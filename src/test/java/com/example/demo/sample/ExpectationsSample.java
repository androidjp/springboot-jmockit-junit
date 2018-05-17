package com.example.demo.sample;

import mockit.Expectations;
import mockit.Mocked;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.util.StringUtils;

public class ExpectationsSample {

  class Person {
    public String say(String sth) {
      return "Person say:" + sth;
    }

    public int getAge() {
      return 18;
    }
  }

  //  @Mocked
  //  Person person;
  //
  //  整个类所有方法全mock
  @Test
  public void test01(@Mocked Person person) throws Exception {
    new Expectations() {
      {
        person.getAge();
        result = 1;
      }
    };

    Assert.assertEquals(1, person.getAge());
    Assert.assertTrue(StringUtils.isEmpty(person.say("Yes")));
  }

  //  只mock 类的某个方法
  @Test
  public void test02() throws Exception {
    Person person1 = new Person();
    Person person2 = new Person();

    new Expectations(Person.class) {
      {
        person1.say("aaa");
        result = "Yeah~";
      }
    };

    Assert.assertEquals("Yeah~", person1.say("aaa"));
    Assert.assertEquals("Yeah~", person2.say("aaa"));

    Assert.assertEquals(18, person1.getAge());
    Assert.assertEquals(18, person2.getAge());
  }

  //  只mock 某个对象的某个方法
  @Test
  public void test03() throws Exception {
    Person person1 = new Person();
    Person person2 = new Person();

    new Expectations(person1) {
      {
        person1.say("aaa");
        result = "Yeah~";
      }
    };

    Assert.assertEquals("Yeah~", person1.say("aaa"));
    Assert.assertEquals("Person say:aaa", person2.say("aaa"));

    Assert.assertEquals(18, person1.getAge());
    Assert.assertEquals(18, person2.getAge());
  }

}
