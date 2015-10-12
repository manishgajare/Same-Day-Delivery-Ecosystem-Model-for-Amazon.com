/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization.System;

import Business.Organization.Organization;
import Business.Role.Role;
import Business.Role.System.SystemAdminRole;
import java.util.ArrayList;

/**
 *
 * @author Manish Gajare
 */
public class SystemAdminOrganization extends Organization{
    
    
    
    
    public SystemAdminOrganization() {
        super(Organization.Type.SystemAdmin.getValue());
    }
    


    @Override
    public ArrayList<Role> getSupportedRole() {
  ArrayList<Role> roles = new ArrayList<>();
        roles.add(new SystemAdminRole());
        return roles;
    }
}
