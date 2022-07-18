package com.sapo.edu.demo.service;

import java.math.BigDecimal;

import com.sapo.edu.demo.entity.Customer;

public interface Atm {
    void withDraw(Customer customer, BigDecimal amount);

    void printCurrentMoney();

    void deposit(Customer customer, BigDecimal amount);

    void displayCustomerInfo(Customer customer);
}
