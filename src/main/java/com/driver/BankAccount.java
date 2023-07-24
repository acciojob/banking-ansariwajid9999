package com.driver;

public class BankAccount {

    private String name;
    private double balance;
    private double minBalance;

    public BankAccount(String name, double balance, double minBalance) {
        this.name=name;
        this.balance=balance;
        this.minBalance=minBalance;
    }

    public String generateAccountNumber(int digits, int sum) throws Exception{
        //Each digit of an account number can lie between 0 and 9 (both inclusive)
        //Generate account number having given number of 'digits' such that the sum of digits is equal to 'sum'
        //If it is not possible, throw "Account Number can not be generated" exception
        StringBuilder sb=new StringBuilder();
        try{
            if (digits <= 0 || digits > 9 || sum < 0 || sum > digits * 9) {
                throw new Exception("Account Number can not be generated");
            }else{
                //Account Number can be generated
                int[] res=new int[digits];
                for(int i=digits-1;i>0 && sum>0;i--){
                    if(sum>9){
                        res[i]=9;
                        sum-=9;
                    }else{
                        res[i]=sum;
                        sum=0;
                        break;
                    }
                }
                res[0]=sum+1;
                for(int element:res){
                    sb.append(element);
                }
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        return sb.toString();
    }

    public void deposit(double amount) {
        //add amount to balance
        balance=balance+amount;
        System.out.println("Amount has been deposited");
    }

    public void withdraw(double amount) throws Exception {
        // Remember to throw "Insufficient Balance" exception, if the remaining amount would be less than minimum balance
        try{
            if (balance < amount) throw new Exception("Insufficient Balance");
            else{
                setBalance(getBalance()-amount);
                System.out.println("Amount has been withdrawn");
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    public class withdrawAmount extends Exception {
        public withdrawAmount(String message){
            super(message);
        }
    }
    public String getName(){
        return this.name;
    }
    public void setName(String name){
         this.name=name;
    }
    public double getBalance(){
        return this.balance;
    }
    public void setBalance(double balance){
        this.balance=balance;
    }
    public double getMinBalance(){
        return this.minBalance;
    }
    public void setMinBalance(double minBalance){
        this.minBalance=minBalance;
    }

}