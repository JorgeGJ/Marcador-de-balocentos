package com.example.jorge.marcador;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Context context = this;
    TextView r1, r2;
    Button b1, b2, b3, b4, b5, b6, b7, b8 ;
    int local, visit, puntos, marcador;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b7= (Button) findViewById(R.id.b7);
        b8= (Button) findViewById(R.id.b8);
        b8.setEnabled(false);
        b3= (Button) findViewById(R.id.b3);
        b2= (Button) findViewById(R.id.b2);
        b1= (Button) findViewById(R.id.b1);
        b4= (Button) findViewById(R.id.b4);
        b5= (Button) findViewById(R.id.b5);
        b6= (Button) findViewById(R.id.b6);

        r1= (TextView) findViewById(R.id.r1);
        r2= (TextView) findViewById(R.id.r2);

        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(context)
                        .setTitle("¿Deseas reiniciar los marcadores?")
                        .setMessage("Los marcadores se reiniciaran a 0 y los puntos se perderan.")
                        .setNegativeButton("NO",null)
                        .setPositiveButton("SI", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                r1.setText("0");
                                r2.setText("0");
                                b7.setEnabled(false);
                            }
                        }).create().show();


            }
        });

        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (marcador==0){
                    local = Integer.parseInt(r1.getText().toString())-puntos;
                    r1.setText(Integer.toString(local));
                    b7.setEnabled(false);
                }else if (marcador==1){
                    visit = Integer.parseInt(r2.getText().toString())-puntos;
                    r2.setText(Integer.toString(visit));
                    b7.setEnabled(false);
                }
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                puntos =3;
                marcador=0;
                local = Integer.parseInt(r1.getText().toString())+puntos;
                r1.setText(Integer.toString(local));
                b7.setEnabled(true);
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                marcador=0;
                puntos=2;
                local = Integer.parseInt(r1.getText().toString())+puntos;
                r1.setText(Integer.toString(local));
                b2.setEnabled(true);
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                puntos =1;
                marcador=0;
                local = Integer.parseInt(r1.getText().toString())+puntos;
                r1.setText(Integer.toString(local));
                b8.setEnabled(true);
            }
        });

        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                puntos =3;
                marcador=1;
                visit = Integer.parseInt(r2.getText().toString())+puntos;
                r2.setText(Integer.toString(visit));
                b6.setEnabled(true);
            }
        });

       b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                marcador=1;
                puntos =2;
                visit = Integer.parseInt(r2.getText().toString())+puntos;
                r2.setText(Integer.toString(visit));
                b5.setEnabled(true);
            }
        });


        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                puntos =1;
                marcador=1;
                visit = Integer.parseInt(r2.getText().toString())+puntos;
                r2.setText(Integer.toString(visit));
                b4.setEnabled(true);
            }
        });
    }
}
