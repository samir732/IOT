package com.example.sadaurin.iot;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;


public class ListAvkImage extends Activity {
    ListView listView;
    HashMap<Integer,String> listeSalleCle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listavkimage);

        listView = (ListView) findViewById(R.id.listView1);

        String[] listeValeurs = new String[] { "210 A ", "210B",
                };

        int[] ages = { 30, 27 };
        int[] images = { R.drawable.vert, R.drawable.vert,
               };

        ArrayList<ListItem> myList = new ArrayList<ListItem>();

        for (int i = 0; i < listeValeurs.length; i++) {
           // myList.add(new ListItem(listeValeurs[i], ages[i], images[i]));
             myList.add(new ListItem(listeValeurs[i],  images[i]));
        }

        CustomAdapter adapter = new CustomAdapter(this, myList);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if(position==0){
                  //  Intent mp2 = new Intent(ListAvkImage.this,MainActivity.class);
                  //  startActivity(mp2);
                    Intent mp2 = new Intent(ListAvkImage.this,DetailSalle.class);
                    startActivity(mp2);



                }else{
                    Toast toast = Toast.makeText(getBaseContext(), "Item "+position+"Viexw para"+parent.toString() , Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });



    }

}
