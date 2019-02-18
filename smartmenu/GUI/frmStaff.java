/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartmenu.GUI;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import smartmenu.Controller;
import smartmenu.MainClasses.Feedback;
import smartmenu.MainClasses.Item;
import smartmenu.MainClasses.Order;
import smartmenu.PersonClasses.Customer;
import smartmenu.PersonClasses.Person;
import smartmenu.PersonClasses.Staff;


public class frmStaff extends javax.swing.JFrame {

    //variable
    private Staff currentStaff;
    
    //Overloading Constructor
    public frmStaff(Staff currentStaff) {
        initComponents();
        this.Remove.setVisible(false);
        this.Add.setVisible(false);
        this.currentStaff = currentStaff;
        this.jLabel1.repaint();
        this.jLabel1.setText(currentStaff.getName());
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ADDNEWITEM = new javax.swing.JDialog();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        NAME = new javax.swing.JTextField();
        PRICE = new javax.swing.JTextField();
        ADDITEm = new javax.swing.JButton();
        BurgerChoice = new javax.swing.JRadioButton();
        DesertChoice = new javax.swing.JRadioButton();
        BeveragesChoice = new javax.swing.JRadioButton();
        CLOSEADDITEM = new javax.swing.JButton();
        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        ORDERS = new javax.swing.JButton();
        EDITMENU = new javax.swing.JButton();
        CLIENTS = new javax.swing.JButton();
        LogOut = new javax.swing.JButton();
        FEEDBACK = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        Remove = new javax.swing.JButton();
        Add = new javax.swing.JButton();

        ADDNEWITEM.setModal(true);
        ADDNEWITEM.setSize(new java.awt.Dimension(477, 536));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/smartmenu/GUI/icons/Webp.net-resizeimage (26).png"))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 0, 51));
        jLabel4.setText("Adding New Item");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(139, 139, 139))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        jPanel4.setBackground(new java.awt.Color(255, 153, 0));

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Category");

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Price");

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Name");

        PRICE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PRICEActionPerformed(evt);
            }
        });

        ADDITEm.setBackground(new java.awt.Color(153, 0, 51));
        ADDITEm.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        ADDITEm.setForeground(new java.awt.Color(255, 255, 255));
        ADDITEm.setText("ADD");
        ADDITEm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ADDITEmActionPerformed(evt);
            }
        });

        buttonGroup2.add(BurgerChoice);
        BurgerChoice.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        BurgerChoice.setForeground(new java.awt.Color(255, 255, 255));
        BurgerChoice.setText("Burger");

        buttonGroup2.add(DesertChoice);
        DesertChoice.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        DesertChoice.setForeground(new java.awt.Color(255, 255, 255));
        DesertChoice.setText("Desert");
        DesertChoice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DesertChoiceActionPerformed(evt);
            }
        });

        buttonGroup2.add(BeveragesChoice);
        BeveragesChoice.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        BeveragesChoice.setForeground(new java.awt.Color(255, 255, 255));
        BeveragesChoice.setText("beverages");

        CLOSEADDITEM.setBackground(new java.awt.Color(153, 0, 51));
        CLOSEADDITEM.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        CLOSEADDITEM.setForeground(new java.awt.Color(255, 255, 255));
        CLOSEADDITEM.setText("Cancle");
        CLOSEADDITEM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CLOSEADDITEMActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(CLOSEADDITEM, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ADDITEm, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(54, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5))
                .addGap(27, 27, 27)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(BurgerChoice)
                        .addGap(18, 18, 18)
                        .addComponent(DesertChoice)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(BeveragesChoice))
                    .addComponent(PRICE)
                    .addComponent(NAME, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NAME, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PRICE, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(BurgerChoice)
                        .addComponent(DesertChoice)
                        .addComponent(BeveragesChoice)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ADDITEm, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CLOSEADDITEM, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
        );

        javax.swing.GroupLayout ADDNEWITEMLayout = new javax.swing.GroupLayout(ADDNEWITEM.getContentPane());
        ADDNEWITEM.getContentPane().setLayout(ADDNEWITEMLayout);
        ADDNEWITEMLayout.setHorizontalGroup(
            ADDNEWITEMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        ADDNEWITEMLayout.setVerticalGroup(
            ADDNEWITEMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ADDNEWITEMLayout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 153, 0));
        jLabel1.setText("ad");

        ORDERS.setBackground(new java.awt.Color(255, 255, 255));
        ORDERS.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        ORDERS.setForeground(new java.awt.Color(255, 153, 0));
        ORDERS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/smartmenu/GUI/icons/order.png"))); // NOI18N
        ORDERS.setText(" Orders");
        ORDERS.setBorder(null);
        ORDERS.setBorderPainted(false);
        ORDERS.setContentAreaFilled(false);
        ORDERS.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ORDERS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ORDERSActionPerformed(evt);
            }
        });

        EDITMENU.setBackground(new java.awt.Color(255, 255, 255));
        EDITMENU.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        EDITMENU.setForeground(new java.awt.Color(255, 153, 0));
        EDITMENU.setIcon(new javax.swing.ImageIcon(getClass().getResource("/smartmenu/GUI/icons/ediit.png"))); // NOI18N
        EDITMENU.setText("  Edit Menu");
        EDITMENU.setBorder(null);
        EDITMENU.setBorderPainted(false);
        EDITMENU.setContentAreaFilled(false);
        EDITMENU.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        EDITMENU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EDITMENUActionPerformed(evt);
            }
        });

        CLIENTS.setBackground(new java.awt.Color(255, 255, 255));
        CLIENTS.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        CLIENTS.setForeground(new java.awt.Color(255, 153, 0));
        CLIENTS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/smartmenu/GUI/icons/clients.png"))); // NOI18N
        CLIENTS.setText(" Clients Info");
        CLIENTS.setBorder(null);
        CLIENTS.setBorderPainted(false);
        CLIENTS.setContentAreaFilled(false);
        CLIENTS.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        CLIENTS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CLIENTSActionPerformed(evt);
            }
        });

        LogOut.setBackground(new java.awt.Color(181, 0, 0));
        LogOut.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        LogOut.setForeground(new java.awt.Color(255, 255, 255));
        LogOut.setText("Log Out");
        LogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogOutActionPerformed(evt);
            }
        });

        FEEDBACK.setBackground(new java.awt.Color(255, 255, 255));
        FEEDBACK.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        FEEDBACK.setForeground(new java.awt.Color(255, 153, 0));
        FEEDBACK.setIcon(new javax.swing.ImageIcon(getClass().getResource("/smartmenu/GUI/icons/Feedback.png"))); // NOI18N
        FEEDBACK.setText("  Feedback");
        FEEDBACK.setBorder(null);
        FEEDBACK.setBorderPainted(false);
        FEEDBACK.setContentAreaFilled(false);
        FEEDBACK.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        FEEDBACK.setPreferredSize(new java.awt.Dimension(135, 60));
        FEEDBACK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FEEDBACKActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(LogOut, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(EDITMENU, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(CLIENTS, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ORDERS, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(FEEDBACK, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 13, Short.MAX_VALUE))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ORDERS, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(CLIENTS, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(EDITMENU, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(FEEDBACK, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(LogOut, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(153, 0, 51));
        jPanel2.setForeground(new java.awt.Color(204, 0, 51));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/smartmenu/GUI/icons/Webp.net-resizeimage (26).png"))); // NOI18N

        jTable1.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Phone", "User Name"
            }
        ));
        jTable1.setRowHeight(27);
        jTable1.setSelectionBackground(new java.awt.Color(255, 153, 0));
        jScrollPane1.setViewportView(jTable1);

        Remove.setBackground(new java.awt.Color(255, 102, 0));
        Remove.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        Remove.setForeground(new java.awt.Color(255, 255, 255));
        Remove.setText("Remove Item");
        Remove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RemoveActionPerformed(evt);
            }
        });

        Add.setBackground(new java.awt.Color(255, 102, 0));
        Add.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        Add.setForeground(new java.awt.Color(255, 255, 255));
        Add.setText("Add New Item");
        Add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(62, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(Add, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Remove, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(49, 49, 49))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Remove, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Add, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
    //Mange Jtable to displlay Orders, Items, Cusomers and Feedback
    public void addOrdersToRows(){
        repaint();
        jTable1.getColumnModel().getColumn(0).setHeaderValue("ID");
        repaint();
        jTable1.getColumnModel().getColumn(1).setHeaderValue("Customer ID");
        repaint();
        jTable1.getColumnModel().getColumn(2).setHeaderValue("Date");
        repaint();
        jTable1.getColumnModel().getColumn(3).setHeaderValue("Total Price");
        ArrayList<Order> list = Controller.OrdersData();
        DefaultTableModel model = (DefaultTableModel) this.jTable1.getModel();
        Object rowData[] = new Object[5];
        Order o = new Order();
        int size = list.size();
        int rows = model.getRowCount(); 
        for(int i = rows - 1; i >=0; i--)
        {
            model.removeRow(i); 
        }
        for(int i = 0; i < size; i++ ) {
            o = list.get(i);
            rowData[0]=  o.getId();
            rowData[1]=  o.getCustomerID();
            rowData[2]=  o.getDate();
            rowData[3]=  o.getTotalPrice();
            model.addRow(rowData);
        }
    }
    public void addProductsToRows(){
        this.Remove.setVisible(true);
        this.Add.setVisible(true);
        repaint();
        jTable1.getColumnModel().getColumn(0).setHeaderValue("ID");
        repaint();
        jTable1.getColumnModel().getColumn(1).setHeaderValue("Name");
        repaint();
        jTable1.getColumnModel().getColumn(2).setHeaderValue("Price");
        repaint();
        jTable1.getColumnModel().getColumn(3).setHeaderValue("Category");
        ArrayList<Item> menu = new ArrayList<Item>();
        menu = Controller.Items();
        Item newItem ;
        DefaultTableModel model = (DefaultTableModel) this.jTable1.getModel();
        Object rowData[] = new Object[5];
        int size = menu.size();
        int rows = model.getRowCount(); 
        for(int i = rows - 1; i >=0; i--)
        {
            model.removeRow(i); 
        }
        for(int i = 0; i < size; i++ ) {
            newItem = menu.get(i);
            rowData[0]=  newItem.getId();
            rowData[1]=  newItem.getName();
            rowData[2]=  newItem.getPrice();
            rowData[3]=  newItem.getCategory();
            model.addRow(rowData);
        }
    }
    public void addCustomersToRows(){
        this.Remove.setVisible(false);
        this.Add.setVisible(false);
        jTable1.getColumnModel().getColumn(0).setHeaderValue("ID");
        jTable1.getColumnModel().getColumn(1).setHeaderValue("Name");
        jTable1.getColumnModel().getColumn(2).setHeaderValue("Phone Number");
        jTable1.getColumnModel().getColumn(3).setHeaderValue("User Name");
        repaint();
        ArrayList<Person> p = new ArrayList<Person>();
        p = Controller.getCustomersData();
        DefaultTableModel model = (DefaultTableModel) this.jTable1.getModel();
        Object rowData[] = new Object[5];
        Customer c = new Customer();
        int size = p.size();
        int rows = model.getRowCount(); 
        for(int i = rows - 1; i >=0; i--)
        {
            model.removeRow(i); 
        }
        for(int i = 0; i < size; i++ ) {
            c = (Customer) p.get(i);
            rowData[0]=  c.getID();
            rowData[1]=  c.getName();
            rowData[2]=  c.getPhone();
            rowData[3]=  c.getUsername();
            model.addRow(rowData);
        }
    }
    public void addFeedbackToRows(){
        this.Remove.setVisible(false);
        this.Add.setVisible(false);
        jTable1.getColumnModel().getColumn(0).setHeaderValue("ID");
        jTable1.getColumnModel().getColumn(1).setHeaderValue("Rate");
        jTable1.getColumnModel().getColumn(2).setHeaderValue("Comment");
        jTable1.getColumnModel().getColumn(3).setHeaderValue("Customer");
        repaint();
        ArrayList<Feedback> list = Controller.FeedbackData();
        DefaultTableModel model = (DefaultTableModel) this.jTable1.getModel();
        Object rowData[] = new Object[5];
        Feedback f = null;
        int size = list.size();
        int rows = model.getRowCount(); 
        for(int i = rows - 1; i >=0; i--)
        {
            model.removeRow(i); 
        }
        for(int i = 0; i < size; i++ ) {
            f = list.get(i);
            rowData[0]=  f.getId();
            rowData[1]=  f.getRate();
            rowData[2]=  f.getComment();
            rowData[3]=  f.getCustomer().getName();
            model.addRow(rowData);
        }
    }
    
    //Send Item Information to be added to database
    public void addItemToStock(){
        String choice = "";
        if(this.BurgerChoice.isSelected())
            choice = "Burger";
        else if(this.DesertChoice.isSelected())
            choice = "Desert";
        else if(this.BeveragesChoice.isSelected())
            choice = "beverages";
        Double p = Double.valueOf(PRICE.getText());
        Item item = new Item(NAME.getText(),p,choice);
        Controller.AddItem(item);
        this.ADDNEWITEM.setVisible(false);
    }
    
    
    private void ORDERSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ORDERSActionPerformed
      this.addOrdersToRows();
    }//GEN-LAST:event_ORDERSActionPerformed

    private void CLIENTSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CLIENTSActionPerformed
        addCustomersToRows();
    }//GEN-LAST:event_CLIENTSActionPerformed

    private void LogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogOutActionPerformed
       new frmLogin().setVisible(true);
       this.dispose();
    }//GEN-LAST:event_LogOutActionPerformed

    private void EDITMENUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EDITMENUActionPerformed
       this.addProductsToRows();
    }//GEN-LAST:event_EDITMENUActionPerformed

    private void RemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RemoveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RemoveActionPerformed

    private void AddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddActionPerformed
        this.ADDNEWITEM.setVisible(true);
    }//GEN-LAST:event_AddActionPerformed

    private void FEEDBACKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FEEDBACKActionPerformed
        addFeedbackToRows();
    }//GEN-LAST:event_FEEDBACKActionPerformed

    private void PRICEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PRICEActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PRICEActionPerformed

    private void ADDITEmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ADDITEmActionPerformed
        this.addItemToStock();
    }//GEN-LAST:event_ADDITEmActionPerformed

    private void DesertChoiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DesertChoiceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DesertChoiceActionPerformed

    private void CLOSEADDITEMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CLOSEADDITEMActionPerformed
        this.ADDNEWITEM.setVisible(false);
    }//GEN-LAST:event_CLOSEADDITEMActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ADDITEm;
    private javax.swing.JDialog ADDNEWITEM;
    private javax.swing.JButton Add;
    private javax.swing.JRadioButton BeveragesChoice;
    private javax.swing.JRadioButton BurgerChoice;
    private javax.swing.JButton CLIENTS;
    private javax.swing.JButton CLOSEADDITEM;
    private javax.swing.JRadioButton DesertChoice;
    private javax.swing.JButton EDITMENU;
    private javax.swing.JButton FEEDBACK;
    private javax.swing.JButton LogOut;
    private javax.swing.JTextField NAME;
    private javax.swing.JButton ORDERS;
    private javax.swing.JTextField PRICE;
    private javax.swing.JButton Remove;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
