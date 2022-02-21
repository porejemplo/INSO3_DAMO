package com.example.a01_introduccion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button botonInicial;
    private TextView textoInicial;
    private EditText editNombre;
    private Button botonSuma, botonResta, botonMulti, botonDiv, botonResultado;
    private EditText editOperandoUno, editOperandoDos;
    private TextView textoResultado;
    private int tipoOperacion, operandoUno, operandoDos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // logica : this
        // grafica : otro


        setContentView(R.layout.activity_main);
        // logico + grafico
        instancias();
        acciones();




    }

    private void acciones() {
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
        botonSuma.setOnClickListener(this);
        botonResta.setOnClickListener(this);
        botonDiv.setOnClickListener(this);
        botonMulti.setOnClickListener(this);
        botonResultado.setOnClickListener(this);

    }

    public void instancias(){
        botonInicial = findViewById(R.id.boton_inicial);
        textoInicial = findViewById(R.id.texto_inicial);
        editNombre = findViewById(R.id.edit_texto);
        //textoInicial.setText("Ejemplo de texto cambiado");
        botonSuma = findViewById(R.id.boton_suma);
        botonResta = findViewById(R.id.boton_resta);
        botonMulti = findViewById(R.id.boton_mult);
        botonDiv = findViewById(R.id.boton_div);
        textoResultado = findViewById(R.id.resultado);
        botonResultado = findViewById(R.id.boton_resultado);
        editOperandoUno = findViewById(R.id.operador_uno);
        editOperandoDos = findViewById(R.id.operador_dos);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.boton_suma:

                tipoOperacion =0;
                break;
            case R.id.boton_resta:
                tipoOperacion = 1;
                break;
            case R.id.boton_resultado:
                operandoUno = Integer.parseInt(editOperandoUno.getText().toString());
                operandoDos = Integer.parseInt(editOperandoDos.getText().toString());
                int resultado=0;
                switch (tipoOperacion){
                    case 0:
                        resultado = operandoUno+operandoDos;
                        break;
                    case 1:
                        resultado = operandoUno-operandoDos;
                        break;
                }
                textoResultado.setText(String.valueOf(resultado));
                break;
        }
    }
}