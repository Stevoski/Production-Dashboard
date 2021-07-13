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
import static newpackage1.NewJFrame.jTextLogin;
import static newpackage1.NewJFrame.jTextStatus;
import newpackage1.db_Connection;

/**
 *
 * @author Stevoski
 */
public class supplierReturns {
    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Stevoski
 */

     public static ArrayList<String> getSupplier() throws InstantiationException {
        String grootl= jTextStatus.getText();
        String grutl = jTextLogin.getText();
        ArrayList<String> supplierList = new ArrayList<>();
        ResultSet trm;
        String kruda;
        switch (grootl) {
            case "USER":
                String sI ="select * from suppliers";
                try (PreparedStatement oloki = db_Connection.getInstance().prepareStatement(sI)) {
//                    oloki.setString(1, grutl);
                    trm = oloki.executeQuery();
                    while (trm.next()) {
                        kruda = trm.getString("supplier");
                        supplierList.add(kruda);
                    }
                } catch (SQLException e) {
                    Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, e);
                }
                break;
            case "ADMINISTRATOR":
                String kroodE = "select * from suppliers";
                try (PreparedStatement oloki = db_Connection.getInstance().prepareStatement(kroodE)) {
                    trm = oloki.executeQuery(kroodE);
                    while (trm.next()) {
                        kruda = trm.getString("supplier");
                        supplierList.add(kruda);
                    }
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "Invalid User. Please contact your system administrator for more information!");
                    Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, e);
                    break;
                }
                case "CENTRAL":
                String kroodEt = "select * from suppliers";
                try (PreparedStatement oloki = db_Connection.getInstance().prepareStatement(kroodEt)) {
                    trm = oloki.executeQuery(kroodEt);
                    while (trm.next()) {
                        kruda = trm.getString("supplier");
                        supplierList.add(kruda);
                    }
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "Invalid User. Please contact your system administrator for more information!");
                    Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, e);
                    break;
                }
            default:

                break;
        }
        return supplierList;
    }
}

    

