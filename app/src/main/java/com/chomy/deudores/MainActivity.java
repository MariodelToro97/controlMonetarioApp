package com.chomy.deudores;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.github.javiersantos.appupdater.AppUpdater;
import com.github.javiersantos.appupdater.enums.Display;
import com.github.javiersantos.appupdater.enums.UpdateFrom;

public class MainActivity extends AppCompatActivity {

    Button registro, inicio;
    EditText user, pass;
    CheckBox remember;

    Typeface script, segundoScript;

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

    @Override
    protected void onResume() {
        super.onResume();
        actualizarApp();
    }

    private void actualizarApp () {
        AppUpdater appUpdater = new AppUpdater(this)
                .setDisplay(Display.DIALOG)
                .setCancelable(false)
                .setUpdateFrom(UpdateFrom.GITHUB)
                .setGitHubUserAndRepo("MariodelToro97", "controlMonetarioApp")
                .showEvery(1)
                .setTitleOnUpdateAvailable(R.string.actualizacion)
                .setTitleOnUpdateNotAvailable(R.string.actualizacionNo)
                .setButtonUpdate(R.string.actualizar)
                .setButtonUpdateClickListener(new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, R.string.descarga, Toast.LENGTH_LONG).show();
                    }
                })
                .setButtonDismiss(R.string.actualizarDespues)
                .setButtonDismissClickListener(new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, R.string.actualizarDesp, Toast.LENGTH_LONG).show();
                    }
                })
                .setButtonDoNotShowAgain(R.string.noInteresado)
                .setButtonDoNotShowAgainClickListener(new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, R.string.cancelUpd, Toast.LENGTH_LONG).show();
                    }
                })
                .setIcon(R.drawable.ic_system_update_black_24dp);
        appUpdater.start();
    }
}
