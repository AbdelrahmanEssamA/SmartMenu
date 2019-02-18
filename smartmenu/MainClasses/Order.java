package smartmenu.MainClasses;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.awt.List;
import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import smartmenu.ConvertObject;
import smartmenu.DatabaseController;
import smartmenu.PersonClasses.Customer;
import smartmenu.PersonClasses.Person;

public class Order implements java.io.Serializable{
    //Variables
    private int id;
    private ArrayList<Item> cart = new ArrayList<>();
    private ArrayList<Item> temp = new ArrayList<>();
    private double totalPrice;
    private String date;
    private Customer customer = new Customer();
    private enum Status {
        PENDING, APPROVED, DELIVERED
    }
    private enum PaymentMethodChoice {
        CASHONDELIVERY,CREDITCARD
    }
    private Status status;
    private PaymentMethodChoice paymentMethodChoice;
    //Generate ID for database storing
    private int generateID(){
        int maxId = 0;
        ResultSet rs = DatabaseController.GetData("Select * From RestaurantOrder");
        try {
            while (rs.next()){
                Blob blob = rs.getBlob(2);
                byte[] theBytes = blob.getBytes(1L, (int)blob.length());
                Order temp = (Order)ConvertObject.getJavaObject(theBytes);
                if (temp.getId() > maxId)
                    maxId = temp.getId();     
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        finally{
            DatabaseController.CloseConnection();
        }
        this.id = maxId+1;
        return maxId + 1;
    }
    //default constructor
    public Order() {
        this.id = generateID();
        this.totalPrice = 0.0;
        this.date = "";
        this.status = Status.PENDING; 
    }
  
    //overloading constructor
    public Order(ArrayList<Item> products, double totalPrice, String date) {
        this.temp = products;
        this.totalPrice = totalPrice;
        this.date = date;
        this.status = Status.PENDING;
    }
    
    //getters
    public int getId (){
        return this.id;
    }
    public int getCustomerID(){
        return this.customer.getID();
    }
    public String getDate() {
        return date;
    }
    public double getTotalPrice() {
        return totalPrice;
    }
    public ArrayList<Item> getTempproducts() {
        return temp;
    }
    public ArrayList<Item> getOrders(){
        return cart;
    }
    public String getStatus(){
        if(this.status == Status.APPROVED){
            return "approved";
        }
        else if(this.status == Status.PENDING){
            return "pending";
        }
        else 
            return "delivered";
    }
    public String getPayment(){
        if(paymentMethodChoice == PaymentMethodChoice.CASHONDELIVERY)
            return "cash on delivery";
        else 
            return "credit card";
    }
    //setters
    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    public void setStatus(String status) {
        if (status.equalsIgnoreCase("pending") )
            this.status = Status.PENDING;
        else if (status.equalsIgnoreCase("approved"))
            this.status = Status.APPROVED;
        else if (status.equals("delivered"))
            this.status = Status.DELIVERED;
    }
    public void setPayment(String payment){
        if(payment.equalsIgnoreCase("cash on delivery")){
            this.paymentMethodChoice = PaymentMethodChoice.CASHONDELIVERY;
        }
        else if(payment.equalsIgnoreCase("credit card")){
            this.paymentMethodChoice = PaymentMethodChoice.CREDITCARD;
        }
        
    }
    
    //Customer controller add an item to the cart
    public void addItem(Item Item) {
        temp.add(Item);
        cart.add(Item);
    }
      
    // Custpmer controller makes a new order
    public String makeOrder() {
        totalPrice = 0;
        String info ="";
        double tax = 0.14;
        for (int i = 0; i < this.temp.size(); i++) {
            
            String name = ("Name : " + this.temp.get(i).getName()+"\n");
            String price= (" Price : " + this.temp.get(i).getPrice()+"\n");
            String q =(" Quantity : " + this.temp.get(i).getSingleOrderQuantity()+"\n");     
            totalPrice += this.temp.get(i).getSingleOrderQuantity() * temp.get(i).getPrice();
            info+=(name+price+q);
        }
            tax*=totalPrice;
            String total = (" Total price : "+totalPrice);
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
            LocalDate localDate = LocalDate.now();
            String date = (" Date:"+dtf.format(localDate));
            String payment = this.getPayment();
            String recipt = info +"\n" +"-----------------------------------" +"\n"+total +"\n"+"ADD 14% taxes"+"\n"+(totalPrice+tax)+"\n"+"____________________________"+"\n"+date +"\n"+"Payment Method: "+payment+"\n" ;
            this.temp.clear();
            
            return recipt;
    }
    
    //To String
    @Override
        public String toString() {
        StringBuilder sb = new StringBuilder();
        return sb.toString();
    }
}
