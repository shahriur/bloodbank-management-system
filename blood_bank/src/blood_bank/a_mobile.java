package blood_bank;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

public class a_mobile extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_1;
	static JTextField textField;

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					a_mobile frame = new a_mobile();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	Connection conn=null;
	public a_mobile(){
		a_mobile1();
		conn=connection.dbConnector();}
	/**
	 * Create the frame.
	 */
	private void a_mobile1() {
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
		
		JLabel lblNewLabel = new JLabel("Email                  :");
		lblNewLabel.setBounds(167, 180, 105, 14);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBackground(Color.LIGHT_GRAY);
		textField.setFont(new Font("Times New Roman", Font.BOLD, 14));
		textField.setForeground(Color.BLUE);
		textField.setEditable(false);
		textField.setBounds(269, 177, 276, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("New Mobile No :");
		lblNewLabel_1.setBounds(167, 231, 105, 14);
		contentPane.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBackground(Color.LIGHT_GRAY);
		textField_1.setForeground(Color.BLUE);
		textField_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		textField_1.setBounds(269, 228, 276, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Update");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					String query1="update admin set phone=? where email=?";
					PreparedStatement pstt=conn.prepareStatement(query1);
					
					pstt.setString(1,textField_1.getText());
					pstt.setString(2,textField.getText());
				
					 if(pstt.executeUpdate()!=0) {
					    	JOptionPane.showMessageDialog(null,"Mobile No Updated Successfully");
					    	dispose();
							u_admin1 u_admin1=new u_admin1();
							blood_bank.u_admin1.textField.setText(a_mobile.textField.getText());
							u_admin1.setVisible(true);
					    }
					    else  {
					    	JOptionPane.showMessageDialog(null,"Error:Something Went Wrong.Please try again...");
					    	dispose();
							 a_mobile  a_mobile=new   a_mobile();
							 blood_bank.u_admin1.textField.setText(blood_bank.a_mobile.textField.getText());
							 a_mobile.setVisible(true);
					    }
				}catch(Exception e1)
				{
					JOptionPane.showMessageDialog(null, "wrong");
					
				}
				
			}
		});
		btnNewButton_1.setBackground(Color.GRAY);
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBounds(415, 279, 119, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Back");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				 u_admin1 u_admin1=new  u_admin1();
				 blood_bank.u_admin1.textField.setText(a_mobile.textField.getText());
				u_admin1.setVisible(true);	
				
			}
		});
		btnNewButton_2.setForeground(new Color(255, 255, 255));
		btnNewButton_2.setBackground(new Color(255, 0, 0));
		btnNewButton_2.setBounds(308, 279, 89, 23);
		contentPane.add(btnNewButton_2);
		
		JLabel lblUpdateAdminMobile = new JLabel("UPDATE ADMIN MOBILE NO");
		lblUpdateAdminMobile.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblUpdateAdminMobile.setForeground(new Color(0, 255, 204));
		lblUpdateAdminMobile.setBounds(242, 112, 370, 40);
		contentPane.add(lblUpdateAdminMobile);
		//create border for text field
		Border field_border = BorderFactory.createMatteBorder(2, 2, 2, 2, Color.GRAY);
		textField.setBorder(field_border);
		textField_1.setBorder(field_border);
	}
}
