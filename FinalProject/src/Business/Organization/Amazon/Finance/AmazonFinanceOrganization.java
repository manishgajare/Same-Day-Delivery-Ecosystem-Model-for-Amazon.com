/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization.Amazon.Finance;

import Business.Organization.Organization;
import Business.Role.Amazon.AmazonFinanceEmployeeRole;
import Business.Role.Role;
import Business.Role.System.SystemAdminRole;
import java.util.ArrayList;

/**
 *
 * @author Manish Gajare
 */
public class AmazonFinanceOrganization extends Organization{
    
    
    InvoiceDirectory invoiceDirectory;
    PaymentDirectory paymentDirectory;
    
    public AmazonFinanceOrganization() {
        super(Organization.Type.AmazonFinance.getValue());
        invoiceDirectory = new InvoiceDirectory();
        paymentDirectory = new PaymentDirectory();
    }

    public InvoiceDirectory getInvoiceDirectory() {
        return invoiceDirectory;
    }

    public PaymentDirectory getPaymentDirectory() {
        return paymentDirectory;
    }
    


    @Override
    public ArrayList<Role> getSupportedRole() {
  ArrayList<Role> roles = new ArrayList<>();
        roles.add(new AmazonFinanceEmployeeRole());
        return roles;
    }
    
}
