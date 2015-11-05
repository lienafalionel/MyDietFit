package fr.iut.mydietfit;

import android.app.ListActivity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;
import fr.iut.mydietfit.R;
import fr.iut.mydietfit.DAO.FicheDAO;

public class ListeFicheActivity extends ListActivity implements OnItemClickListener{

	private FicheDAO ficheDAO;
	private ListView listView;
	
	private static final int EDIT_ID = Menu.FIRST;
	private static final int DELETE_ID = Menu.FIRST+1;
	private static final int SHARE_ID = Menu.FIRST+2;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_liste_fiches);
		setTitle("Liste des fiches de suivi");
		listView = (ListView) findViewById(android.R.id.list);
		registerForContextMenu(listView);
		listView.setOnItemClickListener(this);
		ficheDAO = new FicheDAO(this);
		ficheDAO.open();
		ficheDAO.refreshFiches(this);
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		Intent intent = new Intent(this, VoirFicheActivity.class);
		intent.putExtra("idFiche", id);
		startActivity(intent);
	}
	
	
	@Override
	public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo) {
		super.onCreateContextMenu(menu, v, menuInfo);
		menu.setHeaderTitle("Menu");
		menu.add(0, EDIT_ID, 0, "Modifier la fiche");
		menu.add(0, DELETE_ID, 0, "Supprimer la fiche");
		menu.add(1, SHARE_ID, 0, "Partager la fiche");
	}
	
	@Override
	public boolean onContextItemSelected(MenuItem item) {
		AdapterContextMenuInfo info = (AdapterContextMenuInfo) item.getMenuInfo();
		switch (item.getItemId()) {
		case DELETE_ID:
			ficheDAO.delFiche(info.id);
			ficheDAO.refreshFiches(this);
			Toast.makeText(this, "Fiche supprimée avec succès!", Toast.LENGTH_LONG).show();
			break;
		case EDIT_ID:
			Toast.makeText(this, "Modification de la fiche", Toast.LENGTH_LONG).show();
			break;
		case SHARE_ID:
			Toast.makeText(this, "Partage de la fiche", Toast.LENGTH_LONG).show();
			Intent intent = new Intent(this, VoirFicheActivity.class);
			intent.putExtra("idFiche", info.id);
			NotificationManager notificationManager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
			Notification notification = new Notification.Builder(this).setContentTitle("Envoi de la fiche").setContentText("Partage de la fiche n°" + info.id).setVibrate(new long[] {0,200,100,200,100,200}).setTicker("Notification!").setWhen(System.currentTimeMillis())
			          .setContentIntent(PendingIntent.getActivity(this, 0, intent, Intent.FLAG_ACTIVITY_NEW_TASK))
			          .setDefaults(Notification.DEFAULT_SOUND)
			          .setLights(Color.YELLOW, 500, 500)
			          .setAutoCancel(true)
			          .setSmallIcon(R.drawable.ic_launcher)
			          .build();
			notificationManager.notify(1993, notification);
			break;
		default:
			return false;
		}
		return super.onContextItemSelected(item);
	}
}
