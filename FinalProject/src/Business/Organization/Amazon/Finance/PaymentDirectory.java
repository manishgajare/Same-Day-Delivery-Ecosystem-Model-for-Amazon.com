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
public class PaymentDirectory {
    
    ArrayList<Payment> paymentDirectory=new ArrayList<Payment>();

    public ArrayList<Payment> getPaymentDirectory() {
        return paymentDirectory;
    }

    public void setPaymentDirectory(ArrayList<Payment> paymentDirectory) {
        this.paymentDirectory = paymentDirectory;
    }

    
    
    
}
