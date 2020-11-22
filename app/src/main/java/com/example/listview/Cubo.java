package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Cubo extends AppCompatActivity {
    private EditText lado;
    private TextView resultado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cubo);
        lado = findViewById(R.id.txtLadoCubo);
        resultado = findViewById(R.id.lblResultadoCubo);
    }

    public void calcularResultado(View v){
        if(validar()) {
            double n2,res =0;

            n2 = Double.parseDouble(lado.getText().toString());
            res = n2*n2*n2;
            Operacion op = new Operacion("volumen cubo","lado : "+n2,String.format("%.2f",res));
            op.guardar();
            resultado.setText(String.format("%.2f",res));
        }
    }

    public boolean validar(){


        if(lado.getText().toString().isEmpty()){
            lado.setError(getString(R.string.error_lado));
            lado.requestFocus();
            return false;
        }


        double n2 = Double.parseDouble(lado.getText().toString());
        if( n2 <= 0){
            lado.setError(getString(R.string.mensaje_error_lado_mayor_cero));
            lado.requestFocus();
            return false;
        }
        return true;
    }

    public void limpiar(View v){

        lado.setText("");
        resultado.setText("");
        lado.requestFocus();

    }

}