package com.chomy.deudores;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.app.ProgressDialog;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.google.android.material.snackbar.Snackbar;

import java.util.regex.Pattern;

public class Registro extends AppCompatActivity {

    Typeface script, segundoScript;

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

        nuevo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final ProgressDialog progressDialog = new ProgressDialog(Registro.this);
                progressDialog.setTitle(R.string.titProgre);
                progressDialog.setCancelable(false);
                progressDialog.setMessage("Verificando y guardando los datos del usuario");
                progressDialog.show();

                String nom = nombre.getText().toString();
                String pat = paterno.getText().toString();
                String mat = materno.getText().toString();
                String cor = correo.getText().toString();
                String usr = usuario.getText().toString();
                String cont = contrasena.getText().toString();
                String confCont = confContra.getText().toString();

                if (nom.isEmpty() || pat.isEmpty() || mat.isEmpty() || cor.isEmpty() || usr.isEmpty() || cont.isEmpty() || confCont.isEmpty()) {
                    Snackbar.make(view, R.string.campoVacio, Snackbar.LENGTH_INDEFINITE)
                            .setAction("De acuerdo", new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Log.i("Snackbar", "Pulsación del botoón del Snackbar de registro");
                                }
                            })
                            .setActionTextColor(ContextCompat.getColor(Registro.this, R.color.colorAccent))
                            .show();
                } else {
                    if (usr.length() <= 15) {
                        if (cont.length() >= 8) {
                            if (!validarEmail(cor)){
                                progressDialog.dismiss();
                                Snackbar.make(view, R.string.tamCont, Snackbar.LENGTH_INDEFINITE)
                                        .setAction("De acuerdo", new View.OnClickListener() {
                                            @Override
                                            public void onClick(View view) {
                                                correo.setError("El formato del correo es inválido");
                                                correo.requestFocus();
                                            }
                                        })
                                        .setActionTextColor(ContextCompat.getColor(Registro.this, R.color.colorAccent))
                                        .show();
                            } else {
                                if (!validarNombre(nom)){
                                    progressDialog.dismiss();
                                    Snackbar.make(view, R.string.formNom, Snackbar.LENGTH_INDEFINITE)
                                            .setAction("De acuerdo", new View.OnClickListener() {
                                                @Override
                                                public void onClick(View view) {
                                                    nombre.setError("El campo solamente debe contener letras");
                                                    nombre.requestFocus();
                                                }
                                            })
                                            .setActionTextColor(ContextCompat.getColor(Registro.this, R.color.colorAccent))
                                            .show();
                                } else {
                                    if (!validarNombre(pat)){
                                        progressDialog.dismiss();
                                        Snackbar.make(view, R.string.formNom, Snackbar.LENGTH_INDEFINITE)
                                                .setAction("De acuerdo", new View.OnClickListener() {
                                                    @Override
                                                    public void onClick(View view) {
                                                        paterno.setError("El campo solamente debe contener letras");
                                                        paterno.requestFocus();
                                                    }
                                                })
                                                .setActionTextColor(ContextCompat.getColor(Registro.this, R.color.colorAccent))
                                                .show();
                                    } else {
                                        if (!validarNombre(mat)) {
                                            progressDialog.dismiss();
                                            Snackbar.make(view, R.string.formNom, Snackbar.LENGTH_INDEFINITE)
                                                    .setAction("De acuerdo", new View.OnClickListener() {
                                                        @Override
                                                        public void onClick(View view) {
                                                            materno.setError("El campo solamente debe contener letras");
                                                            materno.requestFocus();
                                                        }
                                                    })
                                                    .setActionTextColor(ContextCompat.getColor(Registro.this, R.color.colorAccent))
                                                    .show();
                                        } else {
                                            if (!validarPassword(cont)){
                                                if (!validarPasswordDos(cont)){
                                                    if (cont.equals(confCont)) {
                                                        BDApp bdApp = new BDApp(Registro.this, "controlMoney", null, 1);
                                                        try (SQLiteDatabase db = bdApp.getReadableDatabase()) {
                                                        }

                                                    } else {
                                                        progressDialog.dismiss();
                                                        Snackbar.make(view, R.string.incontr, Snackbar.LENGTH_INDEFINITE)
                                                                .setAction("De acuerdo", new View.OnClickListener() {
                                                                    @Override
                                                                    public void onClick(View view) {
                                                                        contrasena.setError("Las contraseñas no coinciden");
                                                                        contrasena.requestFocus();
                                                                    }
                                                                })
                                                                .setActionTextColor(ContextCompat.getColor(Registro.this, R.color.colorAccent))
                                                                .show();
                                                    }
                                                } else {
                                                    progressDialog.dismiss();
                                                    Snackbar.make(view, R.string.contAlfa, Snackbar.LENGTH_INDEFINITE)
                                                            .setAction("De acuerdo", new View.OnClickListener() {
                                                                @Override
                                                                public void onClick(View view) {
                                                                    contrasena.setError("La contraseña debe contener valores alfanuméricos");
                                                                    contrasena.requestFocus();
                                                                }
                                                            })
                                                            .setActionTextColor(ContextCompat.getColor(Registro.this, R.color.colorAccent))
                                                            .show();
                                                }
                                            } else {
                                                progressDialog.dismiss();
                                                Snackbar.make(view, R.string.contAlfa, Snackbar.LENGTH_INDEFINITE)
                                                        .setAction("De acuerdo", new View.OnClickListener() {
                                                            @Override
                                                            public void onClick(View view) {
                                                                contrasena.setError("La contraseña debe contener valores alfanuméricos");
                                                                contrasena.requestFocus();
                                                            }
                                                        })
                                                        .setActionTextColor(ContextCompat.getColor(Registro.this, R.color.colorAccent))
                                                        .show();
                                            }
                                        }
                                    }
                                }
                            }
                        } else {
                            progressDialog.dismiss();
                            Snackbar.make(view, R.string.tamCont, Snackbar.LENGTH_INDEFINITE)
                                    .setAction("De acuerdo", new View.OnClickListener() {
                                        @Override
                                        public void onClick(View view) {
                                            contrasena.setError("La contraseña debe ser mayor o igual a 8 caracteres");
                                            contrasena.requestFocus();
                                        }
                                    })
                                    .setActionTextColor(ContextCompat.getColor(Registro.this, R.color.colorAccent))
                                    .show();
                        }
                    } else {
                        progressDialog.dismiss();
                        Snackbar.make(view, R.string.tamUsr, Snackbar.LENGTH_INDEFINITE)
                                .setAction("De acuerdo", new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        usuario.setError("El usuario debe tener 15 caracteres o menos");
                                        usuario.requestFocus();
                                    }
                                })
                                .setActionTextColor(ContextCompat.getColor(Registro.this, R.color.colorAccent))
                                .show();
                    }
                }
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

    private boolean validarEmail(String email) {
        Pattern pattern = Patterns.EMAIL_ADDRESS;
        return pattern.matcher(email).matches();
    }

    private boolean validarNombre(String nombre) {
        Pattern pattern = Pattern.compile("^[A-Z,a-z]+[[ ][A-Z,a-z]]*");
        return pattern.matcher(nombre).matches();
    }

    private boolean validarPassword(String password) {
        Pattern pattern = Pattern.compile("^[0-9]+");
        return pattern.matcher(password).matches();
    }

    private boolean validarPasswordDos(String password) {
        Pattern pattern = Pattern.compile("^[a-z,A-Z]+");
        return pattern.matcher(password).matches();
    }
}
