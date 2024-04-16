package Modelo;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Libro implements MaterialBiblio {
    private String titulo;
    private String autor;
    private LocalDate fechaPub;
    private String id;
    private int contador;
    private List<String> librosPrestados;
    private List<String> libros= new ArrayList<>();
    private boolean libroPrestado;

    

   

    public Libro() {
        this.librosPrestados = new ArrayList<>();
    }

    public Libro(String titulo, String autor, LocalDate fechaPub) {
        this.titulo = titulo;
        this.autor = autor;
        this.fechaPub = fechaPub;
        this.id = generarIdentificador();
        this.contador++;
        this.librosPrestados = new ArrayList<>();
        this.libroPrestado=true;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public LocalDate getFechaPub() {
        return fechaPub;
    }

    public void setFechaPub(LocalDate fechaPub) {
        this.fechaPub = fechaPub;
    }

    public String getId() {
        return id;
    }

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }
    public boolean isLibroPrestado() {
        return libroPrestado;
    }

    public void setLibroPrestado(boolean libroPrestado) {
        this.libroPrestado = libroPrestado;
    }

    @Override
    public void verSinopsis() {
        System.out.println("Ingrese una sinopsis:");
        String sinopsis = Entrada.leerString();
        if (sinopsis.startsWith("Habla") && sinopsis.length() == 20) {
            System.out.println("El autor " + getAutor() + " con id " + getId() + " " + sinopsis);
        }
    }

    @Override
    public void prestar() {
        if (contador >= 0) {
            System.out.println("El libro está disponible para prestar.");
            System.out.println("Ingrese el titulo del libro:");
            String idLibro = Entrada.leerString();
            if (!idLibro.isEmpty() && idLibro.equalsIgnoreCase(titulo)) {
                setContador(getContador()-1);
                
                libros.remove(idLibro);

                librosPrestados.addAll(libros);
                System.out.println("Libro prestado correctamente.");
            } else {
                System.out.println("El titulo ingresado no coincide con el del libro.");
            }
        } else {
            System.out.println("El libro no está disponible para prestar.");
        }
    }

    

    public String generarIdentificador() {
        String[] nombresGen = autor.split(" ");
        String id = nombresGen[nombresGen.length - 1];
        String idNombre = id.substring(0, Math.min(id.length(), 4)).toUpperCase();

        SimpleDateFormat format = new SimpleDateFormat("yy-MM-dd");
        String fecString = format.format(fechaPub);
        return idNombre + "-" + fecString;
    }

    public void detalle() {
        System.out.println("Detalles del Libro:");
        System.out.println("Título: " + titulo);
        System.out.println("Autor: " + autor);
        System.out.println("Fecha de Publicación: " + fechaPub);
        System.out.println("ID: " + id);
        System.out.println("Cantidad Disponible: " + contador);
    
        if (libroPrestado) {
            System.out.println("Libros Prestados:");
            for (String tituloLibro : librosPrestados) {
                System.out.println("- " + tituloLibro);
            }
        } else {
            System.out.println("Libros Prestados: Ninguno");
        }
    }
    

     

  
}
