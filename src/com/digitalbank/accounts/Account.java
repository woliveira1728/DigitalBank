package com.digitalbank.accounts;

import java.util.ArrayList;
import java.util.List;

public abstract class Account implements IAccount {

    private static final int STANDARD_AGENCY = 1;
    private static int SEQUENTIAL = 1;

    protected int agency;
    protected int account;
    protected Double balance;
    protected List<Account> listAccounts = new ArrayList<>();

    public Account() {
        this.agency = Account.STANDARD_AGENCY;
        this.account = SEQUENTIAL++;
        this.balance = 0.0;
    }

    protected void printAttributes() {
        System.out.printf("""
                Agency: %d
                Account: %d
                Balance: %.2f
                """, agency, account, balance);
    }

    @Override
    public void withdraw(Double value) {
        balance -= value;
    }

    @Override
    public void deposit(Double value) {
        balance += value;
    }

    @Override
    public void transfer(Account targetAccount, Double value) {
        withdraw(value);
        targetAccount.deposit(value);
    }

    public int getAgency() {
        return agency;
    }

    public int getAccount() {
        return account;
    }

    public Double getBalance() {
        return balance;
    }

    public List<Account> getListAccounts() {
        return listAccounts;
    }

    public void setListAccounts(Account acc) {
        this.listAccounts.add(acc);
    }

    @Override
    public String toString() {
        return "Account: " + account;
    }
}
