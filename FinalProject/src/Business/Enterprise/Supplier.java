/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author Manish Gajare
 */
public class Supplier extends Enterprise{
    
    private String zipcode;
    private int id;
    private float tax;
    
    
    
    
     public Supplier(String name) {
        super(name, Enterprise.EnterpriseType.SUPPLIER);
        
        
        
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        return null;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getTax() {
        return tax;
    }

    public void setTax(float tax) {
        this.tax = tax;
    }

    
    
    
    
    
    
}
