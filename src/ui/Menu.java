package ui;


public class Menu {

     public static void showMainMenu() {
        System.out.println("===== BANKFLOW =====");
        System.out.println();
        System.out.println("1 - Create account");
        System.out.println("2 - Access account");
        System.out.println("3 - List accounts");
        System.out.println();
        System.out.println("0 - Exit");
        System.out.println();
     }

     public static void showAccountTypeMenu() {
         System.out.println("===== CREATE ACCOUNT =====");
         System.out.println("1 - Checking account");
         System.out.println("2 - Savings account");
         System.out.println();
         System.out.println("0 - Back");
         System.out.println();
     }

     public static void menuAccount(){
         System.out.println("===== ACCOUNT MENU =====");
         System.out.println();
         System.out.println("1 - Account details");
         System.out.println("2 - Deposit");
         System.out.println("3 - Withdraw");
         System.out.println();
         System.out.println("0 - Back");
         System.out.println();
     }


}
