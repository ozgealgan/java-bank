package com.java.bank.service;

import com.java.bank.model.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerService {

    private List<Customer> customerList;

    public CustomerService() {
        this.customerList = new ArrayList<Customer>();
    }

    public List<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
    }

    public Customer createCustomer(Customer customer){
        customerList.add(customer);
        System.out.println("Customer created, customer : " + customer);
        return customer;
    }

    public Customer updateCustomer(Customer customer, String customerId){
        Customer oldCustomer = new Customer();
        for(int i=0; i < customerList.size(); i++){
            if(customerId.equals(customerList.get(i).getId())){
                oldCustomer.setId(customerList.get(i).getId());
                customerList.remove(i);
                break;
            }
        }

        oldCustomer.setAddress(customer.getAddress());
        oldCustomer.setBirthDate(customer.getBirthDate());
        oldCustomer.setCity(customer.getCity());
        oldCustomer.setEmail(customer.getEmail());
        oldCustomer.setPhone(customer.getPhone());
        oldCustomer.setName(customer.getName());
        customerList.add(oldCustomer);

        System.out.println("Customer updated, customer : " + oldCustomer);
        return oldCustomer;
    }

    public void deleteCustomer(String customerId){
        for(int i=0; i < customerList.size(); i++){
            if(customerId.equals(customerList.get(i).getId())){
                System.out.println("Customer deleted, customer : " + customerList.get(i));
                customerList.remove(i);
                break;
            }
        }
    }

    public Customer getCustomer(String customerId){
      Customer customer = null;
        for(int i=0; i < customerList.size(); i++){
            if(customerId.equals(customerList.get(i).getId())){
                customer = customerList.get(i);
                System.out.println("Customer found, customer : " + customer);
                break;
            }
        }

        return customer;
    }
}
