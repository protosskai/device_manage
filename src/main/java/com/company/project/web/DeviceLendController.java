package com.company.project.web;

import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.company.project.dao.DeviceLendMapper;
import com.company.project.model.DeviceBasicInfo;
import com.company.project.model.DeviceLend;
import com.company.project.model.User;
import com.company.project.service.DeviceBasicInfoService;
import com.company.project.service.DeviceLendService;
import com.company.project.service.UserService;
import com.company.project.vo.DeviceLendInfoVo;
import com.company.project.vo.DeviceScrapInfoVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by CodeGenerator on 2021/03/13.
 */
@RestController
@RequestMapping("/device/lend")
public class DeviceLendController {
    @Resource
    private DeviceLendService deviceLendService;
    @Resource
    private DeviceBasicInfoService deviceBasicInfoService;
    @Resource
    private DeviceLendMapper deviceLendMapper;


    @PostMapping("/add")
    public Result add(DeviceLend deviceLend) {
        deviceLendService.save(deviceLend);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Integer id) {
        deviceLendService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(DeviceLend deviceLend) {
        deviceLendService.update(deviceLend);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        DeviceLend deviceLend = deviceLendService.findById(id);
        return ResultGenerator.genSuccessResult(deviceLend);
    }


    @GetMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size, @RequestParam(defaultValue = "0") Integer querySelect) {
        PageHelper.startPage(page, size);
        List<DeviceLendInfoVo> list = deviceLendService.getLendInfoVoList(querySelect);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @GetMapping("/lend")
    public Result lend(@RequestParam Integer userId, @RequestParam Integer deviceId, @RequestParam String detail) {
        if (!deviceLendService.checkUserIdAndDeviceId(userId, deviceId))
            return ResultGenerator.genFailResult("用户ID或设备ID不存在！");
        if (!deviceLendService.checkDeviceAvailable(deviceId))
            return ResultGenerator.genFailResult("设备无法借出！");
        DeviceLend deviceLend = new DeviceLend();
        deviceLend.setDeviceId(deviceId);
        deviceLend.setLendUserId(userId);
        deviceLend.setDetail(detail);
        deviceLend.setIsDeleted(0);
        deviceLendService.save(deviceLend);
        deviceLendService.updateDeviceInfoLend(deviceId, 1);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("returnDevice")
    public Result returnDevice(@RequestParam Integer userId, @RequestParam Integer deviceId) {
        DeviceBasicInfo deviceBasicInfo = deviceBasicInfoService.findById(deviceId);
        if (deviceBasicInfo == null)
            return ResultGenerator.genFailResult("设备不存在！");
        if (deviceBasicInfo.getIsLended() == 0)
            return ResultGenerator.genFailResult("设备尚未被借出！");
        deviceBasicInfo.setIsLended(0);
        deviceBasicInfoService.update(deviceBasicInfo);
        List<DeviceLend> deviceLends = deviceLendMapper.selectsByUserIdAndDeviceId(userId, deviceId);
        for (DeviceLend deviceLend : deviceLends) {
            deviceLend.setIsDeleted(1);
            deviceLendService.update(deviceLend);
        }
        return ResultGenerator.genSuccessResult();
    }
}
