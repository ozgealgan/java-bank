package com.java.bank.service;

import com.java.bank.model.Account;
import com.java.bank.model.Customer;

import java.util.ArrayList;
import java.util.List;

public class AccountService {

    private final CustomerService customerService;
    private List<Account> accountList;

    public  AccountService(CustomerService customerService) {
        this.customerService = customerService;
        this.accountList = new ArrayList<Account>();
    }

    public List<Account> getAccountList() {
        return accountList;
    }

    public void setAccountList(List<Account> accountList) {
        this.accountList = accountList;
    }

    public Account createAccount(Account account){
        Customer customer = customerService.getCustomer(account.getCustomerId());
        if(checkCustomerId(account.getCustomerId())){
            accountList.add(account);
        }

        System.out.println("Account created, account : " + account);
        return account;
    }

    public void deleteAccount(String accountId){
        for(int i=0; i < accountList.size(); i++){
            if(accountId.equals(accountList.get(i).getAccountId())){
                System.out.println("Account deleted, account : " + accountList.get(i));
                accountList.remove(i);
                break;
            }
        }
    }


    public Account getAccount(String accountId){
        Account account = null;
        for(int i=0; i < accountList.size(); i++){
            if(accountId.equals(accountList.get(i).getAccountId())){
                System.out.println("Account found, account : " + accountList.get(i));
                account = accountList.get(i);
                break;
            }
        }

        return account;
    }

    public Account withdrawMoney(String accountId, Double amount){
        Account account = getAccount(accountId);
        if(account == null){
            System.out.println("Couldnt find any customer with this is: " + accountId);
            return null;
        }

        Double balance = account.getBalance();
        if(balance > amount){
            account.setBalance(balance - amount);
            System.out.println("Money withdrawn, new balance : " + (balance - amount));
            updateAccount(account, accountId);
        }else{
            System.out.println("Insufficient funds for this accountId  " + accountId + "current balance is : " + balance);
        }

        return account;
    }

    public Account addMoney(String accountId, Double amount){
        Account account = getAccount(accountId);
        if(account == null){
            System.out.println("Couldnt find any customer with this is: " + accountId);
            return null;
        }

        Double balance = account.getBalance();
        account.setBalance(balance + amount);
        System.out.println("Money added, new balance : " + (balance + amount));
        updateAccount(account, accountId);

        return account;
    }

    private List<Account> updateAccount(Account account, String accountId){
        Account oldAccount = new Account();
        for(int i=0; i < accountList.size(); i++){
            if(accountId.equals(accountList.get(i).getAccountId())){
                oldAccount = accountList.get(i);
                accountList.remove(i);
                break;
            }
        }

        oldAccount.setBalance(account.getBalance());
        accountList.add(oldAccount);

        return accountList;
    }

    private boolean checkCustomerId(String customerId){
        Customer customer = customerService.getCustomer(customerId);
        if(customer == null) {
            System.out.println("Couldnt find any customer with this is: " + customerId);
            return false;
        }else {
            return true;
        }
    }
}
