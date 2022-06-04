package com.example.evaluation2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity3 extends AppCompatActivity {


    private EditText inHygro;
    private Button btn_valider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        inHygro= findViewById(R.id.inHygrometrie);
        btn_valider= findViewById(R.id.valider3);

        btn_valider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(MainActivity3.this, MainActivity.class); //création d'un objet de la classe intent
                intent.putExtra("Hygrometrie",Double.parseDouble(inHygro.getText().toString())); //associer l'intent : clé(déclarer en haut) / valeur comme en python cf(dictionnaire)
                setResult(RESULT_OK, intent); //présiser à android que l'activité c'est bien terminé
                finish();
            }
        });
    }
}