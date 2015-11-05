package fr.iut.mydietfit;

import fr.iut.mydietfit.R;
import fr.iut.mydietfit.DAO.FicheDAO;
import fr.iut.mydietfit.tables.Fiche;
import android.app.Activity;
import android.os.Bundle;
import android.widget.TableRow;
import android.widget.TextView;

public class VoirProgressionActivity extends Activity{

	private FicheDAO ficheDAO;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_voir_progression);
		ficheDAO = new FicheDAO(this);
		ficheDAO.open();
		Fiche uneFiche = ficheDAO.getDerniereFiche();
		float poids = uneFiche.getPoids();
		int tailleCM = uneFiche.getTaille();
		float taille = (float)uneFiche.getTaille()/100;
		float imc = (poids / (taille * taille));
		((TextView) findViewById(R.id.voir_progression_imc)).setText("Votre IMC est de: " + imc);
		((TextView) findViewById(R.id.voir_progression_rappel)).setText("Pour rappel: votre poids est " + poids + "kg et votre taille est " + tailleCM + "cm.");
		((TextView) findViewById(R.id.voir_progression_denutrition)).setText("En dessous de " + (15 * (taille * taille) + "kg"));
		((TextView) findViewById(R.id.voir_progression_maigreur)).setText("Entre " + (15 * (taille * taille)) + "kg et " + (18.5 * (taille * taille)) + "kg");
		((TextView) findViewById(R.id.voir_progression_normal)).setText("Entre " + (18.5 * (taille * taille)) + "kg et " + (25 * (taille * taille)) + "kg");
		((TextView) findViewById(R.id.voir_progression_surpoids)).setText("Entre " + (25 * (taille * taille)) + "kg et " + (30 * (taille * taille)) + "kg");
		((TextView) findViewById(R.id.voir_progression_obesite_mod)).setText("Entre " + (30 * (taille * taille)) + "kg et " + (35 * (taille * taille)) + "kg");
		((TextView) findViewById(R.id.voir_progression_obesite_sev)).setText("Entre " + (35 * (taille * taille)) + "kg et " + (40 * (taille * taille)) + "kg");
		((TextView) findViewById(R.id.voir_progression_obesite_morb)).setText("Au-dessus de " + (40 * (taille * taille)) + "kg");
		
		if(imc < 15) {
			((TableRow) findViewById(R.id.voir_progression_trDenutrition)).setBackgroundColor(getResources().getColor(android.R.color.holo_orange_dark));
		}
		if(imc >= 15 && imc < 18.5) {
			((TableRow) findViewById(R.id.voir_progression_trMaigreur)).setBackgroundColor(getResources().getColor(android.R.color.holo_orange_dark));
		}
		if(imc >= 18.5 && imc < 25) {
			((TableRow) findViewById(R.id.voir_progression_trNormal)).setBackgroundColor(getResources().getColor(android.R.color.holo_orange_dark));
		}
		if(imc >= 25 && imc < 30) {
			((TableRow) findViewById(R.id.voir_progression_trSurpoids)).setBackgroundColor(getResources().getColor(android.R.color.holo_orange_dark));
		}
		if(imc >= 30 && imc < 35) {
			((TableRow) findViewById(R.id.voir_progression_trObesiteMod)).setBackgroundColor(getResources().getColor(android.R.color.holo_orange_dark));
		}
		if(imc >= 35 && imc < 40) {
			((TableRow) findViewById(R.id.voir_progression_trObesiteSev)).setBackgroundColor(getResources().getColor(android.R.color.holo_orange_dark));
		}
		if(imc >= 40) {
			((TableRow) findViewById(R.id.voir_progression_trObesiteMorb)).setBackgroundColor(getResources().getColor(android.R.color.holo_orange_dark));
		}
	}
}
