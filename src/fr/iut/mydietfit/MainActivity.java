package fr.iut.mydietfit;

import java.util.Date;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import fr.iut.mydietfit.R;
import fr.iut.mydietfit.DAO.UtilisateursDAO;
import fr.iut.mydietfit.tables.Utilisateurs;

public class MainActivity extends Activity {

	private UtilisateursDAO utilisateursDAO;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		utilisateursDAO = new UtilisateursDAO(this);
		utilisateursDAO.open();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.voir_progression_denutrition) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	public void onClick(View v) {
		EditText txtLogin = (EditText) findViewById(R.id.txtLogin);
		EditText txtMdp = (EditText) findViewById(R.id.txtMdp);
		Intent intent = new Intent(this, UtilisateursActivity.class);
		intent.putExtra("login", txtLogin.getText().toString());
		intent.putExtra("mdp", txtMdp.getText().toString());
		this.startActivity(intent);
	}
	
	public void onClickR(View v) {
		Intent intent = new Intent(this, AccueilActivity.class);
		startActivity(intent);
	}
	
	public void onClickt(View v) {
		EditText txtLogin = (EditText) findViewById(R.id.txtLogin);
		EditText txtMdp = (EditText) findViewById(R.id.txtMdp);
		Utilisateurs u = new Utilisateurs(txtLogin.getText().toString(), txtMdp.getText().toString(), "Lionel", "LIENAFA", "0699433625", "lienafa.lionel@gmail.com", "14 rue Eugénie Cotton 93290 Tremblay-en-France", new Date().toString());
		utilisateursDAO.addUtilisateur(u);
		Intent intent = new Intent(this, ListeUtilisateursActivity.class);
		this.startActivity(intent);
	}
	
}
