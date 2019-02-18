
package smartmenu.MainClasses;

import javax.swing.JOptionPane;

public class CreditCard implements java.io.Serializable{
    //Variables
    private String cvv;
    private String cardNumber;
    private String expDate;
    private enum CardType {
        MASTERCARD, VISA
    }
    private CardType cardType;
    
    //Setters
    public boolean setCvv(String cvv) {
        if (cvv.length() == 4 || cvv.length() == 3) {
            if (Integer.parseInt(cvv) == 270 || Integer.parseInt(cvv) == 365 || Integer.parseInt(cvv) == 467 || Integer.parseInt(cvv) == 648 || Integer.parseInt(cvv) == 967) {
                this.cardType = CardType.MASTERCARD;
                this.cvv = cvv;
                return true;
            }
            else if (cvv.equals("048") || Integer.parseInt(cvv) == 707 || cvv.equals("094") || Integer.parseInt(cvv) == 198 || Integer.parseInt(cvv) == 122) {
                this.cardType = CardType.VISA;
                this.cvv = cvv;
                return true;
            }
            else 
                 //JOptionPane.showMessageDialog(null,"Invalid Card Verfication Value!");
                 return false;
        }
        return false;
    }   
    public boolean setCardNumber(String cardNumber) {
        if (cardNumber.startsWith("528") || cardNumber.startsWith("547") || cardNumber.startsWith("549") || cardNumber.startsWith("537") || cardNumber.startsWith("519")) {
            this.cardType = CardType.MASTERCARD;
            this.cardNumber = cardNumber;
            return true;
        } 
        else if (cardNumber.startsWith("455") || cardNumber.startsWith("498") || cardNumber.startsWith("491") || cardNumber.startsWith("471") || cardNumber.startsWith("448")) {
            this.cardType = CardType.VISA;
            this.cardNumber = cardNumber;
            return true;
        } 
        //else JOptionPane.showMessageDialog(null,"Invalid Card Verfication Value!");
        return false;
    }    
    public boolean setExpDate(String expDate) {
        this.expDate = expDate;
        return true;
    }
    
    //Getters
    public String getCardType() {
        String card = "";
        if (this.cardType == CardType.MASTERCARD)
            card = "Master Card";
        else if (this.cardType == CardType.VISA)
            card = "VISA";

        else
            JOptionPane.showMessageDialog(null,"Not Found!");

        return card;
    }    
    
}
