package Modelo;

import java.util.ArrayList;

public class Bibliotecario extends Personal {
    private ArrayList<Libro> libros;
    

    public Bibliotecario(String nombre, String fechNac, String tipo) {
        super(nombre, fechNac, tipo);
        this.libros = new ArrayList<>();
    }

    public Bibliotecario() {
        super("", "", "");
        this.libros = new ArrayList<>();
    }

    public ArrayList<Libro> getLibros() {
        return libros;
    }

    public void setLibros(ArrayList<Libro> libros) {
        this.libros = libros;
    }

    public void aniadirLibro(Libro libro) {
        libros.add(libro);

    }

    public void eliminar(String titulo) {
        boolean libroEncontradp = false;

        for (Libro libro : libros) {
            if (libro.getTitulo().equalsIgnoreCase(titulo)) {
                libros.remove(libro);
                libroEncontradp = true;
                break;
            }
        }

        if (!libroEncontradp) {
            System.out.println("No se encontró el libro");
        }

    }

    public void mostrarLibros() {
        if (libros.isEmpty()) {
            System.out.println("No  se encontró el libro en esta biblioteca");
        }
        for (Libro libro : libros) {

            libro.detalle();
        }
    }

}
