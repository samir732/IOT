package com.example.sadaurin.iot;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by sadaurin on 31/03/2017.
 */

public class CustomAdapter extends BaseAdapter implements AdapterView.OnItemClickListener {

    ArrayList<ListItem> myList = new ArrayList<ListItem>();
    Context context;

    // on passe le context afin d'obtenir un LayoutInflater pour utiliser notre
    // row_layout.xml
    // on passe les valeurs de notre à l'adapter
    public CustomAdapter(Context context, ArrayList<ListItem> myList) {
        this.myList = myList;
        this.context = context;
    }

    // retourne le nombre d'objet présent dans notre liste
    @Override
    public int getCount() {
        return myList.size();
    }

    // retourne un élément de notre liste en fonction de sa position
    @Override
    public ListItem getItem(int position) {
        return myList.get(position);
    }

    // retourne l'id d'un élément de notre liste en fonction de sa position
    @Override
    public long getItemId(int position) {
        return myList.indexOf(getItem(position));
    }

    // retourne la vue d'un élément de la liste
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MyViewHolder mViewHolder = null;

        // au premier appel ConvertView est null, on inflate notre layout
        if (convertView == null) {
            LayoutInflater mInflater = (LayoutInflater) context
                    .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);

            convertView = mInflater.inflate(R.layout.row_list, parent, false);

            // nous plaçons dans notre MyViewHolder les vues de notre layout
            mViewHolder = new MyViewHolder();
            mViewHolder.textViewName = (TextView) convertView
                    .findViewById(R.id.textViewName);
            mViewHolder.textViewAge = (TextView) convertView
                    .findViewById(R.id.textViewName);
            mViewHolder.imageView = (ImageView) convertView
                    .findViewById(R.id.imageView);

            // nous attribuons comme tag notre MyViewHolder à convertView
            convertView.setTag(mViewHolder);
        } else {
            // convertView n'est pas null, nous récupérons notre objet MyViewHolder
            // et évitons ainsi de devoir retrouver les vues à chaque appel de getView
            mViewHolder = (MyViewHolder) convertView.getTag();
        }

        // nous récupérons l'item de la liste demandé par getView
        ListItem listItem = (ListItem) getItem(position);

        // nous pouvons attribuer à nos vues les valeurs de l'élément de la liste
        mViewHolder.textViewName.setText(listItem.getName());
        mViewHolder.textViewAge.setText(String.valueOf(listItem.getName())
                + " ");
        mViewHolder.imageView.setImageResource(listItem.getImageId());

        // nous retournos la vue de l'item demandé
        return convertView;
    }

    // MyViewHolder va nous permettre de ne pas devoir rechercher
    // les vues à chaque appel de getView, nous gagnons ainsi en performance
    private class MyViewHolder {
        TextView textViewName, textViewAge;
        ImageView imageView;
    }

    // nous affichons un Toast à chaque clic sur un item de la liste
    // nous récupérons l'objet grâce à sa position
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position,
                            long id) {

        Toast toast = Toast.makeText(context, "Item " + (position + 1) + ": "
                + this.myList.get(position), Toast.LENGTH_SHORT);
        toast.show();





    }

}
