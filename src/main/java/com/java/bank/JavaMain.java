package com.java.bank;

import com.java.bank.model.Account;
import com.java.bank.model.Customer;
import com.java.bank.model.enums.City;
import com.java.bank.model.enums.Currency;
import com.java.bank.service.AccountService;
import com.java.bank.service.CustomerService;


public class JavaMain {

    public static void main(String[] args) {

        CustomerService customerService = new CustomerService();
        AccountService accountService = new AccountService(customerService);

        Customer customer1 = new Customer("123456789", "Ozge Algan", "Istanbul Maltepe", City.ISTANBUL, "ozgealgn1@gmail.com", "905555555555", 1996);
        Customer customer2 = new Customer("987654321", "Ayşe Algan", "Izmir Karabağlar", City.IZMIR, "aysealgan@gmail.com", "904444444444", 1995);
        customerService.createCustomer(customer1);
        customerService.createCustomer(customer2);

        Account account1 = new Account("123", "123456789", 2021, Currency.TL, 0.0);
        Account account2 = new Account("456", "987654321", 2021, Currency.TL, 1500.0);
        accountService.createAccount(account1);
        accountService.createAccount(account2);


        accountService.addMoney("123", 20000.0);
        accountService.addMoney("456", 100.0);
        accountService.withdrawMoney("456", 1800.0);
        accountService.withdrawMoney("123", 1000.0);

        /*Scanner scanner = new Scanner(System.in);
        System.out.println("Java Bankasına Hoşgeldiniz!");
        System.out.println("Yapmak İstediğiniz İşlemi Giriniz");
        System.out.println("1. Müşteri Kaydı için 1 ");
        System.out.println("2. Hesap oluşturma için 2 ");
        System.out.println("3. Var olan hesabınızdan para çekmek için 3 ");
        System.out.println("4. Hesabınıza para yüklemek için 4");
        System.out.println("5. Hesabınızı görüntülemek için 5 ");
        System.out.println("Çıkış için -1");

        int preference = scanner.nextInt();
        while(tercih != -1){
            switch ()
        }*/
    }
}
