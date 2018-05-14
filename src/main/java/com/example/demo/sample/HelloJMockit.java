package com.example.demo.sample;

import java.util.Locale;

/**
 * User: androidjp
 * Date: 2018/5/14
 * Time: 下午10:46
 * Description:
 */
public class HelloJMockit {
    // 向JMockit打招呼
    public String sayHello() {
        Locale locale = Locale.getDefault();
        if (locale.equals(Locale.CHINA)) {
            // 在中国，就说中文
            return "你好，JMockit!";
        } else {
            // 在其它国家，就说英文
            return "Hello，JMockit!";
        }
    }
}
