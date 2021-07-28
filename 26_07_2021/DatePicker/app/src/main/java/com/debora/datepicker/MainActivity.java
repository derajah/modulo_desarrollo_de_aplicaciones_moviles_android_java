package com.debora.datepicker;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private Button btnDatePicker, btnTimePicker;
    private EditText txtFecha, txtHora;
    private int año, mes, dia, hora, minuto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDatePicker = (Button)findViewById(R.id.btnFecha);
        btnTimePicker = (Button)findViewById(R.id.btnHora);
        txtFecha = (EditText)findViewById(R.id.editTextFecha);
        txtHora = (EditText)findViewById(R.id.editTextHora);

        View.OnClickListener onClickListener = view -> {
            onClick(view);
        };

        btnDatePicker.setOnClickListener(onClickListener);
        btnTimePicker.setOnClickListener(onClickListener);
    }

    public void onClick(View v){

        if(v == btnDatePicker){
            final Calendar c = Calendar.getInstance();
            año = c.get(Calendar.YEAR);
            mes = c.get(Calendar.MONTH);
            dia = c.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog datePicker = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                    txtFecha.setText(dayOfMonth + "-" + (month+1) + "-" + year);
                }
            }, año, mes, dia);

            datePicker.show();

        }

        if(v == btnTimePicker){
            final Calendar c = Calendar.getInstance();
            hora = c.get(Calendar.HOUR_OF_DAY);
            minuto = c.get(Calendar.MINUTE);

            TimePickerDialog timePicker = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                    txtHora.setText(hourOfDay + ":"+minute);
                }
            }, hora, minuto, false);

            timePicker.show();
        }

    }
}