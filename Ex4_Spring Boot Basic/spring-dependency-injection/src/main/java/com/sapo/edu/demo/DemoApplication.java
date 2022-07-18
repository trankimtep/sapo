package com.sapo.edu.demo;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sapo.edu.demo.entity.Customer;
import com.sapo.edu.demo.service.Atm;
import com.sapo.edu.demo.service.Printer;

import java.math.BigDecimal;
import java.util.Scanner;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {
    @Autowired
    public Atm bidvAtm ;

    @Autowired    
    //@Qualifier("printer")
    public Printer printer;
    Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        printer.printMessage("Enter your Account Number:");
        String accountNo = sc.nextLine();
        printer.printMessage("Enter your pin:");
        String pin = sc.nextLine();
        Customer customer = new Customer(accountNo, pin, new BigDecimal(5000000));

        //Demo function
        //Atm bidvAtm = new BidvAtm();
        bidvAtm.printCurrentMoney();
        bidvAtm.displayCustomerInfo(customer);
        bidvAtm.withDraw(customer, new BigDecimal(200000));
        bidvAtm.printCurrentMoney();
        bidvAtm.withDraw(customer, new BigDecimal(10000000));
        bidvAtm.printCurrentMoney();
        bidvAtm.deposit(customer,new BigDecimal(1000000));
        bidvAtm.printCurrentMoney();
    }
}
