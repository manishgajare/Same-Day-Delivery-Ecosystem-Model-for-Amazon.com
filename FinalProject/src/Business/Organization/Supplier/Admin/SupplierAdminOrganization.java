/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization.Supplier.Admin;

import Business.Organization.Organization;
import Business.Role.Role;
import Business.Role.Supplier.SupplierAdminRole;
import java.util.ArrayList;

/**
 *
 * @author Manish Gajare
 */
public class SupplierAdminOrganization extends Organization{
  
    
    
     public SupplierAdminOrganization() {
        super(Organization.Type.SupplierAdmin.getValue());
    }
    


    @Override
    public ArrayList<Role> getSupportedRole() {
  ArrayList<Role> roles = new ArrayList<>();
        roles.add(new SupplierAdminRole());
        return roles;
    }
    
    
}
