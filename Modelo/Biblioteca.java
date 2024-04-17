package Modelo;

import java.util.ArrayList;
import java.util.List;



public class Biblioteca {
    private String nombre;
    private String calle;
    private List<Libro> listaMaterialBiblios;
    private List<Usuario> iUsuarios;
    private List<Personal> personals;

    public Biblioteca(String nombre, String calle) {
        this.listaMaterialBiblios = new ArrayList<>();
        this.iUsuarios = new ArrayList<>();
        this.personals = new ArrayList<>();
        this.nombre = nombre;
        this.calle = calle;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public List<Libro> getListaMaterialBiblios() {
        return listaMaterialBiblios;
    }

    public void setListaMaterialBiblios(List<Libro> listaMaterialBiblios) {
        this.listaMaterialBiblios = listaMaterialBiblios;
    }

    public List<Usuario> getlUsuarios() {
        return iUsuarios;
    }

    public void setlUsuarios(List<Usuario> iUsuarios) {
        this.iUsuarios = iUsuarios;
    }

    public List<Personal> getPersonals() {
        return personals;
    }

    public void setPersonals(List<Personal> personals) {
        this.personals = personals;
    }

    public int elegir() {
        int num = 0;
        System.out.println("Que personal quieres aniadir");
        System.out.println("1. Usuario");
        System.out.println("2. Autor");
        System.out.print("Elege: ");
        num = Entrada.leerEntero();
        return num;
    }

    public void crearPersonal() {
        int num = elegir();
        System.out.print("Nombre: ");
        String nombre = Entrada.leerString();

        System.out.println("Fecha Nacimiento (formato: dd-MM-yyyy): ");
        String fechNac = Entrada.leerString();

        System.out.print("Tipo (Usuario/Autor): ");
        String tipo = Entrada.leerString();

        if (num == 1 && tipo.equalsIgnoreCase("Usuario")) {
            Personal usuPersonal = new Usuario(nombre, fechNac, tipo);
            personals.add(usuPersonal);
        } else if (num == 2 && tipo.equalsIgnoreCase("Autor")) {
            Personal auPersonal = new Autor(nombre, fechNac, tipo);
            personals.add(auPersonal);
        } else {
            System.out.println("Error");
        }

    }

    
    public void detalle() {
        int i = 1;
        System.out.println("Biblioteca "+ getNombre());
        StringBuilder sb = new StringBuilder();
        sb.append("Nombre: ").append(getNombre()).append("\n").append("Calle: ").append(getCalle());
        System.out.println(sb.toString());
        
    }

    public void aniadirLibro(Libro libro) {
        listaMaterialBiblios.add(libro);

    }

    public void eliminar(String titulo) {
        boolean libroEncontradp = false;

        for (Libro libro : listaMaterialBiblios) {
            if (libro.getTitulo().equalsIgnoreCase(titulo)) {
                listaMaterialBiblios.remove(libro);
                libroEncontradp = true;
                break;
            }
        }

        if (!libroEncontradp) {
            System.out.println("No se encontró el libro");
        }

    }


    public void prestar(String titulo) {
        boolean libroEncontrado = false;
        Usuario usuario = new Usuario(); 
    
        
        for (Libro libro : listaMaterialBiblios) {
            if (libro.getTitulo().equalsIgnoreCase(titulo)) {
                
                libro.prestar();
                usuario.getLibrosPrest().add(libro); // Agregar el libro a la lista de libros prestados del usuario
                libroEncontrado = true;
                break; // Salir del bucle una vez que se realiza el préstamo
            }
        }
    
        if (!libroEncontrado) {
            System.out.println("El libro no está disponible para prestar o no existe en la biblioteca.");
        }
    }
    
    public void mostrarLibros() {
        if (listaMaterialBiblios.isEmpty()) {
            System.out.println("No  se encontró el libro en esta biblioteca");
        }
        for (Libro libro : listaMaterialBiblios) {

            libro.detalle();
        }
    }
}
