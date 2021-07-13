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
import static newpackage1.ExportAndImport.jComboBox13;
import static newpackage1.NewJFrame.jTextLogin;
import static newpackage1.NewJFrame.jTextStatus;
import newpackage1.db_Connection;
/**
 *
 * @author Stevoski
 */
public class allIngredientReturns {
     public static ArrayList<String> getallMaterial() throws InstantiationException{
        String grootr = jTextStatus.getText();
        String grutr = jTextLogin.getText();
//         String grutr = (String) jComboBox13.getSelectedItem();
        ArrayList<String> allMaterialList = new ArrayList<>();
        ResultSet trm;
        String kruda;
        switch (grootr) {
            case "USER":        
                String krood = "select distinct(ingredient) from all_ingredients where factory=? order by main_material ";
                try (PreparedStatement oloki = db_Connection.getInstance().prepareStatement(krood)) {
                    oloki.setString(1, grutr);
                    trm = oloki.executeQuery();
                    while (trm.next()) {
                        kruda = trm.getString("Ingredient");
                        allMaterialList.add(kruda);
                    }
                } catch (SQLException e) {
                    Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, e);
                }
                break;
            case "ADMINISTRATOR":
                String kroodE = "select distinct(ingredient) from all_ingredients";
                try (PreparedStatement oloki = db_Connection.getInstance().prepareStatement(kroodE)) {
                    trm = oloki.executeQuery(kroodE);
                    while (trm.next()) {
                        kruda = trm.getString("Ingredient");
                        allMaterialList.add(kruda);
                    }
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "Invalid User. Please contact your system administrator for more information!");
                    Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, e);
                    break;
                }
            default:                
                break;
        }
          return allMaterialList;
    }
        public static ArrayList<String> getallmainMaterial() throws InstantiationException{
        String grootr = jTextStatus.getText();
        String grutr = jTextLogin.getText();
//         String grutr = (String) jComboBox13.getSelectedItem();
        ArrayList<String> allMaterialList = new ArrayList<>();
        ResultSet trm;
        String kruda;
        switch (grootr) {
            case "USER":
                String krood = "select distinct(main_material) from all_ingredients where factory=? ";
                try (PreparedStatement oloki = db_Connection.getInstance().prepareStatement(krood)) {
                    oloki.setString(1, grutr);
                    trm = oloki.executeQuery();
                    while (trm.next()) {
                        kruda = trm.getString("main_material");
                        allMaterialList.add(kruda);
                    }
                } catch (SQLException e) {
                    Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, e);
                }
                break;
            case "ADMINISTRATOR":
                String kroodE = "select distinct(main_material) from all_ingredients";
                try (PreparedStatement oloki = db_Connection.getInstance().prepareStatement(kroodE)) {
                    trm = oloki.executeQuery(kroodE);
                    while (trm.next()) {
                        kruda = trm.getString("main_material");
                        allMaterialList.add(kruda);
                    }
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "Invalid User. Please contact your system administrator for more information!");
                    Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, e);
                    break;
                }
            default:
                                break;
        }  
               return allMaterialList;
    }
        public static ArrayList<String> getcodeMaterial() throws InstantiationException{
        String grootr = jTextStatus.getText();
        String grutr = jTextLogin.getText();
//         String grutr = (String) jComboBox13.getSelectedItem();
        ArrayList<String> allMaterialList = new ArrayList<>();
        ResultSet trm;
        String kruda;
        switch (grootr) {
            case "USER":        
                String krood = "select distinct(ing_name) from code_ing order by ing_name ";
                try (PreparedStatement oloki = db_Connection.getInstance().prepareStatement(krood)) {
//                    oloki.setString(1, grutr);
                    trm = oloki.executeQuery();
                    while (trm.next()) {
                        kruda = trm.getString("ing_name");
                        allMaterialList.add(kruda);
                    }
                } catch (SQLException e) {
                    Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, e);
                }
                break;
            case "ADMINISTRATOR":
                String kroodE ="select distinct(ing_name) from code_ing order by ing_name";
                try (PreparedStatement oloki = db_Connection.getInstance().prepareStatement(kroodE)) {
                    trm = oloki.executeQuery(kroodE);
                    while (trm.next()){
                        kruda = trm.getString("ing_name");
                        allMaterialList.add(kruda);
                    }
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "Invalid User. Please contact your system administrator for more information!");
                    Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, e);
                    break;
                }
                case "CENTRAL":
                String kroods ="select distinct(ing_name) from code_ing order by ing_name";
                try (PreparedStatement oloki = db_Connection.getInstance().prepareStatement(kroods)) {
                    trm = oloki.executeQuery(kroods);
                    while (trm.next()) {
                        kruda = trm.getString("ing_name");
                        allMaterialList.add(kruda);
                    }
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "Invalid User. Please contact your system administrator for more information!");
                    Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, e);
                    break;
                }
            default:
                
                break;
        }       
        return allMaterialList;
    }
}
