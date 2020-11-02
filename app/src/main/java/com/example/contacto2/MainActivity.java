package com.example.contacto2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;

import com.google.android.material.textfield.TextInputEditText;

import java.util.Calendar;
public class MainActivity extends AppCompatActivity {

    DatePicker datePicker;
    TextInputEditText textInputEditTextNombre;
    TextInputEditText textInputEditTextTelefono;
    TextInputEditText textInputEditTextEmail;
    TextInputEditText textInputEditTextTextDescripcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CargarDatos();
    }
    public void CargarDatos() {
        Intent intent = getIntent();
        if (intent.hasExtra("NOMBRE")){
            textInputEditTextNombre= (TextInputEditText) findViewById(R.id.txtNombre);
            textInputEditTextNombre.setText(intent.getStringExtra("NOMBRE"));
        }
        if (intent.hasExtra("TELEFONO")) {
            textInputEditTextNombre = (TextInputEditText) findViewById(R.id.txtTelefono);
            textInputEditTextNombre.setText(intent.getStringExtra("TELEFONO"));
        }
        if (intent.hasExtra("EMAIL")) {
            textInputEditTextNombre = (TextInputEditText) findViewById(R.id.txtEmail);
            textInputEditTextNombre.setText(intent.getStringExtra("EMAIL"));
        }
        if (intent.hasExtra("DESC")) {
            textInputEditTextNombre = (TextInputEditText) findViewById(R.id.txtDescripcion);
            textInputEditTextNombre.setText(intent.getStringExtra("DESC"));
        }
        showPicker(intent);
    }

    public void showPicker(Intent intent){
        datePicker = (DatePicker) findViewById(R.id.dpFecha);
        if(intent.hasExtra("YYYY") &&
                intent.hasExtra("MM") &&
                intent.hasExtra("DD")) {
            int anio = Integer.parseInt(intent.getStringExtra("YYYY"));
            int mes = Integer.parseInt(intent.getStringExtra("MM"));
            int dia = Integer.parseInt(intent.getStringExtra("DD"));
            datePicker.init(anio,mes,dia,null);

        } else{
            final Calendar c = Calendar.getInstance();
            int anio = c.get(Calendar.YEAR);
            int mes = c.get(Calendar.MONTH);
            int dia = c.get(Calendar.DAY_OF_MONTH);
            datePicker.init(anio,mes,dia,null);
        }
    }

    public void btnSiguiente(View view){
        datePicker = (DatePicker) findViewById(R.id.dpFecha);
        textInputEditTextNombre = (TextInputEditText) findViewById(R.id.txtNombre);
        textInputEditTextEmail = (TextInputEditText) findViewById(R.id.txtEmail);
        textInputEditTextTelefono = (TextInputEditText) findViewById(R.id.txtTelefono);
        textInputEditTextTextDescripcion = (TextInputEditText) findViewById(R.id.txtDescripcion);

        Intent intent = new Intent(this, Confirmar.class);
        intent.putExtra("NOMBRE",textInputEditTextNombre.getText().toString());
        intent.putExtra("TELEFONO",textInputEditTextTelefono.getText().toString());
        intent.putExtra("EMAIL",textInputEditTextEmail.getText().toString());
        intent.putExtra("DESC",textInputEditTextTextDescripcion.getText().toString());
        intent.putExtra("YYYY",Integer.toString(datePicker.getYear()));
        intent.putExtra("MM",Integer.toString(datePicker.getMonth()));
        intent.putExtra("DD",Integer.toString(datePicker.getDayOfMonth()));
        startActivity(intent);
        finish();
    }
}
