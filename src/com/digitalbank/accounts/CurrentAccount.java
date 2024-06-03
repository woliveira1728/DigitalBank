package com.digitalbank.accounts;

public class CurrentAccount extends Account {

    public void printextract() {
        System.out.println("\n=== Current Account Statement ===");
        super.printAttributes();
    }

}
