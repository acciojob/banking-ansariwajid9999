package com.driver;

import java.util.PriorityQueue;

public class CurrentAccount extends BankAccount{
    String tradeLicenseId; //consists of Uppercase English characters only

    public CurrentAccount(String name, double balance, String tradeLicenseId) throws Exception
    {
        // minimum balance is 5000 by default. If balance is less than 5000, throw "Insufficient Balance" exception

        super(name, balance, 5000);
        this.tradeLicenseId=tradeLicenseId;
        if (balance < 5000) throw new Exception("Insufficient Balance");




    }

    public void validateLicenseId() throws Exception
    {
        // A trade license Id is said to be valid if no two consecutive characters are same
        // If the license Id is valid, do nothing
        // If the characters of the license Id can be rearranged to create any valid license Id
        // If it is not possible, throw "Valid License can not be generated" Exception


        String s = tradeLicenseId;
        if (isValid(s))
        {
            //do nothing..
        } else if (isPossible(s))
        {
            //do nothing.. we did in ispossible function
        } else throw new Exception("Valid License can not be generated");


    }

    public boolean isValid(String s)
    {
        int n=s.length();
        for(int i=1;i<n;i++){
            if(s.charAt(i)==s.charAt(i-1))return false;
        }
        return true;
    }

    class Pair{
        char ch;
        int fre;
        public Pair(char ch,int  fre){
            this.ch=ch;
            this.fre=fre;
        }

    }
    public  boolean isPossible(String s)
    {
        int n=s.length();
        int[]fre=new int[26];
        for(int i=0;i<n;i++)fre[s.charAt(i)-'A']++;
        int limit=(n+1/2);
        PriorityQueue<Pair>pq=new PriorityQueue<>((a,b)->{
            return b.fre-a.fre;
        });
        for(int i=0;i<26;i++){
            if(fre[i]>limit)return false;
            else pq.add(new Pair((char)(i+'A'),fre[i]));
        }

        char[]ans=new char[n];
        int index=0;
        while(pq.size()>0 && index<n)
        {
            Pair p=pq.remove();
            char ch=p.ch;
            int freq=p.fre;
            while(freq-->0 && index<n)
            {
                ans[index]=ch;
                index+=2;
            }
        }
        index=1;
        while(pq.size()>0 && index<n)
        {
            Pair p=pq.remove();
            char ch=p.ch;
            int freq=p.fre;
            while(freq-->0 && index<n)
            {
                ans[index]=ch;
                index+=2;
            }
        }


        tradeLicenseId=String.valueOf(ans);
        return true;

    }
    public String getTradeLicenseId()
    {
        return tradeLicenseId;
    }

    public void setTradeLicenseId(String tradeLicenseId) {
        this.tradeLicenseId = tradeLicenseId;
    }
}