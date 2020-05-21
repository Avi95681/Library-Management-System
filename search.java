import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import java.awt.BorderLayout;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.sql.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JScrollBar;
;
public class search extends JInternalFrame {
	private JTextField textField;
	private JTable table;
	public search() {
		setBounds(0,0,900,900); 
		setIconifiable(true);
		setMaximizable(true);
		setClosable(true);
		
		textField = new JTextField(); 
		textField.setFont(new Font("Arial",2,30));
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				fill(textField.getText());
			}
		});
		getContentPane().add(textField, BorderLayout.NORTH);
		textField.setColumns(10);
		
		table = new JTable();
		getContentPane().add(table, BorderLayout.CENTER);
		fill();

	}
	void fill(String str)
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/Library?user=root&password=india@123");
			String query="Select * from Books where bname like '"+str+"%'";
			PreparedStatement st = cn.prepareStatement(query);
			ResultSet rs = st.executeQuery();
			DefaultTableModel dtm = new DefaultTableModel();
			
			dtm.addColumn("BName");
			dtm.addColumn("Publication");
			dtm.addColumn("Quantity");
			dtm.addColumn("Price");
			dtm.addColumn("Page No.");
			dtm.addColumn("Bill No.");
			dtm.addColumn("Year");
			dtm.addColumn("Remark");
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
			String query="Select * from Books";
			PreparedStatement st = cn.prepareStatement(query);
			ResultSet rs = st.executeQuery();
			DefaultTableModel dtm = new DefaultTableModel();
			
			dtm.addColumn("BName");
			dtm.addColumn("Publication");
			dtm.addColumn("Quantity");
			dtm.addColumn("Price");
			dtm.addColumn("Page No.");
			dtm.addColumn("Bill No.");
			dtm.addColumn("Year");
			dtm.addColumn("Remark");
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
