package smartmenu.PersonClasses;

import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import smartmenu.ConvertObject;
import smartmenu.DatabaseController;

public  class Staff extends Person implements java.io.Serializable {
    //Variables
    public static enum Shift{
        Day, Night
    }
    protected Shift shift;
    
    //overloadin constructor
    public Staff(String username, String password, String name, String Phone, String gender,String shift) {
        super(username, password, name, Phone, gender);
        setShift(shift);
        
    }
    
    //Setters
    public void setShift(String s){
        if(s=="day")
            shift = Shift.Day;
        else
            shift = Shift.Night;
    }
    
     
}
