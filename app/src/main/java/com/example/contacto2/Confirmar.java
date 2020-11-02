package com.example.contacto2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;

public class Confirmar extends AppCompatActivity {

    private String strNombre;
    private String strYYYY;
    private String strMM;
    private String strDD;
    private String strEmail;
    private String strTelefono;
    private String strDesc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmar);
        ObtenerData();
        PonerData();
    }

    public void ObtenerData(){
        Intent intent = getIntent();
        strNombre =intent.getStringExtra("NOMBRE");
        strTelefono =intent.getStringExtra("TELEFONO");
        strEmail =intent.getStringExtra("EMAIL");
        strDesc =intent.getStringExtra("DESC");
        strYYYY = intent.getStringExtra("YYYY");
        strMM = intent.getStringExtra("MM");
        strDD = intent.getStringExtra("DD");

    }

    public void PonerData(){
        Intent intent = getIntent();
        TextView textViewNombre = (TextView) findViewById(R.id.tvNombre);
        TextView textViewFecha = (TextView) findViewById(R.id.tvFecha);
        TextView textViewTelefono = (TextView) findViewById(R.id.tvTelefono);
        TextView textViewEmail = (TextView) findViewById(R.id.tvEmail);
        TextView textViewDescripcion = (TextView) findViewById(R.id.tvDescripcion);

        textViewNombre.setText(strNombre);
        textViewTelefono.setText(strTelefono);
        textViewEmail.setText(strEmail);
        textViewDescripcion.setText(strDesc);
        textViewFecha.setText(strDD +
                "/" + strMM +
                "/" + strDD);
    }

    public void editarDatos(View view){
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("NOMBRE",strNombre);
        intent.putExtra("TELEFONO", strTelefono);
        intent.putExtra("EMAIL", strEmail);
        intent.putExtra("DESC", strDesc);
        intent.putExtra("YYYY",strYYYY);
        intent.putExtra("MM",strMM);
        intent.putExtra("DD",strDD);
        startActivity(intent);
        finish();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode== KeyEvent.KEYCODE_BACK){
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
        return super.onKeyDown(keyCode, event);
    }
}