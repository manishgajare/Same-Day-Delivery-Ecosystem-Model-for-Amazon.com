/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.Market;

import Business.DB4OUtil.DB4OUtil;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Enterprise.Supplier;
import Business.Network.CountryNetwork;
import Business.Network.RegionNetwork;
import Business.Network.StateNetwork;
import Business.Organization.Amazon.Sales.Order;
import Business.Organization.Amazon.Sales.OrderItem;
import Business.Organization.Supplier.Inventory.Product;
import Business.Organization.Supplier.Inventory.SupplierInventoryOrganization;
import Interface.MainJFrame;
import java.awt.CardLayout;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

/**
 *
 * @author Manish Gajare
 */
public class BrowseJPanel extends javax.swing.JPanel {

    /**
     * Creates new form BrowseJPanel
     */
    
    JPanel userProcessContainer;
    EcoSystem system;
    DB4OUtil db4OUtil;
    String categoryName;
    String subCategoryName;
    ArrayList<Integer> supplierIdList;
    Order order = new Order();
    String country;
    String state;
    String region;
    String zipcode;
    
    
    public BrowseJPanel(JPanel userProcessContainer, EcoSystem system, DB4OUtil db4OUtil) {
        initComponents();
        
        this.system = system;
        this.userProcessContainer = userProcessContainer;
        this.db4OUtil = db4OUtil;
        
        
        numberOfItemsJComboBox.setEnabled(false);
        addToCartJButton.setEnabled(false);
        checkoutJButton.setEnabled(false);
        
    }
    
    
    public void populateComboBox(){
        
        
       
        
        int count = Integer.parseInt(productsJTable.getValueAt(productsJTable.getSelectedRow(), 2).toString());
        
        
        
        numberOfItemsJComboBox.removeAllItems();
        
        int addedCount = 0;
        for(int i=0;i<cartJTable.getRowCount();i++){

        if(cartJTable.getValueAt(i, 1).equals(productsJTable.getValueAt(productsJTable.getSelectedRow(), 1)))
        {
            addedCount = Integer.parseInt(cartJTable.getValueAt(i, 2).toString());
        }   
        
    }
        
       
        for(int i=1;i<=count-addedCount;i++){
            numberOfItemsJComboBox.addItem(i);
        }   
     
        
        if(count-addedCount==0){
            numberOfItemsJComboBox.setEnabled(false);
            addToCartJButton.setEnabled(false);
        }else{
            numberOfItemsJComboBox.setEnabled(true);
            addToCartJButton.setEnabled(true);
        }
        
        
    }
    
    
  public void populateProductsJTable()
{
    
    int rowCount = productsJTable.getRowCount();
        for(int i=rowCount-1; i>=0; i--){
            ((DefaultTableModel)productsJTable.getModel()).removeRow(i);
        }
 
    for (CountryNetwork countryNetwork : system.getCountryNetworkList()) {
    for (StateNetwork stateNetwork : countryNetwork.getStateNetworkList()) {
    for (RegionNetwork regionNetwork : stateNetwork.getRegionNetworkList()) {
    for (Enterprise enterprise : regionNetwork.getEnterpriseDirectory().getEnterpriseList()) {
        if(enterprise instanceof Supplier){
            Supplier supplier = (Supplier)enterprise;
            
       for(int i=0;i<supplierIdList.size();i++){
       if(supplier.getId()==supplierIdList.get(i)){
 
           
        for(int j=0;enterprise.getOrganizationDirectory().getOrganizationList().size()>j;j++){
            
            
            
        
         if(supplier.getOrganizationDirectory().getOrganizationList().get(j) instanceof SupplierInventoryOrganization){   
            SupplierInventoryOrganization inventoryOrganization = (SupplierInventoryOrganization)enterprise.getOrganizationDirectory().getOrganizationList().get(j);
        for(int k=0;inventoryOrganization.getProductCatalog().getProductList().size()>k;k++){
            
            
            
       
            
            
            if(inventoryOrganization.getProductCatalog().getProductList().get(k).getCategory().toString().equals(this.categoryName) && inventoryOrganization.getProductCatalog().getProductList().get(k).getSubCategory().toString().equals(this.subCategoryName))
            {
                Product p = inventoryOrganization.getProductCatalog().getProductList().get(k);
   
                Object row[] = new Object[5];
                row[0] = p.getProductId();
                row[1] = p;
                row[2] = p.getAvailability();
                row[3] = p.getPrice();
                row[4] = supplier;
               
            ((DefaultTableModel)productsJTable.getModel()).addRow(row); 
                
            }
            
            
          
            
            
            
        }
           
        }   
        
       }
     
       }         
       }
       
    }
    }
    }
    }
    }
    
    
    
    
}
  
    
    
    public void populateCategoryJTree()
    {
       
        DefaultTreeModel model = (DefaultTreeModel)categoryJTree.getModel();
        
        DefaultMutableTreeNode root =  (DefaultMutableTreeNode) model.getRoot();
        
          root.removeAllChildren();
          
          
        
        
        
        for(int i=1;i<=Product.ProductCategory.values().length;i++){
        DefaultMutableTreeNode categoryNode = new DefaultMutableTreeNode(Product.ProductCategory.valueOf("Category"+i));
        root.insert(categoryNode, i-1);
        }
        
        model.reload();
        
        
    }
    
    public void populateSubCategoryJTree()
    {   
        
     DefaultTreeModel model = (DefaultTreeModel)subCategoryJTree.getModel();
        
     DefaultMutableTreeNode root =  (DefaultMutableTreeNode) model.getRoot();
        
     root.removeAllChildren();
          
      String selectedCategoryvalue = categoryJTree.getSelectionPath().getLastPathComponent().toString();
      String selectedCategoryName=null;
        for(int i=1;i<=Product.ProductCategory.values().length;i++){
            if(Product.ProductCategory.valueOf("Category"+i).toString().equals(selectedCategoryvalue)){
                selectedCategoryName = "Category"+i;
            }
        }
        
        
        
        
      
        if(selectedCategoryName.equals("Category1")){
        for(int i=1;i<=Product.Category1.values().length;i++){
        DefaultMutableTreeNode subCategoryNode = new DefaultMutableTreeNode(Product.Category1.valueOf("SubCategory"+i));
        root.insert(subCategoryNode, i-1);
        }
        }
        else if(selectedCategoryName.equals("Category2")){
        for(int i=1;i<=Product.Category2.values().length;i++){
        DefaultMutableTreeNode subCategoryNode = new DefaultMutableTreeNode(Product.Category2.valueOf("SubCategory"+i));
        root.insert(subCategoryNode, i-1);
        }
        }
        else if(selectedCategoryName.equals("Category3")){
        for(int i=1;i<=Product.Category3.values().length;i++){
        DefaultMutableTreeNode subCategoryNode = new DefaultMutableTreeNode(Product.Category3.valueOf("SubCategory"+i));
        root.insert(subCategoryNode, i-1);
        }
        }
        else if(selectedCategoryName.equals("Category4")){
        for(int i=1;i<=Product.Category4.values().length;i++){
        DefaultMutableTreeNode subCategoryNode = new DefaultMutableTreeNode(Product.Category4.valueOf("SubCategory"+i));
        root.insert(subCategoryNode, i-1);
        }
        }
        else if(selectedCategoryName.equals("Category5")){
        for(int i=1;i<=Product.Category5.values().length;i++){
        DefaultMutableTreeNode subCategoryNode = new DefaultMutableTreeNode(Product.Category5.valueOf("SubCategory"+i));
        root.insert(subCategoryNode, i-1);
        }
        }
        else if(selectedCategoryName.equals("Category6")){
        for(int i=1;i<=Product.Category6.values().length;i++){
        DefaultMutableTreeNode subCategoryNode = new DefaultMutableTreeNode(Product.Category6.valueOf("SubCategory"+i));
        root.insert(subCategoryNode, i-1);
        }
        }
        else if(selectedCategoryName.equals("Category7")){
        for(int i=1;i<=Product.Category7.values().length;i++){
        DefaultMutableTreeNode subCategoryNode = new DefaultMutableTreeNode(Product.Category7.valueOf("SubCategory"+i));
        root.insert(subCategoryNode, i-1);
        }
        }
        else if(selectedCategoryName.equals("Category8")){
        for(int i=1;i<=Product.Category8.values().length;i++){
        DefaultMutableTreeNode subCategoryNode = new DefaultMutableTreeNode(Product.Category8.valueOf("SubCategory"+i));
        root.insert(subCategoryNode, i-1);
        }
        }
        else if(selectedCategoryName.equals("Category9")){
        for(int i=1;i<=Product.Category9.values().length;i++){
        DefaultMutableTreeNode subCategoryNode = new DefaultMutableTreeNode(Product.Category9.valueOf("SubCategory"+i));
        root.insert(subCategoryNode, i-1);
        }
        }
     
        model.reload();
        
        this.categoryName = selectedCategoryName;
        
        
        
        
        
        
        
        
        
    }
    
    
    
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        zipcodeJLabel = new javax.swing.JLabel();
        zipcodeJTextField = new javax.swing.JTextField();
        continueJButton = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        productsJTable = new javax.swing.JTable();
        numberOfItemsJComboBox = new javax.swing.JComboBox();
        addToCartJButton = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        cartJTable = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        categoryJTree = new javax.swing.JTree();
        jScrollPane2 = new javax.swing.JScrollPane();
        subCategoryJTree = new javax.swing.JTree();
        checkoutJButton = new javax.swing.JButton();
        searchJButton = new javax.swing.JButton();
        clearAllJButton = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Browse Products");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 40, -1, -1));

        zipcodeJLabel.setText("zipcode");
        add(zipcodeJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, -1, 30));

        zipcodeJTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                zipcodeJTextFieldKeyTyped(evt);
            }
        });
        add(zipcodeJTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 110, 106, 30));

        continueJButton.setText("Continue");
        continueJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                continueJButtonActionPerformed(evt);
            }
        });
        add(continueJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 110, -1, -1));

        productsJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product ID", "Name", "Items Available", "Price", "Supplier"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        productsJTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                productsJTableMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(productsJTable);

        add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 190, 760, 120));

        numberOfItemsJComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numberOfItemsJComboBoxActionPerformed(evt);
            }
        });
        add(numberOfItemsJComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 340, 70, -1));

        addToCartJButton.setText("Add To Cart");
        addToCartJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addToCartJButtonActionPerformed(evt);
            }
        });
        add(addToCartJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 340, 110, -1));

        cartJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product ID", "Name", "Quantity", "Price", "Supplier"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        cartJTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cartJTableMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(cartJTable);

        add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 420, 760, 140));

        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("Category");
        categoryJTree.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        categoryJTree.setRootVisible(false);
        categoryJTree.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
            public void valueChanged(javax.swing.event.TreeSelectionEvent evt) {
                categoryJTreeValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(categoryJTree);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 200, 430));

        treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("SubCategory");
        subCategoryJTree.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        subCategoryJTree.setRootVisible(false);
        subCategoryJTree.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
            public void valueChanged(javax.swing.event.TreeSelectionEvent evt) {
                subCategoryJTreeValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(subCategoryJTree);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 160, 190, 430));

        checkoutJButton.setText("Checkout");
        checkoutJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkoutJButtonActionPerformed(evt);
            }
        });
        add(checkoutJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 600, 100, -1));

        searchJButton.setText("Search");
        searchJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchJButtonActionPerformed(evt);
            }
        });
        add(searchJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 110, -1, -1));

        clearAllJButton.setText("Clear All");
        clearAllJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearAllJButtonActionPerformed(evt);
            }
        });
        add(clearAllJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 110, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void continueJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_continueJButtonActionPerformed

        
        
        
        
        
        int count = 0;
        if(zipcodeJTextField.getText().isEmpty()){
        count++;    
        }
        
        if(count==0){
            
            
            
            
            
            
            
            
            
            
          int zipcodeCheck=0;  
            
            
        
       this.zipcode = zipcodeJTextField.getText();
       
        
        zipcodeJTextField.setEnabled(false);
        continueJButton.setEnabled(false);
        

        String zipcode = null;
        double longitude=0;
        double latitude=0;
        ArrayList<Integer> supplierIdList = new ArrayList<>();

        try
        {

            zipcode = zipcodeJTextField.getText();

            Scanner fileReader = new Scanner(new File("USA.txt"));
            Scanner lineReader;

            while(fileReader.hasNext()) {

                String info = fileReader.nextLine();

                lineReader = new Scanner(info);
                lineReader.useDelimiter(",");

                //here is what we are getting in from the text doc
                String zipDirectory = lineReader.next();

                if( zipcode.equals(zipDirectory)){
                    this.region = lineReader.next();
                    this.state = lineReader.next();
                    longitude = lineReader.nextDouble();
                    latitude = lineReader.nextDouble();
                    zipcodeCheck++;
                    break;
                    
                }

            }

        }catch (Exception e)
        {
            System.err.println("Error: " + e.getMessage());
        }

        
     if(zipcodeCheck!=0){
        
         
         double lon1 = longitude * MainJFrame.deg2radians;
        double lat1 = latitude  * MainJFrame.deg2radians;

        System.out.println("zipcode: "+zipcode+" longitude: "+lon1+" latitude: "+lat1);

        try
        {

            Scanner fileReader1 = new Scanner(new File("SupplierDirectory.txt"));
            Scanner lineReader1;

            while(fileReader1.hasNext()) {
                String info1 = fileReader1.nextLine();

                lineReader1 = new Scanner(info1);
                lineReader1.useDelimiter(",");

                //here is what we are getting in from the text doc
                int supplierId = lineReader1.nextInt();
                lineReader1.next();
                lineReader1.next();
                this.country = lineReader1.next();
                lineReader1.next();
                double longitudeSupplierDirectory = lineReader1.nextDouble();
                double latitudeSupplierDirectory = lineReader1.nextDouble();

                double lat2= latitudeSupplierDirectory*MainJFrame.deg2radians;
                double lon2= longitudeSupplierDirectory*MainJFrame.deg2radians;
                double distance=Math.acos(Math.sin(lat1)*Math.sin(lat2)+Math.cos(lat1)*Math.cos(lat2)*Math.cos(lon1-lon2))*MainJFrame.earthRadius;

               
//considering average speed of 40miles per hour for 100 miles it will take Approx 2 n half hour 
// Order restricted till 6 PM. 
// Office hours from 9AM to 9PM
                if(distance<120){
                    supplierIdList.add(supplierId);
                }

            }

        }catch (Exception e)
        {
            System.err.println("Error: " + e.getMessage());
        }

        System.out.println(supplierIdList);

this.supplierIdList = supplierIdList;


if(supplierIdList.size()>0){

populateCategoryJTree();

}
else{
    
    JOptionPane.showMessageDialog(null, "no supplier in the proximity");
}
         
         
         
     } 
     else{
         
         JOptionPane.showMessageDialog(null, "zipcode doesnot exist");
     }
        
        
        }
        
        else{
            
            JOptionPane.showMessageDialog(null, "Please fill the zipcode");
        }

    }//GEN-LAST:event_continueJButtonActionPerformed

    private void categoryJTreeValueChanged(javax.swing.event.TreeSelectionEvent evt) {//GEN-FIRST:event_categoryJTreeValueChanged

        numberOfItemsJComboBox.setEnabled(false);
        addToCartJButton.setEnabled(false);
        
        subCategoryJTree.setSelectionPath(null);
        this.subCategoryName = null;
        
        int rowCount = productsJTable.getRowCount();
        for(int i=rowCount-1; i>=0; i--){
            ((DefaultTableModel)productsJTable.getModel()).removeRow(i);
        }
        
        populateSubCategoryJTree();
        
    }//GEN-LAST:event_categoryJTreeValueChanged

    private void subCategoryJTreeValueChanged(javax.swing.event.TreeSelectionEvent evt) {//GEN-FIRST:event_subCategoryJTreeValueChanged

        numberOfItemsJComboBox.setEnabled(false);
        addToCartJButton.setEnabled(false);
        numberOfItemsJComboBox.removeAllItems();
        
        productsJTable.removeAll();
        
        if(subCategoryJTree.getSelectionPath()!=null){
            
        if(this.categoryName.equals("Category1")){
            for(int i=1;i<=Product.Category1.values().length;i++){
                if(Product.Category1.valueOf("SubCategory"+i).toString().equals(subCategoryJTree.getSelectionPath().getLastPathComponent().toString()))
                this.subCategoryName = "SubCategory"+i;
            }
        }
        else if(this.categoryName.equals("Category2")){
            for(int i=1;i<=Product.Category2.values().length;i++){
                if(Product.Category2.valueOf("SubCategory"+i).toString().equals(subCategoryJTree.getSelectionPath().getLastPathComponent().toString()))
                this.subCategoryName = "SubCategory"+i;}
        }
        else if(this.categoryName.equals("Category3")){
            for(int i=1;i<=Product.Category3.values().length;i++){
                if(Product.Category3.valueOf("SubCategory"+i).toString().equals(subCategoryJTree.getSelectionPath().getLastPathComponent().toString()))
                this.subCategoryName = "SubCategory"+i;}
        }
        else if(this.categoryName.equals("Category4")){
            for(int i=1;i<=Product.Category4.values().length;i++){
                if(Product.Category4.valueOf("SubCategory"+i).toString().equals(subCategoryJTree.getSelectionPath().getLastPathComponent().toString()))
                this.subCategoryName = "SubCategory"+i;}
        }
        else if(this.categoryName.equals("Category5")){
            for(int i=1;i<=Product.Category5.values().length;i++){
                if(Product.Category5.valueOf("SubCategory"+i).toString().equals(subCategoryJTree.getSelectionPath().getLastPathComponent().toString()))
                this.subCategoryName = "SubCategory"+i;}
        }
        else if(this.categoryName.equals("Category6")){
            for(int i=1;i<=Product.Category6.values().length;i++){
                if(Product.Category6.valueOf("SubCategory"+i).toString().equals(subCategoryJTree.getSelectionPath().getLastPathComponent().toString()))
                this.subCategoryName = "SubCategory"+i;}
        }
        else if(this.categoryName.equals("Category7")){
            for(int i=1;i<=Product.Category7.values().length;i++){
                if(Product.Category7.valueOf("SubCategory"+i).toString().equals(subCategoryJTree.getSelectionPath().getLastPathComponent().toString()))
                this.subCategoryName = "SubCategory"+i;}
        }
        else if(this.categoryName.equals("Category8")){
            for(int i=1;i<=Product.Category8.values().length;i++){
                if(Product.Category8.valueOf("SubCategory"+i).toString().equals(subCategoryJTree.getSelectionPath().getLastPathComponent().toString()))
                this.subCategoryName = "SubCategory"+i;}
        }
        else if(this.categoryName.equals("Category9")){
            for(int i=1;i<=Product.Category9.values().length;i++){
                if(Product.Category9.valueOf("SubCategory"+i).toString().equals(subCategoryJTree.getSelectionPath().getLastPathComponent().toString()))
                this.subCategoryName = "SubCategory"+i;}
        }
        
        
        
        populateProductsJTable();
        
        
        }
        
    }//GEN-LAST:event_subCategoryJTreeValueChanged

    private void productsJTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_productsJTableMouseClicked

        populateComboBox();

    }//GEN-LAST:event_productsJTableMouseClicked

    private void cartJTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cartJTableMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_cartJTableMouseClicked

    private void addToCartJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addToCartJButtonActionPerformed

        
    int quantity = Integer.parseInt(numberOfItemsJComboBox.getSelectedItem().toString());
    Product product = (Product)productsJTable.getValueAt(productsJTable.getSelectedRow(), 1);
    String productId = product.getProductId();
    float price = product.getPrice();
    Supplier supplier =  (Supplier)productsJTable.getValueAt(productsJTable.getSelectedRow(), 4);
        
    
      
    
    
    
    
        
        int exists=0;
        for(int i=0;i<cartJTable.getRowCount();i++){

        if(cartJTable.getValueAt(i, 1).equals(productsJTable.getValueAt(productsJTable.getSelectedRow(), 1)))
        {
            
            exists++;
            cartJTable.setValueAt(quantity+Integer.parseInt(cartJTable.getValueAt(i, 2).toString()), i, 2);
            
        }   
        
    }
        
        
        
    
    
        
        
        
        
        if(exists==0)
        {
           DefaultTableModel tableModel = (DefaultTableModel)cartJTable.getModel();
           
            
                Object[] object = new Object[5];
                
                object[0] = productId;
                object[1] = product;
                object[2] = quantity;
                object[3] = price;
                object[4] = supplier;
                        
                tableModel.addRow(object);
           
        }
        
                populateComboBox();
                
                if(cartJTable.getRowCount()>0){
                    checkoutJButton.setEnabled(true);
                }
        
                
    }//GEN-LAST:event_addToCartJButtonActionPerformed

    private void numberOfItemsJComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_numberOfItemsJComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_numberOfItemsJComboBoxActionPerformed

    private void checkoutJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkoutJButtonActionPerformed

        
  ArrayList<Product> productList = new ArrayList<>();
  ArrayList<Integer> quantityList = new ArrayList<>();
  ArrayList<Supplier> supplierList = new ArrayList<>();
  
  
  int rowCount = cartJTable.getRowCount();
  
  for(int i=0;i<rowCount;i++){
      
      productList.add((Product)cartJTable.getValueAt(i, 1));
      quantityList.add(Integer.parseInt(cartJTable.getValueAt(i, 2).toString()));
      supplierList.add((Supplier)cartJTable.getValueAt(i, 4));

      Product p = (Product)cartJTable.getValueAt(i, 1);
      int q = Integer.parseInt(cartJTable.getValueAt(i, 2).toString());
      Supplier s = (Supplier)cartJTable.getValueAt(i, 4);
      
      OrderItem oi=order.createOrderItem();
      oi.setProduct(p);
      oi.setPrice(p.getPrice());
      oi.setSupplier(s);
      oi.setQuantity(q);
      oi.setTax(s.getTax()*oi.getPrice()*oi.getQuantity()/100);
      oi.setCommision(q*p.getPrice()*.10);

      
  }
  
  String mainAddress = this.zipcode+", "+this.region+", "+this.state+", "+this.country+".";
  
        CheckoutJPanel cjp = new CheckoutJPanel(userProcessContainer,system,db4OUtil,order,mainAddress);
        userProcessContainer.add("CheckoutJPanel", cjp);
        CardLayout cardLayout = (CardLayout) userProcessContainer.getLayout();
        cardLayout.next(userProcessContainer);    
        
        
        
        
    }//GEN-LAST:event_checkoutJButtonActionPerformed

    private void searchJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchJButtonActionPerformed

        SearchJPanel sjp = new SearchJPanel(userProcessContainer,system,db4OUtil);
        userProcessContainer.add("SearchJPanel", sjp);
        CardLayout cardLayout = (CardLayout) userProcessContainer.getLayout();
        cardLayout.next(userProcessContainer);    
        
        
    }//GEN-LAST:event_searchJButtonActionPerformed

    private void zipcodeJTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_zipcodeJTextFieldKeyTyped
        
        char c =evt.getKeyChar();
       if(!(Character.isLetterOrDigit(c) || (c== KeyEvent.VK_BACK_SPACE) || (c==KeyEvent.VK_DELETE)) ){
           evt.consume();
       }   
        
    }//GEN-LAST:event_zipcodeJTextFieldKeyTyped

    private void clearAllJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearAllJButtonActionPerformed

        
        int rowCount = cartJTable.getRowCount();
        for(int i=rowCount-1; i>=0; i--){
            ((DefaultTableModel)cartJTable.getModel()).removeRow(i);
        }
        
        
        zipcodeJTextField.setEnabled(true);
        zipcodeJTextField.setText(null);
        continueJButton.setEnabled(true);
        
        
        
        DefaultTreeModel model = (DefaultTreeModel)categoryJTree.getModel();
        DefaultMutableTreeNode root =  (DefaultMutableTreeNode) model.getRoot();
        root.removeAllChildren();
        
        
        
        DefaultTreeModel model1 = (DefaultTreeModel)subCategoryJTree.getModel();
        DefaultMutableTreeNode root1 =  (DefaultMutableTreeNode) model.getRoot();
        root1.removeAllChildren();
        
        
        
        int rowCount1 = productsJTable.getRowCount();
        for(int i=rowCount1-1; i>=0; i--){
            ((DefaultTableModel)productsJTable.getModel()).removeRow(i);
        }
        
        
        
        
        numberOfItemsJComboBox.removeAllItems();
        
        addToCartJButton.setEnabled(false);
        
        checkoutJButton.setEnabled(false);
        
        
        
        
        
    }//GEN-LAST:event_clearAllJButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addToCartJButton;
    private javax.swing.JTable cartJTable;
    private javax.swing.JTree categoryJTree;
    private javax.swing.JButton checkoutJButton;
    private javax.swing.JButton clearAllJButton;
    private javax.swing.JButton continueJButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JComboBox numberOfItemsJComboBox;
    private javax.swing.JTable productsJTable;
    private javax.swing.JButton searchJButton;
    private javax.swing.JTree subCategoryJTree;
    private javax.swing.JLabel zipcodeJLabel;
    private javax.swing.JTextField zipcodeJTextField;
    // End of variables declaration//GEN-END:variables
}
