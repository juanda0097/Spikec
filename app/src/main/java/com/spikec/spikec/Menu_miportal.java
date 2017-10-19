package com.spikec.spikec;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Menu_miportal extends AppCompatActivity {
    Button buttonnbano, buttoncita;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_miportal);
        buttonnbano = (Button)findViewById(R.id.btnportalbano);
        buttoncita = (Button)findViewById(R.id.btnportalcita);
        buttonnbano.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentbano = new Intent(Menu_miportal.this, ejemplo.class);
                startActivity(intentbano);
            }
        });
        buttoncita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentcita = new Intent(Menu_miportal.this, cita.class);
                startActivity(intentcita);
            }
        });
    }
}
