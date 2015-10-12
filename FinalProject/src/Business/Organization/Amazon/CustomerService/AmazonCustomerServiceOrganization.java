/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization.Amazon.CustomerService;

import Business.Organization.Organization;
import Business.Role.Amazon.AmazonCustomerServiceEmployeeRole;
import Business.Role.Role;
import Business.Role.System.SystemAdminRole;
import java.util.ArrayList;

/**
 *
 * @author Manish Gajare
 */
public class AmazonCustomerServiceOrganization extends Organization{
    
    public AmazonCustomerServiceOrganization() {
        super(Organization.Type.AmazonCustomerService.getValue());
    }
    


    @Override
    public ArrayList<Role> getSupportedRole() {
  ArrayList<Role> roles = new ArrayList<>();
        roles.add(new AmazonCustomerServiceEmployeeRole());
        return roles;
    }
    
}
