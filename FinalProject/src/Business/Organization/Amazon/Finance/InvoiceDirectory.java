/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization.Amazon.Finance;

import java.util.ArrayList;

/**
 *
 * @author Manish Gajare
 */
public class InvoiceDirectory {
    
     ArrayList<Invoice> invoiceDirectory=new ArrayList<Invoice>();

    public ArrayList<Invoice> getInvoiceDirectory() {
        return invoiceDirectory;
    }

    public void setInvoiceDirectory(ArrayList<Invoice> invoiceDirectory) {
        this.invoiceDirectory = invoiceDirectory;
    }

     
    
    public Invoice createAndAddInvoice()
    {
        Invoice invoice=new Invoice();
        invoiceDirectory.add(invoice);
        return invoice;
    }
    
    
    
    
}
