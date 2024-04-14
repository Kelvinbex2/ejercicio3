package Main;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import Modelo.Biblioteca;
import Modelo.Bibliotecario;
import Modelo.Entrada;
import Modelo.Libro;

public class Main {
    static List<Biblioteca> bibliotecas = new ArrayList<>();
    static Bibliotecario bibliotecario = new Bibliotecario();

    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca("BiblioTeca Andes", "Calle ranom");
        crearBibloteca(biblioteca);

    }

    public static void crearBibloteca(Biblioteca biblioteca) {

        bibliotecas.add(biblioteca);

    }

    public static void mostrarBiblotecas() {
        for (Biblioteca biblioteca : bibliotecas) {
            biblioteca.detalle();
        }
    }

    public static void crearLibro() {

        String titulo = Entrada.leerString();
        System.out.println("Titulo: ");
        String autor = Entrada.leerString();
        System.out.println("Autor");
        LocalDate fechaPub = LocalDate.of(1999, 03, 02);

        
        Libro libro = new Libro(titulo, autor, fechaPub);
        bibliotecario.aniadirLibro(libro);

    }
}
