package Modelo;

import java.util.ArrayList;

public class Bibliotecario extends Personal {
    final static String USUARIO = "Biblo";
    final static String CONTRSANIA = "1234";
    private ArrayList<Libro> libros;
    private ArrayList<Usuario> usuarios;

    public Bibliotecario(String nombre, String fechNac, String tipo) {
        super(nombre, fechNac, tipo);
        this.libros = new ArrayList<>();
        this.usuarios = new ArrayList<>();
    }

    public Bibliotecario() {
        super("", "", "");
        this.libros = new ArrayList<>();
    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
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

    public void crearUsuario() {
        System.out.println("Usuarion: ");
        String us = Entrada.leerString();

        System.out.println("Contraseña");
        String con = Entrada.leerString();
        if (us.equalsIgnoreCase(USUARIO) && con.equalsIgnoreCase(CONTRSANIA)) {
            Usuario personal;
            System.out.print("NombreUs: ");
            String nombre = Entrada.leerString();

            System.out.print("FechaNacUs: ");
            String fechNac = Entrada.leerString();

            System.out.print("TipoUs: ");
            String tipo = Entrada.leerString();

            personal = new Usuario(nombre, fechNac, tipo);
            usuarios.add(personal);
        }

    }

    public void mostrarUsuario(){
        if (usuarios.isEmpty()) {
            System.out.println("No hay usuario creado");
    }
        for (Usuario usuario : usuarios) {
            usuario.toString();

        
        }
    }

}
