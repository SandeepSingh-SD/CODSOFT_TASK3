/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.atminterface;

/**
 *
 * @author DELL
 */

import java.util.Scanner;

class BankAccount{
	
	float balance = 10000f;
	int transactions = 0;
	String transactionHistory = "";
	
	public boolean login() {
		boolean isLogin = false;
		Scanner sc=new Scanner(System.in);
		while( !isLogin) {
			System.out.print("\nEnter your username: ");
			String Username = sc.nextLine();
			if (Username.equals("sd")) {
		        while(!isLogin) {
			   System.out.print("\nEnter your password: ");
			   String Password = sc.nextLine();
			   if(Password.equals("1234")) {
			   System.out.println("\nLogin Successful");
			   isLogin = true;
			   }
			   else {
			   System.out.println("\nIncorrect Password");
			   }
			}
		     }
                      else {
		        System.out.println("\nUsername not found");
			}
		    }
		return isLogin;
	}
	
	public void withdraw() {
		System.out.print("\nEnter Amount to Withdraw: ");
		Scanner sc=new Scanner(System.in); 
		float amount = sc.nextFloat();
		try {
		    if(balance >= amount) {
		    transactions++;
		    balance -= amount;
		    System.out.println("\nWithdral Successful.");
		    String str = amount + "Rs Withdrawn\n";
		    transactionHistory = transactionHistory.concat(str);
		    }
                    else {
			System.out.println("\nInsufficient Balance.");
			}
		}catch(Exception e) {
			
		}
		
	}
	
	public void deposit() {
		System.out.print("\nEnter Amount to Deposit: ");
		Scanner sc=new Scanner(System.in); 
		float amount = sc.nextFloat();
		try {
		  if(amount <= 100000f) {
		     transactions++;
		     balance += amount;
		     System.out.println("\nDeposit Successful.");
		     String str = amount + "Rs deposited\n";
		     transactionHistory = transactionHistory.concat(str);
		}
                  else {
		    System.out.println("\nSorry. The limit is 100000.");
			}
		}
                catch(Exception e) {
			
		}
		
	}
	
	public void transfer() {
	    Scanner sc=new Scanner(System.in); 
		System.out.print("\nEnter Receipent's Name: ");
		String receipent = sc.nextLine();
		System.out.print("\nEnter Amount to transfer: ");
		float amount = sc.nextFloat();
		try {
		    if(balance>= amount) {
		    if(amount <= 50000f) {
		     transactions++; 
		     balance -= amount;
		     System.out.println("\nSuccesfully Transferred to "+ receipent);
		     String str = amount + "Rs transferred to " + receipent+"\n";
		     transactionHistory = transactionHistory.concat(str);
		}
                    else {
		        System.out.println("\nSorry. The limit is 50000.");
			}
		}
                    else{
			System.out.println("\nInsufficient Balance.");
		}
               }
                catch(Exception e) {
		}
			
	    }
		
	public void checkBalance() {
	    System.out.println("\n"+balance+"Rs");
	}
	
	
	
	
	public void transHistory() {
		if(transactions ==0) {
			System.out.println("No TRansactions");
		}else {
			System.out.print("\n"+transactionHistory);
		}
	}
}

public class Atmmachine {
	
	public static int takenIntegerInput(int limit) {
		int input = 0;
		boolean flag = false;
		
		while(!flag) {
		    try {
			Scanner sc = new Scanner(System.in);
			input = sc.nextInt();
			flag = true;
				
			if(flag && input>limit || input<1) {
			    System.out.println("Choose the number between 1 to "+limit);
			    flag=false;
			}
		}
                    catch(Exception e) {
			System.out.println("Enter only integer value.");
			flag=false;
			}
		}
		return input;
	}
	
public static void main(String[] args) {
    System.out.println("\n--------**********WELCOME TO ATM MACHINE**********--------");
        BankAccount b= new BankAccount();
		
	while(true) {
	  System.out.println("\n1.Login \n2.Exit");
	  System.out.print("Enter your choice Optional: ");
	  int ch = takenIntegerInput(2);
	  if(ch==1) 
          {
	  if(b.login()) 
          {
	  System.out.println("\n****--**--**WELCOME To ATM INTERFACE**--**--****");
	  boolean isFinished = false;
	  while(!isFinished) {
          System.out.println(" ");
	  System.out.println("\n1.withdraw \n2.Deposit \n3.Transfer \n4.check balance \n5.Transaction History \n6.Exit");
	  System.out.print("Enter your choice Optional: ");
	  int c = takenIntegerInput(6);
	  switch(c) 
          {
	   case 1:
	   b.withdraw();
	   break;
	   case 2:
	   b.deposit();
	   break;
	   case 3:
	   b.transfer();
	   break;
	   case 4:
           b.checkBalance();
           break;
	   case 5:
	   b.transHistory();
	   break;
	   case 6:
	   isFinished = true;
	   break;
          }
        }
       }
      }
          else{
              System.exit(0);
          }
        }
		
    }
}



