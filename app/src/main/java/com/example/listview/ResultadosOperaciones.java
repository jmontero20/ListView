package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;

public class ResultadosOperaciones extends AppCompatActivity {
    private TableLayout tabla;
    private ArrayList<Operacion> operaciones;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultados_operaciones);

        tabla = findViewById(R.id.tbtOperaciones);
        operaciones = Datos.obtener();

        for (int i = 0; i < operaciones.size(); i++) {
            TableRow fila = new TableRow(this);

            TextView columna_uno = new TextView(this);
            TextView columna_dos = new TextView(this);
            TextView columna_tres = new TextView(this);
            TextView columna_cuatro = new TextView(this);

            columna_uno.setText(""+(i+1));
            columna_dos.setText(operaciones.get(i).getOperacion());
            columna_tres.setText(operaciones.get(i).getDatos());
            columna_cuatro.setText(operaciones.get(i).getResultado());

            fila.addView(columna_uno);
            fila.addView(columna_dos);
            fila.addView(columna_tres);
            fila.addView(columna_cuatro);

            columna_uno.setGravity(Gravity.CENTER_HORIZONTAL);
            columna_dos.setGravity(Gravity.CENTER_HORIZONTAL);
            columna_tres.setGravity(Gravity.CENTER_HORIZONTAL);
            columna_cuatro.setGravity(Gravity.CENTER_HORIZONTAL);
            tabla.addView(fila);

        }

    }
}