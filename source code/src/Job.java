import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Job {
	private int code;
	private String title,description,owner,wilaya,etat,date_creation,duree;
	private long salaire;
	
	public Job() {
		title="";
		description="";
		owner="";
		wilaya="";
		etat="";
	}

	public Job(String title, String description, String owner, String wilaya, String etat, String date_creation, long salaire, String duree) {
		this.title = title;
		this.description = description;
		this.owner = owner;
		this.wilaya = wilaya;
		this.etat = etat;
		this.date_creation = date_creation;
		this.salaire=salaire;
		this.duree=duree;
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
	
	public String getDuree() {
		return duree;
	}

	public void setDuree(String duree) {
		this.duree = duree;
	}

	public long getSalaire() {
		return salaire;
	}

	public void setSalaire(long salaire) {
		this.salaire = salaire;
	}

	public void ajout_job() {
		OracleConnection oc = new OracleConnection();
		oc.initialize();
		
		try {
			oc.stmt=oc.con.prepareStatement("Insert into Jobs (titre,description,owner,date_job,wilaya,etat,duration,salaire) Values (?,?,?,TO_DATE(?,'dd-MM-yyyy HH24:MI'),?,?,?,?)");
			oc.stmt.setString(1, title);
			oc.stmt.setString(2, description);
			oc.stmt.setString(3, owner);
			oc.stmt.setString(4, date_creation);
			oc.stmt.setString(5, wilaya);
			oc.stmt.setString(6, etat);
			oc.stmt.setLong(8, salaire);
			oc.stmt.setString(7, duree);
			oc.rs = oc.stmt.executeQuery();
			JOptionPane.showMessageDialog(null, "Opération a bien effectué ");
			oc.con.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erreur de connexion à la base de données");
		}
	}
	
	public void modifier_job() {
		OracleConnection oc = new OracleConnection();
		oc.initialize();
		
		try {
			oc.stmt=oc.con.prepareStatement("Update Jobs set titre= ?, description=?, wilaya=?, etat=?, salaire=?, duration=? where code=?");
			oc.stmt.setString(1, title);
			oc.stmt.setString(2, description);
			oc.stmt.setString(3, wilaya);
			oc.stmt.setString(4, etat);
			oc.stmt.setInt(7, code);
			oc.stmt.setLong(5, salaire);
			oc.stmt.setString(6, duree);
			oc.rs = oc.stmt.executeQuery();
			JOptionPane.showMessageDialog(null, "Opération a bien effectué ");
			oc.con.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erreur de connexion à la base de données");
		}
	}
	
	public void supprimer_job() {
		OracleConnection oc = new OracleConnection();
		oc.initialize();
		
		try {
			oc.stmt=oc.con.prepareStatement("Delete from Jobs where code=?");
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
			oc.stmt=oc.con.prepareStatement("Update Jobs set etat= ? where code=?");
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
