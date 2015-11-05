package fr.iut.mydietfit;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.graphics.Color;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTabHost;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TabHost;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnMapLongClickListener;
import com.google.android.gms.maps.GoogleMap.OnMarkerClickListener;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

public class LocalisationActivity extends Fragment implements OnMapLongClickListener, OnMarkerClickListener {

	private GoogleMap map;
	private TabHost myTabHost;
	private Geocoder geoCoder;
	
	private final int menu_sethybrid = Menu.FIRST;
	private final int menu_showtraffic = Menu.FIRST+1;
	private final int menu_setplan = Menu.FIRST+4;
	private final int menu_showcurrentlocation = Menu.FIRST+7;
	private final int menu_lineconnecttwopoints = Menu.FIRST+8;
	private final int menu_searchadress = Menu.FIRST+9;
	
//	@Override
//	public void onCreate(Bundle savedInstanceState) {
//		super.onCreate(savedInstanceState);
//		
//		setContentView(R.layout.activity_localisation);
//		map = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
////		map = ((MapView) findViewById(R.id.map)).getMap();
//		if (map == null) {
//            Toast.makeText(this, "Google Maps not available", 
//                Toast.LENGTH_LONG).show();
//        }
//	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		setHasOptionsMenu(true);
		View v = inflater.inflate(R.layout.activity_localisation, container, false);
		map = ((MapFragment)getActivity().getFragmentManager().findFragmentById(R.id.map)).getMap();
		map.setMyLocationEnabled(true);
		map.setOnMapLongClickListener(this);
		map.setOnMarkerClickListener(this);
		
		myTabHost = (FragmentTabHost) getActivity().findViewById(R.id.tabHost);
		geoCoder = new Geocoder(getActivity(), Locale.getDefault());
		return v;
	}
	
	@Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
		menu.clear();
		menu.add(0, menu_searchadress, 0, "Rechercher une adresse");
		menu.add(0, menu_lineconnecttwopoints, 0, "Vol d'oiseau");
		if(map.getMapType() == GoogleMap.MAP_TYPE_NORMAL) {
			menu.add(0, menu_sethybrid, 0, "Hybrid Mode");
		}
		else {
			menu.add(0, menu_setplan, 0, "Plan Mode");
		}
		menu.add(0, menu_showtraffic, 0, "Voir traffic");
		menu.add(0, menu_showcurrentlocation, 0, "Show Current Location");
		
		inflater.inflate(R.menu.main, menu);
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case menu_sethybrid:
			map.setMapType(GoogleMap.MAP_TYPE_HYBRID);
			getActivity().invalidateOptionsMenu();
			break;
		case menu_setplan:
			map.setMapType(GoogleMap.MAP_TYPE_NORMAL);
			getActivity().invalidateOptionsMenu();
			break;
		case menu_showtraffic:
			map.setTrafficEnabled(true);
			break;
		case menu_searchadress:
			AlertDialog.Builder alert = new Builder(getActivity());
			alert.setTitle("Rechercher une adresse");
			final EditText input = new EditText(getActivity());
			alert.setView(input);
			alert.setPositiveButton("Rechercher", new OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					try {
						List<Address> adresses = geoCoder.getFromLocationName(input.getText().toString(), 2);
						if(adresses.size() > 0) {
							map.clear();
							LatLng latLng = new LatLng(adresses.get(0).getLatitude(), adresses.get(0).getLongitude());
							map.addMarker(new MarkerOptions().position(latLng));
							CameraPosition cameraPosition = new CameraPosition(latLng, 17, 30, 90);
							map.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
						}
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			});
			alert.setNegativeButton("Annuler", new OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					
				}
			});
			alert.show();
			break;
		case menu_lineconnecttwopoints:
			AlertDialog.Builder alert2 = new Builder(getActivity());
			alert2.setTitle("Vol d'oiseau");
			LayoutInflater factory = LayoutInflater.from(getActivity());
			final View myDialog = factory.inflate(R.layout.my_dialog_layout, myTabHost, false);
			alert2.setView(myDialog);
			alert2.setPositiveButton("Rechercher", new OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					try {
						map.clear();
						EditText txtDepart = (EditText) myDialog.findViewById(R.id.dialog_txt_depart);
						EditText txtArrivee = (EditText) myDialog.findViewById(R.id.dialog_txt_arrivee);
						List<Address> addressDepart = geoCoder.getFromLocationName(txtDepart.getText().toString(), 1);
						List<Address> addressArrivee = geoCoder.getFromLocationName(txtArrivee.getText().toString(), 1);
						map.addMarker(new MarkerOptions().position(new LatLng(addressDepart.get(0).getLatitude(),addressDepart.get(0).getLongitude())));
						map.addMarker(new MarkerOptions().position(new LatLng(addressArrivee.get(0).getLatitude(), addressArrivee.get(0).getLongitude())));
						map.addPolyline(new PolylineOptions().add(new LatLng(addressDepart.get(0).getLatitude(),addressDepart.get(0).getLongitude()), new LatLng(addressArrivee.get(0).getLatitude(), addressArrivee.get(0).getLongitude())).width(5).color(Color.RED));
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			});
			alert2.setNegativeButton("Annuler", new OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					
				}
			});
			alert2.show();
			break;
		case menu_showcurrentlocation:
			Location myLocation = map.getMyLocation();
	        LatLng myLatLng = new LatLng(myLocation.getLatitude(), myLocation.getLongitude());
	        CameraPosition myPosition = new CameraPosition.Builder().target(myLatLng).zoom(17).bearing(90).tilt(30).build();
	        map.animateCamera(CameraUpdateFactory.newCameraPosition(myPosition));
			break;
		default:
			break;
		}
		return false;
	}

	@Override
	public boolean onMarkerClick(Marker arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void onMapLongClick(LatLng arg0) {
		map.clear();
		try {
			List<Address> listAddress = geoCoder.getFromLocation(arg0.latitude, arg0.longitude, 1);
			String adresse = listAddress.get(0).getAddressLine(0) + ", " + listAddress.get(0).getLocality() + ", " + listAddress.get(0).getCountryName();
			map.addMarker(new MarkerOptions().position(arg0).title(adresse)).showInfoWindow();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
