package blood_bank;
import java.sql.*;
import javax.swing.*;

import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class home {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					home window = new home();
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
	Connection conn=null;
	public home() {
		initialize();
		conn=connection.dbConnector();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(204, 0, 0));
		frame.setBounds(100, 100, 819, 480);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		Image img=new ImageIcon(this.getClass().getResource("/icon.jpg")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));
		lblNewLabel.setBounds(329, 75, 100, 100);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("HOME");
		btnNewButton.setBounds(329, 284, 100, 23);
		frame.getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				HOME1 home1=new HOME1();
				home1.setVisible(true);
			}
		});
		btnNewButton.setForeground(Color.RED);
		btnNewButton.setBackground(Color.GRAY);
		
		JLabel lblGiveTheGift = new JLabel("GIVE THE GIFT OF LIFE");
		lblGiveTheGift.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblGiveTheGift.setForeground(Color.WHITE);
		lblGiveTheGift.setBounds(275, 213, 232, 32);
		frame.getContentPane().add(lblGiveTheGift);
		
		JLabel lblNewLabel_1 = new JLabel("DONATE BLOOD");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(299, 241, 177, 32);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblLife = new JLabel("LIFE SAVER");
		lblLife.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblLife.setForeground(Color.CYAN);
		lblLife.setBounds(332, 186, 109, 14);
		frame.getContentPane().add(lblLife);
		
		
		
	}
	}
		
		
		
	
		

		
	