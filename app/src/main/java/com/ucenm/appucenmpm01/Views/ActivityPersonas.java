package com.ucenm.appucenmpm01.Views;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.ucenm.appucenmpm01.Models.Persona;
import com.ucenm.appucenmpm01.Controllers.PersonaController;

import java.util.Calendar;
import java.util.Locale;

import com.ucenm.appucenmpm01.R;

public class ActivityPersonas extends AppCompatActivity {

    private EditText nombres, apellidos, fechanac, direccion, telefono, correo;
    private Button btn_agregar;

    private PersonaController personaController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_personas);

        InitControls();

        personaController = new PersonaController(this);
        fechanac.setOnClickListener(view -> CalendarSelect());
        btn_agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                guardarPersona();
            }
        });

    }

    private void guardarPersona()
    {
        if(nombres.getText().toString().trim().isEmpty())
        {
            nombres.setError("Ingrese los nombres por favor!!");
        }

        if(apellidos.getText().toString().trim().isEmpty())
        {
            apellidos.setError("Ingrese los apellidos por favor!!");
        }

        if(fechanac.getText().toString().trim().isEmpty())
        {
            fechanac.setError("Ingrese la fecha por favor!!");
        }

        Persona persona = new Persona(nombres.getText().toString(),
                apellidos.getText().toString(),
                fechanac.getText().toString(),
                direccion.getText().toString(),
                telefono.getText().toString(),
                correo.getText().toString());

        long resultado = personaController.AddPerson(persona);

        if(resultado > 0)
        {
            Toast.makeText(this, "Persona Guardada con ID : " + resultado,
                    Toast.LENGTH_LONG).show();
        }
        else
        {
            Toast.makeText(this, "Persona no se puedo guardar",
                    Toast.LENGTH_LONG).show();
        }
    }

    private void InitControls()
    {
        nombres = (EditText) findViewById(R.id.et_nombres);
        apellidos = (EditText) findViewById(R.id.et_apellidos);
        fechanac = (EditText) findViewById(R.id.et_fechanac);
        direccion = (EditText) findViewById(R.id.et_direccion);
        telefono = (EditText) findViewById(R.id.et_telefono);
        correo = (EditText) findViewById(R.id.et_correo);
        btn_agregar = (Button) findViewById(R.id.btn_agregar);
    }

    private void CalendarSelect()
    {
        Calendar calendar = Calendar.getInstance();

        int year = calendar.get(Calendar.YEAR);
        int mes  = calendar.get(Calendar.MONTH);
        int dia = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(
                ActivityPersonas.this,
                (datePicker, selectedYear, selectedMonth, selectedDay) -> {
                    String fechaSeleccionada = String.format(
                            Locale.getDefault(),
                            "%02d/%02d/%04d",
                            selectedDay,
                            selectedMonth + 1,
                            selectedYear
                    );

                    fechanac.setText(fechaSeleccionada);
                    fechanac.setError(null);
                },
                year,
                mes,
                dia
        );

        datePickerDialog.getDatePicker().setMaxDate(System.currentTimeMillis());
        datePickerDialog.show();
    }
}
