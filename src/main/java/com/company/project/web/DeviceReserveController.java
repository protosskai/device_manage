package com.company.project.web;

import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.company.project.model.DeviceReserve;
import com.company.project.service.DeviceReserveService;
import com.company.project.vo.DeviceLendInfoVo;
import com.company.project.vo.DeviceReverseInfoVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by CodeGenerator on 2021/03/13.
 */
@RestController
@RequestMapping("/device/reserve")
public class DeviceReserveController {
    @Resource
    private DeviceReserveService deviceReserveService;

    @PostMapping("/add")
    public Result add(DeviceReserve deviceReserve) {
        deviceReserveService.save(deviceReserve);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Integer id) {
        deviceReserveService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(DeviceReserve deviceReserve) {
        deviceReserveService.update(deviceReserve);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        DeviceReserve deviceReserve = deviceReserveService.findById(id);
        return ResultGenerator.genSuccessResult(deviceReserve);
    }

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<DeviceReserve> list = deviceReserveService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @GetMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size, @RequestParam(defaultValue = "0") Integer querySelect) {
        PageHelper.startPage(page, size);
        List<DeviceReverseInfoVo> list = deviceReserveService.getReverseInfoVoList(querySelect);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @GetMapping("/startReverse")
    public Result startReverse(@RequestParam Integer userId, @RequestParam Integer deviceId) {
        return deviceReserveService.startReverseDevice(userId, deviceId);
    }


}
