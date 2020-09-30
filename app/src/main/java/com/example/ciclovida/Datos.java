package com.example.ciclovida;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Datos extends AppCompatActivity {

    TextView tNombre;
    TextView tTelefono;
    TextView tEdad;
    TextView tSexo;
    TextView tColor;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos);

        Bundle extras = getIntent().getExtras();

        tNombre = findViewById(R.id.tVNombre);
        tNombre.setText("Nombre " + extras.getString("nombre"));

        tTelefono = findViewById(R.id.tVTelefono);
        tTelefono.setText("Telefono" +extras.getString("telefono"));

        tEdad = findViewById(R.id.tVEdad);
        tEdad.setText("Tiene "+getEdad(extras.getString("fecha")) + " años");

        tSexo= findViewById(R.id.tVSexo);
        tSexo.setText("Sexo:" + extras.getString("sexo"));

        tColor = findViewById(R.id.tVColor);
        tColor.setText(extras.getString("colores"));



        Button btnSalir;
        Button btnRegresar;

        btnSalir = findViewById(R.id.btnExit);
        btnSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Datos.this,"Saliendo de la Aplicación",Toast.LENGTH_LONG).show();
                Salida(v);

            }
        });

        btnRegresar = findViewById(R.id.btnRegresar);
        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),formulary.class);
                startActivity(intent);
            }
        });

    }


    @SuppressLint("NewApi")
    public void Salida(View v) {
        finishAffinity();
    }



    public int getEdad(String fecha){
        String [] fecha_nacimiento= fecha.toString().split("/");
        int dia=Integer.parseInt(fecha_nacimiento[0]);
        int mes=Integer.parseInt(fecha_nacimiento[1]);
        int año=Integer.parseInt(fecha_nacimiento[2]);
        Calendar edad_1 = new GregorianCalendar(año,mes,dia);
        Calendar hoy = Calendar.getInstance();
        return hoy.get(Calendar.YEAR)-edad_1.get(Calendar.YEAR);
    }



}