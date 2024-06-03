package com.digitalbank.accounts;

public class GenesisAccount extends Account {

    public void printextract() {
        System.out.println("\n=== Current Account Statement ===");
        super.printAttributes();
    }

}
