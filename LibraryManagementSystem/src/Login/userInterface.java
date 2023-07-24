package Login;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Panel;
import java.awt.Color;
import java.awt.Font;

public class userInterface extends JFrame  {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					userInterface frame = new userInterface();
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
	public userInterface() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1037, 612);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(238, 232, 170));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		ImageIcon backgroundImage = new ImageIcon(login.class.getResource("/icons/123456.png"));
		contentPane.setLayout(null);
		
		JButton btnNewButton_4 = new JButton("Add Book");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addBook a = new addBook();
				a.setVisible(true);
				a.setLocation(325,225);
				a.setUndecorated(true);
				
				
			}
		});
		btnNewButton_4.setIcon(new ImageIcon(login.class.getResource("/icons/New book.png")));
		btnNewButton_4.setBounds(0, 187, 178, 81);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_3 = new JButton("Issue Book");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				issueBook i =new issueBook();
				
				i.setUndecorated(true);
				i.setLocation(325,225);
				i.setVisible(true);
			}
		});
		btnNewButton_3.setIcon(new ImageIcon(login.class.getResource("/icons/issue.png")));
		btnNewButton_3.setBounds(845, 65, 178, 81);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_1 = new JButton("Return Book");
		btnNewButton_1.setIcon(new ImageIcon(login.class.getResource("/icons/return-book-1-560407.png")));
		btnNewButton_1.setSelectedIcon(new ImageIcon(login.class.getResource("/icons/return-book-1-560407.png")));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				returnBook i =new returnBook();
				i.setLocation(325,225);
				i.setUndecorated(true);
				
				i.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(845, 284, 178, 81);
		contentPane.add(btnNewButton_1);
		
		JButton Logout = new JButton("Logout");
		Logout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					login l = new login();
					l.setVisible(true);
					setVisible(false);
				
			}
		});
		Logout.setIcon(new ImageIcon(login.class.getResource("/icons/exit.png")));
		Logout.setSelectedIcon(new ImageIcon(login.class.getResource("/icons/exit.png")));
		Logout.setBounds(845, 494, 178, 81);
		contentPane.add(Logout);
		
		JButton member = new JButton("Add Member");
		member.setFont(new Font("Tahoma", Font.PLAIN, 10));
		member.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addStudent s = new addStudent();
				s.setLocation(325,225);
				s.setUndecorated(true);
				s.setVisible(true);
				
			}
		});
		member.setForeground(new Color(0, 0, 0));
		member.setBackground(new Color(240, 240, 240));
//		member.addActionListener(new ActionListener() {
//			
//		});
		member.setIcon(new ImageIcon(login.class.getResource("/icons/member-add-on-300x300.png")));
		member.setBounds(0, 0, 178, 81);
		contentPane.add(member);
		
		JButton btnClose = new JButton("Close\r\n");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(ABORT);
			}
		});
		btnClose.setIcon(new ImageIcon(userInterface.class.getResource("/icons/red-x-mark-transparent-background-3.png")));
		btnClose.setSelectedIcon(new ImageIcon(userInterface.class.getResource("/icons/red-x-mark-transparent-background-3.png")));
		btnClose.setBounds(0, 406, 178, 81);
		contentPane.add(btnClose);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(login.class.getResource("/icons/Library_Book_532388_1366x768.jpg")));
		lblNewLabel.setBounds(0, -19, 1054, 646);
		contentPane.add(lblNewLabel);
	}
}
