package com.example.demo.service;

import com.example.demo.bean.Computer;

/**
 * User: androidjp
 * Date: 2018/5/12
 * Time: 下午4:36
 * Description:
 */
public interface DiyService {
    Computer buildCompatibleComputer(double money, String usage) throws Exception;
}
