package com.marcelo.bank;

import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.*;

class AccountTest {

    @Test
    void depositAndWithdraw() {
        Account a = new Account("Marcelo");
        a.deposit(new BigDecimal("100.00"));
        a.withdraw(new BigDecimal("40.50"));
        assertEquals(0, a.getBalance().compareTo(new BigDecimal("59.50")));
    }

    @Test
    void depositMustBePositive() {
        Account a = new Account("Marcelo");
        assertThrows(IllegalArgumentException.class,
                () -> a.deposit(new BigDecimal("-1.00")));
    }

    @Test
    void cannotWithdrawMoreThanBalance() {
        Account a = new Account("Marcelo");
        a.deposit(new BigDecimal("10.00"));
        assertThrows(IllegalArgumentException.class,
                () -> a.withdraw(new BigDecimal("20.00")));
    }
}
