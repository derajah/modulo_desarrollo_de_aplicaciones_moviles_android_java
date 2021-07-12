package com.debora.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void saludar(View v){
        Toast.makeText(this, "Me apretaste muy fuerte", Toast.LENGTH_LONG).show();
    }

    public void saludarOtro(View v){
        Toast.makeText(this, "Lo siento mami", Toast.LENGTH_LONG).show();
    }
}