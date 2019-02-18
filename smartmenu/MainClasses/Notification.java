package smartmenu.MainClasses;
import smartmenu.PersonClasses.Person;

public class Notification implements java.io.Serializable{
    //Variable
    private int id;
    private String message;
    private boolean status;
    private Person person;

    //default Constructor
    public Notification(){
        this.id = 0;
        this.status = false;
        this.message = "";
    }
    
    //overLoading Constructor
    public Notification(int id, String message, boolean status, Person person) {
        this.id = id;
        this.message = message;
        this.status = status;
        this.person = person;
    }

    //getters
    public int getId() {
        return id;
    }
    public String getMessage() {
        return message;
    }
    public boolean isStatus() {
        return status;
    }
    public Person getPerson() {
        return person;
    }

    //Setters
    public void setId(int id) {
        this.id = id;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public void setStatus(boolean status) {
        this.status = status;
    }
    public void setPerson(Person person) {
        this.person = person;
    }
    
    
}
