package com.lp;

import org.assertj.core.api.Assertions;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BankAccountTest {

    private BankAccount account;

    @Before
    public void setUp() {
        account = new BankAccount("X123", 1000.00, BankAccount.CHECKING);
        System.out.println("Running a test...");
    }

    @BeforeClass
    public static void beforeClass() {
        System.out.println("This executes before class...");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("This executes after class...");
    }

    @Test
    public void testDeposit() {
        double balance = account.deposit(200.00, true);
        assertEquals(1200.00, balance, 0);
    }

    @Test
    public void testWithdraw() {
        double balance = account.withdraw(200.00, true);
        assertEquals(800.00, balance, 0);
    }

    @Test
    public void testGetBalance_deposit() {
        account.deposit(200.00, true);
        assertEquals(1200.00, account.getBalance(), 0);
    }

    @Test
    public void testGetBalance_withdraw() {
        account.withdraw(200.00, true);
        assertEquals(800.00, account.getBalance(), 0);
    }

    @Test
    public void test_that_account_is_checking() {
        assertTrue("The account is not a checking account", account.isChecking());
    }

    @Test
    public void test_that_withdrawal_of_amount_larger_than_500_is_allowed_in_a_branch() {
        Assertions.assertThatCode(() -> account.withdraw(501.00, true))
                .doesNotThrowAnyException();
    }

    @Test
    public void test_that_withdrawal_of_amount_larger_than_500_is_not_allowed_out_of_a_branch() {
        Assertions.assertThatCode(() -> account.withdraw(501.00, false))
                .isInstanceOf(IllegalStateException.class)
                .hasMessage("Withdrawal of amount larger than 500 is not allowed out of a branch");

    }

    @Test
    public void test_that_withdrawal_of_amount_less_than_500_is_allowed_out_of_a_branch() {
        Assertions.assertThatCode(() -> account.withdraw(499.00, false))
                .doesNotThrowAnyException();
    }

    @Test
    public void test_that_withdrawal_of_amount_less_than_500_is_allowed_in_a_branch() {
        Assertions.assertThatCode(() -> account.withdraw(499.00, true))
                .doesNotThrowAnyException();
    }
}
