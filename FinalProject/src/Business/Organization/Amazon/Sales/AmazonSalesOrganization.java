/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization.Amazon.Sales;

import Business.Organization.Organization;
import Business.Role.Role;
import Business.Role.Amazon.AmazonSalesEmployeeRole;
import Business.Role.System.SystemAdminRole;
import java.util.ArrayList;

/**
 *
 * @author Manish Gajare
 */
public class AmazonSalesOrganization extends Organization{
 
    MasterOrderCatalog masterOrderCatalog;
    
    public AmazonSalesOrganization() {
        super(Organization.Type.AmazonSales.getValue());
 masterOrderCatalog = new MasterOrderCatalog();
    }

    public MasterOrderCatalog getMasterOrderCatalog() {
        return masterOrderCatalog;
    }
    


    @Override
    public ArrayList<Role> getSupportedRole() {
  ArrayList<Role> roles = new ArrayList<>();
        roles.add(new AmazonSalesEmployeeRole());
        return roles;
    }
    
}
