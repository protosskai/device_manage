package com.company.project.interceptor;


import com.company.project.model.*;
import com.company.project.service.*;
import com.company.project.service.impl.*;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;


public class TokenInterceptor implements HandlerInterceptor {

    // 用户id和角色id列表的map
    public HashMap<Integer, List<Integer>> userRoleMap;
    // 角色和权限id列表的map
    public HashMap<Integer, List<PermissionInfo>> rolePermissionMap;
    // token到userId的map
    public HashMap<String, Integer> tokenUserMap;
    // 缓存所有需要权限的路径在内存中，减少sql查询次数
    public List<String> allPermissionPath;


    public UserRoleService userRoleService;

    public SysTokenService sysTokenService;

    public RolePermissionService rolePermissionService;

    public UserService userService;

    public PermissionInfoService permissionInfoService;

    public TokenInterceptor(UserRoleService userRoleService, SysTokenService sysTokenService, RolePermissionService rolePermissionService
            , UserService userService, PermissionInfoService permissionInfoService) {
        userRoleMap = new HashMap<>();
        rolePermissionMap = new HashMap<>();
        tokenUserMap = new HashMap<>();
        this.userRoleService = userRoleService;
        this.sysTokenService = sysTokenService;
        this.rolePermissionService = rolePermissionService;
        this.userService = userService;
        this.permissionInfoService = permissionInfoService;
        initUserRoleMap();
        initRolePermissionMap();
        allPermissionPath = permissionInfoService.findAll().stream().map(PermissionInfo::getPath).collect(Collectors.toList());
    }

    // 初始化用户ID到角色ID的映射
    public void initUserRoleMap() {
        List<UserRole> userRoles = userRoleService.findAll();
        for (UserRole userRole : userRoles) {
            List<Integer> roles = userRoleMap.get(userRole.getUserId());
            if (roles != null) {
                roles.add(userRole.getRoleId());
            } else {
                roles = new LinkedList<>();
                roles.add(userRole.getRoleId());
                userRoleMap.put(userRole.getUserId(), roles);
            }
        }
    }

    // 初始化角色ID到权限ID的映射
    public void initRolePermissionMap() {
        List<RolePermission> rolePermissions = rolePermissionService.findAll();
        for (RolePermission rolePermission : rolePermissions) {
            List<PermissionInfo> permissions = rolePermissionMap.get(rolePermission.getRoleId());
            if (permissions != null) {
                PermissionInfo permissionInfo = permissionInfoService.findById(rolePermission.getPermissionId());
                permissions.add(permissionInfo);
            } else {
                permissions = new LinkedList<>();
                permissions.add(permissionInfoService.findById(rolePermission.getPermissionId()));
                rolePermissionMap.put(rolePermission.getRoleId(), permissions);
            }
        }

    }

    // 通过token获取到用户ID
    public Integer getUserIdByToken(String token) {
        Integer userId = tokenUserMap.get(token);
        if (userId == null) {
            SysToken sysToken = sysTokenService.findByToken(token);
            if (sysToken == null)
                return null;
            User user = userService.findById(sysToken.getUserId());
            tokenUserMap.put(token, user.getId());
            return user.getId();
        }
        return userId;
    }

    // 获取用户所拥有的所有可访问路径
    public List<String> getAllPermissionByUserId(Integer userId) {
        List<String> allPermissions = new LinkedList<>();
        // 获取用户所有角色
        List<Integer> roles = userRoleMap.get(userId);
        // 获取到每个角色拥有的权限
        for (Integer roleId : roles) {
            List<PermissionInfo> permissionInfos = rolePermissionMap.get(roleId);
            // 如果改角色没有任何权限，跳过该角色
            if (permissionInfos == null)
                continue;
            // 将角色所有权限添加到结果中
            for (PermissionInfo permissionInfo : permissionInfos) {
                allPermissions.add(permissionInfo.getPath());
            }
        }
        return allPermissions;
    }


    public Boolean checkUserPermission(String path, String token) {
        // 路径没有权限限制直接返回true
        if (allPermissionPath == null || !allPermissionPath.contains(path))
            return true;
        // 路径需要权限验证但是没有登陆的话，直接false
        if (token == null)
            return false;
        Integer userId = getUserIdByToken(token);
        // 当前token无效，直接返回false
        if (userId == null)
            return false;
        // 获取该用户所有权限
        List<String> allPermissions = getAllPermissionByUserId(userId);
        return allPermissions.contains(path);
    }


    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        String path = httpServletRequest.getServletPath();
        System.out.println("In TokenInterceptor: " + path);
        String token = httpServletRequest.getHeader("X-token");
        if (!checkUserPermission(path, token)) {
            httpServletResponse.sendError(400, "未认证");
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
