package application;
import entities.BankAccount;
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
                    System.out.println("Digite o numero da conta");
                    int number = sc.nextInt();
                    BankAccount foundAccount = service.findAccountByNumber(number);
                    if(foundAccount != null){
                        int escolha;
                        do{
                        Menu.menuAccount();
                        escolha = sc.nextInt();

                        switch (escolha){
                            case 1:
                                System.out.println(foundAccount);
                                break;
                            case 2:
                                System.out.print("quanto deseja depositar");
                                double deposit = sc.nextDouble();
                                if(foundAccount.deposit(deposit)){
                                    System.out.println("Deposito realizado");
                                }else{
                                    System.out.println("valor invalido");
                                }
                                break;
                            case 3:
                                System.out.println("Qual valor quer sacar?");
                                double saque = sc.nextDouble();
                                if(foundAccount.withdraw(saque)){
                                    System.out.println("Saque realizado");
                                }else {
                                    System.out.println("saque nao realizado");
                                }

                                break;

                            case 0:
                                break;

                            default:
                                System.out.println("Opcao invalida");
                        }

                        }while (escolha != 0);
                    }else {
                        System.out.println("Conta nao encontrada");
                    }

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
