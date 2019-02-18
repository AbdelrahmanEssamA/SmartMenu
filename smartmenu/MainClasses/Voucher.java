/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */ 
package smartmenu.MainClasses;

/**
 *
 * @author Abdelrahman
 */
public class Voucher implements java.io.Serializable {
    
    private String Code;
    private int discount;
    private String date;
    private String expDate;
    
    //default Constructor
    public Voucher(){
      this.Code = "";
      this.date = "";
      this.discount = 0;
      this.expDate = "";
    }
    
    //Generate Voucher Code
    public String GenerateCode(){
        return "";
    }

    //getters
    public String getCode() {
        return Code;
    }
    public int getDiscount() {
        return discount;
    }
    public String getDate() {
        return date;
    }
    public String getExpDate() {
        return expDate;
    }

    //Seters
    public void setCode(String Code) {
        this.Code = Code;
    }
    public void setDiscount(int discount) {
        this.discount = discount;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public void setExpDate(String expDate) {
        this.expDate = expDate;
    }
    
    
}
