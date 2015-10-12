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
public class CustomerAccountDirectory {
    
    
           private ArrayList<CustomerAccount> customerAccountList;

    public CustomerAccountDirectory() {
        customerAccountList = new ArrayList<>();
    }

    public ArrayList<CustomerAccount> getCustomerAccountList() {
        return customerAccountList;
    }

   
    
    public CustomerAccount authenticateCustomer(String username, String password){
        for (CustomerAccount ca : customerAccountList)
            if (ca.getUsername().equals(username) && ca.getPassword().equals(password)){
                return ca;
            }
        return null;
    }
    
    public CustomerAccount createCustomerAccount(String username, String password, Customer customer){
        CustomerAccount customerAccount = new CustomerAccount();
        customerAccount.setUsername(username);
        customerAccount.setPassword(password);
        customerAccount.setCustomer(customer);
        customerAccountList.add(customerAccount);
        return customerAccount;
    }
    
    
}
