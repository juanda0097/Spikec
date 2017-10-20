package com.spikec.spikec;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class cita extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cita);

       final EditText etdescripcita = (EditText)findViewById(R.id.descripcioncita);
       final EditText fechahora = (EditText) findViewById(R.id.fechaid);
        Button enviar = (Button) findViewById(R.id.btnenviarcita);
        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String descripcion = etdescripcita.getText().toString();
                //   fechahora.setText(descripcion);
                String fechayhora = fechahora.getText().toString();
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("Cita");
                myRef.push().setValue("Motivo: "+ descripcion);
                 DatabaseReference Reffechahora = database.getReference("Fecha");

                 Reffechahora.push().setValue(fechayhora);


            }
        });


    }
}
