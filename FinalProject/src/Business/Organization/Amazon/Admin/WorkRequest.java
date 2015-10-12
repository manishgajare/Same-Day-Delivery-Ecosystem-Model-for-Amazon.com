/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization.Amazon.Admin;

import Business.Customer.CustomerAccount;
import Business.Enterprise.Supplier;
import Business.Organization.Amazon.Finance.Invoice;
import Business.Organization.Amazon.Finance.Payment;
import Business.Organization.Amazon.Sales.OrderItem;
import Business.UserAccount.UserAccount;
import java.util.Calendar;


/**
 *
 * @author Manish Gajare
 */
public class WorkRequest {

    
    private UserAccount finance;
    private UserAccount packagingProcess;
    private UserAccount packaged;
    private UserAccount ShippingProcess;
    private UserAccount Shipped;
    private CustomerAccount customerAccount;
    private Payment payment;
    private String status;
    private Calendar beginningTime;
    private Calendar endingTime;
    private Calendar toBeDeliveredBy;
    private Calendar canBereturnedTill;
    private Calendar returnRequestSet;
    private Calendar returnRequestProcessedSet;
    private UserAccount customerServiceEmployee;
    private CustomerAccount customerServiceRequest;
    private String penalized;
    private OrderItem orderItemToReturn;
    private int orderItemQuantityToReturn;
    private Supplier supplier;
    private CustomerAccount customerAccountRequest;
    private Invoice returnAgainstInvoice;
    private UserAccount returnApproved;
    
    
    public static final String ORDER_PLACED = "Order Placed";
    public static final String UNDER_PROCESS = "Under Processing";
    public static final String PACKAGING_PROCESS = "Packaging Under Progress";
    public static final String PACKAGING_DONE = "Packaging Done";
    public static final String SHIPPING_PROCESS = "Shipping Under Progress";
    public static final String SHIPPING_DONE = "Shipping Done";
    public static final String RETURN_REQUEST = "requested to return";
    public static final String RETURN_REQUEST_APPROVED = "Order Items Received and Refund Transferred";
    
    
    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public CustomerAccount getCustomerAccount() {
        return customerAccount;
    }

    public void setCustomerAccount(CustomerAccount customerAccount) {
        this.customerAccount = customerAccount;
    }

    public UserAccount getFinance() {
        return finance;
    }

    public void setFinance(UserAccount finance) {
        this.finance = finance;
    }

    public UserAccount getPackagingProcess() {
        return packagingProcess;
    }

    public void setPackagingProcess(UserAccount packagingProcess) {
        this.packagingProcess = packagingProcess;
    }

    public UserAccount getPackaged() {
        return packaged;
    }

    public void setPackaged(UserAccount packaged) {
        this.packaged = packaged;
    }

    public UserAccount getShippingProcess() {
        return ShippingProcess;
    }

    public void setShippingProcess(UserAccount ShippingProcess) {
        this.ShippingProcess = ShippingProcess;
    }

    public UserAccount getShipped() {
        return Shipped;
    }

    public void setShipped(UserAccount Shipped) {
        this.Shipped = Shipped;
    }

    public UserAccount getCustomerServiceEmployee() {
        return customerServiceEmployee;
    }

    public void setCustomerServiceEmployee(UserAccount customerServiceEmployee) {
        this.customerServiceEmployee = customerServiceEmployee;
    }

    public CustomerAccount getCustomerServiceRequest() {
        return customerServiceRequest;
    }

    public void setCustomerServiceRequest(CustomerAccount customerServiceRequest) {
        this.customerServiceRequest = customerServiceRequest;
    }

    public Calendar getBeginningTime() {
        return beginningTime;
    }

    public void setBeginningTime(Calendar beginningTime) {
        this.beginningTime = beginningTime;
    }

    public Calendar getEndingTime() {
        return endingTime;
    }

    public void setEndingTime(Calendar endingTime) {
        this.endingTime = endingTime;
    }

    public Calendar getToBeDeliveredBy() {
        return toBeDeliveredBy;
    }

    public void setToBeDeliveredBy(Calendar toBeDeliveredBy) {
        this.toBeDeliveredBy = toBeDeliveredBy;
    }

    public String getPenalized() {
        return penalized;
    }

    public void setPenalized(String penalized) {
        this.penalized = penalized;
    }

    public Calendar getCanBereturnedTill() {
        return canBereturnedTill;
    }

    public void setCanBereturnedTill(Calendar canBereturnedTill) {
        this.canBereturnedTill = canBereturnedTill;
    }

    public OrderItem getOrderItemToReturn() {
        return orderItemToReturn;
    }

    public void setOrderItemToReturn(OrderItem orderItemToReturn) {
        this.orderItemToReturn = orderItemToReturn;
    }

    public int getOrderItemQuantityToReturn() {
        return orderItemQuantityToReturn;
    }

    public void setOrderItemQuantityToReturn(int orderItemQuantityToReturn) {
        this.orderItemQuantityToReturn = orderItemQuantityToReturn;
    }

    public Calendar getReturnRequestSet() {
        return returnRequestSet;
    }

    public void setReturnRequestSet(Calendar returnRequestSet) {
        this.returnRequestSet = returnRequestSet;
    }

    public Calendar getReturnRequestProcessedSet() {
        return returnRequestProcessedSet;
    }

    public void setReturnRequestProcessedSet(Calendar returnRequestProcessedSet) {
        this.returnRequestProcessedSet = returnRequestProcessedSet;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public CustomerAccount getCustomerAccountRequest() {
        return customerAccountRequest;
    }

    public void setCustomerAccountRequest(CustomerAccount customerAccountRequest) {
        this.customerAccountRequest = customerAccountRequest;
    }

    public Invoice getReturnAgainstInvoice() {
        return returnAgainstInvoice;
    }

    public void setReturnAgainstInvoice(Invoice returnAgainstInvoice) {
        this.returnAgainstInvoice = returnAgainstInvoice;
    }

    public UserAccount getReturnApproved() {
        return returnApproved;
    }

    public void setReturnApproved(UserAccount returnApproved) {
        this.returnApproved = returnApproved;
    }

    
    
    
    
    
    

 @Override
    public String toString() {
        return payment.toString();
    }
    
}
