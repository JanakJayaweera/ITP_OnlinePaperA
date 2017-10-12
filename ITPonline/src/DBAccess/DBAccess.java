/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBAccess;

import DBConnect.DBconnect;
import static java.awt.image.ImageObserver.ERROR;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

    
    
public class DBAccess {
    
    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    private int Man_Id,Qty;
    private String Appliance_Type,Date_Added,Waranty,Price,manName;
    
    private javax.swing.JComboBox manuComboBox;
    private javax.swing.JTable Table1;
    
    public DBAccess(){
    //Default constructor
    }
    
    public DBAccess(javax.swing.JComboBox pmanuComboBox){
    con = DBconnect.connect();
    
    manuComboBox = pmanuComboBox;
    
    getManufacturers();
    }
    
    public void getManufacturers(){
        
        
        try{
        String sql1 = "SELECT Manufacturer FROM appliance_manufacturers";
        pst = con.prepareStatement(sql1);
        rs = pst.executeQuery();
        
        while(rs.next()){
            String name = rs.getString("Manufacturer");
            manuComboBox.addItem(name);
        }
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    
    public DBAccess(String pmanName, String pAppliance_Type, String pDate_Added, String pWaranty, String pPrice, int pQty){
    //Constructor for addAppliance method
        con = DBconnect.connect();
        
        manName = pmanName;
        Appliance_Type = pAppliance_Type;
        Date_Added = pDate_Added;
        Waranty = pWaranty;
        Price = pPrice;
        Qty = pQty;
        
        
    
    }
    public boolean addAppliance(){
        int result=0;
        int man_Id;
        
        try{
        String sql6 = "SELECT Man_Id FROM appliance_manufacturers WHERE Manufacturer = '"+manName+"'";
        pst = con.prepareStatement(sql6);
        rs = pst.executeQuery();
        rs.next();
        man_Id = Integer.parseInt(rs.getString(1));
            
        String sql2 = "INSERT INTO appliances (Man_Id, Appliance_Type, Date_Added, Waranty, Price, Qty) VALUES ('"+man_Id+"','"+Appliance_Type+"','"+Date_Added+"','"+Waranty+"','"+Price+"','"+Qty+"')";
        pst = con.prepareStatement(sql2);
        result = pst.executeUpdate();
       
        }
        catch(Exception e){
            System.out.println(e);
            
            JOptionPane.showMessageDialog(null, "Add appliance unsuccessfull !\n"+e,"ERROR", JOptionPane.ERROR_MESSAGE);
            
           
        }
        
        if(result > 0){
            return true;
        }
        else{
            return false;
        }
    
    }
    
    public void getAllApliances(){
        con = DBconnect.connect();
        try{
            String sql3 = "SELECT * FROM appliances";
            pst= con.prepareStatement(sql3);
            rs = pst.executeQuery();
        }
        catch(Exception e){
            System.out.println(e);
        }
    
    }
    
    public DBAccess(String pmanName){
        //Constructor for getManufactureName(String manName)
        con = DBconnect.connect();
        
        manName = pmanName;
        
        getManufactureName(manName);
    
    }
    
    public int getManufactureName(String manName){
        
        try{
            String sql4 = "SELECT Man_Id FROM appliance_manufacturers WHERE Manufacturer='"+manName+"'";
            pst = con.prepareStatement(sql4);
            rs = pst.executeQuery();
            rs.next();
            Man_Id = Integer.parseInt(rs.getString(1));
            
        }
        catch(Exception e){
            System.out.println(e);
        }
        return Man_Id;
    
    }
    public DBAccess(int pMan_Id, javax.swing.JTable pTable1){
    //Constructor for getAllAppliances(int id)
        con = DBconnect.connect();
        Man_Id = pMan_Id;
        Table1 = pTable1;
        
        getAllAppliances(Man_Id);
    }
    public void getAllAppliances(int id){
    
        try{
            String sql5 = "SELECT * FROM appliances WHERE Man_Id = '"+id+"' ";
            pst = con.prepareStatement(sql5);
            rs = pst.executeQuery();
            Table1.setModel(DbUtils.resultSetToTableModel(rs));
            
        }
        catch(Exception e){
            System.out.println(e);
        }
    
    } 
}
