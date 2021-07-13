/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package avgCostreturns;

import java.awt.HeadlessException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import static newpackage1.NewJFrame.Choose1;
import static newpackage1.NewJFrame.Choose2;
import static newpackage1.NewJFrame.jLabel156;
import static newpackage1.NewJFrame.jTableavg;
import static newpackage1.NewJFrame.jTextField20;
import static newpackage1.NewJFrame.jTextLogin;
import newpackage1.db_Connection;

/**
 *
 * @author Stevoski
 */
public class packradio {
       
    
        public static void packradioAdmin() throws HeadlessException {
         String pck = jTextLogin.getText();
        String aciu = jLabel156.getText();
        String dateaverage1 = ((JTextField) Choose1.getDateEditor().getUiComponent()).getText();
        String dateaverage2 = ((JTextField) Choose2.getDateEditor().getUiComponent()).getText();
        String avgdisp = jTextField20.getText();
        try {
            String clik = "select *"
                    + " FROM `packingcost`"
                    + " WHERE packingcost.packed_product='" + avgdisp + "' and packingcost.date between ? and ?  ";

            try {
//                DefaultTableModel model = (DefaultTableModel) jTableavg.getModel();
//                model.setColumnCount(6);
//                try {
//                    int z = model.getRowCount();
//                    for (int lue = 0; lue <= z; ++lue) {
//                        model.removeRow(0);
//                    }
//
//                } catch (Exception e) {
//                }
                PreparedStatement psy = db_Connection.getInstance().prepareStatement(clik);
                psy.setString(1, dateaverage1);
                psy.setString(2, dateaverage2);
                ResultSet rsPadd = psy.executeQuery();

                while (rsPadd.next()) {
                     jTableavg.setModel(rsToTableModels.aboveMarginModel.buildTableModel(rsPadd));
//                    model.addRow(new Object[]{rsPadd.getString("packedproduct"), rsPadd.getString("factory"), rsPadd.getDouble("procost"), rsPadd.getDouble("packagecost"), rsPadd.getDouble("mancost"), rsPadd.getDouble("packingcost")});
                }
              
          rsPadd.close();
            psy.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error connection");
                e.printStackTrace();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error connection");
            e.printStackTrace();
        }
    }
        
    public static void packradioUser() throws HeadlessException {
        String pck = jTextLogin.getText();
        String aciu = jLabel156.getText();
        String dateaverage1 = ((JTextField) Choose1.getDateEditor().getUiComponent()).getText();
        String dateaverage2 = ((JTextField) Choose2.getDateEditor().getUiComponent()).getText();
        String avgdisp = jTextField20.getText();
        try {
            String clik = "select *"
                    + " FROM `packcost`"
                    + " WHERE packcost.packedproduct=? and packcost.factory=? and packingcost.date between ? and ?";

            try {
               
                PreparedStatement psy = db_Connection.getInstance().prepareStatement(clik);
                psy.setString(1, avgdisp);
                psy.setString(2, pck);
                psy.setString(1, dateaverage1);
                psy.setString(2, dateaverage2);
                ResultSet rsPadd = psy.executeQuery();

                while (rsPadd.next()) {
                     jTableavg.setModel(rsToTableModels.aboveMarginModel.buildTableModel(rsPadd));
//                    model.addRow(new Object[]{rsPadd.getString("packedproduct"), rsPadd.getString("factory"), rsPadd.getDouble("procost"), rsPadd.getDouble("packagecost"), rsPadd.getDouble("mancost"), rsPadd.getDouble("packingcost")});
                }
//          rsPadd.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error connection");
                e.printStackTrace();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error connection");
            e.printStackTrace();
        }
    }
}
