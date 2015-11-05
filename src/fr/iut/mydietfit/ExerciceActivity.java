package fr.iut.mydietfit;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class ExerciceActivity extends Activity {
	    private TextView txt;
	    private String titre;
	    
	    @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.utilisateurs);
	 
	        txt = (TextView) findViewById(R.id.resultReq);
	 
	        // Définir le texte et appeler la fonction de connexion. 
	        txt.setText("Connexion...");
	        
	        Bundle bundle = getIntent().getExtras();
	        titre = bundle.getString("titre");
	        
	        // Appeler la méthode pour récupérer les données JSON
	        DownTask dlTask = new DownTask();
	        dlTask.execute();
	    }
	 
	    // Mettre l'adresse du script PHP
	    // Attention localhost ou 127.0.0.1 ne fonctionnent pas. Mettre l'adresse IP local.
	    public static final String strURL = "http://mad1.byethost15.com/exercices.php";
	    
	    class DownTask extends AsyncTask<String, Void, String> {

	    	@Override
	    	protected String doInBackground(String... params) {
	    		
	    		String returnString = "";
	            InputStream is = null;
	            String result = "";
	            // Envoyer la requête au script PHP.
	            // Script PHP : $sql=mysql_query("select * from tblVille where Nom_ville like '".$_REQUEST['ville']."%'");
	            // $_REQUEST['ville'] sera remplacé par L dans notre exemple.
	            // Ce qui veut dire que la requête enverra les villes commençant par la lettre L
	            
	            ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
	            nameValuePairs.add(new BasicNameValuePair("titre", titre));
	     
	            // Envoie de la commande http
	            try{
	                HttpClient httpclient = new DefaultHttpClient();
	                HttpPost httppost = new HttpPost(strURL);
	                httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
	                HttpResponse response = httpclient.execute(httppost);
	                HttpEntity entity = response.getEntity();
	                is = entity.getContent();
	     
	            }catch(Exception e){
	                Log.e("log_tag", "Error in http connection " + e.toString());
	            }
	     
	            // Convertion de la requête en string
	            try{
	                BufferedReader reader = new BufferedReader(new InputStreamReader(is,"iso-8859-1"),8);
	                StringBuilder sb = new StringBuilder();
	                String line = null;
	                while ((line = reader.readLine()) != null) {
	                    sb.append(line + "\n");
	                }
	                is.close();
	                result=sb.toString();
	            }catch(Exception e){
	                Log.e("log_tag", "Error converting result " + e.toString());
	            }
	            // Parse les données JSON
	            try{
	                JSONArray jArray = new JSONArray(result);
	                for(int i=0;i<jArray.length();i++){
	                    JSONObject json_data = jArray.getJSONObject(i);
	                    // Affichage ID_ville et Nom_ville dans le LogCat
	                    Log.i("log_tag","idUtilisateur: "+json_data.getInt("idFicheExercice")+
	                            ", Nom_utilisateur: "+json_data.getString("titre")
	                    );
	                    // Résultats de la requête
	                    returnString += "\n\t" + jArray.getJSONObject(i);
	                }
	            }catch(JSONException e){
	                Log.e("log_tag", "Error parsing data " + e);
	                returnString = null;
	            }
	            return returnString;
	    	
	    	}
	    	
	    	@Override
	    	protected void onPostExecute(String result) {
	    		if(result == null) {
	    			txt.setText("Pas d'exercices");
	    		} else {
	    			txt.setText(result);
	    		}
	    	}
	}
}