package com.example.comunicacion;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private TextView textoNombre, textoApellido, textoEdad;
    private String nombre, apellido;
    private int edad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        textoEdad = findViewById(R.id.texto_edad);
        textoNombre = findViewById(R.id.texto_nombre);
        textoApellido = findViewById(R.id.texto_apellido);



        if (getIntent().getExtras() != null){
            nombre = getIntent().getStringExtra("nombre");
            apellido = getIntent().getStringExtra("apellido");
            edad = getIntent().getIntExtra("edad",0);
        } else {
            nombre = "sin argumentos";
            apellido = "sin argumentos";
        }
        setearDatos();


    }

    private void setearDatos(){
        textoNombre.setText(nombre);
        textoApellido.setText(apellido);
        textoEdad.setText(String.valueOf(edad));
    }

}