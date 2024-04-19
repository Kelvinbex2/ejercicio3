package Modelo;

import java.util.ArrayList;
import java.util.List;

public class Autor extends Personal {
    private List<Libro> librosEscritos;

    public Autor(String nombre, String fechNac, String tipo) {
        super(nombre, fechNac, tipo);
        this.librosEscritos = new ArrayList<>();
    }

    public List<Libro> getLibrosEscritos() {
        return librosEscritos;
    }

    public void setLibrosEscritos(List<Libro> librosEscritos) {
        this.librosEscritos = librosEscritos;
    }

    @Override
    public void detalle(){
        System.out.println("\tAutor: ");
        System.out.println("Nombre: " + getNombre());
        System.out.println("FechaNac" + getFechNac());
        System.out.println("Tipo" + getTipo());
    }
}
