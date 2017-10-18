package com.spikec.spikec;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;

public class login extends AppCompatActivity implements View.OnClickListener {
Button bottonregister, bottoninicio_sesion;
    EditText editexttcorreo, editexttcontrasena;
    FirebaseAuth.AuthStateListener mAuthListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        bottoninicio_sesion = (Button) findViewById(R.id.btnlogin);
        bottonregister = (Button) findViewById(R.id.btnregister);
        editexttcorreo = (EditText) findViewById(R.id.etcorreo);
        editexttcontrasena = (EditText) findViewById(R.id.etcontrasena);

        bottonregister.setOnClickListener(this);
        bottoninicio_sesion.setOnClickListener(this);

        //Este comprueba con iniciamos sesion o cerramos sesion
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {

            }
        };
    }
        private void registrar(String email,String pass){
            FirebaseAuth.getInstance().createUserWithEmailAndPassword(email,pass);
    }
    private void iniciarsesion(String email,String pass){
        FirebaseAuth.getInstance().signInWithEmailAndPassword(email,pass);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnlogin:
                String emailinicio = editexttcorreo.getText().toString();
                String passinicio = editexttcontrasena.getText().toString();
                iniciarsesion(emailinicio,passinicio);
                break;
            case R.id.btnregister:
                String emailregistro = editexttcorreo.getText().toString();
                String passregregistro = editexttcontrasena.getText().toString();
                iniciarsesion(emailregistro,passregregistro);
                break;
        }
    }
}

