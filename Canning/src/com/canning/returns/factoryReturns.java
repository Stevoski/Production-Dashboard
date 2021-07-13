/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.canning.returns;

import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import newpackage1.NewJFrame;
import newpackage1.db_Connection;

/**
 *
 * @author Stevoski
 */
public class factoryReturns {

    ResultSet araese;

    public static ArrayList<String> getFactories() throws SQLException {

        ArrayList<String> factoryList = new ArrayList<>();
        String query = "select * from factories";
        String factory;
        PreparedStatement st;
        try {
            st = db_Connection.getInstance().prepareStatement(query);
            ResultSet araese = st.executeQuery(query);
            while (araese.next()) {
                factory = araese.getString("factory");
                factoryList.add(factory);
            }
        } catch (Exception e) {
//            e.printStackTrace();
            Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, e);
        }
        return factoryList;
    }
    public static ArrayList<String> getCategories() throws SQLException {

        ArrayList<String> categorylist = new ArrayList<>();
       categorylist.add("Raw Material");
       categorylist.add("Package");
       categorylist.add("Label");
        return categorylist;
    }

}
