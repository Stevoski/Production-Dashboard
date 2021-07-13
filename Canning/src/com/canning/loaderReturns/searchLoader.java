/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.canning.loaderReturns;

import com.canning.returns.multiarrayedReturns.productProductionReturns;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import newpackage1.NewJFrame;
import static newpackage1.NewJFrame.jTextLogin;
import static newpackage1.NewJFrame.jTable18;
import static newpackage1.NewJFrame.jComboBox17;
import newpackage1.db_Connection;

/**
 *
 * @author Stevoski
 */
public class searchLoader {
     ResultSet rs;
     public static void showDataInJTable() throws SQLException {
          ArrayList<productProductionReturns> list = getProductList();
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
    public static ArrayList<productProductionReturns> getProductList() throws SQLException {
        String logar=jTextLogin.getText();
        String twu =(String) jComboBox17.getSelectedItem();
        ArrayList<productProductionReturns> prodprodnList = new ArrayList<>();
        String queryproduction = "SELECT * FROM new_view where product = '" + twu + "' order by date;";
//        String querypacking = "SELECT * FROM packingreport where factory = '" + logar + "';";//packrptid
//        String querytransfer = "SELECT * FROM packingreport where factory = '" + logar + "';";//packrptid
//        String queryreception = "SELECT * FROM packingreport where factory = '" + logar + "';";//packrptid
        PreparedStatement st;
        ResultSet raes;
        try {
//            switch(twu){
//                case "Production":
//                    st = db_Connection.getInstance().prepareStatement(queryproduction);
//                    break;
//                case "Packing":
//                     st = db_Connection.getInstance().prepareStatement(querypacking);
//                    break;
//                case "Transfers":
//                     st = db_Connection.getInstance().prepareStatement(querytransfer);
//                    break;
//                case "Reception":
//                     st = db_Connection.getInstance().prepareStatement(queryreception);
//                    break;
//                default :                    
                   st = db_Connection.getInstance().prepareStatement(queryproduction);    
            raes = st.executeQuery();
            productProductionReturns product;
            
            while (raes.next()) {
               product= new productProductionReturns(raes.getString("date"), raes.getString("product"), raes.getDouble("quantity"),raes.getInt("Production_ID"));
                prodprodnList.add(product);
            }        
        } catch (Exception e) {
//            e.printStackTrace();
   Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, e);
        }
        return prodprodnList;
        }    
}
