package com.debora.productos1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText codigo, nombre, precio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        codigo = findViewById(R.id.editCodigo);
        nombre = findViewById(R.id.editNombre);
        precio = findViewById(R.id.editPrecio);
    }

    public void crearProducto(View v){

        Admindb db = new Admindb(this, "Productos",null, 1);
        SQLiteDatabase base = db.getWritableDatabase();

        String cod = codigo.getText().toString();
        String nom = nombre.getText().toString();
        String pre = precio.getText().toString();

        if(!cod.isEmpty() && !nom.isEmpty() && !pre.isEmpty()){

            ContentValues crear = new ContentValues();
            crear.put("codigo", cod);
            crear.put("nombre", nom);
            crear.put("precio", pre);

            base.insert("producto",null, crear);
            //base.close();

            codigo.setText("");
            nombre.setText("");
            precio.setText("");

            Toast.makeText(this, "Producto guardado exitosamente", Toast.LENGTH_LONG).show();

        } else {
            Toast.makeText(this, "Debe completar los valores", Toast.LENGTH_LONG).show();
        }


    }

    public void buscarProducto(View v){

        Admindb db = new Admindb(this, "Productos",null, 1);
        SQLiteDatabase base = db.getWritableDatabase();

        base.close();
    }

    public void modificarProducto(){

    }

    public void eliminarProducto(){

    }
}