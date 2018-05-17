package com.example.demo.sample;

import mockit.Expectations;
import mockit.Mocked;
import mockit.Verifications;
import mockit.integration.junit4.JMockit;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * User: androidjp
 * Date: 2018/5/14
 * Time: 下午10:54
 * Description:
 */
// 首先，如果没有确保 maven 依赖的编写顺序是：先：JMockit，后：JUnit4，那么，必须加上下面的注解。
//@RunWith(JMockit.class)
public class JMockitFlowSample {
//    step1: mock 一个对象
    @Mocked
    HelloJMockit helloJMockit;

    @Test
    public void test1() {
//        step2: 录制（Record）
//        还可以再写new一个Expectations，只要出现在重放阶段之前均有效
        new Expectations() {
            {
                helloJMockit.sayHello();
                result = "Hello A.";
            }
        };

//        step3: 重放（Replay）
        String msg = helloJMockit.sayHello();
        Assert.assertTrue("Hello A.".equals(msg));

//        step4: 验证（Verification）
        new Verifications(){
            {
                helloJMockit.sayHello();
                times = 1;
            }
        };
    }
}
