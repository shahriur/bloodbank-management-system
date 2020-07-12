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

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class dnrlog extends JFrame {

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
					dnrlog frame = new dnrlog();
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
	private static JTextField textField_1;
	private static JTextField textField_2;
	public dnrlog(){
		dnrlog1();
		conn=connection.dbConnector();
	}
	private void dnrlog1() {
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
		label_3.setBounds(372, 50, 30, 32);
		contentPane.add(label_3);
		
		JLabel lblLifeSaver = new JLabel("LIFE SAVER");
		lblLifeSaver.setForeground(Color.CYAN);
		lblLifeSaver.setFont(new Font("Times New Roman", Font.BOLD, 10));
		lblLifeSaver.setBounds(354, 82, 64, 14);
		contentPane.add(lblLifeSaver);
		
		JLabel lblNewLabel = new JLabel("DONOR PROFILE");
		lblNewLabel.setForeground(new Color(0, 255, 255));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblNewLabel.setBounds(289, 93, 223, 43);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 258, 565, 133);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("UPDATE NAME");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				ud_dname ud_dname=new ud_dname();
				blood_bank.ud_dname.textField.setText(dnrlog.textField.getText());
				ud_dname.setVisible(true);
				
			}
		});
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(Color.GRAY);
		btnNewButton.setBounds(595, 258, 169, 23);
		contentPane.add(btnNewButton);
		
		JButton btnUpdateMobileNo = new JButton("UPDATE MOBILE NO");
		btnUpdateMobileNo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				u_mobile u_mobile=new u_mobile();
				blood_bank.u_mobile.textField.setText(dnrlog.textField.getText());
				u_mobile.setVisible(true);
			}
		});
		btnUpdateMobileNo.setForeground(new Color(255, 255, 255));
		btnUpdateMobileNo.setBackground(Color.GRAY);
		btnUpdateMobileNo.setBounds(595, 278, 169, 23);
		contentPane.add(btnUpdateMobileNo);
		
		JButton btnUpdateAddress = new JButton("UPDATE ADDRESS");
		btnUpdateAddress.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				u_add u_mail=new u_add();
				blood_bank.u_add.textField.setText(dnrlog.textField.getText());
				u_mail.setVisible(true);
				
			}
		});
		btnUpdateAddress.setForeground(new Color(255, 255, 255));
		btnUpdateAddress.setBackground(Color.GRAY);
		btnUpdateAddress.setBounds(595, 300, 169, 23);
		contentPane.add(btnUpdateAddress);
		
		JButton btnNewButton_3 = new JButton("CHANGE PASSWORD");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				u_dpass u_dpass=new u_dpass();
				blood_bank.u_dpass.textField.setText(dnrlog.textField.getText());
				u_dpass.setVisible(true);
				
				
			}
		});
		btnNewButton_3.setForeground(new Color(255, 255, 255));
		btnNewButton_3.setBackground(Color.GRAY);
		btnNewButton_3.setBounds(595, 322, 169, 23);
		contentPane.add(btnNewButton_3);
		
		JButton btnCheckProfile = new JButton("CHECK PROFILE");
		btnCheckProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String query="select name,gender,age,blood as blood_group,mobile,email,address from d_registration where email=? ";
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
		btnCheckProfile.setBounds(20, 215, 145, 23);
		contentPane.add(btnCheckProfile);
		
		JButton btnNewButton_4 = new JButton("LOG OUT");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				HOME1 home1=new HOME1();
				home1.setVisible(true);
				
			}
		});
		btnNewButton_4.setBackground(new Color(255, 0, 0));
		btnNewButton_4.setForeground(new Color(255, 255, 255));
		btnNewButton_4.setBounds(595, 367, 169, 23);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("DONATE ");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					String query1="update availstatus set status='Available' where email=? and available_time<=DATETIME('now')";
					PreparedStatement pstt=conn.prepareStatement(query1);
					
					pstt.setString(1,textField.getText());
					
				
					 if(pstt.executeUpdate()!=0) {
						 try{
								
								
								
								String Query="select * from d_registration where email=?";
								PreparedStatement pss;
								pss=conn.prepareStatement(Query);
								pss.setString(1, textField.getText());
						        ResultSet rss=pss.executeQuery();
						        while(rss.next()) {
						        	
						        	textField_2.setText(rss.getString("blood"));
						        	textField_1.setText("1");
						        	dispose();
									donate donate=new donate();
									blood_bank.donate.textField.setText(dnrlog.textField.getText());
									blood_bank.donate.textField_2.setText(dnrlog.textField_1.getText());
									blood_bank.donate.textField_1.setText(dnrlog.textField_2.getText());
									donate.setVisible(true);
						        	
						        }
						        pss.close();
							}catch(Exception e1) {
								
								JOptionPane.showMessageDialog(null, "Wrong ");
							}
					    	
					    }
					    else  {
					    	try{
								
								
								
								String Query="select * from d_registration where email=?";
								PreparedStatement pss;
								pss=conn.prepareStatement(Query);
								pss.setString(1, textField.getText());
						        ResultSet rss=pss.executeQuery();
						        while(rss.next()) {
						        	
						        	textField_2.setText(rss.getString("blood"));
						        	textField_1.setText("1");
						        	dispose();
									donate donate=new donate();
									blood_bank.donate.textField.setText(dnrlog.textField.getText());
									blood_bank.donate.textField_2.setText(dnrlog.textField_1.getText());
									blood_bank.donate.textField_1.setText(dnrlog.textField_2.getText());
									donate.setVisible(true);
						        	
						        }
						        pss.close();
							}catch(Exception e1) {
								
								JOptionPane.showMessageDialog(null, "Wrong ID");
							}
					    }
				}catch(Exception e1)
				{
					JOptionPane.showMessageDialog(null, "wrong");
					
				}
				
				
				
			
				
				
				
				
				
				
			}
		});
		btnNewButton_5.setForeground(Color.WHITE);
		btnNewButton_5.setBackground(Color.GRAY);
		btnNewButton_5.setBounds(329, 215, 133, 23);
		contentPane.add(btnNewButton_5);
		
		textField = new JTextField();
		textField.setBackground(Color.LIGHT_GRAY);
		textField.setForeground(Color.BLUE);
		textField.setFont(new Font("Times New Roman", Font.BOLD, 14));
		textField.setEditable(false);
		textField.setBounds(66, 158, 251, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Email");
		lblNewLabel_1.setBounds(23, 162, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton_6 = new JButton("HISTORY");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String query="select * from donate where email=? ";
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
		btnNewButton_6.setForeground(Color.WHITE);
		btnNewButton_6.setBackground(Color.GRAY);
		btnNewButton_6.setBounds(176, 215, 141, 23);
		contentPane.add(btnNewButton_6);
		//create border for text field
				Border field_border = BorderFactory.createMatteBorder(2, 2, 2, 2, Color.GRAY);
				textField.setBorder(field_border);
				
				JPanel panel = new JPanel();
				panel.setBounds(403, 135, 177, -9);
				contentPane.add(panel);
				
				textField_1 = new JTextField();
				panel.add(textField_1);
				textField_1.setColumns(10);
				
				textField_2 = new JTextField();
				panel.add(textField_2);
				textField_2.setColumns(10);
	}
}
