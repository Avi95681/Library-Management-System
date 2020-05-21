import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;

public class AddCustomer extends JInternalFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	public AddCustomer() {
		setBounds(0,0,950,900); 
		setIconifiable(true);
		setMaximizable(true);
		setClosable(true);
		getContentPane().setLayout(null);
		
		
		JLabel lblCustomerName = new JLabel("Student Name");
		lblCustomerName.setFont(new Font("Arial",2,20));
		lblCustomerName.setBounds(43, 39, 135, 32);
		getContentPane().add(lblCustomerName);
		
		
		textField = new JTextField();
		textField.setBounds(333, 39, 206, 32);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblCustomerPno = new JLabel("Student Pno");
		lblCustomerPno.setFont(new Font("Arial",2,20));
		lblCustomerPno.setBounds(43, 91, 135, 32);
		getContentPane().add(lblCustomerPno);
		
		textField_1 = new JTextField();
		textField_1.setBounds(333, 91, 206, 32);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblCourse = new JLabel("Course");
		lblCourse.setFont(new Font("Arial",2,20));
		lblCourse.setBounds(43, 141, 135, 32);
		getContentPane().add(lblCourse);
	
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(333, 141, 206, 32);
		getContentPane().add(textField_2);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Arial", Font.ITALIC, 20));
		lblAddress.setBounds(43, 241, 135, 32);
		getContentPane().add(lblAddress);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
				Class.forName("com.mysql.jdbc.Driver");
				Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/Library?user=root&password=india@123");
				String query = "insert into Customers(cname,pno,course,rollno,address) values(?,?,?,?,?)";
				PreparedStatement st = cn.prepareStatement(query);
				st.setString(1,textField.getText());
				st.setString(2,textField_1.getText());
				st.setString(3,textField_2.getText());
				st.setInt(4,Integer.parseInt(textField_4.getText()));
				st.setString(5,textField_3.getText());
				st.executeUpdate();
				JOptionPane.showMessageDialog(null,"Data Saved");
				cn.close();
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
				textField_4.setText("");
				}
				catch(Exception e1)
				{
					JOptionPane.showMessageDialog(null,e1.getMessage());
				}
			}
		});
		btnSave.setBounds(389, 407, 115, 40);
		getContentPane().add(btnSave);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(333, 241, 206, 79);
		getContentPane().add(textField_3);
		
		JLabel lblRollNo = new JLabel("Roll No");
		lblRollNo.setFont(new Font("Arial", Font.ITALIC, 20));
		lblRollNo.setBounds(43, 191, 135, 32);
		getContentPane().add(lblRollNo);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(333, 191, 206, 32);
		getContentPane().add(textField_4);
		

	}
}
