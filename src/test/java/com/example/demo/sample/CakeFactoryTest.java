package com.example.demo.sample;

import mockit.Deencapsulation;
import mockit.Expectations;
import mockit.Tested;
import org.junit.Test;

public class CakeFactoryTest {

  @Tested
  CakeFactory cakeFactory;

  @Test
  public void testMockPrivateMethodAndField() throws Exception {

    new Expectations(cakeFactory) {
      /// mock 这个实例 的 private CAKE_NAME 属性
      // private static  同样可以mock
      // 但是，final 的 mock 不了
      {
        Deencapsulation.setField(cakeFactory, "CAKE_NAME", "被Mock的蛋糕仔");
      }

      /// mock 这个实例 的 private method
      {
        Deencapsulation.invoke(cakeFactory, "addEgg");
        result = "加egg的、";
      }
    };
    System.out.println(cakeFactory.makeACake(15));
  }

  // Mock public final 的 方法
  @Test
  public void testMockFinalMethod() throws Exception {
    new Expectations(cakeFactory) {
      {
        cakeFactory.getBrand();
        result = "老干妈蛋糕店";
      }
    };
    System.out.println(cakeFactory.getBrand());
  }

}