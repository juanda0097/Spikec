package com.spikec.spikec;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

public class ejemplo extends AppCompatActivity {
    TextView txtfecha;
    TextView txthora;
    Button btnfecha;
    Button btnhora;
    Button bano;
    TextView tv;
    //variables globales
    private int year,mes,dia,horas,minutos;
    public boolean[] checkedColors = new boolean[]{
            false, // Red
            false, // Green
            false, // Blue
            false, // Purple
            false, // Olive
            false

    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejemplo);
        bano = (Button)findViewById(R.id.btnbano);
        tv = (TextView)findViewById(R.id.txtselec);

        //identificar la vista de fecha y hora

        txtfecha=(TextView)findViewById(R.id.txtfecha);
        txthora=(TextView)findViewById(R.id.txthora);

        //identificar los botones

        btnfecha=(Button)findViewById(R.id.btnfecha);
        btnhora=(Button)findViewById(R.id.btnhora);

        //colocar el bton poner fecha a la espera de un clic

        btnfecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //obtiene la fecha actual
                final Calendar c = Calendar.getInstance();
                // se captura eñ año mes y dia de la fecha actual en tres variables
                year=c.get(Calendar.YEAR);
                mes=c.get(Calendar.MONTH);
                dia=c.get(Calendar.DAY_OF_MONTH);

                // creamos el dialogdatatepiker
                DatePickerDialog datePicker = new DatePickerDialog(ejemplo.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        txtfecha.setText(year+"/"+month+"/"+dayOfMonth);
                    }
                },year,mes,dia);
                // se muestra el cuadro de dialogo
                datePicker.show();
            }
        });

        // colocamos el otro boton (hora) a la espera

        btnhora.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // en este se establece la hora actual a diferencia del anterior

                final Calendar c = Calendar.getInstance();
                horas=c.get(Calendar.HOUR_OF_DAY);
                minutos=c.get(Calendar.MINUTE);

                // creamos el DialogTimePicker
                TimePickerDialog ponerhora =new TimePickerDialog(ejemplo.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

                        txthora.setText(hourOfDay+":"+minute);

                    }
                },horas,minutos,false);

                // mostramos el elemento timer como una ventana de dialogo
                ponerhora.show();
            }
        });

        bano.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // String array for alert dialog multi choice items
                String[] colors = new String[]{
                        "normal",
                        "medicado",
                        "basiado de glandulas",
                        "desparacitacion",
                        "peluqueria",
                        "corte de uñas"
                };






                // Convert the color array to list
                final List<String> colorsList = Arrays.asList(colors);



                AlertDialog.Builder alert2= new AlertDialog.Builder(ejemplo.this);
                alert2.setTitle("Dialogo con opciones");
//                alert2.setMessage(" este cuadro tiene botones de acceso");

                //agregando las opciones del chekbox
                alert2.setMultiChoiceItems(colors, checkedColors, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i, boolean isChecked) {

                        // Update the current focused item's checked status
                        checkedColors[i] = isChecked;

                        // Get the current focused item
                        String currentItem = colorsList.get(i);

                        // Notify the current action
                        Toast.makeText(getApplicationContext(),
                                currentItem + " " + isChecked, Toast.LENGTH_SHORT).show();
                    }
                });


                //agrega el boton ok al cuadro de dialogo y aplica un listener
                alert2.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        tv.setText("tus Baños son:  \n");



                        for ( int j= 0; j<checkedColors.length; j++){
                            boolean checked = checkedColors[j];
                            if (checked) {
                                tv.setText(tv.getText() + colorsList.get(j) + "\n");
                            }

                        }
                    }
                });

                //agrega el boton cancelar al listener y implementa un listener
                alert2.setNegativeButton("cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();

                    }
                });
                alert2.show();//se muestra el  dialogo
            }
        });
    }
}
