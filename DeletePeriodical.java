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

public class DeletePeriodical extends JInternalFrame {
	private JTextField textField;
	public DeletePeriodical() {
		setBounds(0,0,750,600); 
		setIconifiable(true);
		setMaximizable(true);
		setClosable(true);
		getContentPane().setLayout(null);
		
		
		JLabel lblCustomerName = new JLabel("Periodical Id");
		lblCustomerName.setFont(new Font("Copperplate Gothic",4,20));
		lblCustomerName.setBounds(38, 167, 167, 32);
		getContentPane().add(lblCustomerName);
		
		
		textField = new JTextField();
		textField.setFont(new Font("Copperplate Gothic",4,20));
		textField.setBounds(346, 167, 206, 32);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnSave = new JButton("Delete");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
				Class.forName("com.mysql.jdbc.Driver");
				Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/Library?user=root&password=india@123");
				String query = "delete from Periodicals where periodicalid=?";
				PreparedStatement st = cn.prepareStatement(query);
				st.setInt(1,Integer.parseInt(textField.getText()));
				
				st.executeUpdate();
				JOptionPane.showMessageDialog(null,"Periodical Deleted");
				cn.close();
				textField.setText("");
				
				}
				catch(Exception e1)
				{
					JOptionPane.showMessageDialog(null,e1.getMessage());
				}
			}
		});
		btnSave.setBounds(384, 282, 115, 40);
		getContentPane().add(btnSave);
		

	}
}
