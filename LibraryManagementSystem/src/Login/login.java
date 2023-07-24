package Login;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.Component;
import javax.swing.Box;
import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.File;
import java.io.IOException;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;



public class login {

	private JFrame frame = new JFrame();
	private JTextField username;
	private JTextField password;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			
			public void run() {
				
				try {
					login window = new login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			
		});
	}

	/**
	 * Create the application.
	 */
	public login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
	
		frame.setBounds(100, 100, 1013, 670);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Login");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1.setBounds(461, 263, 78, 20);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Password");
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1_1.setBounds(459, 310, 105, 20);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		username = new JTextField();
		username.setBounds(570, 266, 194, 19);
		frame.getContentPane().add(username);
		username.setColumns(10);
		
		password = new JPasswordField();
		
		password.setColumns(10);
		password.setBounds(570, 313, 194, 19);
		frame.getContentPane().add(password);
		
		JButton cancel = new JButton("Cancel");
		cancel.setFont(new Font("Tahoma", Font.BOLD, 12));
		cancel.setIcon(new ImageIcon(login.class.getResource("/icons/red-x-mark-transparent-background-3.png")));
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
		});
		cancel.setBounds(601, 368, 111, 21);
		frame.getContentPane().add(cancel);
		
		final JButton Loginbtn = new JButton("Login");
		Loginbtn.setHorizontalAlignment(SwingConstants.LEFT);
		Loginbtn.setFont(new Font("Tahoma", Font.BOLD, 12));
		Loginbtn.setIcon(new ImageIcon(login.class.getResource("/icons/login.png")));
		Loginbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(username.getText().equals("Hardik")&&password.getText().equals("Hardik123")) {
					userInterface u = new userInterface();
					u.setVisible(true);
					
				}
				else {
					JOptionPane.showMessageDialog(Loginbtn, "Invalid Credentials");
				}
			}
		});
		Loginbtn.setBounds(476, 368, 105, 21);
		frame.getContentPane().add(Loginbtn);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
			}
		});
		lblNewLabel.setAlignmentX(Component.RIGHT_ALIGNMENT);
		lblNewLabel.setIcon(new ImageIcon(login.class.getResource("/icons/Login background.PNG")));
		lblNewLabel.setBounds(-220, 0, 1277, 623);
		frame.getContentPane().add(lblNewLabel);
	}

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		login window = new login();
		window.frame.setVisible(b);
		
	}
	}

	

	

