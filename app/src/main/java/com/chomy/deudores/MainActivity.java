package com.chomy.deudores;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;

public class MainActivity extends AppCompatActivity {

    Button registro, inicio;
    EditText user, pass;
    CheckBox remember;

    private Typeface script, segundoScript;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setNavigationBarColor(ContextCompat.getColor(this, R.color.colorabajo));
        getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.colorarriba));

        registro = findViewById(R.id.registro);
        inicio = findViewById(R.id.sesion);

        user = findViewById(R.id.usuario);
        pass = findViewById(R.id.pass);

        remember = findViewById(R.id.remember);

        registro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent registro = new Intent(MainActivity.this, Registro.class);
                startActivity(registro);
                Animatoo.animateFade(MainActivity.this);
                finish();
            }
        });

        inicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String action;
                Intent inicio = new Intent(MainActivity.this, Principal.class);
                startActivity(inicio);
                Animatoo.animateShrink(MainActivity.this);
                finish();
            }
        });

        //Agrega el tipo de fuente de texto
        String fuente = "fuentes/Coaster.otf";
        String fuente1 = "fuentes/Smilen.otf";

        this.script = Typeface.createFromAsset(getAssets(),  fuente);
        this.segundoScript = Typeface.createFromAsset(getAssets(),  fuente1);

        registro.setTypeface(script);
        inicio.setTypeface(script);

        user.setTypeface(segundoScript);
        pass.setTypeface(segundoScript);
        remember.setTypeface(segundoScript);

    }
}
