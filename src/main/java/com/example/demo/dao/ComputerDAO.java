package com.example.demo.dao;

import com.example.demo.bean.Computer;

import java.util.List;

/**
 * User: androidjp
 * Date: 2018/5/12
 * Time: 下午4:45
 * Description:
 */
public interface ComputerDAO {
    public List<Computer> getComputersByCost(double costDownTo, double costUpTo) throws Exception;
}
