package com.example.tp_app_mob;

import androidx.appcompat.app.AppCompatActivity;


import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.io.Serializable;
import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
RadioGroup radG;
RadioButton radB;
EditText date, prenom, nom, num;
CheckBox fav;
Button send;

String s_gender, s_nom, s_date, s_prenom, s_num;
boolean b_fav;

DatePickerDialog.OnDateSetListener setListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radG = findViewById(R.id.radioGender);
        send = findViewById(R.id.send);
        date = findViewById(R.id.textDate);
        prenom = findViewById(R.id.editTextTextPersonName);
        nom = findViewById(R.id.textNom);
        num = findViewById(R.id.editTextPhone);
        fav = findViewById(R.id.checkBox);

        Calendar calendar = Calendar.getInstance();
        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);

        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        MainActivity.this, android.R.style.Theme_Holo_Dialog_MinWidth, setListener, year, month, day);
                datePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                datePickerDialog.show();
            }
        });

        setListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month = month+1;
                String daate = day+"/"+month+"/"+year;
                date.setText(daate);
            }
        };



    send.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String regex = "^\\d{10}$";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(num.getText().toString());

            if(radG.getCheckedRadioButtonId() == -1 || prenom.getText().toString().matches("") || nom.getText().toString().matches("")){
                Toast.makeText(getApplicationContext(), "Veuillez au moins renseigner le nom, le prénom et le genre", Toast.LENGTH_SHORT).show();
            }
            else if (!num.getText().toString().matches("") && !matcher.matches()){
                Toast.makeText(getApplicationContext(), "Numéro invalide", Toast.LENGTH_SHORT).show();
            }
            else{
            int selectedGender = radG.getCheckedRadioButtonId();
            radB =  findViewById(selectedGender);
            s_gender = radB.getText().toString();
            s_date = date.getText().toString();
            s_prenom = prenom.getText().toString();
            s_nom = nom.getText().toString();
            s_num = num.getText().toString();
            b_fav = fav.isChecked();

            ContactFile newcontact = new ContactFile(s_nom, s_prenom, s_gender, s_date, s_num, b_fav);


            Intent intent = new Intent();
            intent.putExtra("ContactFile", (Serializable) newcontact);
            setResult(Activity.RESULT_OK, intent);

            finish();
            }









        }
    });




    }


}