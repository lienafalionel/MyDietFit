package fr.iut.mydietfit;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import fr.iut.mydietfit.R;
import fr.iut.mydietfit.DAO.FicheDAO;
import fr.iut.mydietfit.tables.Fiche;

public class VoirFicheActivity extends Activity{

	private FicheDAO ficheDAO;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_voir_fiche);
		ficheDAO = new FicheDAO(this);
		ficheDAO.open();
		int idFiche = (int)getIntent().getExtras().getLong("idFiche");
		Fiche uneFiche = ficheDAO.getUneFiche(idFiche);
		setTitle("Fiche de suivi n°" + idFiche);
		TextView txtDate = (TextView) findViewById(R.id.voir_fiche_txtDate);
		TextView txtPoids = (TextView) findViewById(R.id.voir_fiche_txtPoids);
		TextView txtTaille = (TextView) findViewById(R.id.voir_fiche_txtTaille);
		TextView txtEvenement = (TextView) findViewById(R.id.voir_fiche_txtEvenement);
		txtDate.setText(uneFiche.getDate());
		txtPoids.setText(String.valueOf(uneFiche.getPoids()));
		txtTaille.setText(String.valueOf(uneFiche.getTaille()));
		txtEvenement.setText(uneFiche.getEvenement());
	}
}
