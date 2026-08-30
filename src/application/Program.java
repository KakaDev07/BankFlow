package application;
import entities.CheckingAccount;
import entities.SavingsAccount;
import services.BankService;
import ui.Menu;
import java.util.Scanner;

public class Program {

    public static void main (String[] args) {

        Scanner sc = new Scanner(System.in);
        int option;
        BankService service = new BankService();

        do{
            Menu.showMainMenu();
            option = sc.nextInt();

            switch (option){
                case 1:
                    int accountType;
                    Menu.showAccountTypeMenu();
                    accountType = sc.nextInt();

                    switch (accountType){
                        case 1:

                            System.out.print("numero da conta :");
                            int number = sc.nextInt();
                            System.out.print("nome :");
                            sc.nextLine();
                            String name = sc.nextLine();
                            System.out.print("deposito inicial");
                            double deposit = sc.nextDouble();
                            CheckingAccount account = new CheckingAccount(number, name, deposit);
                            if(service.addAccount(account)){
                                System.out.println("Conta criada");
                            }else{
                                System.out.println("erro 404 kkkk");
                            }
                            break;

                        case 2:
                            System.out.println("numero da conta");
                            int numberP = sc.nextInt();
                            System.out.println("nome ");
                            sc.nextLine();
                            String nameP = sc.nextLine();
                            System.out.println("Deposito inicial");
                            double depositP = sc.nextDouble();
                            SavingsAccount account1 = new SavingsAccount(numberP, nameP, depositP);
                            if(service.addAccount(account1)){
                                System.out.println("Conta criada");
                            }else{
                                System.out.println("erro 404 kkkk");
                            }
                            break;

                        case 0:
                            // voltar
                            break;

                        default:
                            System.out.println("Invalid option");
                    }
                    break;

                case 2:
                    // acessar conta
                    break;

                case 3:
                   // listar contas
                    break;

                case 0:
                    // sair
                    break;

                default:
                    System.out.println("Invalid option");
            }

        } while (option != 0);



        sc.close();
    }
}
