package com.debora.formulario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import java.util.regex.Pattern;
import android.util.Patterns;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;


public class MainActivity extends AppCompatActivity {

    private static final Pattern PASSWORD_PATTERN =
            Pattern.compile("^" +
                    //"(?=.*[0-9])" +         //at least 1 digit
                    //"(?=.*[a-z])" +         //at least 1 lower case letter
                    //"(?=.*[A-Z])" +         //at least 1 upper case letter
                    "(?=.*[a-zA-Z])" +      //any letter
                    "(?=.*[@#$%^&+=])" +    //at least 1 special character
                    "(?=\\S+$)" +           //no white spaces
                    ".{4,}" +               //at least 4 characters
                    "$");

    private EditText nombre, apellido, direccion, email, fono, fechaNac;
    private TextInputLayout layPass, layPassRein;
    private TextInputEditText pass, reinpass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nombre = findViewById(R.id.editName);
        apellido = findViewById(R.id.editApellido);
        direccion = findViewById(R.id.editDire);
        email = findViewById(R.id.editemail);
        fono = findViewById(R.id.editFono);
        fechaNac = findViewById(R.id.editFechaNac);
        pass = findViewById(R.id.editPass);
        reinpass = findViewById(R.id.editReinPass);
        layPass = findViewById(R.id.layPass);
        layPassRein = findViewById(R.id.layPassRein);
    }

    private boolean validateEmail() {
        String emailInput = email.getText().toString().trim();

        if (emailInput.isEmpty()) {
            email.setError("Campo no puede ser vacío");
            return false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(emailInput).matches()) {
            email.setError("Ingrese un email válido");
            return false;
        } else {
            email.setError(null);
            return true;
        }
    }

    private boolean validatePassword() {
        String passwordInput = pass.getText().toString().trim();
        String passInRein = reinpass.getText().toString().trim();

        if (passwordInput.isEmpty()) {
            layPass.setError("Campo no puede ser vacío");
            return false;
        } else if(passInRein.isEmpty()){
            layPassRein.setError("Campo no puede ser vacío");
            return false;
        } else if (!PASSWORD_PATTERN.matcher(passwordInput).matches()) {
            layPass.setError("Password muy débil");
            return false;
        } else if(!passwordInput.equals(passInRein)){
            layPassRein.setError("Password no coincide");
            return false;
        } else {
            layPass.setError(null);
            layPassRein.setError(null);
            return true;
        }


    }

    private boolean validateForm() {
        String nombreInput = nombre.getText().toString().trim();
        String apellidoInput = apellido.getText().toString().trim();
        String direccionInput = direccion.getText().toString().trim();
        String fechaNacInput = fechaNac.getText().toString().trim();
        String telefonoInput = fono.getText().toString().trim();

        if (nombreInput.isEmpty()) {
            nombre.setError("Campo no puede ser vacío");
            return false;
        } else if (apellidoInput.isEmpty()) {
            apellido.setError("Campo no puede ser vacío");
            return false;
        } else if (direccionInput.isEmpty()) {
            direccion.setError("Campo no puede ser vacío");
            return false;
        } else if (fechaNacInput.isEmpty()) {
            fechaNac.setError("Campo no puede ser vacío");
            return false;
        } else if (telefonoInput.isEmpty()) {
            fono.setError("Campo no puede ser vacío");
            return false;
        } else {
            nombre.setError(null);
            apellido.setError(null);
            direccion.setError(null);
            fechaNac.setError(null);
            fono.setError(null);
            return true;
        }
    }

    public void enviarForm(View v) {
        if (!validateEmail() | !validateForm() | !validatePassword()) {
            return;
        }

        String input = "Nombre: " + nombre.getText().toString();
        input += "\n";
        input += "Apellido: " + apellido.getText().toString();
        input += "\n";
        input += "Dirección: " + direccion.getText().toString();
        input += "\n";
        input += "Email: " + email.getText().toString();
        input += "\n";
        input += "Fecha Nacimiento: " + fechaNac.getText().toString();
        input += "\n";
        input += "Teléfono: " + fono.getText().toString();

        Intent salida = new Intent(this,DisplayForm.class);
        salida.putExtra("resultado", input);
        startActivity(salida);
    }


}