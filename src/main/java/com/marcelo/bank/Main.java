package com.marcelo.bank;

import java.math.BigDecimal;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Owner name: ");
        Account acc = new Account(sc.nextLine().trim());

        while (true) {
            System.out.println("\n[1] Deposit [2] Withdraw [3] Balance [0] Exit");
            String op = sc.nextLine().trim();
            try {
                switch (op) {
                    case "1" -> {
                        System.out.print("Amount: ");
                        acc.deposit(new BigDecimal(sc.nextLine().trim()));
                        System.out.println("OK. Balance: " + acc.getBalance());
                    }
                    case "2" -> {
                        System.out.print("Amount: ");
                        acc.withdraw(new BigDecimal(sc.nextLine().trim()));
                        System.out.println("OK. Balance: " + acc.getBalance());
                    }
                    case "3" -> System.out.println("Balance: " + acc.getBalance());
                    case "0" -> { System.out.println("Bye!"); return; }
                    default -> System.out.println("Invalid option");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
