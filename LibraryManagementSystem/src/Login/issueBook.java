package Login;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
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
import java.text.SimpleDateFormat;
import java.util.Date;

import connection.*;
import javax.swing.JFormattedTextField;
import java.awt.List;
import com.toedter.calendar.JDateChooser;
public class issueBook extends JFrame {

	private JPanel contentPane;
	private JTextField bookNumber;
	private JTextField studentID;
	private JTextField issueDate;
	private JTextField due;
	private JTextField bookID;
	private JTextField stud;
	private JButton Save;
	private JButton Close;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					issueBook frame = new issueBook();
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
	private void initializeDateChooser() {

	    // Create the "Choose Date" button
	    
	}

	public issueBook() {
		setUndecorated(true);
		setLocation(325,225);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 614, 382);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		bookNumber = new JTextField();
		bookNumber.setEditable(false);
		bookNumber.setHorizontalAlignment(SwingConstants.CENTER);
		bookNumber.setText("Book ID");
		bookNumber.setBounds(116, 100, 96, 19);
		contentPane.add(bookNumber);
		bookNumber.setColumns(10);
		
		studentID = new JTextField();
		studentID.setEditable(false);
		studentID.setHorizontalAlignment(SwingConstants.CENTER);
		studentID.setText("Student ID");
		studentID.setColumns(10);
		studentID.setBounds(116, 129, 96, 19);
		contentPane.add(studentID);
		initializeDateChooser();
		
		issueDate = new JTextField();
		issueDate.setEditable(false);
		issueDate.setHorizontalAlignment(SwingConstants.CENTER);
		issueDate.setText("Issue Date");
		issueDate.setColumns(10);
		issueDate.setBounds(116, 164, 96, 19);
		contentPane.add(issueDate);
		
		due = new JTextField();
		due.setEditable(false);
		due.setHorizontalAlignment(SwingConstants.CENTER);
		due.setText("Due Date");
		due.setColumns(10);
		due.setBounds(116, 193, 96, 19);
		contentPane.add(due);
		
		bookID = new JTextField();
		bookID.setColumns(10);
		bookID.setBounds(250, 100, 238, 19);
		contentPane.add(bookID);
		
		stud = new JTextField();
		stud.setColumns(10);
		stud.setBounds(250, 129, 238, 19);
		contentPane.add(stud);
		final JDateChooser issuedDate = new JDateChooser();
		issuedDate.setBounds(250, 164, 238, 19);
		contentPane.add(issuedDate);
		
		
		final JDateChooser dateDue = new JDateChooser();
		dateDue.setBounds(250, 193, 238, 19);
		contentPane.add(dateDue);
		
		Save = new JButton("Save");
		Save.setHorizontalAlignment(SwingConstants.LEFT);
		Save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				SimpleDateFormat dFormat = new SimpleDateFormat("dd-MM-yyyy");
				 int id = Integer.parseInt(bookID.getText());
	             String studID = stud.getText();
	             String issued = dFormat.format(issuedDate.getDate());
	             String dueDate = dFormat.format(dateDue.getDate());
	             String returnBook = "No";
	
	                Connection connection=ConnectionProvider.getCon();
                    java.sql.Statement statement = null;

	                try {
	                  
	                    if (connection != null) {
	                        // Step 3: Prepare the UPDATE statement
	                    	statement = connection.createStatement();
	                    	ResultSet rs = statement.executeQuery("select *from book where bookId='"+id+"'");
	                    	if(rs.next()) {
	                    		ResultSet rs1 = statement.executeQuery("select *from student where id='"+studID+"'");
	                    			if(rs1.next()) {
	                    				String insertQuery = "INSERT INTO issue (bookId, studentId, issued , due, Returned)" +
	                                             "VALUES('"+id+"', '"+studID+"', '"+issued+"', '"+dueDate+"', '"+returnBook+"')";
	                        
						                        statement.execute(insertQuery);
						                        JOptionPane.showMessageDialog(null, "Book Successfully Issued");
						                        setVisible(false);
						                        issueBook s = new issueBook();
						                        s.setLocation(325,225);
						                        s.setVisible(true);
	                    			}else {
	                    				JOptionPane.showConfirmDialog(null, "Incorrect Student id");
	                    			}
	                    	}else {
	                    		JOptionPane.showConfirmDialog(null, "Incorrect BookId");
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
                
               
		Save.setIcon(new ImageIcon(login.class.getResource("/icons/login.png"))) ;
		Save.setBounds(248, 233, 111, 21);
		contentPane.add(Save);
		
	      

				
	        
		Close = new JButton("Close");
		Close.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		Close.setHorizontalAlignment(SwingConstants.LEFT);
		Close.setIcon(new ImageIcon(login.class.getResource("/icons/red-x-mark-transparent-background-3.png")));
		Close.setBounds(389, 233, 99, 21);
		contentPane.add(Close);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setLabelFor(issueDate);
		lblNewLabel.setIcon(new ImageIcon(login.class.getResource("/icons/123456.png")));
		lblNewLabel.setBounds(-39, 5, 694, 394);
		contentPane.add(lblNewLabel);
		
	
		
	}
}
