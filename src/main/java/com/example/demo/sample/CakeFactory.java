package com.example.demo.sample;

// 蛋糕厂
public class CakeFactory {
  private String cake = null;
  private static String CAKE_NAME = "爱心蛋糕";
  public final int finalF = 1;
  public String makeACake(int size) {
    cake = CAKE_NAME + " : ";
    cake += addFlour();
    cake += addEgg();
    cake += addSugar();
    cake += addMilk();
    if (size > 10)
      cake += addChocolate();
    cake += getOwner();
    cake += " 推荐";
    return cake;
  }

  private String addFlour() {
    return "加面粉的、";
  }

  private String addEgg() {
    return "加蛋的、";
  }

  private String addSugar() {
    return "加糖的、";
  }

  private String addMilk() {
    return "加牛奶的、";
  }

  private String addChocolate() {
    return "加巧克力的、";
  }

  public final String getBrand(){
    return "爱心蛋糕店（全国连锁）";
  }

  private String getOwner() {
    return "店长小李";
  }
}