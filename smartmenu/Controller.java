package smartmenu;

import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

import smartmenu.MainClasses.*;
import smartmenu.PersonClasses.*;

abstract public class Controller {
//-----------Login Form-----------//
    private static Staff getStaff(String username){
        Staff result = null;
        ResultSet rs = DatabaseController.GetData("Select * From Staff");
        try {
            while (rs.next()){
                Blob blob = rs.getBlob(2);
                byte[] theBytes = blob.getBytes(1L, (int)blob.length());
                Staff temp = (Staff)ConvertObject.getJavaObject(theBytes);
                if (temp.getUsername().equalsIgnoreCase(username)){
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
    private static Person getUser(String username){
        Person result = null;
        ResultSet rs = DatabaseController.GetData("Select * From Person");
        try {
            while (rs.next()){
                Blob blob = rs.getBlob(2);
                byte[] theBytes = blob.getBytes(1L, (int)blob.length());
                Person temp = (Person)ConvertObject.getJavaObject(theBytes);
                if (temp.getUsername().equalsIgnoreCase(username)){
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
    public static Person Login(String username, String password){
        Person temp = getUser(username);
        if (temp != null && temp.getPassword().equals(password))
            return temp;
        else
            return null;
    }
    public static Staff LoginStaff(String username, String pw){
        Staff temp = getStaff(username);
        if (temp != null && temp.getPassword().equals(pw))
            return temp;
        else
            return null;
        
    }
//---------SingUp Form-----------//
    public static boolean Signup(String username, String password, String name, String phone, String gender){
        if (username.isEmpty() || password.isEmpty() || name.isEmpty() || phone.isEmpty() || gender.isEmpty())
            return false;
        if (getUser(username) != null)
            return false;
        Customer c = new Customer(username,password,name,phone,gender);
        DatabaseController.WriteObject("person", c.getID(),c );
        return true;
    }
    
    
//---------Customer Form---------//
    public static void MakeFeedBack(){
        
    }
    public static void RequestWaiter(){
        
    }
    public static void UpdatePreviousOrders(Customer c){
        DatabaseController.UpdateObject("Person", c.getID(), c);
    }
    public static ArrayList<Person> getCustomersData(){
        ArrayList<Person> list = new ArrayList<Person>();
        ResultSet rs = DatabaseController.GetData("Select * From Person");
        try {
            while (rs.next()){
                Blob blob = rs.getBlob(2);
                byte[] theBytes = blob.getBytes(1L, (int)blob.length());
                Person temp = (Person)ConvertObject.getJavaObject(theBytes);
                if (temp instanceof Customer)
                    list.add(temp);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        finally{
            DatabaseController.CloseConnection();
        }
        return list;
    }
    
    
//---------Admin Form---------//
    public static void addItem(Item obj){
        
    }
    public static boolean updateItem(int itemId, Item newObj){
        
        return true;
    }
    public static void acceptOrder(int orderId){
        
    }
    
    
//---------Orders----------//
    public static void addToOrders(Order order){
        DatabaseController.WriteObject("RestaurantOrder",order.getId(),order);
    }
    public static ArrayList<Order> OrdersData(){
        ArrayList<Order> list = new ArrayList<Order>();
        ResultSet rs = DatabaseController.GetData("Select * From RestaurantOrder");
        try {
            while (rs.next()){
                Blob blob = rs.getBlob(2);
                byte[] theBytes = blob.getBytes(1L, (int)blob.length());
                Order temp = (Order)ConvertObject.getJavaObject(theBytes);
                list.add(temp);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        finally{
            DatabaseController.CloseConnection();
        }
        return list;
    }
    
    
//---------Add feedbak To Databse------//
    public static void addfeedback (Feedback feedback){
        DatabaseController.WriteObject("Feedback",feedback.getId(),feedback);
    }
    public static ArrayList<Feedback> FeedbackData(){
        ArrayList<Feedback> list = new ArrayList<Feedback>();
        ResultSet rs = DatabaseController.GetData("Select * From Feedback");
        try {
            while (rs.next()){
                Blob blob = rs.getBlob(2);
                byte[] theBytes = blob.getBytes(1L, (int)blob.length());
                Feedback temp = (Feedback)ConvertObject.getJavaObject(theBytes);
                list.add(temp);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        finally{
            DatabaseController.CloseConnection();
        }
        return list;
    }
    
    
//--------Items--------//
    public static ArrayList<Item> Items(){
        ArrayList<Item> list = new ArrayList<Item>();
        ResultSet rs = DatabaseController.GetData("Select * From Item");
        try {
            while (rs.next()){
                Blob blob = rs.getBlob(2);
                byte[] theBytes = blob.getBytes(1L, (int)blob.length());
                Item temp = (Item)ConvertObject.getJavaObject(theBytes);
                list.add(temp);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        finally{
            DatabaseController.CloseConnection();
        }
        return list;
    }
    public static void AddItem(Item item){
        DatabaseController.WriteObject("Item", item.generateID(), item);
    }
}
