/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage1;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
/**
 *
 * @author Stevoski
 */
public class db_Connection {
    private static Connection conexion = null;
db_Connection() {
    }
    public static Connection getInstance() throws InstantiationException {
if (conexion == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                conexion = DriverManager.getConnection("jdbc:mysql://192.168.1.190:3306/canning?allowMultiQueries=true&autoreconnect=true", "weru", "steve23741997");
//                java.util.Properties connProperties = new java.util.Properties();
//                connProperties.put(MYSQL_AUTO_RECONNECT, "true");
//    connProperties.put(MYSQL_MAX_RECONNECTS, "4");
    // set additional connection properties:
    // if connection stales, then make automatically
    // reconnect; make it alive again;
    // if connection stales, then try for reconnection;
    
    
            
            } catch (Exception e) {
                            JOptionPane.showMessageDialog(null, e.getMessage());
//                            e.printStackTrace();
                        }
                        return conexion;
        } else {
            return conexion;
        }
    }
}                                                                                                                               