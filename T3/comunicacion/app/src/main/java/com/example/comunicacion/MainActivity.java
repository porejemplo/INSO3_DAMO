package com.example.comunicacion;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.widget.Chronometer;

public class MainActivity extends AppCompatActivity {

    Chronometer cronometro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.v("ciclo_vida","Ejecutado OnCreate");
        cronometro = findViewById(R.id.cronometro);
        cronometro.start();
        Log.v("cronometro", String.valueOf(SystemClock.elapsedRealtime()));

        if (savedInstanceState != null){
            String nombre = savedInstanceState.getString("nombre");
            Log.v("test_datos", nombre);
        }

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.v("cronometro", String.valueOf(cronometro.getBase()));
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("nombre","elemento guardado en estado");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.v("ciclo_vida","Ejecutado OnStart");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.v("ciclo_vida","Ejecutado OnRestart");

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.v("ciclo_vida","Ejecutado OnResume");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.v("ciclo_vida","Ejecutado OnStop");


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.v("ciclo_vida","Ejecutado OnDestroy");

    }
}