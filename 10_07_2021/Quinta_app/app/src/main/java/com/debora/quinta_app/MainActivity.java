package com.debora.quinta_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText ed1, ed2;
    private TextView tvr;
    private Spinner sp1;
    private String[] op={"Seleccione Operacion", "Sumar", "Restar", "Multiplicar", "Dividir"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed1 = findViewById(R.id.edit1);
        ed2 = findViewById(R.id.edit2);
        tvr = findViewById(R.id.tvResultado);
        sp1 = findViewById(R.id.spinner);

        ArrayAdapter<String> aD = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, op);
        sp1.setAdapter(aD);
    }

    public void Operar(View v){

        String operacion = sp1.getSelectedItem().toString();
        switch (operacion) {
            case "Sumar":
                    sumar();
                    break;
            case "Restar":
                    restar();
                    break;
            case "Multiplicar":
                    multiplicar();
                    break;
            case "Dividir":
                    dividir();
                    break;
            default:
                Toast.makeText(this, "Seleccione una operacion", Toast.LENGTH_LONG).show();
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