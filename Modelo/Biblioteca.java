package Modelo;

import java.util.ArrayList;
import java.util.List;



public class Biblioteca {
    private String nombre;
    private String calle;
    private List<Libro> listaMaterialBiblios;
    private List<Usuario> iUsuarios;
    private List<Personal> personals;
    private ArrayList<Libro> listaMaterial= new ArrayList<>();

    public ArrayList<Libro> getListaMaterial() {
        return listaMaterial;
    }

    public void setListaMaterial(ArrayList<Libro> listaMaterial) {
        this.listaMaterial = listaMaterial;
    }

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


   
    
    public void mostrarLibros() {
        if (listaMaterialBiblios.isEmpty()) {
            System.out.println("No  se encontró el libro en esta biblioteca");
        }
        for (Libro libro : listaMaterialBiblios) {

            libro.detalle();
        }
    }

    public void prestar(String titulo) {
        boolean libroEncontrado = false;

        for (Libro libro : listaMaterialBiblios) {
            if (libro.getTitulo().equalsIgnoreCase(titulo) && libro.getContador() > 0) {
                libro.prestar();
                if (libro.isLibroPrestado()) { // Verificar si el libro fue prestado con éxito
                    listaMaterial.add(libro);// Agregar el libro prestado

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


    public void devolver(String titulo) {
        boolean libroEncontrado = false;

        for (Usuario usuario : iUsuarios) {
            
        }
        for (Libro libro : listaMaterial) {
            if (libro.getTitulo().equalsIgnoreCase(titulo)) {
                libro.devolver();  
                listaMaterial.remove(libro);  // Eliminar el libro de la lista de libros prestados
                System.out.println("¡Libro devuelto con éxito!");
                libroEncontrado = true;
                break;
            }
        }

        if (!libroEncontrado) {
            System.out.println("No tienes prestado este libro.");
        }
    }
   
}
