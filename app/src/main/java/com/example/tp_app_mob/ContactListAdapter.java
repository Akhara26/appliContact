package com.example.tp_app_mob;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class ContactListAdapter extends ArrayAdapter<ContactFile> {
    public ContactListAdapter( Context context, ArrayList<ContactFile> objects) {
        super(context, 0, objects);
    }

    @Override
    public View getView(int position,  View convertView,  ViewGroup parent) {
        ContactFile contact = getItem(position);
        if (convertView == null) {

            convertView = LayoutInflater.from(getContext()).inflate(R.layout.adapter_view_layout, parent, false);
        }
            TextView prenom = (TextView) convertView.findViewById(R.id.prenomlist);
            TextView nom = (TextView) convertView.findViewById(R.id.nomlist);

            prenom.setText(contact.name);
            nom.setText(contact.lastname);

            return convertView;




    }



}
