package com.company.project.web;

import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.company.project.dto.LoginDTO;
import com.company.project.model.User;
import com.company.project.service.SysTokenService;
import com.company.project.service.UserService;
import com.company.project.utils.TokenGenerator;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Resource
    private UserService userService;
    @Resource
    private SysTokenService sysTokenService;

    @PostMapping("/login")
    public Result login(@RequestBody LoginDTO loginDTO) {
        String username = loginDTO.getUsername();
        String password = loginDTO.getPassword();
        User user = userService.findBy("userName", username);
        if (user == null || !user.getPassword().equals(password)) {
            return ResultGenerator.genFailResult("用户名或密码错误");
        }
        Map<String, Object> data = sysTokenService.createToken(user.getId());
        return ResultGenerator.genSuccessResult(data);
    }

    public Result logout(@RequestHeader("X-Token") String token) {
        return ResultGenerator.genSuccessResult();
    }
}
