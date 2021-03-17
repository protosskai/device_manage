package com.company.project.web;
import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.company.project.model.DeviceScrap;
import com.company.project.service.DeviceScrapService;
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
@RequestMapping("/device/scrap")
public class DeviceScrapController {
    @Resource
    private DeviceScrapService deviceScrapService;

    @PostMapping("/add")
    public Result add(DeviceScrap deviceScrap) {
        deviceScrapService.save(deviceScrap);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Integer id) {
        deviceScrapService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(DeviceScrap deviceScrap) {
        deviceScrapService.update(deviceScrap);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        DeviceScrap deviceScrap = deviceScrapService.findById(id);
        return ResultGenerator.genSuccessResult(deviceScrap);
    }

    @GetMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size, @RequestParam(defaultValue = "0") Integer querySelect) {
        PageHelper.startPage(page, size);
        List<DeviceScrapInfoVo> list = deviceScrapService.getScrapInfoVoList(querySelect);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
