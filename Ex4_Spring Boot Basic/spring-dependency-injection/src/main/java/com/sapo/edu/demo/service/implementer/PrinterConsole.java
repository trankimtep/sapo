package com.sapo.edu.demo.service.implementer;

//import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.sapo.edu.demo.entity.Customer;
import com.sapo.edu.demo.service.Printer;

@Component
public class PrinterConsole implements Printer {
    @Override
    public void printCustoner(Customer customer) {
        System.out.println("CustomerId: " + customer.getAcctNo() + ", balance: " + customer.getBalance().toString());
    }

    @Override
    public void printMessage(String message) {
        System.out.println(message);
    }
}
