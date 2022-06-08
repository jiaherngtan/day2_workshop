package vtp2022.day2.workshop.account;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;
// package to generate uuid
import java.util.UUID;

public class BankAccount {
    // bank account name
    private final String name;
    // this is a generated account id from the java util UUID class
    private final String accID = UUID.randomUUID().toString().substring(0, 8);
    // holds the bank acc balance
    private float balance = 0f;
    // list of transaction history in the event of anything done on the bank account
    // object
    private List<String> transaction = new LinkedList<>();

    private boolean isClosed = false;

    private LocalDateTime accountCreationDate;
    private LocalDateTime accountClosingDate;

    // 1st constructor
    public BankAccount(String name) {
        // with this.name, name will get passed into class instance
        this.name = name;
        this.balance = 0;
    }

    // 2nd constructor
    public BankAccount(String name, float initialBal) {
        this.name = name;
        this.balance = initialBal;
    }

    // Getter and setter for the rest of the properties
    public String getName() {
        return name;
    }

    // public void setName(String name) {
    // this.name = name;
    // }

    public String getAccID() {
        return accID;
    }

    // public void setAccID(String accID) {
    // this.accID = accID;
    // }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public List<String> getTransaction() {
        return transaction;
    }

    public void setTransaction(List<String> transaction) {
        this.transaction = transaction;
    }

    public boolean isClosed() {
        return isClosed;
    }

    public void setClosed(boolean isClosed) {
        this.isClosed = isClosed;
    }

    public LocalDateTime getAccountCreationDate() {
        return accountCreationDate;
    }

    public void setAccountCreationDate(LocalDateTime accountCreationDate) {
        this.accountCreationDate = accountCreationDate;
    }

    public LocalDateTime getAccountClosingDate() {
        return accountClosingDate;
    }

    public void setAccountClosingDate(LocalDateTime accountClosingDate) {
        this.accountClosingDate = accountClosingDate;
    }

    // protected because
    // return float because
    // String because
    public float withdraw(String withdrawAmount) {
        try {
            Float withdrawAmountF = Float.parseFloat(withdrawAmount);
            if (withdrawAmountF.floatValue() <= 0) {
                throw new IllegalArgumentException("Amount cannot be negative or zero");
            }
            if (this.balance < withdrawAmountF.floatValue()) {
                throw new IllegalArgumentException("Insufficient balance to withdraw");
            }
            if (this.isClosed()) {
                throw new IllegalArgumentException("Account is closed");
            }

            // update amount first, notification comes later (store first, record later)
            this.balance -= withdrawAmountF.floatValue();

            // construct the transaction history event log (notification)
            StringBuilder txtStrbld = new StringBuilder();
            txtStrbld.append("withdraw $");
            txtStrbld.append(withdrawAmountF.floatValue());
            txtStrbld.append(" at ");
            txtStrbld.append(LocalDateTime.now());
            System.out.println(txtStrbld.toString());

            // save the event log into the txn linkedlist
            transaction.add(txtStrbld.toString());

        } catch (NumberFormatException e) {
            System.err.print(e);
            throw new IllegalArgumentException("Invalid withdrawal amount");
        }
        return this.balance;
    }

    public void deposit(String depositAmount) {
        try {
            Float depositAmountF = Float.parseFloat(depositAmount);
            if (depositAmountF.floatValue() <= 0) {
                throw new IllegalArgumentException("Amount cannot be negative or zero");
            }
            if (this.isClosed()) {
                throw new IllegalArgumentException("Account is closed");
            }

            this.balance += depositAmountF.floatValue();

            StringBuilder txtStrbld = new StringBuilder();
            txtStrbld.append("deposit $");
            txtStrbld.append(depositAmountF.floatValue());
            txtStrbld.append(" at ");
            txtStrbld.append(LocalDateTime.now());
            System.out.println(txtStrbld.toString());

            // save the event log into the txn linkedlist
            transaction.add(txtStrbld.toString());

        } catch (NumberFormatException e) {
            System.err.print(e);
            throw new IllegalArgumentException("Invalid deposit amount");
        }
    }
}
