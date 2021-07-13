/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.canning.proreport;

import java.awt.HeadlessException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import newpackage1.NewJFrame;
import static newpackage1.NewJFrame.jDate2;
import static newpackage1.NewJFrame.jDateChooser2;
import static newpackage1.NewJFrame.jDateChooser3;
import static newpackage1.NewJFrame.jRadioButton13;
import static newpackage1.NewJFrame.jRadioButton20;
import static newpackage1.NewJFrame.jRadioButton8;
import static newpackage1.NewJFrame.jRadioButton9;
import static newpackage1.NewJFrame.jTextField138;
import static newpackage1.NewJFrame.jTextField40;
import static newpackage1.NewJFrame.jTextField41;
import static newpackage1.NewJFrame.jTextField42;
import static newpackage1.NewJFrame.jTextArea2;
import static newpackage1.NewJFrame.jTable7;
import static newpackage1.NewJFrame.jTable6;
import static newpackage1.NewJFrame.jTable5;
import static newpackage1.NewJFrame.jTable8;
import static newpackage1.NewJFrame.jTextField9;
import static newpackage1.NewJFrame.jTextLogin;
import newpackage1.db_Connection;
//else if (jTextLogin.getText().equals("F1") || jTextLogin.getText(.equals("F2") || jTextLogin.getText().equals("F3")  || jTextLogin.getText().equals("F4") || jTextLogin.getText().equals("F5")  || jTextLogin.getText().equals("F6") 
//                || jTextLogin.getText().equals("F7")  || jTextLogin.getText().equals("F8")  || jTextLogin.getText().equals("Whipcream") {

/**
 *
 * @author Stevoski
 */
public class prorptShow {

    public static void panel8Show() throws HeadlessException {

        ResultSet rsProshow;

        String dated = ((JTextField) jDate2.getDateEditor().getUiComponent()).getText();
        String dated1 = ((JTextField) jDateChooser2.getDateEditor().getUiComponent()).getText();
        String dated2 = ((JTextField) jDateChooser3.getDateEditor().getUiComponent()).getText();

        String no2;
        String remarks;

        if (jTextLogin.getText().equals("ADMINISTRATOR")) {

            try {

                if (jRadioButton8.isSelected() == true) {
                    voucherReport();

                } //DATE RADIO BTN
                else if (jRadioButton9.isSelected() == true) {

                    try {

//                        Connection con148 = (Connection) db_Connection.getInstance();
                        try {
                            String t = "SELECT * FROM production where date= '" + dated + "';";
                            PreparedStatement ps = db_Connection.getInstance().prepareStatement(t);
                            rsProshow = ps.executeQuery(t);

                            if (rsProshow.next()) {

                                remarks = rsProshow.getString("remarks");
                                no2 = remarks;
                                jTextArea2.setText(String.valueOf(no2));
                            }

                            //PRODUCTS TEXTFIELD,AMOUNT
                            try {
                                String tia = "SELECT sum(quantity) FROM prodpriceinclusive WHERE date= '" + dated + "';";

                                PreparedStatement ps123 = db_Connection.getInstance().prepareStatement(t);
                                rsProshow = ps123.executeQuery(tia);

                                if (rsProshow.next()) {
                                    Double xansal = rsProshow.getDouble(1);

                                    jTextField40.setText(String.valueOf(xansal));
                                }

                                //DISPLAY RAW TEXTFIELD
                                try {

//                                    Connection con149 = (Connection) db_Connection.getInstance();
                                    try {
                                        String ti = "SELECT sum(qty) FROM rawmatpriceinc WHERE date= '" + dated + "';";

                                        PreparedStatement psc = db_Connection.getInstance().prepareStatement(t);
                                        rsProshow = psc.executeQuery(ti);

                                        if (rsProshow.next()) {
                                            Double kansal = rsProshow.getDouble(1);

                                            jTextField41.setText(String.valueOf(kansal));
                                        }
                                        psc.close();
                                    } catch (Exception e) {
//                                e.printStackTrace();
                                        JOptionPane.showMessageDialog(null, "Cannot save." + e);
                                    }

                                } catch (Exception ex) {
                                    Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
                                }

                                //DISPLAY INGRED TEXTFIELD
                                try {

//                                    Connection con150 = (Connection) db_Connection.getInstance();
                                    try {
                                        String tou = "SELECT sum(ingredient_qty) FROM ingredpriceinc WHERE date= '" + dated + "';";

                                        PreparedStatement psc1 = db_Connection.getInstance().prepareStatement(t);
                                        rsProshow = psc1.executeQuery(tou);

                                        if (rsProshow.next()) {
                                            Double kansal = rsProshow.getDouble(1);

                                            jTextField42.setText(String.valueOf(kansal));
                                        }
                                        psc1.close();
                                    } catch (Exception e) {
//                                e.printStackTrace();
                                        JOptionPane.showMessageDialog(null, "Cannot save." + e);
                                    }

                                } catch (Exception ex) {
                                    Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                ps123.close();
                            } catch (Exception e) {
//                        e.printStackTrace();
                                JOptionPane.showMessageDialog(null, "Cannot save." + e);
                            }
                            ps.close();
                        } catch (Exception e) {
//                    e.printStackTrace();
                            JOptionPane.showMessageDialog(null, "Cannot save." + e);
                        }

                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Invalid Entry or field must be completely filled", "message", 2);
                    }

                    try {
                        DefaultTableModel model = (DefaultTableModel) jTable7.getModel();
//            int mg3 = Integer.parseInt(jTextField9.getText());

                        try {
                            int z3 = model.getRowCount();
                            for (int lu3 = 0; lu3 <= z3; ++lu3) {
                                model.removeRow(0);
                            }
                        } catch (Exception e) {
                        }
                        try {

//                            Connection con153 = (Connection) db_Connection.getInstance();
                            Statement stmt4 = db_Connection.getInstance().createStatement();
                            String query4 = "SELECT * FROM ingredientsprodn where date = '" + dated + "' ;";
                            rsProshow = stmt4.executeQuery(query4);

                            while (rsProshow.next()) {
                                model.addRow(new Object[]{rsProshow.getString("ingredient_name"), rsProshow.getString("ingredient_qty")});
                            }

                            rsProshow.close();
                            stmt4.close();

                        } catch (Exception e) {
//                    e.printStackTrace();
                            JOptionPane.showMessageDialog(null, "Error in connectivity");
                        }
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Invalid Entry or field must be completely filled", "message", 2);
                    }

                    try {
                        DefaultTableModel model = (DefaultTableModel) jTable6.getModel();
//            int mg2 = Integer.parseInt(jTextField9.getText());

                        try {
                            int z2 = model.getRowCount();
                            for (int lu2 = 0; lu2 <= z2; ++lu2) {
                                model.removeRow(0);
                            }
                        } catch (Exception e) {
                        }
                        try {

//                            Connection con154 = (Connection) db_Connection.getInstance();
                            Statement stmt4 = db_Connection.getInstance().createStatement();
                            String query4 = "SELECT * FROM rawmatprodn where date = '" + dated + "';";
                            rsProshow = stmt4.executeQuery(query4);

                            while (rsProshow.next()) {
                                model.addRow(new Object[]{rsProshow.getString("raw_material"), rsProshow.getString("qty")});
                            }

                            rsProshow.close();
                            stmt4.close();

                        } catch (Exception e) {
//                    e.printStackTrace();
                            JOptionPane.showMessageDialog(null, "Error in connectivity");
                        }
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Invalid Entry or field must be completely filled", "message", 2);
                    }

                    try {
                        DefaultTableModel model = (DefaultTableModel) jTable5.getModel();
//            int mg1 = Integer.parseInt(jTextField9.getText());

                        try {
                            int z1 = model.getRowCount();
                            for (int lu1 = 0; lu1 <= z1; ++lu1) {
                                model.removeRow(0);
                            }
                        } catch (Exception e) {
                        }
                        try {

//                            Connection con165 = (Connection) db_Connection.getInstance();
                            Statement stmt4 = db_Connection.getInstance().createStatement();
                            String query4 = "SELECT * FROM productproduction1 where date = '" + dated + "';";
                            rsProshow = stmt4.executeQuery(query4);

                            while (rsProshow.next()) {
                                model.addRow(new Object[]{rsProshow.getString("ProductionID"), rsProshow.getString("product_name"), rsProshow.getString("quantity"), rsProshow.getString("waste")});
                            }

                            rsProshow.close();
                            stmt4.close();

                        } catch (Exception e) {
//                    e.printStackTrace();
                            JOptionPane.showMessageDialog(null, "Error in connectivity");
                        }
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Invalid Entry or field must be completely filled", "message", 2);
                    }

                    try {
                        DefaultTableModel model = (DefaultTableModel) jTable8.getModel();
//            int mg = Integer.parseInt(jTextField9.getText());

                        try {
                            int zz = model.getRowCount();
                            for (int lu = 0; lu <= zz; ++lu) {
                                model.removeRow(0);
                            }
                        } catch (Exception e) {
                        }
                        try {

//                            Connection con155 = (Connection) db_Connection.getInstance();
                            Statement stmt4 = db_Connection.getInstance().createStatement();
                            String query4 = "SELECT * FROM costingprodn where date = '" + dated + "';";
                            rsProshow = stmt4.executeQuery(query4);

                            while (rsProshow.next()) {
                                model.addRow(new Object[]{rsProshow.getString("voucher_no"), rsProshow.getInt("production_id"), rsProshow.getString("date"), rsProshow.getString("factory"), rsProshow.getString("fuel"), rsProshow.getString("briquette"), rsProshow.getString("manpower"), rsProshow.getString("electricity"), rsProshow.getString("can_name"), rsProshow.getString("no_of_cans"), rsProshow.getString("label_name"), rsProshow.getString("no_of_labels")});
                            }

                            rsProshow.close();
                            stmt4.close();

                        } catch (Exception e) {
//                    e.printStackTrace();
                            JOptionPane.showMessageDialog(null, "Error in connectivity");
                        }

                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Invalid Entry or field must be completely filled", "message", 2);
                    }

                } else if (jRadioButton13.isSelected() == true) {

                    try {

//                        Connection con148 = (Connection) db_Connection.getInstance();
                        try {
                            String t = "SELECT * FROM production where date>= '" + dated1 + "' and date <= '" + dated2 + "';";
                            PreparedStatement ps = db_Connection.getInstance().prepareStatement(t);
                            rsProshow = ps.executeQuery(t);

                            if (rsProshow.next()) {

                                remarks = rsProshow.getString("remarks");
                                no2 = remarks;
                                jTextArea2.setText(String.valueOf(no2));
                            }

                            //PRODUCTS TEXTFIELD,AMOUNT
                            try {
                                String tia = "SELECT sum(quantity) FROM prodpriceinclusive WHERE date>= '" + dated1 + "' and date <= '" + dated2 + "';";

                                PreparedStatement ps123 = db_Connection.getInstance().prepareStatement(t);
                                rsProshow = ps123.executeQuery(tia);

                                if (rsProshow.next()) {
                                    Double xansal = rsProshow.getDouble(1);

                                    jTextField40.setText(String.valueOf(xansal));
                                }

                                //DISPLAY RAW TEXTFIELD
                                try {

//                                    Connection con149 = (Connection) db_Connection.getInstance();
                                    try {
                                        String ti = "SELECT sum(qty) FROM rawmatpriceinc WHERE date>= '" + dated1 + "' and date <= '" + dated2 + "';";

                                        PreparedStatement psc = db_Connection.getInstance().prepareStatement(t);
                                        rsProshow = psc.executeQuery(ti);

                                        if (rsProshow.next()) {
                                            Double kansal = rsProshow.getDouble(1);

                                            jTextField41.setText(String.valueOf(kansal));
                                        }
                                        psc.close();
                                    } catch (Exception e) {
//                                e.printStackTrace();
                                        JOptionPane.showMessageDialog(null, "Cannot save." + e);
                                    }

                                } catch (Exception ex) {
                                    Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
                                }

                                //DISPLAY INGRED TEXTFIELD
                                try {

//                                    Connection con150 = (Connection) db_Connection.getInstance();
                                    try {
                                        String tou = "SELECT sum(ingredient_qty) FROM ingredpriceinc WHERE date>= '" + dated1 + "' and date <= '" + dated2 + "' ;";

                                        PreparedStatement pesc = db_Connection.getInstance().prepareStatement(t);
                                        rsProshow = pesc.executeQuery(tou);

                                        if (rsProshow.next()) {
                                            Double kansal = rsProshow.getDouble(1);

                                            jTextField42.setText(String.valueOf(kansal));
                                        }
                                        pesc.close();
                                    } catch (Exception e) {
//                                e.printStackTrace();
                                        JOptionPane.showMessageDialog(null, "Cannot save." + e);
                                    }

                                } catch (Exception ex) {
                                    Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
                                }

                            } catch (Exception e) {
//                        e.printStackTrace();
                                JOptionPane.showMessageDialog(null, "Cannot save." + e);
                            }
                            ps.close();
                        } catch (Exception e) {
//                    e.printStackTrace();
                            JOptionPane.showMessageDialog(null, "Cannot save." + e);
                        }

                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Invalid Entry or field must be completely filled", "message", 2);
                    }

                    try {
                        DefaultTableModel model = (DefaultTableModel) jTable7.getModel();
//            int mg3 = Integer.parseInt(jTextField9.getText());

                        try {
                            int z3 = model.getRowCount();
                            for (int lu3 = 0; lu3 <= z3; ++lu3) {
                                model.removeRow(0);
                            }
                        } catch (Exception e) {
                        }
                        try {

//                            Connection con153 = (Connection) db_Connection.getInstance();
                            Statement stmt4 = db_Connection.getInstance().createStatement();
                            String query4 = "SELECT * FROM ingredientsprodn where date>= '" + dated1 + "' and date <= '" + dated2 + "';";
                            rsProshow = stmt4.executeQuery(query4);

                            while (rsProshow.next()) {
                                model.addRow(new Object[]{rsProshow.getString("ingredient_name"), rsProshow.getString("ingredient_qty")});
                            }

                            rsProshow.close();
                            stmt4.close();

                        } catch (Exception e) {
//                    e.printStackTrace();
                            JOptionPane.showMessageDialog(null, "Error in connectivity");
                        }
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Invalid Entry or field must be completely filled", "message", 2);
                    }

                    try {
                        DefaultTableModel model = (DefaultTableModel) jTable6.getModel();
//            int mg2 = Integer.parseInt(jTextField9.getText());

                        try {
                            int z2 = model.getRowCount();
                            for (int lu2 = 0; lu2 <= z2; ++lu2) {
                                model.removeRow(0);
                            }
                        } catch (Exception e) {
                        }
                        try {

//                            Connection con154 = (Connection) db_Connection.getInstance();
                            Statement stmt4 = db_Connection.getInstance().createStatement();
                            String query4 = "SELECT * FROM rawmatprodn where date>= '" + dated1 + "' and date <= '" + dated2 + "';";
                            rsProshow = stmt4.executeQuery(query4);

                            while (rsProshow.next()) {
                                model.addRow(new Object[]{rsProshow.getString("raw_material"), rsProshow.getString("qty")});
                            }

                            rsProshow.close();
                            stmt4.close();

                        } catch (Exception e) {
//                    e.printStackTrace();
                            JOptionPane.showMessageDialog(null, "Error in connectivity");
                        }
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Invalid Entry or field must be completely filled", "message", 2);
                    }

                    try {
                        DefaultTableModel model = (DefaultTableModel) jTable5.getModel();
//            int mg1 = Integer.parseInt(jTextField9.getText());

                        try {
                            int z1 = model.getRowCount();
                            for (int lu1 = 0; lu1 <= z1; ++lu1) {
                                model.removeRow(0);
                            }
                        } catch (Exception e) {
                        }
                        try {

//                            Connection con165 = (Connection) db_Connection.getInstance();
                            Statement stmt4 = db_Connection.getInstance().createStatement();
                            String query4 = "SELECT * FROM productproduction1 where date>= '" + dated1 + "' and date <= '" + dated2 + "';";
                            rsProshow = stmt4.executeQuery(query4);

                            while (rsProshow.next()) {
                                model.addRow(new Object[]{rsProshow.getString("ProductionID"), rsProshow.getString("product_name"), rsProshow.getString("quantity"), rsProshow.getString("waste")});
                            }

                            rsProshow.close();
                            stmt4.close();

                        } catch (Exception e) {
//                    e.printStackTrace();
                            JOptionPane.showMessageDialog(null, "Error in connectivity");
                        }
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Invalid Entry or field must be completely filled", "message", 2);
                    }

                    try {
                        DefaultTableModel model = (DefaultTableModel) jTable8.getModel();
//            int mg = Integer.parseInt(jTextField9.getText());

                        try {
                            int zz = model.getRowCount();
                            for (int lu = 0; lu <= zz; ++lu) {
                                model.removeRow(0);
                            }
                        } catch (Exception e) {
                        }
                        try {

//                            Connection con155 = (Connection) db_Connection.getInstance();
                            Statement stmt4 = db_Connection.getInstance().createStatement();
                            String query4 = "SELECT * FROM costingprodn where date>= '" + dated1 + "' and date <= '" + dated2 + "';";
                            rsProshow = stmt4.executeQuery(query4);

                            while (rsProshow.next()) {
                                model.addRow(new Object[]{rsProshow.getString("voucher_no"), rsProshow.getInt("production_id"), rsProshow.getString("date"), rsProshow.getString("factory"), rsProshow.getString("fuel"), rsProshow.getString("briquette"), rsProshow.getString("manpower"), rsProshow.getString("electricity"), rsProshow.getString("can_name"), rsProshow.getString("no_of_cans"), rsProshow.getString("label_name"), rsProshow.getString("no_of_labels")});
                            }

                            rsProshow.close();
                            stmt4.close();

                        } catch (Exception e) {
//                    e.printStackTrace();
                            JOptionPane.showMessageDialog(null, "Error in connectivity");
                        }

                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Invalid Entry or field must be completely filled", "message", 2);
                    }
                } else if (jRadioButton20.isSelected() == true) {
                    productidReport();

                } else {
                    JOptionPane.showMessageDialog(null, "Please choose an option!");
                }
            } catch (Exception e) {
//                                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Cannot save." + e);
            }

        } else if ("F1".equals(jTextLogin.getText()) || "F2".equals(jTextLogin.getText()) || "F3".equals(jTextLogin.getText()) || "F4".equals(jTextLogin.getText()) || "F5".equals(jTextLogin.getText()) || "F6".equals(jTextLogin.getText())
                || "F7".equals(jTextLogin.getText()) || "F8".equals(jTextLogin.getText()) || "quest".equals(jTextLogin.getText()) || "Whipcream".equals(jTextLogin.getText())) {
            String priv = jTextLogin.getText();
            try {

                if (jRadioButton8.isSelected() == true) {
                    String priv1 = jTextLogin.getText();
                    String vouchered = (String) jTextField9.getText();
                    Integer vouchers = Integer.valueOf(vouchered);
                    try {

//                        Connection con1v4 = (Connection) db_Connection.getInstance();
                        try {
                            String t = "SELECT * FROM production where voucher_no = '" + vouchers + "' and factory='" + priv + "';";
                            PreparedStatement ps = db_Connection.getInstance().prepareStatement(t);
                            rsProshow = ps.executeQuery(t);

                            if (rsProshow.next()) {

                                remarks = rsProshow.getString("remarks");
                                no2 = remarks;
                                jTextArea2.setText(String.valueOf(no2));
                            }

                            //PRODUCTS TEXTFIELD,AMOUNT
                            try {
                                String tia = "SELECT sum(quantity) FROM prodpriceinclusive WHERE voucher_no= '" + vouchers + "' and factory='" + priv + "';";

                                PreparedStatement ps123 = db_Connection.getInstance().prepareStatement(t);
                                rsProshow = ps123.executeQuery(tia);

                                if (rsProshow.next()) {
                                    Double xansal = rsProshow.getDouble(1);
                                    DecimalFormat pro1 = new DecimalFormat("0.0000");
                                    String formattedText = pro1.format(xansal);
                                    jTextField40.setText(String.valueOf(formattedText));
                                }

                                //DISPLAY RAW TEXTFIELD
                                try {

//                                    Connection con180 = (Connection) db_Connection.getInstance();
                                    try {
                                        String ti = "SELECT sum(qty) FROM rawmatpriceinc WHERE voucher_no= '" + vouchers + "' and factory='" + priv + "';";

                                        PreparedStatement psc = db_Connection.getInstance().prepareStatement(ti);
                                        rsProshow = psc.executeQuery(ti);

                                        if (rsProshow.next()) {
                                            Double kansal = rsProshow.getDouble(1);
                                            DecimalFormat pro2 = new DecimalFormat("0.0000");
                                            String formattedText1 = pro2.format(kansal);
                                            jTextField41.setText(String.valueOf(formattedText1));
                                        }
                                        psc.close();
                                    } catch (Exception e) {
//                                e.printStackTrace();
                                        JOptionPane.showMessageDialog(null, "Cannot save." + e);
                                    }

                                } catch (Exception ex) {
                                    Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
                                }

                                //DISPLAY INGRED TEXTFIELD
                                try {

//                                    Connection con270 = (Connection) db_Connection.getInstance();
                                    try {
                                        String tou = "SELECT sum(ingredient_qty) FROM ingredpriceinc WHERE voucher_no= '" + vouchers + "' and factory='" + priv + "';";

                                        PreparedStatement psyc = db_Connection.getInstance().prepareStatement(tou);
                                        rsProshow = psyc.executeQuery(tou);

                                        if (rsProshow.next()) {
                                            Double kansals = rsProshow.getDouble(1);
                                            DecimalFormat pro4 = new DecimalFormat("0.0000");
                                            String formattedText2 = pro4.format(kansals);
                                            jTextField42.setText(String.valueOf(formattedText2));
                                        }
                                        psyc.close();
                                    } catch (Exception e) {
//                                e.printStackTrace();
                                        JOptionPane.showMessageDialog(null, "Cannot save." + e);
                                    }

                                } catch (Exception ex) {
                                    Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                ps123.close();
                            } catch (Exception e) {
//                        e.printStackTrace();
                                JOptionPane.showMessageDialog(null, "Cannot save." + e);
                            }
                            ps.close();
                        } catch (Exception e) {
//                    e.printStackTrace();
                            JOptionPane.showMessageDialog(null, "Cannot save." + e);
                        }

                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Invalid Entry or field must be completely filled", "message", 2);
                    }

                    try {
                        DefaultTableModel model = (DefaultTableModel) jTable7.getModel();
                        int mg3 = Integer.parseInt(jTextField9.getText());

                        try {
                            int z3 = model.getRowCount();
                            for (int lu3 = 0; lu3 <= z3; ++lu3) {
                                model.removeRow(0);
                            }
                        } catch (Exception e) {
                        }
                        try {

//                            Connection con144 = (Connection) db_Connection.getInstance();                            Statement stmt4 = con144.createStatement();
                            String query4 = "SELECT * FROM ingredpriceinc where voucher_no = '" + mg3 + "' and factory='" + priv + "';";
                            PreparedStatement stmtrtp = db_Connection.getInstance().prepareStatement(query4);
                            rsProshow = stmtrtp.executeQuery();

                            while (rsProshow.next()) {
                                model.addRow(new Object[]{rsProshow.getString("ingredient_name"), rsProshow.getString("ingredient_qty")});
                            }
                            rsProshow.close();
                            stmtrtp.close();

                        } catch (Exception e) {
//                    e.printStackTrace();
                            JOptionPane.showMessageDialog(null, "Error in connectivity");
                        }
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Invalid Entry or field must be completely filled", "message", 2);
                    }

                    try {
                        DefaultTableModel model = (DefaultTableModel) jTable6.getModel();
                        int mg2 = Integer.parseInt(jTextField9.getText());

                        try {
                            int z2 = model.getRowCount();
                            for (int lu2 = 0; lu2 <= z2; ++lu2) {
                                model.removeRow(0);
                            }
                        } catch (Exception e) {
                        }
                        try {

//                            Connection con145 = (Connection) db_Connection.getInstance();       
                            Statement setmt4 = db_Connection.getInstance().createStatement();
                            String query4 = "SELECT * FROM rawmatpriceinc where voucher_no = '" + mg2 + "' and factory='" + priv + "';";
                            rsProshow = setmt4.executeQuery(query4);

                            while (rsProshow.next()) {
                                model.addRow(new Object[]{rsProshow.getString("raw_material"), rsProshow.getString("qty")});
                            }

                            rsProshow.close();
                            setmt4.close();

                        } catch (Exception e) {
//                    e.printStackTrace();
                            JOptionPane.showMessageDialog(null, "Error in connectivity");
                        }
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Invalid Entry or field must be completely filled", "message", 2);
                    }

                    try {
                        DefaultTableModel model = (DefaultTableModel) jTable5.getModel();
                        int mg1 = Integer.parseInt(jTextField9.getText());

                        try {
                            int z1 = model.getRowCount();
                            for (int lu1 = 0; lu1 <= z1; ++lu1) {
                                model.removeRow(0);
                            }
                        } catch (Exception e) {
                        }
                        try {

//                            Connection con146 = (Connection) db_Connection.getInstance();
                            Statement stmt4o = db_Connection.getInstance().createStatement();
                            String query4 = "SELECT * FROM productproduction where voucher_no = '" + mg1 + "' and factory='" + priv + "';";
                            rsProshow = stmt4o.executeQuery(query4);

                            while (rsProshow.next()) {
                                model.addRow(new Object[]{rsProshow.getString("ProductionID"), rsProshow.getString("product_name"), rsProshow.getString("quantity"), rsProshow.getString("waste")});
                            }

                            rsProshow.close();
                            stmt4o.close();

                        } catch (Exception e) {
//                    e.printStackTrace();
                            JOptionPane.showMessageDialog(null, "Error in connectivity");
                        }
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Invalid Entry or field must be completely filled", "message", 2);
                    }

                    try {
                        DefaultTableModel model = (DefaultTableModel) jTable8.getModel();
                        int mg = Integer.parseInt(jTextField9.getText());

                        try {
                            int zz = model.getRowCount();
                            for (int lu = 0; lu <= zz; ++lu) {
                                model.removeRow(0);
                            }
                        } catch (Exception e) {
                        }
                        try {

//                            Connection con147 = (Connection) db_Connection.getInstance();                            Statement stmt4 = con147.createStatement();
                            String query4 = "SELECT * FROM costingprodn where voucher_no = '" + mg + "' and factory='" + priv + "';";
                            try (PreparedStatement psses = db_Connection.getInstance().prepareStatement(query4)) {
                                rsProshow = psses.executeQuery(query4);

                                while (rsProshow.next()) {
                                    model.addRow(new Object[]{rsProshow.getString("voucher_no"), rsProshow.getInt("production_id"), rsProshow.getString("date"), rsProshow.getString("factory"), rsProshow.getString("fuel"), rsProshow.getString("briquette"), rsProshow.getString("manpower"), rsProshow.getString("electricity"), rsProshow.getString("can_name"), rsProshow.getString("no_of_cans"), rsProshow.getString("label_name"), rsProshow.getString("no_of_labels")});
                                }
                                psses.close();
                                rsProshow.close();
                            }

                        } catch (Exception e) {
//                    e.printStackTrace();
                            JOptionPane.showMessageDialog(null, "Error in connectivity");
                        }
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Invalid Entry or field must be completely filled", "message", 2);
                    }

                } //DATE RADIO BTN
                else if (jRadioButton9.isSelected() == true) {

                    try {
                        String priv1 = jTextLogin.getText();
//                        Connection con148 =(Connection) db_Connection.getInstance();
                        try {
                            String t = "SELECT * FROM production where date= '" + dated + "' and factory='" + priv + "';";
                            PreparedStatement ps = db_Connection.getInstance().prepareStatement(t);
                            rsProshow = ps.executeQuery(t);

                            if (rsProshow.next()) {

                                remarks = rsProshow.getString("remarks");
                                no2 = remarks;
                                jTextArea2.setText(String.valueOf(no2));
                            }

                            //PRODUCTS TEXTFIELD,AMOUNT
                            try {
                                String tia = "SELECT sum(quantity) FROM prodpriceinclusive WHERE date= '" + dated + "' and factory='" + priv + "';";

                                PreparedStatement ps123 = db_Connection.getInstance().prepareStatement(t);
                                rsProshow = ps123.executeQuery(tia);

                                if (rsProshow.next()) {
                                    Double xansal = rsProshow.getDouble(1);

                                    jTextField40.setText(String.valueOf(xansal));
                                }

                                //DISPLAY RAW TEXTFIELD
                                try {

//                                    Connection con149 = (Connection) db_Connection.getInstance();
                                    try {
                                        String ti = "SELECT sum(qty) FROM rawmatpriceinc WHERE date= '" + dated + "' and factory='" + priv + "';";

                                        PreparedStatement psc = db_Connection.getInstance().prepareStatement(t);
                                        rsProshow = psc.executeQuery(ti);

                                        if (rsProshow.next()) {
                                            Double kansal = rsProshow.getDouble(1);

                                            jTextField41.setText(String.valueOf(kansal));
                                        }
                                        psc.close();
                                    } catch (Exception e) {
//                                e.printStackTrace();
                                        JOptionPane.showMessageDialog(null, "Cannot save." + e);
                                    }

                                } catch (Exception ex) {
                                    Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
                                }

                                //DISPLAY INGRED TEXTFIELD
                                try {

//                                    Connection con150 = (Connection) db_Connection.getInstance();
                                    try {
                                        String tou = "SELECT sum(ingredient_qty) FROM ingredpriceinc WHERE date= '" + dated + "' and factory='" + priv + "';";

                                        PreparedStatement pscee = db_Connection.getInstance().prepareStatement(t);
                                        rsProshow = pscee.executeQuery(tou);

                                        if (rsProshow.next()) {
                                            Double kansal = rsProshow.getDouble(1);

                                            jTextField42.setText(String.valueOf(kansal));
                                        }
                                        pscee.close();
                                    } catch (Exception e) {
//                                e.printStackTrace();
                                        JOptionPane.showMessageDialog(null, "Cannot save." + e);
                                    }

                                } catch (Exception ex) {
                                    Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                ps123.close();
                            } catch (Exception e) {
//                        e.printStackTrace();
                                JOptionPane.showMessageDialog(null, "Cannot save." + e);
                            }
                            ps.close();
                        } catch (Exception e) {
//                    e.printStackTrace();
                            JOptionPane.showMessageDialog(null, "Cannot save." + e);
                        }

                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Invalid Entry or field must be completely filled", "message", 2);
                    }

                    try {
                        DefaultTableModel model = (DefaultTableModel) jTable7.getModel();
//            int mg3 = Integer.parseInt(jTextField9.getText());

                        try {
                            int z3 = model.getRowCount();
                            for (int lu3 = 0; lu3 <= z3; ++lu3) {
                                model.removeRow(0);
                            }
                        } catch (Exception e) {
                        }
                        try {

//                            Connection con153 =(Connection) db_Connection.getInstance();
                            Statement s4 = db_Connection.getInstance().createStatement();
                            String query4 = "SELECT * FROM ingredientsprodn where date = '" + dated + "' and factory='" + priv + "';";
                            rsProshow = s4.executeQuery(query4);

                            while (rsProshow.next()) {
                                model.addRow(new Object[]{rsProshow.getString("ingredient_name"), rsProshow.getString("ingredient_qty")});
                            }

                            rsProshow.close();
                            s4.close();

                        } catch (Exception e) {
//                    e.printStackTrace();
                            JOptionPane.showMessageDialog(null, "Error in connectivity");
                        }
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Invalid Entry or field must be completely filled", "message", 2);
                    }

                    try {
                        DefaultTableModel model = (DefaultTableModel) jTable6.getModel();
//            int mg2 = Integer.parseInt(jTextField9.getText());

                        try {
                            int z2 = model.getRowCount();
                            for (int lu2 = 0; lu2 <= z2; ++lu2) {
                                model.removeRow(0);
                            }
                        } catch (Exception e) {
                        }
                        try {

//                            Connection con154 =(Connection) db_Connection.getInstance();    
                            Statement stmt4 = db_Connection.getInstance().createStatement();
                            String query4 = "SELECT * FROM rawmatprodn where date = '" + dated + "' and factory='" + priv + "';";
                            rsProshow = stmt4.executeQuery(query4);

                            while (rsProshow.next()) {
                                model.addRow(new Object[]{rsProshow.getString("raw_material"), rsProshow.getString("qty")});
                            }

                            rsProshow.close();
                            stmt4.close();

                        } catch (Exception e) {
//                    e.printStackTrace();
                            JOptionPane.showMessageDialog(null, "Error in connectivity");
                        }
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Invalid Entry or field must be completely filled", "message", 2);
                    }

                    try {
                        DefaultTableModel model = (DefaultTableModel) jTable5.getModel();
//            int mg1 = Integer.parseInt(jTextField9.getText());

                        try {
                            int z1 = model.getRowCount();
                            for (int lu1 = 0; lu1 <= z1; ++lu1) {
                                model.removeRow(0);
                            }
                        } catch (Exception e) {
                        }
                        try {

//                            Connection con165 = (Connection) db_Connection.getInstance();     
                            Statement stmt4787 = db_Connection.getInstance().createStatement();
                            String query4 = "SELECT * FROM productproduction1 where date = '" + dated + "' and factory='" + priv + "';";
                            rsProshow = stmt4787.executeQuery(query4);

                            while (rsProshow.next()) {
                                model.addRow(new Object[]{rsProshow.getString("ProductionID"), rsProshow.getString("product_name"), rsProshow.getString("quantity")});
                            }

                            rsProshow.close();
                            stmt4787.close();

                        } catch (Exception e) {
//                    e.printStackTrace();
                            JOptionPane.showMessageDialog(null, "Error in connectivity");
                        }
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Invalid Entry or field must be completely filled", "message", 2);
                    }

                    try {
                        DefaultTableModel model = (DefaultTableModel) jTable8.getModel();
//            int mg = Integer.parseInt(jTextField9.getText());

                        try {
                            int zz = model.getRowCount();
                            for (int lu = 0; lu <= zz; ++lu) {
                                model.removeRow(0);
                            }
                        } catch (Exception e) {
                        }
                        try {

//                            Connection con155 = (Connection) db_Connection.getInstance();
                            Statement stmt4456 = db_Connection.getInstance().createStatement();
                            String query4 = "SELECT * FROM costingprodn where date = '" + dated + "' and factory='" + priv + "';";
                            rsProshow = stmt4456.executeQuery(query4);

                            while (rsProshow.next()) {
                                model.addRow(new Object[]{rsProshow.getString("voucher_no"), rsProshow.getInt("production_id"), rsProshow.getString("date"), rsProshow.getString("factory"), rsProshow.getString("fuel"), rsProshow.getString("briquette"), rsProshow.getString("manpower"), rsProshow.getString("electricity"), rsProshow.getString("can_name"), rsProshow.getString("no_of_cans"), rsProshow.getString("label_name"), rsProshow.getString("no_of_labels")});
                            }

                            rsProshow.close();
                            stmt4456.close();

                        } catch (Exception e) {
//                    e.printStackTrace();
                            JOptionPane.showMessageDialog(null, "Error in connectivity");
                        }

                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Invalid Entry or field must be completely filled", "message", 2);
                    }

                } else if (jRadioButton13.isSelected() == true) {

                    try {
                        String priv1 = jTextLogin.getText();
//                        Connection con148 = (Connection) db_Connection.getInstance();
                        try {
                            String t = "SELECT * FROM production where date>= '" + dated1 + "' and date <= '" + dated2 + "' and factory='" + priv + "';";
                            PreparedStatement ps = db_Connection.getInstance().prepareStatement(t);
                            rsProshow = ps.executeQuery(t);

                            if (rsProshow.next()) {

                                remarks = rsProshow.getString("remarks");
                                no2 = remarks;
                                jTextArea2.setText(String.valueOf(no2));
                            }

                            //PRODUCTS TEXTFIELD,AMOUNT
                            try {
                                String tia = "SELECT sum(quantity) FROM prodpriceinclusive WHERE date>= '" + dated1 + "' and date <= '" + dated2 + "' and factory='" + priv + "';";

                                PreparedStatement ps123 = db_Connection.getInstance().prepareStatement(t);
                                rsProshow = ps123.executeQuery(tia);

                                if (rsProshow.next()) {
                                    Double xansal = rsProshow.getDouble(1);

                                    jTextField40.setText(String.valueOf(xansal));
                                }

                                //DISPLAY RAW TEXTFIELD
                                try {

//                                    Connection con149 = (Connection) db_Connection.getInstance();
                                    try {
                                        String ti = "SELECT sum(qty) FROM rawmatpriceinc WHERE date>= '" + dated1 + "' and date <= '" + dated2 + "' and factory='" + priv + "';";

                                        try (PreparedStatement psc = db_Connection.getInstance().prepareStatement(t)) {
                                            rsProshow = psc.executeQuery(ti);

                                            if (rsProshow.next()) {
                                                Double kansal = rsProshow.getDouble(1);

                                                jTextField41.setText(String.valueOf(kansal));
                                            }
                                            psc.close();
                                        }
                                    } catch (Exception e) {
//                                e.printStackTrace();
                                        JOptionPane.showMessageDialog(null, "Cannot save." + e);
                                    }

                                } catch (Exception ex) {
                                    Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
                                }

                                //DISPLAY INGRED TEXTFIELD
                                try {

//                                    Connection con150 = (Connection) db_Connection.getInstance();
                                    try {
                                        String tou = "SELECT sum(ingredient_qty) FROM ingredpriceinc WHERE date>= '" + dated1 + "' and date <= '" + dated2 + "' and factory='" + priv + "';";

                                        PreparedStatement psc = db_Connection.getInstance().prepareStatement(t);
                                        rsProshow = psc.executeQuery(tou);

                                        if (rsProshow.next()) {
                                            Double kansal = rsProshow.getDouble(1);

                                            jTextField42.setText(String.valueOf(kansal));
                                        }
                                        psc.close();
                                    } catch (Exception e) {
//                                e.printStackTrace();
                                        JOptionPane.showMessageDialog(null, "Cannot save." + e);
                                    }

                                } catch (Exception ex) {
                                    Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                ps123.close();
                            } catch (Exception e) {
//                        e.printStackTrace();
                                JOptionPane.showMessageDialog(null, "Cannot save." + e);
                            }
                            ps.close();
                        } catch (Exception e) {
//                    e.printStackTrace();
                            JOptionPane.showMessageDialog(null, "Cannot save." + e);
                        }

                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Invalid Entry or field must be completely filled", "message", 2);
                    }

                    try {
                        DefaultTableModel model = (DefaultTableModel) jTable7.getModel();
//            int mg3 = Integer.parseInt(jTextField9.getText());

                        try {
                            int z3 = model.getRowCount();
                            for (int lu3 = 0; lu3 <= z3; ++lu3) {
                                model.removeRow(0);
                            }
                        } catch (Exception e) {
                        }
                        try {

//                            Connection con153 =(Connection) db_Connection.getInstance();
                            Statement stmt4 = db_Connection.getInstance().createStatement();
                            String query4 = "SELECT * FROM ingredientsprodn where date>= '" + dated1 + "' and date <= '" + dated2 + "' and factory='" + priv + "';";
                            rsProshow = stmt4.executeQuery(query4);

                            while (rsProshow.next()) {
                                model.addRow(new Object[]{rsProshow.getString("ingredient_name"), rsProshow.getString("ingredient_qty")});
                            }

                            rsProshow.close();
                            stmt4.close();

                        } catch (Exception e) {
//                    e.printStackTrace();
                            JOptionPane.showMessageDialog(null, "Error in connectivity");
                        }
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Invalid Entry or field must be completely filled", "message", 2);
                    }

                    try {
                        DefaultTableModel model = (DefaultTableModel) jTable6.getModel();
//            int mg2 = Integer.parseInt(jTextField9.getText());

                        try {
                            int z2 = model.getRowCount();
                            for (int lu2 = 0; lu2 <= z2; ++lu2) {
                                model.removeRow(0);
                            }
                        } catch (Exception e) {
                        }
                        try {

//                            Connection con154 = (Connection) db_Connection.getInstance();
                            Statement stmt4 = db_Connection.getInstance().createStatement();
                            String query4 = "SELECT * FROM rawmatprodn where date>= '" + dated1 + "' and date <= '" + dated2 + "' and factory='" + priv + "';";
                            rsProshow = stmt4.executeQuery(query4);

                            while (rsProshow.next()) {
                                model.addRow(new Object[]{rsProshow.getString("raw_material"), rsProshow.getString("qty")});
                            }

                            rsProshow.close();
                            stmt4.close();

                        } catch (Exception e) {
//                    e.printStackTrace();
                            JOptionPane.showMessageDialog(null, "Error in connectivity");
                        }
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Invalid Entry or field must be completely filled", "message", 2);
                    }

                    try {
                        DefaultTableModel model = (DefaultTableModel) jTable5.getModel();
//            int mg1 = Integer.parseInt(jTextField9.getText());

                        try {
                            int z1 = model.getRowCount();
                            for (int lu1 = 0; lu1 <= z1; ++lu1) {
                                model.removeRow(0);
                            }
                        } catch (Exception e) {
                        }
                        try {

//                            Connection con165 = (Connection) db_Connection.getInstance();
                            Statement stmt4 = db_Connection.getInstance().createStatement();
                            String query4 = "SELECT * FROM productproduction1 where date>= '" + dated1 + "' and date <= '" + dated2 + "' and factory='" + priv + "';";
                            rsProshow = stmt4.executeQuery(query4);

                            while (rsProshow.next()) {
                                model.addRow(new Object[]{rsProshow.getString("ProductionID"), rsProshow.getString("product_name"), rsProshow.getString("quantity")});
                            }

                            rsProshow.close();
                            stmt4.close();

                        } catch (Exception e) {
//                    e.printStackTrace();
                            JOptionPane.showMessageDialog(null, "Error in connectivity");
                        }
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Invalid Entry or field must be completely filled", "message", 2);
                    }

                    try {
                        DefaultTableModel model = (DefaultTableModel) jTable8.getModel();
//            int mg = Integer.parseInt(jTextField9.getText());

                        try {
                            int zz = model.getRowCount();
                            for (int lu = 0; lu <= zz; ++lu) {
                                model.removeRow(0);
                            }
                        } catch (Exception e) {
                        }
                        try {

//                            Connection con155 = (Connection) db_Connection.getInstance();      
                            Statement stmt4g = db_Connection.getInstance().createStatement();
                            String query4 = "SELECT * FROM costingprodn where date>= '" + dated1 + "' and date <= '" + dated2 + "' and factory='" + priv + "';";
                            rsProshow = stmt4g.executeQuery(query4);

                            while (rsProshow.next()) {
                                model.addRow(new Object[]{rsProshow.getString("voucher_no"), rsProshow.getInt("production_id"), rsProshow.getString("date"), rsProshow.getString("factory"), rsProshow.getString("fuel"), rsProshow.getString("briquette"), rsProshow.getString("manpower"), rsProshow.getString("electricity"), rsProshow.getString("can_name"), rsProshow.getString("no_of_cans"), rsProshow.getString("label_name"), rsProshow.getString("no_of_labels")});
                            }

                            rsProshow.close();
                            stmt4g.close();

                        } catch (Exception e) {
//                    e.printStackTrace();
                            JOptionPane.showMessageDialog(null, "Error in connectivity");
                        }

                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Invalid Entry or field must be completely filled", "message", 2);
                    }
                } else if (jRadioButton20.isSelected() == true) {
                    String fcd = jTextLogin.getText();
                    String vouchered = (String) jTextField138.getText();
                    Integer vouchers = Integer.valueOf(vouchered);
//                   String vouchered1 = (String) jTextField9.getText();
//                    Integer vouchers1 = Integer.valueOf(vouchered1);
                    try {

//                        Connection con1v4 = (Connection) db_Connection.getInstance();
                        try {
                            String t = "SELECT * FROM productproduction1 where ProductionID = '" + vouchers + "' and factory = '" + fcd + "';";
                            PreparedStatement ps = db_Connection.getInstance().prepareStatement(t);
                            rsProshow = ps.executeQuery(t);

                            if (rsProshow.next()) {

                                remarks = rsProshow.getString("remarks");
                                no2 = remarks;
                                jTextArea2.setText(String.valueOf(no2));
                            }

                            //PRODUCTS TEXTFIELD,AMOUNT
                            try {
                                String tia = "SELECT sum(quantity) FROM prodpriceinclusive WHERE ProductionID= '" + vouchers + "' and factory = '" + fcd + "';";

                                PreparedStatement ps123 = db_Connection.getInstance().prepareStatement(t);
                                rsProshow = ps123.executeQuery(tia);

                                if (rsProshow.next()) {
                                    Double xansal = rsProshow.getDouble(1);
                                    DecimalFormat pro1 = new DecimalFormat("0.0000");
                                    String formattedText = pro1.format(xansal);
                                    jTextField40.setText(String.valueOf(formattedText));
                                }

                                //DISPLAY RAW TEXTFIELD
                                try {

//                                    Connection con180 = (Connection) db_Connection.getInstance();
                                    try {
                                        String ti = "SELECT sum(qty) FROM rawmatpriceinc WHERE ProductionID= '" + vouchers + "' and factory = '" + fcd + "';";

                                        PreparedStatement psc = db_Connection.getInstance().prepareStatement(t);
                                        rsProshow = psc.executeQuery(ti);

                                        if (rsProshow.next()) {
                                            Double kansal = rsProshow.getDouble(1);
                                            DecimalFormat pro2 = new DecimalFormat("0.0000");
                                            String formattedText1 = pro2.format(kansal);
                                            jTextField41.setText(String.valueOf(formattedText1));
                                        }
                                        psc.close();
                                    } catch (Exception e) {
//                                e.printStackTrace();
                                        JOptionPane.showMessageDialog(null, "Cannot save." + e);
                                    }

                                } catch (Exception ex) {
                                    Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
                                }

                                //DISPLAY INGRED TEXTFIELD
                                try {

//                                    Connection con270 = (Connection) db_Connection.getInstance();
                                    try {
                                        String tou = "SELECT sum(ingredient_qty) FROM ingredpriceinc WHERE ProductionID= '" + vouchers + "' and factory = '" + fcd + "';";

                                        PreparedStatement psrtc = db_Connection.getInstance().prepareStatement(t);
                                        rsProshow = psrtc.executeQuery(tou);

                                        if (rsProshow.next()) {
                                            Double kansals = rsProshow.getDouble(1);
                                            DecimalFormat pro4 = new DecimalFormat("0.0000");
                                            String formattedText2 = pro4.format(kansals);
                                            jTextField42.setText(String.valueOf(formattedText2));
                                        }
                                        psrtc.close();
                                    } catch (Exception e) {
//                                e.printStackTrace();
                                        JOptionPane.showMessageDialog(null, "Cannot save." + e);
                                    }

                                } catch (Exception ex) {
                                    Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                ps123.close();
                            } catch (Exception e) {
//                        e.printStackTrace();
                                JOptionPane.showMessageDialog(null, "Cannot save." + e);
                            }
                            ps.close();
                        } catch (Exception e) {
//                    e.printStackTrace();
                            JOptionPane.showMessageDialog(null, "Cannot save." + e);
                        }

                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Invalid Entry or field must be completely filled", "message", 2);
                    }

                    try {
                        DefaultTableModel model = (DefaultTableModel) jTable7.getModel();
                        int mg3 = Integer.parseInt(jTextField138.getText());

                        try {
                            int z3 = model.getRowCount();
                            for (int lu3 = 0; lu3 <= z3; ++lu3) {
                                model.removeRow(0);
                            }
                        } catch (Exception e) {
                        }
                        try {

//                            Connection con144 =(Connection) db_Connection.getInstance();
                            Statement stmt4 = db_Connection.getInstance().createStatement();
                            String query4 = "SELECT * FROM ingredpriceinc where ProductionID = '" + mg3 + "' and factory = '" + fcd + "';";
                            rsProshow = stmt4.executeQuery(query4);

                            while (rsProshow.next()) {
                                model.addRow(new Object[]{rsProshow.getString("ingredient_name"), rsProshow.getString("ingredient_qty")});
                            }
                            rsProshow.close();
                            stmt4.close();

                        } catch (Exception e) {
//                    e.printStackTrace();
                            JOptionPane.showMessageDialog(null, "Error in connectivity");
                        }
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Invalid Entry or field must be completely filled", "message", 2);
                    }

                    try {
                        DefaultTableModel model = (DefaultTableModel) jTable6.getModel();
                        int mg2 = Integer.parseInt(jTextField138.getText());

                        try {
                            int z2 = model.getRowCount();
                            for (int lu2 = 0; lu2 <= z2; ++lu2) {
                                model.removeRow(0);
                            }
                        } catch (Exception e) {
                        }
                        try {

//                            Connection con145 = (Connection) db_Connection.getInstance();
                            Statement stmt4 = db_Connection.getInstance().createStatement();
                            String query4 = "SELECT * FROM rawmatpriceinc where ProductionID = '" + mg2 + "' and factory = '" + fcd + "';";
                            rsProshow = stmt4.executeQuery(query4);

                            while (rsProshow.next()) {
                                model.addRow(new Object[]{rsProshow.getString("raw_material"), rsProshow.getString("qty")});
                            }

                            rsProshow.close();
                            stmt4.close();

                        } catch (Exception e) {
//                    e.printStackTrace();
                            JOptionPane.showMessageDialog(null, "Error in connectivity");
                        }
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Invalid Entry or field must be completely filled", "message", 2);
                    }

                    try {
                        DefaultTableModel model = (DefaultTableModel) jTable5.getModel();
                        int mg1 = Integer.parseInt(jTextField138.getText());

                        try {
                            int z1 = model.getRowCount();
                            for (int lu1 = 0; lu1 <= z1; ++lu1) {
                                model.removeRow(0);
                            }
                        } catch (Exception e) {
                        }
                        try {

//                            Connection con146 = (Connection) db_Connection.getInstance();
                            Statement stmt4 = db_Connection.getInstance().createStatement();
                            String query4 = "SELECT * FROM productproduction where ProductionID = '" + mg1 + "' and factory = '" + fcd + "';";
                            rsProshow = stmt4.executeQuery(query4);

                            while (rsProshow.next()) {
                                model.addRow(new Object[]{rsProshow.getString("ProductionID"), rsProshow.getString("product_name"), rsProshow.getString("quantity"), rsProshow.getString("waste")});
                            }

                            rsProshow.close();
                            stmt4.close();

                        } catch (Exception e) {
//                    e.printStackTrace();
                            JOptionPane.showMessageDialog(null, "Error in connectivity");
                        }
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Invalid Entry or field must be completely filled", "message", 2);
                    }

                    try {
                        DefaultTableModel model = (DefaultTableModel) jTable8.getModel();
                        int mg = Integer.parseInt(jTextField138.getText());

                        try {
                            int zz = model.getRowCount();
                            for (int lu = 0; lu <= zz; ++lu) {
                                model.removeRow(0);
                            }
                        } catch (Exception e) {
                        }
                        try {

//                            Connection con147 = (Connection) db_Connection.getInstance();
                            Statement stmt4 = db_Connection.getInstance().createStatement();
                            String query4 = "SELECT * FROM costingprodn where production_id = '" + mg + "' and factory = '" + fcd + "';";
                            rsProshow = stmt4.executeQuery(query4);

                            while (rsProshow.next()) {
                                model.addRow(new Object[]{rsProshow.getString("voucher_no"), rsProshow.getInt("production_id"), rsProshow.getString("date"), rsProshow.getString("factory"), rsProshow.getString("fuel"), rsProshow.getString("briquette"), rsProshow.getString("manpower"), rsProshow.getString("electricity"), rsProshow.getString("can_name"), rsProshow.getString("no_of_cans"), rsProshow.getString("label_name"), rsProshow.getString("no_of_labels")});
                            }

                            rsProshow.close();
                            stmt4.close();

                        } catch (Exception e) {
//                    e.printStackTrace();
                            JOptionPane.showMessageDialog(null, "Error in connectivity");
                        }
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Invalid Entry or field must be completely filled", "message", 2);
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "Please choose an option!");
                }
            } catch (Exception e) {
//                                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Cannot save." + e);
            }

        }

        // TODO add your handling code here:
    }

    public static void productidReport() throws HeadlessException, NumberFormatException {
        ResultSet rsProshow;
        String remarks;
        String no2;
        String vouchered = (String) jTextField138.getText();
        Integer vouchers = Integer.valueOf(vouchered);
        //                   String vouchered1 = (String) jTextField9.getText();
//                    Integer vouchers1 = Integer.valueOf(vouchered1);
try {
    
//                        Connection con1v4 = (Connection) db_Connection.getInstance();
try {
    String t = "SELECT * FROM productproduction1 where ProductionID = '" + vouchers + "';";
    PreparedStatement ps = db_Connection.getInstance().prepareStatement(t);
    rsProshow = ps.executeQuery(t);
    
    if (rsProshow.next()) {
        
        remarks = rsProshow.getString("remarks");
        no2 = remarks;
        jTextArea2.setText(String.valueOf(no2));
    }
    
    //PRODUCTS TEXTFIELD,AMOUNT
    try {
        String tia = "SELECT sum(quantity) FROM prodpriceinclusive WHERE ProductionID= '" + vouchers + "';";
        
        PreparedStatement ps123 = db_Connection.getInstance().prepareStatement(t);
        rsProshow = ps123.executeQuery(tia);
        
        if (rsProshow.next()) {
            Double xansal = rsProshow.getDouble(1);
            DecimalFormat pro1 = new DecimalFormat("0.0000");
            String formattedText = pro1.format(xansal);
            jTextField40.setText(String.valueOf(formattedText));
        }
        
        //DISPLAY RAW TEXTFIELD
        try {
            
//                                    Connection con180 = (Connection) db_Connection.getInstance();
try {
    String ti = "SELECT sum(qty) FROM rawmatpriceinc WHERE ProductionID= '" + vouchers + "' ;";
    
    PreparedStatement psc54 = db_Connection.getInstance().prepareStatement(t);
    rsProshow = psc54.executeQuery(ti);
    
    if (rsProshow.next()) {
        Double kansal = rsProshow.getDouble(1);
        DecimalFormat pro2 = new DecimalFormat("0.0000");
        String formattedText1 = pro2.format(kansal);
        jTextField41.setText(String.valueOf(formattedText1));
    }
    psc54.close();
} catch (Exception e) {
//                                e.printStackTrace();
JOptionPane.showMessageDialog(null, "Cannot save." + e);
}

        } catch (Exception ex) {
            Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //DISPLAY INGRED TEXTFIELD
        try {
            
//                                    Connection con270 = (Connection) db_Connection.getInstance();
try {
    String tou = "SELECT sum(ingredient_qty) FROM ingredpriceinc WHERE ProductionID= '" + vouchers + "' ;";
    
    PreparedStatement psc45 = db_Connection.getInstance().prepareStatement(t);
    rsProshow = psc45.executeQuery(tou);
    
    if (rsProshow.next()) {
        Double kansals = rsProshow.getDouble(1);
        DecimalFormat pro4 = new DecimalFormat("0.0000");
        String formattedText2 = pro4.format(kansals);
        jTextField42.setText(String.valueOf(formattedText2));
    }
    psc45.close();
} catch (Exception e) {
//                                e.printStackTrace();
JOptionPane.showMessageDialog(null, "Cannot save." + e);
}

        } catch (Exception ex) {
            Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        ps123.close();
    } catch (Exception e) {
//                        e.printStackTrace();
JOptionPane.showMessageDialog(null, "Cannot save." + e);
    }
    ps.close();
} catch (Exception e) {
//                    e.printStackTrace();
JOptionPane.showMessageDialog(null, "Cannot save." + e);
}

} catch (Exception e) {
    JOptionPane.showMessageDialog(null, "Invalid Entry or field must be completely filled", "message", 2);
}
try {
    DefaultTableModel model = (DefaultTableModel) jTable7.getModel();
    int mg3 = Integer.parseInt(jTextField138.getText());
    
    try {
        int z3 = model.getRowCount();
        for (int lu3 = 0; lu3 <= z3; ++lu3) {
            model.removeRow(0);
        }
    } catch (Exception e) {
    }
    try {
        
//                            Connection con144 = (Connection) db_Connection.getInstance();
Statement stmt4 = db_Connection.getInstance().createStatement();
String query4 = "SELECT * FROM ingredpriceinc where ProductionID = '" + mg3 + "';";
rsProshow = stmt4.executeQuery(query4);

while (rsProshow.next()) {
    model.addRow(new Object[]{rsProshow.getString("ingredient_name"), rsProshow.getString("ingredient_qty")});
}
rsProshow.close();
stmt4.close();

    } catch (Exception e) {
//                    e.printStackTrace();
JOptionPane.showMessageDialog(null, "Error in connectivity");
    }
} catch (Exception e) {
    JOptionPane.showMessageDialog(null, "Invalid Entry or field must be completely filled", "message", 2);
}
try {
    DefaultTableModel model = (DefaultTableModel) jTable6.getModel();
    int mg2 = Integer.parseInt(jTextField138.getText());
    
    try {
        int z2 = model.getRowCount();
        for (int lu2 = 0; lu2 <= z2; ++lu2) {
            model.removeRow(0);
        }
    } catch (Exception e) {
    }
    try {
        
//                            Connection con145 = (Connection) db_Connection.getInstance();
Statement stmt49 = db_Connection.getInstance().createStatement();
String query4 = "SELECT * FROM rawmatpriceinc where ProductionID = '" + mg2 + "' ;";
rsProshow = stmt49.executeQuery(query4);

while (rsProshow.next()) {
    model.addRow(new Object[]{rsProshow.getString("raw_material"), rsProshow.getString("qty")});
}

rsProshow.close();
stmt49.close();

    } catch (Exception e) {
//                    e.printStackTrace();
JOptionPane.showMessageDialog(null, "Error in connectivity");
    }
} catch (Exception e) {
    JOptionPane.showMessageDialog(null, "Invalid Entry or field must be completely filled", "message", 2);
}
try {
    DefaultTableModel model = (DefaultTableModel) jTable5.getModel();
    int mg1 = Integer.parseInt(jTextField138.getText());
    
    try {
        int z1 = model.getRowCount();
        for (int lu1 = 0; lu1 <= z1; ++lu1) {
            model.removeRow(0);
        }
    } catch (Exception e) {
    }
    try {
        
//                            Connection con146 =(Connection) db_Connection.getInstance();
Statement stmt48 = db_Connection.getInstance().createStatement();
String query4 = "SELECT * FROM productproduction where ProductionID = '" + mg1 + "' ;";
rsProshow = stmt48.executeQuery(query4);

while (rsProshow.next()) {
    model.addRow(new Object[]{rsProshow.getString("ProductionID"), rsProshow.getString("product_name"), rsProshow.getString("quantity"), rsProshow.getString("waste")});
}

rsProshow.close();
stmt48.close();

    } catch (Exception e) {
//                    e.printStackTrace();
JOptionPane.showMessageDialog(null, "Error in connectivity");
    }
} catch (Exception e) {
    JOptionPane.showMessageDialog(null, "Invalid Entry or field must be completely filled", "message", 2);
}
try {
    DefaultTableModel model = (DefaultTableModel) jTable8.getModel();
    int mg = Integer.parseInt(jTextField138.getText());
    
    try {
        int zz = model.getRowCount();
        for (int lu = 0; lu <= zz; ++lu) {
            model.removeRow(0);
        }
    } catch (Exception e) {
    }
    try {
        
//                            Connection con147 = (Connection) db_Connection.getInstance();
Statement stmt4o = db_Connection.getInstance().createStatement();
String query4 = "SELECT * FROM costingprodn where production_id = '" + mg + "';";
rsProshow = stmt4o.executeQuery(query4);

while (rsProshow.next()) {
    model.addRow(new Object[]{rsProshow.getString("voucher_no"), rsProshow.getInt("production_id"), rsProshow.getString("date"), rsProshow.getString("factory"), rsProshow.getString("fuel"), rsProshow.getString("briquette"), rsProshow.getString("manpower"), rsProshow.getString("electricity"), rsProshow.getString("can_name"), rsProshow.getString("no_of_cans"), rsProshow.getString("label_name"), rsProshow.getString("no_of_labels")});
}

rsProshow.close();
stmt4o.close();

    } catch (Exception e) {
//                    e.printStackTrace();
JOptionPane.showMessageDialog(null, "Error in connectivity");
    }
} catch (Exception e) {
    JOptionPane.showMessageDialog(null, "Invalid Entry or field must be completely filled", "message", 2);
}
    }

    public static void voucherReport() throws HeadlessException, NumberFormatException {
        ResultSet rsProshow;
        String remarks;
        String no2;
        String vouchered = (String) jTextField9.getText();
        Integer vouchers = Integer.valueOf(vouchered);
        try {
            String t = "SELECT * FROM production where voucher_no = '" + vouchers + "';";
            PreparedStatement ps = db_Connection.getInstance().prepareStatement(t);
            rsProshow = ps.executeQuery();

            if (rsProshow.next()) {

                remarks = rsProshow.getString("remarks");
                no2 = remarks;
                jTextArea2.setText(String.valueOf(no2));
            }

            //PRODUCTS TEXTFIELD,AMOUNT
            try {
                String tia = "SELECT sum(quantity) FROM prodpriceinclusive WHERE voucher_no= '" + vouchers + "';";

                try (PreparedStatement ps123 = db_Connection.getInstance().prepareStatement(t)) {

                    rsProshow = ps123.executeQuery(tia);
                    if (rsProshow.next()) {
                        Double xansal = rsProshow.getDouble(1);
                        DecimalFormat pro1 = new DecimalFormat("0.0000");
                        String formattedText = pro1.format(xansal);
                        jTextField40.setText(String.valueOf(formattedText));
                    }
                    //DISPLAY RAW TEXTFIELD
                    try {
                        String ti = "SELECT sum(qty) FROM rawmatpriceinc WHERE voucher_no= '" + vouchers + "' ;";

                        try (PreparedStatement psc = db_Connection.getInstance().prepareStatement(t)) {
                            rsProshow = psc.executeQuery();

                            if (rsProshow.next()) {
                                Double kansal = rsProshow.getDouble(1);
                                DecimalFormat pro2 = new DecimalFormat("0.0000");
                                String formattedText1 = pro2.format(kansal);
                                jTextField41.setText(String.valueOf(formattedText1));
                            }
                            psc.close();
                        }

                    } catch (Exception e) {
//                                e.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Cannot save." + e);
                    }

                    //DISPLAY INGRED TEXTFIELD
                    try {

                        try {
                            String tou = "SELECT sum(ingredient_qty) FROM ingredpriceinc WHERE voucher_no= '" + vouchers + "' ;";

                            try (PreparedStatement pscee = db_Connection.getInstance().prepareStatement(t)) {
                                rsProshow = pscee.executeQuery();

                                if (rsProshow.next()) {
                                    Double kansals = rsProshow.getDouble(1);
                                    DecimalFormat pro4 = new DecimalFormat("0.0000");
                                    String formattedText2 = pro4.format(kansals);
                                    jTextField42.setText(String.valueOf(formattedText2));
                                }
                            }
                        } catch (Exception e) {
//                                e.printStackTrace();
                            JOptionPane.showMessageDialog(null, "Cannot save." + e);
                        }

                    } catch (Exception ex) {
                        Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } catch (Exception e) {
//                        e.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Cannot save." + e);
                }
                ps.close();
            } catch (Exception e) {
//                    e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Cannot save." + e);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Invalid Entry or field must be completely filled", "message", 2);
        }
        try {
            DefaultTableModel model = (DefaultTableModel) jTable7.getModel();
            int mg3 = Integer.parseInt(jTextField9.getText());

            try {
                int z3 = model.getRowCount();
                for (int lu3 = 0; lu3 <= z3; ++lu3) {
                    model.removeRow(0);
                }
            } catch (Exception e) {
            }
            try {
                String query4 = "SELECT * FROM ingredpriceinc where voucher_no = '" + mg3 + "';";

                try (PreparedStatement stmt4 = db_Connection.getInstance().prepareStatement(query4)) {
                    rsProshow = stmt4.executeQuery();

                    while (rsProshow.next()) {
                        model.addRow(new Object[]{rsProshow.getString("ingredient_name"), rsProshow.getString("ingredient_qty")});
                    }
                    rsProshow.close();
                }

            } catch (Exception e) {
//                    e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error in connectivity");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Invalid Entry or field must be completely filled", "message", 2);
        }
        try {
            DefaultTableModel model = (DefaultTableModel) jTable6.getModel();
            int mg2 = Integer.parseInt(jTextField9.getText());

            try {
                int z2 = model.getRowCount();
                for (int lu2 = 0; lu2 <= z2; ++lu2) {
                    model.removeRow(0);
                }
            } catch (Exception e) {
            }
            try {
                String query4vc = "SELECT * FROM rawmatpriceinc where voucher_no = '" + mg2 + "' ;";

                PreparedStatement s1tmt4 = db_Connection.getInstance().prepareStatement(query4vc);
                rsProshow = s1tmt4.executeQuery();

                while (rsProshow.next()) {
                    model.addRow(new Object[]{rsProshow.getString("raw_material"), rsProshow.getString("qty")});
                }

                rsProshow.close();
                s1tmt4.close();

            } catch (Exception e) {
//                    e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error in connectivity");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Invalid Entry or field must be completely filled", "message", 2);
        }
        try {
            DefaultTableModel model = (DefaultTableModel) jTable5.getModel();
            int mg1 = Integer.parseInt(jTextField9.getText());

            try {
                int z1 = model.getRowCount();
                for (int lu1 = 0; lu1 <= z1; ++lu1) {
                    model.removeRow(0);
                }
            } catch (Exception e) {
            }
            try {
                String query4vc1 = "SELECT * FROM productproduction where voucher_no = '" + mg1 + "' ;";
                PreparedStatement s2tmt4 = db_Connection.getInstance().prepareStatement(query4vc1);

                rsProshow = s2tmt4.executeQuery();

                while (rsProshow.next()) {
                    model.addRow(new Object[]{rsProshow.getString("ProductionID"), rsProshow.getString("product_name"), rsProshow.getString("quantity"), rsProshow.getString("waste")});
                }

                rsProshow.close();
                s2tmt4.close();

            } catch (Exception e) {
//                    e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error in connectivity");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Invalid Entry or field must be completely filled", "message", 2);
        }
        try {
            DefaultTableModel model = (DefaultTableModel) jTable8.getModel();
            int mg = Integer.parseInt(jTextField9.getText());

            try {
                int zz = model.getRowCount();
                for (int lu = 0; lu <= zz; ++lu) {
                    model.removeRow(0);
                }
            } catch (Exception e) {
            }
            try {
                String query4vc2 = "SELECT * FROM costingprodn where voucher_no = '" + mg + "';";

                PreparedStatement s3tmt4 = db_Connection.getInstance().prepareStatement(query4vc2);

                rsProshow = s3tmt4.executeQuery();

                while (rsProshow.next()) {
                    model.addRow(new Object[]{rsProshow.getString("voucher_no"), rsProshow.getInt("production_id"), rsProshow.getString("date"), rsProshow.getString("factory"), rsProshow.getString("fuel"), rsProshow.getString("briquette"), rsProshow.getString("manpower"), rsProshow.getString("electricity"), rsProshow.getString("can_name"), rsProshow.getString("no_of_cans"), rsProshow.getString("label_name"), rsProshow.getString("no_of_labels")});
                }

                rsProshow.close();
                s3tmt4.close();

            } catch (Exception e) {
//                    e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error in connectivity");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Invalid Entry or field must be completely filled", "message", 2);
        }
    }

   
}
