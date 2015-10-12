/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Customer;

import Business.Employee.Employee;

/**
 *
 * @author Manish Gajare
 */
public class CustomerAccount {
    
    
    private String username;
    private String password;
    private Customer customer;


    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


 

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    
    
    
    @Override
    public String toString() {
        return username;
    }
    
    
    
    
    
}
