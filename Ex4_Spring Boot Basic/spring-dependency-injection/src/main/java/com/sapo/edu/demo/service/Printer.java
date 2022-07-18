package com.sapo.edu.demo.service;

import com.sapo.edu.demo.entity.Customer;

//import org.springframework.stereotype.Component;


public interface Printer {
    void printCustoner(Customer customer);

    void printMessage(String message);
}
