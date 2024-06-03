package com.digitalbank.accounts;

public interface IAccount {

    void withdraw(Double value);

    void deposit(Double value);

    void transfer(Account account, Double value);

    void printextract();

}
