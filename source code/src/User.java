import java.sql.Date;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class User {
	private String username,password,nom,prenom,email,type,adresse,wilaya;
	private int tel;
	private Date date_naissance;
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getWilaya() {
		return wilaya;
	}

	public void setWilaya(String wilaya) {
		this.wilaya = wilaya;
	}

	public int getTel() {
		return tel;
	}

	public void setTel(int tel) {
		this.tel = tel;
	}

	public Date getDate_naissance() {
		return date_naissance;
	}

	public void setDate_naissance(Date date_naissance) {
		this.date_naissance = date_naissance;
	}

	public User() {
		this.username="";
		this.password="";
		this.email="";
		this.type="";
		this.nom="";
		this.prenom="";
		this.adresse="";
		this.wilaya="";
	}
	
	public User(String username, String password, String email, String type,String nom, String prenom, String adresse, String wilaya, int tel, Date date_naissance) {
		this.username=username;
		this.password=password;
		this.email=email;
		this.type=type;
		this.nom=nom;
		this.prenom=prenom;
		this.adresse=adresse;
		this.wilaya=wilaya;
		this.tel=tel;
		this.date_naissance= date_naissance;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public int getId() {
		OracleConnection oc = new OracleConnection();
		oc.initialize();
		try {
			oc.stmt = oc.con.prepareStatement("Select id From Users where username = ?");
			oc.stmt.setString(1, this.username);
			oc.rs=oc.stmt.executeQuery(); 
			if(oc.rs.next()) {
				return oc.rs.getInt("id");
			}
			oc.con.close();
		}catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erreur de connexion à la base de données");
		}
		return -1;
	}
	
	public boolean username_existe() {
		OracleConnection oc = new OracleConnection();
		oc.initialize();
		try {
			oc.stmt = oc.con.prepareStatement("Select * From Users where username = ?");
			oc.stmt.setString(1, this.username);
			oc.rs=oc.stmt.executeQuery(); 
			if(oc.rs.next()) {
				return true;
			}
			oc.con.close();
		}catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erreur de connexion à la base de données");
		}
		return false;
	}
	
	public void getUserById(int id) {
		OracleConnection oc = new OracleConnection();
		oc.initialize();
		try {
			oc.stmt = oc.con.prepareStatement("Select * From Users where id = ?");
			oc.stmt.setInt(1, id);
			oc.rs=oc.stmt.executeQuery(); 
			if(oc.rs.next()) {
				this.username=oc.rs.getString("username");
				this.nom=oc.rs.getString("nom");
				this.prenom=oc.rs.getString("prenom");
				this.email=oc.rs.getString("email");
				this.date_naissance=oc.rs.getDate("date_naissance");
				this.adresse=oc.rs.getString("adresse");
				this.wilaya=oc.rs.getString("wilaya");
				this.tel=oc.rs.getInt("tel");
			}
			oc.con.close();
		}catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erreur de connexion à la base de données");
		}
	}
	
	public void ajout_user() {
		if(this.username_existe()) {
			JOptionPane.showMessageDialog(null, "Nom d'utilsateur existe déja");
		}else {
			OracleConnection oc = new OracleConnection();
			oc.initialize();
			try {
				oc.stmt = oc.con.prepareStatement("Insert Into Users(username,password,email,type) Values (?,?,?,?)");
				oc.stmt.setString(1, this.username);
				oc.stmt.setString(2, this.password);
				oc.stmt.setString(3, this.email);
				oc.stmt.setString(4, this.type);
				oc.rs=oc.stmt.executeQuery(); 
				if(oc.rs.next()) {
					JOptionPane.showMessageDialog(null, "Utilisateur bien ajouté");
				}
				oc.con.close();
			}catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "Erreur de connexion à la base de données");
			}
		}
	}
	
	public void userExiste() {
		OracleConnection oc = new OracleConnection();
		oc.initialize();
		try {
			oc.stmt = oc.con.prepareStatement("Select type From Users where username = ? and password = ?");
			oc.stmt.setString(1, this.username);
			oc.stmt.setString(2, this.password);
			oc.rs = oc.stmt.executeQuery();
			if(oc.rs.next()) {
				this.type = oc.rs.getString("type");
			}else {
				JOptionPane.showMessageDialog(null, "Nom d'utilisateur ou mot de passe incorrecte", "Alert ", JOptionPane.INFORMATION_MESSAGE);
			}
			oc.con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Erreur de connexion à la base de données");
		}
		
	}
	
	public void modifier_user() {
		OracleConnection oc = new OracleConnection();
		oc.initialize();
		try {
			oc.stmt = oc.con.prepareStatement("Update Users Set username = ?, email = ?, nom= ?, prenom= ?,adresse = ?, wilaya=? Where id=? ");
			oc.stmt.setString(1, this.username);
			oc.stmt.setString(2, this.email);
			oc.stmt.setString(3, this.nom);
			oc.stmt.setString(4, this.prenom);
			//oc.stmt.setDate(5, this.date_naissance);
			oc.stmt.setString(5, this.adresse);
			oc.stmt.setString(6, this.wilaya);
			//oc.stmt.setInt(8, this.tel);
			oc.stmt.setInt(7, this.getId());
			oc.rs = oc.stmt.executeQuery();
			JOptionPane.showMessageDialog(null, "Opération a bien effectué ");
			oc.con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Erreur de connexion à la base de données");
		}
	}
	
	
}
