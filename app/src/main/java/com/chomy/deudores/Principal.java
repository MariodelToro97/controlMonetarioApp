package com.chomy.deudores;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;

public class Principal extends AppCompatActivity {

    Typeface script, segundo;

    TextView resumen, debo, deben, valorDebo, valorDeben;
    Button cerrar, nuevaPersona, nuevoAdeudor, nuevaDeuda, nuevoAbono, verReporte;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.principal);
        getWindow().setNavigationBarColor(ContextCompat.getColor(this, R.color.colorabajo));
        getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.colorarriba));

        cerrar = findViewById(R.id.sesion);
        nuevaPersona = findViewById(R.id.agregarPersona);
        nuevoAdeudor = findViewById(R.id.nuevoAdeudor);
        nuevaDeuda = findViewById(R.id.nuevaDeuda);
        nuevoAbono = findViewById(R.id.nuevoAbono);
        verReporte = findViewById(R.id.verReporte);

        resumen = findViewById(R.id.resumen);
        debo = findViewById(R.id.debo);
        deben = findViewById(R.id.deben);
        valorDebo = findViewById(R.id.valorDebo);
        valorDeben = findViewById(R.id.valorDeben);

        cerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animatoo.animateFade(Principal.this);
                finish();
            }
        });

        //Agrega el tipo de fuente de texto
        String fuente = "fuentes/Coaster.otf";
        String fuente2 = "fuentes/Ketimun.otf";

        this.script = Typeface.createFromAsset(getAssets(),  fuente);
        this.segundo = Typeface.createFromAsset(getAssets(),  fuente2);

        resumen.setTypeface(script);
        deben.setTypeface(script);
        debo.setTypeface(script);
        valorDeben.setTypeface(script);
        valorDebo.setTypeface(script);

        nuevaPersona.setTypeface(segundo);
        nuevaDeuda.setTypeface(segundo);
        nuevoAdeudor.setTypeface(segundo);
        nuevoAbono.setTypeface(segundo);
        verReporte.setTypeface(segundo);
        cerrar.setTypeface(script);
    }
}
