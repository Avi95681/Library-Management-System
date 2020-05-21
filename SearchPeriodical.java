import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import java.awt.BorderLayout;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.sql.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JScrollBar;
;
public class SearchPeriodical extends JInternalFrame {
	private JTextField textField;
	private JTable table;
	public SearchPeriodical() {
		setBounds(0,0,970,710); 
		setIconifiable(true);
		setMaximizable(true);
		setClosable(true);
		
		textField = new JTextField(); 
		textField.setFont(new Font("Copperplate Gothic",4,30));
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				fill(textField.getText());
			}
		});
		getContentPane().add(textField, BorderLayout.NORTH);
		textField.setColumns(10);
		
		table = new JTable();
		table.setFont(new Font("Times New Roman", Font.BOLD, 14));
		getContentPane().add(table, BorderLayout.CENTER);
		fill();
		
		JScrollPane scrollPane = new JScrollPane(table,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		getContentPane().add(scrollPane,BorderLayout.CENTER);

	}
	void fill(String str)
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/Library?user=root&password=india@123");
			String query="Select * from periodicals where ptitle like '"+str+"%'";
			PreparedStatement st = cn.prepareStatement(query);
			ResultSet rs = st.executeQuery();
			DefaultTableModel dtm = new DefaultTableModel();
			
			dtm.addColumn("Periodical Id");
			dtm.addColumn("Periodical Name");
			dtm.addColumn("Writer");
			dtm.addColumn("Quantity");
			dtm.addColumn("Price");
			dtm.addColumn("Page No.");
			dtm.addColumn("Year");
			dtm.addColumn("Shelf No.");
			while(rs.next())
			{
				dtm.addRow(new String[]{rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8)});
			}
			cn.close();
			table.setModel(dtm);
			
		} 
		catch(Exception e1)
		{
			JOptionPane.showMessageDialog(null,e1.getMessage());
		}
	} 
	
	void fill()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/Library?user=root&password=india@123");
			String query="Select * from Periodicals";
			PreparedStatement st = cn.prepareStatement(query);
			ResultSet rs = st.executeQuery();
			DefaultTableModel dtm = new DefaultTableModel();
			
			dtm.addColumn("Periodical Id");
			dtm.addColumn("Periodical Name");
			dtm.addColumn("Writer");
			dtm.addColumn("Quantity");
			dtm.addColumn("Price");
			dtm.addColumn("Page No.");
			dtm.addColumn("Year");
			dtm.addColumn("Shelf No.");
			while(rs.next())
			{
				dtm.addRow(new String[]{rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8)});
			}
			cn.close();
			table.setModel(dtm);
		} 
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null,e.getMessage());
		}
		
	}

}
