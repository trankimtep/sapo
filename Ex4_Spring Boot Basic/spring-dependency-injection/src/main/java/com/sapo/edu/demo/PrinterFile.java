
package com.sapo.edu.demo;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class PrinterFile implements Printer{
    Logger logger= LoggerFactory.getLogger("app.log");


    @Override
    public void printMessage(String message) {
        logger.info(message);

    }

    @Override
    public void printCustoner(Customer customer) {
        // TODO Auto-generated method stub
        logger.info("CustomerId: " + customer.getAcctNo() + ", balance: " + customer.getBalance().toString());
    }
}