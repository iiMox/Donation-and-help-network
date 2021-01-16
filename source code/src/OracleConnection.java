import java.sql.*;

import javax.swing.JOptionPane;


public class OracleConnection {

	public Connection con=null;
	public PreparedStatement stmt=null;
	public ResultSet rs=null;
	
	public void initialize(){  
		try{  
		//step1 load the driver class  
		Class.forName("oracle.jdbc.driver.OracleDriver");  
		  
		//step2 create  the connection object  
		con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","GL2","GL2"); 
		
		}catch(Exception e){ JOptionPane.showMessageDialog(null, "Erreur de connexion à la base de données");;}  
		  
		}  
}
