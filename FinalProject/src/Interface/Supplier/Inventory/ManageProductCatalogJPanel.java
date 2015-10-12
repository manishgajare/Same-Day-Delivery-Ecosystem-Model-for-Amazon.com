/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.Supplier.Inventory;

import Business.DB4OUtil.DB4OUtil;
import Business.Enterprise.Supplier;
import Business.Organization.Amazon.Inventory.ProductCatalogList;
import Business.Organization.Supplier.Inventory.Product;
import Business.Organization.Supplier.Inventory.SupplierInventoryOrganization;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

/**
 *
 * @author Manish Gajare
 */
public class ManageProductCatalogJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ManageProductCatalogJPanel
     */
    
    JPanel userProcessContainer; 
    UserAccount account; 
    SupplierInventoryOrganization inventoryOrganization;
    ProductCatalogList productCatalogList;
    DB4OUtil db4OUtil;
    Supplier enterprise;
    String categoryName;
    String subCategoryName;
    
    public ManageProductCatalogJPanel(JPanel userProcessContainer, UserAccount account, SupplierInventoryOrganization inventoryOrganization,ProductCatalogList productCatalogList, DB4OUtil db4OUtil,Supplier enterprise) {
        initComponents();
        
        
    this.userProcessContainer = userProcessContainer; 
    this.account = account; 
    this.inventoryOrganization = inventoryOrganization;
    this.productCatalogList = productCatalogList;
    this.db4OUtil = db4OUtil;    
    this.enterprise = enterprise;
    
    
    proceedJButton.setEnabled(false);
    
populateCategoryJTree();
    
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        categoryJTree = new javax.swing.JTree();
        jScrollPane2 = new javax.swing.JScrollPane();
        subCategoryJTree = new javax.swing.JTree();
        jButton1 = new javax.swing.JButton();
        proceedJButton = new javax.swing.JButton();

        jLabel1.setText("Manage Product Catalog");

        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("Category");
        categoryJTree.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        categoryJTree.setRootVisible(false);
        categoryJTree.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
            public void valueChanged(javax.swing.event.TreeSelectionEvent evt) {
                categoryJTreeValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(categoryJTree);

        treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("SubCategory");
        subCategoryJTree.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        subCategoryJTree.setRootVisible(false);
        subCategoryJTree.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
            public void valueChanged(javax.swing.event.TreeSelectionEvent evt) {
                subCategoryJTreeValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(subCategoryJTree);

        jButton1.setText("<< BACK");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        proceedJButton.setText("Proceed");
        proceedJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                proceedJButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(60, 60, 60)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(73, 73, 73)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(52, 52, 52)
                            .addComponent(jButton1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(proceedJButton)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(295, 295, 295)
                        .addComponent(jLabel1)))
                .addContainerGap(154, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(67, 67, 67)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(proceedJButton)
                    .addComponent(jButton1))
                .addGap(220, 220, 220))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void categoryJTreeValueChanged(javax.swing.event.TreeSelectionEvent evt) {//GEN-FIRST:event_categoryJTreeValueChanged


        
        populateSubCategoryJTree();
        proceedJButton.setEnabled(false);
        
        
    }//GEN-LAST:event_categoryJTreeValueChanged

    private void subCategoryJTreeValueChanged(javax.swing.event.TreeSelectionEvent evt) {//GEN-FIRST:event_subCategoryJTreeValueChanged

     

        
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
        
        
      
        proceedJButton.setEnabled(true);
        


    }//GEN-LAST:event_subCategoryJTreeValueChanged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        
        SupplierInventoryEmployeeWorkAreaJPanel siewajp = new SupplierInventoryEmployeeWorkAreaJPanel(userProcessContainer,account,inventoryOrganization,productCatalogList,db4OUtil,enterprise);
        userProcessContainer.add("SupplierInventoryEmployeeWorkAreaJPanel", siewajp);
        CardLayout cardLayout = (CardLayout) userProcessContainer.getLayout();
        cardLayout.next(userProcessContainer); 

    }//GEN-LAST:event_jButton1ActionPerformed

    private void proceedJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_proceedJButtonActionPerformed
        System.out.println(categoryName);
        System.out.println(subCategoryName);
        ModifyProductsJPanel mpjp = new ModifyProductsJPanel(userProcessContainer,account,inventoryOrganization,productCatalogList,db4OUtil,enterprise,this.categoryName,this.subCategoryName);
        userProcessContainer.add("ModifyProductsJPanel", mpjp);
        
        CardLayout cardLayout = (CardLayout) userProcessContainer.getLayout();
        cardLayout.next(userProcessContainer);    
        
        
    }//GEN-LAST:event_proceedJButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JTree categoryJTree;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton proceedJButton;
    private javax.swing.JTree subCategoryJTree;
    // End of variables declaration//GEN-END:variables
}
