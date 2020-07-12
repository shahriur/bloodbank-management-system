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
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextField;

public class send_request extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_1;
	private JTextField textField;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					send_request frame = new send_request();
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
	public send_request(){
		send_request1();
		conn=connection.dbConnector();
	}
	public void send_request1() {
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
		
		JLabel lblNewLabel = new JLabel("REQUEST");
		lblNewLabel.setBounds(338, 78, 148, 47);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel.setForeground(new Color(0, 255, 255));
		contentPane.add(lblNewLabel);
		
		JLabel lblName = new JLabel("NAME :");
		lblName.setBounds(183, 139, 46, 14);
		contentPane.add(lblName);
		
		JLabel lblMobile = new JLabel("MOBILE :");
		lblMobile.setBounds(183, 183, 74, 14);
		contentPane.add(lblMobile);
		
		JLabel lblBloodGroup = new JLabel("BLOOD GROUP :");
		lblBloodGroup.setBounds(183, 228, 108, 14);
		contentPane.add(lblBloodGroup);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setBackground(Color.LIGHT_GRAY);
		comboBox.addItem("AB+");
		comboBox.addItem("AB-");
		comboBox.addItem("A+");
		comboBox.addItem("A-");
		comboBox.addItem("B+");
		comboBox.addItem("B-");
		comboBox.addItem("O+");
		comboBox.addItem("O-");
		comboBox.setBounds(293, 225, 88, 20);
		contentPane.add(comboBox);
		
		JLabel lblQuantity = new JLabel("QUANTITY (BAG) :");
		lblQuantity.setBounds(183, 272, 108, 14);
		contentPane.add(lblQuantity);
		
		JButton btnNewButton = new JButton("BACK");
		btnNewButton.setForeground(new Color(255, 255, 204));
		btnNewButton.setBackground(new Color(255, 0, 0));
		btnNewButton.setBounds(364, 337, 89, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				HOME1 home1=new HOME1();
				home1.setVisible(true);
			}
		});
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("SUBMIT");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String name=textField.getText();
				String mobile=textField_1.getText();
				int qty=Integer.parseInt(textField_2.getText());
				String bg=(String)comboBox.getSelectedItem();
				
				if (verifyFields())
						{
					
					if(qty==0)
					{
						 JOptionPane.showMessageDialog(null,"Quantiy 0 not allowed");
					}
					else
					{
					try{
						String Query="select * from stock where blood_group=?";
						PreparedStatement psss;
						psss=conn.prepareStatement(Query);
						psss.setString(1, bg);
				        ResultSet rsss=psss.executeQuery();
				        while(rsss.next()) {
				        	int qqty=rsss.getInt("quantity");
				        	if(qqty>=qty)
				        	{
				        		try {
									String query11="update stock set quantity=quantity-? where blood_group=?";
									PreparedStatement ptt=conn.prepareStatement(query11);
									ptt.setInt(1,qty);
									ptt.setString(2,bg);
								
									 if(ptt.executeUpdate()!=0) {			 
										 try {
												String query1="update reserve set quantity=quantity+? where blood_group=?";
												PreparedStatement pt=conn.prepareStatement(query1);
												pt.setInt(1,qty);
												pt.setString(2,bg);									
												 if(pt.executeUpdate()!=0) {
														PreparedStatement ps;
														String registerUserQuery="insert into request values(?,?,?,?,Date('now'))";
														try{ps=conn.prepareStatement(registerUserQuery);
														    ps.setString(1, name);
														    ps.setString(2,mobile);
														    ps.setString(3,bg);
														    ps.setInt(4, qty);
														   
														    if(ps.executeUpdate()!=0) {
														    	JOptionPane.showMessageDialog(null,"Request approved.Please collect within 24 hours otherwise your request will be declined");
														    	dispose();
																HOME1 home1=new HOME1();
																home1.setVisible(true);
														    }
														    else  {
														    	JOptionPane.showMessageDialog(null,"Error...");
														    }
														    	
														}catch(Exception e1) {}
													 
													 
												    }
												    else  {
												    	JOptionPane.showMessageDialog(null,"Error:Something Went Wrong.Please try again...");
												    	
												    }
											}catch(Exception e1)
											{
												JOptionPane.showMessageDialog(null, "wrong");
												
											}
										
									    }
									    else  {
									    	JOptionPane.showMessageDialog(null,"Error:Something Went Wrong.Please try again...");
									    	
									    }
								}catch(Exception e1)
								{
									JOptionPane.showMessageDialog(null, "wrong");
									
								}
						
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
					}
			
		});
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBackground(Color.GRAY);
		btnNewButton_1.setBounds(476, 337, 89, 23);
		contentPane.add(btnNewButton_1);
		
		textField_1 = new JTextField();
		textField_1.setBackground(Color.LIGHT_GRAY);
		textField_1.setBounds(293, 180, 140, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField = new JTextField();
		textField.setBackground(Color.LIGHT_GRAY);
		textField.setBounds(293, 136, 263, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBackground(Color.LIGHT_GRAY);
		textField_2.setBounds(293, 269, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		//create border for text field
		Border field_border = BorderFactory.createMatteBorder(2, 2, 2, 2, Color.GRAY);
		textField.setBorder(field_border);
		textField_1.setBorder(field_border);
		textField_2.setBorder(field_border);
	}
	
	
	public boolean verifyFields()
	{
		String name=textField.getText();
		String mobile=textField_1.getText();
		String qty=textField_2.getText();
		
	if(name.trim().equals("")||mobile.trim().equals("")||qty.trim().equals(""))
	{
		JOptionPane.showMessageDialog(null, "One or More Fields Are Empty");
		return false;}
	else {
		
		return true;
		
		}
	
	}
}
