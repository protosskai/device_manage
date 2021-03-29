package com.company.project.web;
import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.company.project.model.LaboratoryInfo;
import com.company.project.service.LaboratoryInfoService;
import com.company.project.vo.DeviceReverseInfoVo;
import com.company.project.vo.LabInfoVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by CodeGenerator on 2021/03/13.
*/
@RestController
@RequestMapping("/lab/info")
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

    @GetMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size, @RequestParam(defaultValue = "0") Integer querySelect) {
        PageHelper.startPage(page, size);
        List<LabInfoVo> list = laboratoryInfoService.getLabInfoVoList(querySelect);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
