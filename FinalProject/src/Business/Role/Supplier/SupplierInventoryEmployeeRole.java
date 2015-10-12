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
import Business.Organization.Amazon.Inventory.AmazonInventoryOrganization;
import Business.Organization.Amazon.Inventory.ProductCatalogList;
import Business.Organization.Organization;
import Business.Organization.Supplier.Inventory.SupplierInventoryOrganization;
import Business.Role.Role;
import Business.UserAccount.UserAccount;
import Interface.Supplier.Inventory.SupplierInventoryEmployeeWorkAreaJPanel;
import javax.swing.JPanel;

/**
 *
 * @author Manish Gajare
 */
public class SupplierInventoryEmployeeRole extends Role{
    
     @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem system,DB4OUtil db4OUtil,Amazon amazonEnterprise) {
        
         
         ProductCatalogList productCatalogList = null;
         for(int i=0; amazonEnterprise.getOrganizationDirectory().getOrganizationList().size()>i;i++){
             
             if(amazonEnterprise.getOrganizationDirectory().getOrganizationList().get(i) instanceof AmazonInventoryOrganization)
             {
                 AmazonInventoryOrganization amazonInventoryOrganization = (AmazonInventoryOrganization)amazonEnterprise.getOrganizationDirectory().getOrganizationList().get(i);
                 productCatalogList = amazonInventoryOrganization.getProductCatalogList();

             }
             
         }
         
         
         return new SupplierInventoryEmployeeWorkAreaJPanel(userProcessContainer, account, (SupplierInventoryOrganization)organization, productCatalogList,db4OUtil,(Supplier)enterprise);
   }
    
}
