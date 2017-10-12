
package DBConnect;

import java.sql.Connection;
import java.sql.DriverManager;


public class DBconnect {
    public static Connection connect(){
            Connection conn = null;
            try{
                Class.forName("com.mysql.jdbc.Driver");
                conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/itponline", "root", "");
            }
            catch(Exception e){
                System.out.println(e);
            }
            
            return conn;
    
    }
    
}
