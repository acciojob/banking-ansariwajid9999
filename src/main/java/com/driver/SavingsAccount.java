package com.driver;

public class SavingsAccount extends BankAccount{
    double rate;
    double maxWithdrawalLimit;

    public SavingsAccount(String name, double balance, double maxWithdrawalLimit, double rate)
    {
        // minimum balance is 0 by default
        super(name,balance,0);
        this.maxWithdrawalLimit=maxWithdrawalLimit;
        this.rate=rate;

    }
    public void withdraw(double amount) throws Exception
    {
        // Might throw the following errors:
        // 1. "Maximum Withdraw Limit Exceed" : If the amount exceeds maximum withdrawal limit
        // 2. "Insufficient Balance" : If the amount exceeds balance
        try{
            if(amount>maxWithdrawalLimit)throw new Exception("Maximum Withdraw Limit Exceed");
            else if(amount>getBalance())throw new Exception("Insufficient Balance");
            else setBalance(getBalance()-amount);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

    }

    public double getSimpleInterest(int years)
    {
        // Return the final amount considering that bank gives simple interest on current amount
        double si= getBalance()*rate*years/100.0;
        return getBalance()+si;

    }

    public double getCompoundInterest(int times, int years)
    {
        // Return the final amount considering that bank gives compound interest on current amount given times per year
        /*
        the formula for compound interest is given by:
            A = P * (1 + r/n)^(n*t)
         */
        double A=getBalance()*Math.pow((1+rate/(times*1d)),times*years);
        return A;

    }

    public double getRate()
    {
        return rate;
    }

    public void setRate(double rate)
    {
        this.rate = rate;
    }

    public double getMaxWithdrawalLimit()
    {
        return maxWithdrawalLimit;
    }

    public void setMaxWithdrawalLimit(double maxWithdrawalLimit)
    {
        this.maxWithdrawalLimit = maxWithdrawalLimit;
    }
}