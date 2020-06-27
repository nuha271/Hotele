import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Choice;
import com.toedter.calendar.JDateChooser;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Label;
import java.awt.TextField;
import javax.swing.ImageIcon;

public class MangerView extends JFrame {

	private JPanel contentPane;
	private JTextField txtId;
	private JTextField txt_EmployeeName;
	private JTextField txt_EmployeeID;
	private JTextField txt_EmployeeGender;
	private JTextField txt_EmployeeSalary;
	private JTextField txt_EmployeePhone;
	private JTextField txt_EmployeeAddress;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField txt_BirthDay;
	private JTextField textField_7;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MangerView frame = new MangerView();
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
	public MangerView() {
		setTitle("Manager");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 655, 466);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter manager ID to search:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setForeground(new Color(51, 0, 0));
		lblNewLabel.setBounds(387, 11, 213, 40);
		contentPane.add(lblNewLabel);
		
		txtId = new JTextField();
		txtId.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				try
				{
					Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel","root","nOhA31427112340");
					PreparedStatement s = (PreparedStatement)c.prepareStatement("select* from  Manager where EmployeeID= ?");
					
					//String sql = "select* from  Manager where EmployeeID= ?";
					//s=c.prepareStatement(sql);
					s.setString(1, txtId.getText());
					ResultSet myr = s.executeQuery();
					if(myr.next())
					{
						String st1=myr.getString("Employeename");
						textField.setText(st1);
						String st2=myr.getString("EmployeeID");
						textField_1.setText(st2);
						String st3=myr.getString("EmployeeGender");
						textField_2.setText(st3);
						String st4=myr.getString("Employeebirthdata");
						textField_7.setText(st4);
						String st5=myr.getString("EmployeeSalary");
						textField_3.setText(st5);
						String st6=myr.getString("EmployeePhone");
						textField_4.setText(st6);
						String st7=myr.getString("EmployeeAddress");
						textField_5.setText(st7);
						
					}
					
					
				}catch(Exception ex)
				{
					JOptionPane.showMessageDialog(null, ex);
				}
			}
		});
		txtId.setBounds(387, 51, 199, 32);
		contentPane.add(txtId);
		txtId.setColumns(10);
		
		JButton btnInsert = new JButton("Insert");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel","root","nOhA31427112340");
					PreparedStatement s = (PreparedStatement)c.prepareStatement("insert into Manager (EmployeeName,EmployeeID,EmployeeGender,Employeebirthdata,EmployeeSalary,EmployeePhone,EmployeeAddress)values (?,?,?,?,?,?,?)");
					
					s.setString(1,txt_EmployeeName.getText());
					s.setString(2,txt_EmployeeID.getText());
					s.setString(3,txt_EmployeeGender.getText());
					s.setString(4,txt_BirthDay.getText());
					s.setString(5,txt_EmployeeSalary.getText());
					s.setString(6,txt_EmployeePhone.getText());
					s.setString(7,txt_EmployeeAddress.getText());
					
					s.executeUpdate();
					s.close();
					c.close();
					
					JOptionPane.showMessageDialog(null, "Inserted successfully!");
					

					
					
					
				}catch(Exception ex)
				{
					JOptionPane.showMessageDialog(null, ex);
				}
				
				
			}
		});
		btnInsert.setBounds(90, 350, 84, 32);
		contentPane.add(btnInsert);
		
		txt_EmployeeName = new JTextField();
		txt_EmployeeName.setBounds(172, 82, 86, 20);
		contentPane.add(txt_EmployeeName);
		txt_EmployeeName.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Employee Name:");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_1.setBounds(20, 84, 131, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblEmployeeId = new JLabel("Employee ID:");
		lblEmployeeId.setFont(new Font("Arial", Font.BOLD, 14));
		lblEmployeeId.setBounds(31, 115, 120, 14);
		contentPane.add(lblEmployeeId);
		
		JLabel lblEmployeeGender = new JLabel("Employee Gender:");
		lblEmployeeGender.setFont(new Font("Arial", Font.BOLD, 14));
		lblEmployeeGender.setBounds(20, 140, 131, 14);
		contentPane.add(lblEmployeeGender);
		
		JLabel lblEmployeeSalary = new JLabel("Employee Salary:");
		lblEmployeeSalary.setFont(new Font("Arial", Font.BOLD, 14));
		lblEmployeeSalary.setBounds(31, 200, 120, 14);
		contentPane.add(lblEmployeeSalary);
		
		JLabel lblEmployeePhone = new JLabel("Employee Phone:");
		lblEmployeePhone.setFont(new Font("Arial", Font.BOLD, 14));
		lblEmployeePhone.setBounds(31, 228, 131, 14);
		contentPane.add(lblEmployeePhone);
		
		JLabel lblEmployeeAddress = new JLabel("Employee Address:");
		lblEmployeeAddress.setFont(new Font("Arial", Font.BOLD, 14));
		lblEmployeeAddress.setBounds(20, 256, 142, 14);
		contentPane.add(lblEmployeeAddress);
		
		txt_EmployeeID = new JTextField();
		txt_EmployeeID.setColumns(10);
		txt_EmployeeID.setBounds(172, 113, 86, 20);
		contentPane.add(txt_EmployeeID);
		
		txt_EmployeeGender = new JTextField();
		txt_EmployeeGender.setColumns(10);
		txt_EmployeeGender.setBounds(172, 138, 86, 20);
		contentPane.add(txt_EmployeeGender);
		
		txt_EmployeeSalary = new JTextField();
		txt_EmployeeSalary.setColumns(10);
		txt_EmployeeSalary.setBounds(172, 198, 86, 20);
		contentPane.add(txt_EmployeeSalary);
		
		txt_BirthDay = new JTextField();
		txt_BirthDay.setColumns(10);
		txt_BirthDay.setBounds(172, 166, 86, 20);
		contentPane.add(txt_BirthDay);
		
		txt_EmployeePhone = new JTextField();
		txt_EmployeePhone.setColumns(10);
		txt_EmployeePhone.setBounds(172, 226, 86, 20);
		contentPane.add(txt_EmployeePhone);
		
		txt_EmployeeAddress = new JTextField();
		txt_EmployeeAddress.setColumns(10);
		txt_EmployeeAddress.setBounds(172, 254, 86, 20);
		contentPane.add(txt_EmployeeAddress);
		
		JLabel lblEmployeeBirthday = new JLabel("Employee BirthDay:");
		lblEmployeeBirthday.setFont(new Font("Arial", Font.BOLD, 14));
		lblEmployeeBirthday.setBounds(20, 175, 142, 14);
		contentPane.add(lblEmployeeBirthday);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(474, 112, 86, 20);
		contentPane.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(474, 143, 86, 20);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(474, 175, 86, 20);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(474, 237, 86, 20);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(474, 268, 86, 20);
		contentPane.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(474, 299, 86, 20);
		contentPane.add(textField_5);
		
		TextField textField_6 = new TextField();
		textField_6.setBounds(252, 299, -40, 20);
		contentPane.add(textField_6);
	
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(474, 206, 86, 20);
		contentPane.add(textField_7);
		
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				MainClass r = new MainClass();
				r.main(null);
			}
		});
		button.setIcon(new ImageIcon("C:\\Users\\nohaa\\Downloads\\eclipse-java-oxygen-2-win32-x86_64\\eclipse\\configuration\\org.eclipse.osgi\\427\\0\\.cp\\icons\\full\\dlcl16\\home_nav.png"));
		button.setBounds(290, 14, 42, 37);
		contentPane.add(button);
		
		JLabel label = new JLabel("Employee Name:");
		label.setFont(new Font("Arial", Font.BOLD, 14));
		label.setBounds(333, 116, 131, 14);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("Employee ID:");
		label_1.setFont(new Font("Arial", Font.BOLD, 14));
		label_1.setBounds(333, 146, 120, 14);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("Employee Gender:");
		label_2.setFont(new Font("Arial", Font.BOLD, 14));
		label_2.setBounds(322, 176, 131, 14);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("Employee BirthDay:");
		label_3.setFont(new Font("Arial", Font.BOLD, 14));
		label_3.setBounds(311, 209, 142, 14);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("Employee Salary:");
		label_4.setFont(new Font("Arial", Font.BOLD, 14));
		label_4.setBounds(333, 240, 120, 14);
		contentPane.add(label_4);
		
		JLabel label_5 = new JLabel("Employee Phone:");
		label_5.setFont(new Font("Arial", Font.BOLD, 14));
		label_5.setBounds(333, 271, 131, 14);
		contentPane.add(label_5);
		
		JLabel label_6 = new JLabel("Employee Address:");
		label_6.setFont(new Font("Arial", Font.BOLD, 14));
		label_6.setBounds(322, 302, 142, 14);
		contentPane.add(label_6);
		
		JButton btnNewButton = new JButton("Reservations");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(387, 364, 131, 36);
		contentPane.add(btnNewButton);
	}
}
