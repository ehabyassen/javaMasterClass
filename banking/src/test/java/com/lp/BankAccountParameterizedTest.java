package com.lp;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BankAccountParameterizedTest {

    private BankAccount account;
    private final double amount;
    private final boolean branch;
    private final double expected;

    public BankAccountParameterizedTest(double amount, boolean branch, double expected) {
        this.amount = amount;
        this.branch = branch;
        this.expected = expected;
    }

    @Before
    public void setUp() {
        account = new BankAccount("X123", 1000.00, BankAccount.CHECKING);
    }

    @Parameters(name = "amount: {0} - branch: {1} - expected: {2}")
    public static Collection<Object> testData() {
        return Arrays.asList(new Object[][] {
                {100.00, true, 1100.00},
                {200.00, true, 1200.00},
                {325.14, true, 1325.14},
                {489.33, true, 1489.33},
                {1000.00, true, 2000.00},
        });
    }

    @Test
    public void test_deposit() {
        account.deposit(amount, branch);
        assertEquals(account.getBalance(), expected, .01);
    }
}
