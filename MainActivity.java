package com.example.evaluation2;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private int indice_item;
    private List<String> piece = new ArrayList<String>();
    private List<Double> listehygro = new ArrayList<Double>();
    private Spinner spinnerPiece;
    private Button btn_ajouter, btn_setting;
    private TextView tvConsigne;


    private int flag;

    ActivityResultLauncher<Intent> activityLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if(result.getResultCode()== Activity.RESULT_OK){
                        switch (flag){
                            case 1 : piece.add(result.getData().getStringExtra("Newpiece")); break;
                            case 2: listehygro.add(result.getData().getDoubleExtra("Hygrometrie",0)); break;
                        }
                    }
                }
            }
    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinnerPiece=findViewById(R.id.spinner1);
        btn_ajouter=findViewById(R.id.btn_ajouter);
        btn_setting=findViewById(R.id.def_para);
        tvConsigne=findViewById(R.id.txtconsigne);

        piece.add("Séjour");
        piece.add("Salle de bain");
        listehygro.add(45.0);
        listehygro.add(55.0);

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item,piece);
        this.spinnerPiece.setAdapter(adapter);

        spinnerPiece.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                indice_item=position;
                if (listehygro.size()>indice_item)
                {
                    tvConsigne.setText(listehygro.get(indice_item).toString()+ "%");
                }
                else {
                    listehygro.add(50.0);
                    tvConsigne.setText(listehygro.get(indice_item).toString()+" %");
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        btn_ajouter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flag=1;
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                activityLauncher.launch(intent);
            }
        });

        btn_setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flag = 2;
                Intent intent = new Intent(MainActivity.this, MainActivity3.class);
                activityLauncher.launch(intent);
            }
        });
    }
}