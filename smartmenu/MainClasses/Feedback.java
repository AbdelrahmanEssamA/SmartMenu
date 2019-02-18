package smartmenu.MainClasses;
import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import smartmenu.ConvertObject;
import smartmenu.DatabaseController;
import smartmenu.PersonClasses.Customer;


public class Feedback implements java.io.Serializable {
    //Variables
    private int id;
    private int rate;
    private String Comment;
    private Customer customer;
    
    //Generate ID for Database Storing
    private int generateID(){
        int maxId = 0;
        ResultSet rs = DatabaseController.GetData("Select * From Feedback");
        try {
            while (rs.next()){
                Blob blob = rs.getBlob(2);
                byte[] theBytes = blob.getBytes(1L, (int)blob.length());
                Feedback temp = (Feedback)ConvertObject.getJavaObject(theBytes);
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
    
    public Feedback(int rate, String Comment, Customer customer) {
        this.id = generateID();
        this.rate = rate;
        this.Comment = Comment;
        this.customer = customer;
    }
    
    
    //Getters
    public int getId() {
        return id;
    }
    public int getRate() {
        return rate;
    }
    public String getComment() {
        return Comment;
    }
    public Customer getCustomer() {
        return customer;
    }
    
    //Setters
    public void setRate(int rate) {
        this.rate = rate;
    }
    public void setComment(String Comment) {
        this.Comment = Comment;
    }
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    
    //Validate Feedback entered By user
    public static Boolean validateInput(int rate, String comment){
        if(comment == null|| rate>10|| rate<0 || comment.isEmpty())  
            return false;
        else
            return true;
    }
    
    
    //ToString
    @Override
        public String toString() {
        StringBuilder sb = new StringBuilder();
        return sb.toString();
    }
    
}
