/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.canning.production;

//import groovy.sql.Sql;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import static newpackage1.NewJFrame.jComboBox21;
import static newpackage1.NewJFrame.jComboBox31;
import static newpackage1.NewJFrame.jComboBox35;
import static newpackage1.NewJFrame.jComboBox4;
import static newpackage1.NewJFrame.jComboBox5;
import static newpackage1.NewJFrame.jTable17;
import static newpackage1.NewJFrame.jTextField133;
import static newpackage1.NewJFrame.jTextField134;
import static newpackage1.NewJFrame.jTextField23;
import static newpackage1.NewJFrame.jTextField24;
import static newpackage1.NewJFrame.jTextField3;
import static newpackage1.NewJFrame.jTextField68;
import static newpackage1.NewJFrame.jTextField99;
import newpackage1.db_Connection;
import java.sql.ResultSet;

/**
 *
 * @author Stevoski
 */
public class addPackage {

    public static void packarde() throws NumberFormatException, HeadlessException {
        String qtr = jTextField23.getText();
        Double bwe = Double.valueOf(qtr); //no of cans
        String qtrr = jTextField99.getText();
        Double bwre = Double.valueOf(qtrr); //cans waste
        ResultSet rusev = null;
        String gwu = (String) jComboBox4.getSelectedItem(); // can name
        String dwu1 = (String) jComboBox21.getSelectedItem();
        String qwe = jTextField3.getText();
        Integer qwi = Integer.parseInt(qwe);  //voucher no

        String etr = jTextField24.getText();
        Double gwe = Double.valueOf(etr); //no of labels

        String dwu = (String) jComboBox5.getSelectedItem(); //label name
        String compa = (String) jComboBox35.getSelectedItem(); //conspa
        String comle = (String) jComboBox31.getSelectedItem(); //conslbl
        String Mqwe = jTextField68.getText();
        Integer Mqwi = Integer.parseInt(Mqwe);

        try {
//where factory='" + access + "'
            PreparedStatement psly = db_Connection.getInstance().prepareStatement("SELECT * FROM package where can_name='" + gwu + "'");
            Connection conpack = (Connection) db_Connection.getInstance();
            conpack.setAutoCommit(false);
            try {
                rusev = psly.executeQuery();

                while (rusev.next()) {
                    jTextField133.setText(rusev.getString("price_per_can"));

                }

                try {
//where factory='" + access + "'
                    PreparedStatement pslLy = db_Connection.getInstance().prepareStatement("SELECT * FROM package where label_name='" + dwu + "'");

                    try {
                        rusev = pslLy.executeQuery();

                        while (rusev.next()) {
                            jTextField134.setText(rusev.getString("price_per_label"));

                        }
                        try {
                            String pfpry = jTextField133.getText();
                            Double pfryce = Double.valueOf(pfpry);
                            String plpry = jTextField134.getText();
                            Double plryce = Double.valueOf(plpry);

                            try {

                                PreparedStatement ps4 = conpack.prepareStatement("INSERT INTO packageproduction(voucher_no,can_name,no_of_cans,label_name,no_of_labels,groupe,production_id,can_waste,pricepercan,priceperlabel,packcons_no,lblcons_no)"
                                        + "values(?,?,?,?,?,?,?,?,?,?,?,?)");
                                ps4.setInt(1, qwi);
                                ps4.setString(2, gwu);
                                ps4.setDouble(3, bwe);
                                ps4.setString(4, dwu);
                                ps4.setDouble(5, gwe);
                                ps4.setString(6, dwu1);
                                ps4.setInt(7, Mqwi);
                                ps4.setDouble(8, bwre);
                                ps4.setDouble(9, pfryce);
                                ps4.setDouble(10, plryce);
                                ps4.setString(11, compa);
                                ps4.setString(12, comle);

                                ps4.executeUpdate();
//                JOptionPane.showMessageDialog(null, "The data was successfully added to the Database!");

//TABLE INSERT
                                try {
                                    DefaultTableModel model = (DefaultTableModel) jTable17.getModel();

                                    try {
                                        int e3 = model.getRowCount();
                                        for (int eu3 = 0; eu3 <= e3; ++eu3) {
                                            model.removeRow(0);
                                        }
                                    } catch (Exception e) {
                                    }
                                    try (PreparedStatement pse = db_Connection.getInstance().prepareStatement("SELECT * FROM packageproduction where voucher_no = '" + qwi + "';")) {

                                        rusev = pse.executeQuery();

                                        while (rusev.next()) {
                                            model.addRow(new Object[]{rusev.getString("packId"), rusev.getString("can_name"), rusev.getDouble("no_of_cans"), rusev.getString("label_name"), rusev.getDouble("no_of_labels")});
                                        }

                                        rusev.close();
                                        pse.close();
                                        conpack.commit();
                                    } catch (Exception e) {
//                                        e.printStackTrace();
                                        JOptionPane.showMessageDialog(null, "Error in connectivity");
                                    }

                                } catch (Exception e) {
                                    JOptionPane.showMessageDialog(null, e.getMessage());
//                                    e.printStackTrace();
                                }

                            } catch (Exception e) {
//                                e.printStackTrace();
                                JOptionPane.showMessageDialog(null, e.getMessage());
                            }
                        } catch (Exception e) {
//                            e.printStackTrace();
                            JOptionPane.showMessageDialog(null, "Error in connectivity");
                        }

                    } catch (Exception e) {
//                        e.printStackTrace();
                        JOptionPane.showMessageDialog(null, e.getMessage());
                    }

                } catch (Exception e) {
//                    e.printStackTrace();
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }
            } catch (Exception e) {
//                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error in connectivity");
            }

        } catch (Exception e) {
//            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

        // TODO add your handling code here:
    }

}
