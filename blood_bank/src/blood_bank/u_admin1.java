package blood_bank;

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

import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class u_admin1 extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	static JTextField textField;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					u_admin1 frame = new u_admin1();
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
	Connection conn=null;
	
	public u_admin1(){
		u_admin11();
		conn=connection.dbConnector();
	}
	public void u_admin11() {
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
		
		JButton btnNewButton = new JButton("Update Name");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				 ua_name ua_name=new  ua_name();
				 blood_bank.ua_name.textField.setText(u_admin1.textField.getText());
				 ua_name.setVisible(true);
				
			}
		});
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(Color.GRAY);
		btnNewButton.setBounds(607, 228, 142, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Update Email");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				 a_email a_email=new  a_email();
				 blood_bank.a_email.textField.setText(u_admin1.textField.getText());
				 a_email.setVisible(true);	
			}
		});
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBackground(Color.GRAY);
		btnNewButton_1.setBounds(607, 262, 142, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Update Mobile");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				 a_mobile  a_mobile=new   a_mobile();
				 blood_bank.a_mobile.textField.setText(u_admin1.textField.getText());
				 a_mobile.setVisible(true);
			}
		});
		btnNewButton_2.setForeground(new Color(255, 255, 255));
		btnNewButton_2.setBackground(Color.GRAY);
		btnNewButton_2.setBounds(607, 330, 142, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Change Password");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				 a_password a_password=new  a_password();
				 blood_bank.a_password.textField.setText(u_admin1.textField.getText());
				 a_password.setVisible(true);
				
			}
		});
		btnNewButton_3.setForeground(new Color(255, 255, 255));
		btnNewButton_3.setBackground(Color.GRAY);
		btnNewButton_3.setBounds(607, 296, 142, 23);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Back");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				dispose();
				adaccess adaccess=new adaccess();
				blood_bank.adaccess.textField.setText(u_admin1.textField.getText());
				adaccess.setVisible(true);
			}
		});
		btnNewButton_4.setForeground(Color.WHITE);
		btnNewButton_4.setBackground(Color.RED);
		btnNewButton_4.setBounds(607, 364, 142, 23);
		contentPane.add(btnNewButton_4);
		
		JLabel lblUpdateProfile = new JLabel("UPDATE PROFILE");
		lblUpdateProfile.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblUpdateProfile.setForeground(Color.CYAN);
		lblUpdateProfile.setBounds(293, 112, 213, 32);
		contentPane.add(lblUpdateProfile);
		
		textField = new JTextField();
		textField.setBackground(Color.LIGHT_GRAY);
		textField.setFont(new Font("Times New Roman", Font.BOLD, 14));
		textField.setForeground(Color.BLUE);
		textField.setEditable(false);
		textField.setBounds(119, 154, 179, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblEmail = new JLabel("EMAIL");
		lblEmail.setBounds(44, 157, 46, 14);
		contentPane.add(lblEmail);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(119, 231, 439, 156);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnNewButton_5 = new JButton("CHECK PROFILE");
		btnNewButton_5.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String query="select name,email,phone from admin where email=? ";
					PreparedStatement pst=conn.prepareStatement(query);
					pst.setString(1,textField.getText());
					ResultSet rs=pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
				}catch(Exception e1)
				{
					JOptionPane.showMessageDialog(null,"e");
					
				}
			}
		});
		btnNewButton_5.setForeground(Color.WHITE);
		btnNewButton_5.setBackground(Color.GRAY);
		btnNewButton_5.setBounds(119, 197, 126, 23);
		contentPane.add(btnNewButton_5);
		//create border for text field
				Border field_border = BorderFactory.createMatteBorder(2, 2, 2, 2, Color.GRAY);
				textField.setBorder(field_border);
				
	}
}
