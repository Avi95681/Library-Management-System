import java.awt.EventQueue;
import java.sql.*;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class Return extends JInternalFrame {
	private JTextField textField;
	  public Return() {
		setBounds(0,0,750,600); 
		setIconifiable(true);
		setMaximizable(true);
		setClosable(true);
		getContentPane().setLayout(null);
		
		JLabel lblTransactionId = new JLabel("Transaction Id");
		lblTransactionId.setBounds(35, 58, 137, 50);
		getContentPane().add(lblTransactionId);
		
		textField = new JTextField();
		textField.setBounds(197, 67, 200, 32);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnReturn = new JButton("Return");
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int tid = Integer.parseInt(textField.getText());
				int bid=getBookId(tid);
				if(bid==-1)
					JOptionPane.showMessageDialog(null,"Invalid Transaction Id");
				else
				{
					increaseQty(bid);
					updateTrans();
				}
			}
		});
		btnReturn.setBounds(242, 128, 97, 25);
		getContentPane().add(btnReturn);
	  }	
		int getBookId(int tid)
		{
			int t=-1;
			try
			 {
				 Class.forName("com.mysql.jdbc.Driver");
				 Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/Library?user=root&password=india@123");
				 String query ="Select * from Transaction where tid=?";
				 PreparedStatement st = cn.prepareStatement(query);
				 st.setInt(1,tid);
				 ResultSet rs= st.executeQuery();
				 if(rs.next())
					 t=rs.getInt(2);
				 cn.close();
			 }
			 catch(Exception e1)
			 {
				 JOptionPane.showMessageDialog(null,e1.getMessage());
			 }
			return t;
		}
		void increaseQty(int id)
		{
			try
			 {
				 Class.forName("com.mysql.jdbc.Driver");
				 Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/Library?user=root&password=india@123");
				 String query ="update Books set qty=qty+1 where bookid=?";
				 PreparedStatement st = cn.prepareStatement(query);
				 st.setInt(1,id);
				 st.executeUpdate();
				
				 cn.close();
			 }
			 catch(Exception e1)
			 {
				 JOptionPane.showMessageDialog(null,e1.getMessage());
			 }
			
		}
		void updateTrans()
		{
			try
			 {
				 Class.forName("com.mysql.jdbc.Driver");
				 Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/Library?user=root&password=india@123");
				 String query ="update Transaction set r_date=? where tid=?";
				 PreparedStatement st = cn.prepareStatement(query);
				 st.setString(1,new java.util.Date().toString());
				 st.setInt(2,Integer.parseInt(textField.getText())); 
				 st.executeUpdate();				
				 cn.close();
				 JOptionPane.showMessageDialog(null,"Book Returned");
			 }
			 catch(Exception e1)
			 {
				 JOptionPane.showMessageDialog(null,e1.getMessage());
			 }
			}

	

}
