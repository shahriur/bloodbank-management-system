package blood_bank;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
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
import javax.swing.table.TableModel;

import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JScrollPane;

public class crqst extends JFrame {

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
					crqst frame = new crqst();
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
	static JTextField textField_1;
	private JTable table;
	public crqst(){
		crqst1();
		conn=connection.dbConnector();
	}
	public void crqst1() {
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
		
		JLabel lblCheckRequest = new JLabel("CHECK REQUEST");
		lblCheckRequest.setForeground(Color.CYAN);
		lblCheckRequest.setBackground(Color.WHITE);
		lblCheckRequest.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblCheckRequest.setBounds(302, 80, 199, 32);
		contentPane.add(lblCheckRequest);
		
		JButton btnNewButton = new JButton("BACK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				admin1 admin1=new admin1();
				blood_bank.admin1.textField.setText(crqst.textField_1.getText());
				admin1.setVisible(true);
				
			}
		});
		btnNewButton.setForeground(new Color(255, 255, 204));
		btnNewButton.setBackground(new Color(255, 0, 0));
		btnNewButton.setBounds(658, 304, 107, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("RESPONSE");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();	
				response response=new response();
				blood_bank.response.textField_3.setText(crqst.textField_1.getText());
				blood_bank.response.textField.setText(crqst.textField.getText());
				response.setVisible(true);
				
			}
		});
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBackground(Color.GRAY);
		btnNewButton_1.setBounds(658, 236, 107, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("DECLINE");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();	
				decline decline=new decline ();
				blood_bank.decline.textField_1.setText(crqst.textField_1.getText());
				blood_bank.decline.textField.setText(crqst.textField.getText());
				decline.setVisible(true);
			}
		});
		btnNewButton_2.setForeground(Color.WHITE);
		btnNewButton_2.setBackground(Color.GRAY);
		btnNewButton_2.setBounds(658, 270, 107, 23);
		contentPane.add(btnNewButton_2);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBackground(Color.LIGHT_GRAY);
		textField.setFont(new Font("Tahoma", Font.BOLD, 13));
		textField.setBounds(658, 205, 107, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblRequestId = new JLabel("REQUEST  ID");
		lblRequestId.setForeground(new Color(0, 0, 153));
		lblRequestId.setBounds(668, 182, 79, 14);
		contentPane.add(lblRequestId);
		//create border for text field
		Border field_border = BorderFactory.createMatteBorder(2, 2, 2, 2, Color.GRAY);
		textField.setBorder(field_border);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 0, 0));
		panel.setBounds(201, 138, 125, 32);
		contentPane.add(panel);
		
		JButton btnNewButton_3 = new JButton("CHECK STOCK");
		panel.add(btnNewButton_3);
		btnNewButton_3.setForeground(Color.WHITE);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String query="select * from stock  ";
					PreparedStatement pst=conn.prepareStatement(query);
					ResultSet rs=pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
				}catch(Exception e1)
				{
					JOptionPane.showMessageDialog(null,e1);
					
				}
				
			}
		});
		btnNewButton_3.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		btnNewButton_3.setBackground(Color.GRAY);
		
		textField_1 = new JTextField();
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(204, 0, 0));
		panel_1.setForeground(Color.BLACK);
		panel_1.setBounds(73, 138, 131, 32);
		contentPane.add(panel_1);
		
		JButton btnVieewRequest = new JButton("VIEEW REQUEST");
		panel_1.add(btnVieewRequest);
		btnVieewRequest.setForeground(Color.WHITE);
		btnVieewRequest.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		btnVieewRequest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					String query="select * from request ";
					PreparedStatement pst=conn.prepareStatement(query);
					
					ResultSet rs=pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
				}catch(Exception e1)
				{
					JOptionPane.showMessageDialog(null,"e");
					
				}
				
			}
		});
		btnVieewRequest.setBackground(Color.GRAY);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(204, 0, 0));
		panel_2.setBounds(322, 138, 125, 32);
		contentPane.add(panel_2);
		
		JButton btnNewButton_4 = new JButton("HOLDED STOCK");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
             try {
					
					String query="select * from reserve ";
					PreparedStatement pst=conn.prepareStatement(query);
					
					ResultSet rs=pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
				}catch(Exception e1)
				{
					JOptionPane.showMessageDialog(null,"e");
					
				}
				
			}
		});
		btnNewButton_4.setForeground(Color.WHITE);
		btnNewButton_4.setBackground(Color.GRAY);
		btnNewButton_4.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		panel_2.add(btnNewButton_4);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(73, 182, 560, 182);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int i=table.getSelectedRow();
				TableModel model=table.getModel();
				textField.setText(model.getValueAt(i,1).toString());
				
			}
		});
		
	}
}
