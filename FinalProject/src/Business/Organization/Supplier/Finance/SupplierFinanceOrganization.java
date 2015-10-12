/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization.Supplier.Finance;

import Business.Organization.Organization;
import Business.Role.Role;
import Business.Role.Supplier.SupplierFinanceEmployeeRole;
import java.util.ArrayList;

/**
 *
 * @author Manish Gajare
 */
public class SupplierFinanceOrganization extends Organization{
    
    
    public SupplierFinanceOrganization() {
        super(Organization.Type.SupplierFinance.getValue());
    }
    


    @Override
    public ArrayList<Role> getSupportedRole() {
  ArrayList<Role> roles = new ArrayList<>();
        roles.add(new SupplierFinanceEmployeeRole());
        return roles;
    }
    
    
}
