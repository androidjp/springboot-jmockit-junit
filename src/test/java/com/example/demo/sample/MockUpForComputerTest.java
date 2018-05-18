package com.example.demo.sample;

import com.example.demo.bean.Computer;
import mockit.Mock;
import mockit.MockUp;
import mockit.Tested;
import mockit.Verifications;
import org.junit.BeforeClass;
import org.junit.Test;

public class MockUpForComputerTest {

  @Tested
  private Computer pc2;

  static class ComputerMockUp extends MockUp<Computer>{
    @Mock
    public String getCpu(){return "锐龙9";}
  }

  @BeforeClass
  public static void setUp() {
    new ComputerMockUp();
  }

  @Test
  public void test01() {
    Computer pc1 = new Computer("i5 8400","华硕 1060 6g",16, 6500);
    System.out.println(pc1.toString());
    System.out.println(pc1.getCpu());
  }

  @Test
  public void test02() {
    System.out.println(pc2.toString());
    System.out.println(pc2.getCpu());
  }

}
