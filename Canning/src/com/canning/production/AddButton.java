/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.canning.production;

import java.sql.Connection;
import java.awt.HeadlessException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import newpackage1.LoginForm;
import static newpackage1.NewJFrame.jComboBox3;
import static newpackage1.NewJFrame.jDate1;
//import static newpackage1.NewJFrame.jTextArea1;
import static newpackage1.NewJFrame.jTextField10;
import static newpackage1.NewJFrame.jTextField11;
import static newpackage1.NewJFrame.jTextField3;
import static newpackage1.NewJFrame.jTextField98;
import static newpackage1.NewJFrame.jTextField94;
import static newpackage1.NewJFrame.jTextField118;
import static newpackage1.NewJFrame.jTextLogin;
import static newpackage1.NewJFrame.enddate;
import static newpackage1.ExportAndImport.pvoucher;
import static newpackage1.ExportAndImport.vdate;
import static newpackage1.ExportAndImport.pelec;
import static newpackage1.ExportAndImport.pfire;
import static newpackage1.ExportAndImport.pbriq;
import static newpackage1.ExportAndImport.pwater;
import static newpackage1.ExportAndImport.pdies;
import newpackage1.NewJFrame;
import newpackage1.db_Connection;

/**
 *
 * @author Stevoski
 */
public class AddButton {
    public static void Productionadd() throws HeadlessException {
        if ("ADMINISTRATOR".equals(jTextLogin.getText())) {
            try {
                Connection con3 = (Connection) db_Connection.getInstance();
                con3.setAutoCommit(false);
                Integer numero = 0;
                try {
                    String kc = (String) jComboBox3.getSelectedItem(); //factory
                    String kg = jTextField10.getText(); //fuel
                    Double ks = Double.valueOf(kg);
                    String kbg = jTextField98.getText(); //Briq
                    Double kbs = Double.valueOf(kbg);
                    String ke = jTextField11.getText(); //electricity
                    Double kt = Double.valueOf(ke);
                    String kds = jTextField118.getText();
                    Double ksdt = Double.valueOf(kds);
                    String htt = NewJFrame.jTextField94.getText(); //water
                    Double tth = Double.valueOf(htt);
//                    String k1 = jTextArea1.getText(); //Remarks
//                String query1 = "insert into production (date,fuel,electricity,factory,remarks,briq)"
//                        + "values (?,?,?,?,?,?)";
                    PreparedStatement pst = con3.prepareStatement("insert into production (date,fuel,electricity,factory,briq,diesel,water,end_date)values (?,?,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
                    pst.setString(1, ((JTextField) jDate1.getDateEditor().getUiComponent()).getText());
                    pst.setDouble(2, ks);
                    pst.setDouble(3, kt);
                    pst.setString(4, kc);
//                    pst.setString(5, k1);
                    pst.setDouble(5, kbs);
                    pst.setDouble(6, ksdt);
                     pst.setDouble(7, tth);
                      pst.setString(8, ((JTextField) enddate.getDateEditor().getUiComponent()).getText());
                    numero = pst.executeUpdate();

                    ResultSet ares = pst.getGeneratedKeys();
                    
                    if (ares.next()) {
//                jTextField3.setText(ares.getInt(1).);
                        jTextField3.setText(String.valueOf(ares.getInt(1)));
                    }
                    con3.commit();
                    pst.close();
                    JOptionPane.showMessageDialog(null, "record has been inserted");
////
                } catch (Exception e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Cannot save." + e);
                }

            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Invalid in fields");
            }
        } else {
            try {

                Connection con3 = (Connection) db_Connection.getInstance();
                con3.setAutoCommit(false);
                Integer numero = 0;
                try {

                    String kc = jTextLogin.getText(); //factory
                    String kg = jTextField10.getText(); //fuel

                    Double ks = Double.valueOf(kg);
                    String kbg = jTextField98.getText(); //Briq
                    Double kbs = Double.valueOf(kbg);
                    String ke = jTextField11.getText(); //electricity
                    Double kt = Double.valueOf(ke);
                    String kds = jTextField118.getText();
                    Double ksdt = Double.valueOf(kds);
//                    String k1 = jTextArea1.getText(); //Remarks
    String htt = NewJFrame.jTextField94.getText(); //water
                    Double tth = Double.valueOf(htt);
            PreparedStatement pst = con3.prepareStatement("insert into production (date,fuel,electricity,factory,briq,diesel,water,end_date)values (?,?,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);

                    pst.setString(1, ((JTextField) jDate1.getDateEditor().getUiComponent()).getText());
                    pst.setDouble(2, ks);
                    pst.setDouble(3, kt);
                    pst.setString(4, kc);
//                    pst.setString(5, k1);
                    pst.setDouble(5, kbs);
                    pst.setDouble(6, ksdt);
                        pst.setDouble(7, tth);
                        pst.setString(8, ((JTextField) enddate.getDateEditor().getUiComponent()).getText());
                    numero = pst.executeUpdate();

                    ResultSet ares = pst.getGeneratedKeys();
                    if (ares.next()) {
//                jTextField3.setText(ares.getInt(1).);
                        jTextField3.setText(String.valueOf(ares.getInt(1)));
                    }
                    con3.commit();
                     pst.close();
                    JOptionPane.showMessageDialog(null, "record has been inserted");
////
                } catch (Exception e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Cannot save." + e);
                }

            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Invalid in fields");
            }
        }

    }
      public static void NewProductionadd() throws HeadlessException {
        if ("ADMINISTRATOR".equals(jTextLogin.getText())) {
            try {

                Connection con3 = (Connection) db_Connection.getInstance();
                con3.setAutoCommit(false);
                Integer numero = 0;
                try {

                    String kc = (String) jComboBox3.getSelectedItem(); //factory
                    String kg = pfire.getText(); //fuel

                    Double ks = Double.valueOf(kg);
                    String kbg = pbriq.getText(); //Briq
                    Double kbs = Double.valueOf(kbg);
                    String ke = pelec.getText(); //electricity
                    Double kt = Double.valueOf(ke);
                    String kds = pdies.getText();//diesel
                    Double ksdt = Double.valueOf(kds);
//                    String k1 = jTextArea1.getText(); //Remarks

//                String query1 = "insert into production (date,fuel,electricity,factory,remarks,briq)"
//                        + "values (?,?,?,?,?,?)";
                    PreparedStatement pst = con3.prepareStatement("insert into production (date,fuel,electricity,factory,briq,diesel,end_date)values (?,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);

                    pst.setString(1, ((JTextField) vdate.getDateEditor().getUiComponent()).getText());
                    pst.setDouble(2, ks);
                    pst.setDouble(3, kt);
                    pst.setString(4, kc);
//                    pst.setString(5, k1);
                    pst.setDouble(5, kbs);
                    pst.setDouble(6, ksdt);
                    pst.setString(7, ((JTextField) enddate.getDateEditor().getUiComponent()).getText());
                    numero = pst.executeUpdate();

                    ResultSet ares = pst.getGeneratedKeys();
                    
                    if (ares.next()) {
//                jTextField3.setText(ares.getInt(1).);
                        pvoucher.setText(String.valueOf(ares.getInt(1)));
                    }
                    con3.commit();
                    pst.close();
                    JOptionPane.showMessageDialog(null, "record has been inserted");
////
                } catch (Exception e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Cannot save." + e);
                }

            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Invalid in fields");
            }
        } else {
            try {

                Connection con3 = (Connection) db_Connection.getInstance();
                con3.setAutoCommit(false);
                Integer numero = 0;
                try {

                    String kc = jTextLogin.getText(); //factory
                    String kg = pfire.getText(); //fuel

                    Double ks = Double.valueOf(kg);
                    String kbg = pbriq.getText(); //Briq
                    Double kbs = Double.valueOf(kbg);
                    String ke = pelec.getText(); //electricity
                    Double kt = Double.valueOf(ke);
                    String kds = pdies.getText();//diesel
                    Double ksdt = Double.valueOf(kds);
//                    String k1 = jTextArea1.getText(); //Remarks

//            
                    PreparedStatement pst = con3.prepareStatement("insert into production (date,fuel,electricity,factory,briq,diesel,end_date)values (?,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
                    pst.setString(1, ((JTextField) vdate.getDateEditor().getUiComponent()).getText());
                    pst.setDouble(2, ks);
                    pst.setDouble(3, kt);
                    pst.setString(4, kc);
//                    pst.setString(5, k1);
                    pst.setDouble(5, kbs);
                    pst.setDouble(6, ksdt);
                    pst.setString(7, ((JTextField) enddate.getDateEditor().getUiComponent()).getText());
                    numero = pst.executeUpdate();
                    ResultSet ares = pst.getGeneratedKeys();
                    if (ares.next()) {
//                jTextField3.setText(ares.getInt(1).);
                        pvoucher.setText(String.valueOf(ares.getInt(1)));
                    }
                    con3.commit();
                     pst.close();
                    JOptionPane.showMessageDialog(null, "record has been inserted");
                } catch (Exception e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Cannot save." + e);
                }
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Invalid in fields");
            }
        }

    }
}
