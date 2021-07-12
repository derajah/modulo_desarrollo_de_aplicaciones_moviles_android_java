package com.debora.segunda_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private TextView tv1, tvr, tvm, tvd;
    private EditText ed1, ed2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed1 = findViewById(R.id.editNumero1);
        ed2 = findViewById(R.id.editNumero2);
        tv1 = findViewById(R.id.tvResultado);
        tvr = findViewById(R.id.tvResultadoRestar);
        tvm = findViewById(R.id.tvResultadoM);
        tvd = findViewById(R.id.tvResultadoD);
    }

    public void sumar(View v){

        if(ed1.getText().toString() == "" || ed2.getText().toString() == ""){
            Toast.makeText(this,"Debe definir valores", Toast.LENGTH_LONG).show();
        } else {
            int valor1 = Integer.parseInt(ed1.getText().toString());
            int valor2 = Integer.parseInt(ed2.getText().toString());

            int suma = valor1 + valor2;
            tv1.setText("El resultado de la suma: " + suma);
        }
    }

    public void Restar(View v){

        if(ed1.getText().toString() == "" || ed2.getText().toString() == ""){
            Toast.makeText(this,"Debe definir valores", Toast.LENGTH_LONG).show();
        } else {
            int valor1 = Integer.parseInt(ed1.getText().toString());
            int valor2 = Integer.parseInt(ed2.getText().toString());
            int resta = valor1 - valor2;
            tvr.setText("El resultado de la resta: " + resta);
        }
    }

    public void multiplicar(View v){

        if(ed1.getText().toString() == "" || ed2.getText().toString() == ""){
            Toast.makeText(this,"Debe definir valores", Toast.LENGTH_LONG).show();
        } else {

            int valor1 = Integer.parseInt(ed1.getText().toString());
            int valor2 = Integer.parseInt(ed2.getText().toString());
            int mult = valor1 * valor2;
            tvm.setText("La multiplicación es: " + mult);
        }
    }

    public void dividir(View v){

        if(ed1.getText().toString() == "" || ed2.getText().toString() == ""){
            Toast.makeText(this,"Debe definir valores", Toast.LENGTH_LONG).show();
        } else {
            float valor1 = Float.valueOf(ed1.getText().toString());
            float valor2 = Float.valueOf(ed2.getText().toString());
            if (valor2 == 0) {
                Toast.makeText(this, "El segundo valor no puede ser 0", Toast.LENGTH_LONG).show();
            } else {
                float div = valor1 / valor2;
                tvd.setText("La division es: " + div);
            }
        }

    }


}