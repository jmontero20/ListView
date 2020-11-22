package com.example.listview;

import java.util.ArrayList;

public class Datos {
    private static ArrayList<Operacion> operaciones = new ArrayList();

    public static void guardar(Operacion p){
        operaciones.add(p);
    }

    public static ArrayList<Operacion> obtener(){
        return operaciones;
    }
}

