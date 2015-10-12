/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization.Amazon.Shipment;

import Business.Organization.Organization;
import Business.Role.Role;
import Business.Role.Amazon.AmazonShipmentEmployeeRole;
import java.util.ArrayList;

/**
 *
 * @author Manish Gajare
 */
public class AmazonShipmentOrganization extends Organization{
    
    
     public AmazonShipmentOrganization() {
        super(Organization.Type.AmazonShipment.getValue());
    }
    


    @Override
    public ArrayList<Role> getSupportedRole() {
  ArrayList<Role> roles = new ArrayList<>();
        roles.add(new AmazonShipmentEmployeeRole());
        return roles;
    }
    
    
    
}
