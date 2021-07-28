package com.debora.formulario;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class DisplayForm extends AppCompatActivity {

    private TextView formResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_form);

        formResult = findViewById(R.id.formularioResult);
        String resultado = getIntent().getStringExtra("resultado");
        formResult.setText(""+resultado);
    }
}