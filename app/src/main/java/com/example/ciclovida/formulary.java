package com.example.ciclovida;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.Calendar;

public class formulary extends AppCompatActivity {

    EditText tNombre;
    EditText tTelefono;
    EditText tFecha;
    RadioButton mMujer, hHombre;
    CheckBox color1, color2, color3, color4, color5;
    boolean  c1,c2,c3,c4,c5;

    //calendario
    private static  final  String CERO = "0";
    private static  final  String BARRA = "/";
    public final Calendar c= Calendar.getInstance();
    final  int mes = c.get(Calendar.MONTH);
    final  int dia = c.get(Calendar.DAY_OF_MONTH);
    final  int anio = c.get(Calendar.YEAR);

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulary);

        tNombre = findViewById(R.id.etxtNombre);
        tTelefono = findViewById(R.id.etxtTelefono);
        tFecha = findViewById(R.id.etxtCumple);
        mMujer = findViewById(R.id.rbMujer);
        hHombre = findViewById(R.id.rbHombre);
        color1 = findViewById(R.id.chbkRojo);
        color2 = findViewById(R.id.chkbVerde);
        color3= findViewById(R.id.chkbAmarillo);
        color4=findViewById(R.id.chkbMorado);
        color5 = findViewById(R.id.chkbAzul);

       tFecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              obtenerFecha();
             }
        });

        tFecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                obtenerFecha();
            }
        });

        Button btnMuestra;
        Button btnLimpiar;

        btnMuestra = findViewById(R.id.btnMostrar);
        btnMuestra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), Datos.class);
                //asignar  informacion al intent
                intent.putExtra( "nombre", tNombre.getText().toString());
                intent.putExtra( "telefono", tTelefono.getText().toString());
                intent.putExtra("fecha", tFecha.getText().toString());
                intent.putExtra( "sexo",getGenero());
                intent.putExtra( "colores",getColores());

                startActivity(intent);
            }
        });

        btnLimpiar = findViewById(R.id.btnLimpiar);
        btnLimpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText( formulary.this,  "limpiando datos",Toast.LENGTH_LONG).show();
                finish();
            }
        });
    }

    private String getColores(){
        c1 = color1.isChecked();
        c2 = color2.isChecked();
        c3 = color3.isChecked();
        c4 = color4.isChecked();
        c5 = color5.isChecked();

        String colores ="";

        if (c1) {colores= colores + "Rojo ,";}
        if (c2) {colores= colores + "Verde ,";}
        if (c3) {colores= colores + "Amarillo ,";}
        if (c4) {colores= colores + "Morado ,";}
        if (c5) {colores= colores + "Azul ,";}

        return colores;
    }
    private String getGenero(){
        if (mMujer.isChecked()){
            return "Femenino";
        }
        else {
            return "Masculino";
        }
    }
    private void obtenerFecha(){
        DatePickerDialog recogerfecha = new DatePickerDialog( this, new  DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                final int mesActual = month + 1;
                String diaFormateado = (dayOfMonth < 10) ? CERO + String.valueOf(dayOfMonth) : String.valueOf(dayOfMonth);
                String mesFormateado = (mesActual < 10) ? CERO + String.valueOf(mesActual) : String.valueOf(mesActual);
                tFecha.setText(diaFormateado + BARRA + mesFormateado + BARRA + year);
            }
        }, anio, mes, dia);
            recogerfecha.show();
    }


}