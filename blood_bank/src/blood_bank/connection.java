package blood_bank;
import java.sql.*;
import javax.swing.*;

public class connection {
	Connection conn=null;
	public static Connection dbConnector()
	{
		try {
			Class.forName("org.sqlite.JDBC");
			Connection conn=DriverManager.getConnection("jdbc:sqlite:E:\\Semester7\\java\\BLOOD_BANK_FINAL (1)\\BLOOD_BANK_FINAL\\blood_CODE\\new.sqlite");
			
			return conn;
		}catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, "connection unsuccessfull");
			return null;
		}
	}

}
