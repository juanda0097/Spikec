package com.spikec.spikec;

import android.app.AlertDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class cita extends AppCompatActivity {
    TextView tvfechacita;
    TextView tvhoracita;
    Button btnfechacita;
    Button btnhoracita;
    Button bottoncita;
    Button enviar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cita);
        bottoncita = (Button)findViewById(R.id.btncita);
        bottoncita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(cita.this);
                View mView = getLayoutInflater().inflate(R.layout.dialog_cita, null);

                final EditText mDescribe = (EditText) mView.findViewById(R.id.describecita);
                Button mButton = (Button) mView.findViewById(R.id.btnokcita);
                mButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(cita.this, "Descripcion anexada",Toast.LENGTH_LONG).show();
                    }

                });
                mBuilder.setView(mView);
                AlertDialog dialog = mBuilder.create();
                dialog.show();

            }
        });
        /*
        enviar = (Button)findViewById(R.id.btnenviarcita);
        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentenviar = new Intent(cita.this, login.class);
                startActivity(intentenviar);
            }
        });*/
    }
}
