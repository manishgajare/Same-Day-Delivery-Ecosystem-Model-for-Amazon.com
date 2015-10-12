/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;


import Business.Organization.Amazon.Admin.AmazonAdminOrganization;
import Business.Organization.Amazon.CustomerService.AmazonCustomerServiceOrganization;
import Business.Organization.Amazon.Finance.AmazonFinanceOrganization;
import Business.Organization.Amazon.Sales.AmazonSalesOrganization;
import Business.Organization.Amazon.Shipment.AmazonShipmentOrganization;
import Business.Organization.Amazon.Inventory.AmazonInventoryOrganization;
import Business.Organization.Organization.Type;
import Business.Organization.Supplier.Inventory.SupplierInventoryOrganization;
import Business.Organization.Supplier.Admin.SupplierAdminOrganization;
import Business.Organization.Supplier.Finance.SupplierFinanceOrganization;
import Business.Organization.Supplier.Sales.SupplierSalesOrganization;
import Business.Organization.Supplier.Shipment.SupplierShipmentOrganization;
import Business.Organization.System.SystemAdminOrganization;
import java.util.ArrayList;

/**
 *
 * @author Manish Gajare
 */
public class OrganizationDirectory {
   
    
       private ArrayList<Organization> organizationList;

    public OrganizationDirectory() {
        organizationList = new ArrayList<>();
    }

    public ArrayList<Organization> getOrganizationList() {
        return organizationList;
    }
    
    public Organization createOrganization(Type type){
        Organization organization = null;
        
        
 
        if (type.getValue().equals(Type.SystemAdmin.getValue())){
            organization = new SystemAdminOrganization();
            organizationList.add(organization);
        }
        
        else if (type.getValue().equals(Type.AmazonAdmin.getValue())){
            organization = new AmazonAdminOrganization();
            organizationList.add(organization);
        }
        
        else if (type.getValue().equals(Type.SupplierAdmin.getValue())){
            organization = new SupplierAdminOrganization();
            organizationList.add(organization);
        }
        
        else if (type.getValue().equals(Type.AmazonSales.getValue())){
            organization = new AmazonSalesOrganization();
            organizationList.add(organization);
        }
        
        else if (type.getValue().equals(Type.AmazonFinance.getValue())){
            organization = new AmazonFinanceOrganization();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.AmazonCustomerService.getValue())){
            organization = new AmazonCustomerServiceOrganization();
            organizationList.add(organization);
        }
        
        else if (type.getValue().equals(Type.AmazonInventory.getValue())){
            organization = new AmazonInventoryOrganization();
            organizationList.add(organization);
        }
            
        else if (type.getValue().equals(Type.AmazonShipment.getValue())){
            organization = new AmazonShipmentOrganization();
            organizationList.add(organization);
        }
        
        else if (type.getValue().equals(Type.SupplierSales.getValue())){
            organization = new SupplierSalesOrganization();
            organizationList.add(organization);
        }
        
        else if (type.getValue().equals(Type.SupplierFinance.getValue())){
            organization = new SupplierFinanceOrganization();
            organizationList.add(organization);
        }
        
        else if (type.getValue().equals(Type.SupplierInventory.getValue())){
            organization = new SupplierInventoryOrganization();
            organizationList.add(organization);
        }
            
        else if (type.getValue().equals(Type.SupplierShipment.getValue())){
            organization = new SupplierShipmentOrganization();
            organizationList.add(organization);
        }
        
        
        return organization;
    }
    
    
}
