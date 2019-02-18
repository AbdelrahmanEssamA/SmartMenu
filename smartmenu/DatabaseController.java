package smartmenu;
import java.io.*;
import java.sql.*;
import javax.swing.*;

public class DatabaseController {
    private static String connectionURL = "jdbc:derby://localhost:1527/Database";
    private static Connection conn = null;
    private static ResultSet rs = null;
    private static Statement st = null;
    public static void ExecuteSQL(String query){
        try {
            conn = DriverManager.getConnection(connectionURL);
            st = conn.createStatement();
            st.executeUpdate(query);
            st.close(); 
            conn.close(); 
        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
    
    public static ResultSet GetData(String query){
        try {
            conn = DriverManager.getConnection(connectionURL);
            st = conn.createStatement();
            rs = st.executeQuery(query);
            return rs;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return null;
    }
    
    public static void CloseConnection(){
        try{
            if (rs != null) rs.close();
            if (st != null) st.close();
            if (conn != null) conn.close();
        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
    
    //Convert the obj to blob and store it in database
    public static void WriteObject(String tableName, int id, Object obj) {
        try {
            conn = DriverManager.getConnection(connectionURL);
            byte[] testBytes  = ConvertObject.getByteArrayObject(obj);
            PreparedStatement statement = conn.prepareStatement("INSERT INTO " + tableName + " (id, obj) VALUES(?,?)");
            statement.setInt(1, id);
            statement.setBinaryStream(2,new ByteArrayInputStream(testBytes),testBytes.length);
            statement.executeUpdate();
            statement.close();
            conn.close();
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static void UpdateObject(String tableName, int id, Object obj) {
        try {
            conn = DriverManager.getConnection(connectionURL);
            byte[] testBytes  = ConvertObject.getByteArrayObject(obj);
            PreparedStatement statement = conn.prepareStatement("UPDATE " + tableName + " SET obj = ? WHERE id = ?");
            statement.setBinaryStream(1,new ByteArrayInputStream(testBytes),testBytes.length);
            statement.setInt(2, id);
            statement.executeUpdate();
            statement.close();
            conn.close();
        }
        catch(SQLException e) {
            System.err.println(e.getErrorCode());
        }
    }
}
