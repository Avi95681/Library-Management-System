
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;





import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.Font;

import javax.swing.JPasswordField;
import java.awt.Toolkit;


public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		
		super("Library Management System of SSVGI By Abhishek Jaiswal");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\HP\\Desktop\\ssvgi.jpg"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsername = new JLabel("User name");
		lblUsername.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 24));
		lblUsername.setBounds(52, 127, 179, 42);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 24));
		lblPassword.setBounds(52, 198, 162, 42);
		contentPane.add(lblPassword);
		
		textField = new JTextField();
		textField.setBounds(316, 133, 200, 31);
		contentPane.add(textField);
		textField.setFont(new Font("Copperplate Gothic",4,20));
		textField.setColumns(10);
		
		
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 18));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(textField.getText().equals("") || passwordField.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null,"Fields are Empty");
					return;
				}
				
				try
				{
				Class.forName("com.mysql.jdbc.Driver");
				Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/Library?user=root&password=india@123");
				Statement st = cn.createStatement();
				String query = "Select password from login where username = '"+ textField.getText()+"'";				
				ResultSet rs = st.executeQuery(query);
				
				String get_password="";
				while(rs.next())
				{
					get_password = rs.getString(1);				    
				}
				if(get_password.equals(passwordField.getText()))
						{
					        					        
					        Home h = new Home();
					        h.setVisible(true);
					        dispose();					       				       
						}
				else
				{
					JOptionPane.showMessageDialog(null,"Invalid Username or Password");
				}
			}
			catch(Exception e1)
			{
				JOptionPane.showMessageDialog(null,e1.getMessage());
			}
			}
			
		});
		
		btnLogin.setBounds(332, 294, 148, 42);
		contentPane.add(btnLogin);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(316, 207, 200, 31);
		contentPane.add(passwordField);
		passwordField.setFont(new Font("Copperplate Gothic",4,20));
		
		JLabel lblLogin = new JLabel("Welcome");
		lblLogin.setFont(new Font("Copperplate Gothic Bold", Font.ITALIC, 36));
		lblLogin.setBounds(187, 38, 257, 63);
		contentPane.add(lblLogin);
		
		JLabel label = new JLabel("New label");
		label.setIcon(new ImageIcon("C:\\Users\\HP\\Downloads\\henry-co-tqu0IOMaiU8-unsplash.jpg"));
		label.setBounds(0, 0, 582, 453);
		contentPane.add(label);
		
		
		
	
	}

}
