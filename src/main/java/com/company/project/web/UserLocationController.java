package com.company.project.web;

import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.company.project.model.UserLocation;
import com.company.project.service.UserLocationService;
import com.company.project.vo.UserLocationVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by CodeGenerator on 2021/05/24.
 */
@RestController
@RequestMapping("/user/location")
public class UserLocationController {
    @Resource
    private UserLocationService userLocationService;

    @PostMapping("/add")
    public Result add(UserLocation userLocation) {
        userLocationService.save(userLocation);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Integer id) {
        userLocationService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        UserLocation userLocation = userLocationService.findById(id);
        return ResultGenerator.genSuccessResult(userLocation);
    }

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<UserLocation> list = userLocationService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @PostMapping("update")
    public Result updateUserLocation(@RequestBody UserLocationVo userLocationVo) {
        return userLocationService.updateUserLocation(userLocationVo);
    }

    @GetMapping("query")
    public Result queryCurrentUser() {
        return userLocationService.queryCurrentUser();
    }
}
