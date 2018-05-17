package com.example.demo.sample;

import mockit.Mock;
import mockit.MockUp;
import org.junit.Assert;
import org.junit.Test;

import java.util.Calendar;
import java.util.Locale;

/**
 * MockUp 与 @Mock
 *
 * 优点：直接，想mock哪个方法就mock哪个方法
 * 特点：针对类的所有实例
 * 缺点：一下场景是没法用它的：
 *   1. 一个类有多个实例，我们只需要对某个实例进行mock。
 *   2. AOP 动态生成类的Mock
 *   3. 对类所有方法进行Mock，此时，MockUp书写工作量太大。
 */
public class MockUpTest {

  @Test
  public void testMockUp() {
    new MockUp<Calendar>(Calendar.class) {
      // 想mock 哪个方法，就再他上面加@Mock，没有这个注解的方法，不受影响
      @Mock
      public int get(int unit) {
        if (unit == Calendar.YEAR) {
          return 2017;
        }
        if (unit == Calendar.MONDAY) {
          return 12;
        }
        if (unit == Calendar.DAY_OF_MONTH) {
          return 25;
        }
        if (unit == Calendar.HOUR_OF_DAY) {
          return 7;
        }
        return 0;
      }
    };

    // 从此Calendar的get方法，就沿用你定制过的逻辑，而不是它原先的逻辑。
    Calendar cal = Calendar.getInstance(Locale.FRANCE);
    Assert.assertTrue(cal.get(Calendar.YEAR) == 2017);
    Assert.assertTrue(cal.get(Calendar.MONDAY) == 12);
    Assert.assertTrue(cal.get(Calendar.DAY_OF_MONTH) == 25);
    Assert.assertTrue(cal.get(Calendar.HOUR_OF_DAY) == 7);
    // Calendar的其它方法，不受影响
    Assert.assertTrue((cal.getFirstDayOfWeek() == Calendar.MONDAY));
  }
}
