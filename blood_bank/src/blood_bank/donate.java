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
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

public class donate extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	static JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					donate frame = new donate();
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
	static JTextField textField_2;
	static JTextField textField_1;
	public donate(){
		donate1();
		conn=connection.dbConnector();
	}
	public void donate1() {
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
		
		JLabel lblNewLabel = new JLabel("DONATE");
		lblNewLabel.setForeground(Color.CYAN);
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblNewLabel.setBounds(342, 91, 266, 45);
		contentPane.add(lblNewLabel);
		
		JLabel lblEmail = new JLabel("EMAIL:");
		lblEmail.setBounds(40, 150, 67, 14);
		contentPane.add(lblEmail);
		
		textField = new JTextField();
		textField.setBackground(Color.LIGHT_GRAY);
		textField.setEditable(false);
		textField.setForeground(Color.BLUE);
		textField.setFont(new Font("Times New Roman", Font.BOLD, 14));
		textField.setBounds(150, 147, 208, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewName = new JLabel("BLOOD GROUP :");
		lblNewName.setBounds(40, 199, 100, 14);
		contentPane.add(lblNewName);
		
		JButton btnUpdate = new JButton("SUBMIT");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				try {
					String query="select * from availstatus where email=? and status='Available'";
					PreparedStatement pst=conn.prepareStatement(query);
					pst.setString(1,textField.getText());
					
					ResultSet rs=pst.executeQuery();
					int count=0;
					while(rs.next()) {
						count=count+1;
					}
					if (count==1)
					{
						
						try {
							
							
							String query1="insert into donate values(?,DateTime('now'),?,DATETIME(DateTime('now'), '+2 minutes'))";
							PreparedStatement pstt=conn.prepareStatement(query1);
							
							pstt.setString(1,textField.getText());
							pstt.setString(2,textField_2.getText());
							pstt.executeUpdate();
							String query2="update stock set quantity=quantity+? where blood_group=?";
							PreparedStatement pstt1=conn.prepareStatement(query2);	
							pstt1.setString(1,textField_2.getText());
							pstt1.setString(2,textField_1.getText());
							
							 if(pstt1.executeUpdate()!=0) {
								 
								 try {
									 String queryy1="update availstatus set status='Unavailable' where email=?";
										PreparedStatement pstty=conn.prepareStatement(queryy1);
										
										pstty.setString(1,textField.getText());
									
										 if(pstty.executeUpdate()!=0) {
											 try {
												 String queryy2="update availstatus set available_time=DATETIME(DATETIME('now'), '+2 minutes') where email=?";
													PreparedStatement psttyy=conn.prepareStatement(queryy2);
													
													psttyy.setString(1,textField.getText());
												
													 if(psttyy.executeUpdate()!=0) {
														 JOptionPane.showMessageDialog(null,"Donated");
													    	dispose();
															dnrlog dnrlog=new dnrlog();
															blood_bank.dnrlog.textField.setText(donate.textField.getText());
															dnrlog.setVisible(true);
													    }
													    else  {
													    	JOptionPane.showMessageDialog(null,"wrong");
													    	dispose();
															dnrlog dnrlog=new dnrlog();
															blood_bank.dnrlog.textField.setText(donate.textField.getText());
															dnrlog.setVisible(true);
													    }
												}catch(Exception e1)
												{
													JOptionPane.showMessageDialog(null, "wrong");
													
												}
											 
										    }
										    else  {
										    	JOptionPane.showMessageDialog(null,"wrong");
										    	dispose();
												dnrlog dnrlog=new dnrlog();
												blood_bank.dnrlog.textField.setText(donate.textField.getText());
												dnrlog.setVisible(true);
										    }
									}catch(Exception e1)
									{
										JOptionPane.showMessageDialog(null, "wrong");
										
									}
								 
								 
							    	
							    }
							    else  {
							    	JOptionPane.showMessageDialog(null,"Error:Something Went Wrong.Please try again...");
							    	dispose();
									dnrlog dnrlog=new dnrlog();
									blood_bank.dnrlog.textField.setText(donate.textField.getText());
									dnrlog.setVisible(true);
							    }
						}catch(Exception e1)
						{
							JOptionPane.showMessageDialog(null, "wrong");
							
						}
					}
					else {
						JOptionPane.showMessageDialog(null, "You haven't permission to donate. After valid time try again");
						
					}
					rs.close();
					pst.close();
				}catch(Exception e1)
				{
					JOptionPane.showMessageDialog(null,e);
					
				}
				

				
			}
		});
		btnUpdate.setForeground(Color.WHITE);
		btnUpdate.setBackground(Color.GRAY);
		btnUpdate.setBounds(269, 290, 89, 23);
		contentPane.add(btnUpdate);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				dnrlog dnrlog=new dnrlog();
				blood_bank.dnrlog.textField.setText(donate.textField.getText());
				dnrlog.setVisible(true);
			}
		});
		btnBack.setForeground(new Color(255, 255, 255));
		btnBack.setBackground(new Color(255, 0, 0));
		btnBack.setBounds(150, 290, 89, 23);
		contentPane.add(btnBack);
		
		JLabel lblQuantity = new JLabel("QUANTITY :");
		lblQuantity.setBounds(40, 240, 100, 14);
		contentPane.add(lblQuantity);
		
		textField_2 = new JTextField();
		textField_2.setForeground(Color.BLUE);
		textField_2.setEditable(false);
		textField_2.setFont(new Font("Times New Roman", Font.BOLD, 14));
		textField_2.setBackground(Color.LIGHT_GRAY);
		textField_2.setBounds(150, 237, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setForeground(Color.BLUE);
		textField_1.setBackground(Color.LIGHT_GRAY);
		textField_1.setEditable(false);
		textField_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		textField_1.setBounds(150, 196, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		//create border for text field
				Border field_border = BorderFactory.createMatteBorder(2, 2, 2, 2, Color.GRAY);
				textField.setBorder(field_border);
				textField_2.setBorder(field_border);
				textField_1.setBorder(field_border);
				
				
		
	}
}
