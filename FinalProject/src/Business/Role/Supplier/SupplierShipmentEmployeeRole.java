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
import Business.Organization.Supplier.Shipment.SupplierShipmentOrganization;
import Business.Role.Role;
import Business.UserAccount.UserAccount;
import Interface.Supplier.Shipment.SupplierShipmentEmployeeWorkAreaJPanel;
import javax.swing.JPanel;

/**
 *
 * @author Manish Gajare
 */
public class SupplierShipmentEmployeeRole extends Role{
    
    
    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem system,DB4OUtil db4OUtil,Amazon amazonEnterprise) {
   
        
        WorkQueue workQueue = null;
            
         for(int i=0; amazonEnterprise.getOrganizationDirectory().getOrganizationList().size()>i;i++){
             
             if(amazonEnterprise.getOrganizationDirectory().getOrganizationList().get(i) instanceof AmazonAdminOrganization)
             {
                 AmazonAdminOrganization amazonAdminOrganization = (AmazonAdminOrganization)amazonEnterprise.getOrganizationDirectory().getOrganizationList().get(i);
                 workQueue = amazonAdminOrganization.getWorkQueue();
                 

             }
             
         }
         
         
        
        
        
        return new SupplierShipmentEmployeeWorkAreaJPanel(userProcessContainer, account, (SupplierShipmentOrganization)organization,workQueue,(Supplier)enterprise);
    }
    
    
}
