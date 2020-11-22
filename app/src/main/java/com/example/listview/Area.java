package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Area extends AppCompatActivity {
    private ListView lista_opciones;
    private String opciones [];
    private ArrayAdapter<String> adapter;
    private Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_area);
        lista_opciones = findViewById(R.id.lstAreas);
        opciones = getResources().getStringArray(R.array.areas);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,opciones);
        lista_opciones.setAdapter(adapter);
        lista_opciones.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                switch (position){
                    case 0:
                        intent = new Intent(Area.this,Cuadrado.class);
                        startActivity(intent);
                        break;
                    case  1:
                        intent = new Intent(Area.this,Rectangulo.class);
                        startActivity(intent);
                        break;
                    case  2:
                        intent = new Intent(Area.this,Circulo.class);
                        startActivity(intent);
                        break;
                    case  3:
                        intent = new Intent(Area.this,Triangulo.class);
                        startActivity(intent);
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + position);
                }
            }
        });
    }
}