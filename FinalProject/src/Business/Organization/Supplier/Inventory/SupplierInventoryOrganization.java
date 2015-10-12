/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization.Supplier.Inventory;

import Business.Organization.Organization;
import Business.Role.Role;
import Business.Role.Supplier.SupplierInventoryEmployeeRole;
import java.util.ArrayList;

/**
 *
 * @author Manish Gajare
 */
public class SupplierInventoryOrganization extends Organization{
    
    private ProductCatalog productCatalog;

   
    
    
  public SupplierInventoryOrganization() {
        super(Organization.Type.SupplierInventory.getValue());
        productCatalog = new ProductCatalog();
    }

    public ProductCatalog getProductCatalog() {
        return productCatalog;
    }
    


    @Override
    public ArrayList<Role> getSupportedRole() {
  ArrayList<Role> roles = new ArrayList<>();
        roles.add(new SupplierInventoryEmployeeRole());
        return roles;
    }  
    
    
    
}
