/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization.Supplier.Sales;

import Business.Organization.Organization;
import Business.Role.Role;
import Business.Role.Supplier.SupplierSalesEmployeeRole;
import java.util.ArrayList;

/**
 *
 * @author Manish Gajare
 */
public class SupplierSalesOrganization extends Organization{
    
    
        public SupplierSalesOrganization() {
        super(Organization.Type.SupplierSales.getValue());
    }
    


    @Override
    public ArrayList<Role> getSupportedRole() {
  ArrayList<Role> roles = new ArrayList<>();
        roles.add(new SupplierSalesEmployeeRole());
        return roles;
    }
   
    
    
}
