package Modelo;

import java.util.ArrayList;
import java.util.List;

public class Autor extends Personal {
    private List<Libro> librosEscritos;

    public Autor(String nombre, String fechNac, String tipo, List<Libro> librosEscritos) {
        super(nombre, fechNac, tipo);
        this.librosEscritos = new ArrayList<>();
    }

    public List<Libro> getLibrosEscritos() {
        return librosEscritos;
    }

    public void setLibrosEscritos(List<Libro> librosEscritos) {
        this.librosEscritos = librosEscritos;
    }
}
