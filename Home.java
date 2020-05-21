import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JDesktopPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Home extends JFrame {
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
					frame.setVisible(true);
                    frame.setSize(1000,800);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */

		private JPanel contentPane;
	public Home() {


		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
                               
                               
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JDesktopPane desktopPane = new JDesktopPane();
		contentPane.add(desktopPane, BorderLayout.CENTER);
		
		JMenu mnBooks = new JMenu("Books");
		menuBar.add(mnBooks);
                                mnBooks.setFont(new Font("Arial",1,20));
		
		JMenuItem mntmAdd = new JMenuItem("Add Book");
        mntmAdd.setFont(new Font("Arial",1,20));
		mntmAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddBook ad = new AddBook();
				desktopPane.add(ad);
				ad.setVisible(true); 
			}
		});
		mnBooks.add(mntmAdd);
		
		JMenuItem mntmSearch = new JMenuItem("Search Book");
        mntmSearch.setFont(new Font("Arial",1,20));
		mntmSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				search s = new search();
				desktopPane.add(s);
				s.setVisible(true); 
			}
		});
		mnBooks.add(mntmSearch);
		
		JMenuItem mntmDeleteB = new JMenuItem("Delete Book");
        mntmDeleteB.setFont(new Font("Arial",1,20));
        mntmDeleteB.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Deletebook db = new Deletebook();
                desktopPane.add(db);
                db.setVisible(true); 
            }
        });
        mnBooks.add(mntmDeleteB);
		
		
		JMenu mnCustomers = new JMenu("Students");
		menuBar.add(mnCustomers);
        mnCustomers.setFont(new Font("Arial",1,20));

		JMenuItem mntmAddcustomer = new JMenuItem("Add Students");
        mntmAddcustomer.setFont(new Font("Arial",1,20));
		mntmAddcustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddCustomer ad = new AddCustomer();
				desktopPane.add(ad);
				ad.setVisible(true); 
			}
		});
		mnCustomers.add(mntmAddcustomer);
		
		JMenuItem mntmSearchcustomer = new JMenuItem("Search Student");
        mntmSearchcustomer.setFont(new Font("Arial",1,20));
		mntmSearchcustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SearchCustomer sc = new SearchCustomer();
				desktopPane.add(sc);
				sc.setVisible(true); 
			}
		});
		mnCustomers.add(mntmSearchcustomer);
		
		JMenuItem mntmDeleteS = new JMenuItem("Delete Student");
        mntmDeleteS.setFont(new Font("Arial",1,20));
        mntmDeleteS.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Deletestudent ds = new Deletestudent();
                desktopPane.add(ds);
                ds.setVisible(true); 
            }
        });
        mnCustomers.add(mntmDeleteS);
		
		JMenu mnTransactions = new JMenu("Transactions");
		menuBar.add(mnTransactions);
                                mnTransactions.setFont(new Font("Arial",1,20));
		
		JMenuItem mntmIssue = new JMenuItem("Issue");
                                mntmIssue.setFont(new Font("Arial",1,20));
		mntmIssue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Issue i = new Issue();
				desktopPane.add(i);
				i.setVisible(true);
			}
		});
		mnTransactions.add(mntmIssue);
		
		JMenuItem mntmReturn = new JMenuItem("Return");
        mntmReturn.setFont(new Font("Arial",1,20));
		mntmReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Return r = new Return();
				desktopPane.add(r);
				r.setVisible(true);
			}
		});
		mnTransactions.add(mntmReturn);
		
		JMenuItem mntmViewTrans = new JMenuItem("View");
        mntmViewTrans.setFont(new Font("Arial",1,20));
        mntmViewTrans.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                View v = new View();
                desktopPane.add(v);
                v.setVisible(true);
            }
        });
        mnTransactions.add(mntmViewTrans);
    }

}
