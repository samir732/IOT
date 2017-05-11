package com.example.sadaurin.iot;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
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

        Intent intent = getIntent();
        final String bat = intent.getStringExtra("Bat");


        listView = (ListView) findViewById(R.id.listView1);
        final String[] listeValeurs = new String[] { "208a",
                "208b",
                "209",
                "210a",
                "210b",
                "212",
                "213a",
                "213b",
                "213c",
        };
        // int[] ages = { 30, 27 };
        int[] images = {R.drawable.bbb,R.drawable.bbb,R.drawable.bbb,R.drawable.aaa,R.drawable.bbb,R.drawable.bbb,R.drawable.bbb,R.drawable.bbb,R.drawable.bbb,
        };

        final ArrayList<ListItem> myList = new ArrayList<ListItem>();

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
                String itemSelected = listeValeurs[position];
                Intent mp2 = new Intent(ListAvkImage.this, DetailSalle.class);
                mp2.putExtra("salle", itemSelected);
                mp2.putExtra("bat",bat);
                startActivity(mp2);


            }
        });



    }

}
