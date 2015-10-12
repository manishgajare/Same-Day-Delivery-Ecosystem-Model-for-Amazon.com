/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Customer;


import java.util.ArrayList;

/**
 *
 * @author Manish Gajare
 */
public class CustomerDirectory {
    
      private ArrayList<Customer> customerList;

    public CustomerDirectory() {
        customerList = new ArrayList<>();
    }

    public ArrayList<Customer> getCustomerList() {
        return customerList;
    }

    public Customer createCustomer(String name,String phoneNo, String emailId, String country, String state, String region){
        Customer customer = new Customer();
        customer.setName(name);
        customer.setEmailId(emailId);
        customer.setCountry(country);
        customer.setPhoneNo(phoneNo);
        customer.setRegion(region);
        customer.setState(state);
        customerList.add(customer);
        return customer;
    }
    
    
    
 
    
}
