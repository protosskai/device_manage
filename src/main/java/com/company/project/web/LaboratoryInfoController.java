package com.company.project.web;
import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.company.project.model.LaboratoryInfo;
import com.company.project.service.LaboratoryInfoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by CodeGenerator on 2021/03/13.
*/
@RestController
@RequestMapping("/laboratory/info")
public class LaboratoryInfoController {
    @Resource
    private LaboratoryInfoService laboratoryInfoService;

    @PostMapping("/add")
    public Result add(LaboratoryInfo laboratoryInfo) {
        laboratoryInfoService.save(laboratoryInfo);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Integer id) {
        laboratoryInfoService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(LaboratoryInfo laboratoryInfo) {
        laboratoryInfoService.update(laboratoryInfo);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        LaboratoryInfo laboratoryInfo = laboratoryInfoService.findById(id);
        return ResultGenerator.genSuccessResult(laboratoryInfo);
    }

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<LaboratoryInfo> list = laboratoryInfoService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
