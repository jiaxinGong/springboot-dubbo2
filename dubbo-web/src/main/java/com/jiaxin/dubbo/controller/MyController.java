package com.jiaxin.dubbo.controller;

import com.alibaba.fastjson.JSONArray;
import com.jiaxin.dubbo.base.ResponseVo;
import com.jiaxin.dubbo.service.impl.Myservice;
import com.welab.thor.operation.service.IAuthConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @Autowired
    private Myservice myservice;

    @RequestMapping(value = "/findAuthListMetaData", method = RequestMethod.GET)
    public ResponseVo findAuthListMetaData() {
        String authConfigStr = myservice.findAuthListMetaData();
        JSONArray jsonArray = JSONArray.parseArray(authConfigStr);
        return new ResponseVo(jsonArray);
    }


    @RequestMapping(value = "/getProfileValue", method = RequestMethod.GET)
    public ResponseVo getProfileValue() {
        String authConfigStr = myservice.getProfileValue();
        return new ResponseVo(authConfigStr);
    }

    @RequestMapping(value = "/getProfileValue2", method = RequestMethod.GET)
    public ResponseVo getProfileValue2() {
        String authConfigStr = myservice.getProfileValue2();
        return new ResponseVo(authConfigStr);
    }

}
