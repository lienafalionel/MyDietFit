package fr.iut.mydietfit.tables;


public class Utilisateurs {

	private int idUtilisateur;
	private String login;
	private String mdp;
	private String prenom;
	private String nom;
	private String telephone;
	private String mail;
	private String adresse;
	private String dateInscription;
	
	public Utilisateurs(int idUtilisateur, String login, String mdp, String prenom, String nom, String telephone, String mail, String adresse, String dateInscription) {
		this.setIdUtilisateur(idUtilisateur);
		this.setLogin(login);
		this.setMdp(mdp);
		this.setPrenom(prenom);
		this.setNom(nom);
		this.setTelephone(telephone);
		this.setMail(mail);
		this.setAdresse(adresse);
		this.setDateInscription(dateInscription);
	}
	
	public Utilisateurs(String login, String mdp, String prenom, String nom, String telephone, String mail, String adresse, String dateInscription) {
		this.setLogin(login);
		this.setMdp(mdp);
		this.setPrenom(prenom);
		this.setNom(nom);
		this.setTelephone(telephone);
		this.setMail(mail);
		this.setAdresse(adresse);
		this.setDateInscription(dateInscription);
	}

	public int getIdUtilisateur() {
		return idUtilisateur;
	}

	public void setIdUtilisateur(int idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getDateInscription() {
		return dateInscription;
	}

	public void setDateInscription(String dateInscription) {
		this.dateInscription = dateInscription;
	}
}
