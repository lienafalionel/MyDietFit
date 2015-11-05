package fr.iut.mydietfit;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.view.Menu;
import android.widget.TabHost.OnTabChangeListener;

public class AccueilActivity extends FragmentActivity {

	private FragmentTabHost myTabHost;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_accueil);
		setTitle("Mon suivi");
		// Recuperation du TabHost
		myTabHost = (FragmentTabHost) findViewById(R.id.tabHost);
		// Before adding tabs, it is imperative to call the method setup()
		myTabHost.setup(this, getSupportFragmentManager(), R.id.realtabcontent);

		// Adding tabs		
		myTabHost.addTab(myTabHost.newTabSpec("Mon suivi").setIndicator("Mon suivi",getResources().getDrawable(android.R.drawable.ic_menu_add)), MonSuiviActivity.class, null);

		myTabHost.addTab(myTabHost.newTabSpec("Exercices").setIndicator("Exercices",getResources().getDrawable(android.R.drawable.ic_menu_edit)), ListePartieCorpsActivity.class, null);
	
		myTabHost.addTab(myTabHost.newTabSpec("Nutrition").setIndicator("Nutrition",getResources().getDrawable(android.R.drawable.ic_menu_view)), ListeCatNutritionActivity.class, null);				
	
		myTabHost.addTab(myTabHost.newTabSpec("Où se muscler?").setIndicator("Où se muscler?", getResources().getDrawable(android.R.drawable.ic_menu_week)), LocalisationActivity.class, null);
		
		myTabHost.setOnTabChangedListener(new OnTabChangeListener() {
			
			@Override
			public void onTabChanged(String tabId) {
				invalidateOptionsMenu();
				AccueilActivity.this.setTitle(myTabHost.getCurrentTabTag());
			}
		});
		
//		map = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map)).getMap();
		
//		FragmentManager fmanager = getSupportFragmentManager();
//        Fragment fragment = fmanager.findFragmentById(R.id.map);
//        SupportMapFragment supportmapfragment = (SupportMapFragment)fragment;
//        map = supportmapfragment.getMap();
        
//		map = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
//		map.setMyLocationEnabled(true);
//		Location myLocation = map.getMyLocation();
//        LatLng myLatLng = new LatLng(myLocation.getLatitude(), myLocation.getLongitude());
//
//        CameraPosition myPosition = new CameraPosition.Builder()
//                .target(myLatLng).zoom(17).bearing(90).tilt(30).build();
//        map.animateCamera(
//            CameraUpdateFactory.newCameraPosition(myPosition));
//		map.setOnMapLongClickListener(this);
//		map.setOnMarkerClickListener(this);
		
	}
	
	

	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		menu.clear();
		getMenuInflater().inflate(R.menu.liste_exercices, menu);
		return true;
	}
}
