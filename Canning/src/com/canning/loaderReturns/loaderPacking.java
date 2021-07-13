/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.canning.loaderReturns;

import static com.canning.loaderReturns.searchLoader.getProductList;
import com.canning.returns.multiarrayedReturns.productProductionReturns;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import newpackage1.NewJFrame;
import static newpackage1.NewJFrame.jComboBox17;
import static newpackage1.NewJFrame.jTable18;
import static newpackage1.NewJFrame.jTextLogin;
import newpackage1.db_Connection;

/**
 *
 * @author Stevoski
 */
public class loaderPacking {
    ResultSet rs;
     public static void showDataInJTable() throws SQLException {
          ArrayList<productProductionReturns> list = getpackingList();
        DefaultTableModel model = (DefaultTableModel) jTable18.getModel();
        //clear jTable content
        model.setRowCount(0);
        Object[] row = new Object[4];
        for (int i = 0; i < list.size(); i++) {
            row[0] = list.get(i).getDate();
            row[1] = list.get(i).getprodName();
            row[2] = list.get(i).getQty();
            row[3] = list.get(i).getId();

            model.addRow(row);
        }
    }
    public static ArrayList<productProductionReturns> getpackingList() throws SQLException {
//        String logar=jTextLogin.getText();
        String twu =(String) jComboBox17.getSelectedItem();
        ArrayList<productProductionReturns> packingList = new ArrayList<>();
//        String queryproduction = "SELECT * FROM subrecp where category='Product' item = '" + twu + "';";
//        String querypacking = "SELECT * FROM packingreport where factory = '" + logar + "';";//packrptid
//        String querytransfer = "SELECT * FROM packingreport where factory = '" + logar + "';";//packrptid
        String queryreception = "SELECT * FROM packed_product where packed_product = '" + twu + "';";
        PreparedStatement st;
        ResultSet raes;
        try {                  
                   st = db_Connection.getInstance().prepareStatement(queryreception);    
            raes = st.executeQuery();
            productProductionReturns packing;
            
            while (raes.next()) {
               packing= new productProductionReturns(raes.getString("date"), raes.getString("packed_product"), raes.getDouble("packed_qty"),raes.getInt("packed_productid"));
                packingList.add(packing);
            }
        
        } catch (Exception e) {
//            e.printStackTrace();
   Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, e);
        }
        return packingList;
        }
}
