package com.example.demo.service;

import com.example.demo.bean.Computer;
import com.example.demo.dao.ComputerDAO;
import mockit.Expectations;
import mockit.Injectable;
import mockit.Tested;
import mockit.Verifications;
import org.junit.Assert;
import org.junit.Test;

import javax.validation.constraints.AssertTrue;
import java.util.ArrayList;

public class DiyServiceImplTest {

  @Tested
  private DiyServiceImpl diyService;

  @Test
  public void testBuildCompatibleComputer(@Injectable ComputerDAO pcDaoImpl) throws Exception {
    new Expectations() {
      {
        pcDaoImpl.getComputersByCost(anyDouble, anyDouble);
        result = new ArrayList<Computer>();
      }
    };

    Computer computer = diyService.buildCompatibleComputer(5000, "game");
    Assert.assertTrue(computer == null);

    new Verifications() {
      {
        pcDaoImpl.getComputersByCost(4500,5500);
        times = 1;
      }
    };
  }
}