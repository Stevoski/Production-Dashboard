/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 /*
Connection-specific DNS Suffix: 
Description: Intel(R) Centrino(R) Advanced-N 6230
Physical Address: ‎88-53-2E-03-FB-38
DHCP Enabled: No
IPv4 Address: 192.168.1.190
IPv4 Subnet Mask: 255.255.255.0
IPv4 Default Gateway: 192.168.1.1
IPv4 DNS Server: 208.67.220.220
IPv4 WINS Server: 
NetBIOS over Tcpip Enabled: Yes
Link-local IPv6 Address: fe80::e5d6:aa91:235:3f95%29
IPv6 Default Gateway: 
IPv6 DNS Server: 
 */
package com.canning.costpanel;

import java.awt.HeadlessException;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;
import newpackage1.db_Connection;
import static newpackage1.NewJFrame.jComboBox22;
import static newpackage1.NewJFrame.jComboBox24;
import static newpackage1.NewJFrame.jDate5;
import static newpackage1.NewJFrame.jDate6;
import static newpackage1.NewJFrame.jDateChooser1;
import static newpackage1.NewJFrame.jRadioButton1;
import static newpackage1.NewJFrame.jRadioButton10;
import static newpackage1.NewJFrame.jRadioButton2;
import static newpackage1.NewJFrame.jTable9;
import static newpackage1.NewJFrame.jTextField25;
import static newpackage1.NewJFrame.jTextField26;
import static newpackage1.NewJFrame.jTextField27;
import static newpackage1.NewJFrame.jTextField29;
import static newpackage1.NewJFrame.jTextField33;
import static newpackage1.NewJFrame.jTextField47;
import static newpackage1.NewJFrame.jTextField50;
import static newpackage1.NewJFrame.jTextField51;
import static newpackage1.NewJFrame.jTextField52;
import static newpackage1.NewJFrame.jTextField53;
import static newpackage1.NewJFrame.jTextField54;
import static newpackage1.NewJFrame.jTextField55;
import static newpackage1.NewJFrame.jTextField56;
import static newpackage1.NewJFrame.jTextField69;
import static newpackage1.NewJFrame.jTextField70;
import static newpackage1.NewJFrame.jTextField28;
import static newpackage1.NewJFrame.jTable11;
import static newpackage1.NewJFrame.jTable10;
import static newpackage1.NewJFrame.jTextField12;
import static newpackage1.NewJFrame.jTextField74;
import static newpackage1.NewJFrame.jComboBox43;
import static newpackage1.NewJFrame.jRadioButton23;
//import static newpackage1.NewJFrame.jRadioButton23;

/**
 *
 * @author Stevoski
 */

public class jpanel9Display {

    public static void Panel9Display() throws NumberFormatException, HeadlessException {

        ResultSet ars;
        String date1 = ((JTextField) jDateChooser1.getDateEditor().getUiComponent()).getText();
        String date5 = ((JTextField) jDate5.getDateEditor().getUiComponent()).getText();
        String date6 = ((JTextField) jDate6.getDateEditor().getUiComponent()).getText();
        String uua = (String) jComboBox24.getSelectedItem();

        jTextField69.setText(null); //ele
        jTextField28.setText(null); //fuel
        jTextField70.setText(null);
        int no2 = 0;
        //        String vou = jTextField25.getText();
        //        int amnt = Integer.valueOf(vou);
        String Factory = (String) jComboBox43.getSelectedItem();
        if (jComboBox43.getSelectedItem() == "All") {

            if (jRadioButton2.isSelected() == true) {
                String vouch1 = (String) jTextField25.getText();
                Integer toucherss = Integer.valueOf(vouch1);

                ///INGREDIENTS DISPL
                try {
                    DefaultTableModel model = (DefaultTableModel) jTable11.getModel();

                    try {
                        int z5 = model.getRowCount();
                        for (int lu3 = 0; lu3 <= z5; ++lu3) {
                            model.removeRow(0);
                        }
                    } catch (Exception e) {
                    }
                    try {

                        String query4 = "SELECT * FROM ingredpriceinc where voucher_no = '" + toucherss + "';";
                        try (PreparedStatement stmt4 = db_Connection.getInstance().prepareStatement(query4)) {
                            ars = stmt4.executeQuery(query4);

                            while (ars.next()) {
                                model.addRow(new Object[]{ars.getString("ingredient_name"), ars.getString("ingredient_price"), ars.getDouble("amount")});
                            }

                            ars.close();
                        }

                    } catch (Exception e) {
//                    e.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Error in connectivity");
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Invalid Entry or field must be completely filled", "message", 2);
                }

                //PRODUCTS
                try {
                    DefaultTableModel model10 = (DefaultTableModel) jTable9.getModel();

                    try {
                        int z4 = model10.getRowCount();
                        for (int lu3 = 0; lu3 <= z4; ++lu3) {
                            model10.removeRow(0);

                        }
                    } catch (Exception e) {
                    }
                    try {

                        String quer = "SELECT * FROM prodpriceinclusive where voucher_no = '" + toucherss + "';";
                        PreparedStatement stmt4 = db_Connection.getInstance().prepareStatement(quer);
                        ars = stmt4.executeQuery(quer);

                        while (ars.next()) {
                            model10.addRow(new Object[]{ars.getString("ProductionID"), ars.getString("date"), ars.getString("product_name"), ars.getDouble("quantity"), ars.getString("unit_price"), ars.getDouble("amount")});
                        }

                        //PRODUCT SUM AMOUNT
                        try {
                            String X = "SELECT sum(amount) FROM prodpriceinclusive WHERE voucher_no= '" + toucherss + "';";

                            try (PreparedStatement psX = db_Connection.getInstance().prepareStatement(X)) {
                                ars = psX.executeQuery(X);

                                if (ars.next()) {
                                    Double jansal = ars.getDouble(1);

                                    jTextField26.setText(String.valueOf(jansal));
                                }
                            }

                        } catch (Exception e) {
                            //                        e.printStackTrace();
                            JOptionPane.showMessageDialog(null, "Cannot save." + e);
                        }

                        //  PRODUCT QTY SUM
                        try {

                            String tra = "SELECT sum(quantityKGS) FROM prodpriceinclusive WHERE voucher_no= '" + toucherss + "';";

                            try (PreparedStatement psX8 = db_Connection.getInstance().prepareStatement(tra)) {
                                ars = psX8.executeQuery(tra);

                                if (ars.next()) {
                                    Double jansa = ars.getDouble(1);

                                    jTextField47.setText(String.valueOf(jansa));
                                    jTextField70.setText(String.valueOf(jansa));
                                }
                            }

                        } catch (Exception e) {
                            //                        e.printStackTrace();
                            JOptionPane.showMessageDialog(null, "Cannot save." + e);
                        }

                        //PRODUCT  ACTUAL QUANTITY PER PRODUCT
                        try {
                            String RT = "SELECT quantityKGS FROM prodpriceinclusive WHERE voucher_no= '" + toucherss + "';";

                            try (PreparedStatement psX7 = db_Connection.getInstance().prepareStatement(RT)) {
                                ars = psX7.executeQuery(RT);

                                if (ars.next()) {
                                    Double Zansal = ars.getDouble(1);

                                    jTextField50.setText(String.valueOf(Zansal));
                                }
                            }

                        } catch (Exception e) {
//                        e.printStackTrace();
                            JOptionPane.showMessageDialog(null, "Cannot save." + e);
                        }

                        //PRODUUCT QUANTITY
                        try {
                            String RTI = "SELECT quantity FROM productproduction WHERE voucher_no= '" + toucherss + "';";

                            try (PreparedStatement psX9 = db_Connection.getInstance().prepareStatement(RTI)) {
                                ars = psX9.executeQuery(RTI);

                                if (ars.next()) {
                                    Double Znsal = ars.getDouble(1);

                                    jTextField51.setText(String.valueOf(Znsal));
                                }
                            }

                        } catch (Exception e) {
                            //                        e.printStackTrace();
                            JOptionPane.showMessageDialog(null, "Cannot save." + e);
                        }

                        //CAN AMOUNT TXTFIELD
                        try {
                            String rw = "SELECT sum(can_amount) FROM package1 WHERE voucher_no= '" + toucherss + "';";

                            try (PreparedStatement psX1 = db_Connection.getInstance().prepareStatement(rw)) {
                                ars = psX1.executeQuery(rw);

                                if (ars.next()) {
                                    Double jans = ars.getDouble(1);

                                    jTextField52.setText(String.valueOf(jans));
                                }
                            }

                        } catch (Exception e) {
                            //                        e.printStackTrace();
                            JOptionPane.showMessageDialog(null, "Cannot save." + e);
                        }

                        //GROUP COMBO DISPLAY
                        try {
                            jComboBox22.removeAllItems();

                            String Tr = "SELECT * FROM productproduction where voucher_no = '" + toucherss + "';";
                            try (PreparedStatement psrwa = db_Connection.getInstance().prepareStatement(Tr)) {
                                ars = psrwa.executeQuery();

                                while (ars.next()) {
                                    jComboBox22.addItem(ars.getString("groupe"));

                                }

                                ars.close();
                                psrwa.close();

                            } catch (Exception e) {
                                //                            e.printStackTrace();
                                JOptionPane.showMessageDialog(null, "Database Error");
                            }
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null, "Error connection");
                        }

                        //LABEL AMOUNT TXTFIELD
                        try {
                            String wr = "SELECT sum(label_amount) FROM package1 WHERE voucher_no= '" + toucherss + "';";

                            try (PreparedStatement psX2 = db_Connection.getInstance().prepareStatement(wr)) {
                                ars = psX2.executeQuery(wr);

                                if (ars.next()) {
                                    Double Xans = ars.getDouble(1);

                                    jTextField53.setText(String.valueOf(Xans));
                                }
                            }

                        } catch (Exception e) {
                            //                        e.printStackTrace();
                            JOptionPane.showMessageDialog(null, "Cannot save." + e);
                        }

                        //MANPOWER AMOUNT TXTFIELD
                        try {
                            String wit = "SELECT sum(manpower_amount) FROM prodmanper WHERE voucher_no= '" + toucherss + "';";

                            try (PreparedStatement psX3 = db_Connection.getInstance().prepareStatement(wit)) {
                                ars = psX3.executeQuery(wit);

                                if (ars.next()) {
                                    Double Tans = ars.getDouble(1);

                                    jTextField54.setText(String.valueOf(Tans));
                                }
                            }

                        } catch (Exception e) {
                            //                        e.printStackTrace();
                            JOptionPane.showMessageDialog(null, "Cannot save." + e);
                        }

                        //ELECTRICITY AMOUNT TXTFIELD
                        try {
                            String wat = "SELECT electricity_amount FROM prodmanper WHERE voucher_no= '" + toucherss + "';";

                            try (PreparedStatement psX4 = db_Connection.getInstance().prepareStatement(wat)) {
                                ars = psX4.executeQuery(wat);

                                if (ars.next()) {
                                    Double tns = ars.getDouble(1);

                                    jTextField55.setText(String.valueOf(tns));
                                    jTextField28.setText(String.valueOf(tns));
                                }
                            }

                        } catch (Exception e) {
                            //                        e.printStackTrace();
                            JOptionPane.showMessageDialog(null, "Cannot save." + e);
                        }

                        //FUEL AMOUNT TXTFIELD
                        try {
                            String tiw = "SELECT fuel_amount FROM prodmanper WHERE voucher_no= '" + toucherss + "';";

                            try (PreparedStatement psX5 = db_Connection.getInstance().prepareStatement(tiw)) {
                                ars = psX5.executeQuery(tiw);

                                if (ars.next()) {
                                    Double sns = ars.getDouble(1);

                                    jTextField56.setText(String.valueOf(sns));
                                    jTextField69.setText(String.valueOf(sns));
                                }
                            }

                        } catch (Exception e) {
                            //                        e.printStackTrace();
                            JOptionPane.showMessageDialog(null, "Cannot save." + e);
                        }

                        //RAW MATERIALS
                        try {
                            DefaultTableModel model = (DefaultTableModel) jTable10.getModel();

                            try {
                                int z5 = model.getRowCount();
                                for (int lu5 = 0; lu5 <= z5; ++lu5) {
                                    model.removeRow(0);
                                }
                            } catch (Exception e) {
                            }

                            try {

                                String query4 = "SELECT * FROM rawmatpriceinc where voucher_no = '" + toucherss + "';";
                                PreparedStatement smt4 = db_Connection.getInstance().prepareStatement(query4);
                                ars = smt4.executeQuery(query4);

                                while (ars.next()) {
                                    model.addRow(new Object[]{ars.getString("raw_material"), ars.getString("unit_price"), ars.getDouble("amount")});
                                }

                                //JTEXTFIELD RAW SUM AMOUNT
                                try {

                                    String si = "SELECT sum(amount) FROM rawmatpriceinc WHERE voucher_no= '" + toucherss + "';";
                                    try (PreparedStatement psX0 = db_Connection.getInstance().prepareStatement(si)) {
                                        ars = psX0.executeQuery(si);

                                        if (ars.next()) {
                                            Double dansal = ars.getDouble(1);
                                            //                                   String Lansal=String.valueOf(dansal)

                                            jTextField29.setText(String.valueOf(dansal));
                                        }
                                    }

                                } catch (Exception e) {
                                    //                                e.printStackTrace();
                                    JOptionPane.showMessageDialog(null, "Cannot save." + e);
                                }

                                //INGREDIENT AMOUNT
                                try {

                                    String t = "SELECT sum(amount) FROM ingredpriceinc WHERE voucher_no= '" + toucherss + "';";

                                    try (PreparedStatement psX11 = db_Connection.getInstance().prepareStatement(t)) {
                                        ars = psX11.executeQuery(t);

                                        if (ars.next()) {
                                            Double pansal = ars.getDouble(1);

                                            jTextField27.setText(String.valueOf(pansal));
                                        }
                                    }

                                } catch (Exception e) {
                                    //                                e.printStackTrace();
                                    JOptionPane.showMessageDialog(null, "Cannot save." + e);
                                }  // TODO add your handling code here:
                                ars.close();
                                stmt4.close();

                            } catch (Exception e) {
                                //                            e.printStackTrace();
                                JOptionPane.showMessageDialog(null, "Error in connectivity");
                            }
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null, "Invalid Entry or field must be completely filled", "message", 2);
                        }

                    } catch (Exception e) {
                        //                    e.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Error in connectivity");
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Invalid Entry or field must be completely filled", "message", 2);
                }

            } else if (jRadioButton1.isSelected() == true) {
//            String vouch1 = (String) jTextField25.getText();
//            Integer toucherss = Integer.valueOf(vouch1);
                try {
                    DefaultTableModel model = (DefaultTableModel) jTable11.getModel();

                    try {
                        int z5 = model.getRowCount();
                        for (int lu3 = 0; lu3 <= z5; ++lu3) {
                            model.removeRow(0);
                        }
                    } catch (Exception e) {
                    }
                    try {

                        String query4 = "SELECT * FROM ingredpriceinc where date= '" + date1 + "';";

                        try (PreparedStatement stmt4 = db_Connection.getInstance().prepareStatement(query4)) {

                            ars = stmt4.executeQuery(query4);

                            while (ars.next()) {
                                model.addRow(new Object[]{ars.getString("ingredient_name"), ars.getString("ingredient_price"), ars.getDouble("amount")});
                            }
                            stmt4.close();
                            ars.close();
                        }

                    } catch (Exception e) {
                        //                    e.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Error in connectivity");
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Invalid Entry or field must be completely filled", "message", 2);
                }

//PRODUCTS
                try {
                    DefaultTableModel model = (DefaultTableModel) jTable9.getModel();

                    try {
                        int z4 = model.getRowCount();
                        for (int lu3 = 0; lu3 <= z4; ++lu3) {
                            model.removeRow(0);
                        }
                    } catch (Exception e) {
                    }
                    try {

                        String query4 = "SELECT * FROM prodpriceinclusive where date = '" + date1 + "';";
                        try (PreparedStatement stmet4 = db_Connection.getInstance().prepareStatement(query4)) {
                            ars = stmet4.executeQuery(query4);

                            while (ars.next()) {
                                model.addRow(new Object[]{ars.getString("voucher_no"), ars.getString("date"), ars.getString("product_name"), ars.getString("unit_price"), ars.getDouble("amount")});
                            }
                            ars.close();
                            stmet4.close();
                        }

                    } catch (Exception e) {
                        //                    e.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Error in connectivity");
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Invalid Entry or field must be completely filled", "message", 2);
                }

//RAW MATERIALS
                try {
                    DefaultTableModel model = (DefaultTableModel) jTable10.getModel();

                    try {
                        int z5 = model.getRowCount();
                        for (int lu5 = 0; lu5 <= z5; ++lu5) {
                            model.removeRow(0);
                        }
                    } catch (Exception e) {
                    }
                    try {

                        String query4 = "SELECT * FROM rawmatpriceinc where  date = '" + date1 + "';";
                        try (PreparedStatement stmt4 = db_Connection.getInstance().prepareStatement(query4)) {
                            ars = stmt4.executeQuery(query4);

                            while (ars.next()) {
                                model.addRow(new Object[]{ars.getString("raw_material"), ars.getString("unit_price"), ars.getDouble("amount")});
                            }

                            ars.close();
                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Error in connectivity");
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Invalid Entry or field must be completely filled", "message", 2);
                }

            } else if (jRadioButton10.isSelected() == true && jRadioButton23.isSelected() == true) {
                jTextField12.setText(null);
                jTextField74.setText(null);
                //Count AMOUNT
                try {

                    String tc = "select count(voucher_no) FROM canning.new_view where product = ? and date >= ? and date <= ?";

                    try (PreparedStatement ccmt = db_Connection.getInstance().prepareStatement(tc)) {
                        ccmt.setString(1, uua);
                        ccmt.setString(2, date5);
                        ccmt.setString(3, date6);
                        ars = ccmt.executeQuery();

                        while (ars.next()) {
                            Integer pansal = ars.getInt(1);

                            jTextField12.setText(String.valueOf(pansal));
                        }
                    }

                } catch (Exception e) {
//                e.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Cannot save." + e);
                }

                //sum AMOUNT vcr
                try {

                    String tc = "select sum(cperunit) FROM canning.new_view where product =? and date >= ? and date <= ?";

                    try (PreparedStatement psct1 = db_Connection.getInstance().prepareStatement(tc)) {
                        psct1.setString(1, uua);
                        psct1.setString(2, date5);
                        psct1.setString(3, date6);
                        ars = psct1.executeQuery();

                        if (ars.next()) {
                            Double ansal = ars.getDouble(1);

                            jTextField74.setText(String.valueOf(ansal));
                        }
                    }

                } catch (Exception e) {
//                e.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Cannot save." + e);
                }

                //costperunit table
                try {
                    DefaultTableModel modelz = (DefaultTableModel) jTable9.getModel();

                    try {
                        int z5 = modelz.getRowCount();
                        for (int lu3 = 0; lu3 <= z5; ++lu3) {
                            modelz.removeRow(0);
                        }
                    } catch (Exception e) {
                    }

                    try {

                        String uery4 = "SELECT * FROM canning.new_view where  product = ? and date >= ? and date <= ?";
                        //"SELECT * FROM canning.kgsum where product=? and date>= ? and date<=?;";
                        //SELECT * FROM canning.kgsum where  product = 'Tomato Sauce Normal 5Kg' and date >= '2017-09-03' and date <= '2017-09-22';
                        try (PreparedStatement tmt4 = db_Connection.getInstance().prepareStatement(uery4)) {
                            tmt4.setString(1, uua);
                            tmt4.setString(2, date5);
                            tmt4.setString(3, date6);

                            ars = tmt4.executeQuery();

                            while (ars.next()) {
                                //                 Double Cpu = rs.getDouble("Costperunit");
                                //                    jTextField33.setText(String.valueOf(Cpu));
                                modelz.addRow(new Object[]{ars.getInt("voucher_no"), ars.getDate("date"), ars.getString("product"), ars.getDouble("sumkgs"), ars.getDouble("cperunit")});

                            }

                            ars.close();
                        }

                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Invalid Entry or field must be completely filled", "message", 2);
//                    e.printStackTrace();
                    }

                } catch (Exception e) {
//                e.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Invalid Entry or field must be completely filled", "message", 2);
                }

                //computation average cost
                try {
                    String ad = jTextField74.getText();
                    Double sumcst = Double.valueOf(ad);
                    String ad1 = jTextField12.getText();
                    Double countcst = Double.valueOf(ad1);
                    Double countcst1 = sumcst / countcst;
                    String Avgcst = String.valueOf(countcst1);
                    jTextField33.setText(Avgcst);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Invalid Entry or field must be completely filled", "message", 2);
//                e.printStackTrace();
                }
            
        }else if (jRadioButton10.isSelected() == true && jRadioButton23.isSelected() == false) {
                jTextField12.setText(null);
                jTextField74.setText(null);
                //Count AMOUNT
                try {

                    String tc = "select count(voucher_no) FROM canning.new_view where date >= ? and date <= ?";

                    try (PreparedStatement ccmt = db_Connection.getInstance().prepareStatement(tc)) {
                        
                        ccmt.setString(1, date5);
                        ccmt.setString(2, date6);
                        ars = ccmt.executeQuery();

                        while (ars.next()) {
                            Integer pansal = ars.getInt(1);

                            jTextField12.setText(String.valueOf(pansal));
                        }
                    }

                } catch (Exception e) {
//                e.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Cannot save." + e);
                }

                //sum AMOUNT vcr
                try {

                    String tc = "select sum(cperunit) FROM canning.new_view where date >= ? and date <= ?";

                    try (PreparedStatement psct1 = db_Connection.getInstance().prepareStatement(tc)) {
                         
                        psct1.setString(1, date5);
                        psct1.setString(2, date6);
                        ars = psct1.executeQuery();

                        if (ars.next()) {
                            Double ansal = ars.getDouble(1);

                            jTextField74.setText(String.valueOf(ansal));
                        }
                    }

                } catch (Exception e) {
//                e.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Cannot save." + e);
                }

                //costperunit table
                try {
                    DefaultTableModel modelz = (DefaultTableModel) jTable9.getModel();

                    try {
                        int z5 = modelz.getRowCount();
                        for (int lu3 = 0; lu3 <= z5; ++lu3) {
                            modelz.removeRow(0);
                        }
                    } catch (Exception e) {
                    }

                    try {

                        String uery4 = "SELECT * FROM canning.new_view where date >= ? and date <= ?";
                        //"SELECT * FROM canning.kgsum where product=? and date>= ? and date<=?;";
                        //SELECT * FROM canning.kgsum where  product = 'Tomato Sauce Normal 5Kg' and date >= '2017-09-03' and date <= '2017-09-22';
                        try (PreparedStatement tmt4 = db_Connection.getInstance().prepareStatement(uery4)) {
                             
                            tmt4.setString(1, date5);
                            tmt4.setString(2, date6);

                            ars = tmt4.executeQuery();

                            while (ars.next()) {
                                //                 Double Cpu = rs.getDouble("Costperunit");
                                //                    jTextField33.setText(String.valueOf(Cpu));
                                modelz.addRow(new Object[]{ars.getInt("voucher_no"), ars.getDate("date"), ars.getString("product"), ars.getDouble("sumkgs"), ars.getDouble("cperunit")});

                            }

                            ars.close();
                        }

                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Invalid Entry or field must be completely filled", "message", 2);
//                    e.printStackTrace();
                    }

                } catch (Exception e) {
//                e.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Invalid Entry or field must be completely filled", "message", 2);
                }

                //computation average cost
                try {
                    String ad = jTextField74.getText();
                    Double sumcst = Double.valueOf(ad);
                    String ad1 = jTextField12.getText();
                    Double countcst = Double.valueOf(ad1);
                    Double countcst1 = sumcst / countcst;
                    String Avgcst = String.valueOf(countcst1);
                    jTextField33.setText(Avgcst);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Invalid Entry or field must be completely filled", "message", 2);
//                e.printStackTrace();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Please choose an option!");

            }

            // TODO add your handling code here:
        } else {
            if (jRadioButton2.isSelected() == true) {
                String vouch1 = (String) jTextField25.getText();
                Integer toucherss = Integer.valueOf(vouch1);

                ///INGREDIENTS DISPL
                try {
                    DefaultTableModel model = (DefaultTableModel) jTable11.getModel();

                    try {
                        int z5 = model.getRowCount();
                        for (int lu3 = 0; lu3 <= z5; ++lu3) {
                            model.removeRow(0);
                        }
                    } catch (Exception e) {
                    }
                    try {

                        String query4 = "SELECT * FROM ingredpriceinc where voucher_no = '" + toucherss + "' and factory= '" + Factory + "';";
                        try (PreparedStatement stmt4 = db_Connection.getInstance().prepareStatement(query4)) {
                            ars = stmt4.executeQuery(query4);

                            while (ars.next()) {
                                model.addRow(new Object[]{ars.getString("ingredient_name"), ars.getString("ingredient_price"), ars.getDouble("amount")});
                            }

                            ars.close();
                        }

                    } catch (Exception e) {
//                    e.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Error in connectivity");
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Invalid Entry or field must be completely filled", "message", 2);
                }

                //PRODUCTS
                try {
                    DefaultTableModel model10 = (DefaultTableModel) jTable9.getModel();

                    try {
                        int z4 = model10.getRowCount();
                        for (int lu3 = 0; lu3 <= z4; ++lu3) {
                            model10.removeRow(0);

                        }
                    } catch (Exception e) {
                    }
                    try {

                        String quer = "SELECT * FROM prodpriceinclusive where voucher_no = '" + toucherss + "' and factory= '" + Factory + "';";
                        PreparedStatement stmt4 = db_Connection.getInstance().prepareStatement(quer);
                        ars = stmt4.executeQuery(quer);

                        while (ars.next()) {
                            model10.addRow(new Object[]{ars.getString("ProductionID"), ars.getString("date"), ars.getString("product_name"), ars.getDouble("quantity"), ars.getString("unit_price"), ars.getDouble("amount")});
                        }

                        //PRODUCT SUM AMOUNT
                        try {
                            String X = "SELECT sum(amount) FROM prodpriceinclusive WHERE voucher_no= '" + toucherss + "' and factory= '" + Factory + "';";

                            try (PreparedStatement psX = db_Connection.getInstance().prepareStatement(X)) {
                                ars = psX.executeQuery(X);

                                if (ars.next()) {
                                    Double jansal = ars.getDouble(1);

                                    jTextField26.setText(String.valueOf(jansal));
                                }
                            }

                        } catch (Exception e) {
                            //                        e.printStackTrace();
                            JOptionPane.showMessageDialog(null, "Cannot save." + e);
                        }

                        //  PRODUCT QTY SUM
                        try {

                            String tra = "SELECT sum(quantityKGS) FROM prodpriceinclusive WHERE voucher_no= '" + toucherss + "' and factory= '" + Factory + "';";

                            try (PreparedStatement psX8 = db_Connection.getInstance().prepareStatement(tra)) {
                                ars = psX8.executeQuery(tra);

                                if (ars.next()) {
                                    Double jansa = ars.getDouble(1);

                                    jTextField47.setText(String.valueOf(jansa));
                                    jTextField70.setText(String.valueOf(jansa));
                                }
                            }

                        } catch (Exception e) {
                            //                        e.printStackTrace();
                            JOptionPane.showMessageDialog(null, "Cannot save." + e);
                        }

                        //PRODUCT  ACTUAL QUANTITY PER PRODUCT
                        try {
                            String RT = "SELECT quantityKGS FROM prodpriceinclusive WHERE voucher_no= '" + toucherss + "' and factory= '" + Factory + "';";

                            try (PreparedStatement psX7 = db_Connection.getInstance().prepareStatement(RT)) {
                                ars = psX7.executeQuery(RT);

                                if (ars.next()) {
                                    Double Zansal = ars.getDouble(1);

                                    jTextField50.setText(String.valueOf(Zansal));
                                }
                            }

                        } catch (Exception e) {
//                        e.printStackTrace();
                            JOptionPane.showMessageDialog(null, "Cannot save." + e);
                        }

                        //PRODUUCT QUANTITY
                        try {
                            String RTI = "SELECT quantity FROM productproduction WHERE voucher_no= '" + toucherss + "' and factory= '" + Factory + "';";

                            try (PreparedStatement psX9 = db_Connection.getInstance().prepareStatement(RTI)) {
                                ars = psX9.executeQuery(RTI);

                                if (ars.next()) {
                                    Double Znsal = ars.getDouble(1);

                                    jTextField51.setText(String.valueOf(Znsal));
                                }
                            }

                        } catch (Exception e) {
                            //                        e.printStackTrace();
                            JOptionPane.showMessageDialog(null, "Cannot save." + e);
                        }

                        //CAN AMOUNT TXTFIELD
                        try {
                            String rw = "SELECT sum(can_amount) FROM package1 WHERE voucher_no= '" + toucherss + "' ;";

                            try (PreparedStatement psX1 = db_Connection.getInstance().prepareStatement(rw)) {
                                ars = psX1.executeQuery(rw);

                                if (ars.next()) {
                                    Double jans = ars.getDouble(1);

                                    jTextField52.setText(String.valueOf(jans));
                                }
                            }

                        } catch (Exception e) {
                            //                        e.printStackTrace();
                            JOptionPane.showMessageDialog(null, "Cannot save." + e);
                        }

                        //GROUP COMBO DISPLAY
                        try {
                            jComboBox22.removeAllItems();

                            String Tr = "SELECT * FROM productproduction where voucher_no = '" + toucherss + "';";
                            try (PreparedStatement psrwa = db_Connection.getInstance().prepareStatement(Tr)) {
                                ars = psrwa.executeQuery();

                                while (ars.next()) {
                                    jComboBox22.addItem(ars.getString("groupe"));

                                }

                                ars.close();
                                psrwa.close();

                            } catch (Exception e) {
                                //                            e.printStackTrace();
                                JOptionPane.showMessageDialog(null, "Database Error");
                            }
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null, "Error connection");
                        }

                        //LABEL AMOUNT TXTFIELD
                        try {
                            String wr = "SELECT sum(label_amount) FROM package1 WHERE voucher_no= '" + toucherss + "';";

                            try (PreparedStatement psX2 = db_Connection.getInstance().prepareStatement(wr)) {
                                ars = psX2.executeQuery(wr);

                                if (ars.next()) {
                                    Double Xans = ars.getDouble(1);

                                    jTextField53.setText(String.valueOf(Xans));
                                }
                            }

                        } catch (Exception e) {
                            //                        e.printStackTrace();
                            JOptionPane.showMessageDialog(null, "Cannot save." + e);
                        }

                        //MANPOWER AMOUNT TXTFIELD
                        try {
                            String wit = "SELECT sum(manpower_amount) FROM prodmanper WHERE voucher_no= '" + toucherss + "' and factory= '" + Factory + "';";

                            try (PreparedStatement psX3 = db_Connection.getInstance().prepareStatement(wit)) {
                                ars = psX3.executeQuery(wit);

                                if (ars.next()) {
                                    Double Tans = ars.getDouble(1);

                                    jTextField54.setText(String.valueOf(Tans));
                                }
                            }

                        } catch (Exception e) {
                            //                        e.printStackTrace();
                            JOptionPane.showMessageDialog(null, "Cannot save." + e);
                        }

                        //ELECTRICITY AMOUNT TXTFIELD
                        try {
                            String wat = "SELECT electricity_amount FROM prodmanper WHERE voucher_no= '" + toucherss + "' and factory= '" + Factory + "';";

                            try (PreparedStatement psX4 = db_Connection.getInstance().prepareStatement(wat)) {
                                ars = psX4.executeQuery(wat);

                                if (ars.next()) {
                                    Double tns = ars.getDouble(1);

                                    jTextField55.setText(String.valueOf(tns));
                                    jTextField28.setText(String.valueOf(tns));
                                }
                            }

                        } catch (Exception e) {
                            //                        e.printStackTrace();
                            JOptionPane.showMessageDialog(null, "Cannot save." + e);
                        }

                        //FUEL AMOUNT TXTFIELD
                        try {
                            String tiw = "SELECT fuel_amount FROM prodmanper WHERE voucher_no= '" + toucherss + "' and factory= '" + Factory + "';";

                            try (PreparedStatement psX5 = db_Connection.getInstance().prepareStatement(tiw)) {
                                ars = psX5.executeQuery(tiw);

                                if (ars.next()) {
                                    Double sns = ars.getDouble(1);

                                    jTextField56.setText(String.valueOf(sns));
                                    jTextField69.setText(String.valueOf(sns));
                                }
                            }

                        } catch (Exception e) {
                            //                        e.printStackTrace();
                            JOptionPane.showMessageDialog(null, "Cannot save." + e);
                        }

                        //RAW MATERIALS
                        try {
                            DefaultTableModel model = (DefaultTableModel) jTable10.getModel();

                            try {
                                int z5 = model.getRowCount();
                                for (int lu5 = 0; lu5 <= z5; ++lu5) {
                                    model.removeRow(0);
                                }
                            } catch (Exception e) {
                            }

                            try {

                                String query4 = "SELECT * FROM rawmatpriceinc where voucher_no = '" + toucherss + "' and factory= '" + Factory + "';";
                                PreparedStatement smt4 = db_Connection.getInstance().prepareStatement(query4);
                                ars = smt4.executeQuery(query4);

                                while (ars.next()) {
                                    model.addRow(new Object[]{ars.getString("raw_material"), ars.getString("rawmaterialprice"), ars.getDouble("amount")});
                                }

                                //JTEXTFIELD RAW SUM AMOUNT
                                try {

                                    String si = "SELECT sum(amount) FROM rawmatpriceinc WHERE voucher_no= '" + toucherss + "' and factory= '" + Factory + "';";
                                    try (PreparedStatement psX0 = db_Connection.getInstance().prepareStatement(si)) {
                                        ars = psX0.executeQuery(si);

                                        if (ars.next()) {
                                            Double dansal = ars.getDouble(1);
                                            //                                   String Lansal=String.valueOf(dansal)

                                            jTextField29.setText(String.valueOf(dansal));
                                        }
                                    }

                                } catch (Exception e) {
                                    //                                e.printStackTrace();
                                    JOptionPane.showMessageDialog(null, "Cannot save." + e);
                                }

                                //INGREDIENT AMOUNT
                                try {

                                    String t = "SELECT sum(amount) FROM ingredpriceinc WHERE voucher_no= '" + toucherss + "' and factory= '" + Factory + "';";

                                    try (PreparedStatement psX11 = db_Connection.getInstance().prepareStatement(t)) {
                                        ars = psX11.executeQuery(t);

                                        if (ars.next()) {
                                            Double pansal = ars.getDouble(1);

                                            jTextField27.setText(String.valueOf(pansal));
                                        }
                                    }

                                } catch (Exception e) {
                                    //                                e.printStackTrace();
                                    JOptionPane.showMessageDialog(null, "Cannot save." + e);
                                }  // TODO add your handling code here:
                                ars.close();
                                stmt4.close();

                            } catch (Exception e) {
                                //                            e.printStackTrace();
                                JOptionPane.showMessageDialog(null, "Error in connectivity");
                            }
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null, "Invalid Entry or field must be completely filled", "message", 2);
                        }

                    } catch (Exception e) {
                        //                    e.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Error in connectivity");
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Invalid Entry or field must be completely filled", "message", 2);
                }

            } else if (jRadioButton1.isSelected() == true) {
//            String vouch1 = (String) jTextField25.getText();
//            Integer toucherss = Integer.valueOf(vouch1);
                try {
                    DefaultTableModel model = (DefaultTableModel) jTable11.getModel();

                    try {
                        int z5 = model.getRowCount();
                        for (int lu3 = 0; lu3 <= z5; ++lu3) {
                            model.removeRow(0);
                        }
                    } catch (Exception e) {
                    }
                    try {

                        String query4 = "SELECT * FROM ingredpriceinc where date= '" + date1 + "' and factory= '" + Factory + "';";

                        try (PreparedStatement stmt4 = db_Connection.getInstance().prepareStatement(query4)) {

                            ars = stmt4.executeQuery(query4);

                            while (ars.next()) {
                                model.addRow(new Object[]{ars.getString("ingredient_name"), ars.getString("ingredient_price"), ars.getDouble("amount")});
                            }
                            stmt4.close();
                            ars.close();
                        }

                    } catch (Exception e) {
                        //                    e.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Error in connectivity");
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Invalid Entry or field must be completely filled", "message", 2);
                }

//PRODUCTS
                try {
                    DefaultTableModel model = (DefaultTableModel) jTable9.getModel();

                    try {
                        int z4 = model.getRowCount();
                        for (int lu3 = 0; lu3 <= z4; ++lu3) {
                            model.removeRow(0);
                        }
                    } catch (Exception e) {
                    }
                    try {

                        String query4 = "SELECT * FROM prodpriceinclusive where date = '" + date1 + "' and factory= '" + Factory + "';";
                        try (PreparedStatement stmet4 = db_Connection.getInstance().prepareStatement(query4)) {
                            ars = stmet4.executeQuery(query4);

                            while (ars.next()) {
                                model.addRow(new Object[]{ars.getString("voucher_no"), ars.getString("date"), ars.getString("product_name"), ars.getString("unit_price"), ars.getDouble("amount")});
                            }
                            ars.close();
                            stmet4.close();
                        }

                    } catch (Exception e) {
                        //                    e.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Error in connectivity");
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Invalid Entry or field must be completely filled", "message", 2);
                }

//RAW MATERIALS
                try {
                    DefaultTableModel model = (DefaultTableModel) jTable10.getModel();

                    try {
                        int z5 = model.getRowCount();
                        for (int lu5 = 0; lu5 <= z5; ++lu5) {
                            model.removeRow(0);
                        }
                    } catch (Exception e) {
                    }
                    try {

                        String query4 = "SELECT * FROM rawmatpriceinc where  date = '" + date1 + "' and factory= '" + Factory + "';";
                        try (PreparedStatement stmt4 = db_Connection.getInstance().prepareStatement(query4)) {
                            ars = stmt4.executeQuery(query4);

                            while (ars.next()) {
                                model.addRow(new Object[]{ars.getString("raw_material"), ars.getString("rawmaterialprice"), ars.getDouble("amount")});
                            }

                            ars.close();
                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Error in connectivity");
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Invalid Entry or field must be completely filled", "message", 2);
                }

            } else if (jRadioButton10.isSelected() == true && jRadioButton23.isSelected() == false) {
                jTextField12.setText(null);
                jTextField74.setText(null);
                //Count AMOUNT
                try {

                    String tc = "select count(voucher_no) FROM canning.new_view where factory = ? and date >= ? and date <= ?";

                    try (PreparedStatement ccmt = db_Connection.getInstance().prepareStatement(tc)) {
                        ccmt.setString(1, Factory);
                        ccmt.setString(2, date5);
                        ccmt.setString(3, date6);
                          
                        ars = ccmt.executeQuery();

                        while (ars.next()) {
                            Integer pansal = ars.getInt(1);

                            jTextField12.setText(String.valueOf(pansal));
                        }
                    }

                } catch (Exception e) {
//                e.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Cannot save." + e);
                }

                //sum AMOUNT vcr
                try {

                    String tc = "select sum(cperunit) FROM canning.new_view where factory =? and date >= ? and date <= ?";

                    try (PreparedStatement psct1 = db_Connection.getInstance().prepareStatement(tc)) {
                        psct1.setString(1, Factory);
                        psct1.setString(2, date5);
                        psct1.setString(3, date6);
             
                        ars = psct1.executeQuery();

                        if (ars.next()) {
                            Double ansal = ars.getDouble(1);

                            jTextField74.setText(String.valueOf(ansal));
                        }
                    }

                } catch (Exception e) {
//                e.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Cannot save." + e);
                }

                //costperunit table
                try {
                    DefaultTableModel modelz = (DefaultTableModel) jTable9.getModel();

                    try {
                        int z5 = modelz.getRowCount();
                        for (int lu3 = 0; lu3 <= z5; ++lu3) {
                            modelz.removeRow(0);
                        }
                    } catch (Exception e) {
                    }

                    try {

                        String uery4 = "SELECT * FROM canning.new_view where  factory = ? and date >= ? and date <= ?";
                        //"SELECT * FROM canning.kgsum where product=? and date>= ? and date<=?;";
                        //SELECT * FROM canning.kgsum where  product = 'Tomato Sauce Normal 5Kg' and date >= '2017-09-03' and date <= '2017-09-22';
                        try (PreparedStatement tmt4 = db_Connection.getInstance().prepareStatement(uery4)) {
                            tmt4.setString(1, Factory);
                            tmt4.setString(2, date5);
                            tmt4.setString(3, date6);
                            

                            ars = tmt4.executeQuery();

                            while (ars.next()) {
                                //                 Double Cpu = rs.getDouble("Costperunit");
                                //                    jTextField33.setText(String.valueOf(Cpu));
                                modelz.addRow(new Object[]{ars.getInt("voucher_no"), ars.getDate("date"), ars.getString("product"), ars.getDouble("sumkgs"), ars.getDouble("cperunit")});

                            }

                            ars.close();
                        }

                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Invalid Entry or field must be completely filled", "message", 2);
//                    e.printStackTrace();
                    }

                } catch (Exception e) {
//                e.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Invalid Entry or field must be completely filled", "message", 2);
                }

                //computation average cost
                try {
                    String ad = jTextField74.getText();
                    Double sumcst = Double.valueOf(ad);
                    String ad1 = jTextField12.getText();
                    Double countcst = Double.valueOf(ad1);
                    Double countcst1 = sumcst / countcst;
                    String Avgcst = String.valueOf(countcst1);
                    jTextField33.setText(Avgcst);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Invalid Entry or field must be completely filled", "message", 2);
//                e.printStackTrace();
                }
                
            } else if (jRadioButton10.isSelected() == true && jRadioButton23.isSelected() == true) {
              
                jTextField12.setText(null);
                jTextField74.setText(null);
                //Count AMOUNT
                try {

                    String tc = "select count(voucher_no) FROM canning.new_view where product = ? and date >= ? and date <= ? and factory = ?";

                    try (PreparedStatement ccmt = db_Connection.getInstance().prepareStatement(tc)) {
                        ccmt.setString(1, uua);
                        ccmt.setString(2, date5);
                        ccmt.setString(3, date6);
                        ccmt.setString(4, Factory);
                        ars = ccmt.executeQuery();

                        while (ars.next()) {
                            Integer pansal = ars.getInt(1);

                            jTextField12.setText(String.valueOf(pansal));
                        }
                    }

                } catch (Exception e) {
//                e.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Cannot save." + e);
                }

                //sum AMOUNT vcr
                try {

                    String tc = "select sum(cperunit) FROM canning.new_view where product =? and date >= ? and date <= ? and factory = ?";

                    try (PreparedStatement psct1 = db_Connection.getInstance().prepareStatement(tc)) {
                        psct1.setString(1, uua);
                        psct1.setString(2, date5);
                        psct1.setString(3, date6);
                        psct1.setString(4, Factory);
                        ars = psct1.executeQuery();

                        if (ars.next()) {
                            Double ansal = ars.getDouble(1);

                            jTextField74.setText(String.valueOf(ansal));
                        }
                    }

                } catch (Exception e) {
//                e.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Cannot save." + e);
                }

                //costperunit table
                try {
                    DefaultTableModel modelz = (DefaultTableModel) jTable9.getModel();

                    try {
                        int z5 = modelz.getRowCount();
                        for (int lu3 = 0; lu3 <= z5; ++lu3) {
                            modelz.removeRow(0);
                        }
                    } catch (Exception e) {
                    }

                    try {

                        String uery4 = "SELECT * FROM canning.new_view where  product = ? and date >= ? and date <= ? and factory = ?";
                        //"SELECT * FROM canning.kgsum where product=? and date>= ? and date<=?;";
                        //SELECT * FROM canning.kgsum where  product = 'Tomato Sauce Normal 5Kg' and date >= '2017-09-03' and date <= '2017-09-22';
                        try (PreparedStatement tmt4 = db_Connection.getInstance().prepareStatement(uery4)) {
                            tmt4.setString(1, uua);
                            tmt4.setString(2, date5);
                            tmt4.setString(3, date6);
                            tmt4.setString(4, Factory);
                            ars = tmt4.executeQuery();

                            while (ars.next()) {
                                //                 Double Cpu = rs.getDouble("Costperunit");
                                //                    jTextField33.setText(String.valueOf(Cpu));
                                modelz.addRow(new Object[]{ars.getInt("voucher_no"), ars.getDate("date"), ars.getString("product"), ars.getDouble("sumkgs"), ars.getDouble("cperunit")});

                            }

                            ars.close();
                        }

                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Invalid Entry or field must be completely filled", "message", 2);
//                    e.printStackTrace();
                    }

                } catch (Exception e) {
//                e.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Invalid Entry or field must be completely filled", "message", 2);
                }

                //computation average cost
                try {
                    String ad = jTextField74.getText();
                    Double sumcst = Double.valueOf(ad);
                    String ad1 = jTextField12.getText();
                    Double countcst = Double.valueOf(ad1);
                    Double countcst1 = sumcst / countcst;
                    String Avgcst = String.valueOf(countcst1);
                    jTextField33.setText(Avgcst);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Invalid Entry or field must be completely filled", "message", 2);
//                e.printStackTrace();
                }           

                
                
            } else {
                JOptionPane.showMessageDialog(null, "Please choose an option!");

            }

            // TODO add your handling code here:
        }
    }
}
