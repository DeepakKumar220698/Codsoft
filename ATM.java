

import java.util.Scanner;

public class ATM 
{

    private static int BALANCE = 100000;

    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to the ATM.");
        System.out.println("Enter your PIN:");

        int pin = sc.nextInt();

        if (pin == 1234 || pin == 2345 || pin == 3456 || pin == 4567 || pin == 2312 || pin == 5634 || pin == 7562 || pin == 4987) 
        {
            System.out.println("Your balance is $" + BALANCE);

            System.out.println("What would you like to do?");
            System.out.println("1. Check balance");
            System.out.println("2. Deposit money");
            System.out.println("3. Withdraw money");
            System.out.println("4. Exit");

            int choice = sc.nextInt();

            switch (choice) 
            {
                case 1:
                    System.out.println("Your balance is $" + BALANCE);
                    break;
                case 2:
                    System.out.println("Enter the amount you want to deposit:");
                    int amount = sc.nextInt();
                    BALANCE += amount;
                    System.out.println("Your new balance is $" + BALANCE);
                    break;
                case 3:
                    System.out.println("Enter the amount you want to withdraw:");
                    amount = sc.nextInt();
                    if (amount > BALANCE) 
                    {
                        System.out.println("You have low account balance.");
                    }
                     else 
                    {
                        BALANCE -= amount;
                        System.out.println("Your new balance after credit is $" + BALANCE);
                    }
                    break;
                case 4:
                    System.out.println("Goodbye.");
                    break;
                default:
                    System.out.println("Invalid Input.");
            }
        }
        else 
        {
            System.out.println("Incorrect PIN.");
        }
    }
}