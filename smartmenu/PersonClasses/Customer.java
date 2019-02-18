package smartmenu.PersonClasses;
import java.util.ArrayList;
import smartmenu.Controller;
import smartmenu.MainClasses.Order;
import smartmenu.MainClasses.Voucher;
public class Customer extends Person {
    //Variables
    private ArrayList<Order> PreviousOrders;
    private ArrayList<Voucher> vouchers = new ArrayList<>();
    
    //overLoading Constructor
    public Customer(String username, String password, String name, String Phone, String gender) {
        super(username, password, name, Phone, gender);
        PreviousOrders = new ArrayList<>();
        
    }
    //default Constructor
    public Customer() {
        super();
    }
    
    //Getters
    public int getNumOfOrders (){
        return this.PreviousOrders.size();
    }
    public ArrayList<Order> getPreviousOrders(){
        return this.PreviousOrders;
    }
    public ArrayList<Voucher> getVouchersList(){
        return this.vouchers;
    }
    
    
    public void addVoucher(Voucher newVoucher){
        this.vouchers.add(newVoucher);
    }
    //addNewOrder
    public void addtoPreviousOrders(Order newOrder){
        this.PreviousOrders.add(newOrder);
        Controller.UpdatePreviousOrders(this);
    }
    //Clear ordersList
    public void clearOrdersHistory(){
        this.PreviousOrders.clear();
    }
    
    @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            return sb.toString();
        }
}
