package Main;

import java.util.ArrayList;
import java.util.List;

import Modelo.Biblioteca;

public class Main {
    static List<Biblioteca> bibliotecas = new ArrayList<>();

    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca("BiblioTeca Andes", "Calle ranom");
        crearBibloteca(biblioteca);
        System.out.println(biblioteca);

    }

    public static void crearBibloteca(Biblioteca biblioteca) {

        bibliotecas.add(biblioteca);

    }
}
