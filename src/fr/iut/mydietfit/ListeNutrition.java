package fr.iut.mydietfit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;

public class ListeNutrition extends ListActivity {

	private String catNutrition;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_liste_nutrition);
		catNutrition = getIntent().getExtras().getString("catNutrition");
		setListAdapter(new ArrayAdapter<String>(this, R.layout.activity_liste_exercices, android.R.id.empty, initList()));
		setTitle(catNutrition);
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
		switch (catNutrition) {
		case "Diététique":
			myList.add("Les protéines");
			myList.add("Les lipides");
			break;
		case "Maigrir":
			myList.add("Les mythes diététiques");
			break;
		default:
			break;
		}
		return Arrays.copyOf(myList.toArray(), myList.size(), String[].class);
	}
	
}
