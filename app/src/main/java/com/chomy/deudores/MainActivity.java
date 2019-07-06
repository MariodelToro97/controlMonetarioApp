package com.chomy.deudores;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;

public class MainActivity extends AppCompatActivity {

    Button registro, inicio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setNavigationBarColor(getResources().getColor(R.color.colorabajo));
        getWindow().setStatusBarColor(getResources().getColor(R.color.colorarriba));

        registro = findViewById(R.id.registro);
        inicio = findViewById(R.id.sesion);

        registro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent registro = new Intent(MainActivity.this, Registro.class);
                startActivity(registro);
                Animatoo.animateFade(MainActivity.this);
                finish();
            }
        });
    }
}
