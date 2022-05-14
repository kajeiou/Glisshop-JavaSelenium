package objects;
import java.util.Random;

public class Utilisateur {
	private String nom;
	private String prenom;
	private String email;
	private String telephone;
	private String mdp;
	private String numAdresse;
	private String nomAdresse;
	private String cpAdresse;
	private String villeAdresse;
	
	public Utilisateur() {
		this.setNom("DeuxPointZero");
		this.setPrenom("UnRobot");
		this.setEmail(this.genereEmail());
		this.setTelephone("0707070707");
		this.setMdp("@MonMotdePasseBienLong2022");
		this.setNumAdresse("37");
		this.setNomAdresse("rue de Paris");
		this.setCpAdresse("93150");
		this.setVilleAdresse("Le Blanc-Mesnil");
	}
	public Utilisateur (String nom, String prenom, String email, String telephone,
			String mdp, String numAdr, String nomAdr, String cpAdr, String villeAdr) {
		this.setNom(nom);
		this.setPrenom(prenom);
		//this.setEmail(this.genereEmail());
		this.setEmail(email);
		this.setTelephone(telephone);
		this.setMdp(mdp);
		this.setNumAdresse(numAdr);
		this.setNomAdresse(nomAdr);
		this.setCpAdresse(cpAdr);
		this.setVilleAdresse(villeAdr);
	}
	public String genereEmail() {
		Random r = new Random();
		String alphabet = "abcdefghijklmnopqrstuvwxyz";
		String email = "";
	    for (int i = 0; i < 15; i++) {
	       email = email + alphabet.charAt(r.nextInt(alphabet.length()));
	    }
	    return email  + "@gmail.com";
	}
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

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

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getNumAdresse() {
		return numAdresse;
	}

	public void setNumAdresse(String numAdresse) {
		this.numAdresse = numAdresse;
	}

	public String getVilleAdresse() {
		return villeAdresse;
	}

	public void setVilleAdresse(String villeAdresse) {
		this.villeAdresse = villeAdresse;
	}

	public String getNomAdresse() {
		return nomAdresse;
	}

	public void setNomAdresse(String nomAdresse) {
		this.nomAdresse = nomAdresse;
	}

	public String getCpAdresse() {
		return cpAdresse;
	}

	public void setCpAdresse(String cpAdresse) {
		this.cpAdresse = cpAdresse;
	}
	
	public String toString() {
	   return "Prenom : " + this.nom + "Nom : " + this.prenom + " Email : " + this.email + "Mdp : " + this.mdp;
	}
	
	
	
}
