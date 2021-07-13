/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.canning.production;

import java.sql.Connection;
import java.awt.HeadlessException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import newpackage1.ExportAndImport;
import newpackage1.LoginForm;
import newpackage1.NewJFrame;
import static newpackage1.NewJFrame.jTextField3;
import static newpackage1.NewJFrame.jTextField30;
import static newpackage1.NewJFrame.jTextField45;
import static newpackage1.NewJFrame.jTextField73;
import static newpackage1.NewJFrame.jComboBox26;
import static newpackage1.NewJFrame.jComboBox21;
import static newpackage1.NewJFrame.jComboBox13;
import static newpackage1.NewJFrame.jRadioButton11;
import static newpackage1.NewJFrame.jTable14;
import static newpackage1.NewJFrame.jDate1;
import static newpackage1.NewJFrame.jTextField87;
import static newpackage1.NewJFrame.jTextLogin;
import static newpackage1.NewJFrame.jTextUser;
import static newpackage1.NewJFrame.batch_no;
//jTextUser.getText();
//jTextLogin.getText()
import newpackage1.db_Connection;

/**
 *
 * @author Stevoski
 */
public class addProduct {

    public static void productAdd() throws HeadlessException, NumberFormatException {
        ResultSet rsPadd=null;
        String swa = (String) jComboBox21.getSelectedItem();
        String bre = jTextField30.getText();
        Double twa = Double.valueOf(bre);
        String twe = jTextField3.getText();
        Integer twi = Integer.parseInt(twe);
        String sua = (String) jComboBox13.getSelectedItem();
        String sua1 = jTextLogin.getText();
        String sua2 =  jTextUser.getText();
        String sawa = (String) jComboBox26.getSelectedItem();
        String bre1 = jTextField73.getText();
        Double twa1 = Double.valueOf(bre1);
        String brwe1 = jTextField87.getText();
        Double twwa1 = Double.valueOf(brwe1);
        String sbre1 = jTextField73.getText();
        Double stwa1 = Double.valueOf(sbre1);
         String banop = batch_no.getText();
          String seas = NewJFrame.jTextField95.getText();
        Double seaso = Double.valueOf(seas);
         String per = NewJFrame.jTextField96.getText();
        Double perm = Double.valueOf(per);

        if (jRadioButton11.isSelected() == true) {
            try {
                Connection con3 = (Connection) db_Connection.getInstance();
                con3.setAutoCommit(false);
                PreparedStatement psyfi = con3.prepareStatement("INSERT INTO productproduction (voucher_no,product_name,quantity,groupe,manpower_hrs,factory,splitter,total_manpower,waste,addedby,date,batch_no,seasonal,permanent,total_seasonal,total_permanent)"
                        + "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
                psyfi.setInt(1, twi);
                psyfi.setString(2, sua);
                psyfi.setDouble(3, twa);
                psyfi.setString(4, swa);
                psyfi.setDouble(5, twa1);
                psyfi.setString(6, sua1);
                psyfi.setString(7, sawa);
                psyfi.setDouble(8, stwa1);
                psyfi.setDouble(9, twwa1);
                psyfi.setString(10, sua2);
                psyfi.setString(11, ((JTextField) jDate1.getDateEditor().getUiComponent()).getText());
                psyfi.setString(12, banop);
                  psyfi.setDouble(13, seaso);
                  psyfi.setDouble(14, perm);
                   psyfi.setDouble(15, seaso);
                  psyfi.setDouble(16, perm);
//                ((JTextField) jDate1.getDateEditor().getUiComponent()).getText());
                psyfi.executeUpdate();
                
               

                //DISPLAY PRODUCT JTABLE
                try {
                    DefaultTableModel model = (DefaultTableModel) jTable14.getModel();

                    try {
                        int z = model.getRowCount();
                        for (int lue = 0; lue <= z; ++lue) {
                            model.removeRow(0);
                        }

                    } catch (Exception e) {
//                           JOptionPane.showMessageDialog(null, "Cannot save." + e);
//                               e.printStackTrace();
                    }

                    try (PreparedStatement ps1 = db_Connection.getInstance().prepareStatement("SELECT * FROM prodpriceinclusive where voucher_no = '" + twi + "';")) {
                        rsPadd = ps1.executeQuery();
                        while (rsPadd.next()) {
                            model.addRow(new Object[]{rsPadd.getString("ProductionID"), rsPadd.getString("product_name"), rsPadd.getDouble("quantity"), rsPadd.getString("unit"), rsPadd.getString("batch_no")});
                        }
//                        rsPadd.close();
                        //DISPLAY PRODUCT TEXTFIELD
                        try {
                         
//                            Connection con18 = (Connection) db_Connection.getInstance();
//                Statement stmt4 = con18.createStatement();

                            try {
                                String t = "SELECT sum(quantity) FROM prodpriceinclusive WHERE voucher_no= '" + twi + "';";

                                PreparedStatement psc = db_Connection.getInstance().prepareStatement(t);
                                rsPadd = psc.executeQuery(t);

                                if (rsPadd.next()) {
                                    Double kansal = rsPadd.getDouble(1);

                                    jTextField45.setText(String.valueOf(kansal));
                                }
//                            String manqq=jTextField45.getText();
//                            String manq=twa
                                psc.close();
                                con3.commit();
                            } catch (Exception e) {
//                            e.printStackTrace();
                                JOptionPane.showMessageDialog(null, "Cannot save." + e);
                            }
                        } catch (Exception ex) {
                            Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
                        }
                         rsPadd.close();
                        ps1.close();
                        
                    } catch (Exception e) {
                    e.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Error in connectivity");
                    }

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Invalid Entry or field must be completely filled", "message", 2);
                }

//              psyfi.close();  //HAPA
            } catch (Exception e) {
//            e.printStackTrace();
                JOptionPane.showMessageDialog(null, e.getMessage());
            }

        } else {
            
            try {
                Connection con3 = (Connection) db_Connection.getInstance();
                con3.setAutoCommit(false);
                PreparedStatement ps = con3.prepareStatement("INSERT INTO productproduction (voucher_no,product_name,quantity,groupe,manpower_hrs,factory,splitter,total_manpower,waste,addedby,price,stock_bf,stock_cf,amount,date,batch_no,seasonal,permanent,total_seasonal,total_permanent)"
                        + "values(?,?,?,?,?,?,?,?,?,?,'0','0','0','0',?,?,?,?,?,?)");
                ps.setInt(1, twi);
                ps.setString(2, sua);
                ps.setDouble(3, twa);
                ps.setString(4, swa);
                ps.setDouble(5, twa1);
                ps.setString(6, sua1);
                ps.setString(7, sawa);
                ps.setDouble(8, stwa1);
                ps.setDouble(9, twwa1);
                ps.setString(10, sua2);
                 ps.setString(11, ((JTextField) jDate1.getDateEditor().getUiComponent()).getText());
                 ps.setString(12, banop);
                    ps.setDouble(13, seaso);
                  ps.setDouble(14, perm);
                   ps.setDouble(15, seaso);
                  ps.setDouble(16, perm);
                 ps.executeUpdate();

                //DISPLAY PRODUCT JTABLE
                try {
                    DefaultTableModel model = (DefaultTableModel) jTable14.getModel();

                    try {
                        int z = model.getRowCount();
                        for (int lue = 0; lue <= z; ++lue) {
                            model.removeRow(0);
                        }
                    } catch (Exception e) {
                    }

                    try (PreparedStatement ps1 = db_Connection.getInstance().prepareStatement("SELECT * FROM prodpriceinclusive where voucher_no = '" + twi + "';")) {
                        rsPadd = ps1.executeQuery();
                        while (rsPadd.next()) {
                            model.addRow(new Object[]{rsPadd.getString("ProductionID"), rsPadd.getString("product_name"), rsPadd.getDouble("quantity"), rsPadd.getString("unit"), rsPadd.getString("batch_no")});
                        }
                        rsPadd.close();
                        //DISPLAY PRODUCT TEXTFIELD
                        try {
                            
//                            Connection con18 = (Connection) db_Connection.getInstance();

                            try {
                                String t = "SELECT sum(quantity) FROM prodpriceinclusive WHERE voucher_no= '" + twi + "';";

                                PreparedStatement psc = db_Connection.getInstance().prepareStatement(t);
                                rsPadd = psc.executeQuery(t);

                                if (rsPadd.next()) {
                                    Double kansal = rsPadd.getDouble(1);
                                    jTextField45.setText(String.valueOf(kansal));
                                }
                                rsPadd.close();
                                psc.close();
                                con3.commit();
                            } catch (Exception e) {
//                            e.printStackTrace();
                                JOptionPane.showMessageDialog(null, "Cannot save." + e);
                            }
                        } catch (Exception ex) {
                            Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
                        }
ps1.close();
                    } catch (Exception e) {
                    e.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Error in connectivity");
                    }

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Invalid Entry or field must be completely filled", "message", 2);
                }

               ps.close();  //HAPA
            } catch (Exception e) {
//            e.printStackTrace();
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
        // TODO add your handling code here:
    }
//     public static void newProductAdd() throws HeadlessException, NumberFormatException {
//        ResultSet rsPadd=null;
//        String swa = (String) jComboBox21.getSelectedItem();
//        String bre = ExportAndImport.pprodqty.getText();//qty
//        Double twa = Double.valueOf(bre);
//        String twe = jTextField3.getText();
//        Integer twi = Integer.parseInt(twe);
//        String sua = (String) ExportAndImport.pprod.getSelectedItem();//product
//        String sua1 = jTextLogin.getText();
//        String sua2 =  jTextUser.getText();
//        String sawa = (String) jComboBox26.getSelectedItem();
//        String bre1 = jTextField73.getText();
//        Double twa1 = Double.valueOf(bre1);
//        String brwe1 = ExportAndImport.pprodwaste.getText();//waste
//        Double twwa1 = Double.valueOf(brwe1);
//        String sbre1 = ExportAndImport.pmanp.getText();//manpower
//        Double stwa1 = Double.valueOf(sbre1);
//         String banop = ExportAndImport.batch_no1.getText();
//
////        if (jRadioButton11.isSelected() == true) {
//            try {
//                Connection con3 = (Connection) db_Connection.getInstance();
//                con3.setAutoCommit(false);
//                PreparedStatement psyfi = con3.prepareStatement("INSERT INTO productproduction (voucher_no,product_name,quantity,groupe,manpower_hrs,factory,splitter,total_manpower,waste,addedby,date,batch_no)"
//                        + "values(?,?,?,?,?,?,?,?,?,?,?,?)");
//                psyfi.setInt(1, twi);
//                psyfi.setString(2, sua);
//                psyfi.setDouble(3, twa);
//                psyfi.setString(4, swa);
//                psyfi.setDouble(5, twa1);
//                psyfi.setString(6, sua1);
//                psyfi.setString(7, sawa);
//                psyfi.setDouble(8, stwa1);
//                psyfi.setDouble(9, twwa1);
//                psyfi.setString(10, sua2);
//                psyfi.setString(11, ((JTextField) ExportAndImport.vdate.getDateEditor().getUiComponent()).getText());
//                psyfi.setString(12, banop);
////                ((JTextField) jDate1.getDateEditor().getUiComponent()).getText());
//                psyfi.executeUpdate();
//                
//               
//
//                //DISPLAY PRODUCT JTABLE
//                try {
//                    DefaultTableModel model = (DefaultTableModel) ExportAndImport.jTable23.getModel();
//
//                    try {
//                        int z = model.getRowCount();
//                        for (int lue = 0; lue <= z; ++lue) {
//                            model.removeRow(0);
//                        }
//
//                    } catch (Exception e) {
////                           JOptionPane.showMessageDialog(null, "Cannot save." + e);
////                               e.printStackTrace();
//                    }
//
//                    try (PreparedStatement ps1 = db_Connection.getInstance().prepareStatement("SELECT * FROM prodpriceinclusive where voucher_no = '" + twi + "';")) {
//                        rsPadd = ps1.executeQuery();
//                        while (rsPadd.next()) {
//                            model.addRow(new Object[]{rsPadd.getString("ProductionID"), rsPadd.getString("product_name"), rsPadd.getDouble("quantity"), rsPadd.getString("unit"), rsPadd.getString("batch_no")});
//                        }
////                        rsPadd.close();
//                        //DISPLAY PRODUCT TEXTFIELD
//                        try {
//                         
////                            Connection con18 = (Connection) db_Connection.getInstance();
////                Statement stmt4 = con18.createStatement();
//
//                            try {
//                                String t = "SELECT sum(quantity) FROM prodpriceinclusive WHERE voucher_no= '" + twi + "';";
//
//                                PreparedStatement psc = db_Connection.getInstance().prepareStatement(t);
//                                rsPadd = psc.executeQuery(t);
//
//                                if (rsPadd.next()) {
//                                    Double kansal = rsPadd.getDouble(1);
//
//                                    jTextField45.setText(String.valueOf(kansal));
//                                }
////                            String manqq=jTextField45.getText();
////                            String manq=twa
//                                psc.close();
//                                con3.commit();
//                            } catch (Exception e) {
////                            e.printStackTrace();
//                                JOptionPane.showMessageDialog(null, "Cannot save." + e);
//                            }
//                        } catch (Exception ex) {
//                            Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
//                        }
//                         rsPadd.close();
//                        ps1.close();
//                        
//                    } catch (Exception e) {
//                    e.printStackTrace();
//                        JOptionPane.showMessageDialog(null, "Error in connectivity");
//                    }
//
//                } catch (Exception e) {
//                    JOptionPane.showMessageDialog(null, "Invalid Entry or field must be completely filled", "message", 2);
//                }
//
////              psyfi.close();  //HAPA
//            } catch (Exception e) {
////            e.printStackTrace();
//                JOptionPane.showMessageDialog(null, e.getMessage());
//            }
//
////        } else {
//            
////            try {
////                Connection con3 = (Connection) db_Connection.getInstance();
////                con3.setAutoCommit(false);
////                PreparedStatement ps = con3.prepareStatement("INSERT INTO productproduction (voucher_no,product_name,quantity,groupe,manpower_hrs,factory,splitter,total_manpower,waste,addedby,price,stock_bf,stock_cf,amount,date,batch_no)"
////                        + "values(?,?,?,?,?,?,?,?,?,?,'0','0','0','0',?,?)");
////                ps.setInt(1, twi);
////                ps.setString(2, sua);
////                ps.setDouble(3, twa);
////                ps.setString(4, swa);
////                ps.setDouble(5, twa1);
////                ps.setString(6, sua1);
////                ps.setString(7, sawa);
////                ps.setDouble(8, stwa1);
////                ps.setDouble(9, twwa1);
////                ps.setString(10, sua2);
////                 ps.setString(11, ((JTextField) jDate1.getDateEditor().getUiComponent()).getText());
////                 ps.setString(12, banop);
////                 ps.executeUpdate();
////
////                //DISPLAY PRODUCT JTABLE
////                try {
////                    DefaultTableModel model = (DefaultTableModel) jTable14.getModel();
////
////                    try {
////                        int z = model.getRowCount();
////                        for (int lue = 0; lue <= z; ++lue) {
////                            model.removeRow(0);
////                        }
////                    } catch (Exception e) {
////                    }
////
////                    try (PreparedStatement ps1 = db_Connection.getInstance().prepareStatement("SELECT * FROM prodpriceinclusive where voucher_no = '" + twi + "';")) {
////                        rsPadd = ps1.executeQuery();
////                        while (rsPadd.next()) {
////                            model.addRow(new Object[]{rsPadd.getString("ProductionID"), rsPadd.getString("product_name"), rsPadd.getDouble("quantity"), rsPadd.getString("unit"), rsPadd.getString("batch_no")});
////                        }
////                        rsPadd.close();
////                        //DISPLAY PRODUCT TEXTFIELD
////                        try {
////                            
//////                            Connection con18 = (Connection) db_Connection.getInstance();
////
////                            try {
////                                String t = "SELECT sum(quantity) FROM prodpriceinclusive WHERE voucher_no= '" + twi + "';";
////
////                                PreparedStatement psc = db_Connection.getInstance().prepareStatement(t);
////                                rsPadd = psc.executeQuery(t);
////
////                                if (rsPadd.next()) {
////                                    Double kansal = rsPadd.getDouble(1);
////
////                                    jTextField45.setText(String.valueOf(kansal));
////                                }
////                                rsPadd.close();
////                                psc.close();
////                                con3.commit();
////                            } catch (Exception e) {
//////                            e.printStackTrace();
////                                JOptionPane.showMessageDialog(null, "Cannot save." + e);
////                            }
////                        } catch (Exception ex) {
////                            Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
////                        }
////ps1.close();
////                    } catch (Exception e) {
////                    e.printStackTrace();
////                        JOptionPane.showMessageDialog(null, "Error in connectivity");
////                    }
////
////                } catch (Exception e) {
////                    JOptionPane.showMessageDialog(null, "Invalid Entry or field must be completely filled", "message", 2);
////                }
////
////               ps.close();  //HAPA
////            } catch (Exception e) {
//////            e.printStackTrace();
////                JOptionPane.showMessageDialog(null, e.getMessage());
////            }
//        }
        // TODO add your handling code here:
//    }
}
