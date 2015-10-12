/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization.Amazon.Finance;

/**
 *
 * @author Manish Gajare
 */
public class Payment {
    
    
    private Invoice invoice;
    private String paymentType;
    private String invoiceFor;
    private int confirmationNumber;
    
    public static final String InAmazonFromCustomer = "customer buying products";
    public static final String InAmazonFromSupplierProduct = "supplier returning money of product to amazons";
    public static final String InAmazonFromSupplierPenalty = "late shippment of product";
    public static final String InSupplierFromAmazon= "shippment of product";
    public static final String InCustomerFromAmazon = "amazon returning money of product to customer";
    

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public String getInvoiceFor() {
        return invoiceFor;
    }

    public void setInvoiceFor(String invoiceFor) {
        this.invoiceFor = invoiceFor;
    }

    public int getConfirmationNumber() {
        return confirmationNumber;
    }

    public void setConfirmationNumber(int confirmationNumber) {
        this.confirmationNumber = confirmationNumber;
    }

    @Override
    public String toString() {
        return invoice.toString();
    }
    
    
    
    
}
