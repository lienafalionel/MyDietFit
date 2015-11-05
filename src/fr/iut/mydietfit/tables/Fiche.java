package fr.iut.mydietfit.tables;

public class Fiche {

	private int idFiche;
	private String date;
	private float poids;
	private int taille;
	private String evenement;
	private int idUtilisateur;
	
	public Fiche(int idFiche, String date, float poids, int taille, String evenement, int idUtilisateur) {
		this.idFiche = idFiche;
		this.date = date;
		this.poids = poids;
		this.taille = taille;
		this.evenement = evenement;
		this.idUtilisateur = idUtilisateur;
	}
	
	public Fiche(String date, float poids, int taille, String evenement, int idUtilisateur) {
		this.date = date;
		this.poids = poids;
		this.taille = taille;
		this.evenement = evenement;
		this.idUtilisateur = idUtilisateur;
	}

	public Fiche() {
		
	}

	public int getIdFiche() {
		return idFiche;
	}

	public void setIdFiche(int idFiche) {
		this.idFiche = idFiche;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public float getPoids() {
		return poids;
	}

	public void setPoids(float poids) {
		this.poids = poids;
	}

	public int getTaille() {
		return taille;
	}

	public void setTaille(int taille) {
		this.taille = taille;
	}

	public String getEvenement() {
		return evenement;
	}

	public void setEvenement(String evenement) {
		this.evenement = evenement;
	}

	public int getIdUtilisateur() {
		return idUtilisateur;
	}

	public void setIdUtilisateur(int idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}
}
