package Main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import Modelo.Biblioteca;
import Modelo.Bibliotecario;
import Modelo.Entrada;
import Modelo.Libro;
import Modelo.Usuario;


public class Main {
    static int idBiblioteca = 0;
    static List<Biblioteca> bibliotecas = new ArrayList<>();
    static Bibliotecario bibliotecario = new Bibliotecario();
    static Libro materialBiblio = new Libro();
    

    public static void main(String[] args) {
        crearMenu();
    }

    public static void crearMenu() {
        int opc;

        do {
            System.out.println("\n\tMenu");
            System.out.println("1: Añadir Biblioteca");
            System.out.println("2: Mostrar Bibliotecas");
            System.out.println("3: Agregar Libro");
            System.out.println("4: Mostrar Libros");
            System.out.println("5: Prestar Libro");
            System.out.println("6: Eliminar Libro");
            System.out.println("7. Agregar Usuario");
            System.out.println("8. Mostrar Usuario");
            System.out.println("0: Salir");
            System.out.print("Ingrese una opción: ");
            opc = Entrada.leerEntero();

            switch (opc) {
                case 1:
                    crearBiblioteca();
                    break;
                case 2:
                    mostrarBibliotecas();
                    break;
                case 3:
                    crearLibro();
                    break;
                case 4:
                    mostrarLibros();
                    break;
                case 5:
                    materialBiblio.prestar();
                    break;
                case 6:
                    eliminar();
                    break;

                case 7:
                    bibliotecario.crearUsuario();
                    break;
                    
                case 8:
                    bibliotecario.mostrarUsuario();
                    break;
                case 0:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción inválida");
                    break;
            }
        } while (opc != 0);
    }

    private static void mostrarLibros() {

        if (idBiblioteca >= 0 && idBiblioteca < bibliotecas.size()) {
            Biblioteca bibliotecaSeleccionada = bibliotecas.get(idBiblioteca);
            System.out.println("Libros disponibles en la biblioteca: " + bibliotecaSeleccionada.getNombre());
            bibliotecario.mostrarLibros();
        } else {
            System.out.println("No hay bibliotecas para mostrar.");

        }

    }

    private static void crearBiblioteca() {
        System.out.print("Nombre de la Biblioteca: ");
        String nombre = Entrada.leerString();
        System.out.print("Dirección de la Biblioteca: ");
        String direccion = Entrada.leerString();

        Biblioteca biblioteca = new Biblioteca(nombre, direccion);
        bibliotecas.add(biblioteca);
        System.out.println("Biblioteca añadida correctamente.");
    }

    private static void mostrarBibliotecas() {
        if (bibliotecas.isEmpty()) {
            System.out.println("No hay bibliotecas para mostrar.");
        } else {
            System.out.println("Lista de Bibliotecas: \n");
            for (Biblioteca biblioteca : bibliotecas) {
                biblioteca.detalle();
                System.out.println();
            }
            
        }
    }

    private static void crearLibro() {
        mostrarBibliotecas();
        System.out.print("Biblioteca: ");
        idBiblioteca = Entrada.leerEntero() - 1;
        if (idBiblioteca < 0 || idBiblioteca > bibliotecas.size()) {
            System.out.println("Biblioteca no válida.");
            return;
        }

        System.out.print("Título del Libro: ");
        String titulo = Entrada.leerString();
        System.out.print("Autor del Libro: ");
        String autor = Entrada.leerString();
        LocalDate fechaPublicacion = pedirFechaPublicacion();

        Libro libro = new Libro(titulo, autor, fechaPublicacion);
        bibliotecario.aniadirLibro(libro);
        System.out.println("Libro añadido correctamente.");
    }

    private static LocalDate pedirFechaPublicacion() {
        System.out.println("Fecha de Publicación del Libro:");
        System.out.print("Año: ");
        int year = Entrada.leerEntero();
        System.out.print("Mes: ");
        int month = Entrada.leerEntero();
        System.out.print("Día: ");
        int day = Entrada.leerEntero();
        return LocalDate.of(year, month, day);
    }

    public static void eliminar() {

        System.out.print("Título del Libro: ");
        String titulo = Entrada.leerString();

        bibliotecario.eliminar(titulo);
        System.out.println("Libro eliminado correctamente.");
    }
}
