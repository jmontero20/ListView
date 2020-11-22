package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Cilindro extends AppCompatActivity {
    private EditText altura, radio;
    private TextView resultado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cilindro);
        altura = findViewById(R.id.txtAlturaCilindro);
        radio = findViewById(R.id.txtRadioCilindro);
        resultado = findViewById(R.id.lblResultado);
    }

    public void calcularResultado(View v){
        if(validar()) {
            double n1, n2,res =0;
            n1 = Double.parseDouble(altura.getText().toString());
            n2 = Double.parseDouble(radio.getText().toString());
            res = 3.14*n2*n2*n1;
            resultado.setText(String.format("%.2f",res));
            Operacion op = new Operacion("Volumen cilindro","altura : "+n1+", radio : "+n2, ""+String.format("%.2f",res));
            op.guardar();
        }
    }

    public boolean validar(){
        if(altura.getText().toString().isEmpty()){
            altura.setError(getString(R.string.error_altura));
            altura.requestFocus();
            return false;
        }

        if(radio.getText().toString().isEmpty()){
            radio.setError(getString(R.string.error_radio));
            radio.requestFocus();
            return false;
        }

        double n1 = Double.parseDouble(altura.getText().toString());
        if( n1 <= 0){
            altura.setError(getString(R.string.mensaje_error_altura_mayor_cero));
            altura.requestFocus();
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
        altura.setText("");
        radio.setText("");
        resultado.setText("");
        radio.requestFocus();

    }


}