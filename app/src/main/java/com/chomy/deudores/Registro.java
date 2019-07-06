package com.chomy.deudores;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;

public class Registro extends AppCompatActivity {

    private Typeface script, segundoScript;

    Button nuevo, cancelar;
    TextView registro;
    EditText nombre, paterno, materno, correo, usuario, contrasena, confContra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        getWindow().setNavigationBarColor(ContextCompat.getColor(this, R.color.colorabajo));
        getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.colorarriba));

        //Texto Encabezado
        nuevo = findViewById(R.id.registrar);
        //Botones
        cancelar = findViewById(R.id.regresar);
        registro = findViewById(R.id.lbl_registro);
        //Input
        nombre = findViewById(R.id.nombre);
        paterno = findViewById(R.id.apePat);
        materno = findViewById(R.id.apeMat);
        correo =findViewById(R.id.email);
        usuario = findViewById(R.id.usuario);
        contrasena = findViewById(R.id.cont);
        confContra = findViewById(R.id.confCont);

        cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (Registro.this, MainActivity.class);
                startActivity(intent);
                Animatoo.animateZoom(Registro.this);
                finish();
            }
        });

        //Agrega el tipo de fuente de texto
        String fuente = "fuentes/Coaster.otf";
        String fuente1 = "fuentes/Smilen.otf";

        this.script = Typeface.createFromAsset(getAssets(),  fuente);
        this.segundoScript = Typeface.createFromAsset(getAssets(),  fuente1);

        registro.setTypeface(script);
        cancelar.setTypeface(script);

        nuevo.setTypeface(script);

        nombre.setTypeface(segundoScript);
        paterno.setTypeface(segundoScript);
        materno.setTypeface(segundoScript);
        correo.setTypeface(segundoScript);
        usuario.setTypeface(segundoScript);
        contrasena.setTypeface(segundoScript);
        confContra.setTypeface(segundoScript);
    }
}
