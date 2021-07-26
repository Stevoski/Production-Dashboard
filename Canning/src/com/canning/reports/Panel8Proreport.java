/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.canning.reports;

import java.sql.Connection;
import java.awt.BorderLayout;
import java.awt.HeadlessException;
import java.sql.DriverManager;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JRViewer;
import newpackage1.LoginForm;
import static newpackage1.NewJFrame.MainPanel;
import static newpackage1.NewJFrame.jDate2;
import static newpackage1.NewJFrame.jDateChooser2;
import static newpackage1.NewJFrame.jDateChooser3;
import static newpackage1.NewJFrame.jRadioButton8;
import static newpackage1.NewJFrame.jRadioButton9;
import static newpackage1.NewJFrame.jRadioButton20;
import static newpackage1.NewJFrame.jTextField138;
import static newpackage1.NewJFrame.jTextField89;
import static newpackage1.NewJFrame.jRadioButton13;
import static newpackage1.NewJFrame.jTextLogin;
import static newpackage1.NewJFrame.jTextField9;
import newpackage1.db_Connection;
//jTextLogin.getText()

/**
 *
 * @author Stevoski
 */
public class Panel8Proreport {
   
    public static void PanelproReport() throws HeadlessException {
      
        String Dispdt = ((JTextField) jDate2.getDateEditor().getUiComponent()).getText();
        String prt1 = ((JTextField) jDateChooser2.getDateEditor().getUiComponent()).getText();
        String prt2 = ((JTextField) jDateChooser3.getDateEditor().getUiComponent()).getText();
        String access = jTextLogin.getText();
          String Disppl = jTextField89.getText();
          String vouch = jTextField9.getText();
           String pidsa = jTextField138.getText();
        if ("ADMINISTRATOR".equals(jTextLogin.getText())) {
            try {
                if (jRadioButton8.isSelected() == true) {
                    try {                        
                        Connection connn = (Connection) db_Connection.getInstance();
        JasperDesign jd = JRXmlLoader.load("C:\\Program Files\\Cost\\production_to_cost.jrxml");
JasperDesign SUBjd = JRXmlLoader.load("C:\\Program Files\\Cost\\DatebtwnReport_subreport2.jrxml");
JasperDesign SUBjd1 = JRXmlLoader.load("C:\\Program Files\\Cost\\production_to_cost_subreport.jrxml");

String sqlie = " SELECT   "
        + "`costingprodn`.`voucher_no` AS `voucher_no`,\n" +
"        `costingprodn`.`production_id` AS `production_id`,\n" +
"        `prodpriceinclusive`.`date` AS `date`,\n" +
"        `prodpriceinclusive`.`factory` AS `factory`,\n" +
"        `prodpriceinclusive`.`groupe` AS `groupe`,\n" +
"        `prodpriceinclusive`.`product_name` AS `product_name`,\n" +
"      (`prodpriceinclusive`.`quantity`) AS `quantity`,\n" +
"        `prodpriceinclusive`.`quantityKGS` AS `quantityKGS`,\n" +
"    `prodpriceinclusive`.`waste` AS `waste`,\n" +
"        `costingprodn`.`electricity` AS `electricity`,\n" +
"        `costingprodn`.`can_name` AS `can`,\n" +
"        `costingprodn`.`no_of_cans` AS `no of can`,\n" +
"        `costingprodn`.`label_name` AS `label`,\n" +
"        `costingprodn`.`no_of_labels` AS `no of labels`,\n" +
"        `prodpriceinclusive`.`manpower_hrs` AS `manpower_hrs`,\n" +
"        `costingprodn`.`fuel` AS `fuel`,\n" +
"        `ingredpriceinc`.`ingredient_name` AS `ingredient`,\n" +
"        `ingredpriceinc`.`ingredient_qty` AS `ing_qty`,\n" +
"        `ingredpriceinc`.`amount` AS `amount`,\n" +
"        `rawmatpriceinc`.`raw_material` AS `raw_material`,\n" +
"        `rawmatpriceinc`.`qty` AS `raw_material_qty`,\n" +
"        `rawmatpriceinc`.`amount` AS `raw_material_amount`,\n" +
"   `costingprodn`.`remarks` AS `remarks`,\n" +
"        `neview`.`ingredient` AS `roomo`,\n" +
"        `neview`.`ing_qty` AS `qoatoo`,\n" +
"	sum(distinct  `neview`.`ing_qty`) as `total qty`,\n" +
" `costingprodn`.`can_waste` AS `can_waste`,\n" +
"  `costingprodn`.`briquette` AS `briquette`,\n" +
"        `costingprodn`.`briquetteamount` AS `briquetteamount`,\n" +
"        `costingprodn`.`diesel` AS `diesel`,\n" +
"         `neview`.ingredient_price AS ingredient_price,\n" +
"        `costingprodn`.`dieselamount` AS `dieselamount` "+       
"    FROM\n" +
"        ((((`costingprodn`\n" +
"        LEFT JOIN `prodpriceinclusive` ON (((`prodpriceinclusive`.`voucher_no` = `costingprodn`.`voucher_no`)\n" +
"            AND (`costingprodn`.`production_id` = `prodpriceinclusive`.`ProductionID`))))\n" +
"        LEFT JOIN `ingredpriceinc` ON (((`ingredpriceinc`.`voucher_no` = `costingprodn`.`voucher_no`)\n" +
"            AND (`ingredpriceinc`.`ProductionID` = `prodpriceinclusive`.`ProductionID`))))\n" +
"        LEFT JOIN `rawmatpriceinc` ON (((`rawmatpriceinc`.`voucher_no` = `costingprodn`.`voucher_no`)\n" +
"            AND (`rawmatpriceinc`.`ProductionID` = `prodpriceinclusive`.`ProductionID`))))\n" +
"        LEFT JOIN `neview` ON (((`neview`.`voucher_no` = `costingprodn`.`voucher_no`)\n" +
"            AND (`neview`.`ProductionID`=`prodpriceinclusive`.`ProductionID`)))) \n" 
       
        + "                  where `prodpriceinclusive`.`voucher_no` ='" + vouch + "' \n"
       
        + "    GROUP BY `neview`.`voucher_no`,`neview`.`ProductionID`  ";
JRDesignQuery NewQuery = new JRDesignQuery();
NewQuery.setText(sqlie);
jd.setQuery(NewQuery);

JasperReport jasperMasterReport = JasperCompileManager.compileReport(jd);
JasperReport jsr = JasperCompileManager.compileReport(SUBjd);
JasperReport jsr1 = JasperCompileManager.compileReport(SUBjd1);

Map<String, Object> paramsi = new HashMap<String, Object>();
//                Map<String, Object> params = new HashMap<>()<String, Object()>;
paramsi.put("par1", jsr);
paramsi.put("propard", jsr1);

JasperPrint jp = JasperFillManager.fillReport(jasperMasterReport, paramsi, connn);

//DISPLAY IN JPANEL
BorderLayout layoutPanel = new BorderLayout();
JPanel panelRPTt = new JPanel(layoutPanel);
JRViewer vw = new JRViewer(jp);
panelRPTt.setLayout(new BorderLayout());
panelRPTt.repaint();
panelRPTt.add(vw);
panelRPTt.revalidate();

MainPanel.removeAll();
MainPanel.add(panelRPTt);
MainPanel.repaint();
MainPanel.revalidate();

                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e.getMessage());
                        e.printStackTrace();
                    }
                } else if (jRadioButton9.isSelected() == true) {
                    try {
                       
                        Connection connn1 = (Connection) db_Connection.getInstance();
//                        JasperDesign jd = JRXmlLoader.load("C:\\Program Files (x86)\\Cost\\DatebtwnReport.jrxml");
//                        JasperDesign SUBjd = JRXmlLoader.load("C:\\Program Files (x86)\\Cost\\DatebtwnReport_subreport2.jrxml");
//                  64BIT OS
//                        JasperDesign jd = JRXmlLoader.load("C:\\Program Files (x86)\\Cost\\DatebtwnReport.jrxml");
//                        JasperDesign SUBjd = JRXmlLoader.load("C:\\Program Files (x86)\\Cost\\DatebtwnReport_subreport2.jrxml");
//32 BIT OS
 JasperDesign jd = JRXmlLoader.load("C:\\Program Files\\Cost\\production_to_cost.jrxml");
JasperDesign SUBjd = JRXmlLoader.load("C:\\Program Files\\Cost\\DatebtwnReport_subreport2.jrxml");
JasperDesign SUBjd1 = JRXmlLoader.load("C:\\Program Files\\Cost\\production_to_cost_subreport.jrxml");

String sqlie = "  SELECT \n" +
"        `costingprodn`.`voucher_no` AS `voucher_no`,\n" +
"        `costingprodn`.`production_id` AS `production_id`,\n" +
"        `prodpriceinclusive`.`date` AS `date`,\n" +
"        `prodpriceinclusive`.`factory` AS `factory`,\n" +
"        `prodpriceinclusive`.`groupe` AS `groupe`,\n" +
"        `prodpriceinclusive`.`product_name` AS `product_name`,\n" +
"      (`prodpriceinclusive`.`quantity`) AS `quantity`,\n" +
"        `prodpriceinclusive`.`quantityKGS` AS `quantityKGS`,\n" +
"    `prodpriceinclusive`.`waste` AS `waste`,\n" +
"        `costingprodn`.`electricity` AS `electricity`,\n" +
"        `costingprodn`.`can_name` AS `can`,\n" +
"        `costingprodn`.`no_of_cans` AS `no of can`,\n" +
"        `costingprodn`.`label_name` AS `label`,\n" +
"        `costingprodn`.`no_of_labels` AS `no of labels`,\n" +
"        `prodpriceinclusive`.`manpower_hrs` AS `manpower_hrs`,\n" +
"        `costingprodn`.`fuel` AS `fuel`,\n" +
"        `ingredpriceinc`.`ingredient_name` AS `ingredient`,\n" +
"        `ingredpriceinc`.`ingredient_qty` AS `ing_qty`,\n" +
"        `ingredpriceinc`.`amount` AS `amount`,\n" +
"        `rawmatpriceinc`.`raw_material` AS `raw_material`,\n" +
"        `rawmatpriceinc`.`qty` AS `raw_material_qty`,\n" +
"        `rawmatpriceinc`.`amount` AS `raw_material_amount`,\n" +
"   `costingprodn`.`remarks` AS `remarks`,\n" +
"        `neview`.`ingredient` AS `roomo`,\n" +
"        `neview`.`ing_qty` AS `qoatoo`,\n" +
"	sum(distinct  `neview`.`ing_qty`) as `total qty`,\n" +
" `costingprodn`.`can_waste` AS `can_waste`,\n" +
         " `costingprodn`.`briquette` AS `briquette`,\n" +
       " `costingprodn`.`briquetteamount` AS `briquetteamount`,\n" +
       " `costingprodn`.`diesel` AS `diesel`,\n" +
        "`neview`.ingredient_price AS ingredient_price,\n" +
       " `costingprodn`.`dieselamount` AS `dieselamount`\n" +
"    FROM\n" +
"        ((((`costingprodn`\n" +
"        LEFT JOIN `prodpriceinclusive` ON (((`prodpriceinclusive`.`voucher_no` = `costingprodn`.`voucher_no`)\n" +
"            AND (`costingprodn`.`production_id` = `prodpriceinclusive`.`ProductionID`))))\n" +
"        LEFT JOIN `ingredpriceinc` ON (((`ingredpriceinc`.`voucher_no` = `costingprodn`.`voucher_no`)\n" +
"            AND (`ingredpriceinc`.`ProductionID` = `prodpriceinclusive`.`ProductionID`))))\n" +
"        LEFT JOIN `rawmatpriceinc` ON (((`rawmatpriceinc`.`voucher_no` = `costingprodn`.`voucher_no`)\n" +
"            AND (`rawmatpriceinc`.`ProductionID` = `prodpriceinclusive`.`ProductionID`))))\n" +
"        LEFT JOIN `neview` ON (((`neview`.`voucher_no` = `costingprodn`.`voucher_no`)\n" +
"            AND (`neview`.`ProductionID`=`prodpriceinclusive`.`ProductionID`)))) \n" 
          + " where  prodpriceinclusive.date ='" + Dispdt + "'\n"
        + "    GROUP BY prodpriceinclusive.voucher_no ,  prodpriceinclusive.groupe , prodpriceinclusive.product_name , prodpriceinclusive.ProductionID ";
JRDesignQuery NewQuery = new JRDesignQuery();
NewQuery.setText(sqlie);
jd.setQuery(NewQuery);
JasperReport jr = JasperCompileManager.compileReport(jd);
JasperReport jsr = JasperCompileManager.compileReport(SUBjd);
JasperReport jsr1 = JasperCompileManager.compileReport(SUBjd1);

Map<String, Object> paramsi = new HashMap<String, Object>();
//                Map<String, Object> params = new HashMap<>()<String, Object()>;
paramsi.put("par1", jsr);
paramsi.put("propard", jsr1);


JasperPrint jp = JasperFillManager.fillReport(jr, paramsi, connn1);
// paramsi.put("par1", jsr);
//JasperViewer.viewReport(jp, false);
//DISPLAY IN JPANEL
BorderLayout layoutPanel1 = new BorderLayout();
JPanel panelRPTt1 = new JPanel(layoutPanel1);
JRViewer vw = new JRViewer(jp);
panelRPTt1.setLayout(new BorderLayout());
panelRPTt1.repaint();
panelRPTt1.add(vw);
panelRPTt1.revalidate();

MainPanel.removeAll();
MainPanel.add(panelRPTt1);
MainPanel.repaint();
MainPanel.revalidate();


                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e.getMessage());
                        
                        e.printStackTrace();
                        
                    }
                    
                } else if (jRadioButton13.isSelected() == true) {
                    try {
                      
                        Connection connn3 = (Connection) db_Connection.getInstance();
               
 JasperDesign jd = JRXmlLoader.load("C:\\Program Files\\Cost\\production_to_cost.jrxml");
JasperDesign SUBjd = JRXmlLoader.load("C:\\Program Files\\Cost\\DatebtwnReport_subreport2.jrxml");
JasperDesign SUBjd1 = JRXmlLoader.load("C:\\Program Files\\Cost\\production_to_cost_subreport.jrxml");

String sqlie = "  SELECT \n" +
"        `costingprodn`.`voucher_no` AS `voucher_no`,\n" +
"        `costingprodn`.`production_id` AS `production_id`,\n" +
"        `prodpriceinclusive`.`date` AS `date`,\n" +
"        `prodpriceinclusive`.`factory` AS `factory`,\n" +
"        `prodpriceinclusive`.`groupe` AS `groupe`,\n" +
"        `prodpriceinclusive`.`product_name` AS `product_name`,\n" +
"      (`prodpriceinclusive`.`quantity`) AS `quantity`,\n" +
"        `prodpriceinclusive`.`quantityKGS` AS `quantityKGS`,\n" +
"    `prodpriceinclusive`.`waste` AS `waste`,\n" +
"        `costingprodn`.`electricity` AS `electricity`,\n" +
"        `costingprodn`.`can_name` AS `can`,\n" +
"        `costingprodn`.`no_of_cans` AS `no of can`,\n" +
"        `costingprodn`.`label_name` AS `label`,\n" +
"        `costingprodn`.`no_of_labels` AS `no of labels`,\n" +
"        `prodpriceinclusive`.`manpower_hrs` AS `manpower_hrs`,\n" +
"        `costingprodn`.`fuel` AS `fuel`,\n" +
"        `ingredpriceinc`.`ingredient_name` AS `ingredient`,\n" +
"        `ingredpriceinc`.`ingredient_qty` AS `ing_qty`,\n" +
        "`neview`.ingredient_price AS ingredient_price,\n" +
"        `ingredpriceinc`.`amount` AS `amount`,\n" +
"        `rawmatpriceinc`.`raw_material` AS `raw_material`,\n" +
"        `rawmatpriceinc`.`qty` AS `raw_material_qty`,\n" +
"        `rawmatpriceinc`.`amount` AS `raw_material_amount`,\n" +
"   `costingprodn`.`remarks` AS `remarks`,\n" +
"        `neview`.`ingredient` AS `roomo`,\n" +
"        `neview`.`ing_qty` AS `qoatoo`,\n" +
"	sum(distinct  `neview`.`ing_qty`) as `total qty`,\n" +
" `costingprodn`.`can_waste` AS `can_waste`,\n" +
         " `costingprodn`.`briquette` AS `briquette`,\n" +
       " `costingprodn`.`briquetteamount` AS `briquetteamount`,\n" +
       " `costingprodn`.`diesel` AS `diesel`,\n" +
       " `costingprodn`.`dieselamount` AS `dieselamount`\n" +
"    FROM\n" +
"        ((((`costingprodn`\n" +
"        LEFT JOIN `prodpriceinclusive` ON (((`prodpriceinclusive`.`voucher_no` = `costingprodn`.`voucher_no`)\n" +
"            AND (`costingprodn`.`production_id` = `prodpriceinclusive`.`ProductionID`))))\n" +
"        LEFT JOIN `ingredpriceinc` ON (((`ingredpriceinc`.`voucher_no` = `costingprodn`.`voucher_no`)\n" +
"            AND (`ingredpriceinc`.`ProductionID` = `prodpriceinclusive`.`ProductionID`))))\n" +
"        LEFT JOIN `rawmatpriceinc` ON (((`rawmatpriceinc`.`voucher_no` = `costingprodn`.`voucher_no`)\n" +
"            AND (`rawmatpriceinc`.`ProductionID` = `prodpriceinclusive`.`ProductionID`))))\n" +
"        LEFT JOIN `neview` ON (((`neview`.`voucher_no` = `costingprodn`.`voucher_no`)\n" +
"            AND (`neview`.`ProductionID`=`prodpriceinclusive`.`ProductionID`)))) \n" 
          + " where  prodpriceinclusive.date >='" + prt1 + "' and prodpriceinclusive.date<='" + prt2 + "'\n"
        + "    GROUP BY prodpriceinclusive.voucher_no ,  prodpriceinclusive.groupe , prodpriceinclusive.product_name , prodpriceinclusive.ProductionID ";
JRDesignQuery NewQuery = new JRDesignQuery();
NewQuery.setText(sqlie);
jd.setQuery(NewQuery);

JasperReport jasperMasterReport = JasperCompileManager.compileReport(jd);
JasperReport jsr = JasperCompileManager.compileReport(SUBjd);
JasperReport jsr1 = JasperCompileManager.compileReport(SUBjd1);

Map<String, Object> paramsi = new HashMap<String, Object>();
//                Map<String, Object> params = new HashMap<>()<String, Object()>;
paramsi.put("par1", jsr);
paramsi.put("propard", jsr1);//JasperFillManager.fillReportToFile(jasperMasterReport, parameters, connn);
JasperPrint jp = JasperFillManager.fillReport(jasperMasterReport, paramsi, connn3);

//DISPLAY IN JPANEL
BorderLayout layoutPanel = new BorderLayout();
JPanel panelRPTt = new JPanel(layoutPanel);
JRViewer vw = new JRViewer(jp);
panelRPTt.setLayout(new BorderLayout());
panelRPTt.repaint();
panelRPTt.add(vw);
panelRPTt.revalidate();

MainPanel.removeAll();
MainPanel.add(panelRPTt);
MainPanel.repaint();
MainPanel.revalidate();

                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e.getMessage());
                        e.printStackTrace();
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Please Select an Option");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
                e.printStackTrace();
            }
            if (jRadioButton20.isSelected() == true) {
                    try {                        
                        Connection connn = (Connection) db_Connection.getInstance();
        JasperDesign jd = JRXmlLoader.load("C:\\Program Files\\Cost\\production_to_cost.jrxml");
JasperDesign SUBjd = JRXmlLoader.load("C:\\Program Files\\Cost\\DatebtwnReport_subreport2.jrxml");
JasperDesign SUBjd1 = JRXmlLoader.load("C:\\Program Files\\Cost\\production_to_cost_subreport.jrxml");
String sqlie = " SELECT   "
        + "`costingprodn`.`voucher_no` AS `voucher_no`,\n" +
"        `costingprodn`.`production_id` AS `production_id`,\n" +
"        `prodpriceinclusive`.`date` AS `date`,\n" +
"        `prodpriceinclusive`.`factory` AS `factory`,\n" +
"        `prodpriceinclusive`.`groupe` AS `groupe`,\n" +
"        `prodpriceinclusive`.`product_name` AS `product_name`,\n" +
"      (`prodpriceinclusive`.`quantity`) AS `quantity`,\n" +
"        `prodpriceinclusive`.`quantityKGS` AS `quantityKGS`,\n" +
"    `prodpriceinclusive`.`waste` AS `waste`,\n" +
"        `costingprodn`.`electricity` AS `electricity`,\n" +
"        `costingprodn`.`can_name` AS `can`,\n" +
"        `costingprodn`.`no_of_cans` AS `no of can`,\n" +
"        `costingprodn`.`label_name` AS `label`,\n" +
"        `costingprodn`.`no_of_labels` AS `no of labels`,\n" +
"        `prodpriceinclusive`.`manpower_hrs` AS `manpower_hrs`,\n" +
"        `costingprodn`.`fuel` AS `fuel`,\n" +
"        `ingredpriceinc`.`ingredient_name` AS `ingredient`,\n" +
"        `ingredpriceinc`.`ingredient_qty` AS `ing_qty`,\n" +
"        `ingredpriceinc`.`amount` AS `amount`,\n" +
"        `rawmatpriceinc`.`raw_material` AS `raw_material`,\n" +
"        `rawmatpriceinc`.`qty` AS `raw_material_qty`,\n" +
"        `rawmatpriceinc`.`amount` AS `raw_material_amount`,\n" +
"   `costingprodn`.`remarks` AS `remarks`,\n" +
"        `neview`.`ingredient` AS `roomo`,\n" +
"        `neview`.`ing_qty` AS `qoatoo`,\n" +
"	sum(distinct  `neview`.`ing_qty`) as `total qty`,\n" +
" `costingprodn`.`can_waste` AS `can_waste`,\n" +
"  `costingprodn`.`briquette` AS `briquette`,\n" +
"        `costingprodn`.`briquetteamount` AS `briquetteamount`,\n" +
"        `costingprodn`.`diesel` AS `diesel`,\n" +
"         `neview`.ingredient_price AS ingredient_price,\n" +
"        `costingprodn`.`dieselamount` AS `dieselamount` "+       
"    FROM\n" +
"        ((((`costingprodn`\n" +
"        LEFT JOIN `prodpriceinclusive` ON (((`prodpriceinclusive`.`voucher_no` = `costingprodn`.`voucher_no`)\n" +
"            AND (`costingprodn`.`production_id` = `prodpriceinclusive`.`ProductionID`))))\n" +
"        LEFT JOIN `ingredpriceinc` ON (((`ingredpriceinc`.`voucher_no` = `costingprodn`.`voucher_no`)\n" +
"            AND (`ingredpriceinc`.`ProductionID` = `prodpriceinclusive`.`ProductionID`))))\n" +
"        LEFT JOIN `rawmatpriceinc` ON (((`rawmatpriceinc`.`voucher_no` = `costingprodn`.`voucher_no`)\n" +
"            AND (`rawmatpriceinc`.`ProductionID` = `prodpriceinclusive`.`ProductionID`))))\n" +
"        LEFT JOIN `neview` ON (((`neview`.`voucher_no` = `costingprodn`.`voucher_no`)\n" +
"            AND (`neview`.`ProductionID`=`prodpriceinclusive`.`ProductionID`)))) \n" 
       
        + "                  where `prodpriceinclusive`.`ProductionID` ='" + pidsa + "' \n"
               + "    GROUP BY `neview`.`voucher_no`,`neview`.`ProductionID`  ";
JRDesignQuery NewQuery = new JRDesignQuery();
NewQuery.setText(sqlie);
jd.setQuery(NewQuery);

JasperReport jasperMasterReport = JasperCompileManager.compileReport(jd);
JasperReport jsr = JasperCompileManager.compileReport(SUBjd);
JasperReport jsr1 = JasperCompileManager.compileReport(SUBjd1);

Map<String, Object> paramsi = new HashMap<String, Object>();
//                Map<String, Object> params = new HashMap<>()<String, Object()>;
paramsi.put("par1", jsr);
paramsi.put("propard", jsr1);

JasperPrint jp = JasperFillManager.fillReport(jasperMasterReport, paramsi, connn);

//DISPLAY IN JPANEL
BorderLayout layoutPanel = new BorderLayout();
JPanel panelRPTt = new JPanel(layoutPanel);
JRViewer vw = new JRViewer(jp);
panelRPTt.setLayout(new BorderLayout());
panelRPTt.repaint();
panelRPTt.add(vw);
panelRPTt.revalidate();

MainPanel.removeAll();
MainPanel.add(panelRPTt);
MainPanel.repaint();
MainPanel.revalidate();

                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e.getMessage());
                        e.printStackTrace();
                    }
                }
        } else {
            try {
                
                if (jRadioButton8.isSelected() == true) {
                    
                    try {
                        
                        Connection connn4 = (Connection) db_Connection.getInstance();
                        
// JasperDesign jd = JRXmlLoader.load("C:\\Users\\Stevoski\\Documents\\Scanned Documents\\Canning\\src\\newpackage1\\DatebtwnReport.jrxml");
//                  64BIT OS
//                        JasperDesign jd = JRXmlLoader.load("C:\\Program Files (x86)\\Cost\\DatebtwnReport.jrxml");
//                        JasperDesign SUBjd = JRXmlLoader.load("C:\\Program Files (x86)\\Cost\\DatebtwnReport_subreport2.jrxml");
//JasperDesign SUBjd = JRXmlLoader.load("C:\\Program Files (x86)\\Cost\\DatebtwnReport_subreport2.jrxml");
//                  32BIT OS
JasperDesign jd = JRXmlLoader.load("C:\\Program Files\\Cost\\DatebtwnReport.jrxml");
JasperDesign SUBjd = JRXmlLoader.load("C:\\Program Files\\Cost\\DatebtwnReport_subreport2.jrxml");

//                InputStream jrM1 = getClass().getResourceAsStream("DatetwnReport.jasper");
//                InputStream jSr1 = getClass().getResourceAsStream("DatebtwnReport_rawsubreport.jasper");
//                JasperDesign jd = JRXmlLoader.load(jrM1);
String sqlie = "  SELECT \n" +
"        `costingprodn`.`voucher_no` AS `voucher_no`,\n" +
"        `costingprodn`.`production_id` AS `production_id`,\n" +
"        `prodpriceinclusive`.`date` AS `date`,\n" +
"        `prodpriceinclusive`.`factory` AS `factory`,\n" +
"        `prodpriceinclusive`.`groupe` AS `groupe`,\n" +
"        `prodpriceinclusive`.`product_name` AS `product_name`,\n" +
"      (`prodpriceinclusive`.`quantity`) AS `quantity`,\n" +
"        `prodpriceinclusive`.`quantityKGS` AS `quantityKGS`,\n" +
"    `prodpriceinclusive`.`waste` AS `waste`,\n" +
"        `costingprodn`.`electricity` AS `electricity`,\n" +
"        `costingprodn`.`can_name` AS `can`,\n" +
"        `costingprodn`.`no_of_cans` AS `no of can`,\n" +
"        `costingprodn`.`label_name` AS `label`,\n" +
"        `costingprodn`.`no_of_labels` AS `no of labels`,\n" +
"        `prodpriceinclusive`.`manpower_hrs` AS `manpower_hrs`,\n" +
"        `costingprodn`.`fuel` AS `fuel`,\n" +
"        `ingredpriceinc`.`ingredient_name` AS `ingredient`,\n" +
"        `ingredpriceinc`.`ingredient_qty` AS `ing_qty`,\n" +
"        `ingredpriceinc`.`amount` AS `amount`,\n" +
"        `rawmatpriceinc`.`raw_material` AS `raw_material`,\n" +
"        `rawmatpriceinc`.`qty` AS `raw_material_qty`,\n" +
"        `rawmatpriceinc`.`amount` AS `raw_material_amount`,\n" +
"   `costingprodn`.`remarks` AS `remarks`,\n" +
"        `neview`.`ingredient` AS `roomo`,\n" +
"        `neview`.`ing_qty` AS `qoatoo`,\n" +
"	sum(distinct  `neview`.`ing_qty`) as `total qty`,\n" +
" `costingprodn`.`can_waste` AS `can_waste`,\n" +
         " `costingprodn`.`briquette` AS `briquette`,\n" +
       " `costingprodn`.`briquetteamount` AS `briquetteamount`,\n" +
       " `costingprodn`.`diesel` AS `diesel`,\n" +
       " `costingprodn`.`dieselamount` AS `dieselamount`\n" +
"    FROM\n" +
"        ((((`costingprodn`\n" +
"        LEFT JOIN `prodpriceinclusive` ON (((`prodpriceinclusive`.`voucher_no` = `costingprodn`.`voucher_no`)\n" +
"            AND (`costingprodn`.`production_id` = `prodpriceinclusive`.`ProductionID`))))\n" +
"        LEFT JOIN `ingredpriceinc` ON (((`ingredpriceinc`.`voucher_no` = `costingprodn`.`voucher_no`)\n" +
"            AND (`ingredpriceinc`.`ProductionID` = `prodpriceinclusive`.`ProductionID`))))\n" +
"        LEFT JOIN `rawmatpriceinc` ON (((`rawmatpriceinc`.`voucher_no` = `costingprodn`.`voucher_no`)\n" +
"            AND (`rawmatpriceinc`.`ProductionID` = `prodpriceinclusive`.`ProductionID`))))\n" +
"        LEFT JOIN `neview` ON (((`neview`.`voucher_no` = `costingprodn`.`voucher_no`)\n" +
"            AND (`neview`.`ProductionID`=`prodpriceinclusive`.`ProductionID`)))) \n" 
         + "                  where `prodpriceinclusive`.`ProductionID` ='" + Disppl + "' and `prodpriceinclusive`.`factory` ='" + access + "'\n"
        + "    GROUP BY `neview`.`voucher_no`,`neview`.`ProductionID`  ";
JRDesignQuery NewQuery = new JRDesignQuery();
NewQuery.setText(sqlie);
jd.setQuery(NewQuery);

JasperReport jasperMasterReport = JasperCompileManager.compileReport(jd);
JasperReport jsr = JasperCompileManager.compileReport(SUBjd);

//         JasperReport jasperMasterReport = JasperCompileManager.compileReport(masterReportSource);
//JasperReport jasperSubReport = JasperCompileManager.compileReport(SUBjd);
//
//Map<String, Object> parameters = new HashMap()<String, Object>;
//parameters.put("subreportParameter", jasperSubReport);
//
//JasperFillManager.fillReportToFile(jasperMasterReport, parameters, connection);
Map<String, Object> paramsi = new HashMap<String, Object>();
//                Map<String, Object> params = new HashMap<>()<String, Object()>;
paramsi.put("par1", jsr);

//JasperFillManager.fillReportToFile(jasperMasterReport, parameters, connn);
JasperPrint jp = JasperFillManager.fillReport(jasperMasterReport, paramsi, connn4);

//DISPLAY IN JPANEL
BorderLayout layoutPanel = new BorderLayout();
JPanel panelRPTt = new JPanel(layoutPanel);
JRViewer vw = new JRViewer(jp);
panelRPTt.setLayout(new BorderLayout());
panelRPTt.repaint();
panelRPTt.add(vw);
panelRPTt.revalidate();

MainPanel.removeAll();
MainPanel.add(panelRPTt);
MainPanel.repaint();
MainPanel.revalidate();
                   } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e.getMessage());
                        e.printStackTrace();
                    }
                } else if (jRadioButton9.isSelected() == true) {
                    try {
                      
                        Connection connn5 =(Connection) db_Connection.getInstance();
//                        JasperDesign jd = JRXmlLoader.load("C:\\Program Files (x86)\\Cost\\DatebtwnReport.jrxml");
//                        JasperDesign SUBjd = JRXmlLoader.load("C:\\Program Files (x86)\\Cost\\DatebtwnReport_subreport2.jrxml");

//64BIT OS
//                        JasperDesign jd = JRXmlLoader.load("C:\\Program Files (x86)\\Cost\\DatebtwnReport.jrxml");
//                        JasperDesign SUBjd = JRXmlLoader.load("C:\\Program Files (x86)\\Cost\\DatebtwnReport_subreport2.jrxml");
//32 BIT OS
JasperDesign jd = JRXmlLoader.load("C:\\Program Files\\Cost\\DatebtwnReport.jrxml");
JasperDesign SUBjd = JRXmlLoader.load("C:\\Program Files\\Cost\\DatebtwnReport_subreport2.jrxml");
String sqlie = " SELECT \n" +
"        `costingprodn`.`voucher_no` AS `voucher_no`,\n" +
"        `costingprodn`.`production_id` AS `production_id`,\n" +
"        `prodpriceinclusive`.`date` AS `date`,\n" +
"        `prodpriceinclusive`.`factory` AS `factory`,\n" +
"        `prodpriceinclusive`.`groupe` AS `groupe`,\n" +
"        `prodpriceinclusive`.`product_name` AS `product_name`,\n" +
"      (`prodpriceinclusive`.`quantity`) AS `quantity`,\n" +
"        `prodpriceinclusive`.`quantityKGS` AS `quantityKGS`,\n" +
"    `prodpriceinclusive`.`waste` AS `waste`,\n" +
"        `costingprodn`.`electricity` AS `electricity`,\n" +
"        `costingprodn`.`can_name` AS `can`,\n" +
"        `costingprodn`.`no_of_cans` AS `no of can`,\n" +
"        `costingprodn`.`label_name` AS `label`,\n" +
"        `costingprodn`.`no_of_labels` AS `no of labels`,\n" +
"        `prodpriceinclusive`.`manpower_hrs` AS `manpower_hrs`,\n" +
"        `costingprodn`.`fuel` AS `fuel`,\n" +
"        `ingredpriceinc`.`ingredient_name` AS `ingredient`,\n" +
"        `ingredpriceinc`.`ingredient_qty` AS `ing_qty`,\n" +
"        `ingredpriceinc`.`amount` AS `amount`,\n" +
"        `rawmatpriceinc`.`raw_material` AS `raw_material`,\n" +
"        `rawmatpriceinc`.`qty` AS `raw_material_qty`,\n" +
"        `rawmatpriceinc`.`amount` AS `raw_material_amount`,\n" +
"   `costingprodn`.`remarks` AS `remarks`,\n" +
"        `neview`.`ingredient` AS `roomo`,\n" +
"        `neview`.`ing_qty` AS `qoatoo`,\n" +
"	sum(distinct  `neview`.`ing_qty`) as `total qty`,\n" +
" `costingprodn`.`can_waste` AS `can_waste`,\n" +
         " `costingprodn`.`briquette` AS `briquette`,\n" +
       " `costingprodn`.`briquetteamount` AS `briquetteamount`,\n" +
       " `costingprodn`.`diesel` AS `diesel`,\n" +
       " `costingprodn`.`dieselamount` AS `dieselamount`\n" +
"    FROM\n" +
"        ((((`costingprodn`\n" +
"        LEFT JOIN `prodpriceinclusive` ON (((`prodpriceinclusive`.`voucher_no` = `costingprodn`.`voucher_no`)\n" +
"            AND (`costingprodn`.`production_id` = `prodpriceinclusive`.`ProductionID`))))\n" +
"        LEFT JOIN `ingredpriceinc` ON (((`ingredpriceinc`.`voucher_no` = `costingprodn`.`voucher_no`)\n" +
"            AND (`ingredpriceinc`.`ProductionID` = `prodpriceinclusive`.`ProductionID`))))\n" +
"        LEFT JOIN `rawmatpriceinc` ON (((`rawmatpriceinc`.`voucher_no` = `costingprodn`.`voucher_no`)\n" +
"            AND (`rawmatpriceinc`.`ProductionID` = `prodpriceinclusive`.`ProductionID`))))\n" +
"        LEFT JOIN `neview` ON (((`neview`.`voucher_no` = `costingprodn`.`voucher_no`)\n" +
"            AND (`neview`.`ProductionID`=`prodpriceinclusive`.`ProductionID`)))) \n" 
               + " where  prodpriceinclusive.date ='" + Dispdt + "' and `prodpriceinclusive`.`factory` ='" + access + "'\n"
        + "    GROUP BY prodpriceinclusive.voucher_no ,  prodpriceinclusive.groupe , prodpriceinclusive.product_name , prodpriceinclusive.ProductionID ";
JRDesignQuery NewQuery = new JRDesignQuery();
NewQuery.setText(sqlie);
jd.setQuery(NewQuery);
JasperReport jr = JasperCompileManager.compileReport(jd);
JasperReport jsr = JasperCompileManager.compileReport(SUBjd);
Map<String, Object> paramsi = new HashMap<String, Object>();

paramsi.put("par1", jsr);

JasperPrint jp = JasperFillManager.fillReport(jr, paramsi, connn5);

//DISPLAY IN JPANEL
BorderLayout layoutPanel1 = new BorderLayout();
JPanel panelRPTt1 = new JPanel(layoutPanel1);
JRViewer vw = new JRViewer(jp);
panelRPTt1.setLayout(new BorderLayout());
panelRPTt1.repaint();
panelRPTt1.add(vw);
panelRPTt1.revalidate();

MainPanel.removeAll();
MainPanel.add(panelRPTt1);
MainPanel.repaint();
MainPanel.revalidate();


                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e.getMessage());
                        
                        e.printStackTrace();
                        
                    }
                    
                } else if (jRadioButton13.isSelected() == true) {
                    try {
                        
                        Connection connn6 = (Connection) db_Connection.getInstance();
                        
//                        JasperDesign jd = JRXmlLoader.load("C:\\Users\\Stevoski\\Documents\\Scanned Documents\\Canning\\src\\CostReport.jrxml");
//                        JasperDesign SUBjd = JRXmlLoader.load("C:\\Program Files (x86)\\Cost\\DatebtwnReport_subreport2.jrxml");
//                  64BIT OS
//                        JasperDesign jd = JRXmlLoader.load("C:\\Program Files (x86)\\Cost\\DatebtwnReport.jrxml");
//                        JasperDesign SUBjd = JRXmlLoader.load("C:\\Program Files (x86)\\Cost\\DatebtwnReport_subreport2.jrxml");
//                  32BIT OS
JasperDesign jd = JRXmlLoader.load("C:\\Program Files\\Cost\\DatebtwnReport.jrxml");
JasperDesign SUBjd = JRXmlLoader.load("C:\\Program Files\\Cost\\DatebtwnReport_subreport2.jrxml");
//                InputStream jrM1 = getClass().getResourceAsStream("DatetwnReport.jasper");
//                InputStream jSr1 = getClass().getResourceAsStream("DatebtwnReport_rawsubreport.jasper");
//                JasperDesign jd = JRXmlLoader.load(jrM1);
String sqlie = "  SELECT \n" +
"        `costingprodn`.`voucher_no` AS `voucher_no`,\n" +
"        `costingprodn`.`production_id` AS `production_id`,\n" +
"        `prodpriceinclusive`.`date` AS `date`,\n" +
"        `prodpriceinclusive`.`factory` AS `factory`,\n" +
"        `prodpriceinclusive`.`groupe` AS `groupe`,\n" +
"        `prodpriceinclusive`.`product_name` AS `product_name`,\n" +
"      (`prodpriceinclusive`.`quantity`) AS `quantity`,\n" +
"        `prodpriceinclusive`.`quantityKGS` AS `quantityKGS`,\n" +
"    `prodpriceinclusive`.`waste` AS `waste`,\n" +
"        `costingprodn`.`electricity` AS `electricity`,\n" +
"        `costingprodn`.`can_name` AS `can`,\n" +
"        `costingprodn`.`no_of_cans` AS `no of can`,\n" +
"        `costingprodn`.`label_name` AS `label`,\n" +
"        `costingprodn`.`no_of_labels` AS `no of labels`,\n" +
"        `prodpriceinclusive`.`manpower_hrs` AS `manpower_hrs`,\n" +
"        `costingprodn`.`fuel` AS `fuel`,\n" +
"        `ingredpriceinc`.`ingredient_name` AS `ingredient`,\n" +
"        `ingredpriceinc`.`ingredient_qty` AS `ing_qty`,\n" +
"        `ingredpriceinc`.`amount` AS `amount`,\n" +
"        `rawmatpriceinc`.`raw_material` AS `raw_material`,\n" +
"        `rawmatpriceinc`.`qty` AS `raw_material_qty`,\n" +
"        `rawmatpriceinc`.`amount` AS `raw_material_amount`,\n" +
"   `costingprodn`.`remarks` AS `remarks`,\n" +
"        `neview`.`ingredient` AS `roomo`,\n" +
"        `neview`.`ing_qty` AS `qoatoo`,\n" +
"	sum(distinct  `neview`.`ing_qty`) as `total qty`,\n" +
" `costingprodn`.`can_waste` AS `can_waste`,\n" +
         " `costingprodn`.`briquette` AS `briquette`,\n" +
       " `costingprodn`.`briquetteamount` AS `briquetteamount`,\n" +
       " `costingprodn`.`diesel` AS `diesel`,\n" +
       " `costingprodn`.`dieselamount` AS `dieselamount`\n" +
"    FROM\n" +
"        ((((`costingprodn`\n" +
"        LEFT JOIN `prodpriceinclusive` ON (((`prodpriceinclusive`.`voucher_no` = `costingprodn`.`voucher_no`)\n" +
"            AND (`costingprodn`.`production_id` = `prodpriceinclusive`.`ProductionID`))))\n" +
"        LEFT JOIN `ingredpriceinc` ON (((`ingredpriceinc`.`voucher_no` = `costingprodn`.`voucher_no`)\n" +
"            AND (`ingredpriceinc`.`ProductionID` = `prodpriceinclusive`.`ProductionID`))))\n" +
"        LEFT JOIN `rawmatpriceinc` ON (((`rawmatpriceinc`.`voucher_no` = `costingprodn`.`voucher_no`)\n" +
"            AND (`rawmatpriceinc`.`ProductionID` = `prodpriceinclusive`.`ProductionID`))))\n" +
"        LEFT JOIN `neview` ON (((`neview`.`voucher_no` = `costingprodn`.`voucher_no`)\n" +
"            AND (`neview`.`ProductionID`=`prodpriceinclusive`.`ProductionID`)))) \n" 
               + " where `prodpriceinclusive`.`factory` ='" + access + "' and prodpriceinclusive.date >='" + prt1 + "' and prodpriceinclusive.date<='" + prt2 + "'\n"
        + "    GROUP BY prodpriceinclusive.voucher_no ,  prodpriceinclusive.groupe , prodpriceinclusive.product_name , prodpriceinclusive.ProductionID ";
JRDesignQuery NewQuery = new JRDesignQuery();
NewQuery.setText(sqlie);
jd.setQuery(NewQuery);

JasperReport jasperMasterReport = JasperCompileManager.compileReport(jd);

JasperReport jsr = JasperCompileManager.compileReport(SUBjd);
Map<String, Object> paramsi = new HashMap<String, Object>();
//                Map<String, Object> params = new HashMap<>()<String, Object()>;
paramsi.put("par1", jsr);

//JasperFillManager.fillReportToFile(jasperMasterReport, parameters, connn);
JasperPrint jp = JasperFillManager.fillReport(jasperMasterReport, paramsi, connn6);

//DISPLAY IN JPANEL
BorderLayout layoutPanel = new BorderLayout();
JPanel panelRPTt = new JPanel(layoutPanel);
JRViewer vw = new JRViewer(jp);
panelRPTt.setLayout(new BorderLayout());
panelRPTt.repaint();
panelRPTt.add(vw);
panelRPTt.revalidate();

MainPanel.removeAll();
MainPanel.add(panelRPTt);
MainPanel.repaint();
MainPanel.revalidate();

                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e.getMessage());
                        e.printStackTrace();
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Please Select an Option");
                }
                
//        JFrame yourComponent = new JFrame();
//        PrinterJob pjob = PrinterJob.getPrinterJob();
//        PageFormat preformat = pjob.defaultPage();
//        preformat.setOrientation(PageFormat.LANDSCAPE);
//        PageFormat postformat = pjob.pageDialog(preformat);
////If user does not hit cancel then print.
//        if (preformat != postformat) {
//            //Set print component
//            pjob.setPrintable(new Printer(yourComponent), postformat);
//            if (pjob.printDialog()) {
//                try {
//                    pjob.print();
//                } catch (PrinterException ex) {
//                    Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//        }}
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
                e.printStackTrace();
            }
        }
        // TODO add your handling code here:
    } 
}
