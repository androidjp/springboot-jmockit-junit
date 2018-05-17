package com.example.demo.service;

import com.example.demo.bean.Invoice;
import com.example.demo.util.DateUtil;
import mockit.Deencapsulation;
import mockit.Expectations;
import mockit.Tested;
import mockit.Verifications;
import org.junit.Assert;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.*;

public class PcFixServiceImplTest {

  @Tested
  PcFixServiceImpl pcFixService;

  /// 将静态方法 mock
  @Test
  public void itShouldBeActiveIfInvoiceDeadlineIsOk() throws ParseException {
    new Expectations(DateUtil.class){
      {
        Date date = new Date();
        date.setTime(date.getTime()+300000);
        DateUtil.addDay((Date) any,400);
        result = date;
      }
    };

    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    Date twoYearsAgo = format.parse("2015-01-01 08:00");
    Invoice invoice = new Invoice("pc001", twoYearsAgo, true);

    Assert.assertEquals(true, pcFixService.checkIfInvoiceActive(invoice));

    new Verifications() {
      {
        DateUtil.addDay((Date) any, 400);
      }
    };

  }
}