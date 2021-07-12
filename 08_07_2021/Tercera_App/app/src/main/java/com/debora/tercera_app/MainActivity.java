package com.debora.tercera_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView tvr;
    private EditText ed1, ed2;
    private CheckBox ck1, ck2, ck3, ck4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed1 = findViewById(R.id.edit1);
        ed2 = findViewById(R.id.edit2);
        tvr = findViewById(R.id.tvResultado);
        ck1 = findViewById(R.id.ck1);
        ck2 = findViewById(R.id.ck2);
        ck3 = findViewById(R.id.ck3);
        ck4 = findViewById(R.id.ck4);

    }

    public void Operar(View v){

        if("".equals(ed1.getText().toString()) || "".equals(ed2.getText().toString())){
            Toast.makeText(this,"Debe definir valores", Toast.LENGTH_LONG).show();
        } else {

            if(ck1.isChecked()){
                sumar();
            } else if (ck2.isChecked()){
                restar();
            } else if (ck3.isChecked()){
                multiplicar();
            } else if (ck4.isChecked()) {
                dividir();
            }

        }
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

        float valor1 = Float.valueOf(ed1.getText().toString());
        float valor2 = Float.valueOf(ed2.getText().toString());
        if (valor2 == 0) {
            Toast.makeText(this, "El segundo valor no puede ser 0", Toast.LENGTH_LONG).show();
        } else {
            float div = valor1 / valor2;
            tvr.setText("La division es: " + div);
        }

    }
}