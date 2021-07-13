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
public class rawMaterialReturns {
     public static ArrayList<String> getrawMaterial() throws InstantiationException{
        String grootr = jTextStatus.getText();
         String grutr = jTextLogin.getText();
          String qrduie=(String)jComboBox3.getSelectedItem();
        ArrayList<String> rawMaterialList = new ArrayList<>();
        ResultSet trm;
        String kruda;
        switch (grootr) {
            case "USER":
                String krood = "select distinct(raw_material_name) from raw_material where factory=?";
                try (PreparedStatement oloki = db_Connection.getInstance().prepareStatement(krood)) {
                    oloki.setString(1, grutr);
                    trm = oloki.executeQuery();
                    while (trm.next()) {
                        kruda = trm.getString("raw_material_name");
                        rawMaterialList.add(kruda);
                    }
                } catch (SQLException e) {
                    Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, e);
                }
                break;
            case "ADMINISTRATOR":
                String krood2 = "select distinct(raw_material_name) from raw_material where factory=?";
                try (PreparedStatement oloki = db_Connection.getInstance().prepareStatement(krood2)) {
                    oloki.setString(1, qrduie);
                    trm = oloki.executeQuery();
                    while (trm.next()) {
                        kruda = trm.getString("raw_material_name");
                        rawMaterialList.add(kruda);
                    }
                } catch (SQLException e) {
                    Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, e);
                }
            default:
                
                break;
        }
        return rawMaterialList;
    }
}
