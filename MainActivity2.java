package com.example.evaluation2;


import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity2 extends AppCompatActivity {

    private EditText in_piece;
    private Button btn_ajout_piece;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        in_piece= findViewById(R.id.inPiece);
        btn_ajout_piece= findViewById(R.id.btnAjoutPiece);

        btn_ajout_piece.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent= new Intent(MainActivity2.this, MainActivity.class); //création d'un objet de la classe intent
                intent.putExtra("Newpiece",in_piece.getText().toString()); //associer l'intent : clé(déclarer en haut) / valeur comme en python cf(dictionnaire)
                setResult(RESULT_OK, intent); //présiser à android que l'activité c'est bien terminé
                finish(); //finir l'activité
            }
        });
    }

}
