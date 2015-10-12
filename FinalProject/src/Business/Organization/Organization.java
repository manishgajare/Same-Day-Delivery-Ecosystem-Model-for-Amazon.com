/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Employee.EmployeeDirectory;
import Business.Role.Role;
import Business.UserAccount.UserAccount;
import Business.UserAccount.UserAccountDirectory;
import java.util.ArrayList;


/**
 *
 * @author Manish Gajare
 */
public abstract class Organization {
    
    private String name;
    private EmployeeDirectory employeeDirectory;
    private UserAccountDirectory userAccountDirectory;
    private int organizationID;
    private static int counter;
    
    public enum Type{
        SystemAdmin("System Admin Organization"),
        AmazonAdmin("Amazon Admin Organization"),
        SupplierAdmin("Supplier Admin Organization"),
        AmazonSales("Amazon Sales Organization"), 
        AmazonFinance("Amazon Finance Organization"),
        AmazonCustomerService("Amazon Customer Service Organization"),
        AmazonInventory("Amazon Inventory Organization"),
        AmazonShipment("Amazon Shipment Organization"),
        SupplierSales("Supplier Sales Organization"), 
        SupplierFinance("Supplier Finance Organization"),
        SupplierInventory("Supplier Inventory Organization"),
        SupplierShipment("Supplier Shipment Organization");
        
        private String value;
        private Type(String value) {
            this.value = value;
        }
        public String getValue() {
            return value;
        }
    }

    public Organization(String name) {
        this.name = name;
        employeeDirectory = new EmployeeDirectory();
        userAccountDirectory = new UserAccountDirectory();
        organizationID = counter;
        ++counter;
    }

    public abstract ArrayList<Role> getSupportedRole();
    
    public UserAccountDirectory getUserAccountDirectory() {
        return userAccountDirectory;
    }

    public int getOrganizationID() {
        return organizationID;
    }

    public EmployeeDirectory getEmployeeDirectory() {
        return employeeDirectory;
    }
    
    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    
    
    
    @Override
    public String toString() {
        return name;
    }
   
    
}
