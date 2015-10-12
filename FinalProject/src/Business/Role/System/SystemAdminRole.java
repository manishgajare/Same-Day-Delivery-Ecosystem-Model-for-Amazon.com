/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role.System;

import Business.DB4OUtil.DB4OUtil;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.Organization.System.SystemAdminOrganization;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;
import Business.EcoSystem;
import Business.Enterprise.Amazon;
import Business.Role.Role;
import Interface.System.SystemAdminWorkAreaJPanel;

/**
 *
 * @author Manish Gajare
 */
public class SystemAdminRole extends Role {

  
    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem system,DB4OUtil db4OUtil,Amazon amazonEnterprise) {
        return new SystemAdminWorkAreaJPanel(userProcessContainer, account, (SystemAdminOrganization)organization, enterprise,system,db4OUtil);
   }
    
}

