/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.System;

import Business.Customer.CustomerAccount;
import Business.DB4OUtil.DB4OUtil;
import Business.Enterprise.Enterprise;
import Business.Organization.System.SystemAdminOrganization;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;
import Business.EcoSystem;
import Business.Employee.Employee;
import Business.Enterprise.Amazon;
import Business.Enterprise.EnterpriseDirectory;
import Business.Enterprise.Supplier;
import Business.Network.CountryNetwork;
import Business.Network.RegionNetwork;
import Business.Network.StateNetwork;
import Business.Organization.Organization;
import Business.Role.Amazon.AmazonAdminRole;
import Business.Role.Supplier.SupplierAdminRole;
import java.awt.CardLayout;
import java.awt.event.KeyEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import javax.swing.JOptionPane;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

/*
 *
 * @author Manish Gajare
 */
public class ManageAllJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ManageAllJPanel
     */
    JPanel userProcessContainer;
    Enterprise enterprise;
    EcoSystem system;
    DB4OUtil db4OUtil;
    
    public ManageAllJPanel(JPanel userProcessContainer, UserAccount account, SystemAdminOrganization systemAdminOrganization, Enterprise enterprise, EcoSystem system,DB4OUtil db4OUtil) {
      
    initComponents();
    
        this.userProcessContainer = userProcessContainer;
        this.enterprise = enterprise;
        this.system = system;
        this.db4OUtil = db4OUtil;
        

          enterpriseListJTree.setRootVisible(false);  
          regionListJTree.setRootVisible(false);
          stateListJTree.setRootVisible(false);   
          countryListJTree.setRootVisible(false);

        
        
        
        countryNameJTextField.setVisible(true);
        addCountryNameJButton.setVisible(true);
        
        stateNameJTextField.setVisible(false);
        addStateNameJButton.setVisible(false);
        
        regionNameJTextField.setVisible(false);
        addRegionNameJButton.setVisible(false);
        
     
        enterpriseNameJLabel.setVisible(false);
        enterpriseNameJTextField.setVisible(false);
        enterpriseTypeJLabel.setVisible(false);
        enterpriseTypeJComboBox.setVisible(false);
        createEnterpriseJButton.setVisible(false);
        
        adminNameJLabel.setVisible(false);
        adminNameJTextField.setVisible(false);
        usernameJLabel.setVisible(false);
        usernameJTextField.setVisible(false);
        passwordJLabel.setVisible(false);
        passwordJTextField.setVisible(false);
        
        activeCountryJRadioButton.setVisible(true);
        activeStateJRadioButton.setVisible(false);
        activeRegionJRadioButton.setVisible(false);
        activeEnterpriseJRadioButton.setVisible(false);
        inactiveCountryJRadioButton.setVisible(true);
        inactiveStateJRadioButton.setVisible(false);
        inactiveRegionJRadioButton.setVisible(false);
        inactiveEnterpriseJRadioButton.setVisible(false);
        
       zipcodeJLabel.setVisible(false);
       zipcodeJTextField.setVisible(false);
       taxJLabel.setVisible(false);
       taxJTextField.setVisible(false);
       
       
       jSeparator1.setVisible(false);
       jSeparator2.setVisible(false);
       
        populateCountryListJTree();
        
    }
    
    
    private void populateEnterpriseTypeJCombobox(){
        
        
        ArrayList<CountryNetwork> countryNetworkList = system.getCountryNetworkList();
        int amazonExist = 0; 
        
        for(int i=0;i<countryNetworkList.size();i++){
        
       try {
        if(countryNetworkList.get(i).getCountryName().equals(String.valueOf(countryListJTree.getSelectionPath().getLastPathComponent())))    
        {
        ArrayList<StateNetwork> stateNetworkList = countryNetworkList.get(i).getStateNetworkList();
        
        
        for(int j=0;j<stateNetworkList.size();j++){
        
       
        ArrayList<RegionNetwork> regionNetworkList = stateNetworkList.get(j).getRegionNetworkList();
        
        
        
        
        for(int k=0;k<regionNetworkList.size();k++){
        
        
        
      ArrayList<Enterprise> enterpriseList = regionNetworkList.get(k).getEnterpriseDirectory().getEnterpriseList();  
        
       
      for(int l=0;l<enterpriseList.size();l++){
        
          if(enterpriseList.get(l) instanceof Amazon){
             amazonExist++; 
          
        }
        
      

      
   
        
        }
        
        }
        
        

        
        
        
        
        
        }
        

        
        }
        
       } catch (NullPointerException e){}
        
        }
        
        
        
        enterpriseTypeJComboBox.removeAllItems();
        if(amazonExist!=0){
        enterpriseTypeJComboBox.addItem(Enterprise.EnterpriseType.SUPPLIER);
        }
        else if(amazonExist==0){
            enterpriseTypeJComboBox.addItem(Enterprise.EnterpriseType.AMAZON);
        //    enterpriseTypeJComboBox.addItem(Enterprise.EnterpriseType.SUPPLIER);
        }
        
        
    }
    
    
    private void populateCountryListJTree(){

        DefaultTreeModel model = (DefaultTreeModel)countryListJTree.getModel();
        
        DefaultMutableTreeNode root =  (DefaultMutableTreeNode) model.getRoot();
        
          root.removeAllChildren();
          
        ArrayList<CountryNetwork> countryNetworkList = system.getCountryNetworkList();
        
        
        
        for(int i=0;i<countryNetworkList.size();i++){
        DefaultMutableTreeNode countryNetworkNode = new DefaultMutableTreeNode(countryNetworkList.get(i).getCountryName());
        root.insert(countryNetworkNode, i);
        }
        
        model.reload();
        
        
    }
    
    private void populateStateListJTree(){
        
//  String selectedCountryName = String.valueOf();
        
     
     
        DefaultTreeModel model = (DefaultTreeModel)stateListJTree.getModel();
        
        DefaultMutableTreeNode root =  (DefaultMutableTreeNode) model.getRoot();
        
          root.removeAllChildren();
          
        ArrayList<CountryNetwork> countryNetworkList = system.getCountryNetworkList();
        
        
        for(int i=0;i<countryNetworkList.size();i++){
        
       try {
        if(countryNetworkList.get(i).getCountryName().equals(String.valueOf(countryListJTree.getSelectionPath().getLastPathComponent())))    
        {
        ArrayList<StateNetwork> stateNetworkList = countryNetworkList.get(i).getStateNetworkList();
        
        for(int j=0;j<stateNetworkList.size();j++){
        DefaultMutableTreeNode stateNetworkNode = new DefaultMutableTreeNode(stateNetworkList.get(j).getStateName());
        root.insert(stateNetworkNode, j);
        }
        
        }
        
       } catch (NullPointerException e){}
        
        }
        
        model.reload();
        
        
    }
    
    
      private void populateRegionListJTree(){
        
//  String selectedCountryName = String.valueOf();
        
  
     
        DefaultTreeModel model = (DefaultTreeModel)regionListJTree.getModel();
        
        DefaultMutableTreeNode root =  (DefaultMutableTreeNode) model.getRoot();
        
          root.removeAllChildren();
          
        ArrayList<CountryNetwork> countryNetworkList = system.getCountryNetworkList();
        
        
        for(int i=0;i<countryNetworkList.size();i++){
        
       try {
        if(countryNetworkList.get(i).getCountryName().equals(String.valueOf(countryListJTree.getSelectionPath().getLastPathComponent())))    
        {
        ArrayList<StateNetwork> stateNetworkList = countryNetworkList.get(i).getStateNetworkList();
        
        
        for(int j=0;j<stateNetworkList.size();j++){
        
        if(stateNetworkList.get(j).getStateName().equals(String.valueOf(stateListJTree.getSelectionPath().getLastPathComponent())))    
        {
        ArrayList<RegionNetwork> regionNetworkList = stateNetworkList.get(j).getRegionNetworkList();
        
        
        
        
        for(int k=0;k<regionNetworkList.size();k++){
        DefaultMutableTreeNode regionNetworkNode = new DefaultMutableTreeNode(regionNetworkList.get(k).getRegionName());
        root.insert(regionNetworkNode, k);
        }
        
        
        
        
        
        
        }
        
        
        }
        
        
        
        }
        
       } catch (NullPointerException e){}
        
        }
        
        model.reload();
        
        
    }  
    
    
    
    public void populateEnterpriseListJTree()
    {
        
      
     
        DefaultTreeModel model = (DefaultTreeModel)enterpriseListJTree.getModel();
        
        DefaultMutableTreeNode root =  (DefaultMutableTreeNode) model.getRoot();
        
          root.removeAllChildren();
          
        ArrayList<CountryNetwork> countryNetworkList = system.getCountryNetworkList();
        
        
        for(int i=0;i<countryNetworkList.size();i++){
        
       try {
        if(countryNetworkList.get(i).getCountryName().equals(String.valueOf(countryListJTree.getSelectionPath().getLastPathComponent())))    
        {
        ArrayList<StateNetwork> stateNetworkList = countryNetworkList.get(i).getStateNetworkList();
        
        
        for(int j=0;j<stateNetworkList.size();j++){
        
        if(stateNetworkList.get(j).getStateName().equals(String.valueOf(stateListJTree.getSelectionPath().getLastPathComponent())))    
        {
        ArrayList<RegionNetwork> regionNetworkList = stateNetworkList.get(j).getRegionNetworkList();
        
        
        
        
        for(int k=0;k<regionNetworkList.size();k++){
        
        if(regionNetworkList.get(k).getRegionName().equals(String.valueOf(regionListJTree.getSelectionPath().getLastPathComponent())))    
        {
        
      ArrayList<Enterprise> enterpriseList = regionNetworkList.get(k).getEnterpriseDirectory().getEnterpriseList();  
        
       
      for(int l=0;l<enterpriseList.size();l++){
        DefaultMutableTreeNode enterpriseNode = new DefaultMutableTreeNode(enterpriseList.get(l).getName());
        root.insert(enterpriseNode, l);
        }
        
      
      
      
      
      
      
        
        }
        
        }
        
        
        
        
        
        
        }
        
        
        }
        
        
        
        }
        
       } catch (NullPointerException e){}
        
        }
        
        model.reload();
        
        
        
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
        buttonGroup3 = new javax.swing.ButtonGroup();
        buttonGroup4 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        countryListJTree = new javax.swing.JTree();
        jScrollPane2 = new javax.swing.JScrollPane();
        stateListJTree = new javax.swing.JTree();
        jScrollPane3 = new javax.swing.JScrollPane();
        regionListJTree = new javax.swing.JTree();
        jScrollPane4 = new javax.swing.JScrollPane();
        enterpriseListJTree = new javax.swing.JTree();
        countryNameJTextField = new javax.swing.JTextField();
        addCountryNameJButton = new javax.swing.JButton();
        stateNameJTextField = new javax.swing.JTextField();
        addStateNameJButton = new javax.swing.JButton();
        regionNameJTextField = new javax.swing.JTextField();
        addRegionNameJButton = new javax.swing.JButton();
        enterpriseTypeJComboBox = new javax.swing.JComboBox();
        enterpriseNameJTextField = new javax.swing.JTextField();
        enterpriseTypeJLabel = new javax.swing.JLabel();
        enterpriseNameJLabel = new javax.swing.JLabel();
        createEnterpriseJButton = new javax.swing.JButton();
        adminNameJLabel = new javax.swing.JLabel();
        usernameJLabel = new javax.swing.JLabel();
        passwordJLabel = new javax.swing.JLabel();
        passwordJTextField = new javax.swing.JTextField();
        adminNameJTextField = new javax.swing.JTextField();
        usernameJTextField = new javax.swing.JTextField();
        activeCountryJRadioButton = new javax.swing.JRadioButton();
        inactiveCountryJRadioButton = new javax.swing.JRadioButton();
        activeStateJRadioButton = new javax.swing.JRadioButton();
        inactiveStateJRadioButton = new javax.swing.JRadioButton();
        activeRegionJRadioButton = new javax.swing.JRadioButton();
        inactiveRegionJRadioButton = new javax.swing.JRadioButton();
        activeEnterpriseJRadioButton = new javax.swing.JRadioButton();
        inactiveEnterpriseJRadioButton = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();
        zipcodeJLabel = new javax.swing.JLabel();
        zipcodeJTextField = new javax.swing.JTextField();
        taxJLabel = new javax.swing.JLabel();
        taxJTextField = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Manage All");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 11, -1, -1));

        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("Country");
        countryListJTree.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        countryListJTree.setEditable(true);
        countryListJTree.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
            public void valueChanged(javax.swing.event.TreeSelectionEvent evt) {
                countryListJTreeValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(countryListJTree);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 166, -1));

        treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("State");
        stateListJTree.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        stateListJTree.setEditable(true);
        stateListJTree.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
            public void valueChanged(javax.swing.event.TreeSelectionEvent evt) {
                stateListJTreeValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(stateListJTree);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 40, 165, -1));

        treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("Region");
        regionListJTree.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        regionListJTree.setEditable(true);
        regionListJTree.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
            public void valueChanged(javax.swing.event.TreeSelectionEvent evt) {
                regionListJTreeValueChanged(evt);
            }
        });
        jScrollPane3.setViewportView(regionListJTree);

        add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 40, 171, -1));

        treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("Enterprise");
        enterpriseListJTree.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        enterpriseListJTree.setEditable(true);
        jScrollPane4.setViewportView(enterpriseListJTree);

        add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 40, 210, 210));

        countryNameJTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                countryNameJTextFieldKeyTyped(evt);
            }
        });
        add(countryNameJTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 440, 102, -1));

        addCountryNameJButton.setText("Add New Country");
        addCountryNameJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addCountryNameJButtonActionPerformed(evt);
            }
        });
        add(addCountryNameJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 500, 127, -1));

        stateNameJTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                stateNameJTextFieldKeyTyped(evt);
            }
        });
        add(stateNameJTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 440, 102, -1));

        addStateNameJButton.setText("Add State Name");
        addStateNameJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addStateNameJButtonActionPerformed(evt);
            }
        });
        add(addStateNameJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 500, 130, -1));

        regionNameJTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                regionNameJTextFieldKeyTyped(evt);
            }
        });
        add(regionNameJTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 440, 102, -1));

        addRegionNameJButton.setText("Add Region Name");
        addRegionNameJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addRegionNameJButtonActionPerformed(evt);
            }
        });
        add(addRegionNameJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 500, 140, -1));

        add(enterpriseTypeJComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 330, 100, -1));

        enterpriseNameJTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enterpriseNameJTextFieldActionPerformed(evt);
            }
        });
        enterpriseNameJTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                enterpriseNameJTextFieldKeyTyped(evt);
            }
        });
        add(enterpriseNameJTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 360, 100, -1));

        enterpriseTypeJLabel.setText("Enterprise Type");
        add(enterpriseTypeJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 330, 110, -1));

        enterpriseNameJLabel.setText("Enterprise Name");
        add(enterpriseNameJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 360, 110, -1));

        createEnterpriseJButton.setText("Create Enterprise");
        createEnterpriseJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createEnterpriseJButtonActionPerformed(evt);
            }
        });
        add(createEnterpriseJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 590, -1, -1));

        adminNameJLabel.setText("Admin Name");
        add(adminNameJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 460, 110, -1));

        usernameJLabel.setText("Username");
        add(usernameJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 500, 100, -1));

        passwordJLabel.setText("Password");
        add(passwordJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 530, 110, -1));

        passwordJTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                passwordJTextFieldKeyTyped(evt);
            }
        });
        add(passwordJTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 530, 100, -1));

        adminNameJTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                adminNameJTextFieldKeyTyped(evt);
            }
        });
        add(adminNameJTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 460, 100, -1));

        usernameJTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                usernameJTextFieldKeyTyped(evt);
            }
        });
        add(usernameJTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 500, 100, -1));

        buttonGroup1.add(activeCountryJRadioButton);
        activeCountryJRadioButton.setSelected(true);
        activeCountryJRadioButton.setText("active");
        add(activeCountryJRadioButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 470, -1, -1));

        buttonGroup1.add(inactiveCountryJRadioButton);
        inactiveCountryJRadioButton.setText("inactive");
        add(inactiveCountryJRadioButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 470, -1, -1));

        buttonGroup2.add(activeStateJRadioButton);
        activeStateJRadioButton.setSelected(true);
        activeStateJRadioButton.setText("active");
        add(activeStateJRadioButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 470, -1, -1));

        buttonGroup2.add(inactiveStateJRadioButton);
        inactiveStateJRadioButton.setText("inactive");
        add(inactiveStateJRadioButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 470, -1, -1));

        buttonGroup3.add(activeRegionJRadioButton);
        activeRegionJRadioButton.setSelected(true);
        activeRegionJRadioButton.setText("active");
        add(activeRegionJRadioButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 470, -1, -1));

        buttonGroup3.add(inactiveRegionJRadioButton);
        inactiveRegionJRadioButton.setText("inactive");
        add(inactiveRegionJRadioButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 470, -1, -1));

        buttonGroup4.add(activeEnterpriseJRadioButton);
        activeEnterpriseJRadioButton.setSelected(true);
        activeEnterpriseJRadioButton.setText("active");
        add(activeEnterpriseJRadioButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 560, -1, -1));

        buttonGroup4.add(inactiveEnterpriseJRadioButton);
        inactiveEnterpriseJRadioButton.setText("inactive");
        add(inactiveEnterpriseJRadioButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 560, -1, -1));

        jButton1.setText("<< BACK");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 560, -1, -1));

        zipcodeJLabel.setText("zipcode");
        add(zipcodeJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 390, -1, -1));

        zipcodeJTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                zipcodeJTextFieldKeyTyped(evt);
            }
        });
        add(zipcodeJTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 390, 100, -1));

        taxJLabel.setText("Product & Service Charges : ");
        add(taxJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 420, -1, -1));

        taxJTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                taxJTextFieldKeyTyped(evt);
            }
        });
        add(taxJTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 420, 100, -1));
        add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 450, 250, -1));
        add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 490, 250, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void addCountryNameJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addCountryNameJButtonActionPerformed

        
        
        
        String countryName = countryNameJTextField.getText();

        int count=0;
        if(countryName.isEmpty()){
            count++;
        }
        
        
        if(count==0)
        {
       
         int count1=0;
         for(CountryNetwork country:system.getCountryNetworkList()){
             if(country.getCountryName().equalsIgnoreCase(countryName)){
                 count1++;
             }
         }
         
         if(count1==0)
         {
        CountryNetwork cn =system.createAndAddCountryNetwork(countryName);
       
        
        if(activeCountryJRadioButton.isSelected())
            cn.setStatus(activeCountryJRadioButton.getText());
        else if(inactiveCountryJRadioButton.isSelected())
            cn.setStatus(inactiveCountryJRadioButton.getText());
        
        db4OUtil.storeSystem(system);
        populateCountryListJTree();
        
        
        countryNameJTextField.setVisible(true);
        addCountryNameJButton.setVisible(true);
        
        stateNameJTextField.setVisible(false);
        addStateNameJButton.setVisible(false);
        
        regionNameJTextField.setVisible(false);
        addRegionNameJButton.setVisible(false);
      
        
        enterpriseNameJLabel.setVisible(false);
        enterpriseNameJTextField.setVisible(false);
        enterpriseTypeJLabel.setVisible(false);
        enterpriseTypeJComboBox.setVisible(false);
        createEnterpriseJButton.setVisible(false);
        
        adminNameJLabel.setVisible(false);
        adminNameJTextField.setVisible(false);
        usernameJLabel.setVisible(false);
        usernameJTextField.setVisible(false);
        passwordJLabel.setVisible(false);
        passwordJTextField.setVisible(false);
        
        activeCountryJRadioButton.setVisible(true);
        activeStateJRadioButton.setVisible(false);
        activeRegionJRadioButton.setVisible(false);
        activeEnterpriseJRadioButton.setVisible(false);
        inactiveCountryJRadioButton.setVisible(true);
        inactiveStateJRadioButton.setVisible(false);
        inactiveRegionJRadioButton.setVisible(false);
        inactiveEnterpriseJRadioButton.setVisible(false);

        
       zipcodeJLabel.setVisible(false);
       zipcodeJTextField.setVisible(false);
       taxJLabel.setVisible(false);
       taxJTextField.setVisible(false);
       jSeparator1.setVisible(false);
       jSeparator2.setVisible(false);
        
        countryNameJTextField.setText(null); 
        
         }
         else{
             
             
           JOptionPane.showMessageDialog(null, "Country already Exists");  
             
             
         }
        
        
    }
        else
        {
            JOptionPane.showMessageDialog(null, "Please fill the required fields");
        }
        
        regionNameJTextField.setText(null);
        stateNameJTextField.setText(null);
        countryNameJTextField.setText(null);
        enterpriseNameJTextField.setText(null);
        adminNameJTextField.setText(null);
        usernameJTextField.setText(null);
        passwordJTextField.setText(null);
        zipcodeJTextField.setText(null);
        taxJTextField.setText(null);
        
    
    }//GEN-LAST:event_addCountryNameJButtonActionPerformed

    private void countryListJTreeValueChanged(javax.swing.event.TreeSelectionEvent evt) {//GEN-FIRST:event_countryListJTreeValueChanged
       
        
       
       
       populateStateListJTree();
       
       countryNameJTextField.setVisible(true);
        addCountryNameJButton.setVisible(true);
        
        stateNameJTextField.setVisible(true);
        addStateNameJButton.setVisible(true);
        
        regionNameJTextField.setVisible(false);
        addRegionNameJButton.setVisible(false);
        
        
        enterpriseNameJLabel.setVisible(false);
        enterpriseNameJTextField.setVisible(false);
        enterpriseTypeJLabel.setVisible(false);
        enterpriseTypeJComboBox.setVisible(false);
        createEnterpriseJButton.setVisible(false);
       
        adminNameJLabel.setVisible(false);
        adminNameJTextField.setVisible(false);
        usernameJLabel.setVisible(false);
        usernameJTextField.setVisible(false);
        passwordJLabel.setVisible(false);
        passwordJTextField.setVisible(false);
        
        activeCountryJRadioButton.setVisible(true);
        activeStateJRadioButton.setVisible(true);
        activeRegionJRadioButton.setVisible(false);
        activeEnterpriseJRadioButton.setVisible(false);
        inactiveCountryJRadioButton.setVisible(true);
        inactiveStateJRadioButton.setVisible(true);
        inactiveRegionJRadioButton.setVisible(false);
        inactiveEnterpriseJRadioButton.setVisible(false);

        zipcodeJLabel.setVisible(false);
       zipcodeJTextField.setVisible(false);
       taxJLabel.setVisible(false);
       taxJTextField.setVisible(false);      
       jSeparator1.setVisible(false);
       jSeparator2.setVisible(false);
       
        
    }//GEN-LAST:event_countryListJTreeValueChanged

    private void addStateNameJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addStateNameJButtonActionPerformed
     
        String stateName = stateNameJTextField.getText();
        
        
        
    int count=0;
        if(stateName.isEmpty()){
            count++;
        }
        
        
        if(count==0)
        {
       
         int count1=0;
         for(CountryNetwork country:system.getCountryNetworkList()){
             for(StateNetwork state: country.getStateNetworkList()){
             if(state.getStateName().equalsIgnoreCase(stateName)){
                 count1++;
             }
             }
         }
         
         if(count1==0)
         {    
        
        
        ArrayList<CountryNetwork> countryNetworkList = system.getCountryNetworkList();
        
        
        for(int i=0;i<countryNetworkList.size();i++){
        
        try {
        if(countryNetworkList.get(i).getCountryName().equals(String.valueOf(countryListJTree.getSelectionPath().getLastPathComponent())))    
        {
        ArrayList<StateNetwork> stateNetworkList = countryNetworkList.get(i).getStateNetworkList();
        
        StateNetwork sn = system.getCountryNetworkList().get(i).createAndAddStateNetwork(stateName);
        
       if(activeStateJRadioButton.isSelected())
            sn.setStatus(activeStateJRadioButton.getText());
        else if(inactiveStateJRadioButton.isSelected())
            sn.setStatus(inactiveStateJRadioButton.getText());
        
       
        db4OUtil.storeSystem(system);
        populateStateListJTree();
        
         }
        } catch (NullPointerException e){}
        
        }
       
     stateNameJTextField.setText(null); 
     
     
     countryNameJTextField.setVisible(true);
        addCountryNameJButton.setVisible(true);
        
        stateNameJTextField.setVisible(true);
        addStateNameJButton.setVisible(true);
        
        regionNameJTextField.setVisible(false);
        addRegionNameJButton.setVisible(false);
        
        
        enterpriseNameJLabel.setVisible(false);
        enterpriseNameJTextField.setVisible(false);
        enterpriseTypeJLabel.setVisible(false);
        enterpriseTypeJComboBox.setVisible(false);
        createEnterpriseJButton.setVisible(false);
     
        adminNameJLabel.setVisible(false);
        adminNameJTextField.setVisible(false);
        usernameJLabel.setVisible(false);
        usernameJTextField.setVisible(false);
        passwordJLabel.setVisible(false);
        passwordJTextField.setVisible(false);
        
        activeCountryJRadioButton.setVisible(true);
        activeStateJRadioButton.setVisible(true);
        activeRegionJRadioButton.setVisible(false);
        activeEnterpriseJRadioButton.setVisible(false);
        inactiveCountryJRadioButton.setVisible(true);
        inactiveStateJRadioButton.setVisible(true);
        inactiveRegionJRadioButton.setVisible(false);
        inactiveEnterpriseJRadioButton.setVisible(false);

        zipcodeJLabel.setVisible(false);
       zipcodeJTextField.setVisible(false);
       taxJLabel.setVisible(false);
       taxJTextField.setVisible(false);
       jSeparator1.setVisible(false);
       jSeparator2.setVisible(false);
       
        
        }
         else{
             
             
           JOptionPane.showMessageDialog(null, "State already Exists");  
             
             
         }
        
        
    }
        else
        {
            JOptionPane.showMessageDialog(null, "Please fill the required fields");
        }
    
        regionNameJTextField.setText(null);
        stateNameJTextField.setText(null);
        countryNameJTextField.setText(null);
        enterpriseNameJTextField.setText(null);
        adminNameJTextField.setText(null);
        usernameJTextField.setText(null);
        passwordJTextField.setText(null);
        zipcodeJTextField.setText(null);
        taxJTextField.setText(null);
        
        
    }//GEN-LAST:event_addStateNameJButtonActionPerformed

    private void stateListJTreeValueChanged(javax.swing.event.TreeSelectionEvent evt) {//GEN-FIRST:event_stateListJTreeValueChanged
        
        populateRegionListJTree();
        
      
       
        countryNameJTextField.setVisible(true);
        addCountryNameJButton.setVisible(true);
        
        stateNameJTextField.setVisible(true);
        addStateNameJButton.setVisible(true);
        
        regionNameJTextField.setVisible(true);
        addRegionNameJButton.setVisible(true);
        
      
        enterpriseNameJLabel.setVisible(false);
        enterpriseNameJTextField.setVisible(false);
        enterpriseTypeJLabel.setVisible(false);
        enterpriseTypeJComboBox.setVisible(false);
        createEnterpriseJButton.setVisible(false);
        
        adminNameJLabel.setVisible(false);
        adminNameJTextField.setVisible(false);
        usernameJLabel.setVisible(false);
        usernameJTextField.setVisible(false);
        passwordJLabel.setVisible(false);
        passwordJTextField.setVisible(false);
        
        activeCountryJRadioButton.setVisible(true);
        activeStateJRadioButton.setVisible(true);
        activeRegionJRadioButton.setVisible(true);
        activeEnterpriseJRadioButton.setVisible(false);
        inactiveCountryJRadioButton.setVisible(true);
        inactiveStateJRadioButton.setVisible(true);
        inactiveRegionJRadioButton.setVisible(true);
        inactiveEnterpriseJRadioButton.setVisible(false);

        
       zipcodeJLabel.setVisible(false);
       zipcodeJTextField.setVisible(false);
       taxJLabel.setVisible(false);
       taxJTextField.setVisible(false);
       jSeparator1.setVisible(false);
       jSeparator2.setVisible(false);
       
        
        
    }//GEN-LAST:event_stateListJTreeValueChanged

    private void addRegionNameJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addRegionNameJButtonActionPerformed

        
        
        int count=0;
        if(regionNameJTextField.getText().isEmpty()){
            count++;
        }
        
        
        if(count==0)
        {
       
         int count1=0;
         for(CountryNetwork country:system.getCountryNetworkList()){
             for(StateNetwork state: country.getStateNetworkList()){
                 for(RegionNetwork region: state.getRegionNetworkList()){
                     if(region.getRegionName().equalsIgnoreCase(regionNameJTextField.getText())){
                         count1++;
                     }
                 }
             }
         }
         
         if(count1==0)
         {    
    
        
        
          
        ArrayList<CountryNetwork> countryNetworkList = system.getCountryNetworkList();
        
        
        for(int i=0;i<countryNetworkList.size();i++){
        
       try {
        if(countryNetworkList.get(i).getCountryName().equals(String.valueOf(countryListJTree.getSelectionPath().getLastPathComponent())))    
        {
        ArrayList<StateNetwork> stateNetworkList = countryNetworkList.get(i).getStateNetworkList();
        
        
        for(int j=0;j<stateNetworkList.size();j++){
        
        if(stateNetworkList.get(j).getStateName().equals(String.valueOf(stateListJTree.getSelectionPath().getLastPathComponent())))    
        {
        
            
       
        RegionNetwork rn = system.getCountryNetworkList().get(i).getStateNetworkList().get(j).createAndAddRegionNetwork(regionNameJTextField.getText());
        
        if(activeRegionJRadioButton.isSelected())
            rn.setStatus(activeRegionJRadioButton.getText());
        else if(inactiveRegionJRadioButton.isSelected())
            rn.setStatus(inactiveRegionJRadioButton.getText());
        
        db4OUtil.storeSystem(system);
        populateRegionListJTree();
        
        
        
        }
        
        
        }
        
        
        
        }
        
       } catch (NullPointerException e){}
        
        }   
       
        regionNameJTextField.setText(null);
        
        
         }
         else{
             
             
           JOptionPane.showMessageDialog(null, "Region already Exists");  
             
             
         }
        
        
    }
        else
        {
            JOptionPane.showMessageDialog(null, "Please fill the required fields");
        }
    
        
        regionNameJTextField.setText(null);
        stateNameJTextField.setText(null);
        countryNameJTextField.setText(null);
        enterpriseNameJTextField.setText(null);
        adminNameJTextField.setText(null);
        usernameJTextField.setText(null);
        passwordJTextField.setText(null);
        zipcodeJTextField.setText(null);
        taxJTextField.setText(null);
        
        
    }//GEN-LAST:event_addRegionNameJButtonActionPerformed

    private void regionListJTreeValueChanged(javax.swing.event.TreeSelectionEvent evt) {//GEN-FIRST:event_regionListJTreeValueChanged


        
        
        populateEnterpriseListJTree();
        populateEnterpriseTypeJCombobox();        
        
        countryNameJTextField.setVisible(true);
        addCountryNameJButton.setVisible(true);
        
        stateNameJTextField.setVisible(true);
        addStateNameJButton.setVisible(true);
        
        regionNameJTextField.setVisible(true);
        addRegionNameJButton.setVisible(true);
      
        
        enterpriseNameJLabel.setVisible(true);
        enterpriseNameJTextField.setVisible(true);
        enterpriseTypeJLabel.setVisible(true);
        enterpriseTypeJComboBox.setVisible(true);
        createEnterpriseJButton.setVisible(true);
        
        adminNameJLabel.setVisible(true);
        adminNameJTextField.setVisible(true);
        usernameJLabel.setVisible(true);
        usernameJTextField.setVisible(true);
        passwordJLabel.setVisible(true);
        passwordJTextField.setVisible(true);

         activeCountryJRadioButton.setVisible(true);
        activeStateJRadioButton.setVisible(true);
        activeRegionJRadioButton.setVisible(true);
        activeEnterpriseJRadioButton.setVisible(true);
        inactiveCountryJRadioButton.setVisible(true);
        inactiveStateJRadioButton.setVisible(true);
        inactiveRegionJRadioButton.setVisible(true);
        inactiveEnterpriseJRadioButton.setVisible(true);

        

       zipcodeJLabel.setVisible(true);
       zipcodeJTextField.setVisible(true);
       taxJLabel.setVisible(true);
       taxJTextField.setVisible(true); 
       jSeparator1.setVisible(true);
       jSeparator2.setVisible(true);
       

        
        
    }//GEN-LAST:event_regionListJTreeValueChanged

    private void createEnterpriseJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createEnterpriseJButtonActionPerformed

        
        
        int count=0;
        if(enterpriseNameJTextField.getText().isEmpty() || zipcodeJTextField.getText().isEmpty() || taxJTextField.getText().isEmpty() || adminNameJTextField.getText().isEmpty() || usernameJTextField.getText().isEmpty() || passwordJTextField.getText().isEmpty()){
            count++;
        }
        
        
        if(count==0)
        {
       
            
            
            
            
            
            
            
                                // Get user name
        String userName = usernameJTextField.getText();
        // Get Password
        String password = String.valueOf(passwordJTextField.getText());

        //Step1: Check in the EcoSystem
        UserAccount userAccount = system.getUserAccountDirectory().authenticateUser(userName, password);
        //Step2: If user account is not in the system's user account directory
        
        Enterprise inEnterprise = null;
        Organization inOrganization = null;
    
        
        
        String countryName = null;
        if (userAccount == null) {
//            1
            
            
            
            
            
            for (CountryNetwork countryNetwork : system.getCountryNetworkList()) {
//              2  
            countryName = countryNetwork.getCountryName();
                
                for (StateNetwork stateNetwork : countryNetwork.getStateNetworkList()) {
//              3  
        
                
                for (RegionNetwork regionNetwork : stateNetwork.getRegionNetworkList()) {
//              4  
                    
                    
                    
                for (Enterprise enterprise : regionNetwork.getEnterpriseDirectory().getEnterpriseList()) {
//               5     
                    
                 
                    
                    if (enterprise.getUserAccountDirectory().authenticateUser(userName, password) != null) {
                    userAccount = enterprise.getUserAccountDirectory().authenticateUser(userName, password);
                        inEnterprise = enterprise;
                        
                    }else{
                        
                        
                        for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
                           
                            userAccount = organization.getUserAccountDirectory().authenticateUser(userName, password);
                                if(userAccount!=null){
                                    inEnterprise = enterprise;
                                    inOrganization = organization;
                                   break;
                                    
                                    }
                            
                            }
                   
                        
                    } 
                    
               if (inEnterprise != null) {
                        break;
                    }
                   
               
                
                
         //       5  
                }
                
                if (inEnterprise != null) {
                        break;
                    }
                
                
           
                
        //           4     
                    }
        
                  
                
     //           3     
                }
                
                     
                
//           2     
            }
            
                   
        
 //    1       
        }
        

       
        
        
        
        
        
        CustomerAccount customerAccount=null;
       Amazon amazon = null; 
      if (userAccount == null && customerAccount==null) {
//            1
            
            
            
            for (CountryNetwork countryNetwork : system.getCountryNetworkList()) {
//              2  
            countryName = countryNetwork.getCountryName();
                
                for (StateNetwork stateNetwork : countryNetwork.getStateNetworkList()) {
//              3  
        
                
                for (RegionNetwork regionNetwork : stateNetwork.getRegionNetworkList()) {
//              4  
                    
                    
                    
                for (Enterprise enterprise : regionNetwork.getEnterpriseDirectory().getEnterpriseList()) {
//               5     
      
                    
                    
                 
          if(enterprise instanceof Amazon){
           amazon = (Amazon)enterprise;
              
           inEnterprise = amazon;
           

           if(amazon.getCustomerAccountDirectory().authenticateCustomer(userName, password)!=null){
               
           customerAccount = amazon.getCustomerAccountDirectory().authenticateCustomer(userName, password);
           
           break;
             }      
          
           
        }          
                    
               
                   
               
                
                
         //       5  
                }
                
                if(inEnterprise!=null)
                    break;
                 
           
                
        //           4     
                    }
        
                if(inEnterprise!=null)
                    break;
                 
                
     //           3     
                }
                
                if(inEnterprise!=null)
                    break;
                 
                
//           2     
            }
            
            
        
 //    1       
        }
          
//.............................................................................................
      
   
      
      
      
      
      
      
      
      
ArrayList<CountryNetwork> countryNetworkList = system.getCountryNetworkList();
        Amazon amazonEnterprise = null; 
        
        for(int i=0;i<countryNetworkList.size();i++){
        
       try {
        if(countryNetworkList.get(i).getCountryName().equals(countryName))    
        {
        ArrayList<StateNetwork> stateNetworkList = countryNetworkList.get(i).getStateNetworkList();
        
        
        for(int j=0;j<stateNetworkList.size();j++){
        
       
        ArrayList<RegionNetwork> regionNetworkList = stateNetworkList.get(j).getRegionNetworkList();
        
        
        
        
        for(int k=0;k<regionNetworkList.size();k++){
        
        
        
      ArrayList<Enterprise> enterpriseList = regionNetworkList.get(k).getEnterpriseDirectory().getEnterpriseList();  
        
       
      for(int l=0;l<enterpriseList.size();l++){
        
          if(enterpriseList.get(l) instanceof Amazon){
             amazonEnterprise = (Amazon)enterpriseList.get(l);
             
          
        }
        
      

      
   
        
        }
        
        }
        
        

        
        
        
        
        
        }
        

        
        }
        
       } catch (NullPointerException e){}
        
        }
        
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
      if (userAccount == null && customerAccount==null) {   

          
          
          
          
          
          
          
          
          
          
          
          
          
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
     
         countryNetworkList = system.getCountryNetworkList();
        
        
        for(int i=0;i<countryNetworkList.size();i++){
        
       try {
        if(countryNetworkList.get(i).getCountryName().equals(String.valueOf(countryListJTree.getSelectionPath().getLastPathComponent())))    
        {
        ArrayList<StateNetwork> stateNetworkList = countryNetworkList.get(i).getStateNetworkList();
        
        
        for(int j=0;j<stateNetworkList.size();j++){
        
        if(stateNetworkList.get(j).getStateName().equals(String.valueOf(stateListJTree.getSelectionPath().getLastPathComponent())))    
        {
  
        ArrayList<RegionNetwork> regionNetworkList = stateNetworkList.get(j).getRegionNetworkList();
        
            
        for(int k=0;k<regionNetworkList.size();k++){
            
            
        if(regionNetworkList.get(k).getRegionName().equals(String.valueOf(regionListJTree.getSelectionPath().getLastPathComponent())))    
        {
  
            EnterpriseDirectory enterpriseDirectory = regionNetworkList.get(k).getEnterpriseDirectory();
        
    
        if(enterpriseTypeJComboBox.getSelectedItem().equals(Enterprise.EnterpriseType.AMAZON))
        {    
        Amazon enterprise =  (Amazon)enterpriseDirectory.createAndAddEnterprise(enterpriseNameJTextField.getText(), Enterprise.EnterpriseType.AMAZON); 
        
        if(activeEnterpriseJRadioButton.isSelected())
          enterprise.setStatus(activeEnterpriseJRadioButton.getText().toString());
        else if(inactiveEnterpriseJRadioButton.isSelected())
          enterprise.setStatus(inactiveEnterpriseJRadioButton.getText().toString());
        
                
        
        Employee employee = enterprise.getEmployeeDirectory().createEmployee(adminNameJTextField.getText());
        enterprise.getUserAccountDirectory().createUserAccount(usernameJTextField.getText(), passwordJTextField.getText(), employee, new AmazonAdminRole());
        enterprise.getOrganizationDirectory().createOrganization(Organization.Type.AmazonSales);
        enterprise.getOrganizationDirectory().createOrganization(Organization.Type.AmazonInventory);
        enterprise.getOrganizationDirectory().createOrganization(Organization.Type.AmazonFinance);
        enterprise.getOrganizationDirectory().createOrganization(Organization.Type.AmazonShipment);
        enterprise.getOrganizationDirectory().createOrganization(Organization.Type.AmazonCustomerService);
        enterprise.getOrganizationDirectory().createOrganization(Organization.Type.AmazonAdmin);
        } 
        else if(enterpriseTypeJComboBox.getSelectedItem().equals(Enterprise.EnterpriseType.SUPPLIER))
        {
        Supplier enterprise =  (Supplier)enterpriseDirectory.createAndAddEnterprise(enterpriseNameJTextField.getText(), Enterprise.EnterpriseType.SUPPLIER); 
        
        enterprise.setZipcode(zipcodeJTextField.getText());
        enterprise.setTax(Float.parseFloat(taxJTextField.getText()));
        
        
        
   ArrayList<Integer> numbers = new ArrayList<>();
     for(int t = 1; t < 99999; t++)
     {
     numbers.add(t);
   }
 
     Collections.shuffle(numbers);
     
      int n0 = (int)(Math.random() * (99999 - 1)) + 1;
      int n1 = (int)(Math.random() * (99999 - 1)) + 1;
      
        int id = (int) Math.pow(10, Math.floor(Math.log10(numbers.get(n1)))+1)*numbers.get(n0) + numbers.get(n1);       
  
        if(id<0){
            id *= -1;
        }
            
            enterprise.setId(id);
        
        if(activeEnterpriseJRadioButton.isSelected())
          enterprise.setStatus(activeEnterpriseJRadioButton.getText().toString());
        else if(inactiveEnterpriseJRadioButton.isSelected())
          enterprise.setStatus(inactiveEnterpriseJRadioButton.getText().toString());
        
        
        
        
        
        
        
     try
{   
        

                
    
    
    File file = new File("SupplierDirectory.txt");
      
    if(!file.exists()){
      file.createNewFile();
    }

    
    
            Scanner fileReader = new Scanner(new File("USA.txt")); 
            Scanner lineReader;

            while(fileReader.hasNext()) {

                String info = fileReader.nextLine();

                lineReader = new Scanner(info);
                lineReader.useDelimiter(",");

                //here is what we are getting in from the text doc
                String zip = lineReader.next();
      
                if(zip.equals(zipcodeJTextField.getText())) {  
                int entId = enterprise.getId();
                String city = lineReader.next();
                String state = lineReader.next();
                double longitude = lineReader.nextDouble();
                double latitude = lineReader.nextDouble();    
      
                  String newline = System.getProperty("line.separator");
                
  FileWriter entry = new FileWriter(file,true);
  BufferedWriter out = new BufferedWriter(entry);
  out.append(entId+","+zip+","+city+","+"USA"+","+state+","+longitude+","+latitude+newline);
  out.close();  
  break;
    
         }
                
  
                
    
    
            }
    
      
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}catch (Exception e)
{
   System.err.println("Error: " + e.getMessage());
}
   
        
        
        
        
        Employee employee = enterprise.getEmployeeDirectory().createEmployee(adminNameJTextField.getText());
        enterprise.getUserAccountDirectory().createUserAccount(usernameJTextField.getText(), passwordJTextField.getText(), employee, new SupplierAdminRole());
        enterprise.getOrganizationDirectory().createOrganization(Organization.Type.SupplierSales);
        enterprise.getOrganizationDirectory().createOrganization(Organization.Type.SupplierInventory);
        enterprise.getOrganizationDirectory().createOrganization(Organization.Type.SupplierFinance);
        enterprise.getOrganizationDirectory().createOrganization(Organization.Type.SupplierShipment);
            
        }
           
        
        if(activeEnterpriseJRadioButton.isSelected())
            enterprise.setStatus(activeEnterpriseJRadioButton.getText());
        else if(inactiveEnterpriseJRadioButton.isSelected())
            enterprise.setStatus(inactiveEnterpriseJRadioButton.getText());
        
         
         
               
         
        
           
            
            
            
        }
         
        
        }    
            
      
        }
        
        
        }
        
        
        
        }
        
       } catch (NullPointerException e){}
        
        }   
       
        regionNameJTextField.setText(null);
        stateNameJTextField.setText(null);
        countryNameJTextField.setText(null);
        enterpriseNameJTextField.setText(null);
        adminNameJTextField.setText(null);
        usernameJTextField.setText(null);
        passwordJTextField.setText(null);
        zipcodeJTextField.setText(null);
        taxJTextField.setText(null);
        
        
       
        db4OUtil.storeSystem(system);
        populateEnterpriseTypeJCombobox(); 
        populateEnterpriseListJTree();
        
        
      }
     else{
         JOptionPane.showMessageDialog(null, "zipcode doesn't exist");
     }
     
      }
      
      else{
            
            JOptionPane.showMessageDialog(null, "Username Already exist");
            
        }
        
        
        
        }
        else{
            
            JOptionPane.showMessageDialog(null, "Please fill the required fields");
            
        }
        
    }//GEN-LAST:event_createEnterpriseJButtonActionPerformed

    private void enterpriseNameJTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enterpriseNameJTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_enterpriseNameJTextFieldActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);        
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void countryNameJTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_countryNameJTextFieldKeyTyped
        
        char c =evt.getKeyChar();
       if(!(Character.isAlphabetic(c) || (c== KeyEvent.VK_BACK_SPACE) || (c==KeyEvent.VK_DELETE)) ){
           evt.consume();
       }
        
    }//GEN-LAST:event_countryNameJTextFieldKeyTyped

    private void stateNameJTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_stateNameJTextFieldKeyTyped
        
        char c =evt.getKeyChar();
       if(!(Character.isAlphabetic(c) || (c== KeyEvent.VK_BACK_SPACE) || (c==KeyEvent.VK_DELETE)) ){
           evt.consume();
       }
        
    }//GEN-LAST:event_stateNameJTextFieldKeyTyped

    private void regionNameJTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_regionNameJTextFieldKeyTyped
        
        char c =evt.getKeyChar();
       if(!(Character.isAlphabetic(c) || (c== KeyEvent.VK_BACK_SPACE) || (c==KeyEvent.VK_DELETE)) ){
           evt.consume();
       }
        
    }//GEN-LAST:event_regionNameJTextFieldKeyTyped

    private void enterpriseNameJTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_enterpriseNameJTextFieldKeyTyped
        
      char c =evt.getKeyChar();
       if(!(Character.isLetterOrDigit(c) || (c== KeyEvent.VK_BACK_SPACE) || (c==KeyEvent.VK_DELETE)) ){
           evt.consume();
       }    
        
    }//GEN-LAST:event_enterpriseNameJTextFieldKeyTyped

    private void zipcodeJTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_zipcodeJTextFieldKeyTyped
        
      char c =evt.getKeyChar();
       if(!(Character.isLetterOrDigit(c) || (c== KeyEvent.VK_BACK_SPACE) || (c==KeyEvent.VK_DELETE)) ){
           evt.consume();
       }  
        
    }//GEN-LAST:event_zipcodeJTextFieldKeyTyped

    private void taxJTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_taxJTextFieldKeyTyped

       char c =evt.getKeyChar();
       if(!(Character.isDigit(c) || (c== KeyEvent.VK_BACK_SPACE) || (c==KeyEvent.VK_DELETE) ) ){
           evt.consume();
       } 
        
    }//GEN-LAST:event_taxJTextFieldKeyTyped

    private void adminNameJTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_adminNameJTextFieldKeyTyped

        char c =evt.getKeyChar();
       if(!(Character.isAlphabetic(c) || (c== KeyEvent.VK_BACK_SPACE) || (c==KeyEvent.VK_DELETE)) ){
           evt.consume();
       }
        
    }//GEN-LAST:event_adminNameJTextFieldKeyTyped

    private void usernameJTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_usernameJTextFieldKeyTyped
       
        char c =evt.getKeyChar();
       if(((c==KeyEvent.VK_SPACE) ) ){
           evt.consume();
       }
        
    }//GEN-LAST:event_usernameJTextFieldKeyTyped

    private void passwordJTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passwordJTextFieldKeyTyped
        
        char c =evt.getKeyChar();
       if(((c==KeyEvent.VK_SPACE) ) ){
           evt.consume();
       }
        
    }//GEN-LAST:event_passwordJTextFieldKeyTyped

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton activeCountryJRadioButton;
    private javax.swing.JRadioButton activeEnterpriseJRadioButton;
    private javax.swing.JRadioButton activeRegionJRadioButton;
    private javax.swing.JRadioButton activeStateJRadioButton;
    private javax.swing.JButton addCountryNameJButton;
    private javax.swing.JButton addRegionNameJButton;
    private javax.swing.JButton addStateNameJButton;
    private javax.swing.JLabel adminNameJLabel;
    private javax.swing.JTextField adminNameJTextField;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.JTree countryListJTree;
    private javax.swing.JTextField countryNameJTextField;
    private javax.swing.JButton createEnterpriseJButton;
    private javax.swing.JTree enterpriseListJTree;
    private javax.swing.JLabel enterpriseNameJLabel;
    private javax.swing.JTextField enterpriseNameJTextField;
    private javax.swing.JComboBox enterpriseTypeJComboBox;
    private javax.swing.JLabel enterpriseTypeJLabel;
    private javax.swing.JRadioButton inactiveCountryJRadioButton;
    private javax.swing.JRadioButton inactiveEnterpriseJRadioButton;
    private javax.swing.JRadioButton inactiveRegionJRadioButton;
    private javax.swing.JRadioButton inactiveStateJRadioButton;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel passwordJLabel;
    private javax.swing.JTextField passwordJTextField;
    private javax.swing.JTree regionListJTree;
    private javax.swing.JTextField regionNameJTextField;
    private javax.swing.JTree stateListJTree;
    private javax.swing.JTextField stateNameJTextField;
    private javax.swing.JLabel taxJLabel;
    private javax.swing.JTextField taxJTextField;
    private javax.swing.JLabel usernameJLabel;
    private javax.swing.JTextField usernameJTextField;
    private javax.swing.JLabel zipcodeJLabel;
    private javax.swing.JTextField zipcodeJTextField;
    // End of variables declaration//GEN-END:variables
}
