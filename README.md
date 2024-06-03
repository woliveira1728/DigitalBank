# DigitalBank

DigitalBank is a simple banking simulation application developed in Java. The main goal is to create, manage, and interact with different types of bank accounts.

## Features

- **Create Accounts**:
    - Current Account
    - Savings Account
- **Select Existing Accounts**
- **Manage Accounts**:
    - Deposit
    - Withdraw
    - Transfer
    - Print Statement

## Project Structure

The project structure is divided into three main packages:

1. **com.digitalbank**: Contains the main class `DigitalBankApplication`.
2. **com.digitalbank.accounts**: Contains classes related to accounts (`Account`, `CurrentAccount`, `SavingsAccount`, `GenesisAccount`) and the interface `IAccount`.
3. **com.digitalbank.principal**: Contains the class `Principal`, responsible for user interaction.

## Classes and Methods

### DigitalBankApplication

Main class that starts the application.

```java
public class DigitalBankApplication {
    public static void main(String[] args) {
        Account genesisAccount = new GenesisAccount();
        genesisAccount.setListAccounts(genesisAccount);

        Principal principal = new Principal(genesisAccount);

        principal.initialMenu();
    }
}
```
## Principal
Class responsible for user interaction, offering an initial menu and account management options.

Main methods:
- `initialMenu()`: Displays the initial menu and manages user navigation.
- `currentService()`: Creates a new Current Account and adds it to the account list.
- `savingsService()`: Creates a new Savings Account and adds it to the account list.
- `selectAccService(Account genesisAccount)`: Displays all existing accounts and allows selecting a specific account to manage.
- `showMenu(Account account)`: Displays the options menu for a selected account.
- `withdrawService(Account account)`, `depositService(Account account)`, `transferService(Account account)`, `extractService(Account account)` : Methods to manage operations on the selected account.

## Account (Abstract Class)
Base class for all accounts. Implements the IAccount interface.

Main attributes:
- `Agency`: Agency number.
- `account`: Account number.
- `balance`: Account balance.
- `listAccounts`: List of all accounts.

Main methods:
- `withdraw(Double value)`: Performs a withdrawal from the account.
- `deposit(Double value)`: Performs a deposit into the account.
- `transfer(Account targetAccount, Double value)`: Performs a transfer to another account.
- `printextract()`: Abstract method for printing the account statement (implemented in derived classes).

### CurrentAccount, SavingsAccount, GenesisAccount
Classes that extend `Account` and implement the `printextract()` method to display the account statement.

## How to Run
1. Make sure you have the JDK installed on your system.
2. Compile the project using the command:
   ```bash
   javac -d bin src/com/digitalbank/*.java src/com/digitalbank/accounts/*.java src/com/digitalbank/principal/*.java
   ```
3. Run the application with the command:
   ```bash
   java -cp bin com.digitalbank.DigitalBankApplication
   ```