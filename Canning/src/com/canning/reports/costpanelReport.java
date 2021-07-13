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
import static newpackage1.NewJFrame.jComboBox24;
import static newpackage1.NewJFrame.jDate5;
import static newpackage1.NewJFrame.jDate6;
import static newpackage1.NewJFrame.jDateChooser1;
import static newpackage1.NewJFrame.jRadioButton1;
import static newpackage1.NewJFrame.jRadioButton10;
import static newpackage1.NewJFrame.jRadioButton2;
import static newpackage1.NewJFrame.jTextField25;
import static newpackage1.NewJFrame.MainPanel;
import static newpackage1.NewJFrame.jComboBox43;
import java.awt.Toolkit;
import java.util.HashMap;
import java.util.Map;
import static newpackage1.NewJFrame.jRadioButton23;
import newpackage1.db_Connection;

/**
 *
 * @author Stevoski
 */
public class costpanelReport {

    public static void Panel9report() throws HeadlessException {
        String rpp = ((JTextField) jDateChooser1.getDateEditor().getUiComponent()).getText();
        String btwn1 = ((JTextField) jDate5.getDateEditor().getUiComponent()).getText();
        String btwn2 = ((JTextField) jDate6.getDateEditor().getUiComponent()).getText();
        String prod = (String) jComboBox24.getSelectedItem();
        String Facto = (String) jComboBox43.getSelectedItem();
        String voucherrpt = jTextField25.getText();
        if (jComboBox43.getSelectedItem() == "All") {
            if (jRadioButton1.isSelected() == true) {

                try {
                    Connection connn = (Connection) db_Connection.getInstance();//                JasperDesign jd = JRXmlLoader.load("C:\\Users\\Stevoski\\Documents\\Scanned Documents\\Canning\\src\\CostReport.jrxml");
//                  64BIT OS
//                JasperDesign jd = JRXmlLoader.load("C:\\Program Files (x86)\\Cost\\CostReport.jrxml");
//                  32BIT OS
                    JasperDesign jd = JRXmlLoader.load("C:\\Program Files\\Cost\\newReport.jrxml");
                     JasperDesign subjd = JRXmlLoader.load("C:\\Program Files\\Cost\\newsubReport.jrxml");

//                InputStream input = ReportServlet.class.getResourceAsStream("+CostReport+" +".jasper");
//                JasperDesign jd = JRXmlLoader.load(input);
//                JasperDesign jd = JRXmlLoader.load(jd);
                    String sql = "select voucher_no,Production_ID,date,product,manpower,IngCost,RawCost,CanCost,LabelCost,EleCost,FuelCost,ManCost,Cperunit,quantity,waste_amount FROM new_view where date='" + rpp + "'  order by Production_ID";
                    JRDesignQuery NewQuery = new JRDesignQuery();
                    NewQuery.setText(sql);
                    jd.setQuery(NewQuery);
                    JasperReport jr = JasperCompileManager.compileReport(jd);
                    JasperReport jsr = JasperCompileManager.compileReport(subjd);
                    Map<String, Object> paramsie = new HashMap<String, Object>();
//                Map<String, Object> params = new HashMap<>()<String, Object()>;
                        paramsie.put("paramet1", jsr);
                    JasperPrint jp = JasperFillManager.fillReport(jr, paramsie, connn);

//DISPLAY IN JPANEL
                    BorderLayout layoutPanel = new BorderLayout();
                    JPanel panelRPT = new JPanel(layoutPanel);
                    JRViewer vw = new JRViewer(jp);
                    panelRPT.setLayout(new BorderLayout());
                    panelRPT.repaint();
                    panelRPT.add(vw);
                    panelRPT.revalidate();

                    MainPanel.removeAll();
                    MainPanel.add(panelRPT);
                    MainPanel.repaint();
                    MainPanel.revalidate();

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                    e.printStackTrace();
                }
            } else if (jRadioButton2.isSelected() == true) {
                try {

                    Connection connn = (Connection) db_Connection.getInstance();
//                JasperDesign jd = JRXmlLoader.load("C:\\Users\\Stevoski\\Documents\\Scanned Documents\\Canning\\src\\CostReport.jrxml");
//    64BIT OS
//                JasperDesign jd = JRXmlLoader.load("C:\\Program Files (x86)\\Cost\\CostReport.jrxml");
//                  32BIT OS
                   JasperDesign jd = JRXmlLoader.load("C:\\Program Files\\Cost\\newReport.jrxml");
                     JasperDesign subjd = JRXmlLoader.load("C:\\Program Files\\Cost\\newsubReport.jrxml");

                    String sql = "select voucher_no,Production_ID,date,product,manpower,IngCost,RawCost,CanCost,LabelCost,EleCost,FuelCost,ManCost,Cperunit,quantity,waste_amount FROM new_view where voucher_no='" + voucherrpt + "' order by Production_ID";
                    JRDesignQuery NewQuery = new JRDesignQuery();
                    NewQuery.setText(sql);
                    jd.setQuery(NewQuery);
                    JasperReport jr = JasperCompileManager.compileReport(jd);
                    JasperReport jsr = JasperCompileManager.compileReport(subjd);
                    Map<String, Object> paramsie = new HashMap<String, Object>();
//                Map<String, Object> params = new HashMap<>()<String, Object()>;
                        paramsie.put("paramet1", jsr);
                    JasperPrint jp = JasperFillManager.fillReport(jr, paramsie, connn);
                    BorderLayout layoutPanel1 = new BorderLayout();
                    JPanel panelRPT1 = new JPanel(layoutPanel1);
                    Toolkit toolkit = Toolkit.getDefaultToolkit();
                    int hch = (int) toolkit.getScreenSize().getHeight();
                    int wxh = (int) toolkit.getScreenSize().getWidth();
                    panelRPT1.setSize(wxh, hch);
                    JRViewer vw = new JRViewer(jp);
                    panelRPT1.setLayout(new BorderLayout());
                    panelRPT1.repaint();
                    panelRPT1.add(vw);
                    panelRPT1.revalidate();

                    MainPanel.removeAll();
                    MainPanel.add(panelRPT1);
                    MainPanel.repaint();
                    MainPanel.revalidate();

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());

                    e.printStackTrace();

                }
            } else if (jRadioButton10.isSelected() == true && jRadioButton23.isSelected() == true) {

                try {
                    Connection connn = (Connection) db_Connection.getInstance();
//                JasperDesign jd = JRXmlLoader.load("C:\\Users\\Stevoski\\Documents\\Scanned Documents\\Canning\\src\\CostReport.jrxml");
// 64BIT OS
//                JasperDesign jd = JRXmlLoader.load("C:\\Program Files (x86)\\Cost\\CostReport.jrxml");
//                  32BIT OS
                    JasperDesign jd = JRXmlLoader.load("C:\\Program Files\\Cost\\newReport.jrxml");
                     JasperDesign subjd = JRXmlLoader.load("C:\\Program Files\\Cost\\newsubReport.jrxml");

                    String sql = "select voucher_no,Production_ID,date,product,manpower,IngCost,RawCost,CanCost,LabelCost,EleCost,FuelCost,ManCost,Cperunit,quantity,waste_amount FROM new_view where product='" + prod + "' and date >='" + btwn1 + "' and date <= '" + btwn2 + "' order by Production_ID";

                    JRDesignQuery NewQuery = new JRDesignQuery();
                    NewQuery.setText(sql);
                    jd.setQuery(NewQuery);
                    JasperReport jr = JasperCompileManager.compileReport(jd);
                    JasperReport jsr = JasperCompileManager.compileReport(subjd);
                    Map<String, Object> paramsie = new HashMap<String, Object>();
//                Map<String, Object> params = new HashMap<>()<String, Object()>;
                        paramsie.put("paramet1", jsr);
                    JasperPrint jp = JasperFillManager.fillReport(jr, paramsie, connn);
                    BorderLayout layoutPanel2 = new BorderLayout();
                    JPanel panelRPT2 = new JPanel(layoutPanel2);
                    JRViewer vw = new JRViewer(jp);
                    panelRPT2.setLayout(new BorderLayout());
                    panelRPT2.repaint();
                    panelRPT2.add(vw);
                    panelRPT2.revalidate();

                    MainPanel.removeAll();
                    MainPanel.add(panelRPT2);
                    MainPanel.repaint();
                    MainPanel.revalidate();

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());

                    e.printStackTrace();

                }
            } else if (jRadioButton10.isSelected() == true && jRadioButton23.isSelected() == false) {
                try {
                    Connection connn = (Connection) db_Connection.getInstance();
//                JasperDesign jd = JRXmlLoader.load("C:\\Users\\Stevoski\\Documents\\Scanned Documents\\Canning\\src\\CostReport.jrxml");
// 64BIT OS
//                JasperDesign jd = JRXmlLoader.load("C:\\Program Files (x86)\\Cost\\CostReport.jrxml");
//                  32BIT OS
                    JasperDesign jd = JRXmlLoader.load("C:\\Program Files\\Cost\\newReport.jrxml");
                     JasperDesign subjd = JRXmlLoader.load("C:\\Program Files\\Cost\\newsubReport.jrxml");

                    String sql = "select voucher_no,Production_ID,date,product,manpower,IngCost,RawCost,CanCost,LabelCost,EleCost,FuelCost,ManCost,Cperunit,quantity,waste_amount FROM new_view where date >='" + btwn1 + "' and date <= '" + btwn2 + "' order by date";

                    JRDesignQuery NewQuery = new JRDesignQuery();
                    NewQuery.setText(sql);
                    jd.setQuery(NewQuery);
                    JasperReport jr = JasperCompileManager.compileReport(jd);
                    JasperReport jsr = JasperCompileManager.compileReport(subjd);
                    Map<String, Object> paramsie = new HashMap<String, Object>();
//                Map<String, Object> params = new HashMap<>()<String, Object()>;
                        paramsie.put("paramet1", jsr);
                    JasperPrint jp = JasperFillManager.fillReport(jr, paramsie, connn);

                    BorderLayout layoutPanel2 = new BorderLayout();
                    JPanel panelRPT2 = new JPanel(layoutPanel2);
                    JRViewer vw = new JRViewer(jp);
                    panelRPT2.setLayout(new BorderLayout());
                    panelRPT2.repaint();
                    panelRPT2.add(vw);
                    panelRPT2.revalidate();

                    MainPanel.removeAll();
                    MainPanel.add(panelRPT2);
                    MainPanel.repaint();
                    MainPanel.revalidate();

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());

                    e.printStackTrace();

                }
            } else {
                JOptionPane.showMessageDialog(null, "Please Select an Option");
            }
        } else {
            if (jRadioButton1.isSelected() == true) {

                try {
                    Connection connn = (Connection) db_Connection.getInstance();//                JasperDesign jd = JRXmlLoader.load("C:\\Users\\Stevoski\\Documents\\Scanned Documents\\Canning\\src\\CostReport.jrxml");
//                  64BIT OS
//                JasperDesign jd = JRXmlLoader.load("C:\\Program Files (x86)\\Cost\\CostReport.jrxml");
//                  32BIT OS
                    JasperDesign jd = JRXmlLoader.load("C:\\Program Files\\Cost\\newReport.jrxml");
                     JasperDesign subjd = JRXmlLoader.load("C:\\Program Files\\Cost\\newsubReport.jrxml");

//                InputStream input = ReportServlet.class.getResourceAsStream("+CostReport+" +".jasper");
//                JasperDesign jd = JRXmlLoader.load(input);
//                JasperDesign jd = JRXmlLoader.load(jd);
                    String sql = "select voucher_no,Production_ID,date,product,manpower,IngCost,RawCost,CanCost,LabelCost,EleCost,FuelCost,ManCost,Cperunit,quantity,waste_amount FROM new_view where factory ='" + Facto + "' and date='" + rpp + "'  order by Production_ID";
                    JRDesignQuery NewQuery = new JRDesignQuery();
                    NewQuery.setText(sql);
                    jd.setQuery(NewQuery);
                    JasperReport jr = JasperCompileManager.compileReport(jd);
                    JasperReport jsr = JasperCompileManager.compileReport(subjd);
                    Map<String, Object> paramsie = new HashMap<String, Object>();
//                Map<String, Object> params = new HashMap<>()<String, Object()>;
                        paramsie.put("paramet1", jsr);
                    JasperPrint jp = JasperFillManager.fillReport(jr, paramsie, connn);

//DISPLAY IN JPANEL
                    BorderLayout layoutPanel = new BorderLayout();
                    JPanel panelRPT = new JPanel(layoutPanel);
                    JRViewer vw = new JRViewer(jp);
                    panelRPT.setLayout(new BorderLayout());
                    panelRPT.repaint();
                    panelRPT.add(vw);
                    panelRPT.revalidate();

                    MainPanel.removeAll();
                    MainPanel.add(panelRPT);
                    MainPanel.repaint();
                    MainPanel.revalidate();

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                    e.printStackTrace();
                }
            } else if (jRadioButton2.isSelected() == true) {
                try {

                    Connection connn = (Connection) db_Connection.getInstance();
//                JasperDesign jd = JRXmlLoader.load("C:\\Users\\Stevoski\\Documents\\Scanned Documents\\Canning\\src\\CostReport.jrxml");
//    64BIT OS
//                JasperDesign jd = JRXmlLoader.load("C:\\Program Files (x86)\\Cost\\CostReport.jrxml");
//                  32BIT OS
                    JasperDesign jd = JRXmlLoader.load("C:\\Program Files\\Cost\\newReport.jrxml");
                     JasperDesign subjd = JRXmlLoader.load("C:\\Program Files\\Cost\\newsubReport.jrxml");

                    String sql = "select voucher_no,Production_ID,date,product,manpower,IngCost,RawCost,CanCost,LabelCost,EleCost,FuelCost,ManCost,Cperunit,quantity,waste_amount FROM new_view where factory ='" + Facto + "' and voucher_no='" + voucherrpt + "' order by Production_ID";
                    JRDesignQuery NewQuery = new JRDesignQuery();
                    NewQuery.setText(sql);
                    jd.setQuery(NewQuery);
                   JasperReport jr = JasperCompileManager.compileReport(jd);
                    JasperReport jsr = JasperCompileManager.compileReport(subjd);
                    Map<String, Object> paramsie = new HashMap<String, Object>();
//                Map<String, Object> params = new HashMap<>()<String, Object()>;
                        paramsie.put("paramet1", jsr);
                    JasperPrint jp = JasperFillManager.fillReport(jr, paramsie, connn);

                    BorderLayout layoutPanel1 = new BorderLayout();
                    JPanel panelRPT1 = new JPanel(layoutPanel1);
                    Toolkit toolkit = Toolkit.getDefaultToolkit();
                    int hch = (int) toolkit.getScreenSize().getHeight();
                    int wxh = (int) toolkit.getScreenSize().getWidth();
                    panelRPT1.setSize(wxh, hch);
                    JRViewer vw = new JRViewer(jp);
                    panelRPT1.setLayout(new BorderLayout());
                    panelRPT1.repaint();
                    panelRPT1.add(vw);
                    panelRPT1.revalidate();

                    MainPanel.removeAll();
                    MainPanel.add(panelRPT1);
                    MainPanel.repaint();
                    MainPanel.revalidate();

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());

                    e.printStackTrace();

                }
            } else if (jRadioButton10.isSelected() == true && jRadioButton23.isSelected() == true) {

                try {
                    Connection connn = (Connection) db_Connection.getInstance();
//                JasperDesign jd = JRXmlLoader.load("C:\\Users\\Stevoski\\Documents\\Scanned Documents\\Canning\\src\\CostReport.jrxml");
// 64BIT OS
//                JasperDesign jd = JRXmlLoader.load("C:\\Program Files (x86)\\Cost\\CostReport.jrxml");
//                  32BIT OS
                    JasperDesign jd = JRXmlLoader.load("C:\\Program Files\\Cost\\newReport.jrxml");
                     JasperDesign subjd = JRXmlLoader.load("C:\\Program Files\\Cost\\newsubReport.jrxml");

                    String sql = "select voucher_no,Production_ID,date,product,manpower,IngCost,RawCost,CanCost,LabelCost,EleCost,FuelCost,ManCost,Cperunit,quantity,waste_amount FROM new_view where factory ='" + Facto + "' and product='" + prod + "' and date >='" + btwn1 + "' and date <= '" + btwn2 + "' order by Production_ID";

                    JRDesignQuery NewQuery = new JRDesignQuery();
                    NewQuery.setText(sql);
                    jd.setQuery(NewQuery);
                   JasperReport jr = JasperCompileManager.compileReport(jd);
                    JasperReport jsr = JasperCompileManager.compileReport(subjd);
                    Map<String, Object> paramsie = new HashMap<String, Object>();
//                Map<String, Object> params = new HashMap<>()<String, Object()>;
                        paramsie.put("paramet1", jsr);
                    JasperPrint jp = JasperFillManager.fillReport(jr, paramsie, connn);

                    BorderLayout layoutPanel2 = new BorderLayout();
                    JPanel panelRPT2 = new JPanel(layoutPanel2);
                    JRViewer vw = new JRViewer(jp);
                    panelRPT2.setLayout(new BorderLayout());
                    panelRPT2.repaint();
                    panelRPT2.add(vw);
                    panelRPT2.revalidate();

                    MainPanel.removeAll();
                    MainPanel.add(panelRPT2);
                    MainPanel.repaint();
                    MainPanel.revalidate();

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());

                    e.printStackTrace();

                }
            } else if (jRadioButton10.isSelected() == true && jRadioButton23.isSelected() == false) {
                try {
                    Connection connn = (Connection) db_Connection.getInstance();
//                JasperDesign jd = JRXmlLoader.load("C:\\Users\\Stevoski\\Documents\\Scanned Documents\\Canning\\src\\CostReport.jrxml");
// 64BIT OS
//                JasperDesign jd = JRXmlLoader.load("C:\\Program Files (x86)\\Cost\\CostReport.jrxml");
//                  32BIT OS
                    JasperDesign jd = JRXmlLoader.load("C:\\Program Files\\Cost\\newReport.jrxml");
                     JasperDesign subjd = JRXmlLoader.load("C:\\Program Files\\Cost\\newsubReport.jrxml");

                    String sql = "select voucher_no,Production_ID,date,product,manpower,IngCost,RawCost,CanCost,LabelCost,EleCost,FuelCost,ManCost,Cperunit,quantity,waste_amount FROM new_view where factory ='" + Facto + "' and date >='" + btwn1 + "' and date <= '" + btwn2 + "' order by date";

                    JRDesignQuery NewQuery = new JRDesignQuery();
                    NewQuery.setText(sql);
                    jd.setQuery(NewQuery);
                   JasperReport jr = JasperCompileManager.compileReport(jd);
                    JasperReport jsr = JasperCompileManager.compileReport(subjd);
                    Map<String, Object> paramsie = new HashMap<String, Object>();
//                Map<String, Object> params = new HashMap<>()<String, Object()>;
                        paramsie.put("paramet1", jsr);
                    JasperPrint jp = JasperFillManager.fillReport(jr, paramsie, connn);

                    BorderLayout layoutPanel2 = new BorderLayout();
                    JPanel panelRPT2 = new JPanel(layoutPanel2);
                    JRViewer vw = new JRViewer(jp);
                    panelRPT2.setLayout(new BorderLayout());
                    panelRPT2.repaint();
                    panelRPT2.add(vw);
                    panelRPT2.revalidate();

                    MainPanel.removeAll();
                    MainPanel.add(panelRPT2);
                    MainPanel.repaint();
                    MainPanel.revalidate();

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());

                    e.printStackTrace();

                }
            } else {
                JOptionPane.showMessageDialog(null, "Please Select an Option");
            }
        }
    }
}
    //
