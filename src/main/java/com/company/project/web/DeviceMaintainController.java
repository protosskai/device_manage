package com.company.project.web;

import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.company.project.model.DeviceMaintain;
import com.company.project.service.DeviceMaintainService;
import com.company.project.vo.DeviceMaintainInfoVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Created by CodeGenerator on 2021/03/13.
 */
@RestController
@RequestMapping("/device/maintain")
public class DeviceMaintainController {
    @Resource
    private DeviceMaintainService deviceMaintainService;

    @PostMapping("/add")
    public Result add(DeviceMaintain deviceMaintain) {
        deviceMaintainService.save(deviceMaintain);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Integer id) {
        deviceMaintainService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(DeviceMaintain deviceMaintain) {
        deviceMaintainService.update(deviceMaintain);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        DeviceMaintain deviceMaintain = deviceMaintainService.findById(id);
        return ResultGenerator.genSuccessResult(deviceMaintain);
    }

    @GetMapping("/list")
    public Result getMaintainList(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size, @RequestParam(defaultValue = "0") Integer querySelect) {
        PageHelper.startPage(page, size);
        List<DeviceMaintainInfoVo> res = deviceMaintainService.getMaintainList(querySelect);
        PageInfo pageInfo = new PageInfo(res);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @GetMapping("/startMaintainDevice")
    public Result startMaintainDevice(@RequestParam Integer deviceId, @RequestParam Integer userId) {
        return deviceMaintainService.startMaintainDevice(userId, deviceId, null, null);
    }

    @GetMapping("/startMaintainDevice1")
    public Result startMaintainDevice1(@RequestParam Integer deviceId, @RequestParam Integer userId, @RequestParam String maintainStartDate, @RequestParam String maintainEndDate) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss.SSS'Z'");
        Date startDate = simpleDateFormat.parse(maintainStartDate);
        Date endDate = simpleDateFormat.parse(maintainEndDate);
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(startDate);
        calendar.add(Calendar.HOUR, +8);
        startDate = calendar.getTime();
        calendar = new GregorianCalendar();
        calendar.setTime(endDate);
        calendar.add(Calendar.HOUR, +8);
        endDate = calendar.getTime();
        return deviceMaintainService.startMaintainDevice(userId, deviceId, startDate, endDate);
    }

    @GetMapping("/stopMaintainDevice")
    public Result stopMaintainDevice(@RequestParam Integer deviceId, @RequestParam Integer userId) {
        return deviceMaintainService.stopMaintainDevice(userId, deviceId);
    }
}
