/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.canning.production;
import java.sql.ResultSet;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import static newpackage1.NewJFrame.jButton92;
import static newpackage1.NewJFrame.jButton93;
import static newpackage1.NewJFrame.jButton95;
import static newpackage1.NewJFrame.jComboBox27;
import static newpackage1.NewJFrame.jCombotoe;
import static newpackage1.NewJFrame.jComboBox48;
import static newpackage1.NewJFrame.jLabel242;
import static newpackage1.NewJFrame.jLabel243;
import static newpackage1.NewJFrame.jLabel244;
import static newpackage1.NewJFrame.jTextLogin;
import static newpackage1.NewJFrame.jTextUser;
import static newpackage1.NewJFrame.jTextid;
import static newpackage1.NewJFrame.jTextcomm;
import static newpackage1.NewJFrame.jTextFieldid;
import static newpackage1.NewJFrame.jTexty;
import static newpackage1.NewJFrame.jtransDate;
import static newpackage1.NewJFrame.jTable42;
import static newpackage1.NewJFrame.jTextprod;
import newpackage1.db_Connection;
/**
 *
 * @author Stevoski
 */
public class addTransfer {
    public static void Producttransferinsert() throws HeadlessException {
        ResultSet rs;
//     Adds data to product transfer table
        try {
            String ostoe = (String) jComboBox27.getSelectedItem();
            String stoe = (String) jCombotoe.getSelectedItem();//stype
            String qty = jTexty.getText();
            Double tqty = Double.valueOf(qty);
            String tid = jTextid.getText();
            Integer ttid = Integer.valueOf(tid);
            String tprod = jTextprod.getText();
            String comm = jTextcomm.getText();
//            Double tprod = Double.valueOf(prod);
            String aidi = jTextFieldid.getText();
            Integer taidi = Integer.valueOf(aidi);
            String Factrans = jTextLogin.getText();
            String utrans = jTextUser.getText();
            Connection con3 = (Connection) db_Connection.getInstance();
                con3.setAutoCommit(false);
            try (PreparedStatement saps = con3.prepareStatement("INSERT INTO product_transfer(`date`,productionid,product,quantity,`from`,`to`,addedby,comments,mainid,factorof)"
                    + "values(?,?,?,?,?,?,?,?,?,?)")) {
                saps.setString(1, ((JTextField) jtransDate.getDateEditor().getUiComponent()).getText());
                saps.setInt(2, ttid);
                saps.setString(3, tprod);
                saps.setDouble(4, tqty);
                saps.setString(5, Factrans);
                saps.setString(6, stoe);
                saps.setString(7, utrans);
                saps.setString(8, comm);
                saps.setInt(9, taidi);
                saps.setString(10, ostoe);
                saps.executeUpdate();
                try {
                    DefaultTableModel motrel = (DefaultTableModel) jTable42.getModel();
                    try {
                        int z3 = motrel.getRowCount();
                        for (int lu3 = 0; lu3 <= z3; ++lu3) {
                            motrel.removeRow(0);
                        }
                    } catch (Exception e) {
                    }
                    try {
                        PreparedStatement ps7 = db_Connection.getInstance().prepareStatement("SELECT * FROM product_transfer where date = ? and `from` =? and mainid = ?");
                        ps7.setString(1, ((JTextField) jtransDate.getDateEditor().getUiComponent()).getText());
                        ps7.setString(2, Factrans);
                        ps7.setInt(3, taidi);
                        rs = ps7.executeQuery();
                        while (rs.next()) {
                            motrel.addRow(new Object[]{rs.getInt("mainid"), rs.getString("date"), rs.getDouble("productionid"), rs.getString("product"), rs.getDouble("quantity"), rs.getString("to")});
                        }
                        jComboBox48.setEnabled(true);
                        jTexty.setEnabled(true);
                        jTextid.setEnabled(true);
                        jButton92.setEnabled(true);
                        jButton95.setEnabled(true);
                        jButton93.setEnabled(true);
                        jTable42.setEnabled(true);
                        jLabel244.setEnabled(true);
                        jLabel242.setEnabled(true);
                        jLabel243.setEnabled(true);
                        jCombotoe.setEnabled(true);
                        jtransDate.setEnabled(true);
                        jTextFieldid.setEnabled(true);
                        jTextcomm.setEnabled(true);
                    } catch (Exception e) {
                    e.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Invalid Entry");
                    }
                } catch (Exception e) {
                e.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Invalid Entry");
                }
                con3.commit();            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Invalid Entry");
        }
        // TODO add your handling code here:
    }

}
