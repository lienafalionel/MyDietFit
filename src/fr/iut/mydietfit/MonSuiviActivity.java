package fr.iut.mydietfit;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

public class MonSuiviActivity extends Fragment{
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.activity_mon_suivi, container, false);
		((Button) v.findViewById(R.id.ajoutFicheSuivi)).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(getActivity(), AjoutFiche.class);
				startActivity(intent);
			}
		});
		((Button) v.findViewById(R.id.voirFicheSuivi)).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(getActivity(), ListeFicheActivity.class);
				startActivity(intent);
			}
		});
		((Button) v.findViewById(R.id.voirProgression)).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(getActivity(), VoirProgressionActivity.class);
				startActivity(intent);
			}
		});
		return v;
	}
}