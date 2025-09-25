package com.marcelo.bank;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public class Account {
    private final String owner;
    private BigDecimal balance;

    public Account(String owner) {
        this.owner = Objects.requireNonNull(owner);
        this.balance = BigDecimal.ZERO.setScale(2, RoundingMode.HALF_UP);
    }

    public String getOwner() { return owner; }
    public BigDecimal getBalance() { return balance; }

    public void deposit(BigDecimal amt) {
        BigDecimal amount = normalize(amt);
        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Amount must be > 0");
        }
        balance = balance.add(amount);
    }

    public void withdraw(BigDecimal amt) {
        BigDecimal amount = normalize(amt);
        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Amount must be > 0");
        }
        if (balance.compareTo(amount) < 0) {
            throw new IllegalArgumentException("Insufficient funds");
        }
        balance = balance.subtract(amount);
    }

    private static BigDecimal normalize(BigDecimal value) {
        if (value == null) throw new IllegalArgumentException("Amount cannot be null");
        return value.setScale(2, RoundingMode.HALF_UP);
    }
}
