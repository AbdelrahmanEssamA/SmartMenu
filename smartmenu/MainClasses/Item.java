package smartmenu.MainClasses;
import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import smartmenu.ConvertObject;
import smartmenu.DatabaseController;

public class Item implements java.io.Serializable {
    //variables
    public static enum Category{
        beverages, Desert, Burger
    }
    private Category CATEGORY;
    private int id;
    private String name;
    private double price;
    private int SingleOrderQuantity;
    
    //overLoading Constructor
    public Item(String name, double price,String category) {

        this.name = name;
        this.price = price;
        this.setCategory(category);
        this.id = this.generateID();
        
    }

    //Search for certain item in database
    public static Item getITem(String name){
        Item result = null;
        ResultSet rs = DatabaseController.GetData("Select * From Item");
        try {
            while (rs.next()){
                Blob blob = rs.getBlob(2);
                byte[] theBytes = blob.getBytes(1L, (int)blob.length());
                Item temp = (Item)ConvertObject.getJavaObject(theBytes);
                if (temp.getName().equalsIgnoreCase(name)){
                    result = temp; 
                    break;
                }      
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        finally{
            DatabaseController.CloseConnection();
        }
        return result;
    }
    
    //Generate Id for storing the object in database
    public int generateID(){
        int maxId = 0;
        ResultSet rs = DatabaseController.GetData("Select * From Item");
        try {
            while (rs.next()){
                Blob blob = rs.getBlob(2);
                byte[] theBytes = blob.getBytes(1L, (int)blob.length());
                Item temp = (Item)ConvertObject.getJavaObject(theBytes);
                if (temp.getId() > maxId)
                    maxId = temp.getId();     
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        finally{
            DatabaseController.CloseConnection();
        }
        return maxId + 1;
    }
    
    //getters
    public int getSingleOrderQuantity(){
        return this.SingleOrderQuantity;
    }
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
    }
    public String getCategory(){
        if (this.CATEGORY.equals(Category.Burger)){
            return "Burger";
        }
        else if (this.CATEGORY.equals(Category.Desert)){
            return "Desert";
        }
        else
            return "beverages";
    }
    
    
    //Setters
    public void setId(int id) {
        this.id = id;
    }
    public void SingleOrderQuantity(int quantity) {
        this.SingleOrderQuantity = quantity;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public void setCategory(String category){
        if (category=="Desert"){
            CATEGORY = Category.Desert;
        } 
        else if (category == "Burger"){
            this.CATEGORY = Category.Burger;
        }
        else 
            this.CATEGORY = Category.beverages;
    }
}
