import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.table.DefaultTableModel;

import java.awt.EventQueue;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


public class SearchCustomer extends JInternalFrame {
	private JTextField textField;
	private JTable table;
	public SearchCustomer() 
	{
		setBounds(0,0,900,900); 
		setIconifiable(true);
		setMaximizable(true);
		setClosable(true);
		
		textField = new JTextField();
		textField.setFont(new Font("Arial",2,30));
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
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
			String query="Select * from Customers where rollno like '"+str+"%'";
			PreparedStatement st = cn.prepareStatement(query);
			ResultSet rs = st.executeQuery();
			DefaultTableModel dtm = new DefaultTableModel();
			dtm.addColumn("rollno");
			dtm.addColumn("cname");
			dtm.addColumn("customer pno");
			dtm.addColumn("course");
			dtm.addColumn("address");
			
			while(rs.next())
			{
				dtm.addRow(new String[]{rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)});
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
			String query="Select * from Customers";
			PreparedStatement st = cn.prepareStatement(query);
			ResultSet rs = st.executeQuery();
			DefaultTableModel dtm = new DefaultTableModel();
			dtm.addColumn("rollno");
			dtm.addColumn("cname");
			dtm.addColumn("customer pno");
			dtm.addColumn("course");
			dtm.addColumn("address");
			while(rs.next())
			{
				dtm.addRow(new String[]{rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)});
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


	
