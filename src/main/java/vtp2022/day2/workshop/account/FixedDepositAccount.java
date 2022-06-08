package vtp2022.day2.workshop.account;

public class FixedDepositAccount extends BankAccount {
    private float interest = 3;
    private int duration = 6;
    private int durationCounter = 0;
    private int interestCounter = 0;

    public FixedDepositAccount(String name, float initialAmount) {
        super(name, initialAmount);
        this.durationCounter = 0;
        this.interestCounter = 0;
    }

    // 1st overloaded constructor
    public FixedDepositAccount(String name, float initialAmount, float interest) {
        super(name, initialAmount);
        this.interest = interest;
        this.durationCounter = 0;
        this.interestCounter = 0;
    }

    // 2nd overloaded constructor
    public FixedDepositAccount(String name, float initialAmount, float interest, int duration) {
        super(name, initialAmount);
        this.interest = interest;
        this.duration = duration;
        this.durationCounter = 0;
        this.interestCounter = 0;
    }

    // getter and setter
    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        if (duration < 0) {
            throw new IllegalArgumentException("Unsupported duration");
        }

        if (durationCounter > 0) {
            throw new IllegalArgumentException("Only can set duration once");
        }
        this.duration = duration;
        durationCounter++;
    }

    public void setInterest(int interest) {
        if (interest < 0) {
            throw new IllegalArgumentException("Unsupported interest");
        }

        if (interestCounter > 0) {
            throw new IllegalArgumentException("Only can set interest once");
        }
        this.interest = interest;
        interestCounter++;
    }

    @Override
    public float getBalance() {
        return super.getBalance() + interest;
    }

    @Override
    public float withdraw(String withdrawAmount) {
        // NOP
        return 0;
    }

    @Override
    public void deposit(String depositAmount) {
        // NOP
    }
}

/*
 * Parent A = new Child();
 * A is an instance of Parent
 * A is also an instance of Child, can access to all child's method
 * 
 * Child B = new Child();
 * B cannot be re-assigned to another Parent
 * 
 * Parent C = new Parent();
 * C can be re-assigned to another Parent
 */