/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.DB4OUtil.DB4OUtil;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import Business.EcoSystem;
import Business.Enterprise.Amazon;
import javax.swing.JPanel;

/**
 *
 * @author Manish Gajare
 */
public abstract class Role {
    
    
//            public enum RoleType{
//        SystemAdmin("System Admin"),
//        AmazonAdmin("Amazon Admin"),
//        SupplierAdmin("Supplier Admin"),
//        AmazonSales("Sales Management Employee"),
//        AmazonInventory("Inventory Management Employee"),
//        AmazonCustomerService("Customer Service Employee"),
//        AmazonCustomerManagement("Customer Management Employee"),
//        AmazonFinance("Finance Employee"),
//        SupplierSales("Sales Management Employee"),
//        SupplierInventory("Inventory Management Employee"),
//        SupplierCustomerService("Customer Service Employee"),
//        SupplierFinance("Finance Employee");
//        
//        private String value;
//        private RoleType(String value){
//            this.value = value;
//        }
//
//        public String getValue() {
//            return value;
//        }
//
//        @Override
//        public String toString() {
//            return value;
//        }
//    }
    
    public abstract JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem system,DB4OUtil db4OUtil,Amazon amazonEnterprise);

    @Override
    public String toString() {
        return this.getClass().getName();
    }
    

    
    
}
