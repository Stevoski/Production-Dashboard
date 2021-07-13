/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.canning.costpanel;

import java.awt.HeadlessException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import static newpackage1.NewJFrame.jTable9;
import static newpackage1.NewJFrame.jTextField25;
import static newpackage1.NewJFrame.jTextField33;
import static newpackage1.NewJFrame.jTextField48;
import static newpackage1.NewJFrame.jTextField49;
import static newpackage1.NewJFrame.jTextField57;
import static newpackage1.NewJFrame.jTextField58;
import static newpackage1.NewJFrame.jTextField59;
import static newpackage1.NewJFrame.jTextField60;
import static newpackage1.NewJFrame.jTextField61;
import static newpackage1.NewJFrame.jTextField88;
import newpackage1.db_Connection;

/**
 *
 * @author Stevoski
 */
public class panel9Compute {
    public static void panel9compute() throws HeadlessException {
        int rowcost = jTable9.getSelectedRow();
        String tableCost = (jTable9.getModel().getValueAt(rowcost, 0).toString());
        String vcrcost = (String) jTextField25.getText();
        ResultSet rsCompute;
        try {
            String querycost = "SELECT RawCost,IngCost,CanCost,LabelCost,eleCost,fuelCost,manCost,Cperunit,WasteCost FROM new_view where voucher_no = '" + vcrcost + "' and Production_ID = '" + tableCost + "';";

            try (PreparedStatement stmtcost = db_Connection.getInstance().prepareStatement(querycost)) {
                rsCompute = stmtcost.executeQuery();
                
                //PRODUCT SUM AMOUNT
                while (rsCompute.next()) {
                    Double RCost = rsCompute.getDouble(1);
                    jTextField48.setText(String.valueOf(RCost));
                    
                    Double ICost = rsCompute.getDouble(2);
                    jTextField49.setText(String.valueOf(ICost));
                    
                    Double PCost = rsCompute.getDouble(3);
                    jTextField57.setText(String.valueOf(PCost));
                    
                    Double LCost = rsCompute.getDouble(4);
                    jTextField58.setText(String.valueOf(LCost));
                    
                    Double ECost = rsCompute.getDouble(5);
                    jTextField60.setText(String.valueOf(ECost));
                    
                    Double FCost = rsCompute.getDouble(6);
                    jTextField61.setText(String.valueOf(FCost));
                    
                    Double MCost = rsCompute.getDouble(7);
                    jTextField59.setText(String.valueOf(MCost));
                    
                    Double PPUCost = rsCompute.getDouble(8);
                    jTextField33.setText(String.valueOf(PPUCost));
                    
                    Double wasteCost = rsCompute.getDouble(9);
                    jTextField88.setText(String.valueOf(wasteCost));
                    
                }
            }
            
        } catch (Exception e) {
                                    e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Cannot save." + e);
        }
    }
}
