/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.canning.events.table;

import java.sql.Connection;
import java.awt.HeadlessException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import newpackage1.NewJFrame;
import static newpackage1.NewJFrame.jDate2;
import static newpackage1.NewJFrame.jRadioButton20;
import static newpackage1.NewJFrame.jRadioButton8;
import static newpackage1.NewJFrame.jTable5;
import static newpackage1.NewJFrame.jTable6;
import static newpackage1.NewJFrame.jTable7;
import static newpackage1.NewJFrame.jTable8;
import static newpackage1.NewJFrame.jTextArea2;
import static newpackage1.NewJFrame.jTextField138;
import static newpackage1.NewJFrame.jTextField40;
import static newpackage1.NewJFrame.jTextField41;
import static newpackage1.NewJFrame.jTextField42;
import static newpackage1.NewJFrame.jTextField89;
import static newpackage1.NewJFrame.jTextField9;
import static newpackage1.NewJFrame.jTextLogin;
import newpackage1.db_Connection;

/**
 *
 * @author Stevoski
 */
public class table5Clickevent {
    public static void table5Click() throws HeadlessException {
        String accesse = jTextLogin.getText();
        ResultSet rs=null;
        String dated1 = ((JTextField) jDate2.getDateEditor().getUiComponent()).getText();
        String jTable5no21;
        String jTable5remarks1;
        jTextField89.setText(null);
        try {
            
            int jTable5row = jTable5.getSelectedRow();
            String jTable5tableclick = (jTable5.getModel().getValueAt(jTable5row, 0).toString());
            jTextField89.setText(jTable5tableclick);
//            String jTable5tableclicker = (jTable5.getModel().getValueAt(jTable5row, 0).toString());


Connection jTable5conclikk =  (Connection) db_Connection.getInstance();

String jTable5clik = "select * from prodpriceinclusive where ProductionID='" + jTable5tableclick + "' ";
PreparedStatement jTable5psclikk = jTable5conclikk.prepareStatement(jTable5clik);

rs = jTable5psclikk.executeQuery();

if (rs.next()) {
    if (jRadioButton8.isSelected() == true) {
        String jTable5vouchered1 = (String) jTextField9.getText();
        Integer jTable5vouchers1 = Integer.valueOf(jTable5vouchered1);
        try {
             
            Connection jTable5con1v41 = (Connection) db_Connection.getInstance();
            
            try {
                String t = "SELECT * FROM production where voucher_no = '" + jTable5vouchers1 + "';";
                PreparedStatement ps3 = jTable5con1v41.prepareStatement(t);
                rs = ps3.executeQuery(t);
                
                if (rs.next()) {
                    
                    jTable5remarks1 = rs.getString("remarks");
                    jTable5no21 = jTable5remarks1;
                    jTextArea2.setText(String.valueOf(jTable5no21));
                }
                
                //PRODUCTS TEXTFIELD,AMOUNT
                try {
                    String tia1 = "SELECT sum(quantity) FROM prodpriceinclusive WHERE voucher_no= '" + jTable5vouchers1 + "' and  ProductionID='" + jTable5tableclick + "' ;";
                    
                    PreparedStatement jTable5ps1231 = jTable5con1v41.prepareStatement(t);
                    rs = jTable5ps1231.executeQuery(tia1);
                    
                    if (rs.next()) {
                        Double xansal1 = rs.getDouble(1);
                        
                        jTextField40.setText(String.valueOf(xansal1));
                    }
                    
                    //DISPLAY RAW TEXTFIELD
                    try {
                    
                        Connection jTable5con1802 =(Connection) db_Connection.getInstance();
//                Statement stmt4 = con18.createStatement();

try {
    String jTable5ti23 = "SELECT sum(qty) FROM rawmatpriceinc WHERE voucher_no= '" + jTable5vouchers1 + "' and  ProductionID='" + jTable5tableclick + "' ;";
    
    PreparedStatement jTable5psc = jTable5con1802.prepareStatement(t);
    rs = jTable5psc.executeQuery(jTable5ti23);
    
    if (rs.next()) {
        Double kansal2 = rs.getDouble(1);
        
        jTextField41.setText(String.valueOf(kansal2));
    }
    jTable5psc.close();
} catch (Exception e) {
//                                e.printStackTrace();
JOptionPane.showMessageDialog(null, "Cannot save." + e);
}
 
                    } catch (Exception e) {
//                                e.printStackTrace();
JOptionPane.showMessageDialog(null, "Cannot save." + e);
}
                    
                    //DISPLAY INGRED TEXTFIELD
                    try {
                       
                        Connection jTable5con2702 = (Connection) db_Connection.getInstance();
                        
                        try {
                            String jTable5tou2 = "SELECT sum(ingredient_qty) FROM ingredpriceinc WHERE voucher_no= '" + jTable5vouchers1 + "' and  ProductionID='" + jTable5tableclick + "' ;";
                            
                            PreparedStatement jTable5psc2 = jTable5con2702.prepareStatement(jTable5tou2);
                            rs = jTable5psc2.executeQuery(jTable5tou2);
                            
                            if (rs.next()) {
                                Double kansal3 = rs.getDouble(1);
                                
                                jTextField42.setText(String.valueOf(kansal3));
                            }
                            jTable5psc2.close();
                        } catch (Exception e) {
//                                e.printStackTrace();
JOptionPane.showMessageDialog(null, "Cannot save." + e);
                        }
                        
                    } catch (Exception e) {
//                        e.printStackTrace();
JOptionPane.showMessageDialog(null, "Cannot save." + e);
                }
                    jTable5ps1231.close();
                } catch (Exception e) {
//                        e.printStackTrace();
JOptionPane.showMessageDialog(null, "Cannot save." + e);
                }
               ps3.close();
            } catch (Exception e) {
//                    e.printStackTrace();
JOptionPane.showMessageDialog(null, "Cannot save." + e);
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Invalid Entry or field must be completely filled", "message", 2);
        }
        
        try {
            DefaultTableModel jTable5model5 = (DefaultTableModel) jTable7.getModel();
            int jTable5mg3 = Integer.parseInt(jTextField9.getText());
            
            try {
                int jTable5z3 = jTable5model5.getRowCount();
                for (int lu3 = 0; lu3 <= jTable5z3; ++lu3) {
                    jTable5model5.removeRow(0);
                }
            } catch (Exception e) {
            }
            try {
                
                 
                Connection jTable5con1445 = (Connection) db_Connection.getInstance();
                Statement jTable5stmt45 = jTable5con1445.createStatement();
                String query45 = "SELECT * FROM ingredpriceinc where voucher_no = '" + jTable5mg3 + "' and  ProductionID='" + jTable5tableclick + "' ;";
                rs = jTable5stmt45.executeQuery(query45);
                
                while (rs.next()) {
                    jTable5model5.addRow(new Object[]{rs.getString("ingredient_name"), rs.getString("ingredient_qty")});
                }
                rs.close();
                jTable5stmt45.close();
                 
                
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error in connectivity");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Invalid Entry or field must be completely filled", "message", 2);
        }
        
        try {
            DefaultTableModel jTable5model6 = (DefaultTableModel) jTable6.getModel();
            int jTable5mg2 = Integer.parseInt(jTextField9.getText());
            
            try {
                int jTable5z2 = jTable5model6.getRowCount();
                for (int lu2 = 0; lu2 <= jTable5z2; ++lu2) {
                    jTable5model6.removeRow(0);
                }
            } catch (Exception e) {
            }
            try {
                
                
                Connection jTable5con1456 =(Connection) db_Connection.getInstance();
                Statement jTable5stmt46 = jTable5con1456.createStatement();
                String jTable5query46 = "SELECT * FROM raw_materialproduction where voucher_no = '" + jTable5mg2 + "' and  ProductionID='" + jTable5tableclick + "' ;";
                rs = jTable5stmt46.executeQuery(jTable5query46);
                
                while (rs.next()) {
                    jTable5model6.addRow(new Object[]{rs.getString("raw_material"), rs.getString("qty")});
                }
                
                rs.close();
                jTable5stmt46.close();
               
                
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error in connectivity");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Invalid Entry or field must be completely filled", "message", 2);
        }
        
        try {
            DefaultTableModel jTable5model7 = (DefaultTableModel) jTable5.getModel();
            int jTable5mg1 = Integer.parseInt(jTextField9.getText());
            
            try {
                int z1 = jTable5model7.getRowCount();
                for (int lu1 = 0; lu1 <= z1; ++lu1) {
                    jTable5model7.removeRow(0);
                }
            } catch (Exception e) {
            }
            try {
                
                 
                Connection jTable5con1467 = (Connection) db_Connection.getInstance();
                Statement jTable5stmt47 = jTable5con1467.createStatement();
                String jTable5query47 = "SELECT * FROM productproduction where voucher_no = '" + jTable5mg1 + "' and  ProductionID='" + jTable5tableclick + "' ;";
                rs = jTable5stmt47.executeQuery(jTable5query47);
                
                while (rs.next()) {
                    jTable5model7.addRow(new Object[]{rs.getString("ProductionID"), rs.getString("product_name"), rs.getString("quantity"), rs.getString("waste")});
                }
                
                rs.close();
                jTable5stmt47.close();
               
                
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error in connectivity");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Invalid Entry or field must be completely filled", "message", 2);
        }
        
        try {
            DefaultTableModel jTable5model8 = (DefaultTableModel) jTable8.getModel();
            int jTable5mg = Integer.parseInt(jTextField9.getText());
            
            try {
                int zz = jTable5model8.getRowCount();
                for (int lu = 0; lu <= zz; ++lu) {
                    jTable5model8.removeRow(0);
                }
            } catch (Exception e) {
            }
            try {
                
              
                Connection jTable5con1478 = (Connection) db_Connection.getInstance();
                Statement jTable5stmt48 = jTable5con1478.createStatement();
                String jTable5query48 = "SELECT * FROM costingprodn where voucher_no = '" + jTable5mg + "' and  production_id='" + jTable5tableclick + "' ;";
                rs = jTable5stmt48.executeQuery(jTable5query48);
                
                while (rs.next()) {
                    jTable5model8.addRow(new Object[]{rs.getString("voucher_no"), rs.getInt("production_id"), rs.getString("date"), rs.getString("factory"), rs.getString("fuel"), rs.getString("manpower"), rs.getString("electricity"), rs.getString("can_name"), rs.getString("no_of_cans"), rs.getString("label_name"), rs.getString("no_of_labels")});
                }
                
                rs.close();
                jTable5stmt48.close();
                 
                
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error in connectivity");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Invalid Entry or field must be completely filled", "message", 2);
        }
        
    } else if (jRadioButton20.isSelected() == true) {
        String jTable5vouchered1 = (String) jTextField138.getText();
        Integer jTable5vouchers1 = Integer.valueOf(jTable5vouchered1);
        try {
             
            Connection jTable5con1v41 = (Connection) db_Connection.getInstance();
            
            try {
                String t = "SELECT * FROM production where voucher_no = '" + jTable5vouchers1 + "';";
                PreparedStatement ps3 = jTable5con1v41.prepareStatement(t);
                rs = ps3.executeQuery(t);
                
                if (rs.next()) {
                    
                    jTable5remarks1 = rs.getString("remarks");
                    jTable5no21 = jTable5remarks1;
                    jTextArea2.setText(String.valueOf(jTable5no21));
                }
                ps3.close();
                //PRODUCTS TEXTFIELD,AMOUNT
                try {
                    String tia1 = "SELECT sum(quantity) FROM prodpriceinclusive WHERE voucher_no= '" + jTable5vouchers1 + "' and  ProductionID='" + jTable5tableclick + "' ;";
                    
                    PreparedStatement jTable5ps1231 = jTable5con1v41.prepareStatement(t);
                    rs = jTable5ps1231.executeQuery(tia1);
                    
                    if (rs.next()) {
                        Double xansal1 = rs.getDouble(1);
                        
                        jTextField40.setText(String.valueOf(xansal1));
                    }
                    jTable5ps1231.close();
                    //DISPLAY RAW TEXTFIELD
                    try {

Connection jTable5con1802 = (Connection) db_Connection.getInstance();

try {
    String jTable5ti23 = "SELECT sum(qty) FROM rawmatpriceinc WHERE voucher_no= '" + jTable5vouchers1 + "' and  ProductionID='" + jTable5tableclick + "' ;";
    
    PreparedStatement jTable5psc = jTable5con1802.prepareStatement(t);
    rs = jTable5psc.executeQuery(jTable5ti23);
    
    if (rs.next()) {
        Double kansal2 = rs.getDouble(1);
        
        jTextField41.setText(String.valueOf(kansal2));
    }
    jTable5psc.close();
//    (Connection) db_Connection.getInstance();
} catch (Exception e) {
//                                e.printStackTrace();
JOptionPane.showMessageDialog(null, "Cannot save." + e);
}

                    } catch (Exception e) {
                        Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, e);
                    }
                    
                    //DISPLAY INGRED TEXTFIELD
                    try {
                        
                        Connection jTable5con2702 =  (Connection) db_Connection.getInstance();
                        
                        try {
                            String jTable5tou2 = "SELECT sum(ingredient_qty) FROM ingredpriceinc WHERE voucher_no= '" + jTable5vouchers1 + "' and  ProductionID='" + jTable5tableclick + "' ;";
                            
                            PreparedStatement jTable5psc2 = jTable5con2702.prepareStatement(jTable5tou2);
                            rs = jTable5psc2.executeQuery(jTable5tou2);
                            
                            if (rs.next()) {
                                Double kansal3 = rs.getDouble(1);
                                
                                jTextField42.setText(String.valueOf(kansal3));
                            }
                            jTable5psc2.close();
                        } catch (Exception e) {
//                                e.printStackTrace();
JOptionPane.showMessageDialog(null, "Cannot save." + e);
                        }
                        
                   } catch (Exception e) {
//                                e.printStackTrace();
JOptionPane.showMessageDialog(null, "Cannot save." + e);
                        }
                    
                } catch (Exception e) {
//                        e.printStackTrace();
JOptionPane.showMessageDialog(null, "Cannot save." + e);
                }
                
            } catch (Exception e) {
//                    e.printStackTrace();
JOptionPane.showMessageDialog(null, "Cannot save." + e);
            }
           
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Invalid Entry or field must be completely filled", "message", 2);
        }
        
        try {
            DefaultTableModel jTable5model5 = (DefaultTableModel) jTable7.getModel();
            int jTable5mg3 = Integer.parseInt(jTextField9.getText());
            
            try {
                int jTable5z3 = jTable5model5.getRowCount();
                for (int lu3 = 0; lu3 <= jTable5z3; ++lu3) {
                    jTable5model5.removeRow(0);
                }
            } catch (Exception e) {
            }
            try {
                
               
                Connection jTable5con1445 = (Connection) db_Connection.getInstance();
                Statement jTable5stmt45 = jTable5con1445.createStatement();
                String query45 = "SELECT * FROM ingredpriceinc where voucher_no = '" + jTable5mg3 + "' and  ProductionID='" + jTable5tableclick + "' ;";
                rs = jTable5stmt45.executeQuery(query45);
                
                while (rs.next()) {
                    jTable5model5.addRow(new Object[]{rs.getString("ingredient_name"), rs.getString("ingredient_qty")});
                }
                rs.close();
                jTable5stmt45.close();
                 
                
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error in connectivity");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Invalid Entry or field must be completely filled", "message", 2);
        }
        
        try {
            DefaultTableModel jTable5model6 = (DefaultTableModel) jTable6.getModel();
            int jTable5mg2 = Integer.parseInt(jTextField9.getText());
            
            try {
                int jTable5z2 = jTable5model6.getRowCount();
                for (int lu2 = 0; lu2 <= jTable5z2; ++lu2) {
                    jTable5model6.removeRow(0);
                }
            } catch (Exception e) {
            }
            try {
                
               
                Connection jTable5con1456 = (Connection) db_Connection.getInstance();
                Statement jTable5stmt46 = jTable5con1456.createStatement();
                String jTable5query46 = "SELECT * FROM raw_materialproduction where voucher_no = '" + jTable5mg2 + "' and  ProductionID='" + jTable5tableclick + "' ;";
                rs = jTable5stmt46.executeQuery(jTable5query46);
                
                while (rs.next()) {
                    jTable5model6.addRow(new Object[]{rs.getString("raw_material"), rs.getString("qty")});
                }
                
                rs.close();
                jTable5stmt46.close();
               
                
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error in connectivity");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Invalid Entry or field must be completely filled", "message", 2);
        }
        
        try {
            DefaultTableModel jTable5model7 = (DefaultTableModel) jTable5.getModel();
            int jTable5mg1 = Integer.parseInt(jTextField9.getText());
            
            try {
                int z1 = jTable5model7.getRowCount();
                for (int lu1 = 0; lu1 <= z1; ++lu1) {
                    jTable5model7.removeRow(0);
                }
            } catch (Exception e) {
            }
            try {
                
               
                Connection jTable5con1467 = (Connection) db_Connection.getInstance();
                Statement jTable5stmt47 = jTable5con1467.createStatement();
                String jTable5query47 = "SELECT * FROM productproduction where voucher_no = '" + jTable5mg1 + "' and  ProductionID='" + jTable5tableclick + "' ;";
                rs = jTable5stmt47.executeQuery(jTable5query47);
                
                while (rs.next()) {
                    jTable5model7.addRow(new Object[]{rs.getString("ProductionID"), rs.getString("product_name"), rs.getString("quantity"), rs.getString("waste")});
                }
                
                rs.close();
                jTable5stmt47.close();  
                
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error in connectivity");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Invalid Entry or field must be completely filled", "message", 2);
        }
        
        try {
            DefaultTableModel jTable5model8 = (DefaultTableModel) jTable8.getModel();
            int jTable5mg = Integer.parseInt(jTextField9.getText());
            
            try {
                int zz = jTable5model8.getRowCount();
                for (int lu = 0; lu <= zz; ++lu) {
                    jTable5model8.removeRow(0);
                }
            } catch (Exception e) {
            }
            try {
                
               
                Connection jTable5con1478 =(Connection) db_Connection.getInstance();
                Statement jTable5stmt48 = jTable5con1478.createStatement();
                String jTable5query48 = "SELECT * FROM costingprodn where voucher_no = '" + jTable5mg + "' and  production_id='" + jTable5tableclick + "' ;";
                rs = jTable5stmt48.executeQuery(jTable5query48);
                
                while (rs.next()) {
                    jTable5model8.addRow(new Object[]{rs.getString("voucher_no"), rs.getInt("production_id"), rs.getString("date"), rs.getString("factory"), rs.getString("fuel"), rs.getString("manpower"), rs.getString("electricity"), rs.getString("can_name"), rs.getString("no_of_cans"), rs.getString("label_name"), rs.getString("no_of_labels")});
                }
                
                rs.close();
                jTable5stmt48.close();
                 
                
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error in connectivity");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Invalid Entry or field must be completely filled", "message", 2);
        }
        
    }
    
    
}jTable5psclikk.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error connection");
            e.printStackTrace();
        }
        
        // TODO add your handling code here:
    }
}
