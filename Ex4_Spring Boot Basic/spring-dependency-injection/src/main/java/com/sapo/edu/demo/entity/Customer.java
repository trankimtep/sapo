package com.sapo.edu.demo.entity;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;

import com.sapo.edu.demo.service.Printer;

public class Customer {
    @Autowired
    Printer printer;
    private String acctNo;
    private String pin;
    private BigDecimal balance;

    public Customer(String accountNo,String pin,BigDecimal balance) {
        this.acctNo = accountNo;
        this.pin = pin;
        this.balance = balance;
    }

    public String getAcctNo() {
        return acctNo;
    }

    public void setAcctNo(String acctNo) {
        this.acctNo = acctNo;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}
