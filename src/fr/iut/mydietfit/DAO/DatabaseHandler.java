package fr.iut.mydietfit.DAO;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;

public class DatabaseHandler extends SQLiteOpenHelper {

	public static final String UTILISATEUR_TABLE_NAME = "Utilisateurs";
	public static final String UTILISATEUR_ID = "idUtilisateur";
	public static final String UTILISATEUR_LOGIN = "login";
	public static final String UTILISATEUR_MDP = "mdp";
	public static final String UTILISATEUR_PRENOM = "prenom";
	public static final String UTILISATEUR_NOM = "nom";
	public static final String UTILISATEUR_TELEPHONE = "telephone";
	public static final String UTILISATEUR_MAIL = "mail";
	public static final String UTILISATEUR_ADRESSE = "adresse";
	public static final String UTILISATEUR_DATEINSCRIPTION = "dateInscription";
	public static final String UTILISATEUR_TABLE_CREATE = "CREATE TABLE " + 
			UTILISATEUR_TABLE_NAME + " (" +
			UTILISATEUR_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
			UTILISATEUR_LOGIN + " TEXT, " +
			UTILISATEUR_MDP + " TEXT, " +
			UTILISATEUR_PRENOM + " TEXT, " +
			UTILISATEUR_NOM + " TEXT, " +
			UTILISATEUR_TELEPHONE + " TEXT, " +
			UTILISATEUR_MAIL + " TEXT, " +
			UTILISATEUR_ADRESSE + " TEXT, " +
			UTILISATEUR_DATEINSCRIPTION + " TEXT);";
	public static final String UTILISATEUR_TABLE_DROP = "DROP TABLE IF EXISTS " + UTILISATEUR_TABLE_NAME + ";";
	
	public static final String FICHE_TABLE_NAME = "Fiche";
	public static final String FICHE_ID = "idFiche";
	public static final String FICHE_DATE = "date";
	public static final String FICHE_POIDS = "poids";
	public static final String FICHE_TAILLE = "taille";
	public static final String FICHE_EVENEMENT = "evenement";
	public static final String FICHE_IDUTILISATEUR = "idUtilisateur";
	public static final String FICHE_TABLE_CREATE = "CREATE TABLE " + 
			FICHE_TABLE_NAME + " (" +
			FICHE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
			FICHE_DATE + " TEXT, " +
			FICHE_POIDS + " TEXT, " + 
			FICHE_TAILLE + " INTEGER, " + 
			FICHE_EVENEMENT + " TEXT, " + 
			FICHE_IDUTILISATEUR + " INTEGER);";
	public static final String FICHE_TABLE_DROP = "DROP TABLE IF EXISTS " + FICHE_TABLE_NAME + ";";
	
	public DatabaseHandler(Context context, String name, CursorFactory factory, int version) {
		super(context, name, factory, version);
	}
	
	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(UTILISATEUR_TABLE_CREATE);
		db.execSQL(FICHE_TABLE_CREATE);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL(UTILISATEUR_TABLE_DROP);
		db.execSQL(FICHE_TABLE_DROP);
		onCreate(db);
	}
}
