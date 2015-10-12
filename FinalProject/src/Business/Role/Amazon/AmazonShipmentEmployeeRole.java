/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role.Amazon;

import Business.DB4OUtil.DB4OUtil;
import Business.EcoSystem;
import Business.Enterprise.Amazon;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.Organization.Amazon.Shipment.AmazonShipmentOrganization;
import Business.Role.Role;
import Business.UserAccount.UserAccount;
import Interface.Amazon.Shipment.AmazonShipmentEmployeeWorkAreaJPanel;
import javax.swing.JPanel;

/**
 *
 * @author Manish Gajare
 */
public class AmazonShipmentEmployeeRole extends Role{
    
    
    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem system,DB4OUtil db4OUtil,Amazon amazonEnterprise) {
        return new AmazonShipmentEmployeeWorkAreaJPanel(userProcessContainer, account, (AmazonShipmentOrganization)organization);
    }
    
    
    
}
