/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization.Supplier.Inventory;

import Business.Enterprise.Supplier;
import java.util.ArrayList;

/**
 *
 * @author Manish Gajare
 */
public class ProductCatalog {
    
    private ArrayList<Product> productList;
    private Supplier supplier;
    

    public ProductCatalog() {
        productList = new ArrayList<>();
    }

    public ArrayList<Product> getProductList() {
        return productList;
    }

    public void setProductList(ArrayList<Product> productList) {
        this.productList = productList;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

public void removeProduct(Product p){
        productList.remove(p);
    }
    
    
    
    public Product createAndAddProduct(String productId, String name, float price, int availability,String status,String category,String subCategory){
     
       Product product = new Product();
       product.setProductId(productId);
       product.setName(name);
       product.setPrice(price);
       product.setAvailability(availability);
       product.setStatus(status);
       product.setCategory(category);
       product.setSubCategory(subCategory);
       productList.add(product);
       return product;
     
    }
    
    
    
    
    
    
}
