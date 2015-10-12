/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;


import Business.Customer.CustomerAccountDirectory;
import Business.Customer.CustomerDirectory;
import Business.Supplier.SupplierDirectory;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author Manish Gajare
 */
public class Amazon extends Enterprise {
    
    private SupplierDirectory supplierDirectory;
    private CustomerDirectory customerDirectory;
    private CustomerAccountDirectory customerAccountDirectory;
    
    
     public Amazon(String name) {
        super(name, Enterprise.EnterpriseType.AMAZON);
        customerDirectory = new CustomerDirectory();
        customerAccountDirectory = new CustomerAccountDirectory();
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        return null;
    }

    public SupplierDirectory getSupplierDirectory() {
        return supplierDirectory;
    }

    public CustomerDirectory getCustomerDirectory() {
        return customerDirectory;
    }

    public CustomerAccountDirectory getCustomerAccountDirectory() {
        return customerAccountDirectory;
    }

    
    
    
    
}
