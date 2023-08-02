package com.driver;

import java.net.SocketTimeoutException;
import java.sql.SQLOutput;

public class BankAccount {

    private String name;
    private double balance;
    private double minBalance;

    public BankAccount(String name, double balance, double minBalance)
    {
        this.name=name;
        this.balance=balance;
        this.minBalance=minBalance;
    }

    public String generateAccountNumber(int digits, int sum) throws Exception{
        //Each digit of an account number can lie between 0 and 9 (both inclusive)
        //Generate account number having given number of 'digits' such that the sum of digits is equal to 'sum'
        //If it is not possible, throw "Account Number can not be generated" exception
        StringBuilder sb=new StringBuilder();

        if (sum > digits * 9)
        {
            //means it is not possible...
            throw new Exception("Account Number can not be generated");

        }
        else
        {
            //means it can be generated...
            int[]ans=new int[digits];
            sum=sum-1;
            //let' have 1 for last..
            int i=digits-1;
            while(i>0 && sum>0)
            {
                if(sum>9)
                {
                    ans[i]=9;
                    sum-=9;
                }
                else
                {
                    ans[i]=sum;
                    sum=0;
                    break;
                }
                i--;
            }
            ans[0]=sum+1;
            for(int nu:ans)
            {
                sb.append(nu);
            }

        }


        return sb.toString();
    }

    public void deposit(double amount)
    {
        //add amount to balance
        balance+=amount;

    }

    public void withdraw(double amount) throws Exception
    {
        // Remember to throw "Insufficient Balance" exception, if the remaining amount would be less than minimum balance

        if (balance < amount) throw new Exception("Insufficient Balance");
        else setBalance(getBalance()-amount);


    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getMinBalance() {
        return minBalance;
    }

    public void setMinBalance(double minBalance) {
        this.minBalance = minBalance;
    }
}