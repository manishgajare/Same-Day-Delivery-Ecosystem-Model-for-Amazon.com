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
import Business.Organization.Supplier.Inventory.Product;
import Business.Organization.Supplier.Inventory.SupplierInventoryOrganization;
import Interface.MainJFrame;
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
public class SearchJPanel extends javax.swing.JPanel {

    /**
     * Creates new form SearchJPanel
     */
    
    JPanel userProcessContainer; 
    EcoSystem system; 
    DB4OUtil db4OUtil;
    String categoryName;
    String subCategoryName;
    ArrayList<Integer> supplierIdList;
    
    
    public SearchJPanel(JPanel userProcessContainer, EcoSystem system, DB4OUtil db4OUtil) {
        initComponents();
        
        this.userProcessContainer = userProcessContainer;
        this.system = system;
        this.db4OUtil = db4OUtil;

        populateCategoryJTree();
        productIdJLabel.setText(null);
    }
    
    
    
    
    
    
    public void populateSupplierJTable(){
        
        
        
        
        int rowCount = suppliersJTable.getRowCount();
        for(int i=rowCount-1; i>=0; i--){
            ((DefaultTableModel)suppliersJTable.getModel()).removeRow(i);
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
   
            if(p.getProductId().equals(productIdJTextField.getText())){    
                
                
                Object row[] = new Object[1];
                row[0] = supplier.getName();
                
                
                
                
               
            ((DefaultTableModel)suppliersJTable.getModel()).addRow(row); 
                
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
    
    
        
        
        
        
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    public void populateProductsJComboBox(){
        
      productIdJLabel.setText(null);
      productsJComboBox.removeAllItems();
      
      
          for (CountryNetwork countryNetwork : system.getCountryNetworkList()) {
    for (StateNetwork stateNetwork : countryNetwork.getStateNetworkList()) {
    for (RegionNetwork regionNetwork : stateNetwork.getRegionNetworkList()) {
    for (Enterprise enterprise : regionNetwork.getEnterpriseDirectory().getEnterpriseList()) {
        if(enterprise instanceof Supplier){
            Supplier supplier = (Supplier)enterprise;
            
       
 
           
        for(int j=0;enterprise.getOrganizationDirectory().getOrganizationList().size()>j;j++){
            
            
            
        
         if(supplier.getOrganizationDirectory().getOrganizationList().get(j) instanceof SupplierInventoryOrganization){   
            SupplierInventoryOrganization inventoryOrganization = (SupplierInventoryOrganization)enterprise.getOrganizationDirectory().getOrganizationList().get(j);
        for(int k=0;inventoryOrganization.getProductCatalog().getProductList().size()>k;k++){
            
            
            
       
            
            
            if(inventoryOrganization.getProductCatalog().getProductList().get(k).getCategory().toString().equals(this.categoryName) && inventoryOrganization.getProductCatalog().getProductList().get(k).getSubCategory().toString().equals(this.subCategoryName))
            {
                Product p = inventoryOrganization.getProductCatalog().getProductList().get(k);
   
                productsJComboBox.addItem(p);
               
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
        productIdJLabel.setText(null);
        productsJComboBox.removeAllItems();
       
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
        productIdJTextField = new javax.swing.JTextField();
        searchJButton = new javax.swing.JButton();
        zipcodeJTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        distanceJTextField = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        productIdJLabel = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        suppliersJTable = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        categoryJTree = new javax.swing.JTree();
        jScrollPane3 = new javax.swing.JScrollPane();
        subCategoryJTree = new javax.swing.JTree();
        productsJComboBox = new javax.swing.JComboBox();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Product ID:");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 70, -1, -1));

        productIdJTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                productIdJTextFieldKeyTyped(evt);
            }
        });
        add(productIdJTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 70, 88, -1));

        searchJButton.setText("Search");
        searchJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchJButtonActionPerformed(evt);
            }
        });
        add(searchJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 190, -1, -1));

        zipcodeJTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                zipcodeJTextFieldKeyTyped(evt);
            }
        });
        add(zipcodeJTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 110, 88, -1));

        jLabel2.setText("Zipcode :");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 110, -1, -1));

        jLabel3.setText("Distance(miles):");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 150, -1, -1));

        distanceJTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                distanceJTextFieldKeyTyped(evt);
            }
        });
        add(distanceJTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 150, 88, -1));

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 10, 10, 540));

        jLabel4.setText("Product Id: ");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 390, -1, -1));

        productIdJLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        productIdJLabel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        add(productIdJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 380, 91, 32));

        jLabel5.setText("Search Results");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 260, -1, -1));

        suppliersJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Supplier Name"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(suppliersJTable);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 300, 410, 170));

        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("Category");
        categoryJTree.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        categoryJTree.setRootVisible(false);
        categoryJTree.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
            public void valueChanged(javax.swing.event.TreeSelectionEvent evt) {
                categoryJTreeValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(categoryJTree);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 250, 260));

        treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("SubCategory");
        subCategoryJTree.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        subCategoryJTree.setRootVisible(false);
        subCategoryJTree.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
            public void valueChanged(javax.swing.event.TreeSelectionEvent evt) {
                subCategoryJTreeValueChanged(evt);
            }
        });
        jScrollPane3.setViewportView(subCategoryJTree);

        add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 20, 240, 260));

        productsJComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productsJComboBoxActionPerformed(evt);
            }
        });
        add(productsJComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 320, 200, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void categoryJTreeValueChanged(javax.swing.event.TreeSelectionEvent evt) {//GEN-FIRST:event_categoryJTreeValueChanged
productIdJLabel.setText(null);
        subCategoryJTree.setSelectionPath(null);
        this.subCategoryName = null;

       
        populateSubCategoryJTree();

    }//GEN-LAST:event_categoryJTreeValueChanged

    private void subCategoryJTreeValueChanged(javax.swing.event.TreeSelectionEvent evt) {//GEN-FIRST:event_subCategoryJTreeValueChanged

        productIdJLabel.setText(null);
        productsJComboBox.removeAllItems();
        
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
populateProductsJComboBox();
           
        }
        
        

    }//GEN-LAST:event_subCategoryJTreeValueChanged

    private void productsJComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productsJComboBoxActionPerformed

        
        if(productsJComboBox.getSelectedItem()!=null){
        Product product = (Product)productsJComboBox.getSelectedItem();
        productIdJLabel.setText(product.getProductId());
        productIdJTextField.setText(productIdJLabel.getText());
        }
        
    }//GEN-LAST:event_productsJComboBoxActionPerformed

    private void searchJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchJButtonActionPerformed

        int count=0;
        if(productIdJTextField.getText().isEmpty() || zipcodeJTextField.getText().isEmpty() || distanceJTextField.getText().isEmpty() )
        {
            count++;
        }
        
        if(count==0){
            
            
            
            
            
            
          
          
          
           int zipcodeCheck=0;  
           String zipcode = zipcodeJTextField.getText();
        
        

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
                    lineReader.next();
                    lineReader.next();
                    lineReader.nextDouble();
                    lineReader.nextDouble();
                    zipcodeCheck++;
                    break;
                    
                }

            }

        }catch (Exception e)
        {
            System.err.println("Error: " + e.getMessage());
        }

          
            
        if(zipcodeCheck!=0)     
          
     {      
            
            
            
            
            
        
        String productId = productIdJTextField.getText();
        String zipcodeInput = zipcodeJTextField.getText();
        double distanceInput = Double.parseDouble(distanceJTextField.getText());
        
        
        zipcode = null;
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
                    lineReader.next();
                    lineReader.next();
                    longitude = lineReader.nextDouble();
                    latitude = lineReader.nextDouble();
                    break;
                }

            }

        }catch (Exception e)
        {
            System.err.println("Error: " + e.getMessage());
        }

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
                String zipSupplierDirectory = lineReader1.next();
                lineReader1.next();
                lineReader1.next();
                lineReader1.next();
                double longitudeSupplierDirectory = lineReader1.nextDouble();
                double latitudeSupplierDirectory = lineReader1.nextDouble();

                double lat2= latitudeSupplierDirectory*MainJFrame.deg2radians;
                double lon2= longitudeSupplierDirectory*MainJFrame.deg2radians;
                double distance=Math.acos(Math.sin(lat1)*Math.sin(lat2)+Math.cos(lat1)*Math.cos(lat2)*Math.cos(lon1-lon2))*MainJFrame.earthRadius;

               
//considering average speed of 40miles per hour for 100 miles it will take Approx 2 n half hour 
// Order restricted till 6 PM. 
// Office hours from 9AM to 9PM
                if(distance<distanceInput){
                    supplierIdList.add(supplierId);
                    
                }

            }

        }catch (Exception e)
        {
            System.err.println("Error: " + e.getMessage());
        }

        System.out.println(supplierIdList);
         
this.supplierIdList = supplierIdList;

      populateSupplierJTable();  


}
     else{
         JOptionPane.showMessageDialog(null, "zipcode doesn't exist");
     }
     


        }else{
            
            JOptionPane.showMessageDialog(null, "Please fill all the fields");
            
        }
        
        
        
    }//GEN-LAST:event_searchJButtonActionPerformed

    private void productIdJTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_productIdJTextFieldKeyTyped
        
      char c =evt.getKeyChar();
       if(!(Character.isDigit(c) || (c== KeyEvent.VK_BACK_SPACE) || (c==KeyEvent.VK_DELETE)) ){
           evt.consume();
       }
        
        
    }//GEN-LAST:event_productIdJTextFieldKeyTyped

    private void zipcodeJTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_zipcodeJTextFieldKeyTyped
        
        char c =evt.getKeyChar();
       if(!(Character.isLetterOrDigit(c) || (c== KeyEvent.VK_BACK_SPACE) || (c==KeyEvent.VK_DELETE)) ){
           evt.consume();
       }
        
        
    }//GEN-LAST:event_zipcodeJTextFieldKeyTyped

    private void distanceJTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_distanceJTextFieldKeyTyped
        
       char c =evt.getKeyChar();
       if(!(Character.isDigit(c) || (c== KeyEvent.VK_BACK_SPACE) || (c==KeyEvent.VK_DELETE)) ){
           evt.consume();
       }
       
        
        
    }//GEN-LAST:event_distanceJTextFieldKeyTyped

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTree categoryJTree;
    private javax.swing.JTextField distanceJTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel productIdJLabel;
    private javax.swing.JTextField productIdJTextField;
    private javax.swing.JComboBox productsJComboBox;
    private javax.swing.JButton searchJButton;
    private javax.swing.JTree subCategoryJTree;
    private javax.swing.JTable suppliersJTable;
    private javax.swing.JTextField zipcodeJTextField;
    // End of variables declaration//GEN-END:variables
}
