package fr.iut.mydietfit;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ListeUtilisateursActivity extends ListFragment {

//	private UtilisateursDAO utilisateursDAO;
//	private List<String> lesNomsUtilisateurs;
	
//	@Override
//	protected void onCreate(Bundle savedInstanceState) {
//		super.onCreate(savedInstanceState);
//		setContentView(R.layout.activity_liste_utilisateurs);
//		utilisateursDAO = new UtilisateursDAO(this);
//		utilisateursDAO.open();
//		Cursor cursor = utilisateursDAO.getLesUtilisateurs();
//		SimpleCursorAdapter sca = new SimpleCursorAdapter(this, R.layout.utilisateurs_row, cursor, new String[] {UtilisateursDAO.LOGIN}, new int[]{R.id.text1}, 0);
//		setListAdapter(sca);
//		//		cursor.moveToFirst();
////		while (!cursor.isAfterLast()) {
////			lesNomsUtilisateurs.add(cursor.getString(cursor.getColumnIndex("login")));
////		      cursor.moveToNext();
////		}
////		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, lesNomsUtilisateurs);
////		setListAdapter(adapter);
//	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return inflater.inflate(R.layout.activity_liste_utilisateurs, container, false);
	}
}
