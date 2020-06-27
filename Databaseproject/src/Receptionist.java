import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class Receptionist extends JFrame {
	
	
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	//private JFrame framer;
    
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Receptionist frame = new Receptionist();
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
	public Receptionist() {
		setTitle("Receptionist");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 620, 399);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEnterPaymentType = new JLabel("Enter reservation ID:");
		lblEnterPaymentType.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEnterPaymentType.setForeground(new Color(51, 0, 0));
		lblEnterPaymentType.setBounds(10, 48, 269, 43);
		contentPane.add(lblEnterPaymentType);
		
		textField = new JTextField();
		textField.setBounds(10, 89, 244, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel","root","nOhA31427112340");

				    Statement mys = c.createStatement(); // create statement
					
					String rID1 = textField_2.getText();
					
					String deleteQuery = "delete from Receptionist where ReservationID = '"+rID1+"' ";
					
					mys.execute(deleteQuery);
				 	JOptionPane.showMessageDialog(null, "Deleted successfully!");
				 	
					
					
				} catch (Exception es) {
			         JOptionPane.showMessageDialog(null, es);
			} }
		});
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnDelete.setBounds(424, 164, 95, 26);
		contentPane.add(btnDelete);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel","root","nOhA31427112340");

				    Statement mys = c.createStatement(); // create statement
			
				 	String rID = textField.getText();
				    String pt = textField_1.getText();
				 	
				 	String updateQuery = "update Receptionist set PaymentType = '"+pt+"' where ReservationID = '"+rID+"' ";
				 	mys.execute(updateQuery);
				 	JOptionPane.showMessageDialog(null, "Updated successfully!");
				 	
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, ex);
			} }
		});
		btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnUpdate.setBounds(80, 211, 95, 26);
		contentPane.add(btnUpdate);
		
		JLabel lblEnterNewInput = new JLabel("Enter new payment type:");
		lblEnterNewInput.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEnterNewInput.setForeground(new Color(51, 0, 0));
		lblEnterNewInput.setBounds(10, 126, 179, 26);
		contentPane.add(lblEnterNewInput);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(10, 165, 244, 26);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(350, 128, 244, 26);
		contentPane.add(textField_2);
		
		JLabel label = new JLabel("Enter reservation ID:");
		label.setForeground(new Color(51, 0, 0));
		label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label.setBounds(350, 89, 269, 43);
		contentPane.add(label);
		
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				MainClass r = new MainClass();
				r.main(null);
			}
		});
		button.setIcon(new ImageIcon("C:\\Users\\nohaa\\Downloads\\eclipse-java-oxygen-2-win32-x86_64\\eclipse\\configuration\\org.eclipse.osgi\\427\\0\\.cp\\icons\\full\\dlcl16\\home_nav.png"));
		button.setBounds(297, 24, 42, 37);
		contentPane.add(button);
	}
}
