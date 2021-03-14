import java.sql.Date;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Don {
	private int code;
	private String title,description,owner,categorie,wilaya,etat,date_creation;
	
	public Don() {
		title="";
		description="";
		owner="";
		categorie="";
		wilaya="";
		etat="";
	}

	public Don(String title, String description, String owner, String categorie, String wilaya, String etat, String date_creation) {
		this.title = title;
		this.description = description;
		this.owner = owner;
		this.categorie = categorie;
		this.wilaya = wilaya;
		this.etat = etat;
		this.date_creation = date_creation;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getCategorie() {
		return categorie;
	}

	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}

	public String getWilaya() {
		return wilaya;
	}

	public void setWilaya(String wilaya) {
		this.wilaya = wilaya;
	}

	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	public String getDate_creation() {
		return date_creation;
	}

	public void setDate_creation(String date_creation) {
		this.date_creation = date_creation;
	}
	
	public void ajout_don() {
		OracleConnection oc = new OracleConnection();
		oc.initialize();
		
		try {
			oc.stmt=oc.con.prepareStatement("Insert into Dons (title,description,owner,date_don,categorie,wilaya,etat) Values (?,?,?,TO_DATE(?,'dd-MM-yyyy HH24:MI'),?,?,?)");
			oc.stmt.setString(1, title);
			oc.stmt.setString(2, description);
			oc.stmt.setString(3, owner);
			oc.stmt.setString(4, date_creation);
			oc.stmt.setString(5, categorie);
			oc.stmt.setString(6, wilaya);
			oc.stmt.setString(7, etat);
			oc.rs = oc.stmt.executeQuery();
			JOptionPane.showMessageDialog(null, "Opération a bien effectué ");
			oc.con.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erreur de connexion à la base de données");
		}
	}
	
	public void modifier_don() {
		OracleConnection oc = new OracleConnection();
		oc.initialize();
		
		try {
			oc.stmt=oc.con.prepareStatement("Update Dons set title= ?, description=?, categorie=?, wilaya=?, etat=? where code=?");
			oc.stmt.setString(1, title);
			oc.stmt.setString(2, description);
			oc.stmt.setString(3, categorie);
			oc.stmt.setString(4, wilaya);
			oc.stmt.setString(5, etat);
			oc.stmt.setInt(6, code);
			oc.rs = oc.stmt.executeQuery();
			JOptionPane.showMessageDialog(null, "Opération a bien effectué ");
			oc.con.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erreur de connexion à la base de données");
		}
	}
	
	public void supprimer_don() {
		OracleConnection oc = new OracleConnection();
		oc.initialize();
		
		try {
			oc.stmt=oc.con.prepareStatement("Delete from Dons where code=?");
			oc.stmt.setInt(1, code);
			oc.rs = oc.stmt.executeQuery();
			JOptionPane.showMessageDialog(null, "Opération a bien effectué ");
			oc.con.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erreur de connexion à la base de données");
		}
	}
	
	public void changer_etat() {
		OracleConnection oc = new OracleConnection();
		oc.initialize();
		
		try {
			oc.stmt=oc.con.prepareStatement("Update Dons set etat= ? where code=?");
			oc.stmt.setString(1, etat);
			oc.stmt.setInt(2, code);
			oc.rs = oc.stmt.executeQuery();
			JOptionPane.showMessageDialog(null, "Opération a bien effectué ");
			oc.con.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erreur de connexion à la base de données");
		}
	}
}
