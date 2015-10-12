/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization.Amazon.Inventory;

import Business.Enterprise.Supplier;
import Business.Organization.Supplier.Inventory.Product;
import Business.Organization.Supplier.Inventory.ProductCatalog;
import java.util.ArrayList;

/**
 *
 * @author Manish Gajare
 */
public class ProductCatalogList {
    
    private ArrayList<ProductCatalog> productCatalogList;

    public ProductCatalogList() {
        productCatalogList = new ArrayList<>();
    }

    public ArrayList<ProductCatalog> getProductCatalogList() {
        return productCatalogList;
    }
    
    
    
    public ProductCatalog createAndAddProduct(ArrayList<Product> productList,Supplier supplier){
        
        ProductCatalog productCatalog = new ProductCatalog();
        productCatalog.setProductList(productList);
        productCatalog.setSupplier(supplier);
        productCatalogList.add(productCatalog);
        return productCatalog;
    }
    
}
