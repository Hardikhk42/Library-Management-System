package Login;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.beans.Statement;
import java.awt.event.ActionEvent;
import java.sql.*;
import connection.*;
public class returnBook extends JFrame {

	private JPanel contentPane;
	private JTextField book;
	private JTextField student;
	private JTextField txtMobileNumber;
	private JTextField txtBranch;
	private JTextField bookID;
	private JTextField studentID;
	private JTextField issueDate;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JTextField dueDate;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					returnBook frame = new returnBook();
					frame.setUndecorated(false);
					
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
	public returnBook() {
		setUndecorated(true);
		setLocation(325,225);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 614, 382);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		book = new JTextField();
		book.setEditable(false);
		book.setHorizontalAlignment(SwingConstants.CENTER);
		book.setText("Book ID");
		book.setBounds(116, 100, 96, 19);
		contentPane.add(book);
		book.setColumns(10);
		
		student = new JTextField();
		student.setEditable(false);
		student.setHorizontalAlignment(SwingConstants.CENTER);
		student.setText("Student ID");
		student.setColumns(10);
		student.setBounds(116, 129, 96, 19);
		contentPane.add(student);
		
		txtMobileNumber = new JTextField();
		txtMobileNumber.setEditable(false);
		txtMobileNumber.setHorizontalAlignment(SwingConstants.CENTER);
		txtMobileNumber.setText("Issue Date");
		txtMobileNumber.setColumns(10);
		txtMobileNumber.setBounds(116, 164, 96, 19);
		contentPane.add(txtMobileNumber);
		
		txtBranch = new JTextField();
		txtBranch.setEditable(false);
		txtBranch.setHorizontalAlignment(SwingConstants.CENTER);
		txtBranch.setText("Due Date");
		txtBranch.setColumns(10);
		txtBranch.setBounds(116, 193, 96, 19);
		contentPane.add(txtBranch);
		
		bookID = new JTextField();
		bookID.setColumns(10);
		bookID.setBounds(250, 100, 238, 19);
		contentPane.add(bookID);
		
		studentID = new JTextField();
		studentID.setColumns(10);
		studentID.setBounds(250, 129, 238, 19);
		contentPane.add(studentID);
		
		issueDate = new JTextField();
		issueDate.setColumns(10);
		issueDate.setBounds(250, 164, 238, 19);
		contentPane.add(issueDate);
		
		btnNewButton = new JButton("Return");
		btnNewButton.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 int book = Integer.parseInt(bookID.getText());
	                int student = Integer.parseInt(studentID.getText());
	                
	                Connection connection=ConnectionProvider.getCon();
                    java.sql.Statement statement = null;
                    	
	                try {
	                   
	                  
	                    if (connection != null) {
	                        // Step 3: Prepare the UPDATE statement
	                    	statement = connection.createStatement();
	                    	statement.executeUpdate("update issue set Returned='Yes' where bookId = '"+book+"' and studentId ='"+student+"'");
	                    	
	                    	JOptionPane.showMessageDialog(null, "Book Successfully Returned");
	                     }else {
	                    		JOptionPane.showMessageDialog(null, "Error Occured");
	                    		 setVisible(false);
	 	                        returnBook s = new returnBook();
	 	                        s.setLocation(325,225);
	 	                        s.setVisible(true);

	                    	}
	                        
	                   
	                } catch (SQLException ex) {
	                    ex.printStackTrace();
	                }
	               finally {
	                        try {
	                            // Step 6: Close the resources
	                            if (statement != null) {
	                                statement.close();
	                            }
	                            if (connection != null) {
	                                connection.close();
	                            }
	                        } catch (SQLException ex) {
	                            ex.printStackTrace();
	                        }
	                    }
	                }
			
	        });
                
               
		btnNewButton.setIcon(new ImageIcon(login.class.getResource("/icons/return book png.png")));
		btnNewButton.setBounds(250, 241, 111, 21);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("Close");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnNewButton_1.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_1.setIcon(new ImageIcon(login.class.getResource("/icons/red-x-mark-transparent-background-3.png")));
		btnNewButton_1.setBounds(391, 241, 99, 21);
		contentPane.add(btnNewButton_1);
		
		dueDate = new JTextField();
		dueDate.setColumns(10);
		dueDate.setBounds(250, 193, 238, 19);
		contentPane.add(dueDate);
		
		JButton btnNewButton_2 = new JButton("Search");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int book = Integer.parseInt(bookID.getText());
                int student = Integer.parseInt(studentID.getText());
                
                Connection connection=ConnectionProvider.getCon();
                java.sql.Statement statement = null;

                try {
                   
                  
                    if (connection != null) {
                        // Step 3: Prepare the UPDATE statement
                    	statement = connection.createStatement();
                    		ResultSet rs = statement.executeQuery("select* from issue where bookId = '"+book+"' and studentId = '"+student+"'");
                        // Step 3: Define the SQL INSERT query
                        if(rs.next()) {
                        	issueDate.setText(rs.getString(3));
                        	dueDate.setText(rs.getNString(4));
                        	bookID.setEditable(false);
                        	studentID.setEditable(false);
                        
                        }else {
                        	JOptionPane.showMessageDialog(null, "Book Id or Student Id is incorrect");
                        	 setVisible(false);
                             returnBook s = new returnBook();
                             s.setUndecorated(true);
                             s.setLocation(325,225);
                             s.setVisible(true);
                             
                        }
                        
                       
                       
                        
                    } else {
                    	JOptionPane.showMessageDialog(null, "Failed to establish a database connection.");
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
               finally {
                        try {
                            // Step 6: Close the resources
                            if (statement != null) {
                                statement.close();
                            }
                            if (connection != null) {
                                connection.close();
                            }
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                        }
                    }
                }
		
        });
				
		
		btnNewButton_2.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_2.setIcon(new ImageIcon(login.class.getResource("/icons/search.png")));
		btnNewButton_2.setBounds(500, 128, 104, 19);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(login.class.getResource("/icons/123456.png")));
		lblNewLabel.setBounds(-39, 5, 694, 394);
		contentPane.add(lblNewLabel);
		
	}
}
