package com.example.demo.service;

import com.example.demo.bean.Invoice;

// 维修 service
public interface PcFixService {
  public boolean checkIfInvoiceActive(Invoice invoice);
}
