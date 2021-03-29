package com.company.project.web;
import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.company.project.model.PermissionInfo;
import com.company.project.service.PermissionInfoService;
import com.company.project.vo.PermissionInfoVo;
import com.company.project.vo.RoleInfoVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by CodeGenerator on 2021/03/13.
*/
@RestController
@RequestMapping("/permission")
public class PermissionInfoController {
    @Resource
    private PermissionInfoService permissionInfoService;

    @PostMapping("/add")
    public Result add(PermissionInfo permissionInfo) {
        permissionInfoService.save(permissionInfo);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Integer id) {
        permissionInfoService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(PermissionInfo permissionInfo) {
        permissionInfoService.update(permissionInfo);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        PermissionInfo permissionInfo = permissionInfoService.findById(id);
        return ResultGenerator.genSuccessResult(permissionInfo);
    }

    @GetMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size, @RequestParam(defaultValue = "0") Integer querySelect) {
        PageHelper.startPage(page, size);
        List<PermissionInfoVo> list = permissionInfoService.getPermissionInfoVoList(querySelect);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
