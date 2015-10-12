/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization.Amazon.Sales;

import java.util.ArrayList;

/**
 *
 * @author Manish Gajare
 */
public class MasterOrderCatalog {
    ArrayList<Order> masterOrderDirectory=new  ArrayList<Order>();

    public ArrayList<Order> getOrders() {
        return masterOrderDirectory;
    }

    public void setOrders(ArrayList<Order> orders) {
        this.masterOrderDirectory = orders;
    }
    
    public Order createOrder()
    {
        Order o=new Order();
        masterOrderDirectory.add(o);
        return o;
    }
    
    public void addOrder(Order order)
    {
        masterOrderDirectory.add(order);
    }  
    
    
    
}
