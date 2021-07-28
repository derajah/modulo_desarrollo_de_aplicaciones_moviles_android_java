package com.debora.multiple_activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;

public class RadioButtonActivity extends AppCompatActivity {

    private TextView tvr;
    private EditText ed1, ed2;
    private RadioButton rs, rr, rm, rd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio_button);

        ed1 = findViewById(R.id.editNumero1);
        ed2 = findViewById(R.id.editNumero2);
        tvr = findViewById(R.id.tvResultado);
        rs = findViewById(R.id.rdSumar);
        rr = findViewById(R.id.rdRestar);
        rm = findViewById(R.id.rdMulti);
        rd = findViewById(R.id.rdDividir);

        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.TITULO);
        TextView tvt = findViewById(R.id.tvTitulo);
        tvt.setText(message);
    }

    public void Operar(View v){

        if("".equals(ed1.getText().toString()) || "".equals(ed2.getText().toString())){
            Toast.makeText(this,"Debe definir valores", Toast.LENGTH_LONG).show();
        } else {

            if(rs.isChecked()){
                Sumar();
            } else if (rr.isChecked()){
                Restar();
            } else if (rm.isChecked()){
                multiplicar();
            } else if (rd.isChecked()){
                dividir();
            }

        }
    }

    public void Volver(View v){
        Intent volver = new Intent(this, MainActivity.class);
        startActivity(volver);
    }

    private void Sumar(){

        int valor1 = Integer.parseInt(ed1.getText().toString());
        int valor2 = Integer.parseInt(ed2.getText().toString());

        int suma = valor1 + valor2;
        tvr.setText("El resultado de la suma: " + suma);
    }

    private void Restar(){

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