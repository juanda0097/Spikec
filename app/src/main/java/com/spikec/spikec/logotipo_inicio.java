package com.spikec.spikec;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class logotipo_inicio extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logotipo_inicio);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent3 = new Intent(logotipo_inicio.this, login.class);
                startActivity(intent3);
            }
        },2000);
    }
}
