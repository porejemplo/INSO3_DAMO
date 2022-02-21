package com.example.comunicacion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button botonArrancar, botonArrancarDatos, botonMapa, botonCorreo, botonTelefono;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        botonArrancar = findViewById(R.id.boton_arrancar);
        botonArrancarDatos = findViewById(R.id.boton_arrancar_datos);
        botonCorreo = findViewById(R.id.boton_arrancar_correo);
        botonMapa = findViewById(R.id.boton_arrancar_mapa);
        botonTelefono = findViewById(R.id.boton_arrancar_telefono);


        botonArrancar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext()
                        ,SecondActivity.class);
                startActivity(intent);
                finish();
            }
        });
        botonArrancarDatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),
                        SecondActivity.class);
                i.putExtra("nombre","Borja");
                i.putExtra("apellido","Martin");
                i.putExtra("edad",18);
                startActivity(i);
            }
        });

        botonCorreo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                Intent chooser = Intent.createChooser(intent,"Selecciona algo");
                startActivity(chooser);
            }
        });

        botonTelefono.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("tel:612633633"));
            }
        });

        botonMapa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("geo:33.34513,-0.74551"));
                startActivity(intent);
            }
        });
    }
}