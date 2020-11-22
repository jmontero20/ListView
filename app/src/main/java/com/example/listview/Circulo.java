package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Circulo extends AppCompatActivity {
    private EditText  radio;
    private TextView resultado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circulo);
        radio = findViewById(R.id.txtRadioCirculo);
        resultado = findViewById(R.id.lblResultadoCirculo);
    }

    public void calcularResultado(View v){
        if(validar()) {
            double n2,res =0;

            n2 = Double.parseDouble(radio.getText().toString());
            res = 3.14*n2*n2;
            Operacion op = new Operacion("Area circulo","radio : "+n2,""+String.format("%.2f",res));
            op.guardar();
            resultado.setText(String.format("%.2f",res));
        }
    }

    public boolean validar(){


        if(radio.getText().toString().isEmpty()){
            radio.setError(getString(R.string.error_radio));
            radio.requestFocus();
            return false;
        }


        double n2 = Double.parseDouble(radio.getText().toString());
        if( n2 <= 0){
            radio.setError(getString(R.string.mensaje_error_radio_mayor_cero));
            radio.requestFocus();
            return false;
        }
        return true;
    }

    public void limpiar(View v){

        radio.setText("");
        resultado.setText("");
        radio.requestFocus();

    }
}