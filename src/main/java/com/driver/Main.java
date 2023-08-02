package com.driver;

import java.security.spec.ECField;

public class Main
{
    public static void main(String[] args)
    {
        BankAccount ba=new BankAccount("Aniket Khangar",1379,300);
        try
        {
            ba.withdraw(100);
            System.out.println(ba.generateAccountNumber(13,118));
        }
        catch (Exception e)
        {

        }
        finally
        {
            ba=new SavingsAccount("Pranali",1500,1000,6.25);
            try
            {
                //withdraw limit exception...
                ba.withdraw(1001);

                //Insufficient balance exception...
                ba.withdraw(400);

            }
            catch(Exception e)
            {

            }
            finally
            {
                try
                {
                    CurrentAccount ca=new CurrentAccount("Pranu",50000,"IIIT");
                    ca.validateLicenseId();
                }
                catch(Exception e)
                {
                    System.out.print(e.getMessage());
                }



            }

        }
    }
}