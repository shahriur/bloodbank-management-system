package blood_bank;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class admin1 extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					admin1 frame = new admin1();
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
	static JTextField textField;
	public admin1(){
		admin11();
		conn=connection.dbConnector();
	}
	public void admin11() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 819, 480);
		contentPane = 	new JPanel();
		contentPane.setBackground(new Color(204, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label_3 = new JLabel();
		Image img6=new ImageIcon(this.getClass().getResource("/iconn.jpg")).getImage();
		label_3.setIcon(new ImageIcon(img6));
		label_3.setBounds(372, 24, 30, 32);
		contentPane.add(label_3);
		
		JLabel lblLifeSaver = new JLabel("LIFE SAVER");
		lblLifeSaver.setForeground(Color.CYAN);
		lblLifeSaver.setFont(new Font("Times New Roman", Font.BOLD, 10));
		lblLifeSaver.setBounds(358, 55, 64, 14);
		contentPane.add(lblLifeSaver);
		
		JLabel lblAdminLinks = new JLabel("MODERATOR");
		lblAdminLinks.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblAdminLinks.setForeground(new Color(0, 255, 255));
		lblAdminLinks.setBounds(325, 67, 147, 38);
		contentPane.add(lblAdminLinks);
		
		JButton btnUpdateUser = new JButton("UPDATE PROFILE");
		btnUpdateUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				dispose();
				 umprofile umprofile=new  umprofile();
				 blood_bank.umprofile.textField.setText(admin1.textField.getText());
				 umprofile.setVisible(true);
				
				
			}
		});
		btnUpdateUser.setForeground(new Color(255, 255, 255));
		btnUpdateUser.setBackground(Color.GRAY);
		btnUpdateUser.setBounds(626, 194, 167, 23);
		contentPane.add(btnUpdateUser);
		
		JButton btnNewButton = new JButton("DONOR LIST");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query="select name,gender,age,blood,mobile,email,address from d_registration ";
					PreparedStatement pst=conn.prepareStatement(query);
					ResultSet rs=pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
				}catch(Exception e1)
				{
					JOptionPane.showMessageDialog(null,e);
					
				}
			}
		});
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(Color.GRAY);
		btnNewButton.setBounds(626, 216, 167, 23);
		contentPane.add(btnNewButton);
		
		JButton btnBloodRequests = new JButton("BLOOD REQUESTS");
		btnBloodRequests.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				crqst crqst=new crqst();
				blood_bank.crqst.textField_1.setText(admin1.textField.getText());
				crqst.setVisible(true);
				
			}
		});
		btnBloodRequests.setForeground(new Color(255, 255, 255));
		btnBloodRequests.setBackground(Color.GRAY);
		btnBloodRequests.setBounds(626, 261, 167, 23);
		contentPane.add(btnBloodRequests);
		
		JButton btnNewButton_2 = new JButton("LOG OUT");
		btnNewButton_2.setForeground(new Color(255, 255, 255));
		btnNewButton_2.setBackground(Color.RED);
		btnNewButton_2.setBounds(626, 375, 167, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("TRANSACTION  HISTORY\r\n");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
				
					String query="select * from history  ";
					PreparedStatement pst=conn.prepareStatement(query);
					
					ResultSet rs=pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
				}catch(Exception e1)
				{
					JOptionPane.showMessageDialog(null,"e");
					
				}
				
			}
		});
		btnNewButton_3.setForeground(new Color(255, 255, 255));
		btnNewButton_3.setBackground(Color.GRAY);
		btnNewButton_3.setBounds(626, 238, 167, 23);
		contentPane.add(btnNewButton_3);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(53, 194, 563, 204);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		textField = new JTextField();
		textField.setBackground(Color.LIGHT_GRAY);
		textField.setForeground(Color.BLUE);
		textField.setFont(new Font("Times New Roman", Font.BOLD, 14));
		textField.setEditable(false);
		textField.setBounds(53, 108, 235, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblEmail = new JLabel("EMAIL");
		lblEmail.setBounds(10, 111, 46, 14);
		contentPane.add(lblEmail);
		
		JButton btnCheckProfile = new JButton("CHECK PROFILE");
		btnCheckProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String query="select name,email,phone from moderator where email=? ";
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
		btnCheckProfile.setForeground(Color.WHITE);
		btnCheckProfile.setBackground(Color.GRAY);
		btnCheckProfile.setBounds(53, 157, 147, 23);
		contentPane.add(btnCheckProfile);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				HOME1 home1=new HOME1();
				home1.setVisible(true);
			}
		});
		//create border for text field
		Border field_border = BorderFactory.createMatteBorder(2, 2, 2, 2, Color.GRAY);
		textField.setBorder(field_border);
		
		JButton btnNewButton_1 = new JButton("DONOR HISTORY");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
try {
					
					String query="with donor_history(name,email) as(select d_registration.name, donate.email  from donate,d_registration  where donate.email=d_registration.email ) ,total(email,Total_donate) as (select email, sum(quantity) as Total_donate  from donate  group by email) select name, email,Total_donate from donor_history natural join total group by email  ";
					PreparedStatement pst=conn.prepareStatement(query);
					
					ResultSet rs=pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
				}catch(Exception e1)
				{
					JOptionPane.showMessageDialog(null,"e");
					
				}
			}
		});
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBackground(Color.GRAY);
		btnNewButton_1.setBounds(626, 283, 167, 23);
		contentPane.add(btnNewButton_1);
		
	}
}
