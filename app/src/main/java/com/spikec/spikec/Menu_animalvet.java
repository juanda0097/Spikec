package com.spikec.spikec;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class Menu_animalvet extends AppCompatActivity {
Button bano,cita;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_animalvet);
        bano = (Button)findViewById(R.id.btnanimalvetbano);
        bano.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent bano = new Intent(Menu_animalvet.this, ejemplo.class);
                startActivity(bano);
            }
        });
        cita = (Button)findViewById(R.id.btnenviarcita);
        cita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cita = new Intent(Menu_animalvet.this, cita.class);
                startActivity(cita);
            }
        });
    }
}
