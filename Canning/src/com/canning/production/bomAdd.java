/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.canning.production;
//import static newpackage1.NewJFrame.getFrames;

import java.sql.Connection;
import java.awt.HeadlessException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import static newpackage1.ExportAndImport.jTable20;
import static newpackage1.NewJFrame.jComboBox21;
import static newpackage1.NewJFrame.jTable15;
import static newpackage1.NewJFrame.jTable16;
import static newpackage1.ExportAndImport.jTextField107;
import static newpackage1.ExportAndImport.jTextField108;
import static newpackage1.ExportAndImport.jTable24;
import static newpackage1.ExportAndImport.jTable25;
import static newpackage1.NewJFrame.IngFormer;
import static newpackage1.NewJFrame.MainPanel;
import static newpackage1.NewJFrame.jPanel3;
import static newpackage1.NewJFrame.jTable17;
import static newpackage1.NewJFrame.jTextField3;

import newpackage1.db_Connection;

/**
 *
 * @author Stevoski
 */
public class bomAdd {

    public static void addBom() throws HeadlessException {
        ResultSet rs;
        PreparedStatement ps;
        PreparedStatement ps1;
        PreparedStatement ps2;
        String Groupe = (String) jComboBox21.getSelectedItem();
        String xiao = jTextField3.getText();
        String voouchernoo = jTextField108.getText();
        Integer vooucherno = Integer.valueOf(voouchernoo);
        try {
            int rowsi = jTable24.getRowCount();
//
//            Connection conntbtie = (Connection) db_Connection.getInstance();
//            conntbtie.setAutoCommit(false);
//
            String querycoh = "insert into raw_materialproduction (raw_material,qty,rawmaterialprice,ProductionID,voucher_no,groupe,Total_qty) values(?,?,?,?,?,?,?)";

            ps = db_Connection.getInstance().prepareStatement(querycoh);
            for (int row = 0; row < rowsi; row++) {
                String coitemname = (String) jTable24.getValueAt(row, 0);
                Double cocateg = (Double) jTable24.getValueAt(row, 1);
//                Double cocateg = Double.valueOf(cocatega);
                Double codesc = (Double) jTable24.getValueAt(row, 2);
//                  Double codesc = Double.valueOf(codesca);
//                Double codesc = Double.valueOf(codesca);
//                 String codesc90 = (String) jTable24.getValueAt(row, 3);

//                Integer mwarata1 = Integer.valueOf(codesc);
                String codescoH = jTextField108.getText();
                Integer mwarata = Integer.valueOf(codescoH);
                String codescoHe = jTextField107.getText();
                Integer mwaratae = Integer.valueOf(codescoHe);

                ps.setString(1, coitemname);
                ps.setDouble(2, cocateg);
                ps.setDouble(3, codesc);
                ps.setInt(4, mwaratae);
                ps.setInt(5, mwarata);
                ps.setString(6, Groupe);
                ps.setDouble(7, cocateg);

                ps.addBatch();
////INGREDIENTS TABLE
//
            }
            ps.executeBatch();
            try {
//                Connection conntbtie1 = (Connection) db_Connection.getInstance();
//                conntbtie1.setAutoCommit(false);
                int rowsie = jTable25.getRowCount();
                String querycohe = "insert into ingredientsproduction (ingredient_name,ingredient_qty,price,ProductionID,voucher_no,groupe,Total_qty) values(?,?,?,?,?,?,?)";

                ps1 = db_Connection.getInstance().prepareStatement(querycohe);
                for (int row = 0; row < rowsie; row++) {
                    String ingname = (String) jTable25.getValueAt(row, 0);
                    Double qty = (Double) jTable25.getValueAt(row, 1);
//                    Double qty = Double.valueOf(ingqty);
                    Double price = (Double) jTable25.getValueAt(row, 2);
//                    Double price = Double.valueOf(ingprice);
//                    

//                Double mwarataee = Double.valueOf(price);
                    String codesco = jTextField107.getText();
                    Integer PID = Integer.valueOf(codesco);
                    String codescoH = jTextField108.getText();
                    Integer VCRNO = Integer.valueOf(codescoH);

                    ps1.setString(1, ingname);
                    ps1.setDouble(2, qty);
                    ps1.setDouble(3, price);
                    ps1.setInt(4, PID);
                    ps1.setInt(5, VCRNO);
                    ps1.setString(6, Groupe);
                    ps1.setDouble(7, qty);

                    ps1.addBatch();
                }
                ps1.executeBatch();
                try {
//                    Connection conntbtie2 = (Connection) db_Connection.getInstance();
//                    conntbtie2.setAutoCommit(false);
                    int rosee = jTable20.getRowCount();
                    String querypackage = "INSERT INTO packageproduction(voucher_no,can_name,no_of_cans,label_name,no_of_labels,groupe,production_id,can_waste,pricepercan,priceperlabel)"
                            + "values(?,?,?,?,?,?,?,?,?,?)";

                    ps2 = db_Connection.getInstance().prepareStatement(querypackage);
                    for (int row = 0; row < rosee; row++) {
                        String packname = (String) jTable20.getValueAt(row, 0);
                        Double packqty = (Double) jTable20.getValueAt(row, 1);
                        Double cwaste = (Double) jTable20.getValueAt(row, 2);

                        String labelname = (String) jTable20.getValueAt(row, 3);
                        Double lblqty = (Double) jTable20.getValueAt(row, 4);
                        Double pckprice = (Double) jTable20.getValueAt(row, 5);
                        Double lblprice = (Double) jTable20.getValueAt(row, 6);

                        String prodnidd = jTextField107.getText();
                        Integer prodnid = Integer.valueOf(prodnidd);
                        String packvchrr = jTextField108.getText();
                        Integer packvchr = Integer.valueOf(packvchrr);

                        ps2.setInt(1, packvchr);
                        ps2.setString(2, packname);
                        ps2.setDouble(3, packqty);
                        ps2.setString(4, labelname);
                        ps2.setDouble(5, lblqty);
                        ps2.setString(6, Groupe);
                        ps2.setInt(7, prodnid);
                        ps2.setDouble(8, cwaste);
                        ps2.setDouble(9, pckprice);
                        ps2.setDouble(10, lblprice);
                        ps2.addBatch();
                    }
                    ps2.executeBatch();
                    //TABLE preview Raw Material
                    try {
                        DefaultTableModel model = (DefaultTableModel) jTable17.getModel();

                        try {
                            int e3 = model.getRowCount();
                            for (int eu3 = 0; eu3 <= e3; ++eu3) {
                                model.removeRow(0);
                            }
                        } catch (Exception e) {
                        }
                        try (PreparedStatement pse = db_Connection.getInstance().prepareStatement("SELECT * FROM packageproduction where voucher_no = '" + vooucherno + "';")) {

                            rs = pse.executeQuery();

                            while (rs.next()) {
                                model.addRow(new Object[]{rs.getString("packId"), rs.getString("can_name"), rs.getDouble("no_of_cans"), rs.getString("label_name"), rs.getDouble("no_of_labels")});
                            }

                            rs.close();
                            pse.close();
//                                        conpack.commit();
                        } catch (Exception e) {
//                                        e.printStackTrace();
                            JOptionPane.showMessageDialog(null, "Error in connectivity");
                        }

                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e.getMessage());
//                                    e.printStackTrace();
                    }
                    try {
                        DefaultTableModel model = (DefaultTableModel) jTable15.getModel();

                        try {
                            int z3 = model.getRowCount();
                            for (int lu3 = 0; lu3 <= z3; ++lu3) {
                                model.removeRow(0);
                            }
                        } catch (Exception e) {
                        }
                        try {

                            PreparedStatement ps5 = db_Connection.getInstance().prepareStatement("SELECT * FROM rawmatpriceinc where voucher_no = '" + xiao + "';");

                            rs = ps5.executeQuery();

                            while (rs.next()) {
                                model.addRow(new Object[]{rs.getInt("ProductionID"), rs.getString("raw_material"), rs.getDouble("qty"), rs.getString("unit"), rs.getInt("RawID")});
                            }
//                        //TABLE preview INGREDIENT
                            try {
                                DefaultTableModel del = (DefaultTableModel) jTable16.getModel();

                                try {
                                    int z3 = del.getRowCount();
                                    for (int lu3 = 0; lu3 <= z3; ++lu3) {
                                        del.removeRow(0);
                                    }
                                } catch (Exception e) {
                                }
                                try {

                                    PreparedStatement psingE = db_Connection.getInstance().prepareStatement("SELECT * FROM ingredpriceinc where voucher_no = '" + xiao + "';");

                                    rs = psingE.executeQuery();

                                    while (rs.next()) {
                                        del.addRow(new Object[]{rs.getInt("ProductionID"), rs.getString("ingredient_name"), rs.getDouble("ingredient_qty"), rs.getString("unit"), rs.getDouble("ingredient_price"), rs.getInt("ingredID")});
                                    }
                                    psingE.close();
                                    JOptionPane.showMessageDialog(null, "Successful");

                                    MainPanel.removeAll();
                                    MainPanel.add(jPanel3);
                                    MainPanel.repaint();
                                    MainPanel.revalidate();

                                } catch (Exception e) {
                                    JOptionPane.showMessageDialog(null, e.getMessage());
                                    e.printStackTrace();
                                }
                            } catch (Exception e) {
                                JOptionPane.showMessageDialog(null, e.getMessage());
                                e.printStackTrace();
                            }
                            ps5.close();
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null, e.getMessage());
                            e.printStackTrace();
                        }
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e.getMessage());
                        e.printStackTrace();
                    }
//                    conntbtie2.commit();
                    ps2.close();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                    e.printStackTrace();
                }

//                conntbtie1.commit();
//                
                ps1.close();

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
                e.printStackTrace();
            }
//            conntbtie.commit();
            ps.close();

//            conntbtie.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            e.printStackTrace();
        }

        // TODO add your handling code here:
    }
}
