/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization.Amazon.Inventory;

import Business.Organization.Organization;
import Business.Role.Amazon.AmazonInventoryEmployeeRole;
import Business.Role.Role;
import Business.Role.System.SystemAdminRole;
import java.util.ArrayList;

/**
 *
 * @author Manish Gajare
 */
public class AmazonInventoryOrganization extends Organization{
    
    private ProductCatalogList productCatalogList;
    
    public AmazonInventoryOrganization() {
        super(Organization.Type.AmazonInventory.getValue());
        productCatalogList = new ProductCatalogList();
    }

    public ProductCatalogList getProductCatalogList() {
        return productCatalogList;
    }
    


    @Override
    public ArrayList<Role> getSupportedRole() {
  ArrayList<Role> roles = new ArrayList<>();
        roles.add(new AmazonInventoryEmployeeRole());
        return roles;
    }
    
}
