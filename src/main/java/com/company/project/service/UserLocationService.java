package com.company.project.service;

import com.company.project.core.Result;
import com.company.project.model.UserLocation;
import com.company.project.core.Service;
import com.company.project.vo.UserLocationVo;


/**
 * Created by CodeGenerator on 2021/05/24.
 */
public interface UserLocationService extends Service<UserLocation> {

    Result updateUserLocation(UserLocationVo userLocationVo);

    Result queryCurrentUser();

}
