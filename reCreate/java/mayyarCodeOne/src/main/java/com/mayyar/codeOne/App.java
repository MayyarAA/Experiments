package com.mayyar.codeOne;

import com.mayyar.codeOne.Utills.Logger;
import com.mayyar.codeOne.codeRecreation.recreateBuilder.BankCustomer;
import com.mayyar.codeOne.codeRecreation.recreateBuilder.BankCustomer.BankCustomerBuilder;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        Logger.start(App.class.getName());
        BankCustomer bankCustomerOne = BankCustomer.builder().balance(1.1).customerId("121212-23422-1")
                .username("tom11").build();
        Logger.log(bankCustomerOne.toString());
        Logger.end(App.class.getName());
    }
}
