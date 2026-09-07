package application;

import entities.BankAccount;
import entities.CheckingAccount;
import entities.SavingsAccount;
import services.BankService;
import ui.Menu;

import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        BankService service = new BankService();
        int option;

        do {
            Menu.showMainMenu();
            option = sc.nextInt();

            switch (option) {
                case 1:
                    int accountType;

                    Menu.showAccountTypeMenu();
                    accountType = sc.nextInt();

                    switch (accountType) {
                        case 1:
                            System.out.print("Account number: ");
                            int number = sc.nextInt();

                            System.out.print("Account holder: ");
                            sc.nextLine();
                            String name = sc.nextLine();

                            System.out.print("Initial deposit: R$ ");
                            double deposit = sc.nextDouble();

                            CheckingAccount account =
                                    new CheckingAccount(number, name, deposit);

                            if (service.addAccount(account)) {
                                System.out.println("\nAccount created successfully!");
                            } else {
                                System.out.println("\nAccount could not be created.");
                                System.out.println("Check the account number and initial deposit.");
                            }
                            break;

                        case 2:
                            System.out.print("Account number: ");
                            int savingsNumber = sc.nextInt();

                            System.out.print("Account holder: ");
                            sc.nextLine();
                            String savingsHolder = sc.nextLine();

                            System.out.print("Initial deposit: R$ ");
                            double savingsDeposit = sc.nextDouble();

                            SavingsAccount savingsAccount =
                                    new SavingsAccount(savingsNumber, savingsHolder, savingsDeposit);

                            if (service.addAccount(savingsAccount)) {
                                System.out.println("\nAccount created successfully!");
                            } else {
                                System.out.println("\nAccount could not be created.");
                                System.out.println("Check the account number and initial deposit.");
                            }
                            break;

                        case 0:
                            break;

                        default:
                            System.out.println("Invalid option.");
                    }
                    break;

                case 2:
                    System.out.print("Enter the account number: ");
                    int accountNumber = sc.nextInt();

                    BankAccount foundAccount =
                            service.findAccountByNumber(accountNumber);

                    if (foundAccount != null) {
                        int accountOption;

                        do {
                            Menu.menuAccount();
                            accountOption = sc.nextInt();

                            switch (accountOption) {
                                case 1:
                                    System.out.println(foundAccount);
                                    break;

                                case 2:
                                    System.out.print("Deposit amount: R$ ");
                                    double deposit = sc.nextDouble();

                                    if (foundAccount.deposit(deposit)) {
                                        System.out.println("Deposit completed successfully!");
                                    } else {
                                        System.out.println("Invalid deposit amount.");
                                    }
                                    break;

                                case 3:
                                    System.out.print("Withdrawal amount: R$ ");
                                    double withdrawal = sc.nextDouble();

                                    if (foundAccount.withdraw(withdrawal)) {
                                        System.out.println("Withdrawal completed successfully!");
                                    } else {
                                        System.out.println("Withdrawal could not be completed.");
                                    }
                                    break;

                                case 0:
                                    break;

                                default:
                                    System.out.println("Invalid option.");
                            }

                        } while (accountOption != 0);

                    } else {
                        System.out.println("Account not found.");
                    }
                    break;

                case 3:
                    if (service.getAccounts().isEmpty()) {
                        System.out.println("No accounts registered.");
                    } else {
                        System.out.println("\n===== REGISTERED ACCOUNTS =====");

                        for (BankAccount account : service.getAccounts()) {
                            System.out.println(account);
                        }
                    }
                    break;

                case 0:
                    System.out.println("Closing BankFlow...");
                    break;

                default:
                    System.out.println("Invalid option.");
            }

        } while (option != 0);

        sc.close();
    }
}