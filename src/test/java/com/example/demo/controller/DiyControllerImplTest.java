package com.example.demo.controller;

import com.example.demo.bean.Computer;
import com.example.demo.dto.JsonRes;
import com.example.demo.service.DiyService;
import com.example.demo.service.DiyServiceImpl;
import mockit.Expectations;
import mockit.Injectable;
import mockit.Mocked;
import mockit.Tested;
import org.junit.Assert;
import org.junit.Test;

/**
 * @Injectable 也表示一个Mocked对象，相比@Mocked，只不过只影响类的一个实例。而@Mocked默认是影响类的所有实例。
 * @Tested 表示被测试对象。如果该对象没有赋值，JMockit会去实例化它，若@Tested的构造函数有参数，
 则JMockit通过在测试属性&测试参数中查找@Injectable修饰的Mocked对象注入@Tested对象的构造函数来实例化，
 不然，则用无参构造函数来实例化。除了构造函数的注入，JMockit还会通过属性查找的方式，把@Injectable对象注入到@Tested对象中。
 注入的匹配规则：先类型，再名称(构造函数参数名，类的属性名)。若找到多个可以注入的@Injectable，则选择最优先定义的@Injectable对象。
 当然，我们的测试程序要尽量避免这种情况出现。因为给哪个测试属性/测试参数加@Injectable，是人为控制的。
 */
public class DiyControllerImplTest {

    @Tested
    DiyControllerImpl diyController;

    @Test
    public void testBuyDiyPc(@Injectable DiyService diyServiceImpl) throws Exception {
        new Expectations() {
            {
                diyServiceImpl.buildCompatibleComputer(anyDouble,anyString);
                result = new Computer("i5 7777",null,16,8000);
            }
        };
        JsonRes res = diyController.buyDiyPc("A",5000,"game");
        Assert.assertEquals("success", res.getMessage());
        Assert.assertEquals("i5 7777", ((Computer)(res.getData())).getCpu());

    }
}