package Modelo;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;




public class Libro implements MaterialBiblio, Comparable<Libro> {
    private String titulo;
    private String autor;
    private LocalDate fechaPub;
    private String id;
    private int contador;
   
    private boolean libroPrestado;

    public Libro() {
       
    }

    public Libro(String titulo, String autor, LocalDate fechaPub) {
        this.titulo = titulo;
        this.autor = autor;
        this.fechaPub = fechaPub;
        this.id = generarIdentificador();
        this.contador++;
        this.libroPrestado = false;
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
        if (contador > 0) {
            contador--;  // Decrementar el contador para indicar que un libro ha sido prestado
            libroPrestado = true;  // Marcar el libro como prestado
            System.out.println("¡Libro prestado con éxito!");
        } else {
            System.out.println("El libro no está disponible para prestar.");
        }
    }
    

    

    public String generarIdentificador() {
        String[] nombresGen = autor.split(" ");
        String id = nombresGen[nombresGen.length - 1];
        String idNombre = id.substring(0, Math.min(id.length(), 4)).toUpperCase();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyMMdd");
        String fecString = fechaPub.format(formatter);
        return idNombre + "-" + fecString;
    }

    public void detalle() {
        System.out.println("Detalles del Libro:");
        System.out.println("Título: " + titulo);
        System.out.println("Autor: " + autor);
        System.out.println("Fecha de Publicación: " + fechaPub);
        System.out.println("ID: " + id);
        System.out.println("Cantidad Disponible: " + contador);
        System.out.println("Estado de Préstamo: " + (libroPrestado ? "Prestado" : "Disponible"));
    }
    

    @Override
    public int compareTo(Libro o) {
        return this.titulo.compareToIgnoreCase(o.titulo);
    }

}
