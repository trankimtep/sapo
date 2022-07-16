package com.sapo.edu.demo;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
@Component
@ConfigurationProperties(prefix = "atm")
public class BidvAtm implements Atm {
    private BigDecimal moneyAtm;
    public BigDecimal getMoneyAtm(){
        return moneyAtm;
    }
    public void setMoneyAtm(BigDecimal moneyAtm){
        this.moneyAtm = moneyAtm;
    }
    @Autowired
    public Printer printer;

    @Override
    public void withDraw(Customer customer, BigDecimal amount) {
        if (amount == null || amount.compareTo(new BigDecimal(0)) < 0) {
            printer.printMessage("Amount is invalid");
            return;
        }
        if (customer.getBalance().compareTo(amount) < 0) {
            printer.printMessage("Insufficient Balance");
            return;
        }
        if (amount.compareTo(moneyAtm) >= 0) {
            printer.printMessage("ATM is out of money");
            return;
        }

        BigDecimal currentBalance = customer.getBalance();
        customer.setBalance(currentBalance.subtract(amount));
        moneyAtm = moneyAtm.subtract(amount);
    }

    @Override
    public void printCurrentMoney() {
        System.out.println(moneyAtm.toString());
        //printer.printMessage("Current ATM money is " + moneyAtm.toString());
    }

    @Override
    public void deposit(Customer customer, BigDecimal amount) {
        if (amount == null || amount.compareTo(new BigDecimal(0)) <= 0) {
            printer.printMessage("Amount is invalid");
            return;
        }

        BigDecimal currentBalance = customer.getBalance();
        customer.setBalance(currentBalance.add(amount));
        moneyAtm = moneyAtm.add(amount);
    }

    @Override
    public void displayCustomerInfo(Customer customer) {
        printer.printCustoner(customer);
    }
}
