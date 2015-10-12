/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role.Supplier;

import Business.DB4OUtil.DB4OUtil;
import Business.EcoSystem;
import Business.Enterprise.Amazon;
import Business.Enterprise.Enterprise;
import Business.Enterprise.Supplier;
import Business.Organization.Amazon.Admin.AmazonAdminOrganization;
import Business.Organization.Amazon.Admin.WorkQueue;
import Business.Organization.Amazon.Finance.Payment;
import Business.Organization.Organization;
import Business.Organization.Supplier.Finance.SupplierFinanceOrganization;
import Business.Role.Role;
import Business.UserAccount.UserAccount;
import Interface.Supplier.Finance.SupplierFinanceEmployeeWorkAreaJPanel;
import javax.swing.JPanel;

/**
 *
 * @author Manish Gajare
 */
public class SupplierFinanceEmployeeRole extends Role{
    
    

    
    
    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem system,DB4OUtil db4OUtil,Amazon amazonEnterprise) {
    
        
            WorkQueue workQueue = null;
            Payment payment = null;
         for(int i=0; amazonEnterprise.getOrganizationDirectory().getOrganizationList().size()>i;i++){
             
             if(amazonEnterprise.getOrganizationDirectory().getOrganizationList().get(i) instanceof AmazonAdminOrganization)
             {
                 AmazonAdminOrganization amazonAdminOrganization = (AmazonAdminOrganization)amazonEnterprise.getOrganizationDirectory().getOrganizationList().get(i);
                 workQueue = amazonAdminOrganization.getWorkQueue();
                 

             }
             
         }
        
        
        
        return new SupplierFinanceEmployeeWorkAreaJPanel(userProcessContainer, account, (SupplierFinanceOrganization)organization,workQueue,(Supplier)enterprise);
   }
    
}
