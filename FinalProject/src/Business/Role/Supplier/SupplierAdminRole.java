/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role.Supplier;

import Business.DB4OUtil.DB4OUtil;
import Business.EcoSystem;
import Business.Enterprise.Amazon;
import Business.Enterprise.Enterprise;
import Business.Enterprise.Supplier;
import Business.Organization.Organization;
import Business.Organization.Supplier.Admin.SupplierAdminOrganization;
import Business.Role.Role;
import Business.UserAccount.UserAccount;
import Interface.Supplier.Admin.SupplierAdminWorkAreaJPanel;
import javax.swing.JPanel;

/**
 *
 * @author Manish Gajare
 */
public class SupplierAdminRole extends Role {

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem system,DB4OUtil db4OUtil,Amazon amazonEnterprise) {
        return new SupplierAdminWorkAreaJPanel(userProcessContainer, account, (SupplierAdminOrganization)organization, (Supplier)enterprise,system);
    }
    
}
