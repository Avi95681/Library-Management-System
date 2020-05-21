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
import javax.swing.JList;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.Calendar;
import javax.swing.SpinnerListModel;


public class AddPeriodical extends JInternalFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_7;
	private JTextField textField_6;
	public AddPeriodical() {
		setBounds(0,0,750,600); 
		setIconifiable(true);
		setMaximizable(true);
		setClosable(true);
	
	
		getContentPane().setLayout(null);
		
		JLabel lblBookname = new JLabel("Periodical Title/Magazine");
		lblBookname.setFont(new Font("Copperplate Gothic",4,20));
		lblBookname.setBounds(43, 39, 229, 32);
		getContentPane().add(lblBookname);
		
		textField = new JTextField();
		textField.setFont(new Font("Copperplate Gothic",4,20));
		textField.setBounds(413, 39, 256, 32);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblPublisher = new JLabel("Writer");
		lblPublisher.setFont(new Font("Copperplate Gothic",4,20));
		lblPublisher.setBounds(43, 91, 135, 32);
		getContentPane().add(lblPublisher);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Copperplate Gothic",4,20));
		textField_1.setBounds(413, 91, 256, 32);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection cn= DriverManager.getConnection("jdbc:mysql://localhost:3306/Library?user=root&password=india@123");
					String query = "insert into periodicals(ptitle,pwriter,qty,price,page,periodicalid,year,remark) values(?,?,?,?,?,?,?,?)";
					PreparedStatement st= cn.prepareStatement(query);
					st.setString(1,textField.getText());
					st.setString(2,textField_1.getText());
					st.setInt(3,Integer.parseInt(textField_2.getText()));
					st.setInt(4,Integer.parseInt(textField_3.getText()));
					st.setInt(5,Integer.parseInt(textField_4.getText()));
					st.setInt(6,Integer.parseInt(textField_5.getText()));
					st.setInt(7,Integer.parseInt(textField_6.getText()));
					st.setString(8,textField_7.getText());
					st.executeUpdate();
					JOptionPane.showMessageDialog(null,"Data Saved");
					cn.close();
					textField.setText("");
					textField_1.setText("");
					textField_2.setText("");
					textField_3.setText("");
					textField_4.setText("");
					textField_5.setText("");
					textField_6.setText("");
					textField_7.setText("");
					
					
					
					
				} catch (Exception e1)
				{
					JOptionPane.showMessageDialog(null,e1.getMessage());
				}	
				
				
			}
		});
		btnSave.setBounds(397, 519, 129, 32);
		getContentPane().add(btnSave);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Copperplate Gothic",4,20));
		textField_2.setColumns(10);
		textField_2.setBounds(413, 141, 256, 32);
		getContentPane().add(textField_2);
		
		JLabel lblQuantity = new JLabel("Quantity");
		lblQuantity.setFont(new Font("Copperplate Gothic",4,20));
		lblQuantity.setBounds(43, 141, 135, 32);
		getContentPane().add(lblQuantity);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setFont(new Font("Copperplate Gothic",4,20));
		lblPrice.setBounds(43, 191, 135, 32);
		getContentPane().add(lblPrice);
		
		JLabel lblPageNo = new JLabel("Page No.");
		lblPageNo.setFont(new Font("Copperplate Gothic",4,20));
		lblPageNo.setBounds(43, 241, 135, 32);
		getContentPane().add(lblPageNo);
		
		JLabel lblBillNo = new JLabel("Periodical Id");
		lblBillNo.setFont(new Font("Copperplate Gothic",4,20));
		lblBillNo.setBounds(43, 291, 135, 32);
		getContentPane().add(lblBillNo);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Copperplate Gothic",4,20));
		textField_3.setColumns(10);
		textField_3.setBounds(413, 191, 256, 32);
		getContentPane().add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Copperplate Gothic",4,20));
		textField_4.setColumns(10);
		textField_4.setBounds(413, 241, 256, 32);
		getContentPane().add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Copperplate Gothic",4,20));
		textField_5.setColumns(10);
		textField_5.setBounds(413, 291, 256, 32);
		getContentPane().add(textField_5);
		
		
		JLabel lblYear = new JLabel("Year");
		lblYear.setFont(new Font("Copperplate Gothic",4,20));
		lblYear.setBounds(43, 341, 135, 32);
		getContentPane().add(lblYear);
		
		JLabel lblRemark = new JLabel("Remark");
		lblRemark.setFont(new Font("Copperplate Gothic",4,20));
		lblRemark.setBounds(43, 391, 135, 32);
		getContentPane().add(lblRemark);
		
		textField_7 = new JTextField();
		textField_7.setFont(new Font("Copperplate Gothic",4,20));
		textField_7.setColumns(10);
		textField_7.setBounds(413, 391, 256, 86);
		getContentPane().add(textField_7);
		
		textField_6 = new JTextField();
		textField_6.setFont(new Font("Dialog", Font.PLAIN, 20));
		textField_6.setColumns(10);
		textField_6.setBounds(413, 341, 256, 32);
		getContentPane().add(textField_6);

		
		
		
	
	}
}
