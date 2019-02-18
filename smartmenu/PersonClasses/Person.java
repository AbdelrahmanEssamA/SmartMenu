package smartmenu.PersonClasses;

import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import smartmenu.ConvertObject;
import smartmenu.DatabaseController;
import smartmenu.MainClasses.Notification;

public abstract class Person implements java.io.Serializable{
    //Variables
    protected int ID;
    protected String username;
    protected String password;
    protected String name;
    protected String Phone;
    protected String gender;
    protected ArrayList<Notification> notifications;
    
    //Generate ID to store at the database
    private int generateID(){
        int maxId = 0;
        ResultSet rs = DatabaseController.GetData("Select * From Person");
        try {
            while (rs.next()){
                Blob blob = rs.getBlob(2);
                byte[] theBytes = blob.getBytes(1L, (int)blob.length());
                Person temp = (Person)ConvertObject.getJavaObject(theBytes);
                if (temp.getID() > maxId)
                    maxId = temp.getID();     
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        finally{
            DatabaseController.CloseConnection();
        }
        this.ID = maxId+1;
        return maxId + 1;
    }
    
    //default Constructor
    public Person(){
        
    }
    
    //OverLoading Constructor
    public Person(String username, String password, String name, String Phone, String gender) {
        this.ID = generateID();
        this.username = username;
        this.password = password;
        this.name = name;
        this.Phone = Phone;
        this.gender = gender;
    }

    //Getters
    public int getID() {
        return ID;
    }
    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
    public String getGender() {
        return gender;
    }
    public String getName() {
        return name;
    }
    public String getPhone() {
        return Phone;
    }
    public ArrayList<Notification> getNotifications(){
        return this.notifications;
    }
    
    //Setters
    public void setUsername(String username) {
        this.username = username;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPhone(String Phone) {
        this.Phone = Phone;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public void setNotifications(ArrayList<Notification> list){
        this.notifications = list;
    }
    
    //add new notification
    public void addNotification(Notification n){
        this.notifications.add(n);
    }
 
    //To String
    @Override
        public String toString() {
        StringBuilder sb = new StringBuilder();
        return sb.toString();
    }
}
