package com.example.demo.aop;

public class PrivilegeInterrupter implements IPrivilege {
  @Override
  public boolean isVip(String userId) {
    return "A".equals(userId);
  }
}
