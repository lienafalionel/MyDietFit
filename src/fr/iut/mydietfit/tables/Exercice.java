package fr.iut.mydietfit.tables;

public class Exercice {

	private int idExercice;
	private String titre;
	private String resume;
	private String description;
	private String dateAjout;
	private int idPartieCorps;
	private String video;
	private String image;
	
	public Exercice(int idExercice, String titre, String resume, String description, String dateAjout, int idPartieCorps, String video, String image) {
		this.idExercice = idExercice;
		this.titre = titre;
		this.resume = resume;
		this.description = description;
		this.dateAjout = dateAjout;
		this.idPartieCorps= idPartieCorps;
		this.video = video;
		this.image = image;
	}
	
	public Exercice(String titre, String resume, String description, String dateAjout, int idPartieCorps, String video, String image) {
		this.titre = titre;
		this.resume = resume;
		this.description = description;
		this.dateAjout = dateAjout;
		this.idPartieCorps = idPartieCorps;
		this.video = video;
		this.image = image;
	}
	
	public Exercice() {
		
	}
	
	public int getIdExercice() {
		return idExercice;
	}
	
	public void setIdExercice(int idExercice) {
		this.idExercice = idExercice;
	}
	
	public String getTitre() {
		return titre;
	}
	
	public void setTitre(String titre) {
		this.titre = titre;
	}
	
	public String getResume() {
		return resume;
	}
	
	public void setResume(String resume) {
		this.resume = resume;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getDateAjout() {
		return dateAjout;
	}
	
	public void setDateAjout(String dateAjout) {
		this.dateAjout = dateAjout;
	}
	
	public int getIdPartieCorps() {
		return idPartieCorps;
	}
	
	public void setIdPartieCorps(int idPartieCorps) {
		this.idPartieCorps = idPartieCorps;
	}
	
	public String getVideo() {
		return video;
	}
	
	public void setVideo(String video) {
		this.video = video;
	}
	
	public String getImage() {
		return image;
	}
	
	public void setImage(String image) {
		this.image = image;
	}
}
