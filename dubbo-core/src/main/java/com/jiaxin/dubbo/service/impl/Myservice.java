package com.jiaxin.dubbo.service.impl;

import com.welab.thor.operation.service.IAuthConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class Myservice {

    @Autowired
    private IAuthConfigService authConfigService;

    @Value("${hello.abc}")
    private String profileValue;


    @Value("${propertiesfile.value}")
    private String testPropertiesfileValue;

    public String getProfileValue2(){
        return testPropertiesfileValue;
    }

    public String findAuthListMetaData() {
        return authConfigService.findAuthListMetaData() ;
    }


    public String getProfileValue(){
        return profileValue;
    }



}
