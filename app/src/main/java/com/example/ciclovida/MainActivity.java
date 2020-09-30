package com.example.ciclovida;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    //    Toast.makeText( MainActivity.this,  "onCreate",Toast.LENGTH_LONG).show();
        Button btnAcceso;
        Button btnSalir;

        btnAcceso = findViewById(R.id.btningreso);
        btnAcceso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), formulary.class);
                 startActivity(intent);
            }
        });
        btnSalir = findViewById(R.id.btnatras);
        btnSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText( MainActivity.this,  "Saliendo de la aplicacion",Toast.LENGTH_LONG).show();
                finish();
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
      //  Toast.makeText( MainActivity.this,  "onStart", Toast.LENGTH_SHORT).show();
        //para  la  actividad que pronto sera visible
    }

    @Override
    protected void onResume() {
        super.onResume();
      //  Toast.makeText( MainActivity.this,  "onResume", Toast.LENGTH_SHORT).show();
        //para  la  actividad que se  va  a segundo  plano
    }
    @Override
    protected void onPause() {
        super.onPause();
       //  Toast.makeText( MainActivity.this,  "onPause", Toast.LENGTH_SHORT).show();
        //para  la  actividad que se va  segundo  plano
    }
    @Override
    protected void onStop() {
        super.onStop();
       //  Toast.makeText( MainActivity.this,  "onStop", Toast.LENGTH_SHORT).show();
        //para  la  actividad se  detenga
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
      //  Toast.makeText( MainActivity.this,  "onDestroy", Toast.LENGTH_SHORT).show();
        //para  la  actividad que pronto sera visible
    }
}





