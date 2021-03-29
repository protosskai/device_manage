package com.company.project.service;
import com.company.project.model.DeviceReserve;
import com.company.project.core.Service;
import com.company.project.vo.DeviceReverseInfoVo;

import java.util.List;


/**
 * Created by CodeGenerator on 2021/03/13.
 */
public interface DeviceReserveService extends Service<DeviceReserve> {

    List<DeviceReverseInfoVo> getReverseInfoVoList(Integer querySelected);
}
