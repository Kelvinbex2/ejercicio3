package Main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import Modelo.Biblioteca;
import Modelo.Bibliotecario;
import Modelo.Entrada;
import Modelo.Libro;
import Modelo.Personal;
import Modelo.Usuario;

public class Main {
    static int idBiblioteca = 0;
    static List<Biblioteca> bibliotecas = new ArrayList<>();
    static Biblioteca bibliotecario;
    static Bibliotecario bibliotecario1 = new Bibliotecario();
    static Libro materialBiblio = new Libro();
    static Usuario usuario = new Usuario();

    public static void main(String[] args) {
        bibliotecario = new Biblioteca("Kelvin", "Fuenla");
        Personal usuario = new Usuario("kelvin", "20-20-20", "Usuario");
        materialBiblio = new Libro("h", "p", pedirFechaPublicacion());
        bibliotecario.aniadirLibro(materialBiblio);
        bibliotecario.aniadirPersonal(usuario);
        crearMenu();
    }

    public static void crearMenu() {
        int opc;

        do {
            System.out.println("\n+================================+");
            System.out.println("\tMenu");
            System.out.println("1: Agregar Libro");
            System.out.println("2: Mostrar Libros");
            System.out.println("3: Prestar Libro");
            System.out.println("4: Eliminar Libro");
            System.out.println("5: Devolver libro");
            System.out.println("6. Agregar Personal");
            System.out.println("7. Mostrar Personal");
            System.out.println("0: Salir");
            System.out.println(" +================================+");
            System.out.print("Ingrese una opción: ");
            opc = Entrada.leerEntero();

            switch (opc) {

                case 1:
                    crearLibro();
                    break;
                case 2:
                    mostrarLibros();
                    break;
                case 3:
                    prestar();
                    break;
                case 4:
                    eliminar();
                    break;
                case 5:
                    devolverLibro();
                    break;
                case 6:
                    bibliotecario.crearPersonal();
                    ;
                    break;

                case 7:
                    bibliotecario.mostrarPersonals();
                    ;
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

    private static void devolverLibro() {
        System.out.println("\t\nDevolver Libro");
        System.out.println("Ingrese el titulo del Libro: ");
        String idl = Entrada.leerString();
        bibliotecario.devolver(idl);
    }

    private static void mostrarLibros() {

        bibliotecario.mostrarLibros();

    }

    private static void crearLibro() {

        System.out.print("\nTítulo del Libro: ");
        String titulo = Entrada.leerString();
        while (titulo.contains(materialBiblio.getTitulo())) {
            System.out.println("\tEl título del libro ya existe");
            System.out.print("Título del Libro: ");
            titulo = Entrada.leerString();
        }
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

        System.out.print("\n  \tTítulo del Libro: ");
        String titulo = Entrada.leerString();

        bibliotecario.eliminar(titulo);
        System.out.println("\tLibro eliminado correctamente.");
    }

    public static void prestar() {

        System.out.print("Título del Libro: ");
        String titulo = Entrada.leerString();

        bibliotecario.prestar(titulo);

    }

}
