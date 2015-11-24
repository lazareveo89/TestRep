package com.test.supportech.frames;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.TableRowSorter;

import com.test.supportech.tables.DepartmentTable;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	private DepartmentTable depTableModel = new DepartmentTable();
	private JTable depTable = new JTable(depTableModel);// указываем модель для
														// таблицы
	private TableRowSorter<DepartmentTable> rowSorter = new TableRowSorter<DepartmentTable>(
			(DepartmentTable) depTable.getModel());
	private JTextField jTextFilter = new JTextField();
	private JScrollPane jp = new JScrollPane(depTable);// прокрутка для таблицы
	private JButton closeButton = new JButton("Close");

	public MainFrame() {
		super("DepartmentList");
		this.setSize(800, 500);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(screenSize.width / 2 - this.getSize().width / 2,
				screenSize.height / 2 - this.getSize().height / 2);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());

		depTable.setRowSorter(rowSorter);
		JPanel jpanel = new JPanel(new BorderLayout());
		jpanel.add(new JLabel("Text search:"), BorderLayout.WEST);
		jpanel.add(closeButton, BorderLayout.EAST);
		this.add(jpanel, BorderLayout.SOUTH);
		this.add(jp, BorderLayout.CENTER);
		this.setVisible(true);
		init();
		depTableModel.addData();
	}

	private void init() {
		jTextFilter.getDocument().addDocumentListener(new DocumentListener() {

			public void removeUpdate(DocumentEvent e) {
				String text = jTextFilter.getText();

				if (text.trim().length() == 0) {
					rowSorter.setRowFilter(null);
				} else {
					rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
				}
			}

			public void insertUpdate(DocumentEvent e) {
				String text = jTextFilter.getText();

				if (text.trim().length() == 0) {
					rowSorter.setRowFilter(null);
				} else {
					rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
				}
			}

			public void changedUpdate(DocumentEvent e) {
			}

		});

		closeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame.this.dispose();
			}
		});
	}
}
