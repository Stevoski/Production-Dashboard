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
public class ingredientReturns {

    public static ArrayList<String> getIngredient() throws InstantiationException {
        String grooti = jTextStatus.getText();
        String gruti = jTextLogin.getText();
           String qrduie=(String)jComboBox3.getSelectedItem();
        ArrayList<String> ingredientList = new ArrayList<>();
        ResultSet trm;
        String kruda;
        switch (grooti) {
            case "USER":
                String krood = "select distinct(ingredient_name) from ingredients where factory=?";
                try (PreparedStatement oloki = db_Connection.getInstance().prepareStatement(krood)) {
                    oloki.setString(1, gruti);
                    trm = oloki.executeQuery();
                    while (trm.next()) {
                        kruda = trm.getString("ingredient_name");
                        ingredientList.add(kruda);
                    }
                } catch (SQLException e) {
                    Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, e);
                }
                break;
            case "ADMINISTRATOR":
                String kroods = "select distinct(ingredient_name) from ingredients where factory=?";
                try (PreparedStatement oloki = db_Connection.getInstance().prepareStatement(kroods)) {
                    oloki.setString(1, qrduie);
                    trm = oloki.executeQuery();
                    while (trm.next()) {
                        kruda = trm.getString("ingredient_name");
                        ingredientList.add(kruda);
                    }
                } catch (SQLException e) {
                    Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, e);
                }
            default:

                break;
        }
        return ingredientList;
    }
    public static ArrayList<String> getIngredientCode() throws InstantiationException {
        
        ArrayList<String> ingcodeList = new ArrayList<>();
        ResultSet trmtr;
        String kruda;
                          
                String kroodE = "select distinct(ingredient_code) from ing_code_main";
                try (PreparedStatement oloki = db_Connection.getInstance().prepareStatement(kroodE)) {
                    trmtr = oloki.executeQuery(kroodE);
                    while (trmtr.next()) {
                        kruda = trmtr.getString("ingredient_code");
                        ingcodeList.add(kruda);
                    }
                    trmtr.close();
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "Invalid User. Please contact your system administrator for more information!");
                    Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, e);
                  }
       

              
        
        return ingcodeList;
    }
}
