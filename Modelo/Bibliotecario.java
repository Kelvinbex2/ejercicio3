package Modelo;

import java.util.ArrayList;

public class Bibliotecario {
    private ArrayList<Libro> libros = new ArrayList<>();

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
