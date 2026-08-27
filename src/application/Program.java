package application;

import entities.BankAccount;

import java.util.Scanner;

public class Program {

    public static void main (String[] args) {


        Scanner sc = new Scanner(System.in);
        BankAccount account = null;

        System.out.println("numero da conta");
        int num = sc.nextInt();
        System.out.println("digite nome");
        sc.nextLine();
        String nome = sc.nextLine();
        System.out.println("deposito inicial?");
        System.out.println("1- sim");
        System.out.println("2- nao");
        int esco = sc.nextInt();
        switch (esco){
            case 1:
                System.out.println("Qual valor para depositar?");
                double deposit = sc.nextDouble();
                account = new BankAccount(num, nome,  deposit);
                break;
            case 2:
                account = new BankAccount(num, nome);
                break;
            default:
                System.out.println("Opçao invalida");
                return;
        }
        System.out.println(account);

        sc.close();
    }
}
