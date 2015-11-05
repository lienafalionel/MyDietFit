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
			myList.add("Crunch oblique à la poulie haute");
			myList.add("Crunch décliné avec rotation");
			myList.add("Relevé de jambes au banc incliné");
			myList.add("Flexions latérales debout avec haltère");
			break;
		case "Biceps":
			myList.add("Curl halère au banc");
			myList.add("Curl haltère supination");
			myList.add("Curl haltère au pupitre");
			myList.add("Curl barre");
			break;
		case "Dos":
			myList.add("Tirage vertical en supination");
			myList.add("Rowling d'un bras avec haltère");
			myList.add("Tirage menton à la barre");
			break;
		case "Epaules":
			myList.add("Elévation avant à la poulie basse");
			myList.add("Développé militaire guidé");
			myList.add("Elévations latérales avec haltères");
			myList.add("Elevation frontale avec haltère");
			myList.add("Oiseau à la pulie haute");
			myList.add("Développé assis avec haltères");
			myList.add("Pec deck inversé");
			break;
		case "Pectoraux":
			myList.add("Ecartés à plat aux pulies basses");
			myList.add("Pec deck");
			myList.add("Développé décliné avec haltères");
			myList.add("Ecartés déclinés avec haltères");
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
