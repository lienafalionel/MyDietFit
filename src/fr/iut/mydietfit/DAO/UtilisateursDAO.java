package fr.iut.mydietfit.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import fr.iut.mydietfit.tables.Utilisateurs;


public class UtilisateursDAO extends DAOBase {
	
	public UtilisateursDAO(Context pContext) {
		super(pContext);
	}

	public static final String TABLE_NAME = "utilisateurs";
	public static final String IDUTILISATEUR = "idUtilisateur";
	public static final String LOGIN = "login";
	public static final String MDP = "mdp";
	public static final String PRENOM = "prenom";
	public static final String NOM = "nom";
	public static final String TELEPHONE = "telephone";
	public static final String MAIL = "mail";
	public static final String ADRESSE = "adresse";
	public static final String DATEINSCRIPTION = "dateInscription";
	
	public static final String TABLE_CREATE = "CREATE TABLE " + TABLE_NAME + " (" + IDUTILISATEUR + " INTEGER PRIMARY KEY AUTOINCREMENT, " + LOGIN + " TEXT, " + MDP + " TEXT, " + PRENOM + " TEXT, " + NOM + " TEXT, " + 
	TELEPHONE + " TEXT, " + MAIL + " TEXT, " + ADRESSE + " TEXT, " + DATEINSCRIPTION + " TEXT);";
	
	public static final String TABLE_DROP = "DROP TABLE IF EXISTS " + TABLE_NAME + ";";
	
	public void addUtilisateur(Utilisateurs u) {
		ContentValues value = new ContentValues();
		value.put(LOGIN, u.getLogin());
		value.put(MDP, u.getMdp());
		value.put(PRENOM, u.getPrenom());
		value.put(NOM, u.getNom());
		value.put(TELEPHONE, u.getTelephone());
		value.put(MAIL, u.getMail());
		value.put(ADRESSE, u.getAdresse());
		value.put(DATEINSCRIPTION, u.getDateInscription());
		mDb.insert(TABLE_NAME, LOGIN, value);
	}

	public void delUtilisateur(int idUtilisateur) {
		mDb.delete(TABLE_NAME, IDUTILISATEUR + " = ?", new String[] {String.valueOf(idUtilisateur)});
	}
	
	public void updateUtilisateur(Utilisateurs u) {
		ContentValues value = new ContentValues();
		value.put(LOGIN, u.getLogin());
		value.put(MDP, u.getMdp());
		value.put(PRENOM, u.getPrenom());
		value.put(NOM, u.getNom());
		value.put(TELEPHONE, u.getTelephone());
		value.put(MAIL, u.getMail());
		value.put(ADRESSE, u.getAdresse());
		mDb.update(TABLE_NAME, value, IDUTILISATEUR + " = ?", new String[] {String.valueOf(u.getIdUtilisateur())});
	}
	
	public Utilisateurs getUnUtilisateur(int idUtilisateur) {
		Cursor c = mDb.rawQuery("SELECT idUtilisateur, login, mdp, prenom, nom, telephone, mail, adresse, dateInscription " + " from " + TABLE_NAME + "where idUtilisateur = ?", new String[]{String.valueOf(idUtilisateur)});
		return new Utilisateurs(c.getInt(0), c.getString(1), c.getString(2), c.getString(3), c.getString(4), c.getString(5), c.getString(6), c.getString(7), c.getString(8));
	}
	
	public Cursor getLesUtilisateurs() {
		return mDb.rawQuery("SELECT idUtilisateur as _id, login, mdp, prenom, nom, telephone, mail, adresse, dateInscription" + " from " + TABLE_NAME, null);
	}
}
