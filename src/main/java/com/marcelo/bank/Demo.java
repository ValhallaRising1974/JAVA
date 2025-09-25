package com.marcelo.bank;

import java.math.BigDecimal;

public class Demo {
    public static void main(String[] args) {
        Account a = new Account("Marcelo");
        a.deposit(new BigDecimal("150.00"));
        a.withdraw(new BigDecimal("23.40"));
        System.out.println("Demo final balance: " + a.getBalance()); // 126.60
    }
}
