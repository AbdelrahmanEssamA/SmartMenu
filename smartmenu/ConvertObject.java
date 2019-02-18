/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartmenu;

import java.io.*;

public abstract class ConvertObject {
  //converting SimpleExample object to byte[].
    public static byte[] getByteArrayObject(Object simpleExample){
    
        byte[] byteArrayObject = null;
        try {
            
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(simpleExample);
            
            oos.close();
            bos.close();
            byteArrayObject = bos.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
            return byteArrayObject;
        }
        return byteArrayObject;
    }
  //converting byte[] to SimpleExample  
    public static Object getJavaObject(byte[] convertObject){
            Object objSimpleExample = null;
            
            ByteArrayInputStream bais;
            ObjectInputStream ins;
            try {
            
            bais = new ByteArrayInputStream(convertObject);
            
            ins = new ObjectInputStream(bais);
                 objSimpleExample =(Object)ins.readObject();
            
            ins.close();

            }
            catch (Exception e) {
            e.printStackTrace();
            }
            return objSimpleExample;
    }
 
}   
