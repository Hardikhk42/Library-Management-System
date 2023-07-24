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
public class addBook extends JFrame {

	private JPanel contentPane;
	private JTextField bookNumber;
	private JTextField NameBook;
	private JTextField publisherName;
	private JTextField PublisherYear;
	private JTextField bookID;
	private JTextField bookName;
	private JTextField publisherNam;
	private JButton Save;
	private JButton Close;
	private JTextField publishedIn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addBook frame = new addBook();
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
	public addBook() {
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
		bookNumber.setText("bookID");
		bookNumber.setBounds(116, 100, 96, 19);
		contentPane.add(bookNumber);
		bookNumber.setColumns(10);
		
		NameBook = new JTextField();
		NameBook.setEditable(false);
		NameBook.setHorizontalAlignment(SwingConstants.CENTER);
		NameBook.setText("Title");
		NameBook.setColumns(10);
		NameBook.setBounds(116, 129, 96, 19);
		contentPane.add(NameBook);
		
		publisherName = new JTextField();
		publisherName.setEditable(false);
		publisherName.setHorizontalAlignment(SwingConstants.CENTER);
		publisherName.setText("Publisher");
		publisherName.setColumns(10);
		publisherName.setBounds(116, 164, 96, 19);
		contentPane.add(publisherName);
		
		PublisherYear = new JTextField();
		PublisherYear.setEditable(false);
		PublisherYear.setHorizontalAlignment(SwingConstants.CENTER);
		PublisherYear.setText("Year Published");
		PublisherYear.setColumns(10);
		PublisherYear.setBounds(116, 193, 96, 19);
		contentPane.add(PublisherYear);
		
		bookID = new JTextField();
		bookID.setColumns(10);
		bookID.setBounds(250, 100, 238, 19);
		contentPane.add(bookID);
		
		bookName = new JTextField();
		bookName.setColumns(10);
		bookName.setBounds(250, 129, 238, 19);
		contentPane.add(bookName);
		
		publisherNam = new JTextField();
		publisherNam.setColumns(10);
		publisherNam.setBounds(250, 164, 238, 19);
		contentPane.add(publisherNam);
		
		Save = new JButton("Save");
		Save.setHorizontalAlignment(SwingConstants.LEFT);
		Save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 int id = Integer.parseInt(bookID.getText());
	                String name = bookName.getText();
	                String publisher = publisherNam.getText();
	                int pubIn = Integer.parseInt(publishedIn.getText());
	                Connection connection=ConnectionProvider.getCon();
                    java.sql.Statement statement = null;

	                try {
	                   
	                  
	                    if (connection != null) {
	                        // Step 3: Prepare the UPDATE statement
	                    	statement = connection.createStatement();

	                        // Step 3: Define the SQL INSERT query
	                        String insertQuery = "INSERT INTO book (bookId, BookName, Publisher, PublishedIn) " +
	                                             "VALUES ('"+id+"', '"+name+"', '"+publisher+"', '"+pubIn+"')";
	                        
	                        statement.execute(insertQuery);
	                        
	                        JOptionPane.showMessageDialog(null, "Successfully Inserted");
	                        setVisible(false);
	                        addBook s = new addBook();
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
                
               
		Save.setIcon(new ImageIcon(login.class.getResource("/icons/login.png")));
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
		
		publishedIn = new JTextField();
		publishedIn.setColumns(10);
		publishedIn.setBounds(250, 193, 238, 19);
		contentPane.add(publishedIn);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(login.class.getResource("/icons/123456.png")));
		lblNewLabel.setBounds(-39, 5, 694, 394);
		contentPane.add(lblNewLabel);
		
	}
}
