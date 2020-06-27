import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.JButton;

public class MainClass {

	private JFrame frmHotel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainClass window = new MainClass();
					window.frmHotel.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainClass() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmHotel = new JFrame();
		frmHotel.setTitle("Hotel");
		frmHotel.setBounds(100, 100, 566, 410);
		frmHotel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmHotel.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\nohaa\\Pictures\\ANDAZMAYAKOBA%20-SanctuaryInterior.jpg"));
		lblNewLabel.setBounds(0, 83, 550, 288);
		frmHotel.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("DB HOTEL");
		lblNewLabel_1.setForeground(Color.DARK_GRAY);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel_1.setBounds(195, 11, 168, 29);
		frmHotel.getContentPane().add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Customer view ");
		btnNewButton.setBounds(0, 61, 197, 23);
		frmHotel.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Manager view");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmHotel.dispose();
				MangerView m = new MangerView();
				m.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(195, 61, 197, 23);
		frmHotel.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Receptionist view");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmHotel.dispose();
				Receptionist r = new Receptionist();
				r.setVisible(true);
			}
		});
		btnNewButton_2.setBounds(390, 61, 160, 23);
		frmHotel.getContentPane().add(btnNewButton_2);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmHotel.dispose();
				Booking booking = new Booking();
				booking.setVisible(true);
				
			}
		});
	}

}
