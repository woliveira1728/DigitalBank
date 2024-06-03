package com.digitalbank.accounts;

public class SavingsAccount extends Account {

    public void printextract() {
        System.out.println("\n=== Saving Account Statement ===");
        super.printAttributes();
    }

}
