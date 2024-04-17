package Modelo;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Usuario extends Personal {
    private String id;
    private ArrayList<Libro> librosPrest;
    private ArrayList<Libro> listaMaterialBiblios;

    public Usuario() {
        super("", "", "");
        this.librosPrest = new ArrayList<>();
        this.listaMaterialBiblios = new ArrayList<>();
    }

    public Usuario(String nombre, String fechNac, String tipo) {
        super(nombre, fechNac, tipo);
        this.id = generarIdentificador();
        this.librosPrest = new ArrayList<>();
        this.listaMaterialBiblios = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ArrayList<Libro> getLibrosPrest() {
        return librosPrest;
    }

    public void setLibrosPrest(ArrayList<Libro> librosPrest) {
        this.librosPrest = librosPrest;
    }

    public String generarIdentificador() {
        String[] nombresGen = nombre.split(" ");
        String id = nombresGen[nombresGen.length - 1];
        String idNombre = id.substring(0, Math.min(id.length(), 4)).toUpperCase();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyMMdd");
        String fechaFormateada = fechNac.formatted(formatter);

        return idNombre + "-" + fechaFormateada;
    }

    public void prestar(String titulo) {
        boolean libroEncontrado = false;

        for (Libro libro : listaMaterialBiblios) {
            if (libro.getTitulo().equalsIgnoreCase(titulo) && libro.getContador() > 0) {
                libro.prestar();
                if (libro.isLibroPrestado()) { // Verificar si el libro fue prestado con éxito
                    librosPrest.add(libro); // Agregar el libro prestado

                    System.out.println("¡Libro prestado con éxito!");
                } else {
                    System.out.println("No se pudo prestar el libro.");
                }
                libroEncontrado = true;
                break; // Salir del bucle

            }
        }

        if (!libroEncontrado) {
            System.out.println("El libro no está disponible para prestar o no existe en la biblioteca.");
        }
    }

    @Override
    public String toString() {
        return "Usuario [nombre=" + nombre + ", fechNac=" + fechNac + ", id=" + id + ", tipo=" + tipo + ", librosPrest="
                + librosPrest + "]";
    }

}
