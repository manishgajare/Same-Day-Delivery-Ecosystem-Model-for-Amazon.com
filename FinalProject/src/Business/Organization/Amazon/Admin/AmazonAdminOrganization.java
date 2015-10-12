/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization.Amazon.Admin;


import Business.Organization.Organization;
import Business.Role.Amazon.AmazonAdminRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author Manish Gajare
 */
public class AmazonAdminOrganization extends Organization{
 
   WorkQueue workQueue;
            
    public AmazonAdminOrganization() {
        super(Organization.Type.AmazonAdmin.getValue());
        workQueue = new WorkQueue();
    }

    public WorkQueue getWorkQueue() {
        return workQueue;
    }




    @Override
    public ArrayList<Role> getSupportedRole() {
  ArrayList<Role> roles = new ArrayList<>();
        roles.add(new AmazonAdminRole());
        return roles;
    }

    
    
    
    
}
