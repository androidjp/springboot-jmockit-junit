package com.example.demo.controller;

import com.example.demo.dto.JsonRes;

/**
 * User: androidjp
 * Date: 2018/5/12
 * Time: 下午4:36
 * Description:
 */
public interface DiyPcController {

    public JsonRes buyDiyPc(String userId, double money, String usage) throws Exception;
}
