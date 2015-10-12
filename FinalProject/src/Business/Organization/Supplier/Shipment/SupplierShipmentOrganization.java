/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization.Supplier.Shipment;

import Business.Organization.Organization;
import Business.Role.Role;
import Business.Role.Supplier.SupplierShipmentEmployeeRole;
import java.util.ArrayList;

/**
 *
 * @author Manish Gajare
 */
public class SupplierShipmentOrganization extends Organization{
    
    
    public SupplierShipmentOrganization() {
        super(Organization.Type.SupplierShipment.getValue());
    }
    


    @Override
    public ArrayList<Role> getSupportedRole() {
  ArrayList<Role> roles = new ArrayList<>();
        roles.add(new SupplierShipmentEmployeeRole());
        return roles;
    }
    
    
}
