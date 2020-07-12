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
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class response extends JFrame {

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
					response frame = new response();
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
	private JTextField textField_2;
	static JTextField textField_3;
	private JTextField textField_4;
	public response(){
		response1();
		conn=connection.dbConnector();
	}
	public void response1() {
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
		label_3.setBounds(379, 22, 30, 32);
		contentPane.add(label_3);
		
		JLabel lblLifeSaver = new JLabel("LIFE SAVER");
		lblLifeSaver.setForeground(Color.CYAN);
		lblLifeSaver.setFont(new Font("Times New Roman", Font.BOLD, 10));
		lblLifeSaver.setBounds(364, 55, 64, 14);
		contentPane.add(lblLifeSaver);
		
		JLabel lblRequestId = new JLabel("REQUEST ID:");
		lblRequestId.setBounds(132, 101, 77, 14);
		contentPane.add(lblRequestId);
		
		textField = new JTextField();
		textField.setBackground(Color.LIGHT_GRAY);
		textField.setForeground(Color.BLUE);
		textField.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		textField.setEditable(false);
		textField.setBounds(252, 98, 205, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setForeground(Color.BLUE);
		textField_4.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		textField_4.setBackground(Color.LIGHT_GRAY);
		textField_4.setBounds(252, 228, 86, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblBloodGroup = new JLabel("BLOOD GROUP");
		lblBloodGroup.setBounds(135, 231, 94, 14);
		contentPane.add(lblBloodGroup);
		
		JLabel lblQuantity = new JLabel("QUANTITY");
		lblQuantity.setBounds(135, 273, 77, 14);
		contentPane.add(lblQuantity);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		textField_1.setForeground(Color.BLUE);
		textField_1.setBackground(Color.LIGHT_GRAY);
		textField_1.setBounds(252, 270, 170, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				crqst crqst=new crqst();
				blood_bank.crqst.textField_1.setText(response.textField_3.getText());			
				crqst.setVisible(true);
			}
		});
		btnBack.setForeground(Color.WHITE);
		btnBack.setBackground(Color.RED);
		btnBack.setBounds(257, 317, 89, 23);
		contentPane.add(btnBack);
		
		JLabel lblName = new JLabel("NAME:");
		lblName.setBounds(135, 183, 63, 14);
		contentPane.add(lblName);
		
		textField_2 = new JTextField();
		textField_2.setForeground(Color.BLUE);
		textField_2.setBackground(Color.LIGHT_GRAY);
		textField_2.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		textField_2.setEditable(false);
		textField_2.setBounds(252, 179, 205, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);	
		JButton btnNewButton = new JButton("OK");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(Color.GRAY);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String mobile=textField.getText();
				int qty=Integer.parseInt(textField_1.getText());
				String blood=textField_4.getText();
				String name=textField_2.getText();
				if(qty==0)
				{
					 JOptionPane.showMessageDialog(null,"Quantiy 0 cannot be responsed");
				}
				else
				{
				try{
					String Query="select * from reserve where blood_group=?";
					PreparedStatement psss;
					psss=conn.prepareStatement(Query);
					psss.setString(1, blood);
			        ResultSet rsss=psss.executeQuery();
			        while(rsss.next()) {
			        	int qqty=rsss.getInt("quantity");
			        	if(qqty>=qty)
			        	{
			        		PreparedStatement ps;
							String registerUserQuery="insert into history values(?,?,?,?,Date('now'),'responsed')";
							try{ps=conn.prepareStatement(registerUserQuery);
							 ps.setString(1, name);
							    ps.setString(2,mobile);
							    ps.setString(3,blood);
							    ps.setInt(4,qty);						   
							    if(ps.executeUpdate()!=0) {						    	
							    	try {
										String query1="delete from request where  mobile=?";
										PreparedStatement pstt=conn.prepareStatement(query1);
										
										pstt.setString(1,textField.getText());
									
										 if(pstt.executeUpdate()!=0) {
											 try {
													String query11="update reserve set quantity=quantity-? where blood_group=?";
													PreparedStatement ptt=conn.prepareStatement(query11);
													ptt.setInt(1,qty);
													ptt.setString(2,blood);
												
													 if(ptt.executeUpdate()!=0) {
														 JOptionPane.showMessageDialog(null,"Responsed");
													    	dispose();
															crqst crqst=new crqst();
															blood_bank.crqst.textField_1.setText(response.textField_3.getText());
															crqst.setVisible(true);
													    }
													    else  {
													    	JOptionPane.showMessageDialog(null,"Error:Something Went Wrong.Please try again...");
													    	dispose();											    	
															crqst crqst=new crqst();
															blood_bank.crqst.textField_1.setText(response.textField_3.getText());
															crqst.setVisible(true);
													    }
												}catch(Exception e1)
												{
													JOptionPane.showMessageDialog(null, "wrong");
													
												}
										    	
										    }
										 
										    else  {
										    	
										    	JOptionPane.showMessageDialog(null,"Error:Something Went Wrong.Please try again...");
										    	dispose();
												crqst crqst=new crqst();
												blood_bank.crqst.textField_1.setText(response.textField_3.getText());
												crqst.setVisible(true); 
										    }
									}catch(Exception e1)
									{
										JOptionPane.showMessageDialog(null, "Error:Something Went Wrong.Please try again...");
										
									}
							    }
							    else  {
							    	JOptionPane.showMessageDialog(null,"Error......");
							    }
							    	
							}catch(Exception e1) {}
					
			        	}
			        	
			        	else  {
					    	JOptionPane.showMessageDialog(null,"Quantity is insufficient");
					    }
			        	
			        }
			        psss.close();
				}catch(Exception e1) {
					
					JOptionPane.showMessageDialog(null, "");
					
				}
			}			
						
			}
		});
		btnNewButton.setBounds(356, 317, 64, 23);
		contentPane.add(btnNewButton);
		//create border for text field
		Border field_border = BorderFactory.createMatteBorder(2, 2, 2, 2, Color.GRAY);
		textField.setBorder(field_border);
		textField_2.setBorder(field_border);
		textField_1.setBorder(field_border);
		textField_4.setBorder(field_border);
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 0, 0));
		panel.setBounds(351, 129, 106, 32);
		contentPane.add(panel);
		
		JButton btnOk = new JButton("CONFIRM ID");
		panel.add(btnOk);
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				
						try{
							String Query="select * from request where mobile=?";
							PreparedStatement pss;
							pss=conn.prepareStatement(Query);
							pss.setString(1, textField.getText());
					        ResultSet rss=pss.executeQuery();
					        while(rss.next()) {
					        	textField_2.setText(rss.getString("name"));
					        	textField_4.setText(rss.getString("blood_group"));
					        	textField_1.setText(rss.getString("quantity"));
					        }
					        pss.close();
						}catch(Exception e1) {
							
							JOptionPane.showMessageDialog(null, "Wrong ID");
						}
			}       
		});
		btnOk.setForeground(Color.WHITE);
		btnOk.setBackground(Color.GRAY);
		
		textField_3 = new JTextField();
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		
	}
}
