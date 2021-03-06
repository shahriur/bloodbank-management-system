package blood_bank;

import java.sql.*;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ua_name extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	static JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ua_name frame = new ua_name();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	Connection conn=null;
	public ua_name(){
		ua_name1();
		conn=connection.dbConnector();
	}
	/**
	 * Create the frame.
	 */
	private void ua_name1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 819, 480);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(224, 255, 255));
		contentPane.setBackground(new Color(204, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel label_3 = new JLabel();
		Image img6=new ImageIcon(this.getClass().getResource("/iconn.jpg")).getImage();
		label_3.setIcon(new ImageIcon(img6));
		label_3.setBounds(367, 56, 30, 32);
		contentPane.add(label_3);
		
		JLabel lblLifeSaver = new JLabel("LIFE SAVER");
		lblLifeSaver.setForeground(Color.CYAN);
		lblLifeSaver.setFont(new Font("Times New Roman", Font.BOLD, 10));
		lblLifeSaver.setBounds(352, 87, 64, 14);
		contentPane.add(lblLifeSaver);
		
		
		//---
		
		JLabel lblNewLabel = new JLabel("Email         :");
		lblNewLabel.setBounds(173, 171, 64, 14);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBackground(Color.LIGHT_GRAY);
		textField.setFont(new Font("Times New Roman", Font.BOLD, 14));
		textField.setForeground(Color.BLUE);
		textField.setEditable(false);
		textField.setBounds(258, 168, 276, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("New Name :");
		lblNewLabel_1.setBounds(173, 220, 75, 14);
		contentPane.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBackground(Color.LIGHT_GRAY);
		textField_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		textField_1.setBounds(258, 217, 276, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Update");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					String query1="update admin set name=? where email=?";
					PreparedStatement pstt=conn.prepareStatement(query1);
					
					pstt.setString(1,textField_1.getText());
					pstt.setString(2,textField.getText());
				
					 if(pstt.executeUpdate()!=0) {
					    	JOptionPane.showMessageDialog(null,"Name Updated Successfully");
					    	dispose();
							u_admin1 u_admin1=new u_admin1();
						    blood_bank.u_admin1.textField.setText(ua_name.textField.getText());
							u_admin1.setVisible(true);
					    }
					    else  {
					    	JOptionPane.showMessageDialog(null,"Error:Something Went Wrong.Please try again...");
					    	dispose();
							 ua_name ua_name=new  ua_name();
							 blood_bank.u_admin1.textField.setText(blood_bank.ua_name.textField.getText());
							 ua_name.setVisible(true);
					    }
				}catch(Exception e1)
				{
					JOptionPane.showMessageDialog(null, "wrong");
					
				}
				
			}
		});
		btnNewButton_1.setBackground(Color.GRAY);
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBounds(415, 272, 119, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Back");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				 u_admin1 u_admin1=new  u_admin1();
				 blood_bank.u_admin1.textField.setText(ua_name.textField.getText());
				u_admin1.setVisible(true);	
				
			}
		});
		btnNewButton_2.setForeground(new Color(255, 255, 255));
		btnNewButton_2.setBackground(new Color(255, 0, 0));
		btnNewButton_2.setBounds(308, 272, 89, 23);
		contentPane.add(btnNewButton_2);
		
		JLabel lblUpdateAdminName = new JLabel("UPDATE ADMIN NAME");
		lblUpdateAdminName.setForeground(new Color(0, 255, 204));
		lblUpdateAdminName.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblUpdateAdminName.setBounds(252, 112, 304, 32);
		contentPane.add(lblUpdateAdminName);
		//create border for text field
				Border field_border = BorderFactory.createMatteBorder(2, 2, 2, 2, Color.GRAY);
				textField.setBorder(field_border);
				textField_1.setBorder(field_border);
	}
}
