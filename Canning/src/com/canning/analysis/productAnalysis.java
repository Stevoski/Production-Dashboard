/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.canning.analysis;

import java.awt.HeadlessException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import newpackage1.NewJFrame;
import newpackage1.db_Connection;
import static newpackage1.NewJFrame.jComboBox18;
import static newpackage1.NewJFrame.jComboBox19;
import static newpackage1.NewJFrame.jDate1st;
import static newpackage1.NewJFrame.jDate2nd;
import static newpackage1.NewJFrame.tabledisp;
import static newpackage1.NewJFrame.jTable4;
import static newpackage1.NewJFrame.jRadioButton4;
import static newpackage1.NewJFrame.jRadioButton5;

/**
 *
 * @author Stevoski
 */
public class productAnalysis {

    public static void loadItems() throws HeadlessException {
        ResultSet rlys;
        ResultSet rsfields;
        String cat = (String) jComboBox18.getSelectedItem();
        String name = (String) jComboBox19.getSelectedItem();
        String date1 = ((JTextField) jDate1st.getDateEditor().getUiComponent()).getText();
        String date2 = ((JTextField) jDate2nd.getDateEditor().getUiComponent()).getText();
        if (jRadioButton5.isSelected() == true) {
            switch (cat) {
            case "Product":

                getProductcons(name);

                break;

            case "Raw Material":

                getRawmaterial(name, date1, date2);

                break;
            //COMBO SELECTED=PACKAGE
            case "Package":

                getPackage(name, date1, date2);

                break;
        }
    
    }else if (jRadioButton4.isSelected() == true) {
        switch (cat) {
            case "Product":

                getProduct(name, date1, date2);

                break;

            case "Raw Material":

                getRawmaterial(name, date1, date2);

                break;
            //COMBO SELECTED=PACKAGE
            case "Package":

                getPackage(name, date1, date2);

                break;
        }
    }else{
        JOptionPane.showMessageDialog(null, "Error parsing fields!!");
    }
    }
   private static void getProduct(String name, String date1, String date2) throws HeadlessException {
        ResultSet rlys;
        String sqltraw = "SELECT product, sum(quantity) as qty, date, action FROM productanalysis \n"
                + " where product=? and date between ? and ?"
                + "group by action,product;";
        try (PreparedStatement traw = (PreparedStatement) db_Connection.getInstance().prepareStatement(sqltraw)) {
            traw.setString(1, name);
            traw.setString(2, date1);
            traw.setString(3, date2);

            try {
                DefaultTableModel modrop1 = (DefaultTableModel) jTable4.getModel();
                try {
                    int cofd = modrop1.getRowCount();
                    for (int mcod = 0; mcod <= cofd; mcod++) {
                        modrop1.removeRow(0);
                    }
                } catch (Exception e) {
//java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, e);
                }
                rlys = traw.executeQuery();
                while (rlys.next()) {
                    modrop1.addRow(new Object[]{rlys.getString("action"), rlys.getDouble("qty")});
                }

                String sqlprod = "Select * from productanalysis where product=? and date between ? and ?";
//
                try (PreparedStatement prod = (PreparedStatement) db_Connection.getInstance().prepareStatement(sqlprod)) {
                    prod.setString(1, name);
                    prod.setString(2, date1);
                    prod.setString(3, date2);

                    try {
                        DefaultTableModel modrop = (DefaultTableModel) tabledisp.getModel();
                        try {
                            int cofd = modrop.getRowCount();
                            for (int mcod = 0; mcod <= cofd; mcod++) {
                                modrop.removeRow(0);
                            }
                        } catch (Exception e) {
//java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, e);
                        }
                        rlys = prod.executeQuery();
                        while (rlys.next()) {
                            modrop.addRow(new Object[]{rlys.getString("date"), rlys.getString("product"), rlys.getString("batch_no"), rlys.getDouble("quantity"), rlys.getString("action")});
                        }
                    } catch (Exception e) {
                        java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, e);
                    }
                } catch (Exception e) {
                    java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, e);
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error parsing fields!!");
                java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, e);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error parsing fields!!");
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, e);
        }
    }
     private static void getProductcons(String name) throws HeadlessException {
        ResultSet rlys;
        String sqltraw = "SELECT product, sum(quantity) as qty, date, action FROM productanalysis \n"
                + " where product=? "
                + "group by action,product;";
        try (PreparedStatement traw = (PreparedStatement) db_Connection.getInstance().prepareStatement(sqltraw)) {
            traw.setString(1, name);
//            traw.setString(2, date1);
//            traw.setString(3, date2);

            try {
                DefaultTableModel modrop1 = (DefaultTableModel) jTable4.getModel();
                try {
                    int cofd = modrop1.getRowCount();
                    for (int mcod = 0; mcod <= cofd; mcod++) {
                        modrop1.removeRow(0);
                    }
                } catch (Exception e) {
//java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, e);
                }
                rlys = traw.executeQuery();
                while (rlys.next()) {
                    modrop1.addRow(new Object[]{rlys.getString("action"), rlys.getDouble("qty")});
                }

                String sqlprod = "Select * from productanalysis where product=? ";
//
                try (PreparedStatement prod = (PreparedStatement) db_Connection.getInstance().prepareStatement(sqlprod)) {
                    prod.setString(1, name);
//                    prod.setString(2, date1);
//                    prod.setString(3, date2);

                    try {
                        DefaultTableModel modrop = (DefaultTableModel) tabledisp.getModel();
                        try {
                            int cofd = modrop.getRowCount();
                            for (int mcod = 0; mcod <= cofd; mcod++) {
                                modrop.removeRow(0);
                            }
                        } catch (Exception e) {
//java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, e);
                        }
                        rlys = prod.executeQuery();
                        while (rlys.next()) {
                            modrop.addRow(new Object[]{rlys.getString("date"), rlys.getString("product"), rlys.getString("batch_no"), rlys.getDouble("quantity"), rlys.getString("action")});
                        }
                    } catch (Exception e) {
                        java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, e);
                    }
                } catch (Exception e) {
                    java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, e);
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error parsing fields!!");
                java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, e);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error parsing fields!!");
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, e);
        }
    }

    private static void getRawmaterial(String name, String date1, String date2) throws HeadlessException {
        ResultSet rlys;
        String sqltrawe = "SELECT Raw_material, sum(qty) as qty, date, transfertype FROM canning.raw_material_analysis \n"
                + " where raw_material=? and date between ? and ?"
                + "group by transfertype,Raw_material;";
        try (PreparedStatement traw = (PreparedStatement) db_Connection.getInstance().prepareStatement(sqltrawe)) {
            traw.setString(1, name);
            traw.setString(2, date1);
            traw.setString(3, date2);

            try {
                DefaultTableModel modeurat = (DefaultTableModel) jTable4.getModel();
                try {
                    int comd = modeurat.getRowCount();
                    for (int mcod = 0; mcod <= comd; mcod++) {
                        modeurat.removeRow(0);
                    }
                } catch (Exception e) {
//java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, e);
                }
                rlys = traw.executeQuery();
                while (rlys.next()) {
                    modeurat.addRow(new Object[]{rlys.getString("transfertype"), rlys.getDouble("qty")});
                }
                String sqlraw = "Select * from raw_material_analysis where raw_material=? and date between ? and ?";
                try (PreparedStatement praw = (PreparedStatement) db_Connection.getInstance().prepareStatement(sqlraw)) {
                    praw.setString(1, name);
                    praw.setString(2, date1);
                    praw.setString(3, date2);

                    try {
                        DefaultTableModel modeura = (DefaultTableModel) tabledisp.getModel();
                        try {
                            int comd = modeura.getRowCount();
                            for (int mcod = 0; mcod <= comd; mcod++) {
                                modeura.removeRow(0);
                            }
                        } catch (Exception e) {
//java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, e);
                        }
                        rlys = praw.executeQuery();
                        while (rlys.next()) {
                            modeura.addRow(new Object[]{rlys.getString("date"), rlys.getString("Raw_material"), rlys.getString("cons_no"), rlys.getDouble("qty"), rlys.getString("transfertype")});
                        }

                    } catch (Exception e) {
                        java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, e);
                    }
                } catch (Exception e) {
                    java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, e);
                }
            } catch (Exception e) {
                java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, e);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error parsing fields!!");
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, e);
        }
    }

    private static void getPackage(String name, String date1, String date2) throws HeadlessException {
        ResultSet rlys;
        String sqlpack = "Select * from package_analysis where package= ? and date between ? and ?";
        try (PreparedStatement praw = (PreparedStatement) db_Connection.getInstance().prepareStatement(sqlpack)) {
            praw.setString(1, name);
            praw.setString(2, date1);
            praw.setString(3, date2);

            try {
                DefaultTableModel modeura = (DefaultTableModel) tabledisp.getModel();
                try {
                    int comd = modeura.getRowCount();
                    for (int mcod = 0; mcod <= comd; mcod++) {
                        modeura.removeRow(0);
                    }
                } catch (Exception e) {
//java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, e);
                }
                rlys = praw.executeQuery();
                while (rlys.next()) {
                    modeura.addRow(new Object[]{rlys.getString("date"), rlys.getString("package"), rlys.getString("cons_no"), rlys.getDouble("package_qty"), rlys.getString("activity")});
                }
                String sqlpacksum = "SELECT package,sum(package_qty) as qty, date, activity FROM package_analysis \n"
                        + " where package=? and date between ? and ?"
                        + "group by activity,package;";
                try (PreparedStatement tpack = (PreparedStatement) db_Connection.getInstance().prepareStatement(sqlpacksum)) {
                    tpack.setString(1, name);
                    tpack.setString(2, date1);
                    tpack.setString(3, date2);

                    try {
                        DefaultTableModel modeurat = (DefaultTableModel) jTable4.getModel();
                        try {
                            int comd = modeurat.getRowCount();
                            for (int mcod = 0; mcod <= comd; mcod++) {
                                modeurat.removeRow(0);
                            }
                        } catch (Exception e) {
//java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, e);
                        }
                        rlys = tpack.executeQuery();
                        while (rlys.next()) {
                            modeurat.addRow(new Object[]{rlys.getString("activity"), rlys.getDouble("qty")});
                        }
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Error parsing fields!!");
                        java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, e);
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Error parsing fields!!");
                    java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, e);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error parsing fields!!");
                java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, e);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error parsing fields!!");
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, e);
        }
    }
}


