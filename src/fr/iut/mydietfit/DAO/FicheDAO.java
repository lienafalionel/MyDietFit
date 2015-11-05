package fr.iut.mydietfit.DAO;

import android.app.ListActivity;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.widget.SimpleCursorAdapter;
import fr.iut.mydietfit.R;
import fr.iut.mydietfit.R.layout;
import fr.iut.mydietfit.tables.Fiche;

public class FicheDAO extends DAOBase {

	public FicheDAO(Context pContext) {
		super(pContext);
	}

	public static final String TABLE_NAME = "fiche";
	public static final String IDFICHE = "idFiche";
	public static final String DATE = "date";
	public static final String POIDS = "poids";
	public static final String TAILLE = "taille";
	public static final String EVENEMENT = "evenement";
	public static final String IDUTILISATEUR = "idUtilisateur";
	
	public static final String TABLE_CREATE = "CREATE TABLE " + TABLE_NAME + 
			" (" + IDFICHE + " INTEGER PRIMARY KEY AUTOINCREMENT, " + 
			DATE + " TEXT, " + 
			POIDS + " TEXT, " + 
			TAILLE + " INTEGER, " + 
			EVENEMENT + " TEXT, " + 
			IDUTILISATEUR + " INTEGER);";
	
	public static final String TABLE_DROP = "DROP TABLE IF EXISTS " + TABLE_NAME + ";";
	
	public void addFiche(Fiche f) {
		ContentValues value = new ContentValues();
		value.put(DATE, f.getDate());
		value.put(POIDS, f.getPoids());
		value.put(TAILLE, f.getTaille());
		value.put(EVENEMENT, f.getEvenement());
		mDb.insert(TABLE_NAME, IDFICHE, value);
	}
	
	public void delFiche(long id) {
		mDb.delete(TABLE_NAME, IDFICHE + " = ?", new String[] {String.valueOf(id)});
	}
	
	public Fiche getUneFiche(int idFiche) {
		Fiche f = new Fiche();
		Cursor cursor = mDb.rawQuery("SELECT idFiche, date, poids, taille, evenement " + " from " + TABLE_NAME + " where idFiche = ?", new String[]{String.valueOf(idFiche)});
		if(cursor.moveToFirst()) {
			f.setIdFiche(Integer.parseInt(cursor.getString(0)));
			f.setDate(cursor.getString(1));
			f.setPoids(Float.parseFloat(cursor.getString(2)));
			f.setTaille(Integer.parseInt(cursor.getString(3)));
			f.setEvenement(cursor.getString(4));
		}
		cursor.close();
		return f;
	}
	
	public Cursor getLesFiches() {
		return mDb.rawQuery("SELECT idFiche as _id,  date, poids, taille, evenement, idUtilisateur" + " from " + TABLE_NAME, null);
	}
	
	public void refreshFiches(Context context) {
		Cursor cursor = getLesFiches();
		SimpleCursorAdapter sca = new SimpleCursorAdapter(context, layout.utilisateurs_row, cursor, new String[]{FicheDAO.DATE}, new int[] {R.id.text1}, 0);
		((ListActivity) context).setListAdapter(sca);
	}
	
	public Fiche getDerniereFiche() {
		Fiche f = new Fiche();
		Cursor cursor = mDb.rawQuery("SELECT idFiche, date, poids, taille, evenement FROM " + TABLE_NAME + " WHERE idFiche = (SELECT MAX(idFiche) FROM " + TABLE_NAME + ")", null);
		if(cursor.moveToFirst()) {
			f.setIdFiche(Integer.parseInt(cursor.getString(0)));
			f.setDate(cursor.getString(1));
			f.setPoids(Float.parseFloat(cursor.getString(2)));
			f.setTaille(Integer.parseInt(cursor.getString(3)));
			f.setEvenement(cursor.getString(4));
		}
		cursor.close();
		return f;
	}
}
			