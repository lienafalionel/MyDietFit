package fr.iut.mydietfit;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListePartieCorpsActivity extends ListFragment {
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		String[] myList = new String[] {"Abdominaux", "Biceps", "Dos", "Epaules", "Pectoraux", "Triceps"};
		setListAdapter(new ArrayAdapter<String>(getActivity(), R.layout.activity_liste_partie_corps, android.R.id.empty, myList));
		return inflater.inflate(R.layout.activity_liste_partie_corps, container, false);
	}
	
	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		Intent i = new Intent(getActivity(), ListeExercices.class);
		i.putExtra("partieCorps", getListAdapter().getItem(position).toString());
		startActivity(i);
	}
}
