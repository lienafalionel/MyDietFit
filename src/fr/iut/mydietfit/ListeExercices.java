package fr.iut.mydietfit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListeExercices extends ListActivity {

	private String partieCorps;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_liste_exercices);
		partieCorps = getIntent().getExtras().getString("partieCorps");
		setListAdapter(new ArrayAdapter<String>(this, R.layout.activity_liste_exercices, android.R.id.empty, initList()));
		setTitle("Liste des exercices pour " + partieCorps);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.liste_exercices, menu);
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
	
	public String[] initList() {
		List<String> myList = new ArrayList<>();
		switch (partieCorps) {
		case "Abdominaux":
			myList.add("Crunch oblique � la poulie haute");
			myList.add("Crunch d�clin� avec rotation");
			myList.add("Relev� de jambes au banc inclin�");
			myList.add("Flexions lat�rales debout avec halt�re");
			break;
		case "Biceps":
			myList.add("Curl hal�re au banc");
			myList.add("Curl halt�re supination");
			myList.add("Curl halt�re au pupitre");
			myList.add("Curl barre");
			break;
		case "Dos":
			myList.add("Tirage vertical en supination");
			myList.add("Rowling d'un bras avec halt�re");
			myList.add("Tirage menton � la barre");
			break;
		case "Epaules":
			myList.add("El�vation avant � la poulie basse");
			myList.add("D�velopp� militaire guid�");
			myList.add("El�vations lat�rales avec halt�res");
			myList.add("Elevation frontale avec halt�re");
			myList.add("Oiseau � la pulie haute");
			myList.add("D�velopp� assis avec halt�res");
			myList.add("Pec deck invers�");
			break;
		case "Pectoraux":
			myList.add("Ecart�s � plat aux pulies basses");
			myList.add("Pec deck");
			myList.add("D�velopp� d�clin� avec halt�res");
			myList.add("Ecart�s d�clin�s avec halt�res");
		default:
			break;
		}
		return Arrays.copyOf(myList.toArray(), myList.size(), String[].class);
	}
	
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		Intent i = new Intent(this, ExerciceActivity.class);
		i.putExtra("titre", getListAdapter().getItem(position).toString());
		startActivity(i);
	}
	
}
