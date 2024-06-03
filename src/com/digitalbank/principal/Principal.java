package com.digitalbank.principal;

import com.digitalbank.accounts.Account;
import com.digitalbank.accounts.CurrentAccount;
import com.digitalbank.accounts.SavingsAccount;

import java.util.List;
import java.util.Scanner;

public class Principal {

    private Scanner scanner = new Scanner(System.in);
    private Account genesisAccount;

    public Principal(Account genesisAccount) {
        this.genesisAccount = genesisAccount;
    }

    public void initialMenu() {
        var option = -1;
        while (option != 0) {
            var menu  =  """
                        \n### DIGITAL BANK ###
                        Select account type:
                        1 - Create Current Account
                        2 - Create Savings Account
                        3 - Select Existing Account
    
                        0 - Exit
                        """;

            System.out.println(menu);
            option = scanner.nextInt();
            scanner.nextLine();
            
            switch (option) {
                case 1:
                    currentService();
                    break;
                case 2:
                    savingsService();
                    break;
                case 3:
                    selectAccService(genesisAccount);
                    break;
                case 0:
                    System.out.println("Leaving...");
                    break;
                default:
                    System.out.println("Invalid option!");
            }
        }
    }

    private void selectAccService(Account genesisAccount) {
        List<Account> listAccount = genesisAccount.getListAccounts();
        if (listAccount.isEmpty()) {
            System.out.println("No accounts available.");
            return;
        }

        System.out.println("Enter your account number:");
        int accSelected = scanner.nextInt();
        scanner.nextLine();

        Account selectedAccount = getAccountByNumber(accSelected);

        if (selectedAccount != null) {
            selectedAccount.printextract();
            showMenu(selectedAccount);
        } else {
            System.out.println("Reported account does not exist");
        }
    }

    private void savingsService() {
        Account savingsAcc = new SavingsAccount();
        genesisAccount.setListAccounts(savingsAcc);
        this.showMenu(savingsAcc);
    }

    private void currentService() {
        Account currentAcc = new CurrentAccount();
        genesisAccount.setListAccounts(currentAcc);
        this.showMenu(currentAcc);
    }

    public void showMenu(Account account) {
        var option = -1;
        while(option != 0) {
            var menu = """
                    \n### DIGITAL BANK ###
                    Options:
                    1 - Withdraw
                    2 - Deposit
                    3 - Transfer
                    4 - Extract

                    0 - Initial Menu
                    """;

            System.out.println(menu);
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    withdrawService(account);
                    break;
                case 2:
                    depositService(account);
                    break;
                case 3:
                    transferService(account);
                    break;
                case 4:
                    extractService(account);
                    break;
                case 0:
                    System.out.println("Leaving...");
                    break;
                default:
                    System.out.println("Invalid option!");
            }
        }
    }

    private void extractService(Account account) {
        account.printextract();
    }

    private void transferService(Account account) {

        System.out.println("Enter the account number:");
        int destinationAcc = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter the transfer amount:");
        Double amount = scanner.nextDouble();
        account.withdraw(amount);

        Account selectedAccount = getAccountByNumber(destinationAcc);
        if (selectedAccount != null) {
            selectedAccount.deposit(amount);
            System.out.println("Amount deposited into the account " + selectedAccount.getAccount());
            account.printextract();
        } else {
            System.out.println("Reported account does not exist");
        }

    }

    private void depositService(Account account) {
        System.out.println("Enter the deposit amount:");
        Double amount = scanner.nextDouble();

        account.deposit(amount);
        account.printextract();
    }

    private void withdrawService(Account account) {
        System.out.println("Enter the withdraw amount:");
        Double amount = scanner.nextDouble();

        account.withdraw(amount);
        account.printextract();
    }

    private Account getAccountByNumber(int accNumber) {

        Account selectedAccount = null;
        for (Account acc : genesisAccount.getListAccounts()) {
            if (acc.getAccount() == accNumber) {
                selectedAccount = acc;
            }
        }

        return selectedAccount;
    }

}
