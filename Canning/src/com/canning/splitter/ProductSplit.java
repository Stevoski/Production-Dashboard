/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.canning.splitter;


import java.awt.HeadlessException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import static newpackage1.NewJFrame.jComboBox21;
import static newpackage1.NewJFrame.jComboBox26;
import static newpackage1.NewJFrame.jComboBox3;
import static newpackage1.NewJFrame.jDate1;
import static newpackage1.NewJFrame.jRadioButton11;
import static newpackage1.NewJFrame.jTextField3;
import static newpackage1.NewJFrame.jTextField64;
import static newpackage1.NewJFrame.jTextField73;
import static newpackage1.NewJFrame.jTextField78;
import static newpackage1.NewJFrame.jTextField79;
import static newpackage1.NewJFrame.jTextLogin;
import static newpackage1.NewJFrame.jTextStatus;
import static newpackage1.NewJFrame.totman;
import static newpackage1.NewJFrame.totsea;
 import static newpackage1.NewJFrame.jDialog1;
import newpackage1.db_Connection;
/**
 *
 * @author Stevoski
 */
public  class ProductSplit {
    public static void splitProduct() throws HeadlessException, NumberFormatException {
            ResultSet rs;
        String sawa1 = (String) jComboBox26.getSelectedItem();
        String combofaact = (String) jComboBox3.getSelectedItem();
        String sua11 = jTextLogin.getText();
        String stetoss = jTextStatus.getText();
        String twe1 = jTextField3.getText();
        Integer twi1 = Integer.parseInt(twe1);
        String swa1 = (String) jComboBox21.getSelectedItem();
        String dte = ((JTextField) jDate1.getDateEditor().getUiComponent()).getText();
        String catat1 = jTextField73.getText();//manpower
        Double catta = Double.valueOf(catat1);
        String catata1 = jTextField79.getText();//qty
        Double cattaa = Double.valueOf(catata1);
        String atata1 = jTextField64.getText();//id
        Double attaa = Double.valueOf(atata1);
        String tosea = totsea.getText();
        Double seatot = Double.valueOf(tosea);
        String toper = totman.getText();
        Double pertot = Double.valueOf(toper);
        switch (stetoss) {
            case "USER":
                if (jRadioButton11.isSelected() == true) {
                    //SUM QTYKGS DISPLAY
                    try {
                        try {
                            String si = "select sum(quantityKGS) from prodpriceinclusive where voucher_no= '" + twi1 + "' and date= '" + dte + "'  and groupe= '" + swa1 + "'  AND splitter= '" + sawa1 + "'  and factory= '" + sua11 + "' ";
                            try (PreparedStatement psi = db_Connection.getInstance().prepareStatement(si)) {
                                
                                rs = psi.executeQuery(si);
                                
                                while (rs.next()) {
                                    Double jansal = rs.getDouble(1);
                                    jTextField78.setText(String.valueOf(jansal));
                                }
                                try {
                                    String vas = jTextField78.getText();
                                    Double vasa = Double.valueOf(vas);
                                    Double krea = cattaa / vasa;
                                    Double kwata = (krea * catta);
                                    try {
                                        
                                        String Changa = "update productproduction set manpower_hrs='" + kwata + "' where (ProductionID= '" + attaa + "')";
                                        try (PreparedStatement psi3 = db_Connection.getInstance().prepareStatement(Changa)) {
                                            psi3.executeUpdate();
//                                    JOptionPane.showMessageDialog(null, "OPERATION SUCCESSFUL!");
psi3.close();
//                                    jDialog1.dispose();
                                        } catch (Exception e) {
                                            JOptionPane.showMessageDialog(null, "Error Executing!");
                                            //                                    e.printStackTrace();
                                        }
                                        rs.close();
                                        try {
                                            Double seaso = cattaa / vasa;
                                            Double season = (seaso * seatot);
                                            try {
                                                
                                                String seasoto = "update productproduction set seasonal='" + season + "' where (ProductionID= '" + attaa + "')";
                                                try (PreparedStatement psi3 = db_Connection.getInstance().prepareStatement(seasoto)) {
                                                    psi3.executeUpdate();
//                                    JOptionPane.showMessageDialog(null, "OPERATION SUCCESSFUL!");
psi3.close();
//                                    jDialog1.dispose();
                                                } catch (Exception e) {
                                                    JOptionPane.showMessageDialog(null, "Error Executing!");
                                                    e.printStackTrace();
                                                }
                                                rs.close();
                                            } catch (Exception e) {
                                                //                                e.printStackTrace();
                                                JOptionPane.showMessageDialog(null, "Database Error");
                                            }
                                        } catch (Exception e) {
                                            //                            e.printStackTrace();
                                            JOptionPane.showMessageDialog(null, "Database Error");
                                        }
                                        try {
                                            Double per = cattaa / vasa;
                                            Double perma = (per * pertot);
                                            try {
                                                
                                                String perman = "update productproduction set permanent='" + perma + "' where (ProductionID= '" + attaa + "')";
                                                try (PreparedStatement psi3 = db_Connection.getInstance().prepareStatement(perman)) {
                                                    psi3.executeUpdate();
                                                    
                                                    psi3.close();
                                                    //                                    jDialog1.dispose();
                                                } catch (Exception e) {
                                                    JOptionPane.showMessageDialog(null, "Error Executing!");
                                                    e.printStackTrace();
                                                }
                                                rs.close();
                                            } catch (Exception e) {
                                                //                                e.printStackTrace();
                                                JOptionPane.showMessageDialog(null, "Database Error");
                                            }
                                        } catch (Exception e) {
                                            //                            e.printStackTrace();
                                            JOptionPane.showMessageDialog(null, "Database Error");
                                        }
                                    } catch (Exception e) {
                                        //                                e.printStackTrace();
                                        JOptionPane.showMessageDialog(null, "Database Error");
                                    }
                                    
                                    JOptionPane.showMessageDialog(null, "OPERATION SUCCESSFUL!");
                                    
                                } catch (Exception e) {
                                    //                            e.printStackTrace();
                                    JOptionPane.showMessageDialog(null, "Error Executing");
                                }
                                psi.close();
                                rs.close();
                            } catch (Exception e) {
                                //                        e.printStackTrace();
                                JOptionPane.showMessageDialog(null, "Database Error");
                            }
                            
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null, "Error Executing");
                            //                    e.printStackTrace();
                        }
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Error connection");
                        //                e.printStackTrace();
                    }
                } else {
                    jDialog1.dispose();
                    //            JOptionPane.showDialog(null, "Only for shared resources!!");
                }
                break;
                
            case "ADMINISTRATOR":
                if (jRadioButton11.isSelected() == true) {
                    //SUM QTYKGS DISPLAY
                    try {
                        try {
                            String si = "select sum(quantityKGS) from prodpriceinclusive where voucher_no= '" + twi1 + "' and date= '" + dte + "'  and groupe= '" + swa1 + "'  AND splitter= '" + sawa1 + "'  and factory= '" + combofaact + "' ";
                            try (PreparedStatement psi = db_Connection.getInstance().prepareStatement(si)) {
                                
                                rs = psi.executeQuery(si);
                                
                                while (rs.next()) {
                                    Double jansal = rs.getDouble(1);
                                    
                                    jTextField78.setText(String.valueOf(jansal));
                                    
                                }
                                try {
                                    String vas = jTextField78.getText();
                                    Double vasa = Double.valueOf(vas);
                                    Double krea = cattaa / vasa;
                                    Double kwata = (krea * catta);
                                    
                                    Double aper = cattaa / vasa;
                                    Double aperma = (aper * pertot);
                                    
                                    Double aseaso = cattaa / vasa;
                                    Double aseason = (aseaso * seatot);
                                    try {
                                        
                                        String Changa = "update productproduction set manpower_hrs=?,seasonal=?,permanent=? where (ProductionID= ?)";
                                        try (PreparedStatement psi3 = db_Connection.getInstance().prepareStatement(Changa)) {
                                            psi3.setDouble(1, kwata);
                                            psi3.setDouble(2, aseason);
                                            psi3.setDouble(3, aperma);
                                            psi3.setDouble(4, attaa);
                                            psi3.executeUpdate();
                                            JOptionPane.showMessageDialog(null, "OPERATION SUCCESSFUL!");
                                            psi3.close();
                                            //                                    jDialog1.dispose();
                                        } catch (Exception e) {
                                            JOptionPane.showMessageDialog(null, "Error Executing!");
                                            //                                    e.printStackTrace();
                                        }
                                        rs.close();
                                    } catch (Exception e) {
                                        //                                e.printStackTrace();
                                        JOptionPane.showMessageDialog(null, "Database Error");
                                    }
                                } catch (Exception e) {
                                    //                            e.printStackTrace();
                                    JOptionPane.showMessageDialog(null, "Database Error");
                                }
                                psi.close();
                                rs.close();
                            } catch (Exception e) {
                                //                        e.printStackTrace();
                                JOptionPane.showMessageDialog(null, "Database Error");
                            }
                            
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null, "Error connection");
                            //                    e.printStackTrace();
                        }
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Error connection");
                        //                e.printStackTrace();
                    }
                } else {
                    jDialog1.dispose();
                    //            JOptionPane.showDialog(null, "Only for shared resources!!");
                }
                break;
                
        }
        
        // TODO add your handling code here:
    }
    
}
