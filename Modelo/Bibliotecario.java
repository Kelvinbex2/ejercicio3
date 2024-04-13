package Modelo;

import java.util.ArrayList;

public class Bibliotecario {
    private ArrayList<Libro>libros= new ArrayList<>();


    public void aniadirLibro(Libro libro){
        libros.add(libro);
    }

    public void eliminar(Libro libro){
        libros.remove(libro);
    }

    
}
