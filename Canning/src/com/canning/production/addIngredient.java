/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.canning.production;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import static newpackage1.NewJFrame.jComboBox14;
import static newpackage1.NewJFrame.jComboBox21;
import static newpackage1.NewJFrame.jComboBox30;
import static newpackage1.NewJFrame.jTable16;
import static newpackage1.NewJFrame.jTextField132;
import static newpackage1.NewJFrame.jTextField140;
import static newpackage1.NewJFrame.jTextField3;
import static newpackage1.NewJFrame.jTextField32;
import static newpackage1.NewJFrame.jTextField44;
import static newpackage1.NewJFrame.jTextField62;
import static newpackage1.NewJFrame.jTextUser;
import newpackage1.db_Connection;

/**
 *
 * @author Stevoski
 */
public class addIngredient {
        public static void ingAdd() throws HeadlessException, NumberFormatException {
        String bla = jTextField32.getText();
        Double ble = Double.valueOf(bla);
        String bli = (String) jComboBox14.getSelectedItem();
        String blo = jTextField3.getText();
        Integer blu = Integer.parseInt(blo);
        String boL = jTextField62.getText();
        Integer bold = Integer.parseInt(boL);
        String ind = (String) jComboBox21.getSelectedItem();
         String consinoe = (String) jComboBox30.getSelectedItem();
     ResultSet rsingadd;
        String loger = jTextUser.getText();
        
        try {
            try {
                
                PreparedStatement psly = db_Connection.getInstance().prepareStatement("SELECT * FROM ingredients where ingredient_name='" + bli + "'");
                Connection coning = (Connection) db_Connection.getInstance();
                coning.setAutoCommit(false);
                try {
                    rsingadd = psly.executeQuery();
                    
                    while (rsingadd.next()) {
                        jTextField132.setText(rsingadd.getString("ingredient_price"));
                        jTextField140.setText(rsingadd.getString("stock_in_hand"));
                    }
                    try {
                        String inpry = jTextField132.getText();
                        Double inpryce = Double.valueOf(inpry);
                        Double instc = Double.valueOf(jTextField140.getText());
                        
                        try (PreparedStatement pyes = coning.prepareStatement("INSERT INTO ingredientsproduction(voucher_no,ingredient_name,ingredient_qty,ProductionID,groupe,total_qty,price,user,stock_in_hand,consi_no)"
                                + "values(?,?,?,?,?,?,?,?,?,?)")) {
                            pyes.setInt(1, blu);
                            pyes.setString(2, bli);
                            pyes.setDouble(3, ble);
                            pyes.setInt(4, bold);
                            pyes.setString(5, ind);
                            pyes.setDouble(6, ble);
                            pyes.setDouble(7, inpryce);
                            pyes.setString(8, loger);
                            pyes.setDouble(9, instc);
                           pyes.setString(10, consinoe);  
                            pyes.executeUpdate();
                            //TABLE PANEL ADD
                            try {
                                DefaultTableModel model = (DefaultTableModel) jTable16.getModel();
                                
                                try {
                                    int z3 = model.getRowCount();
                                    for (int lu3 = 0; lu3 <= z3; ++lu3) {
                                        model.removeRow(0);
                                    }
                                } catch (Exception e) {
                                }
                                try (PreparedStatement ps7 = db_Connection.getInstance().prepareStatement("SELECT * FROM ingredpriceinc where voucher_no = '" + blu + "';")) {
                                    
                                    rsingadd = ps7.executeQuery();
                                    
                                    while (rsingadd.next()) {
                                        model.addRow(new Object[]{rsingadd.getInt("ProductionID"), rsingadd.getString("ingredient_name"), rsingadd.getDouble("ingredient_qty"), rsingadd.getInt("ingredID"), rsingadd.getDouble("ingredient_price"), rsingadd.getString("cons_no")});
                                    }
                                    
                                    //SUM ING QTY
                                    try {
                                        String t = "SELECT sum(ingredient_qty) FROM ingredpriceinc WHERE voucher_no= '" + blu + "';";
                                        
                                        PreparedStatement psc = db_Connection.getInstance().prepareStatement(t);
                                        rsingadd = psc.executeQuery(t);
                                        
                                        if (rsingadd.next()) {
                                            Double bansal = rsingadd.getDouble(1);
                                            
                                            jTextField44.setText(String.valueOf(bansal));
                                        }
                                        coning.commit();
                                        
                                    } catch (Exception e) {
//                                    e.printStackTrace();
JOptionPane.showMessageDialog(null, "Cannot save." + e);
                                    }
                                    
                                    rsingadd.close();
                                    ps7.close();
                                    
                                } catch (Exception e) {
                                e.printStackTrace();
JOptionPane.showMessageDialog(null, "Error in connectivity");
                                }
                                pyes.close();
                            } catch (Exception e) {
//                            e.printStackTrace();
JOptionPane.showMessageDialog(null, "Invalid Entry or field must be completely filled", "message", 2);
                            }
//                JOptionPane.showMessageDialog(null, "The data was successfully added to the Database!");

                        }
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, ex.getMessage());
                    }
                } catch (Exception e) {
//                    e.printStackTrace();
JOptionPane.showMessageDialog(null, "Error in connectivity");
                }
                
            } catch (Exception e) {
//                e.printStackTrace();
JOptionPane.showMessageDialog(null, "Invalid Entry or field must be completely filled", "message", 2);
            }
            
//                JOptionPane.showMessageDialog(null, "The data was successfully added to the Database!");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        //TODO add your handling code here:
    }
}
