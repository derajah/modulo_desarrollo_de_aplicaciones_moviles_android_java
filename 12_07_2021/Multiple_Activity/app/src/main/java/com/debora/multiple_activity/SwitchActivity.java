package com.debora.multiple_activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class SwitchActivity extends AppCompatActivity {

    private TextView tvr;
    private EditText ed1, ed2;
    private Switch sw1, sw2, sw3, sw4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_switch);

        ed1 = findViewById(R.id.edit1);
        ed2 = findViewById(R.id.edit2);
        tvr = findViewById(R.id.tvResultado);
        sw1 = findViewById(R.id.sw1);
        sw2 = findViewById(R.id.sw2);
        sw3 = findViewById(R.id.sw3);
        sw4 = findViewById(R.id.sw4);

        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.TITULO);
        TextView tvt = findViewById(R.id.tvTitulo);
        tvt.setText(message);
    }

    public void Operar(View v){

        if("".equals(ed1.getText().toString()) || "".equals(ed2.getText().toString())){
            Toast.makeText(this,"Debe definir valores", Toast.LENGTH_LONG).show();
        } else {

            if(sw1.isChecked()){
                sumar();
            } else if (sw2.isChecked()){
                restar();
            } else if (sw3.isChecked()){
                multiplicar();
            } else if (sw4.isChecked()){
                dividir();
            }

        }
    }

    public void Volver(View v){
        Intent volver = new Intent(this, MainActivity.class);
        startActivity(volver);
    }

    private void sumar(){

        int valor1 = Integer.parseInt(ed1.getText().toString());
        int valor2 = Integer.parseInt(ed2.getText().toString());

        int suma = valor1 + valor2;
        tvr.setText("El resultado de la suma: " + suma);
    }

    private void restar(){

        int valor1 = Integer.parseInt(ed1.getText().toString());
        int valor2 = Integer.parseInt(ed2.getText().toString());
        int resta = valor1 - valor2;
        tvr.setText("El resultado de la resta: " + resta);
    }

    private void multiplicar(){

        int valor1 = Integer.parseInt(ed1.getText().toString());
        int valor2 = Integer.parseInt(ed2.getText().toString());
        int mult = valor1 * valor2;
        tvr.setText("La multiplicación es: " + mult);
    }

    private void dividir(){

        float valor1 = Float.parseFloat(ed1.getText().toString());
        float valor2 = Float.parseFloat(ed2.getText().toString());
        if (valor2 == 0) {
            Toast.makeText(this, "El segundo valor no puede ser 0", Toast.LENGTH_LONG).show();
        } else {
            float div = valor1 / valor2;
            tvr.setText("La division es: " + div);
        }

    }
}