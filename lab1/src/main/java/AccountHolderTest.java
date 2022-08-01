import java.util.Scanner;

import static java.lang.System.in;

public class AccountHolderTest {
    public static void main(String[] args) {
        /*
        Allow the interest for the bank to be initially set at 4%. This can be hard coded in.
         */
        AccountHolder.annualInterestRate = 0.04;
        while (true) {
            try {
                System.out.printf("welcome to IIT bank ,the interest rate of one year is %.2f ." +
                        "please enter your initBalance... \n", AccountHolder.annualInterestRate);
                Scanner scanner = new Scanner(in);
                AccountHolder accountHolder = new AccountHolder(Double.parseDouble(scanner.next()));
                System.out.printf("accountBalance is %.2f \n", accountHolder.getBalance());
                while (true) {
                    System.out.println("please enter the amount you wanna deposit ...");
                    double amt = Double.parseDouble(new Scanner(in).next());
                    if (amt < 0) {
                        System.out.println("amt must be non-negative");
                    } else {
                        accountHolder.deposit(amt);
                        System.out.printf("accountBalance is %.2f \n", accountHolder.getBalance());
                        break;
                    }
                }

                while (true) {
                    System.out.println("please enter the amount you wanna withdrawal ...");
                    scanner = new Scanner(in);
                    double withdrawal = Double.parseDouble(scanner.next());
                    if (withdrawal < 0) {
                        System.out.println("amt must be non-negative");
                    }
                         /*
                            Disallow a withdrawal attempts to drive account balance to drop below $50.
                             Deliver a message to the console stating that the balance must hold to at least $50.
                     */
                    else if (accountHolder.getBalance() - withdrawal < 50) {
                        System.out.println("acoount balance can't be less than 50");

                    } else {
                        accountHolder.withdrawal(withdrawal);
                        accountHolder.monthlyInterest();
                        System.out.printf("after one month ,accountBalance %.2f \n", accountHolder.getBalance());
                        break;
                    }

                }

            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("please renter your  balance");
            }


        }
    }
}
