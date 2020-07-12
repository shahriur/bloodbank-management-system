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
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

public class adminlog extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					adminlog frame = new adminlog();
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
	private JPasswordField passwordField;
	private static JTextField textField;
	
	public adminlog(){
		adminlog1();
		conn=connection.dbConnector();
	}
	public void adminlog1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 819, 480);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(224, 255, 255));
		contentPane.setBackground(new Color(204, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		passwordField = new JPasswordField();
		passwordField.setBackground(Color.LIGHT_GRAY);
		passwordField.setForeground(Color.BLUE);
		passwordField.setBounds(430, 225, 199, 20);
		contentPane.add(passwordField);
		
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
		
		JLabel lblAdminLogIn = new JLabel("ADMIN LOG IN");
		lblAdminLogIn.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblAdminLogIn.setForeground(new Color(0, 255, 255));
		lblAdminLogIn.setBounds(299, 112, 199, 29);
		contentPane.add(lblAdminLogIn);
		
		JLabel lblId = new JLabel("Email       :");
		lblId.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblId.setBounds(277, 182, 95, 14);
		contentPane.add(lblId);
		
		textField = new JTextField();
		textField.setBackground(Color.LIGHT_GRAY);
		textField.setForeground(Color.BLUE);
		textField.setFont(new Font("Times New Roman", Font.BOLD, 14));
		textField.setBounds(430, 180, 199, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblPassword.setBounds(277, 227, 95, 14);
		contentPane.add(lblPassword);
		
		JButton btnCancel = new JButton("BACK");
		btnCancel.setForeground(new Color(255, 255, 204));
		btnCancel.setBackground(new Color(255, 0, 0));
		btnCancel.setBounds(430, 277, 89, 23);
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				HOME1 home1=new HOME1();
				home1.setVisible(true);
			}
		});
		contentPane.add(btnCancel);
		
		JButton btnNewButton = new JButton("LOG IN");
		btnNewButton.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					String query="select * from admin where email=? and pass=?";
					PreparedStatement pst=conn.prepareStatement(query);
					pst.setString(1,textField.getText());
					pst.setString(2,passwordField.getText());
					ResultSet rs=pst.executeQuery();
					int count=0;
					while(rs.next()) {
						count=count+1;
					}
					if (count==1)
					{
						dispose();
						adaccess adaccess=new adaccess();
						blood_bank.adaccess.textField.setText(adminlog.textField.getText());
						adaccess.setVisible(true);
					}
					else {
						JOptionPane.showMessageDialog(null, "Email or Password is Incorrect.Try Again...");
						
					}
					rs.close();
					pst.close();
				}catch(Exception e)
				{
					JOptionPane.showMessageDialog(null, e);
					
				}
			}
		});
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(Color.GRAY);
		btnNewButton.setBounds(540, 277, 89, 23);
		contentPane.add(btnNewButton);
		
		//create border for text field
		Border field_border = BorderFactory.createMatteBorder(2, 2, 2, 2, Color.GRAY);
		textField.setBorder(field_border);
		passwordField.setBorder(field_border);
	}

}
