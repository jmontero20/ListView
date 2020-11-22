package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Rectangulo extends AppCompatActivity {
    private EditText lado,altura;
    private TextView resultado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rectangulo);
        altura = findViewById(R.id.txtAlturaRectangulo);
        lado = findViewById(R.id.txtLadoRectangulo);
        resultado = findViewById(R.id.lblResultadoRectangulo);
    }

    public void calcularResultado(View v){
        if(validar()) {
            double n1, n2,res =0;
            n1 = Double.parseDouble(altura.getText().toString());
            n2 = Double.parseDouble(lado.getText().toString());
            res =n1*n2;
            Operacion op = new Operacion("area rectangulo","altura : "+n1+", lado : "+n2,String.format("%.2f",res));
            op.guardar();
            resultado.setText(String.format("%.2f",res));
        }
    }

    public boolean validar(){
        if(altura.getText().toString().isEmpty()){
            altura.setError(getString(R.string.error_altura));
            altura.requestFocus();
            return false;
        }

        if(lado.getText().toString().isEmpty()){
            lado.setError(getString(R.string.error_lado));
            lado.requestFocus();
            return false;
        }

        double n1 = Double.parseDouble(altura.getText().toString());
        if( n1 <= 0){
            altura.setError(getString(R.string.mensaje_error_altura_mayor_cero));
            altura.requestFocus();
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
        altura.setText("");
        lado.setText("");
        resultado.setText("");
        lado.requestFocus();

    }
}