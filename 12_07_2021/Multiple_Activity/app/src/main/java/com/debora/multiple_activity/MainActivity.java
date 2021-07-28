package com.debora.multiple_activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    public static final String TITULO = "titulo";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void RadioB(View v){
        Intent siguiente = new Intent(this, RadioButtonActivity.class);
        siguiente.putExtra(TITULO,"Operacion con RadioButton");
        startActivity(siguiente);
    }

    public void CheckB(View v){
        Intent siguiente = new Intent(this, CheckBoxActivity.class);
        siguiente.putExtra(TITULO,"Operacion con CheckBox");
        startActivity(siguiente);
    }

    public void SwitchB(View v){
        Intent siguiente = new Intent(this, SwitchActivity.class);
        siguiente.putExtra(TITULO,"Operacion con Switch");
        startActivity(siguiente);
    }

    public void SpinnerB(View v){
        Intent siguiente = new Intent(this, SpinnerActivity.class);
        siguiente.putExtra(TITULO,"Operacion con Spinner");
        startActivity(siguiente);
    }
}