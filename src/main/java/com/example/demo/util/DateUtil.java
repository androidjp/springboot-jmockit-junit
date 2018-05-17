package com.example.demo.util;

import java.util.Date;

public class DateUtil {
  public static Date addDay(Date originDate, int day) {
    Date date = originDate != null ? originDate : new Date();
    long time = date.getTime();
    time += day * 86400000;
    date.setTime(time);
    return date;
  }
}
