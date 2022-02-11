package com.example.a01_introduccion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button botonInicial;
    private TextView textoInicial;
    private EditText editNombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // logica : this
        // grafica : otro


        setContentView(R.layout.activity_main);
        // logico + grafico
        botonInicial = findViewById(R.id.boton_inicial);
        textoInicial = findViewById(R.id.texto_inicial);
        editNombre = findViewById(R.id.edit_texto);
        //textoInicial.setText("Ejemplo de texto cambiado");

        botonInicial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String dato =editNombre.getText().toString();
                if (dato.length()==0){
                    Toast.makeText(getApplicationContext(),
                            "Faltan datos", Toast.LENGTH_SHORT).show();
                } else {
                    textoInicial.setText("Muy bien "+dato);
                }

            }
        });




    }
}