package com.company.project.web;

import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.company.project.model.DeviceBasicInfo;
import com.company.project.model.DeviceMaintain;
import com.company.project.model.User;
import com.company.project.service.DeviceBasicInfoService;
import com.company.project.service.DeviceMaintainService;
import com.company.project.service.UserService;
import com.company.project.vo.DeviceInfoVo;
import com.company.project.vo.DeviceMaintainInfoVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.base.Preconditions;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by CodeGenerator on 2021/03/13.
 */
@RestController
@RequestMapping("/device/info")
public class DeviceBasicInfoController {
    @Resource
    private DeviceBasicInfoService deviceBasicInfoService;
    @Resource
    private UserService userService;
    @Resource
    private DeviceMaintainService deviceMaintainService;

    @PostMapping("/add")
    public Result add(@RequestBody DeviceInfoVo deviceInfoVo) {
        deviceBasicInfoService.addDevice(deviceInfoVo);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Integer id) {
        deviceBasicInfoService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(DeviceBasicInfo deviceBasicInfo) {
        deviceBasicInfoService.update(deviceBasicInfo);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        DeviceBasicInfo deviceBasicInfo = deviceBasicInfoService.findById(id);
        return ResultGenerator.genSuccessResult(deviceBasicInfo);
    }

    @GetMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<DeviceBasicInfo> list = deviceBasicInfoService.findAll();
        List<DeviceInfoVo> voList = new ArrayList<>();
        for (DeviceBasicInfo info : list) {
            DeviceInfoVo infoVo = new DeviceInfoVo();
            infoVo.setId(info.getId());
            infoVo.setDeviceName(info.getDeviceName());
            infoVo.setIsScraped(info.getIsScraped());
            infoVo.setIsScraped(info.getIsScraped());
            User user = userService.findById(info.getPrincipalUserId());
            if (user != null) {
                infoVo.setPrincipalUser(user.getUserName());
            }
            voList.add(infoVo);
        }
        PageInfo pageInfo = new PageInfo(voList);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @GetMapping("/maintainList")
    public Result getMaintainList(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size, @RequestParam(defaultValue = "0") Integer querySelect) {
        PageHelper.startPage(page, size);
        List<DeviceMaintainInfoVo> res = deviceMaintainService.getMaintainList(querySelect);
        PageInfo pageInfo = new PageInfo(res);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
