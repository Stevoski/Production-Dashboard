package requisation.requisation;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JCheckBox;

import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.awt.event.ActionEvent;
import java.awt.CardLayout;
import java.awt.Checkbox;

import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

import java.awt.Color;
import javax.swing.JSplitPane;
import java.awt.FlowLayout;
import javax.swing.JScrollPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import javax.swing.BoxLayout;
import javax.swing.DefaultCellEditor;

import net.miginfocom.swing.MigLayout;
import java.awt.GridLayout;
import java.awt.SystemColor;
import com.toedter.calendar.JDateChooser;

//import javafx.scene.control.TableColumn;

import javax.swing.JTabbedPane;
import java.awt.Component;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JSeparator;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class RequesitionClass extends JFrame {

	public JPanel contentPane;
	public JPanel panelMother, panelTopPane, panelCenterCard, panelForMovement, panelMAkeNewReq;

	public JTable tableMovementView  = new JTable();
	public JPanel panel_forApproval;
	public JPanel panel_rawMatMove;
	public JPanel panel_AddReq;
	public JPanel panel;
	public JComboBox comboBox_ToChoose;
	public JTextField textField_Search;
	public JButton button_search;
	public JTable tableToShowRawMaterialStock;
	public JScrollPane scrollPane;
	public JPanel panel_3;
	public JButton btnNewButton_addMakeToTable;
	public JTextField textField_GetReqNo;
	public JTextField textField_GetQuantity;
	public JTable table_MAkeRequisition;
	public JPanel panel_4;
	public JScrollPane scrollPane_1;
	public JLabel lblItem;
	public JComboBox comboBox_GetItemsName;
	public JSeparator separator_7;
	public JSeparator separator_8;
	public JPanel panel_1;
	public JButton btnNewButton_DeleteRowReq;
	public JButton btnNewButton_SaveReq;
	public DefaultTableModel tableModel = new DefaultTableModel();
	public JPanel panel_2;
	public JButton btnPendingRequisitions;
	public JButton btnApprovedRequisitions;
	public JSeparator separator_6;
	public JPanel panel_approvalMotherpane;
	public JPanel panel_PendingPane;
	public JPanel panel_5;
	private JPanel panel_for_approval;
	private JButton btnApprove;
	private JLabel lblTheTableBelow;
	private JSeparator separator_9;
	private JSeparator separator_10;
	private JComboBox comboBoxChooseCategory;
	private JButton btnStoreview;
	private JButton btnF1Requisitions;
	private JButton btnF2Requisitions;
	private JButton btnF3Requisitions;
	private JButton btnF4Requisitions;
	private JButton btn5Requisitions;
	private JButton btnF6Requisitions;
	private JButton btnF7Requisitions;
	String comboStuff[] = {"APPROVED", "NOT APPROVED"};
	public JComboBox combochoice = new JComboBox(comboStuff);
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RequesitionClass frame = new RequesitionClass();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public RequesitionClass() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 948, 660);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(139, 69, 19));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		panelMother = new JPanel();
		panelMother.setBackground(new Color(139, 69, 19));
		contentPane.add(panelMother, "name_14950007521154");
		panelMother.setLayout(new BorderLayout(0, 0));
		
		panelTopPane = new JPanel();
		panelTopPane.setBackground(new Color(139, 69, 19));
		panelMother.add(panelTopPane, BorderLayout.NORTH);
		
		JButton btnRawMaterialMovement = new JButton("RAW MATERIAL MOVEMENT");
		btnRawMaterialMovement.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelCenterCard.removeAll();
				panelCenterCard.add(panelForMovement);
				panelCenterCard.repaint();
				panelCenterCard.revalidate();
			}
		});
		panelTopPane.add(btnRawMaterialMovement);
		
		JButton btnMakeReqisition = new JButton("MAKE REQISITION");
		btnMakeReqisition.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelCenterCard.removeAll();
				panelCenterCard.add(panelMAkeNewReq);
				panelCenterCard.repaint();
				panelCenterCard.revalidate();
			}
		});
		panelTopPane.add(btnMakeReqisition);
		
		btnApprove = new JButton("approve");
		btnApprove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.removeAll();
				contentPane.add(panel_forApproval);
				contentPane.repaint();
				contentPane.revalidate();
			}
		});
		panelTopPane.add(btnApprove);
		
		btnStoreview = new JButton("StoreView");
		panelTopPane.add(btnStoreview);
		
		panelCenterCard = new JPanel();
		panelMother.add(panelCenterCard, BorderLayout.CENTER);
		panelCenterCard.setLayout(new CardLayout(0, 0));
		
		panelForMovement = new JPanel();
		panelForMovement.setBackground(SystemColor.control);
		panelCenterCard.add(panelForMovement, "name_15619860029282");
		panelForMovement.setLayout(new CardLayout(0, 0));
		
		panel_rawMatMove = new JPanel();
		panelForMovement.add(panel_rawMatMove, "name_13092802632147");
		panel_rawMatMove.setLayout(new BorderLayout(0, 0));
		
		panel = new JPanel();
		panel.setBackground(new Color(255, 140, 0));
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 20));
		panel_rawMatMove.add(panel, BorderLayout.NORTH);
		
		lblTheTableBelow = new JLabel("THE TABLE BELOW SHOWS THE RAW MATERIAL STOCK MOVEMENT.");
		lblTheTableBelow.setFont(new Font("Nueva Std Cond", Font.BOLD, 20));
		lblTheTableBelow.setForeground(Color.BLACK);
		panel.add(lblTheTableBelow);
		
		separator_10 = new JSeparator();
		panel.add(separator_10);
		
		separator_9 = new JSeparator();
		panel.add(separator_9);
		
		comboBox_ToChoose = new JComboBox();
		comboBox_ToChoose.setModel(new DefaultComboBoxModel(new String[] {"-SELECT-", "1. DATE.", "2. REQUISITION NO.", "3. ITEM NAME."}));
		comboBox_ToChoose.setMaximumRowCount(40);
		panel.add(comboBox_ToChoose);
		
		textField_Search = new JTextField();
		textField_Search.setColumns(25);
		panel.add(textField_Search);
		
		button_search = new JButton("SEARCH");
		button_search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String comboSelect = comboBox_ToChoose.getSelectedItem().toString();
				String searchField = textField_Search.getText().toString();
				if (comboSelect != null && comboSelect != "-SELECT-" && searchField!= null){
					
				}
			}
		});
		panel.add(button_search);
		
		scrollPane = new JScrollPane();
		panel_rawMatMove.add(scrollPane, BorderLayout.CENTER);
		
		tableToShowRawMaterialStock = new JTable();
		scrollPane.setViewportView(tableToShowRawMaterialStock);
		tableToShowRawMaterialStock.setModel(new DefaultTableModel(
			new Object[][] {
				{"Date of Travel","Origin City", "Destination City","Flight No", "Destination COUNTY","TIME OF ARIVAL"},
				{"Date of Travel","Origin City", "Destination City","Flight No", "Destination COUNTY","TIME OF ARIVAL"},
				{"Date of Travel","Origin City", "Destination City","Flight No", "Destination COUNTY","TIME OF ARIVAL"},
				{"Date of Travel","Origin City", "Destination City","Flight No", "Destination COUNTY","TIME OF ARIVAL"},
				{"Date of Travel","Origin City", "Destination City","Flight No", "Destination COUNTY","TIME OF ARIVAL"},
				{"Date of Travel","Origin City", "Destination City","Flight No", "Destination COUNTY","TIME OF ARIVAL"},
				{"Date of Travel","Origin City", "Destination City","Flight No", "Destination COUNTY","TIME OF ARIVAL"},
				{"Date of Travel","Origin City", "Destination City","Flight No", "Destination COUNTY","TIME OF ARIVAL"},
				{"Date of Travel","Origin City", "Destination City","Flight No", "Destination COUNTY","TIME OF ARIVAL"},
				{"Date of Travel","Origin City", "Destination City","Flight No", "Destination COUNTY","TIME OF ARIVAL"},
				{"Date of Travel","Origin City", "Destination City","Flight No", "Destination COUNTY","TIME OF ARIVAL"},
				{"Date of Travel","Origin City", "Destination City","Flight No", "Destination COUNTY","TIME OF ARIVAL"}
			},
			new String[] {
				"DATE", "REQ NO", "ITEM NAME", "STOCK REQUESTED", "STOCK ISSUED", "STOCK B/F", "MATERIALS USED", "BALANCE"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				true, true, true, true, true, false, true, true
			};
			
		});
		tableToShowRawMaterialStock.getColumnModel().getColumn(0).setPreferredWidth(83);
		tableToShowRawMaterialStock.getColumnModel().getColumn(1).setPreferredWidth(96);
		tableToShowRawMaterialStock.getColumnModel().getColumn(2).setPreferredWidth(280);
		tableToShowRawMaterialStock.getColumnModel().getColumn(3).setPreferredWidth(128);
		tableToShowRawMaterialStock.getColumnModel().getColumn(4).setPreferredWidth(174);
		tableToShowRawMaterialStock.getColumnModel().getColumn(5).setPreferredWidth(113);
		tableToShowRawMaterialStock.getColumnModel().getColumn(6).setPreferredWidth(122);
		tableToShowRawMaterialStock.getColumnModel().getColumn(7).setPreferredWidth(111);
		tableToShowRawMaterialStock.setSurrendersFocusOnKeystroke(true);
		tableToShowRawMaterialStock.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		panelMAkeNewReq = new JPanel();
		panelMAkeNewReq.setBackground(SystemColor.menu);
		panelCenterCard.add(panelMAkeNewReq, "name_15629771593270");
		panelMAkeNewReq.setLayout(new CardLayout(0, 0));
		
		panel_AddReq = new JPanel();
		panelMAkeNewReq.add(panel_AddReq, "name_13104101122398");
		panel_AddReq.setLayout(new BorderLayout(0, 0));
		
		panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 140, 0));
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel_AddReq.add(panel_3, BorderLayout.NORTH);
		panel_3.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 20));
		
		JLabel lblChooseDate = new JLabel();
		DateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		System.out.println(dateFormat.format(cal.getTime()));
		lblChooseDate.setText(dateFormat.format(cal.getTime()));
		panel_3.add(lblChooseDate);
		
		JSeparator separator = new JSeparator();
		panel_3.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		panel_3.add(separator_1);
		
		JLabel lblAutoReqNo = new JLabel("AUTO REQ NO");
		panel_3.add(lblAutoReqNo);
		
		JSeparator separator_2 = new JSeparator();
		panel_3.add(separator_2);
		
		textField_GetReqNo = new JTextField();
		textField_GetReqNo.setEnabled(false);
		textField_GetReqNo.setEditable(false);
		textField_GetReqNo.setColumns(10);
		panel_3.add(textField_GetReqNo);
		
		separator_8 = new JSeparator();
		panel_3.add(separator_8);
		
		comboBoxChooseCategory = new JComboBox();
		comboBoxChooseCategory.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				String category = comboBoxChooseCategory.getSelectedItem().toString();
				
				if (category == "RAW MATERIAL"){ 
//					comboBox_GetItemsName shall get data from the raw material table
				} else if (category == "INGREDIENT"){
//					comboBox_GetItemsName shall get data from the INGRIDIENT table
				} else if (category == "PACKAGING MATERIALS"){
//				comboBox_GetItemsName shall get data from the PACKAGING MATERIALS table
				}
			}
		});
		comboBoxChooseCategory.setModel(new DefaultComboBoxModel(new String[] {"-CHOOSE CATEGORY-", "RAW MATERIAL", "INGRIDIENT", "PACKAGING MATERIALS", "OTHERS"}));
		panel_3.add(comboBoxChooseCategory);
		
		lblItem = new JLabel("ITEM");
		panel_3.add(lblItem);
		
		separator_7 = new JSeparator();
		panel_3.add(separator_7);
		
		comboBox_GetItemsName = new JComboBox();
		comboBox_GetItemsName.setModel(new DefaultComboBoxModel(new String[] {"SELECT ITEMS FROM DB"}));
		comboBox_GetItemsName.setEditable(true);
		panel_3.add(comboBox_GetItemsName);
		
		JSeparator separator_3 = new JSeparator();
		panel_3.add(separator_3);
		
		JLabel lblQuantity = new JLabel("QUANTITY");
		panel_3.add(lblQuantity);
		
		JSeparator separator_5 = new JSeparator();
		panel_3.add(separator_5);
		
		textField_GetQuantity = new JTextField();
		textField_GetQuantity.setColumns(10);
		panel_3.add(textField_GetQuantity);
		
		JSeparator separator_4 = new JSeparator();
		panel_3.add(separator_4);
		
		btnNewButton_addMakeToTable = new JButton("ADD");
		btnNewButton_addMakeToTable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
										
				DefaultTableModel moderode = (DefaultTableModel)table_MAkeRequisition.getModel();
				moderode.addRow(new Object[]{lblChooseDate.getText(), textField_GetReqNo.getText(), comboBox_GetItemsName.getSelectedItem(), 
						textField_GetQuantity.getText()});
			}
		});
		panel_3.add(btnNewButton_addMakeToTable);
		
		panel_4 = new JPanel();
		panel_AddReq.add(panel_4, BorderLayout.CENTER);
		panel_4.setLayout(new CardLayout(0, 0));
		
		scrollPane_1 = new JScrollPane();
		panel_4.add(scrollPane_1, "name_14209706435882");		
		table_MAkeRequisition = new JTable();
		table_MAkeRequisition.setModel(new DefaultTableModel(
				new Object[][] { },
				new String[] {
					"DATE", "REQUISITION NO", "ITEM NAME", "QUANTIIES IN KGs"
				}
			));
		table_MAkeRequisition.setFont(new Font("Tahoma", Font.PLAIN, 15));
		scrollPane_1.setViewportView(table_MAkeRequisition);
		
		panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 140, 0));
		panel_AddReq.add(panel_1, BorderLayout.SOUTH);
		
		btnNewButton_DeleteRowReq = new JButton("DELETE ROW");
		btnNewButton_DeleteRowReq.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DefaultTableModel mo_delete = (DefaultTableModel)table_MAkeRequisition.getModel();
				int SelectedRow = table_MAkeRequisition.getSelectedRow();
				mo_delete.removeRow(SelectedRow);
			}
		});
		panel_1.add(btnNewButton_DeleteRowReq);
		
		btnNewButton_SaveReq = new JButton("SAVE DATA");
		btnNewButton_SaveReq.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// HIS IS WHERE YOU PLACE DB CODE
				
			}
		});
		panel_1.add(btnNewButton_SaveReq);
		
		panel_forApproval = new JPanel();
		contentPane.add(panel_forApproval, "name_128558058348649");
		panel_forApproval.setBackground(SystemColor.inactiveCaptionBorder);
		panel_forApproval.setLayout(new BorderLayout(0, 0));
		
		panel_2 = new JPanel();
		panel_2.setBackground(new Color(139, 69, 19));
		panel_forApproval.add(panel_2, BorderLayout.NORTH);
		
		btnPendingRequisitions = new JButton("PENDING REQUISITIONS");
		panel_2.add(btnPendingRequisitions);
		
		separator_6 = new JSeparator();
		panel_2.add(separator_6);
		
		btnApprovedRequisitions = new JButton("APPROVED REQUISITIONS");
		panel_2.add(btnApprovedRequisitions);
		
		panel_approvalMotherpane = new JPanel();
		panel_forApproval.add(panel_approvalMotherpane, BorderLayout.CENTER);
		panel_approvalMotherpane.setLayout(new CardLayout(0, 0));
		
		panel_PendingPane = new JPanel();
		panel_approvalMotherpane.add(panel_PendingPane, "name_143354093814226");
		panel_PendingPane.setLayout(new BorderLayout(0, 0));
		
		panel_5 = new JPanel();
		panel_PendingPane.add(panel_5, BorderLayout.NORTH);
		
		panel_for_approval = new JPanel();
		panel_PendingPane.add(panel_for_approval, BorderLayout.CENTER);
		panel_for_approval.setLayout(new CardLayout(0, 0));
		
		btnF1Requisitions = new JButton("F1 REQUISITIONS");
		btnF1Requisitions.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					JScrollPane F2ScrollPane = new JScrollPane();
					String[][] data1 = { {"15-june-2018","656600", "white beans","56", ""} };
					String[] columns = { "DATE", "REQUISITION NO", "ITEM NAME", "QUANTIIES IN KGs", "APPROVAL"};
					JTable newF2Table = new JTable();
					newF2Table.setModel(new DefaultTableModel(data1, columns) {
							boolean[] columnEditables = new boolean[] {
									false, false, false, false, true
							};
					});
					
					javax.swing.table.TableColumn sportColumn = newF2Table.getColumnModel().getColumn(4);
			        sportColumn.setCellEditor(new DefaultCellEditor(combochoice));
					F2ScrollPane.setViewportView(newF2Table);
					panel_for_approval.add(F2ScrollPane);
				}
			}
		);
		panel_5.add(btnF1Requisitions);
		
		btnF2Requisitions = new JButton("F2 REQUISITIONS");
		btnF2Requisitions.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					JScrollPane F2ScrollPane = new JScrollPane();
					String[][] data1 = { {"15-june-2018","656600", "corn stach","56", ""} };
					String[] columns = { "DATE", "REQUISITION NO", "ITEM NAME", "QUANTIIES IN KGs", "APPROVAL"};
					JTable newF2Table = new JTable();
					newF2Table.setModel(new DefaultTableModel(data1, columns) {
							boolean[] columnEditables = new boolean[] {
									false, false, false, false, true
							};
					});
					
					
					javax.swing.table.TableColumn sportColumn = newF2Table.getColumnModel().getColumn(4);
			        sportColumn.setCellEditor(new DefaultCellEditor(combochoice));
					F2ScrollPane.setViewportView(newF2Table);
					panel_for_approval.add(F2ScrollPane);
				}
			});
		panel_5.add(btnF2Requisitions);
		
		btnF3Requisitions = new JButton("F3 REQUISITIONS");
		btnF3Requisitions.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					JScrollPane F2ScrollPane = new JScrollPane();
					String[][] data1 = { {"15-june-2018","656600", "cooking oil","56", ""} };
					String[] columns = { "DATE", "REQUISITION NO", "ITEM NAME", "QUANTIIES IN KGs", "APPROVAL"};
					JTable newF2Table = new JTable();
					newF2Table.setModel(new DefaultTableModel(data1, columns) {
							boolean[] columnEditables = new boolean[] {
									false, false, false, false, true
							};
					});
					
					javax.swing.table.TableColumn sportColumn = newF2Table.getColumnModel().getColumn(4);
			        sportColumn.setCellEditor(new DefaultCellEditor(combochoice));
					F2ScrollPane.setViewportView(newF2Table);
					panel_for_approval.add(F2ScrollPane);
				}
			});
		panel_5.add(btnF3Requisitions);
		
		btnF4Requisitions = new JButton("F4 REQUISITIONS");
		btnF4Requisitions.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					JScrollPane F2ScrollPane = new JScrollPane();
					String[][] data1 = { {"15-june-2018","656600", "packaging materials","56", ""} };
					String[] columns = { "DATE", "REQUISITION NO", "ITEM NAME", "QUANTIIES IN KGs", "APPROVAL"};
					JTable newF2Table = new JTable();
					newF2Table.setModel(new DefaultTableModel(data1, columns) {
							boolean[] columnEditables = new boolean[] {
									false, false, false, false, true
							};
					});
					
					javax.swing.table.TableColumn sportColumn = newF2Table.getColumnModel().getColumn(4);
			        sportColumn.setCellEditor(new DefaultCellEditor(combochoice));
					F2ScrollPane.setViewportView(newF2Table);
					panel_for_approval.add(F2ScrollPane);
				}
			});
		panel_5.add(btnF4Requisitions);
		
		btn5Requisitions = new JButton("F5 REQUISITIONS");
		btn5Requisitions.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					JScrollPane F2ScrollPane = new JScrollPane();
					String[][] data1 = { {"15-june-2018","656600", "curry powder","56", ""} };
					String[] columns = { "DATE", "REQUISITION NO", "ITEM NAME", "QUANTIIES IN KGs", "APPROVAL"};
					JTable newF2Table = new JTable();
					newF2Table.setModel(new DefaultTableModel(data1, columns) {
							boolean[] columnEditables = new boolean[] {
									false, false, false, false, true
							};
					});
					
					String comboStuff[] = {"APPROVED", "NOT APPROVED"};
					javax.swing.table.TableColumn sportColumn = newF2Table.getColumnModel().getColumn(4);
			        sportColumn.setCellEditor(new DefaultCellEditor(combochoice));
					F2ScrollPane.setViewportView(newF2Table);
					panel_for_approval.add(F2ScrollPane);
				}
			});
		panel_5.add(btn5Requisitions);
		
		btnF6Requisitions = new JButton("F6 REQUISITIONS");
		btnF6Requisitions.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					JScrollPane F2ScrollPane = new JScrollPane();
					String[][] data1 = { {"15-june-2018","656600", "chilli powder","56", ""} };
					String[] columns = { "DATE", "REQUISITION NO", "ITEM NAME", "QUANTIIES IN KGs", "APPROVAL"};
					JTable newF2Table = new JTable();
					newF2Table.setModel(new DefaultTableModel(data1, columns) {
							boolean[] columnEditables = new boolean[] {
									false, false, false, false, true
							};
					});
					
					javax.swing.table.TableColumn sportColumn = newF2Table.getColumnModel().getColumn(4);
			        sportColumn.setCellEditor(new DefaultCellEditor(combochoice));
					F2ScrollPane.setViewportView(newF2Table);
					panel_for_approval.add(F2ScrollPane);
				}
			});
		panel_5.add(btnF6Requisitions);
		
		btnF7Requisitions = new JButton("F7 REQUISITIONS");
		btnF7Requisitions.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					JScrollPane F2ScrollPane = new JScrollPane();
					String[][] data1 = { {"15-june-2018","656600", "packaging material","56", ""} };
					String[] columns = { "DATE", "REQUISITION NO", "ITEM NAME", "QUANTIIES IN KGs", "APPROVAL"};
					JTable newF2Table = new JTable();
					newF2Table.setModel(new DefaultTableModel(data1, columns) {
							boolean[] columnEditables = new boolean[] {
									false, false, false, false, true
							};
					});
					
					javax.swing.table.TableColumn sportColumn = newF2Table.getColumnModel().getColumn(4);
			        sportColumn.setCellEditor(new DefaultCellEditor(combochoice));
					F2ScrollPane.setViewportView(newF2Table);
					panel_for_approval.add(F2ScrollPane);
				}
			
		});
		panel_5.add(btnF7Requisitions);
		
		
		
	}
}
