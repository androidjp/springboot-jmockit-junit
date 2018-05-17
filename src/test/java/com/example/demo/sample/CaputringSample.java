package com.example.demo.sample;

import com.example.demo.aop.IPrivilege;
import mockit.Capturing;
import mockit.Expectations;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

// @Capturing 用于 对子类/实现类 进行 Mock.
// 当我们只知道父类、接口， 但是我们需要控制其所有子类的行为时，就可以用 @Capturing
public class CaputringSample {
  String testUserId = "B";
  IPrivilege privilege1 = new IPrivilege() {
    @Override
    public boolean isVip(String userId) {
      return "A".equals(userId);
    }
  };

  IPrivilege privilege2 = (IPrivilege) Proxy
      .newProxyInstance(IPrivilege.class.getClassLoader(), new Class[] { IPrivilege.class }, new InvocationHandler() {
        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
          return "A".equals(args[0]);
        }
      });

  @Test
  public void testCapturing(@Capturing IPrivilege privilegeManager) {
    //    注意：这种 通过JDK 动态代理生成的（一般AOP用）的情况，是需要在@Capturing 之后使用的
//    privilege2 = (IPrivilege) Proxy
//        .newProxyInstance(IPrivilege.class.getClassLoader(), new Class[] { IPrivilege.class }, new InvocationHandler() {
//          @Override
//          public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//            return "A".equals(args[0]);
//          }
//        });

    /// 这样一来，所有IPrivilege的子类/实现类 都会被Mock
    new Expectations() {
      {
        /// 无论IPrivilege 的实现类是谁，都遵循以下 规则
        privilegeManager.isVip(anyString);
        result = true;
      }
    };

    Assert.assertTrue(privilege1.isVip(testUserId));
    /// 注意， 这种的动态代理方式，如果不在方法内部初始化，mock 是无效的
    Assert.assertTrue(privilege2.isVip(testUserId));
  }

    @Test
    public void testWithoutCapturing() {
      Assert.assertFalse(privilege1.isVip(testUserId));
      Assert.assertFalse(privilege2.isVip(testUserId));
    }
}
