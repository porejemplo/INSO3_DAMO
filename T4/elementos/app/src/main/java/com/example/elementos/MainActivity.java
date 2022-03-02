package com.example.elementos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.ToggleButton;

import com.example.elementos.utils.Persona;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener
        , RadioGroup.OnCheckedChangeListener, AdapterView.OnItemSelectedListener {

    private ToggleButton toggleButton;
    private Switch aSwitch;
    private CheckBox checkBox;
    private RadioGroup grupoRadios;
    private Spinner spinner;
    private ArrayList listaProductos;
    private ArrayAdapter adapterSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toggleButton = findViewById(R.id.toggle_button);
        checkBox = findViewById(R.id.check);
        aSwitch = findViewById(R.id.switch_elemento);
        grupoRadios = findViewById(R.id.grupo_radios);
        spinner = findViewById(R.id.spinner);
        listaProductos = new ArrayList<>();
        adapterSpinner = new ArrayAdapter(getApplicationContext(),
                android.R.layout.simple_spinner_item, listaProductos);
        listaProductos.add(new Persona("Borja","Martin"));
        listaProductos.add(new Persona("Borja","Martin"));
        listaProductos.add(new Persona("Borja","Martin"));
        listaProductos.add(new Persona("Borja","Martin"));
        listaProductos.add(new Persona("Borja","Martin"));
        listaProductos.add("Cerveza");
        listaProductos.add("CocaCola");
        adapterSpinner.notifyDataSetChanged();

        spinner.setAdapter(adapterSpinner);

        listaProductos.add("Zumo");
        listaProductos.add("Leche");
        adapterSpinner.notifyDataSetChanged();

        /*toggleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.v("elementos", String.valueOf(toggleButton.isChecked()));
            }
        });*/
        toggleButton.setOnCheckedChangeListener(this);
        aSwitch.setOnCheckedChangeListener(this);
        checkBox.setOnCheckedChangeListener(this);
        grupoRadios.setOnCheckedChangeListener(this);
        spinner.setOnItemSelectedListener(this);

    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        switch (compoundButton.getId()){
            case R.id.toggle_button:
                checkBox.setEnabled(b);
                aSwitch.setEnabled(b);

                checkBox.setChecked(b);
                aSwitch.setChecked(b);

                RadioButton radio = findViewById(grupoRadios.getCheckedRadioButtonId());
                // sacar lo seleccionado spinner
                //Log.v("elementos",adapterSpinner.getItem(spinner.getSelectedItemPosition()).toString());

                break;
            case R.id.switch_elemento:
                break;
            case R.id.check:
                Log.v("elemento","Estado pasado a "+String.valueOf(b));
                break;
        }
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        //RadioButton radioSelect = findViewById(i);
        //Log.v("elementos",radioSelect.getText().toString());
        switch (i){
            case R.id.radio1:
                break;
            case R.id.radio2:
                break;
            case R.id.radio3:
                break;
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        Log.v("elementos", spinner.getSelectedItem().toString());
        //Log.v("elementos", (String) adapterSpinner.getItem(spinner.getSelectedItemPosition()));

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}