import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;

public class Booking extends JFrame {

	private JPanel contentpane;
	private JTextField textFieldName;
	private JTextField textFieldidd;
	private JTextField textFielG;
	private JTextField textFieldP;
	private JTextField textFieldr;
	private JTextField textFieldpt;
	private JTextField textFieldIDD;
	private JTextField textField_1;
	private JTextField textFielpc;
	//private JFrame frame;
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Booking frame = new Booking();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


   public Booking() {
   	setTitle("Customer");
	   setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 399);
		contentpane = new JPanel();
		contentpane.setBackground(new Color(201, 177, 201));
		contentpane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentpane);
		contentpane.setLayout(null);
		//////////////////////////////////////////////////////////
		JLabel lblInsert = new JLabel("Insert Informations");
		lblInsert.setFont(new Font("Engravers MT", Font.BOLD, 15));
		lblInsert.setForeground(new Color(51, 0, 0));
		lblInsert.setBounds(150, 10, 269, 43);
		contentpane.add(lblInsert);
		//////////////////////////////////////////////////////////
		JLabel lblEnterName = new JLabel("Enter Customer Name:");
		lblEnterName.setFont(new Font("Calibri", Font.BOLD, 14));
		lblEnterName.setForeground(new Color(51, 0, 0));
		lblEnterName.setBounds(10, 48, 269, 43);
		contentpane.add(lblEnterName);
		
		textFieldName = new JTextField();
		textFieldName.setBounds(10, 89, 244, 26);
		contentpane.add(textFieldName);
		textFieldName.setColumns(10);
		/////////////////////////////////////////////////////////////
		JLabel lblEnterGender = new JLabel("Enter Customer ID:");
		lblEnterGender.setFont(new Font("Calibri", Font.BOLD, 14));
		lblEnterGender.setForeground(new Color(51, 0, 0));
		lblEnterGender.setBounds(10, 110, 269, 43);
		contentpane.add(lblEnterGender);
		
		textFieldidd = new JTextField();
		textFieldidd.setBounds(10, 150, 244, 26);
		contentpane.add(textFieldidd);
		textFieldidd.setColumns(10);
		/////////////////////////////////////////////////////////////
		JLabel lblEnterPass= new JLabel("Enter Customers Gender");
		lblEnterPass.setFont(new Font("Calibri", Font.BOLD, 14));
		lblEnterPass.setForeground(new Color(51, 0, 0));
		lblEnterPass.setBounds(10, 177, 269, 43);
		contentpane.add(lblEnterPass);
		
		textFielG = new JTextField();
		textFielG.setBounds(10, 215, 244, 26);
		contentpane.add(textFielG);
		textFielG.setColumns(10);
		////////////////////////////////////////////////////////////
		JLabel lblEnterPhone= new JLabel("Enter Customers PassportNumber:");
		lblEnterPhone.setFont(new Font("Calibri", Font.BOLD, 14));
		lblEnterPhone.setForeground(new Color(51, 0, 0));
		lblEnterPhone.setBounds(330, 48, 269, 43);
		contentpane.add(lblEnterPhone);
		
		textFieldP = new JTextField();
		textFieldP.setBounds(330, 89, 244, 26);
		contentpane.add(textFieldP);
		textFieldP.setColumns(10);
		///////////////////////////////////////////////////////////
		JLabel lblEnterE= new JLabel("Enter CustomersRoomNumber:");
		lblEnterE.setFont(new Font("Calibri", Font.BOLD, 14));
		lblEnterE.setForeground(new Color(51, 0, 0));
		lblEnterE.setBounds(330, 110, 269, 43);
		contentpane.add(lblEnterE);
		
		textFieldr = new JTextField();
		textFieldr.setBounds(330, 150, 244, 26);
		contentpane.add(textFieldr);
		textFieldr.setColumns(10);
		//////////////////////////////////////////////////////////
		JLabel lblEnterId= new JLabel("Enter Customers PaymentType:");
		lblEnterId.setFont(new Font("Calibri", Font.BOLD, 14));
		lblEnterId.setForeground(new Color(51, 0, 0));
		lblEnterId.setBounds(330, 177, 269, 43);
		contentpane.add(lblEnterId);
		
		textFieldpt = new JTextField();
		textFieldpt.setBounds(330, 215, 244, 26);
		contentpane.add(textFieldpt);
		textFieldpt.setColumns(10);
		/////////////////////////////////////////////////////////
		JLabel lblNewLabel = new JLabel("Enter Customers Price:");
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 14));
		lblNewLabel.setBounds(213, 253, 182, 26);
		contentpane.add(lblNewLabel);
		
		textFielpc = new JTextField();
		textFielpc.setColumns(10);
		textFielpc.setBounds(178, 278, 244, 26);
		contentpane.add(textFielpc);
		////////////////////////////////////////////////////////////
		JButton btnInsert = new JButton("Insert");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel","root","nOhA31427112340");
                    
					String query= "Insert into Customer (CustomerName, CustomerID, CustomerGender, PassportNumber, RoomNumber, PaymentType,Price) values(?,?,?,?,?,?,?)  ";
					
					PreparedStatement pst = c.prepareStatement(query); // create statement
					
				    pst.setString(1, textFieldName.getText());
                    pst.setString(2, textFieldidd.getText());
                    pst.setString(3, textFielG.getText());
                    pst.setString(4, textFieldP.getText());
                    pst.setString(5, textFieldr.getText());
                    pst.setString(6, textFieldpt.getText());
                    pst.setString(7, textFielpc.getText());
                    pst.execute();
                    
                    JOptionPane.showMessageDialog(null, "Insert Completed!");
                    
                   pst.close();
				 	
				 	
					
					
				} catch (Exception es) {
			         JOptionPane.showMessageDialog(null, es);
			} }
		});
		
		btnInsert.setFont(new Font("Calibri", Font.PLAIN, 13));
		btnInsert.setBounds(247, 323, 95, 26);
		contentpane.add(btnInsert);
		/////////////////////////////////////////////////////////////////////////////////
		
		JLabel lblDeleteInformations = new JLabel("Delete Informations");
		lblDeleteInformations.setFont(new Font("Engravers MT", Font.BOLD, 15));
		lblDeleteInformations.setBounds(796, -1, 256, 70);
		contentpane.add(lblDeleteInformations);
		/////////////////////////////////////////////////////////////////////////////////
		JLabel lblEnterCustomerId = new JLabel("Enter Customer ID:");
		lblEnterCustomerId.setFont(new Font("Calibri", Font.BOLD, 14));
		lblEnterCustomerId.setBounds(821, 110, 135, 26);
		contentpane.add(lblEnterCustomerId);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(821, 150, 244, 26);
		contentpane.add(textField_1);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel","root","nOhA31427112340");

				    Statement mys = c.createStatement(); // create statement
					
					String rID1 = textField_1.getText();
					
					String deleteQuery = "delete from Customer where CustomerID  = '"+rID1+"' ";
					
					mys.execute(deleteQuery);
				 	JOptionPane.showMessageDialog(null, "Deleted successfully!");
				 	
					
					
				} catch (Exception es) {
			         JOptionPane.showMessageDialog(null, es);
			} }
		});
		btnDelete.setBounds(896, 197, 89, 23);
		contentpane.add(btnDelete);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				dispose();
				MainClass r = new MainClass();
				r.main(null);
			}
		});
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\nohaa\\Downloads\\eclipse-java-oxygen-2-win32-x86_64\\eclipse\\configuration\\org.eclipse.osgi\\427\\0\\.cp\\icons\\full\\dlcl16\\home_nav.png"));
		btnNewButton.setBounds(672, 22, 42, 37);
		contentpane.add(btnNewButton);
		
		
		
		////////////////////////////////////////////////////////////////////////////////
	
		

		
   }
   }