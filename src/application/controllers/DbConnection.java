package application.controllers;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;

public class DbConnection {
	  private static Connection conexion = null;
	  DbConnection() {
	       }
	       public static Connection getInstance() throws InstantiationException {
	   if (conexion == null) {
	               try {
	               Class.forName("com.mysql.cj.jdbc.Driver");
	               conexion = DriverManager.getConnection("jdbc:mysql://stevoski-pc:3306/canning?allowMultiQueries=true&autoreconnect=true", "HotelAdmin", "P@ssw0rd");
	               } catch (Exception e) {
	                               JOptionPane.showMessageDialog(null, e.getMessage());
//	                               e.printStackTrace();
	                           }
	                           return conexion;
	           } else {
	               return conexion;
	           }
	       }
}
