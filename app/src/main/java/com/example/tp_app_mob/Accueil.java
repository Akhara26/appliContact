package com.example.tp_app_mob;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class Accueil extends AppCompatActivity {
    Button button2;
    ListView listView;
    ContactListAdapter adapter;
    private ArrayList<ContactFile> contacts;


    ActivityResultLauncher<Intent> activityLauncher  = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                if (result.getResultCode() == Activity.RESULT_OK){
                    Intent data = result.getData();
                    if (data != null){
                        ContactFile newContactFile = (ContactFile) data.getExtras().getSerializable("ContactFile");
                        contacts.add(newContactFile);

                        PrefConfig.writeListInPref(getApplicationContext(), contacts);
                    }
                }

            }
    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accueil);

        contacts = (ArrayList<ContactFile>) PrefConfig.readListFromPref(this);
        if(contacts == null){
            contacts = new ArrayList<>();

        }

        button2 = findViewById(R.id.buttoncreate);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(Accueil.this, MainActivity.class);
                activityLauncher.launch(intent1);
            }
        });


}

    @Override
    protected void onResume() {
        super.onResume();

        adapter = new ContactListAdapter(this , contacts);
        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long id) {
                Toast.makeText(Accueil.this, "Contact supprimé", Toast.LENGTH_SHORT).show();
                removeItem(position);
                return false;
            }

        });
    }

    public void removeItem(int remove){
        contacts.remove(remove);
        adapter.notifyDataSetChanged();
        PrefConfig.writeListInPref(getApplicationContext(), contacts);


    }
}

