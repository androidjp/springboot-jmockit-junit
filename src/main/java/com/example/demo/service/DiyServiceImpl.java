package com.example.demo.service;

import com.example.demo.bean.Computer;
import com.example.demo.dao.ComputerDAO;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * User: androidjp
 * Date: 2018/5/12
 * Time: 下午4:44
 * Description:
 */
@Service
public class DiyServiceImpl implements DiyService {

    @Resource(name = "PcDaoImpl")
    private ComputerDAO computerDAO;

    @Override
    public Computer buildCompatibleComputer(double money, String usage) throws Exception {
        List<Computer> computerList = computerDAO.getComputersByCost(money-500,money+500);
        if (CollectionUtils.isEmpty(computerList)) {
            return null;
        }
        return computerList.get(0);
    }
}
