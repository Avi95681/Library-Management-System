import java.awt.EventQueue;
import java.sql.*;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.DriverManager;


public class Issue extends JInternalFrame {
	private JTextField textField;
	private JTextField textField_1;
	public Issue() {
		setBounds(0,0,750,600); 
		setIconifiable(true);
		setMaximizable(true);
		setClosable(true);
		getContentPane().setLayout(null);
		
		JLabel label = new JLabel("BookId");
		label.setBounds(22, 35, 200, 50);
		getContentPane().add(label);
		
		JLabel lblCustomerId = new JLabel("Student RollNo");
		lblCustomerId.setBounds(22, 98, 200, 50);
		getContentPane().add(lblCustomerId);
		
		textField = new JTextField();
		textField.setBounds(188, 45, 200, 31);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(188, 108, 200, 31);
		getContentPane().add(textField_1);
		
		JButton btnIssue=new JButton("Issue");
		btnIssue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int id=Integer.parseInt(textField.getText());
				int cid=Integer.parseInt(textField_1.getText());
				if(checkid(id)==false)
					JOptionPane.showMessageDialog(null,"Invalid Book Id");
				if(Isavail(id)==false){
					JOptionPane.showMessageDialog(null,"Sorry no more books are available");
				    return;
				}
				if(checkcid(cid)==false)
					JOptionPane.showMessageDialog(null,"Invalid Customer");
				else
				{
					decreaseQty(id);
					insertTrans();
				}
			}
		});
		btnIssue.setBounds(235, 174, 97, 25);
		getContentPane().add(btnIssue); 
	}
		boolean checkid(int id)
		{
			boolean valid=false;
			try
			 {
				 Class.forName("com.mysql.jdbc.Driver");
				 Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/Library?user=root&password=india@123");
				 String query ="Select * from Books where bookid=?";
				 PreparedStatement st = cn.prepareStatement(query);
				 st.setInt(1,id);
				 ResultSet rs= st.executeQuery();
				 if(rs.next())
					 valid=true;
				 cn.close();
			 }
			 catch(Exception e1)
			 {
				 JOptionPane.showMessageDialog(null,e1.getMessage());
			 }
			return valid;
		}
		boolean Isavail(int id)
		{
			boolean valid = false;
			try
			 {
				 Class.forName("com.mysql.jdbc.Driver");
				 Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/Library?user=root&password=india@123");
				 String query ="Select * from Books where bookid=? and Qty>0";
				 PreparedStatement st = cn.prepareStatement(query);
				 st.setInt(1,id);
				 ResultSet rs= st.executeQuery();
				 if(rs.next())
					 valid= true;
				 cn.close();
			 }
			 catch(Exception e1)
			 {
				 JOptionPane.showMessageDialog(null,e1.getMessage());
			 }
			return valid;
		}
		boolean checkcid(int cid)

		{
			boolean valid = false;
			try
			 {
				 Class.forName("com.mysql.jdbc.Driver");
				 Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/Library?user=root&password=india@123");
				 String query ="Select * from Customers where rollno=?";
				 PreparedStatement st = cn.prepareStatement(query);
				 st.setInt(1,cid);
				 ResultSet rs= st.executeQuery();
				 if(rs.next())
					 valid= true;
				 cn.close();
			 }
			 catch(Exception e1)
			 {
				 JOptionPane.showMessageDialog(null,e1.getMessage());
			 }
			return valid;
		}
		void decreaseQty(int id)
		{
			try
			 {
				 Class.forName("com.mysql.jdbc.Driver");
				 Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/Library?user=root&password=india@123");
				 String query ="update Books set qty=qty-1 where bookid=?";
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
		void insertTrans()
		{
			try
			 {
				 Class.forName("com.mysql.jdbc.Driver");
				 Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/Library?user=root&password=india@123");
				 String query ="insert into Transaction(bookid,rollno,i_date,r_date) values(?,?,?,?)";
				 PreparedStatement st = cn.prepareStatement(query);
				 st.setInt(1,Integer.parseInt(textField.getText()));
				 st.setInt(2,Integer.parseInt(textField_1.getText()));
				 st.setString(3,new java.util.Date().toString());
				 st.setString(4,"NA");
				 st.executeUpdate();				
				 cn.close();
				 JOptionPane.showMessageDialog(null,"Book Issued");
			 }
			 catch(Exception e1)
			 {
				 JOptionPane.showMessageDialog(null,e1.getMessage());
			 }
			}
}



