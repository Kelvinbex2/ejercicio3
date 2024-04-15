package Main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import Modelo.Biblioteca;
import Modelo.Bibliotecario;
import Modelo.Entrada;
import Modelo.Libro;
import Modelo.MaterialBiblio;

public class Main {
    static List<Biblioteca> bibliotecas = new ArrayList<>();
    static Bibliotecario bibliotecario = new Bibliotecario();
    static Libro materialBiblio = new Libro() ;

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
                    bibliotecario.mostrarLibros();
                    break;
                case 5:
                    materialBiblio.prestar();
                    break;
                case 6:
                    bibliotecario.eliminar();
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
            System.out.println("Lista de Bibliotecas:");
            for (Biblioteca biblioteca : bibliotecas) {
                biblioteca.detalle();
            }
        }
    }

    private static void crearLibro() {
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
}
