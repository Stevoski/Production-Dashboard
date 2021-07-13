/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.canning.loaderReturns;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import static newpackage1.NewJFrame.jTextField64;
import static newpackage1.NewJFrame.jTextField3;
import static newpackage1.ExportAndImport.jComboBox13;
import static newpackage1.ExportAndImport.jTable25;
import static newpackage1.ExportAndImport.jTable24;
import static newpackage1.ExportAndImport.jTextField108;
import static newpackage1.ExportAndImport.jTable20;
import static newpackage1.ExportAndImport.bomProd_disp;
import static newpackage1.ExportAndImport.jTextField105;
import static newpackage1.ExportAndImport.jTextField107;
import static newpackage1.NewJFrame.MainPanel;
import static newpackage1.NewJFrame.MainPanel;
import newpackage1.NewJFrame;
import static newpackage1.NewJFrame.jTextField45;

import newpackage1.db_Connection;

/**
 *
 * @author Stevoski
 */
public class bomLoader {

    public static void bomprodnLoad() throws NumberFormatException {
        String cimbio = jTextField64.getText();
        Integer cimbiolae = Integer.valueOf(jTextField3.getText());
        String cimbiola = String.valueOf(cimbiolae);
        ResultSet ryat = null;

//        String Cimbi = (String) jComboBox13.getSelectedItem();
        try {

            PreparedStatement pse0a = db_Connection.getInstance().prepareStatement("SELECT * FROM productproduction where ProductionID = '" + cimbio + "';");

            ryat = pse0a.executeQuery();

            while (ryat.next()) {
                String stua = ryat.getString("product_name");
                jTextField105.setText(String.valueOf(stua));
                int stuaO = ryat.getInt("ProductionID");
                jTextField107.setText(String.valueOf(stuaO));
                String QUITO = ryat.getString("quantity");
                jTextField45.setText(String.valueOf(QUITO));

            }
            String cuantooto = jTextField45.getText();
            Double qtycuanto = Double.valueOf(cuantooto);
            String Cimbi = (String) jTextField105.getText();
//        try {
//              Connection conntbtie = (Connection) db_Connection.getInstance();
//            conntbtie.setAutoCommit(false);
            try {
                DefaultTableModel modula = (DefaultTableModel) jTable25.getModel();

                try {
                    int e3 = modula.getRowCount();
                    for (int eu3 = 0; eu3 <= e3; ++eu3) {
                        modula.removeRow(0);
                    }
                } catch (Exception e) {
                }
                try {
                    PreparedStatement pse0 = db_Connection.getInstance().prepareStatement("SELECT * FROM ingredbom where product = '" + Cimbi + "';");
                    ryat = pse0.executeQuery();
                    while (ryat.next()) {
                        Double qty = ryat.getDouble("quantity");
                        Double sumqty = qty * qtycuanto;
                        modula.addRow(new Object[]{ryat.getString("ingredient"), sumqty, ryat.getDouble("price"), ryat.getString("unit")});
                    }
//                                JOptionPane.showMessageDialog(null, "The data was successfully added to the Database!");

//                TABLE INSERT Raw Materials
                    try {
                        DefaultTableModel model = (DefaultTableModel) jTable24.getModel();

                        try {
                            int e3 = model.getRowCount();
                            for (int eu3 = 0; eu3 <= e3; ++eu3) {
                                model.removeRow(0);
                            }
                        } catch (Exception e) {
                        }
                        try {

                            PreparedStatement pse = db_Connection.getInstance().prepareStatement("SELECT * FROM rawbom where product_name = '" + Cimbi + "';");

                            ryat = pse.executeQuery();

                            while (ryat.next()) {
                                Double qty = ryat.getDouble("quantity");
                                Double sumqty = qty * qtycuanto;
                                model.addRow(new Object[]{ryat.getString("raw_material"), sumqty, ryat.getDouble("price"), ryat.getString("unit")});

                            }
                            try {
                                DefaultTableModel lamodula = (DefaultTableModel) jTable20.getModel();

                                try {
                                    int e3 = lamodula.getRowCount();
                                    for (int eu3 = 0; eu3 <= e3; ++eu3) {
                                        lamodula.removeRow(0);
                                    }
                                } catch (Exception e) {
                                }
                                try {
                                    PreparedStatement pse04 = db_Connection.getInstance().prepareStatement("SELECT * FROM bom_package where product = '" + Cimbi + "';");

                                    ryat = pse04.executeQuery();

                                    while (ryat.next()) {
                                        Double qty = ryat.getDouble("quantity");
                                        Double sumqty = qty * qtycuanto;
                                        lamodula.addRow(new Object[]{ryat.getString("package"), sumqty, ryat.getDouble("can_waste"), ryat.getString("label"), sumqty, ryat.getDouble("package_price"), ryat.getDouble("label_price")});
                                    }
                                    try {
                                        jTextField108.setText(cimbiola);
                                        MainPanel.removeAll();
                                        MainPanel.add(bomProd_disp);
                                        MainPanel.repaint();
                                        MainPanel.revalidate();

                                    } catch (Exception e) {
                                        //                        e.printStackTrace();
                                    }
                                    //display prod
                                    //
                                    pse04.close();
                                    //                        pse.close();
                                } catch (Exception e) {
                                    //                        e.printStackTrace();
                                    JOptionPane.showMessageDialog(null, "Error in connectivity");
                                }

                            } catch (Exception e) {
                                //                    e.printStackTrace();
                                JOptionPane.showMessageDialog(null, "Error in connectivity");
                            }
                            pse.close();
                        } catch (Exception ex) {
                            Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
                        }

                    } catch (Exception ex) {
                        Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    pse0.close();
                } catch (Exception ex) {
                    Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
                }

            } catch (Exception ex) {
                Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
            pse0a.close();
            ryat.close();
        } catch (Exception ex) {
            Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
//           
//            } catch (Exception ex) {
//            Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
//        }
        // TODO add your handling code here:
    }

    //            } catch (Exception ex) {
    //                JOptionPane.showMessageDialog(null, ex.getMessage());
    ////                ex.printStackTrace();
    //            }
    //        } catch (Exception ex) {
    //            JOptionPane.showMessageDialog(null, ex.getMessage());
    ////            ex.printStackTrace();
    //        }
    // String friah=jTextField3.getText();
    //
//                try {
//                    DefaultTableModel modelfriah = (DefaultTableModel) jTable14.getModel();
//
//                    try {
//                        int z = modelfriah.getRowCount();
//                        for (int lue = 0; lue <= z; ++lue) {
//                            modelfriah.removeRow(0);
//                        }
//
//                    } catch (Exception e) {
//                        //                           JOptionPane.showMessageDialog(null, "Cannot save." + e);
//                        //                               e.printStackTrace();
//                    }
//                    try (PreparedStatement ps1 = db_Connection.getInstance().prepareStatement("SELECT * FROM prodpriceinclusive where voucher_no = '" + friah + "';")) {
//                        ryat = ps1.executeQuery();
//                        while (ryat.next()) {
//                            modelfriah.addRow(new Object[]{ryat.getString("ProductionID"), ryat.getString("product_name"), ryat.getDouble("quantity"), ryat.getString("unit"), ryat.getString("groupe")});
//                        }
//                //                        rsPadd.close();
//                //DISPLAY PRODUCT TEXTFIELD
//                try {
//
//                    //                            Connection con18 = (Connection) db_Connection.getInstance();
//                    //                Statement stmt4 = con18.createStatement();
//
//                    try {
//                        String t = "SELECT sum(quantity) FROM prodpriceinclusive WHERE voucher_no= '" + friah + "';";
//
//                        PreparedStatement psc = db_Connection.getInstance().prepareStatement(t);
//                        ryat = psc.executeQuery(t);
//
//                        if (ryat.next()) {
//                            Double kansal = ryat.getDouble(1);
//
//                            jTextField45.setText(String.valueOf(kansal));
//                        }
//                        //                            String manqq=jTextField45.getText();
//                        //                            String manq=twa
//                        psc.close();
//
//                    } catch (Exception e) {
//                        //                            e.printStackTrace();
//                        JOptionPane.showMessageDialog(null, "Cannot save." + e);
//                    }
}
