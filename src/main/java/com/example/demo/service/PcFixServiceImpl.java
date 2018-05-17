package com.example.demo.service;

import com.example.demo.bean.Invoice;
import com.example.demo.util.DateUtil;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class PcFixServiceImpl implements PcFixService {

  @Override
  public boolean checkIfInvoiceActive(Invoice invoice) {
    if (invoice == null)
      return false;
    Date deadline = DateUtil.addDay(invoice.getBuyDate(),400);
    if (deadline.compareTo(new Date())<0) {
      return false;
    }
    boolean result = invoice.isUseful();
    invoice.setUseful(false);
    return result;
  }
}
