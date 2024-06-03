package com.digitalbank;

import com.digitalbank.accounts.Account;
import com.digitalbank.accounts.GenesisAccount;
import com.digitalbank.principal.Principal;

public class DigitalBankApplication {

    public static void main(String[] args) {
        Account genesisAccount = new GenesisAccount();
        genesisAccount.setListAccounts(genesisAccount);

        Principal principal = new Principal(genesisAccount);

        principal.initialMenu();

    }
}