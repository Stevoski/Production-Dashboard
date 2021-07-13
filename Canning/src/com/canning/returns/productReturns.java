/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.canning.returns;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import newpackage1.NewJFrame;
import static newpackage1.NewJFrame.jComboBox3;
import static newpackage1.NewJFrame.jTextField3;
import static newpackage1.NewJFrame.jTextLogin;
import static newpackage1.NewJFrame.jTextStatus;
import newpackage1.db_Connection;

/**
 *
 * @author Stevoski
 */
public class productReturns {

    public static ArrayList<String> getProduct() throws InstantiationException {
        String grotp = jTextStatus.getText();
         String grootp = jTextLogin.getText();
         String qrduie=(String)jComboBox3.getSelectedItem();
        ArrayList<String> ProductList = new ArrayList<>();
        ResultSet trm;
        String kruda;
        switch (grotp) {
            case "USER":
                String krood = "select distinct(product_name) from product where factory=?";
                try (PreparedStatement oloki = db_Connection.getInstance().prepareStatement(krood)) {
                    oloki.setString(1, grootp);
                    trm = oloki.executeQuery();
                    while (trm.next()) {
                        kruda = trm.getString("product_name");
                        ProductList.add(kruda);
                    }
//                    kruda.close();
                } catch (SQLException e) {
                    Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, e);
                }
                break;
            case "ADMINISTRATOR":
              String kroods = "select distinct(product_name) from product where factory=?";
                try (PreparedStatement oloki = db_Connection.getInstance().prepareStatement(kroods)) {
                    oloki.setString(1, qrduie);
                    trm = oloki.executeQuery();
                    while (trm.next()) {
                        kruda = trm.getString("product_name");
                        ProductList.add(kruda);
                    }
//                    kruda.close();
                } catch (SQLException e) {
                    Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, e);
                }
            default:
                
                break;
        }
        return ProductList;
    }
    }
