/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization.Amazon.Finance;

import Business.Organization.Amazon.Sales.Order;
import Business.Organization.Amazon.Sales.OrderItem;
import java.util.ArrayList;

/**
 *
 * @author Manish Gajare
 */
public class Invoice {
    
    
    private String invoiceID;
    private String status;
    private Order order;
    private ArrayList<OrderItem> orderItem;
    private OrderItem orderItemToReturn;
    private double amount;
    private String shippingAddress;
    
    public ArrayList<OrderItem> getOrderItem() {
    
        return orderItem;
    }

    public void setOrderItem(ArrayList<OrderItem> orderItem) {
        this.orderItem = orderItem;
    }
    
    
    public String getInvoiceID() {
        return invoiceID;
    }

    public void setInvoiceID(String invoiceID) {
        this.invoiceID = invoiceID;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public OrderItem getOrderItemToReturn() {
        return orderItemToReturn;
    }

    public void setOrderItemToReturn(OrderItem orderItemToReturn) {
        this.orderItemToReturn = orderItemToReturn;
    }
    
    
    
    @Override
    public String toString(){
        return invoiceID;
    }

    
    
}
