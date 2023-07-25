package com.driver;

public class CurrentAccount extends BankAccount{
    String tradeLicenseId; //consists of Uppercase English characters only

    public CurrentAccount(String name, double balance, String tradeLicenseId) throws Exception
    {
        // minimum balance is 5000 by default. If balance is less than 5000, throw "Insufficient Balance" exception

        super(name, balance, 5000);
        this.tradeLicenseId = tradeLicenseId;
        try
        {
            if (balance < 5000) throw new Exception("Insufficient Balance");
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }



    }

    public void validateLicenseId() throws Exception
    {
        // A trade license Id is said to be valid if no two consecutive characters are same
        // If the license Id is valid, do nothing
        // If the characters of the license Id can be rearranged to create any valid license Id
        // If it is not possible, throw "Valid License can not be generated" Exception

        try{
            String s = tradeLicenseId;
            if (isValid(s))
            {
                //do nothing..
            } else if (isPossible(s))
            {
                //do nothing.. we did in ispossible function
            } else throw new Exception("Valid License can not be generated");
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

    }

    public boolean isValid(String s)
    {
        int n=s.length();
        for(int i=1;i<n;i++){
            if(s.charAt(i)==s.charAt(i-1))return false;
        }
        return true;
    }
    public boolean isPossible(String s)
    {
        int n=s.length();
        int[]fre=new int[26];
        for(int i=0;i<n;i++)fre[s.charAt(i)-'A']++;
        int limit=(n/2)+1;
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<n;i++)
        {
            if(fre[i]>limit)return false;
        }

        //else it is possible to rearrange..

        char[]arr=s.toCharArray();
        for(int i=1;i<n;i++)
        {
            if(arr[i]==arr[i-1])
            {
                for(int j=i+1;i<n;i++)
                {
                    if(arr[j]!=arr[i-1])
                    {
                        char temp=arr[i];
                        arr[i]=arr[j];
                        arr[i]=temp;
                    }
                }
            }
        }

        tradeLicenseId=String.valueOf(arr);
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