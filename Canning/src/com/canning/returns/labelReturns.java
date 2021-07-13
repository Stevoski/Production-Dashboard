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
import static newpackage1.NewJFrame.jTextLogin;
import static newpackage1.NewJFrame.jTextStatus;
import newpackage1.db_Connection;

/**
 *
 * @author Stevoski
 */
public class labelReturns {
     public static ArrayList<String> getLabel() throws InstantiationException {
        String grootl= jTextStatus.getText();
        String grutl = jTextLogin.getText();
          String qrduie=(String)jComboBox3.getSelectedItem();
        ArrayList<String> labelList = new ArrayList<>();
        ResultSet trm;
        String kruda;
        switch (grootl) {
            case "USER":
                String sI ="select * from package where factory=?";
                try (PreparedStatement oloki = db_Connection.getInstance().prepareStatement(sI)) {
                    oloki.setString(1, grutl);
                    trm = oloki.executeQuery();
                    while (trm.next()) {
                        kruda = trm.getString("main_label");
                        labelList.add(kruda);
                    }
                } catch (SQLException e) {
                    Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, e);
                }
                break;
            case "ADMINISTRATOR":
                 String sIs ="select * from package where factory=?";
                try (PreparedStatement oloki = db_Connection.getInstance().prepareStatement(sIs)) {
                    oloki.setString(1, qrduie);
                    trm = oloki.executeQuery();
                    while (trm.next()) {
                        kruda = trm.getString("main_label");
                        labelList.add(kruda);
                    }
                } catch (SQLException e) {
                    Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, e);
                }
                 case "CENTRAL":
                 String sIsTE ="select * from main_package WHERE category='label'";
                try (PreparedStatement oloki = db_Connection.getInstance().prepareStatement(sIsTE)) {
//                    oloki.setString(1, qrduie);
                    trm = oloki.executeQuery();
                    while (trm.next()) {
                        kruda = trm.getString("package");
                        labelList.add(kruda);
                    }
                } catch (SQLException e) {
                    Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, e);
                }
            default:

                break;
        }
        return labelList;
    }
}
