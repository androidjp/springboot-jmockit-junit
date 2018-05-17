package com.example.demo.dao;

import com.example.demo.bean.Computer;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * User: androidjp
 * Date: 2018/5/12
 * Time: 下午5:02
 * Description:
 */
@Repository("pcDaoImpl")
public class ComputerDAOImpl implements ComputerDAO {

    private List<Computer> computers = new ArrayList<>();

    {
        computers.add(new Computer("Intel i5 8400", "华硕 1060", 8, 5000));
        computers.add(new Computer("Intel i5 8400", "华硕 1050Ti", 8, 4500));
        computers.add(new Computer("Intel i7 8600k", "华硕 1080Ti", 16, 7000));
    }


    @Override
    public List<Computer> getComputersByCost(double costDownTo, double costUpTo) throws Exception {
        /// Mock the logic to search on DB.
        return searchDB(costDownTo, costUpTo);
    }

    private List<Computer> searchDB(double costDownTo, double costUpTo) throws CloneNotSupportedException {
        List<Computer> resList = new ArrayList<>();
        for (Computer item : computers) {
            if (item.getPrice() >= costDownTo && item.getPrice() <= costUpTo) {
                resList.add(item.clone());
            }
        }
        return resList;
    }
}
