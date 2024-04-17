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



    public void crearUsuario() {
        System.out.println("Usuarion: " +USUARIO);
        String us = Entrada.leerString();

        System.out.println("Contraseña" + CONTRSANIA);
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

    public void mostrarUsuario() {
        if (usuarios.isEmpty()) {
            System.out.println("No hay usuario creado");
        }
        for (Usuario usuario : usuarios) {
            usuario.toString();

        }
    }

    // Devuelve un libro prestado por un usuario
    
    public Libro devolverLibro() {
        Usuario usuario = new Usuario();
        int posicion = 0;
        boolean devuelto = false;
        while (!devuelto) {
            System.out.println("\nIngrese el titulo del libro a devolver: ");
            String tituloDevuelto = Entrada.leerString();

            for (int i = 0; i < usuario.getLibrosPrest().size(); i++) {
                if (tituloDevuelto.equalsIgnoreCase(usuario.getLibrosPrest().get(i).getTitulo())) {
                    usuario.getLibrosPrest().remove(i);
                    devuelto = true;
                    break;
                }
            }
            if (!devuelto) {
                System.out.println("El libro no se encuentra prestado");
            } else {
                System.out.println("Se ha devuelto el libro: " + usuario.getLibrosPrest().get(posicion));
            }
            posicion++;
        }
        return usuario.getLibrosPrest().get(posicion);
    }

}
