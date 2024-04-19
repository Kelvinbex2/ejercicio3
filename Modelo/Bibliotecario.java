package Modelo;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.text.DateFormatter;

public class Bibliotecario extends Personal {
    private ArrayList<Libro> libros;
    private ArrayList<Usuario> usuarios;
    private String id;


    public Bibliotecario(String nombre, String fechNac, String tipo) {
        super(nombre, fechNac, tipo);
        this.libros = new ArrayList<>();
        this.usuarios = new ArrayList<>();
        this.id = crearid();
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

    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    // {
    // public void crearUsuario() {
    // System.out.println("Usuarion: " +USUARIO);
    // String us = Entrada.leerString();

    // System.out.println("Contraseña" + CONTRSANIA);
    // String con = Entrada.leerString();
    // if (us.equalsIgnoreCase(USUARIO) && con.equalsIgnoreCase(CONTRSANIA)) {
    // Usuario personal;
    // System.out.print("NombreUs: ");
    // String nombre = Entrada.leerString();

    // System.out.print("FechaNacUs: ");
    // String fechNac = Entrada.leerString();

    // System.out.print("TipoUs: ");
    // String tipo = Entrada.leerString();

    // personal = new Usuario(nombre, fechNac, tipo);
    // usuarios.add(personal);
    // }

    // }}

    // public void mostrarUsuario() {
    // if (usuarios.isEmpty()) {
    // System.out.println("No hay usuario creado");
    // }
    // for (Usuario usuario : usuarios) {
    // usuario.toString();

    // }
    // }

    // Devuelve un libro prestado por un usuario

  

    public String crearid() {

        String[] biblio = nombre.split(" ");
        String id = biblio[biblio.length - 1];
        String generar = id.substring(0, Math.min(id.length(), 4)).toUpperCase();

        DateTimeFormatter formater = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String date = fechNac.formatted(formater);

        return generar + "-" + date;

    }

    @Override
    public void detalle() {
        System.out.println("\tBibliotecario: ");
        System.out.println("Nombre: " + getNombre());
        System.out.println("FechaNac: " + getFechNac());
        System.out.println("Tipo: " + getTipo());
        System.out.println("Id : " + id);
    }

}
