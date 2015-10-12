/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization.Supplier.Inventory;

/**
 *
 * @author Manish Gajare
 */
public class Product {
    
    private String productId;
    private String name;
    private float price; 
    private int availability;
    private String category;
    private String subCategory;
    private String status;
    
    
    
                public enum ProductCategory{
        Category1("Books & Audible"),
        Category2("Movies, Music & Games"),
        Category3("Electronics & Computers"),
        Category4("Home, Garden & Tools"),
        Category5("Beauty, Health & Grocery"),
        Category6("Toys, Kids & Baby"),
        Category7("Clothing, Shoes & Jewelery"),
        Category8("Sports & Outdoors"),
        Category9("Automotive & Industrial");
        
        private String value;
        private ProductCategory(String value){
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return value;
        }
    }
                
                
                
        public enum Category1{
        SubCategory1("Books"),
        SubCategory2("Kindle Books"),
        SubCategory3("Children's Books"),
        SubCategory4("TextBooks"),
        SubCategory5("Magazines"),
        SubCategory6("Audible AudioBooks & More"),
        SubCategory7("Whispersync for Voice");
                       
        private String value;
        private Category1(String value){
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return value;
        }
    }          
                
         
        
        public enum Category2{
        SubCategory1("Movies & TV"),
        SubCategory2("Blu-ray"),
        SubCategory3("Amazon Instant Video"),
        SubCategory4("Music"),
        SubCategory5("Mp3 Download"),
        SubCategory6("Musical Instruments"),
        SubCategory7("Entertainment Collectibles"),
        SubCategory8("Video Games"),
        SubCategory9("Digital Games");
                       
        private String value;
        private Category2(String value){
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return value;
        }
    }   
                
                
         
        public enum Category3{
        SubCategory1("TV & Video"),
        SubCategory2("Home Audio & Theater"),
        SubCategory3("Camera, Photo & Video"),
        SubCategory4("Cell Phones & Accessories"),
        SubCategory5("Video Games"),
        SubCategory6("MP3 Players & Portable Speakers"),
        SubCategory7("Car Electronics & GPS"),
        SubCategory8("Musical Instruments"),
        SubCategory9("Electronics Accessories"),
        SubCategory10("Laptops & Tablets"),
        SubCategory11("Desktops & Monitors"),
        SubCategory12("Computer Accessories & Peripherals"),
        SubCategory13("Computer Parts & Components"),
        SubCategory14("Software"),
        SubCategory15("PC Games"),
        SubCategory16("Printers & Ink"),
        SubCategory17("Office & School Supplies");
        
                       
        private String value;
        private Category3(String value){
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return value;
        }
    }   
                
                
      public enum Category4{
        SubCategory1("Kitchen & Dining"),
        SubCategory2("Furniture & Decor"),
        SubCategory3("Bedding & Bath"),
        SubCategory4("Appliances"),
        SubCategory5("Patio, Lawn & Garden"),
        SubCategory6("Fine Art"),
        SubCategory7("Arts, Crafts & Sewing"),
        SubCategory8("Pet Supplies"),
        SubCategory9("Home Improvement"),
        SubCategory10("Power & Hand Tools"),
        SubCategory11("Lamps & Light Fixures"),
        SubCategory12("Kitchen & Bath Fixtures"),
        SubCategory13("Hardware"),
        SubCategory14("Home Automation");
        
        private String value;
        private Category4(String value){
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return value;
        }
    }             
                
                
                
          public enum Category5{
        SubCategory1("All Beauty"),
        SubCategory2("Luxury Beauty"),
        SubCategory3("Men's Grooming"),
        SubCategory4("Health, Household & Baby Care"),
        SubCategory5("Grocery & Gourmet Food"),
        SubCategory6("Natural & Organic"),
        SubCategory7("Fresh Flowers"),
        SubCategory8("Wine"),
        SubCategory9("Amazon Fresh");
                       
        private String value;
        private Category5(String value){
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return value;
        }
    }         
                
                
       public enum Category6{
        SubCategory1("Toys & Games"),
        SubCategory2("Baby"),
        SubCategory3("Kids' Clothing"),
        SubCategory4("Baby Clothing"),
        SubCategory5("Video Games for Kids"),
        SubCategory6("Amazon Mom"),
        SubCategory7("Baby Registry"),
        SubCategory8("Kids' Birthdays");
                       
        private String value;
        private Category6(String value){
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return value;
        }
    }            
                
    
       
       public enum Category7{
        SubCategory1("Clothing"),
        SubCategory2("Shoes"),
        SubCategory3("Handbags"),
        SubCategory4("Accessories"),
        SubCategory5("Luggage"),
        SubCategory6("Jewelry"),
        SubCategory7("Watches");
        
        private String value;
        private Category7(String value){
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return value;
        }
    }   
       
       
       
       public enum Category8{
        SubCategory1("Exercise & Fitness"),
        SubCategory2("Outdoor Gear"),
        SubCategory3("Hunting & Fishing"),
        SubCategory4("Cycling"),
        SubCategory5("Athletic & Outdoor Clothng"),
        SubCategory6("Boating & Water Sports"),
        SubCategory7("Team Sports"),
        SubCategory8("Fan Shop"),
        SubCategory9("Sports Collectibles"),
        SubCategory10("Golf"),
        SubCategory11("All Sports & Outdoors");
                       
        private String value;
        private Category8(String value){
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return value;
        }
    }   
       
       
       
       public enum Category9{
        SubCategory1("Automotive Parts & Accessories"),
        SubCategory2("Automotive Tools & Equipment"),
        SubCategory3("Car/Vehicle Electronics & GPS"),
        SubCategory4("Tires & Wheels"),
        SubCategory5("Motorcycle & Powersports"),
        SubCategory6("Industrial Supplies"),
        SubCategory7("Lab & Scientific"),
        SubCategory8("Janitrial"),
        SubCategory9("Safety");
                       
        private String value;
        private Category9(String value){
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return value;
        }
    }   
       
    
    

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getAvailability() {
        return availability;
    }

    public void setAvailability(int availability) {
        this.availability = availability;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(String subCategory) {
        this.subCategory = subCategory;
    }
    
    
    
    
    
    @Override
    public String toString() {
        return name;
    }
    
    
}
