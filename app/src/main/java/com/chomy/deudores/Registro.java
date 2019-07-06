package com.chomy.deudores;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;

public class Registro extends AppCompatActivity {

    Button nuevo, cancelar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        getWindow().setNavigationBarColor(getResources().getColor(R.color.colorabajo));
        getWindow().setStatusBarColor(getResources().getColor(R.color.colorarriba));

        nuevo = findViewById(R.id.registrar);
        cancelar = findViewById(R.id.regresar);

        cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (Registro.this, MainActivity.class);
                startActivity(intent);
                Animatoo.animateZoom(Registro.this);
                finish();
            }
        });
    }
}
