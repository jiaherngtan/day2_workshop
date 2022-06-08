package vtp2022.day2.workshop;

import vtp2022.day2.workshop.account.BankAccount;
import vtp2022.day2.workshop.account.FixedDepositAccount;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        // test for BankAccount
        System.out.println("My ATM Machine");
        BankAccount bkAcc = new BankAccount("Joey's bank account");
        bkAcc.deposit("1000");
        System.out.println("My new account balance >" + bkAcc.getBalance());
        bkAcc.withdraw("500");
        System.out.println("My new account balance >" + bkAcc.getBalance());

        // test for FixedDepositAccount
        FixedDepositAccount fdAcc = new FixedDepositAccount("Joey", 10000);
        fdAcc.setDuration(12);
        System.out.println(fdAcc.getDuration());
        // fdAcc.setDuration(24);
        // System.out.println(fdAcc.getDuration());

        FixedDepositAccount fdAcc2 = new FixedDepositAccount("Jay", 10000, 4);
        System.out.println("My new account balance >" + fdAcc2.getBalance());
    }
}
