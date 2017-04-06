package com.example.sadaurin.iot;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.Toast;

public class DetailSalle extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_salle);

        final CheckBox checkBox = (CheckBox) findViewById(R.id.checkBox);
        checkBox.setChecked(false);

        if (checkBox.isChecked()) {
            CharSequence text = "Ajouter ce batiment au favories ";


            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(getBaseContext(), text, duration);
            toast.show();
           // checkBox.setChecked(false);
        }

    }
}
