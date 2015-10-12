/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization.Amazon.Sales;

import Business.Customer.CustomerAccount;
import java.security.Timestamp;
import java.util.ArrayList;

/**
 *
 * @author Manish Gajare
 */
public class Order {
    
    private int orderId;
    private CustomerAccount customerAccount;
    private ArrayList<OrderItem> orderItemList;

    public Order() {
        orderItemList = new ArrayList<>();
    }

 
    
    
    
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public CustomerAccount getCustomerAccount() {
        return customerAccount;
    }

    public void setCustomerAccount(CustomerAccount customerAccount) {
        this.customerAccount = customerAccount;
    }

    public ArrayList<OrderItem> getOrderItemList() {
        return orderItemList;
    }

    public void setOrderItemList(ArrayList<OrderItem> orderItemList) {
        this.orderItemList = orderItemList;
    }

   
    
    
    public double getOrderTotal(){
        double total=0;
        for(OrderItem orderItem:orderItemList){
            total = total + orderItem.getOrderItemTotal();
        }
        return total;
    }
    
       public OrderItem createOrderItem()
    {
      OrderItem oit=new OrderItem();
      orderItemList.add(oit);
      return oit;
    }
       
       public void removeOrderItem(OrderItem oi){
           orderItemList.remove(oi);
       }
    
   
}
