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

public class a_email extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	static JTextField textField;
	private static JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					a_email frame = new a_email();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	Connection conn=null;
	public a_email(){
		a_email1();
		conn=connection.dbConnector();
	}

	/**
	 * Create the frame.
	 */
	private void a_email1() {
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
		label_3.setBounds(367, 49, 30, 32);
		contentPane.add(label_3);
		
		JLabel lblLifeSaver = new JLabel("LIFE SAVER");
		lblLifeSaver.setForeground(Color.CYAN);
		lblLifeSaver.setFont(new Font("Times New Roman", Font.BOLD, 10));
		lblLifeSaver.setBounds(351, 80, 64, 14);
		contentPane.add(lblLifeSaver);
		
		
		//---
		
		JLabel lblNewLabel = new JLabel("Email          :");
		lblNewLabel.setBounds(176, 159, 64, 14);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBackground(Color.LIGHT_GRAY);
		textField.setForeground(Color.BLUE);
		textField.setFont(new Font("Times New Roman", Font.BOLD, 14));
		textField.setEditable(false);
		textField.setBounds(258, 156, 276, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("New Email :");
		lblNewLabel_1.setBounds(176, 206, 72, 14);
		contentPane.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBackground(Color.LIGHT_GRAY);
		textField_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		textField_1.setForeground(Color.BLUE);
		textField_1.setBounds(258, 203, 276, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Update");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				String query="select * from admin where email=? ";
				PreparedStatement pst=conn.prepareStatement(query);
				pst.setString(1,textField_1.getText());
				ResultSet rs=pst.executeQuery();
				int count=0;
				while(rs.next()) {
					count=count+1;
				}
				if (count==1)
				{
					JOptionPane.showMessageDialog(null, "Email ALready Exist.Update not possible");
					dispose();
					u_admin1 u_admin1=new u_admin1();
					blood_bank.u_admin1.textField.setText(a_email.textField_1.getText());
					u_admin1.setVisible(true);
				
				}
				else {
					try {
						String query1="update admin set email=? where email=?";
						PreparedStatement pstt=conn.prepareStatement(query1);
						
						pstt.setString(1,textField_1.getText());
						pstt.setString(2,textField.getText());
					
						 if(pstt.executeUpdate()!=0) {
						    	JOptionPane.showMessageDialog(null,"Email Updated Successfully");
						    	dispose();
								u_admin1 u_admin1=new u_admin1();
								 blood_bank.u_admin1.textField.setText(a_email.textField_1.getText());
								u_admin1.setVisible(true);
						    }
						    else  {
						    	JOptionPane.showMessageDialog(null,"Error:Something Went Wrong.Please try again...");
						    	dispose();
						    	u_admin1 u_admin1=new u_admin1();
						    	blood_bank.u_admin1.textField.setText(a_email.textField.getText());
								u_admin1.setVisible(true);
						    }
					}catch(Exception e1)
					{
						JOptionPane.showMessageDialog(null, "wrong");
						
					}
					
					
				}
				rs.close();
				pst.close();
			}catch(Exception e1)
			{
				JOptionPane.showMessageDialog(null, e);
				
			}
				
			}
		});
		btnNewButton_1.setBackground(Color.GRAY);
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBounds(415, 251, 119, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Back");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				 u_admin1 u_admin1=new  u_admin1();
				 blood_bank.u_admin1.textField.setText(a_email.textField.getText());
				u_admin1.setVisible(true);	
				
			}
		});
		btnNewButton_2.setForeground(new Color(255, 255, 255));
		btnNewButton_2.setBackground(new Color(255, 0, 0));
		btnNewButton_2.setBounds(316, 251, 89, 23);
		contentPane.add(btnNewButton_2);
		
		JLabel lblUpdateAdminEmail = new JLabel("UPDATE ADMIN EMAIL");
		lblUpdateAdminEmail.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblUpdateAdminEmail.setForeground(new Color(0, 255, 204));
		lblUpdateAdminEmail.setBounds(245, 99, 309, 33);
		contentPane.add(lblUpdateAdminEmail);
		//create border for text field
		Border field_border = BorderFactory.createMatteBorder(2, 2, 2, 2, Color.GRAY);
		textField.setBorder(field_border);
		textField_1.setBorder(field_border);
	}
}
