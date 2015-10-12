/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role.Amazon;

import Business.DB4OUtil.DB4OUtil;
import Business.EcoSystem;
import Business.Enterprise.Amazon;
import Business.Enterprise.Enterprise;
import Business.Organization.Amazon.CustomerService.AmazonCustomerServiceOrganization;
import Business.Organization.Organization;
import Business.Role.Role;
import Business.UserAccount.UserAccount;
import Interface.Amazon.CustomerService.AmazonCustomerServiceEmployeeWorkAreaJPanel;
import javax.swing.JPanel;

/**
 *
 * @author Manish Gajare
 */
public class AmazonCustomerServiceEmployeeRole extends Role{

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem system,DB4OUtil db4OUtil,Amazon amazonEnterprise) {
        return new AmazonCustomerServiceEmployeeWorkAreaJPanel(userProcessContainer, account, (AmazonCustomerServiceOrganization)organization);
   }
    
}
