package fr.iut.mydietfit;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListeCatNutritionActivity extends ListFragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		String[] myList = new String[] {"Diététique", "Maigrir", "Conseils Nutrition"};
		setListAdapter(new ArrayAdapter<String>(getActivity(), R.layout.activity_liste_cat_nutrition, android.R.id.empty, myList));
		return inflater.inflate(R.layout.activity_liste_cat_nutrition, container, false);
	}
	
	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		Intent i = new Intent(getActivity(), ListeNutrition.class);
		i.putExtra("catNutrition", getListAdapter().getItem(position).toString());
		startActivity(i);
	}
}
