package com.spikec.spikec;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

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
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null){
                    Log.i("SESION", "Sesion iniciada "+ user.getEmail());
                    //si eso es valido poner iniciar una actividad

                }else{
                    Log.i("SESION", "sesion cerrada");


                }

        }
        };
    }
        private void registrar(String email,String pass){
            FirebaseAuth.getInstance().createUserWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()){
                        Log.i("SESION", "Usuario creado");
                    }else {
                        Log.i("SESION", task.getException().getMessage()+"");
                    }
                }
            });
    }
    private void iniciarsesion(String email,String pass){
        FirebaseAuth.getInstance().signInWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    Log.i("SESION", "Sesion Iniciada");


                }else {
                    Log.i("SESION", task.getException().getMessage()+"");
                }
            }
        });;
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
                registrar(emailregistro,passregregistro);
                break;
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseAuth.getInstance().addAuthStateListener(mAuthListener);
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (mAuthListener != null ){
            FirebaseAuth.getInstance().removeAuthStateListener(mAuthListener);
        }
    }
}

