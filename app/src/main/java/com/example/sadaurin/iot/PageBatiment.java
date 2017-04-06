package com.example.sadaurin.iot;

import android.app.ActionBar;
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

public class PageBatiment extends ActionBarActivity {
    ArrayAdapter<String> adapter;

    ListView mListeView;

    String[] values1 = {
            "Batiment A", "Batiment B", "Batiment C", "Batiment D",
            "Batiment E"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_batiment);


        mListeView = (ListView) findViewById(R.id.lst);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(PageBatiment.this,android.R.layout.simple_expandable_list_item_1,values1);
        mListeView.setAdapter(adapter);

        mListeView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if(position==0){
                    Intent mp2 = new Intent(PageBatiment.this,ListeAvecImage.class);
                    startActivity(mp2);
                } else if (position==1){

                    Intent mp1 = new Intent(PageBatiment.this,ListAvkImage.class);
                    startActivity(mp1);
                }


                else {
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
