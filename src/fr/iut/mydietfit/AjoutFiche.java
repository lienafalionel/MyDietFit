package fr.iut.mydietfit;

import java.text.DateFormat;
import java.util.Date;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import fr.iut.mydietfit.R;
import fr.iut.mydietfit.DAO.FicheDAO;
import fr.iut.mydietfit.tables.Fiche;

public class AjoutFiche extends Activity{

	private FicheDAO ficheDAO;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ajout_fiche);
		getActionBar().setDisplayHomeAsUpEnabled(true);
		ficheDAO = new FicheDAO(this);
		ficheDAO.open();
	}

	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			NavUtils.navigateUpFromSameTask(this);
			return true;
		default:
			break;
		}
		return super.onOptionsItemSelected(item);
	}
	
	public void onClick(View v) {
		EditText txtPoids = (EditText) findViewById(R.id.txtPoids);
		EditText txtTaille = (EditText) findViewById(R.id.txtTaille);
		EditText txtEvenement = (EditText) findViewById(R.id.txtEvenement);
		Fiche f = new Fiche(DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.MEDIUM).format(new Date()), Float.valueOf(txtPoids.getText().toString()), Integer.valueOf(txtTaille.getText().toString()), txtEvenement.getText().toString(), 1);
		ficheDAO.addFiche(f);
		Intent intent = new Intent(this, ListeFicheActivity.class);
		this.startActivity(intent);
	}
}