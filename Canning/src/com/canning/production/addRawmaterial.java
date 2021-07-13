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
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import static newpackage1.NewJFrame.jComboBox15;
import static newpackage1.NewJFrame.jComboBox21;
import static newpackage1.NewJFrame.jComboBox20;
import static newpackage1.NewJFrame.jComboBox3;
import static newpackage1.NewJFrame.jTable15;
import static newpackage1.NewJFrame.jTextField131;
import static newpackage1.NewJFrame.jTextField141;
import static newpackage1.NewJFrame.jTextField3;
import static newpackage1.NewJFrame.jTextField31;
import static newpackage1.NewJFrame.jTextField43;
import static newpackage1.NewJFrame.jTextField63;
import static newpackage1.NewJFrame.jTextField92;
import static newpackage1.NewJFrame.jTextLogin;
import static newpackage1.NewJFrame.jTextStatus;
import static newpackage1.NewJFrame.jTextUser;
//jTextUser.getText();
import newpackage1.db_Connection;

/**
 *
 * @author Stevoski
 */
public class addRawmaterial {

    public static void rawmaterialAdd() throws HeadlessException, NumberFormatException {

        String stetos = jTextStatus.getText();
         String fectory = (String) jComboBox3.getSelectedItem();
        ResultSet rsRawadd;
        String qrr = jTextField31.getText();
        Double rwe = Double.valueOf(qrr);
        String kwu = (String) jComboBox15.getSelectedItem();
        String consino = (String) jComboBox20.getSelectedItem();//ing name
        String rwa = (String) jComboBox21.getSelectedItem();
        String asusus = jTextLogin.getText();
        String swe = jTextField3.getText();
        Integer swi = Integer.parseInt(swe);
        String Dwe = jTextField63.getText();
        Integer Dwi = Integer.parseInt(Dwe);
        String qrWr = jTextUser.getText();
        String skra = null;
        String rwasted = jTextField92.getText();
        Double rwaste = Double.valueOf(rwasted);
        switch (stetos) {
            case "USER":         
        try {
//where factory='" + access + "'
                PreparedStatement psly = db_Connection.getInstance().prepareStatement("SELECT * FROM raw_material where raw_material_name=? and factory=?");
                Connection conraw = (Connection) db_Connection.getInstance();
                conraw.setAutoCommit(false);
                psly.setString(1, kwu);
                psly.setString(2, asusus);
                try {
                    rsRawadd = psly.executeQuery();

                    while (rsRawadd.next()) {
                        jTextField131.setText(rsRawadd.getString("unit_price"));
                        jTextField141.setText(rsRawadd.getString("stock_in_hand"));
                        skra = (rsRawadd.getString("raw_material_name"));
                    }
                    try {
                        String rmpry = jTextField131.getText();
                        Double rmpryce = Double.valueOf(rmpry);
                        String rmstc = jTextField141.getText();
                        Double rmpstc = Double.valueOf(rmstc);
                        try {

                            PreparedStatement ps4 = conraw.prepareStatement("INSERT INTO raw_materialproduction(voucher_no,raw_material,qty,ProductionID,groupe,Total_qty,rawmaterialprice,user,stock_in_hand,consi_no,raw_material_waste)"
                                    + "values(?,?,?,?,?,?,?,?,?,?,?)");
                            ps4.setInt(1, swi);
                            ps4.setString(2, skra);
                            ps4.setDouble(3, rwe);
                            ps4.setInt(4, Dwi);
                            ps4.setString(5, rwa);
                            ps4.setDouble(6, rwe);
                            ps4.setDouble(7, rmpryce);
                            ps4.setString(8, qrWr);
                            ps4.setDouble(9, rmpstc);
                            ps4.setString(10, consino); 
ps4.setDouble(11, rwaste);//                        
                            ps4.executeUpdate();
//                JOptionPane.showMessageDialog(null, "The data was successfully added to the Database!");

//TABLE INSERT
                            try {
                                DefaultTableModel model = (DefaultTableModel) jTable15.getModel();

                                try {
                                    int z3 = model.getRowCount();
                                    for (int lu3 = 0; lu3 <= z3; ++lu3) {
                                        model.removeRow(0);
                                    }
                                } catch (Exception e) {
                                }

                                try (PreparedStatement ps5 = db_Connection.getInstance().prepareStatement("SELECT * FROM rawmatpriceinc where voucher_no = '" + swi + "';")) {
                                    rsRawadd = ps5.executeQuery();
                                    while (rsRawadd.next()) {
                                        model.addRow(new Object[]{rsRawadd.getInt("ProductionID"), rsRawadd.getString("raw_material"), rsRawadd.getDouble("qty"), rsRawadd.getInt("RawID"), rsRawadd.getString("cons_no")});
                                    }
                                    try {
                                        try {
                                            String t = "SELECT sum(qty) FROM rawmatpriceinc WHERE voucher_no= '" + swi + "';";

                                            PreparedStatement psc = db_Connection.getInstance().prepareStatement(t);
                                            rsRawadd = psc.executeQuery(t);

                                            if (rsRawadd.next()) {
                                                Double bansal = rsRawadd.getDouble(1);

                                                jTextField43.setText(String.valueOf(bansal));
                                            }
                                            psc.close();
                                            conraw.commit();
                                        } catch (Exception e) {
                                            JOptionPane.showMessageDialog(null, "Cannot save." + e);
                                        }
                                    } catch (Exception e) {
                                        JOptionPane.showMessageDialog(null, e.getMessage());
                                    }
                                    rsRawadd.close();

                                } catch (Exception e) {
                                    JOptionPane.showMessageDialog(null, e.getMessage());
                                }

                                ps4.close();

                            } catch (Exception e) {
                                JOptionPane.showMessageDialog(null, e.getMessage());
                            }

                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(null, ex.getMessage());

                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Cannot save." + e);
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error in connectivity");
                }

            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Invalid Entry or field must be completely filled", "message", 2);
            }

            break;
            case "ADMINISTRATOR":
                                
        try {
//where factory='" + access + "'
                PreparedStatement psly = db_Connection.getInstance().prepareStatement("SELECT * FROM raw_material where raw_material_name=? and factory=?");
                Connection conraw = (Connection) db_Connection.getInstance();
                conraw.setAutoCommit(false);
                psly.setString(1, kwu);
                psly.setString(2, fectory);
                try {
                    rsRawadd = psly.executeQuery();

                    while (rsRawadd.next()) {
                        jTextField131.setText(rsRawadd.getString("unit_price"));
                        jTextField141.setText(rsRawadd.getString("stock_in_hand"));
                        skra = (rsRawadd.getString("raw_material_name"));
                    }
                    try {
                        String rmpry = jTextField131.getText();
                        Double rmpryce = Double.valueOf(rmpry);
                        String rmstc = jTextField141.getText();
                        Double rmpstc = Double.valueOf(rmstc);
                        try {

                            PreparedStatement ps4 = conraw.prepareStatement("INSERT INTO raw_materialproduction(voucher_no,raw_material,qty,ProductionID,groupe,Total_qty,rawmaterialprice,user,stock_in_hand,consi_no,raw_material_waste)"
                                    + "values(?,?,?,?,?,?,?,?,?,?,?)");
                            ps4.setInt(1, swi);
                            ps4.setString(2, skra);
                            ps4.setDouble(3, rwe);
                            ps4.setInt(4, Dwi);
                            ps4.setString(5, rwa);
                            ps4.setDouble(6, rwe);
                            ps4.setDouble(7, rmpryce);
                            ps4.setString(8, qrWr);
                            ps4.setDouble(9, rmpstc);
                            ps4.setString(10, consino); 
ps4.setDouble(11, rwaste);//                        
                            ps4.executeUpdate();
//                JOptionPane.showMessageDialog(null, "The data was successfully added to the Database!");

//TABLE INSERT
                            try {
                                DefaultTableModel model = (DefaultTableModel) jTable15.getModel();

                                try {
                                    int z3 = model.getRowCount();
                                    for (int lu3 = 0; lu3 <= z3; ++lu3) {
                                        model.removeRow(0);
                                    }
                                } catch (Exception e) {
                                }

                                try (PreparedStatement ps5 = db_Connection.getInstance().prepareStatement("SELECT * FROM rawmatpriceinc where voucher_no = '" + swi + "';")) {
                                    rsRawadd = ps5.executeQuery();
                                    while (rsRawadd.next()) {
                                        model.addRow(new Object[]{rsRawadd.getInt("ProductionID"), rsRawadd.getString("raw_material"), rsRawadd.getDouble("qty"), rsRawadd.getInt("RawID"), rsRawadd.getString("cons_no")});
                                    }
                                    try {
                                        try {
                                            String t = "SELECT sum(qty) FROM rawmatpriceinc WHERE voucher_no= '" + swi + "';";

                                            PreparedStatement psc = db_Connection.getInstance().prepareStatement(t);
                                            rsRawadd = psc.executeQuery(t);

                                            if (rsRawadd.next()) {
                                                Double bansal = rsRawadd.getDouble(1);

                                                jTextField43.setText(String.valueOf(bansal));
                                            }
                                            psc.close();
                                            conraw.commit();
                                        } catch (Exception e) {
                                            JOptionPane.showMessageDialog(null, "Cannot save." + e);
                                        }
                                    } catch (Exception e) {
                                        JOptionPane.showMessageDialog(null, e.getMessage());
                                    }
                                    rsRawadd.close();

                                } catch (Exception e) {
                                    JOptionPane.showMessageDialog(null, e.getMessage());
                                }

                                ps4.close();

                            } catch (Exception e) {
                                JOptionPane.showMessageDialog(null, e.getMessage());
                            }

                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(null, ex.getMessage());

                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Cannot save." + e);
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error in connectivity");
                }

            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Invalid Entry or field must be completely filled", "message", 2);
            }

            break;
        }

// TODO add your handling code here:
    }
    
    public static void newRawmaterialAdd() throws HeadlessException, NumberFormatException {

        String stetos = jTextStatus.getText();
         String fectory = (String) jComboBox3.getSelectedItem();
        ResultSet rsRawadd;
        String qrr = jTextField31.getText();
        Double rwe = Double.valueOf(qrr);
        String kwu = (String) jComboBox15.getSelectedItem();
        String consino = (String) jComboBox20.getSelectedItem();//ing name
        String rwa = (String) jComboBox21.getSelectedItem();
        String asusus = jTextLogin.getText();
        String swe = jTextField3.getText();
        Integer swi = Integer.parseInt(swe);
        String Dwe = jTextField63.getText();
        Integer Dwi = Integer.parseInt(Dwe);
        String qrWr = jTextUser.getText();
        String skra = null;
        String rwasted = jTextField92.getText();
        Double rwaste = Double.valueOf(rwasted);
        switch (stetos) {
            case "USER":
                
                
        try {
//where factory='" + access + "'
                PreparedStatement psly = db_Connection.getInstance().prepareStatement("SELECT * FROM raw_material where raw_material_name=? and factory=?");
                Connection conraw = (Connection) db_Connection.getInstance();
                conraw.setAutoCommit(false);
                psly.setString(1, kwu);
                psly.setString(2, asusus);
                try {
                    rsRawadd = psly.executeQuery();

                    while (rsRawadd.next()) {
                        jTextField131.setText(rsRawadd.getString("unit_price"));
                        jTextField141.setText(rsRawadd.getString("stock_in_hand"));
                        skra = (rsRawadd.getString("raw_material_name"));
                    }
                    try {
                        String rmpry = jTextField131.getText();
                        Double rmpryce = Double.valueOf(rmpry);
                        String rmstc = jTextField141.getText();
                        Double rmpstc = Double.valueOf(rmstc);
                        try {

                            PreparedStatement ps4 = conraw.prepareStatement("INSERT INTO raw_materialproduction(voucher_no,raw_material,qty,ProductionID,groupe,Total_qty,rawmaterialprice,user,stock_in_hand,consi_no,raw_material_waste)"
                                    + "values(?,?,?,?,?,?,?,?,?,?,?)");
                            ps4.setInt(1, swi);
                            ps4.setString(2, skra);
                            ps4.setDouble(3, rwe);
                            ps4.setInt(4, Dwi);
                            ps4.setString(5, rwa);
                            ps4.setDouble(6, rwe);
                            ps4.setDouble(7, rmpryce);
                            ps4.setString(8, qrWr);
                            ps4.setDouble(9, rmpstc);
                            ps4.setString(10, consino); 
ps4.setDouble(11, rwaste);//                        
                            ps4.executeUpdate();
//                JOptionPane.showMessageDialog(null, "The data was successfully added to the Database!");

//TABLE INSERT
                            try {
                                DefaultTableModel model = (DefaultTableModel) jTable15.getModel();

                                try {
                                    int z3 = model.getRowCount();
                                    for (int lu3 = 0; lu3 <= z3; ++lu3) {
                                        model.removeRow(0);
                                    }
                                } catch (Exception e) {
                                }

                                try (PreparedStatement ps5 = db_Connection.getInstance().prepareStatement("SELECT * FROM rawmatpriceinc where voucher_no = '" + swi + "';")) {
                                    rsRawadd = ps5.executeQuery();
                                    while (rsRawadd.next()) {
                                        model.addRow(new Object[]{rsRawadd.getInt("ProductionID"), rsRawadd.getString("raw_material"), rsRawadd.getDouble("qty"), rsRawadd.getInt("RawID"), rsRawadd.getString("cons_no")});
                                    }
                                    try {
                                        try {
                                            String t = "SELECT sum(qty) FROM rawmatpriceinc WHERE voucher_no= '" + swi + "';";

                                            PreparedStatement psc = db_Connection.getInstance().prepareStatement(t);
                                            rsRawadd = psc.executeQuery(t);

                                            if (rsRawadd.next()) {
                                                Double bansal = rsRawadd.getDouble(1);

                                                jTextField43.setText(String.valueOf(bansal));
                                            }
                                            psc.close();
                                            conraw.commit();
                                        } catch (Exception e) {
                                            JOptionPane.showMessageDialog(null, "Cannot save." + e);
                                        }
                                    } catch (Exception e) {
                                        JOptionPane.showMessageDialog(null, e.getMessage());
                                    }
                                    rsRawadd.close();

                                } catch (Exception e) {
                                    JOptionPane.showMessageDialog(null, e.getMessage());
                                }

                                ps4.close();

                            } catch (Exception e) {
                                JOptionPane.showMessageDialog(null, e.getMessage());
                            }

                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(null, ex.getMessage());

                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Cannot save." + e);
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error in connectivity");
                }

            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Invalid Entry or field must be completely filled", "message", 2);
            }

            break;
            case "ADMINISTRATOR":
                                
        try {
//where factory='" + access + "'
                PreparedStatement psly = db_Connection.getInstance().prepareStatement("SELECT * FROM raw_material where raw_material_name=? and factory=?");
                Connection conraw = (Connection) db_Connection.getInstance();
                conraw.setAutoCommit(false);
                psly.setString(1, kwu);
                psly.setString(2, fectory);
                try {
                    rsRawadd = psly.executeQuery();

                    while (rsRawadd.next()) {
                        jTextField131.setText(rsRawadd.getString("unit_price"));
                        jTextField141.setText(rsRawadd.getString("stock_in_hand"));
                        skra = (rsRawadd.getString("raw_material_name"));
                    }
                    try {
                        String rmpry = jTextField131.getText();
                        Double rmpryce = Double.valueOf(rmpry);
                        String rmstc = jTextField141.getText();
                        Double rmpstc = Double.valueOf(rmstc);
                        try {

                            PreparedStatement ps4 = conraw.prepareStatement("INSERT INTO raw_materialproduction(voucher_no,raw_material,qty,ProductionID,groupe,Total_qty,rawmaterialprice,user,stock_in_hand,consi_no,raw_material_waste)"
                                    + "values(?,?,?,?,?,?,?,?,?,?,?)");
                            ps4.setInt(1, swi);
                            ps4.setString(2, skra);
                            ps4.setDouble(3, rwe);
                            ps4.setInt(4, Dwi);
                            ps4.setString(5, rwa);
                            ps4.setDouble(6, rwe);
                            ps4.setDouble(7, rmpryce);
                            ps4.setString(8, qrWr);
                            ps4.setDouble(9, rmpstc);
                            ps4.setString(10, consino); 
ps4.setDouble(11, rwaste);//                        
                            ps4.executeUpdate();
//                JOptionPane.showMessageDialog(null, "The data was successfully added to the Database!");

//TABLE INSERT
                            try {
                                DefaultTableModel model = (DefaultTableModel) jTable15.getModel();

                                try {
                                    int z3 = model.getRowCount();
                                    for (int lu3 = 0; lu3 <= z3; ++lu3) {
                                        model.removeRow(0);
                                    }
                                } catch (Exception e) {
                                }

                                try (PreparedStatement ps5 = db_Connection.getInstance().prepareStatement("SELECT * FROM rawmatpriceinc where voucher_no = '" + swi + "';")) {
                                    rsRawadd = ps5.executeQuery();
                                    while (rsRawadd.next()) {
                                        model.addRow(new Object[]{rsRawadd.getInt("ProductionID"), rsRawadd.getString("raw_material"), rsRawadd.getDouble("qty"), rsRawadd.getInt("RawID"), rsRawadd.getString("cons_no")});
                                    }
                                    try {
                                        try {
                                            String t = "SELECT sum(qty) FROM rawmatpriceinc WHERE voucher_no= '" + swi + "';";

                                            PreparedStatement psc = db_Connection.getInstance().prepareStatement(t);
                                            rsRawadd = psc.executeQuery(t);

                                            if (rsRawadd.next()) {
                                                Double bansal = rsRawadd.getDouble(1);

                                                jTextField43.setText(String.valueOf(bansal));
                                            }
                                            psc.close();
                                            conraw.commit();
                                        } catch (Exception e) {
                                            JOptionPane.showMessageDialog(null, "Cannot save." + e);
                                        }
                                    } catch (Exception e) {
                                        JOptionPane.showMessageDialog(null, e.getMessage());
                                    }
                                    rsRawadd.close();

                                } catch (Exception e) {
                                    JOptionPane.showMessageDialog(null, e.getMessage());
                                }

                                ps4.close();

                            } catch (Exception e) {
                                JOptionPane.showMessageDialog(null, e.getMessage());
                            }

                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(null, ex.getMessage());

                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Cannot save." + e);
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error in connectivity");
                }

            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Invalid Entry or field must be completely filled", "message", 2);
            }

            break;
        }

// TODO add your handling code here:
    }
}
