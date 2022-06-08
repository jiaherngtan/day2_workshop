package vtp2022.day2.workshop;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import vtp2022.day2.workshop.account.BankAccount;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {
        assertTrue(true);
    }

    // Add codes here (Junit method):
    @Test
    public void testBankAccount() {
        BankAccount bkAcc = new BankAccount("Joey's bank account");
        bkAcc.deposit("1000");
        float finalBalance = bkAcc.withdraw("500");
        assertEquals(500, finalBalance, .1);
    }

    // @Test
    // public void testFixedDepositAccount() {

    // System.out.println("My ATM Machine");
    // BankAccount bkAcc = new BankAccount("Joey's bank account");
    // bkAcc.deposit("1000");
    // System.out.println("My new account balance >" + bkAcc.getBalance());
    // bkAcc.withdraw("500");
    // System.out.println("My new account balance >" + bkAcc.getBalance());
    // assertEquals(500, this.balance, .1);
    // }
}
