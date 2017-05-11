package com.example.sadaurin.iot;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by sadaurin on 05/04/2017.
 */

public class HttpHandler {

    public  String reponseStocker;
    private static final String TAG = HttpHandler.class.getSimpleName();

    public HttpHandler(String url, Context context) {

        // lancementWebSerivice(url,context);

    }
    public HttpHandler() {
    }


    public  void lancementWebSerivice (String url, Context context){
        RequestQueue queue = Volley.newRequestQueue(context);
// Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.
                        Log.v("salut 2",response.substring(5));

                        //  reponseStocker=response;
                        sabirMethode(response);

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.v("salut","didn't work");
            }
        });
// Add the request to the RequestQueue.
        queue.add(stringRequest);
    }

    public void sabirMethode(String reponse)  {

        ArrayList<ReponseWebServiceJSon> personnes = new ArrayList<ReponseWebServiceJSon>();

// On récupère le JSON complet


        JSONObject jsonObject = null;
        try {
            jsonObject = new JSONObject(reponse);

        } catch (JSONException e) {
            e.printStackTrace();
        }
        // On récupère le tableau d'objets qui nous concernent
        JSONArray array = null;
        try {
            array = new JSONArray(jsonObject.getString("items"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        // Pour tous les objets on récupère les infos
        for (int i = 0; i < array.length(); i++) {
            // On récupère un objet JSON du tableau
            JSONObject obj = null;
            try {
                obj = new JSONObject(array.getString(i));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            // On fait le lien Personne - Objet JSON
            ReponseWebServiceJSon personne = new ReponseWebServiceJSon();
            try {
                personne.setKing(obj.getString("kind"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            try {
                personne.setId(obj.getString("id"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            // On ajoute la personne à la liste
            personnes.add(personne);
            for (int j =0;j<personnes.size();j++){
                Log.v("BACHIR",personnes.get(i).getId());
            }




        }



    }
}
