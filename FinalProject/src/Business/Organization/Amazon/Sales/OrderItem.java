/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization.Amazon.Sales;

import Business.Enterprise.Supplier;
import Business.Organization.Supplier.Inventory.Product;

/**
 *
 * @author Manish Gajare
 */
public class OrderItem {
    
    
    Product product;
    int quantity;
    float price;
    float tax;
    double commision;
    Supplier supplier;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    
    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public float getTax() {
        return tax;
    }

    public void setTax(float tax) {
        this.tax = tax;
    }

    public double getCommision() {
        return commision;
    }

    public void setCommision(double commision) {
        this.commision = commision;
    }
  
    

    public double getOrderItemTotal(){
        return (getPrice()*getQuantity())+getTax();
    }
    
    
@Override
    public String toString() {
        return product.toString();
    }
   
    

    
    
}
