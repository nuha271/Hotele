import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class join extends JFrame {

	private JPanel contentPane;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					join frame = new join();
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
	public join() {
		setTitle("join");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCustomerName = new JLabel("Customer Name:");
		lblCustomerName.setForeground(new Color(51, 0, 0));
		lblCustomerName.setFont(new Font("Calibri", Font.BOLD, 14));
		lblCustomerName.setBounds(22, 78, 220, 30);
		contentPane.add(lblCustomerName);
		
		JLabel lblPrice = new JLabel("Price:");
		lblPrice.setForeground(new Color(51, 0, 0));
		lblPrice.setFont(new Font("Calibri", Font.BOLD, 14));
		lblPrice.setBounds(22, 166, 136, 30);
		contentPane.add(lblPrice);
		
		JLabel lblChickIn = new JLabel("Chick in:");
		lblChickIn.setForeground(new Color(51, 0, 0));
		lblChickIn.setFont(new Font("Calibri", Font.BOLD, 14));
		lblChickIn.setBounds(243, 78, 136, 30);
		contentPane.add(lblChickIn);
		
		JLabel lblChickOut = new JLabel("Chick out:");
		lblChickOut.setForeground(new Color(51, 0, 0));
		lblChickOut.setFont(new Font("Calibri", Font.BOLD, 14));
		lblChickOut.setBounds(243, 166, 163, 30);
		contentPane.add(lblChickOut);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(22, 115, 136, 20);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(22, 195, 136, 20);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(243, 115, 136, 20);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(243, 195, 136, 20);
		contentPane.add(textField_4);
		
		btnNewButton = new JButton("join");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
				Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel","root","nOhA31427112340");
					PreparedStatement s = (PreparedStatement)c.prepareStatement("select Customer.CustomerID,Customer.Price,Receptionist.CheckIn,Receptionist.CheckOut from Customer,Receptionist where Customer.CustomerID=Receptionist.CustomerID;"); 
						
					//JOptionPane.showMessageDialog(null, s.executeQuery());
						//String sql = "select* from  Manager where EmployeeID= ?";
						//s=c.prepareStatement(sql);
						//s.setString(1, txtId.getText());
						ResultSet myr = s.executeQuery();
						if(myr.next())
						{
							
							String st2=myr.getString("CustomerID");
							textField_1.setText(st2);
							String st3=myr.getString("Price");
							textField_2.setText(st3);
							String st4=myr.getString("CheckIn");
							textField_3.setText(st4);
							//String st5=myr.getString("check in ");
							//textField_3.setText(st5);
							String st6=myr.getString("checkout");
							textField_4.setText(st6);
							//String st7=myr.getString("EmployeeAddress");
							//textField_5.setText(st7);
							
						}
						
				}
					catch(Exception ex)
					{
						JOptionPane.showMessageDialog(null, ex);
					}
			}
		});
		btnNewButton.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				try
				{
				Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel","root","nOhA31427112340");
				PreparedStatement s = (PreparedStatement)c.prepareStatement("select Customer.CustomerID=?,Customer.Price,Receptionist.CheckIn,Receptionist.CheckOut from Customer,Receptionist where Customer.CustomerID=Receptionist.CustomerID"); 
						
						
						//String sql = "select* from  Manager where EmployeeID= ?";
						//s=c.prepareStatement(sql);
						//s.setString(1, txtId.getText());
						ResultSet myr = s.executeQuery();
						if(myr.next())
						{
							String st1=myr.getString("Customer ID");
							//textField.setText(st1);
							String st2=myr.getString("Customer Name");
							textField_1.setText(st2);
							String st3=myr.getString("Price");
							textField_2.setText(st3);
							//String st4=myr.getString("Employeebirthdata");
							//textField_7.setText(st4);
							String st5=myr.getString("check in ");
							textField_3.setText(st5);
							String st6=myr.getString("check out");
							textField_4.setText(st6);
							//String st7=myr.getString("EmployeeAddress");
							//textField_5.setText(st7);
							
						}
						
						
					}catch(Exception ex)
					{
						JOptionPane.showMessageDialog(null, ex);
					}
			}
		});
		btnNewButton.setBounds(146, 25, 96, 23);
		contentPane.add(btnNewButton);
	}
}
