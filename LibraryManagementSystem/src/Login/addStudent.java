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
public class addStudent extends JFrame {

	private JPanel contentPane;
	private JTextField name;
	private JTextField txtFathersName;
	private JTextField txtMobileNumber;
	private JTextField txtBranch;
	private JTextField txtBranch_1;
	private JTextField studentID;
	private JTextField studentName;
	private JTextField fatherName;
	private JButton btnNewButton;
	private JButton btnNewButton_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addStudent frame = new addStudent();
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
	public addStudent() {
		setUndecorated(true);
		setLocation(325,225);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 614, 382);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		name = new JTextField();
		name.setEditable(false);
		name.setHorizontalAlignment(SwingConstants.CENTER);
		name.setText("ID");
		name.setBounds(116, 100, 96, 19);
		contentPane.add(name);
		name.setColumns(10);
		
		txtFathersName = new JTextField();
		txtFathersName.setEditable(false);
		txtFathersName.setHorizontalAlignment(SwingConstants.CENTER);
		txtFathersName.setText("Name");
		txtFathersName.setColumns(10);
		txtFathersName.setBounds(116, 129, 96, 19);
		contentPane.add(txtFathersName);
		
		txtMobileNumber = new JTextField();
		txtMobileNumber.setEditable(false);
		txtMobileNumber.setHorizontalAlignment(SwingConstants.CENTER);
		txtMobileNumber.setText("Father's Name");
		txtMobileNumber.setColumns(10);
		txtMobileNumber.setBounds(116, 164, 96, 19);
		contentPane.add(txtMobileNumber);
		
		txtBranch = new JTextField();
		txtBranch.setEditable(false);
		txtBranch.setHorizontalAlignment(SwingConstants.CENTER);
		txtBranch.setText("Course");
		txtBranch.setColumns(10);
		txtBranch.setBounds(116, 193, 96, 19);
		contentPane.add(txtBranch);
		
		txtBranch_1 = new JTextField();
		txtBranch_1.setEditable(false);
		txtBranch_1.setHorizontalAlignment(SwingConstants.CENTER);
		txtBranch_1.setText("Branch");
		txtBranch_1.setColumns(10);
		txtBranch_1.setBounds(116, 223, 96, 19);
		contentPane.add(txtBranch_1);
		
		studentID = new JTextField();
		studentID.setColumns(10);
		studentID.setBounds(250, 100, 238, 19);
		contentPane.add(studentID);
		
		studentName = new JTextField();
		studentName.setColumns(10);
		studentName.setBounds(250, 129, 238, 19);
		contentPane.add(studentName);
		
		fatherName = new JTextField();
		fatherName.setColumns(10);
		fatherName.setBounds(250, 164, 238, 19);
		contentPane.add(fatherName);
		
		final JComboBox courseName = new JComboBox();
		courseName.setModel(new DefaultComboBoxModel(new String[] {"B.Tech", "BCA", "MCA", "M.Tech"}));
		courseName.setBounds(250, 192, 238, 21);
		contentPane.add(courseName);
		
		final JComboBox branch = new JComboBox();
		branch.setModel(new DefaultComboBoxModel(new String[] {"Computer Science", "Artificial Intelligence", "Data Science", "Cyber Security"}));
		branch.setBounds(250, 222, 238, 21);
		contentPane.add(branch);
		
		btnNewButton = new JButton("Save");
		btnNewButton.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 int id = Integer.parseInt(studentID.getText());
	                String name = studentName.getText();
	                String fathersName = fatherName.getText();
	                String course = (String) courseName.getSelectedItem();
	                String branchs = (String) branch.getSelectedItem();
	                Connection connection=ConnectionProvider.getCon();
                    java.sql.Statement statement = null;

	                try {
	                   
	                  
	                    if (connection != null) {
	                        // Step 3: Prepare the UPDATE statement
	                    	statement = connection.createStatement();

	                        // Step 3: Define the SQL INSERT query
	                        String insertQuery = "INSERT INTO student (id, name, fathers_name, course, branch) " +
	                                             "VALUES ('"+id+"', '"+name+"', '"+fathersName+"', '"+course+"', '"+branchs+"')";
	                        statement.execute(insertQuery);
	                        
	                        JOptionPane.showMessageDialog(null, "Successfully Inserted");
	                        setVisible(false);
	                        addStudent s = new addStudent();
	                        s.setLocation(325,225);
	                        s.setVisible(true);
	                        
	                        

	                       
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
                
               
		btnNewButton.setIcon(new ImageIcon(login.class.getResource("/icons/login.png")));
		btnNewButton.setBounds(248, 272, 111, 21);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("Close");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnNewButton_1.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_1.setIcon(new ImageIcon(login.class.getResource("/icons/red-x-mark-transparent-background-3.png")));
		btnNewButton_1.setBounds(389, 272, 99, 21);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(login.class.getResource("/icons/123456.png")));
		lblNewLabel.setBounds(-39, 5, 694, 394);
		contentPane.add(lblNewLabel);
		
	}
}
