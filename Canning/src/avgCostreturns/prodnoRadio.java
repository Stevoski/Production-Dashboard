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
import static newpackage1.NewJFrame.jLabel142;
import static newpackage1.NewJFrame.jLabel156;
import static newpackage1.NewJFrame.jTextField20;
import static newpackage1.NewJFrame.jTableavg;
import static newpackage1.NewJFrame.jTextLogin;
import newpackage1.db_Connection;

/**
 *
 * @author Stevoski
 */
public class prodnoRadio {
    
    public static void prodnoradioUser() throws HeadlessException {
         String pck = jTextLogin.getText();
//        String aciu = jLabel156.getText();
//        String dateaverage1 = ((JTextField) Choose1.getDateEditor().getUiComponent()).getText();
//        String dateaverage2 = ((JTextField) Choose2.getDateEditor().getUiComponent()).getText();
        String avgdisp = jTextField20.getText();
        try {
            String clik = "SELECT \n"
                    + "        `new_view`.`product` AS `product`,\n"
                    + "        `new_view`.`factory` AS `factory`,\n"
                    + "        `new_view`.`kgsperpc` AS `kgsperpc`,\n"
                    + "       `new_view`.`IngCost`+`new_view`.`rawcost` AS `rawcost`,\n"
                    + "	`new_view`.`LabelCost`+`new_view`.`CanCost` AS `cancost`,\n"
                    + "        `new_view`.`briqCost` + `new_view`.`fuelCost` AS `fuelcost`,\n"
                    + "        `new_view`.`eleCost`  AS `eleCost`,\n"
                    + "	`new_view`.`dieselCost` AS `dieselCost`,\n"
                    + "	`new_view`.`manCost` AS `manCost`,\n"
                    + "	`new_view`.`wasteCost` AS `wastecost`,\n"
                    + "     `new_view`.`Cperunit` AS `AveragePrice`,\n"
                     + "     `new_view`.`standard_cost` AS `standard_cost`,\n"
                     + "     round(`new_view`.`deviation_from_averagecost`) AS `deviation`,\n"
                    + "     `new_view`.`date` AS `date`,  \n"
                    + "     `new_view`.`quantity` AS `quantity`"
                    + " FROM `new_view`"
                    + " WHERE new_view.product='" + avgdisp + "' and new_view.factory='" + pck + "' ";

            try {
                DefaultTableModel model = (DefaultTableModel) jTableavg.getModel();
                model.setColumnCount(12);
                try {
                    int z = model.getRowCount();
                    for (int lue = 0; lue <= z; ++lue) {
                        model.removeRow(0);
                    }

                } catch (Exception e) {
                }
                PreparedStatement psy = db_Connection.getInstance().prepareStatement(clik);
//                    psy.setString(1, dateaverage2);
//                    psy.setString(2, dateaverage1);
                ResultSet rsPadd = psy.executeQuery();

                while (rsPadd.next()) {
                    model.addRow(new Object[]{rsPadd.getString("product"), rsPadd.getString("factory"), rsPadd.getDouble("rawcost"), rsPadd.getDouble("cancost"), rsPadd.getDouble("fuelcost"), rsPadd.getDouble("elecost"), rsPadd.getDouble("dieselcost"), rsPadd.getDouble("mancost"), rsPadd.getDouble("wastecost"), rsPadd.getDouble("averageprice"), rsPadd.getString("date"), rsPadd.getDouble("quantity")});
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
    
     public static void prodnoradioAdmin() throws HeadlessException {
//       String pck = jTextLogin.getText();
//        String aciu = jLabel156.getText();
//        String dateaverage1 = ((JTextField) Choose1.getDateEditor().getUiComponent()).getText();
//        String dateaverage2 = ((JTextField) Choose2.getDateEditor().getUiComponent()).getText();
        String avgdisp = jTextField20.getText();
//        jLabel141.setText(avgdisp);
//         String avgdisp1 = jLabel142.getText();
        try {
//            String clak= "SELECT voucher_no, `Production_ID` as PID, date, factory, quantity, product, RawCost, wasteCost, CanCost, eleCost, briqCost, manCost,Cperunit, standard_cost, `deviation_from_averagecost` as variation from above_margin_productions";
          String clik = "SELECT \n"
                    + "        `new_view`.`product` AS `product`,\n"
                    + "        `new_view`.`factory` AS `factory`,\n"
                    + "        `new_view`.`kgsperpc` AS `kgsperpc`,\n"
                    + "       `new_view`.`IngCost`+`new_view`.`rawcost` AS `rawcost`,\n"
                    + "	`new_view`.`LabelCost`+`new_view`.`CanCost` AS `cancost`,\n"
                    + "        `new_view`.`briqCost` + `new_view`.`fuelCost` AS `fuelcost`,\n"
                    + "        `new_view`.`eleCost`  AS `eleCost`,\n"
                    + "	`new_view`.`dieselCost` AS `dieselCost`,\n"
                    + "	`new_view`.`manCost` AS `manCost`,\n"
                    + "	`new_view`.`wasteCost` AS `wastecost`,\n"
                    + "     `new_view`.`Cperunit` AS `AveragePrice`,\n"
                   + "     `new_view`.`standard_cost` AS `standard_cost`,\n"
                     + "     `new_view`.`deviation_from_averagecost` AS `deviation`,\n"
                    + "     `new_view`.`date` AS `date`,  \n"
                    + "     `new_view`.`quantity` AS `quantity`"
                    + " FROM `new_view`"
                    + " WHERE new_view.product='" + avgdisp + "' ";


            try {
//                  DefaultTableModel model = (DefaultTableModel) jTableavg.getModel();
//                model.setColumnCount(12);
//                try {
//                    int z = model.getRowCount();
//                    for (int lue = 0; lue <= z; ++lue) {
//                        model.removeRow(0);
//                    }
//
//                } catch (Exception e) {
//                }
                
                PreparedStatement psy = db_Connection.getInstance().prepareStatement(clik);
//                    psy.setString(1, avgdispl);

                ResultSet rsPadd = psy.executeQuery();   

                 while (rsPadd.next()) {
                  jTableavg.setModel(rsToTableModels.aboveMarginModel.buildTableModel(rsPadd));
//                                      model.addRow(new Object[]{rsPadd.getString("product"), rsPadd.getString("factory"), rsPadd.getDouble("rawcost"), rsPadd.getDouble("cancost"), rsPadd.getDouble("fuelcost"), rsPadd.getDouble("elecost"), rsPadd.getDouble("dieselcost"), rsPadd.getDouble("mancost"), rsPadd.getDouble("wastecost"), rsPadd.getDouble("averageprice"), rsPadd.getString("date"), rsPadd.getDouble("quantity")});
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
