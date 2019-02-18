package smartmenu.GUI;
import java.awt.Frame;
import java.awt.event.KeyEvent;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import smartmenu.Controller;
import smartmenu.MainClasses.CreditCard;
import smartmenu.MainClasses.Feedback;
import smartmenu.MainClasses.Item;
import smartmenu.MainClasses.Order;
import smartmenu.PersonClasses.Customer;

public class frmCustomer extends javax.swing.JFrame {
    //Variables
    private Order order;
    private Customer currentCustomer;
    private CreditCard creditCard;
    boolean doneCredit = false;
    //Overloading Constructor
    public frmCustomer(Customer currentCustomer) {
        creditCard = new CreditCard();
        this.setVisible(true);
        initComponents();
        this.currentCustomer = currentCustomer ;
        MENU.setDefaultEditor(Object.class, null);
        order = new Order();
        AllItems.setSelected(true);
        this.CLIENTNAME.setText(currentCustomer.getName());
        addRows();
    }
    
    //Constructor
    public frmCustomer(){
        initComponents();
        
        MENU.setDefaultEditor(Object.class, null);
        order = new Order();
        AllItems.setSelected(true);
        addRows();
    }
    
    //Adding items To jtable and categorize them
    public void addRows(){
        
        ArrayList<Item> menu = new ArrayList<Item>();
        menu = Controller.Items();
        Item newItem ;
        DefaultTableModel model = (DefaultTableModel) this.MENU.getModel();
        Object rowData[] = new Object[30];
        int size = menu.size();
        int rows = model.getRowCount();
        for(int i = rows - 1; i >=0; i--)
        {
            model.removeRow(i);
        }
        for(int i = 0; i < size; i++ ) {
            newItem = menu.get(i);
            rowData[0]=  newItem.getName();
            rowData[1]=  newItem.getPrice();
            model.addRow(rowData);
        }
    }
    public void addBurger(){
        ArrayList<Item> menu = new ArrayList<Item>();
        menu = Controller.Items();
        Item newItem ;
        DefaultTableModel model = (DefaultTableModel) this.MENU.getModel();
        Object rowData[] = new Object[30];
        int size = menu.size();
        int rows = model.getRowCount();
        for(int i = rows - 1; i >=0; i--)
        {
            model.removeRow(i);
        }
        for(int i = 0; i < size; i++ ) {
            newItem = menu.get(i);
            if (newItem.getCategory().equals("Burger")){
                rowData[0]=  newItem.getName();
                rowData[1]=  newItem.getPrice();
                model.addRow(rowData);
            }
        }
        
    }
    public void addDesert(){
        ArrayList<Item> menu = new ArrayList<Item>();
        menu = Controller.Items();
        Item newItem ;
        DefaultTableModel model = (DefaultTableModel) this.MENU.getModel();
        Object rowData[] = new Object[30];
        int size = menu.size();
        int rows = model.getRowCount();
        for(int i = rows - 1; i >=0; i--)
        {
            model.removeRow(i);
        }
        for(int i = 0; i < size; i++ ) {
            newItem = menu.get(i);
            if (newItem.getCategory().equals("Desert")){
                rowData[0]=  newItem.getName();
                rowData[1]=  newItem.getPrice();
                model.addRow(rowData);
            }
        }
    }
    public void addBev(){
        ArrayList<Item> menu = new ArrayList<Item>();
        menu = Controller.Items();
        Item newItem ;
        DefaultTableModel model = (DefaultTableModel) this.MENU.getModel();
        Object rowData[] = new Object[30];
        int size = menu.size();
        int rows = model.getRowCount();
        for(int i = rows - 1; i >=0; i--)
        {
            model.removeRow(i);
        }
        for(int i = 0; i < size; i++ ) {
            newItem = menu.get(i);
            if (newItem.getCategory().equals("beverages")){
                rowData[0]=  newItem.getName();
                rowData[1]=  newItem.getPrice();
                model.addRow(rowData);
            }
        }
    }
    
    //Adding items to cart
    public void addToCart() {
        Frame frame = new Frame();
        Object[] options = {"1", "2", "3", "4", "5", "6", "8","9","10","11","12"};
        String quantity = (String) JOptionPane.showInputDialog(frame," Please Slect quantity   ","Quantity",JOptionPane.ERROR_MESSAGE,new javax.swing.ImageIcon(getClass().getResource("/smartmenu/GUI/icons/Webp.net-resizeimage (32).png")),options,options[0]);
        int index = this.MENU.getSelectedRow();
        TableModel model =  this.MENU.getModel();
        String name="";
        try{
            name = (String) model.getValueAt(index, 0);
        }catch (Exception e){
            
        }
        Integer quant = null;
        try{
            quant = Integer.valueOf(quantity);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error:You did'nt Select quantity","Inane error",JOptionPane.ERROR_MESSAGE);
        }
        try{
            SendItem(name,quant);
        }catch(Exception e){
            
        }
    }
    public void SendItem(String name,int quantity){
        
        Item temp = Item.getITem(name);
        temp.SingleOrderQuantity(quantity);
        order.addItem(temp);
    }
    
    //Calculate the bill and display a recipt to the customer
        public void CheckOut(){
        ImageIcon icon = new javax.swing.ImageIcon(getClass().getResource("/smartmenu/GUI/icons/Webp.net-resizeimage (32).png"));
        Object[] options = {"Cash on Delivery","Credit card"};
        String payment;
        payment = (String) JOptionPane.showInputDialog(null," Select Payment Method   ","Payment",JOptionPane.ERROR_MESSAGE,icon,options,options[0]);
        if (payment.equals("Credit card"))
        {
            this.CREDITCARD.setVisible(true);
        }
        if (this.doneCredit == false && payment.equals("Credit card")){
            return;
        }
        order.setPayment(payment);
        String Recepit;
        Recepit = order.makeOrder();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDate localDate = LocalDate.now();
        order.setDate(dtf.format(localDate));
        order.setCustomer(currentCustomer);
        currentCustomer.addtoPreviousOrders(order);
        Controller.addToOrders(order);
        order = new Order();
        JOptionPane.showMessageDialog(null, Recepit+"\nThank You","Recpepit", JOptionPane.PLAIN_MESSAGE,icon);

    }
    
    //Search for certain item in menu
    public void search(){
        String Status = this.SEARCHBAR.getText();
        if(Item.getITem(Status)!=null){
            JOptionPane.showMessageDialog(null,"   The item Exists"     ,"Search",1,new javax.swing.ImageIcon(getClass().getResource("/smartmenu/GUI/icons/Webp.net-resizeimage (32).png")));
        }
        else{
            JOptionPane.showMessageDialog(null,"   The item Does not Exists     ","Search",1,new javax.swing.ImageIcon(getClass().getResource("/smartmenu/GUI/icons/Webp.net-resizeimage (32).png")));
        }
        
    }
    //Send Feedback to Order and Feedback database
    public void setFeedback(){
        String Comment = this.COMMENT.getText();
        int rate = this.RATE.getValue();
        if(Feedback.validateInput(rate, Comment)){
            Feedback fb = new Feedback(rate,Comment,currentCustomer);
            fb.setComment(Comment);
            fb.setRate(rate);
            
            Controller.addfeedback(fb);
            this.FEEDBACKFORM.setVisible(false);
        }
        else
            JOptionPane.showMessageDialog(null,"Please Enter Comment and Rate","ERROR",JOptionPane.ERROR_MESSAGE);
    }
    //add Credtit cart information
    public void setCreditCard(){
        if (this.CVVtxt.getText().isEmpty() ||this.expdatetxt.getText().isEmpty() || this.cardnumtxt.getText().isEmpty()){
            JOptionPane.showMessageDialog(null,"Please Enter the data","ERROR",JOptionPane.ERROR_MESSAGE);
            return;
        }
        creditCard.setExpDate(this.expdatetxt.getText());
        creditCard.setCvv(this.CVVtxt.getText());
        creditCard.setCardNumber(this.cardnumtxt.getText());
        doneCredit = true;
        JOptionPane.showMessageDialog(null,"The amount was successfully withdrawn","Done",JOptionPane.INFORMATION_MESSAGE);
        CREDITCARD.dispose();
    }
    
    //diplay images for items in jtable
    public void displayImages(){
        int index = this.MENU.getSelectedRow();
        TableModel model =  this.MENU.getModel();
        
        String name = (String) model.getValueAt(index, 0);
        if (name.equals("Iced Coffe")){
            
            MENUIMAGES.setIcon(new javax.swing.ImageIcon(getClass().getResource("/smartmenu/GUI/icons/ddice.jpg")));
        }
        else if(name.equalsIgnoreCase("Tea")){
            MENUIMAGES.setIcon(new javax.swing.ImageIcon(getClass().getResource("/smartmenu/GUI/icons/HotTea_Silo_Hi-229x300.png")));
        }
        else if(name.equals("Candy Shake")){
            MENUIMAGES.setIcon(new javax.swing.ImageIcon(getClass().getResource("/smartmenu/GUI/icons/DD-Frozen-Donut-Dunkaccino_vertDesktop.png")));
        }
        else if(name.equals("Coffe")){
            MENUIMAGES.setIcon(new javax.swing.ImageIcon(getClass().getResource("/smartmenu/GUI/icons/coffe.png")));
        }
        else if(name.equals("Caramel")){
            MENUIMAGES.setIcon(new javax.swing.ImageIcon(getClass().getResource("/smartmenu/GUI/icons/caramel.png")));
        }
        else if(name.equals("Pepsi")){
            MENUIMAGES.setIcon(new javax.swing.ImageIcon(getClass().getResource("/smartmenu/GUI/icons/pepsi.png")));
        }
        else if(name.equals("Cheese Burger")){
            MENUIMAGES.setIcon(new javax.swing.ImageIcon(getClass().getResource("/smartmenu/GUI/icons/cheese.png")));
        }
        else if(name.equals("BBQ Burger")){
            MENUIMAGES.setIcon(new javax.swing.ImageIcon(getClass().getResource("/smartmenu/GUI/icons/bbq.png")));
        }
        else if(name.equals("Black Burger")){
            MENUIMAGES.setIcon(new javax.swing.ImageIcon(getClass().getResource("/smartmenu/GUI/icons/black.png")));
        }
        else if (name.equals("Donut")){
            MENUIMAGES.setIcon(new javax.swing.ImageIcon(getClass().getResource("/smartmenu/GUI/icons/doun.png")));
        }
        else if (name.equals("Choclate Donut") || name.equals("Strawberry Donut")){
            MENUIMAGES.setIcon(new javax.swing.ImageIcon(getClass().getResource("/smartmenu/GUI/icons/dd.png")));
        }
        else if(name.equals("Donut box")){
            MENUIMAGES.setIcon(new javax.swing.ImageIcon(getClass().getResource("/smartmenu/GUI/icons/box.png")));
        }
        else{
            MENUIMAGES.setIcon(new javax.swing.ImageIcon(getClass().getResource("/smartmenu/GUI/icons/Webp.net-resizeimage (32).png")));
        }
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        FEEDBACKFORM = new javax.swing.JDialog();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        RATE = new javax.swing.JSlider();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        COMMENT = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        FEEDBACKAPRROVE = new javax.swing.JButton();
        CANCLE = new javax.swing.JButton();
        CREDITCARD = new javax.swing.JDialog();
        jPanel5 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        CVVtxt = new javax.swing.JTextField();
        cardnumtxt = new javax.swing.JTextField();
        expdatetxt = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        CancleCreditCard = new javax.swing.JButton();
        ApproveCREDITCARD = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        MENU = new javax.swing.JTable();
        MENUIMAGES = new javax.swing.JLabel();
        ADDTOCHECK = new javax.swing.JButton();
        LOGO = new javax.swing.JLabel();
        SEARCHBAR = new javax.swing.JTextField();
        CheckOut = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        AllItems = new javax.swing.JRadioButton();
        DESERTMENU = new javax.swing.JRadioButton();
        BURGERMENU = new javax.swing.JRadioButton();
        BEVERAGESMENU = new javax.swing.JRadioButton();
        PREVIOUSORDERS = new javax.swing.JButton();
        FEEDBACK = new javax.swing.JButton();
        CLIENTNAME = new javax.swing.JLabel();
        LogOut = new javax.swing.JButton();

        FEEDBACKFORM.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        FEEDBACKFORM.setModal(true);
        FEEDBACKFORM.setSize(new java.awt.Dimension(531, 645));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/smartmenu/GUI/icons/Webp.net-resizeimage (26).png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel2.setText("Your Opinion Matters");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(97, 97, 97))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(146, 146, 146)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(19, 19, 19))
        );

        jPanel3.setBackground(new java.awt.Color(153, 0, 51));
        jPanel3.setForeground(new java.awt.Color(204, 0, 51));

        RATE.setMaximum(10);

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 153, 0));
        jLabel5.setText("Rate Us From 1 to 10 :)");

        COMMENT.setColumns(20);
        COMMENT.setRows(5);
        jScrollPane1.setViewportView(COMMENT);

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 153, 0));
        jLabel6.setText("Comment");

        jLabel7.setText(" 1                                5                               10 ");

        FEEDBACKAPRROVE.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        FEEDBACKAPRROVE.setText("Done");
        FEEDBACKAPRROVE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FEEDBACKAPRROVEActionPerformed(evt);
            }
        });

        CANCLE.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        CANCLE.setText("Cancle");
        CANCLE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CANCLEActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(CANCLE, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(FEEDBACKAPRROVE, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(141, 141, 141)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(28, 28, 28)
                                        .addComponent(jLabel5))
                                    .addComponent(RATE, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(79, 79, 79)
                                .addComponent(jLabel6))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(79, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(RATE, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addGap(25, 25, 25)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(FEEDBACKAPRROVE, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CANCLE, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13))
        );

        javax.swing.GroupLayout FEEDBACKFORMLayout = new javax.swing.GroupLayout(FEEDBACKFORM.getContentPane());
        FEEDBACKFORM.getContentPane().setLayout(FEEDBACKFORMLayout);
        FEEDBACKFORMLayout.setHorizontalGroup(
            FEEDBACKFORMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        FEEDBACKFORMLayout.setVerticalGroup(
            FEEDBACKFORMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FEEDBACKFORMLayout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        CREDITCARD.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        CREDITCARD.setModal(true);
        CREDITCARD.setSize(new java.awt.Dimension(511, 591));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/smartmenu/GUI/icons/Webp.net-resizeimage (25).png"))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(153, 0, 51));
        jLabel4.setText("Credit Card");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(128, 128, 128))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(189, 189, 189)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(32, 32, 32))
        );

        jPanel6.setBackground(new java.awt.Color(153, 0, 51));

        cardnumtxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cardnumtxtActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("CVV");

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Card Number");

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("EXP/Date");

        CancleCreditCard.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        CancleCreditCard.setText("Cancle");
        CancleCreditCard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancleCreditCardActionPerformed(evt);
            }
        });

        ApproveCREDITCARD.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        ApproveCREDITCARD.setText("Done");
        ApproveCREDITCARD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ApproveCREDITCARDActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cardnumtxt, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(expdatetxt, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addGap(0, 3, Short.MAX_VALUE)
                        .addComponent(CVVtxt, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(59, 59, 59))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(CancleCreditCard, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ApproveCREDITCARD, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CVVtxt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(41, 41, 41)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cardnumtxt, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(expdatetxt, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CancleCreditCard, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ApproveCREDITCARD, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
        );

        javax.swing.GroupLayout CREDITCARDLayout = new javax.swing.GroupLayout(CREDITCARD.getContentPane());
        CREDITCARD.getContentPane().setLayout(CREDITCARDLayout);
        CREDITCARDLayout.setHorizontalGroup(
            CREDITCARDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        CREDITCARDLayout.setVerticalGroup(
            CREDITCARDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CREDITCARDLayout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel4.setBackground(new java.awt.Color(255, 153, 0));
        jPanel4.setForeground(new java.awt.Color(255, 153, 0));

        MENU.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        MENU.setForeground(new java.awt.Color(204, 0, 102));
        MENU.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Price"
            }
        ));
        MENU.setRowHeight(30);
        MENU.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MENUMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(MENU);

        MENUIMAGES.setForeground(new java.awt.Color(255, 255, 255));

        ADDTOCHECK.setBackground(new java.awt.Color(153, 0, 102));
        ADDTOCHECK.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        ADDTOCHECK.setForeground(new java.awt.Color(255, 255, 255));
        ADDTOCHECK.setText("Add to Cart");
        ADDTOCHECK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ADDTOCHECKActionPerformed(evt);
            }
        });

        LOGO.setIcon(new javax.swing.ImageIcon(getClass().getResource("/smartmenu/GUI/icons/Webp.net-resizeimage (25).png"))); // NOI18N

        SEARCHBAR.setText("Search for Item");
        SEARCHBAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SEARCHBARActionPerformed(evt);
            }
        });
        SEARCHBAR.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                SEARCHBARKeyPressed(evt);
            }
        });

        CheckOut.setBackground(new java.awt.Color(255, 255, 255));
        CheckOut.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        CheckOut.setForeground(new java.awt.Color(51, 51, 51));
        CheckOut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/smartmenu/GUI/icons/Webp.net-resizeimage (15).png"))); // NOI18N
        CheckOut.setText("CheckOut!   ");
        CheckOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CheckOutActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(204, 0, 102));

        buttonGroup1.add(AllItems);
        AllItems.setFont(new java.awt.Font("Dialog", 1, 17)); // NOI18N
        AllItems.setForeground(new java.awt.Color(255, 255, 255));
        AllItems.setText("All");
        AllItems.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AllItemsActionPerformed(evt);
            }
        });

        buttonGroup1.add(DESERTMENU);
        DESERTMENU.setFont(new java.awt.Font("Dialog", 1, 17)); // NOI18N
        DESERTMENU.setForeground(new java.awt.Color(255, 255, 255));
        DESERTMENU.setText("Desert");
        DESERTMENU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DESERTMENUActionPerformed(evt);
            }
        });

        buttonGroup1.add(BURGERMENU);
        BURGERMENU.setFont(new java.awt.Font("Dialog", 1, 17)); // NOI18N
        BURGERMENU.setForeground(new java.awt.Color(255, 255, 255));
        BURGERMENU.setText("Burgers");
        BURGERMENU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BURGERMENUActionPerformed(evt);
            }
        });

        buttonGroup1.add(BEVERAGESMENU);
        BEVERAGESMENU.setFont(new java.awt.Font("Dialog", 1, 17)); // NOI18N
        BEVERAGESMENU.setForeground(new java.awt.Color(255, 255, 255));
        BEVERAGESMENU.setText("Beverages");
        BEVERAGESMENU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BEVERAGESMENUActionPerformed(evt);
            }
        });

        PREVIOUSORDERS.setBackground(new java.awt.Color(255, 102, 0));
        PREVIOUSORDERS.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        PREVIOUSORDERS.setForeground(new java.awt.Color(255, 255, 255));
        PREVIOUSORDERS.setText("Previous Orders");
        PREVIOUSORDERS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PREVIOUSORDERSActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(AllItems)
                .addGap(83, 83, 83)
                .addComponent(DESERTMENU)
                .addGap(70, 70, 70)
                .addComponent(BURGERMENU)
                .addGap(86, 86, 86)
                .addComponent(BEVERAGESMENU)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(PREVIOUSORDERS)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PREVIOUSORDERS, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AllItems, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DESERTMENU, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BURGERMENU, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BEVERAGESMENU, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        FEEDBACK.setBackground(new java.awt.Color(153, 0, 102));
        FEEDBACK.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        FEEDBACK.setForeground(new java.awt.Color(255, 255, 255));
        FEEDBACK.setText("Feedback");
        FEEDBACK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FEEDBACKActionPerformed(evt);
            }
        });

        CLIENTNAME.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        CLIENTNAME.setForeground(new java.awt.Color(255, 255, 255));
        CLIENTNAME.setText("jLabel8");

        LogOut.setBackground(new java.awt.Color(181, 0, 0));
        LogOut.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        LogOut.setForeground(new java.awt.Color(255, 255, 255));
        LogOut.setText("Log Out");
        LogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogOutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(SEARCHBAR, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(CLIENTNAME, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(142, 142, 142)
                        .addComponent(LOGO)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(LogOut, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(FEEDBACK, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(ADDTOCHECK, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 138, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addComponent(CheckOut, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addComponent(MENUIMAGES, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(137, 137, 137))))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(SEARCHBAR, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19)
                        .addComponent(CLIENTNAME))
                    .addComponent(LOGO)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(LogOut, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(MENUIMAGES, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CheckOut, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(FEEDBACK, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ADDTOCHECK, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 631, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
    private void SEARCHBARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SEARCHBARActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SEARCHBARActionPerformed
    
    private void CheckOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CheckOutActionPerformed
        this.CheckOut();
    }//GEN-LAST:event_CheckOutActionPerformed
    
    private void ADDTOCHECKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ADDTOCHECKActionPerformed
        this.addToCart();
        
    }//GEN-LAST:event_ADDTOCHECKActionPerformed
    
    private void MENUMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MENUMouseClicked
        this.displayImages();
    }//GEN-LAST:event_MENUMouseClicked
    
    private void SEARCHBARKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SEARCHBARKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            this.search();
        }
    }//GEN-LAST:event_SEARCHBARKeyPressed
    
    private void AllItemsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AllItemsActionPerformed
        this.addRows();
    }//GEN-LAST:event_AllItemsActionPerformed
    
    private void BURGERMENUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BURGERMENUActionPerformed
        this.addBurger();
    }//GEN-LAST:event_BURGERMENUActionPerformed
    
    private void DESERTMENUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DESERTMENUActionPerformed
        this.addDesert();
    }//GEN-LAST:event_DESERTMENUActionPerformed
    
    private void BEVERAGESMENUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BEVERAGESMENUActionPerformed
        this.addBev();
    }//GEN-LAST:event_BEVERAGESMENUActionPerformed
    
    private void FEEDBACKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FEEDBACKActionPerformed
        this.FEEDBACKFORM.setVisible(true);
    }//GEN-LAST:event_FEEDBACKActionPerformed
    
    private void FEEDBACKAPRROVEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FEEDBACKAPRROVEActionPerformed
        this.setFeedback();
    }//GEN-LAST:event_FEEDBACKAPRROVEActionPerformed
    
    private void PREVIOUSORDERSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PREVIOUSORDERSActionPerformed
        new frmPreviousOrders(currentCustomer).setVisible(true);
    }//GEN-LAST:event_PREVIOUSORDERSActionPerformed
    
    private void CANCLEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CANCLEActionPerformed
        this.FEEDBACKFORM.setVisible(false);
    }//GEN-LAST:event_CANCLEActionPerformed
    
    private void ApproveCREDITCARDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ApproveCREDITCARDActionPerformed
        setCreditCard();
        
    }//GEN-LAST:event_ApproveCREDITCARDActionPerformed
    
    private void CancleCreditCardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancleCreditCardActionPerformed
        CREDITCARD.dispose();
        doneCredit = false;
    }//GEN-LAST:event_CancleCreditCardActionPerformed

    private void LogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogOutActionPerformed
        new frmLogin().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_LogOutActionPerformed

    private void cardnumtxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cardnumtxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cardnumtxtActionPerformed
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ADDTOCHECK;
    private javax.swing.JRadioButton AllItems;
    private javax.swing.JButton ApproveCREDITCARD;
    private javax.swing.JRadioButton BEVERAGESMENU;
    private javax.swing.JRadioButton BURGERMENU;
    private javax.swing.JButton CANCLE;
    private javax.swing.JLabel CLIENTNAME;
    private javax.swing.JTextArea COMMENT;
    private javax.swing.JDialog CREDITCARD;
    private javax.swing.JTextField CVVtxt;
    private javax.swing.JButton CancleCreditCard;
    private javax.swing.JButton CheckOut;
    private javax.swing.JRadioButton DESERTMENU;
    private javax.swing.JButton FEEDBACK;
    private javax.swing.JButton FEEDBACKAPRROVE;
    private javax.swing.JDialog FEEDBACKFORM;
    private javax.swing.JLabel LOGO;
    private javax.swing.JButton LogOut;
    private javax.swing.JTable MENU;
    private javax.swing.JLabel MENUIMAGES;
    private javax.swing.JButton PREVIOUSORDERS;
    private javax.swing.JSlider RATE;
    private javax.swing.JTextField SEARCHBAR;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTextField cardnumtxt;
    private javax.swing.JTextField expdatetxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
