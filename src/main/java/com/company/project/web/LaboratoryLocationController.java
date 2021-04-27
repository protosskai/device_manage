package com.company.project.web;

import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.company.project.model.LaboratoryLocation;
import com.company.project.service.LaboratoryLocationService;
import com.company.project.vo.LaboratoryLocationVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by CodeGenerator on 2021/04/08.
 */
@RestController
@RequestMapping("/laboratory/location")
public class LaboratoryLocationController {
    @Resource
    private LaboratoryLocationService laboratoryLocationService;

    @PostMapping("/add")
    public Result add(@RequestBody LaboratoryLocationVo laboratoryLocationVo) {
        return laboratoryLocationService.addLaboratoryLocation(laboratoryLocationVo);
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Integer id) {
        laboratoryLocationService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(LaboratoryLocation laboratoryLocation) {
        laboratoryLocationService.update(laboratoryLocation);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        LaboratoryLocation laboratoryLocation = laboratoryLocationService.findById(id);
        return ResultGenerator.genSuccessResult(laboratoryLocation);
    }

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<LaboratoryLocationVo> list = laboratoryLocationService.findAllVo();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

}
