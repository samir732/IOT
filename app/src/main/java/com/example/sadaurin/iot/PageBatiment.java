package com.example.sadaurin.iot;

import android.app.ActionBar;
import android.app.Activity;
import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.graphics.pdf.PdfDocument;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class PageBatiment extends Activity {
    ListView mListeView;
    ArrayAdapter<String> adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_batiment_avec_image);

        mListeView = (ListView) findViewById(R.id.listView1bat);
        final String[] values1 = new String[] {
                "Batiment A", "Batiment B", "Batiment C", "Batiment D",
                "Batiment E",
                "Batiment F",
                "Batiment G",
                "Batiment H"};

        int[] images = {R.drawable.bbb,R.drawable.bbb,R.drawable.bbb,R.drawable.bbb,R.drawable.bbb,R.drawable.bbb,R.drawable.aaa,R.drawable.bbb,
        };
        final ArrayList<ListItem> myList = new ArrayList<ListItem>();

        for (int i = 0; i < values1.length; i++) {
            myList.add(new ListItem(values1[i],  images[i]));
        }


        CustomAdapter adapter = new CustomAdapter(this, myList);
        mListeView.setAdapter(adapter);
        mListeView.setOnItemClickListener(adapter);




        mListeView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String itemSelected = values1[position];
                Toast t = Toast.makeText(PageBatiment.this, itemSelected, Toast.LENGTH_SHORT);




                if (itemSelected == "Batiment G") {
                    Intent mp1 = new Intent(PageBatiment.this, ListAvkImage.class);
                    mp1.putExtra("Bat", itemSelected);
                    startActivity(mp1);
                } else {
                    Context context = getApplicationContext();
                    CharSequence text = "Batiment non traité pour le moment";
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }
            }
        });


    }







}
