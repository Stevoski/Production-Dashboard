/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.canning.reports;

import java.awt.BorderLayout;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JRViewer;
import static newpackage1.NewJFrame.IngFormer;
import static newpackage1.NewJFrame.MainPanel;
import newpackage1.db_Connection;
import static newpackage1.ExportAndImport.jComboBox21;
import static newpackage1.ExportAndImport.jComboBox22;

/**
 *
 * @author Stevoski
 */
public class SummaryReport {

    public static void PrintSummaryreport() {
        String monthel = (String) jComboBox21.getSelectedItem();
        String factoe = (String) jComboBox22.getSelectedItem();
        if (factoe.equals("All")) {
            try {
                String sql = "SELECT * FROM Summary_view where month=  '" + monthel + "'";
                try {
                    Connection connn = (Connection) db_Connection.getInstance();
                    JasperDesign jd = JRXmlLoader.load("C:\\Program Files\\Cost\\summary report.jrxml");
                    JRDesignQuery NewQuery = new JRDesignQuery();
                    NewQuery.setText(sql);
                    jd.setQuery(NewQuery);
                    JasperReport jr = JasperCompileManager.compileReport(jd);
                    JasperPrint jp = JasperFillManager.fillReport(jr, null, connn);
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
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
                e.printStackTrace();
            }

        } else {
            try {
                String sql = "SELECT * FROM Summary_view where month=  '" + monthel + "' and factory= '" + factoe + "'";
                try {
                    Connection connn = (Connection) db_Connection.getInstance();
                    JasperDesign jd = JRXmlLoader.load("C:\\Program Files\\Cost\\summary report.jrxml");
                    JRDesignQuery NewQuery = new JRDesignQuery();
                    NewQuery.setText(sql);
                    jd.setQuery(NewQuery);
                    JasperReport jr = JasperCompileManager.compileReport(jd);
                    JasperPrint jp = JasperFillManager.fillReport(jr, null, connn);
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

            } catch (Exception ex) {
                ex.printStackTrace();
            }

        }

    }

    public static void printSummaryasCost() {
        String monthel = (String) jComboBox21.getSelectedItem();
        String factoe = (String) jComboBox22.getSelectedItem();
        if (factoe.equals("All")) {
            try {
                Connection connn = (Connection) db_Connection.getInstance();//                JasperDesign jd = JRXmlLoader.load("C:\\Users\\Stevoski\\Documents\\Scanned Documents\\Canning\\src\\CostReport.jrxml");
                JasperDesign jd = JRXmlLoader.load("C:\\Program Files\\Cost\\newReport.jrxml");
                JasperDesign subjd = JRXmlLoader.load("C:\\Program Files\\Cost\\newsubReport.jrxml");
                String sql = "select * from summary_cost where monthname(date)=  '" + monthel + "'";
                JRDesignQuery NewQuery = new JRDesignQuery();
                NewQuery.setText(sql);
                jd.setQuery(NewQuery);
                JasperReport jr = JasperCompileManager.compileReport(jd);
                JasperReport jsr = JasperCompileManager.compileReport(subjd);
                Map<String, Object> paramsie = new HashMap<String, Object>();
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
        } else {
            try {
                Connection connn = (Connection) db_Connection.getInstance();//                JasperDesign jd = JRXmlLoader.load("C:\\Users\\Stevoski\\Documents\\Scanned Documents\\Canning\\src\\CostReport.jrxml");
                JasperDesign jd = JRXmlLoader.load("C:\\Program Files\\Cost\\newReport.jrxml");
                JasperDesign subjd = JRXmlLoader.load("C:\\Program Files\\Cost\\newsubReport.jrxml");
                String sql = "select * from summary_cost where monthname(date)=  '" + monthel + "' and factory= '" + factoe + "'";
                JRDesignQuery NewQuery = new JRDesignQuery();
                NewQuery.setText(sql);
                jd.setQuery(NewQuery);
                JasperReport jr = JasperCompileManager.compileReport(jd);
                JasperReport jsr = JasperCompileManager.compileReport(subjd);
                Map<String, Object> paramsie = new HashMap<String, Object>();
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
        }
    }
}
