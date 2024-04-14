package Modelo;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Libro implements MaterialBiblio {
    private String titulo;
    private String autor;
    private LocalDate fechaPub;
    private String id;
    private int contardor;
    private List<String> librosPrestados;

    public Libro(String titulo, String autor, LocalDate fechaPub) {
        this.titulo = titulo;
        this.autor = autor;
        this.fechaPub = fechaPub;
        this.id = generarIdentificador();
        contardor++;
        this.librosPrestados = new ArrayList<>();
    }

    public LocalDate getFechaPub() {
        return fechaPub;
    }

    public void setFechaPub(LocalDate fechaPub) {
        this.fechaPub = fechaPub;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getContardor() {
        return contardor;
    }

    public void setContardor(int contardor) {
        this.contardor = contardor;
    }

    @Override
    public void verSinopsis() {
        String msg = Entrada.leerString();
        if (msg.startsWith("Habla") && msg.length() == 20) {
            StringBuilder sb = new StringBuilder();
            sb.append("El autor " + getAutor()).append(" con id" + getId()).append(" " + msg);
            System.out.println(sb);
        }

    }

    @Override
    public void prestar() {
        if (contardor != 0) {
            System.out.println("Hay " + contardor + "libros");

            System.out.println("El id de libro al prestar");
            String idLibro = Entrada.leerString();

            if (this.id.equals(idLibro)) {
                contardor--;
                librosPrestados.add(idLibro);
                System.out.println("Libro prestado");
            } else {
                System.out.println("El id no coincide");
            }

        } else {
            System.out.println("No hay libros disponibles");
        }

    }

    private String generarIdentificador() {
        // Obtener las 3 primeras letras del apellido del autor
        String[] partesNombre = autor.split(" ");
        String apellido = partesNombre[partesNombre.length - 1];
        String tresPrimerasLetras = apellido.substring(0, Math.min(apellido.length(), 3)).toUpperCase();

        // Formatear la fecha de publicación en formato yy-MM-dd
        SimpleDateFormat formatter = new SimpleDateFormat("yy-MM-dd");
        String fechaFormateada = formatter.format(fechaPub);

        // Combinar las partes para formar el identificador
        return tresPrimerasLetras + "-" + fechaFormateada;
    }

    public void detalle() {
        StringBuilder sb = new StringBuilder();
        sb.append("Título: ").append(titulo).append("\n");
        sb.append("Autor: ").append(autor).append("\n");
        sb.append("Fecha de Publicación: ").append(fechaPub).append("\n");
        sb.append("ID: ").append(id).append("\n");
        sb.append("Cantidad Disponible: ").append(contardor).append("\n");

        // Agregar información sobre los libros prestados, si los hay
        if (!librosPrestados.isEmpty()) {
            sb.append("Libros Prestados: ").append("\n");
            for (String libroPrestado : librosPrestados) {
                sb.append("- ").append(libroPrestado).append("\n");
            }
        } else {
            sb.append("Libros Prestados: Ninguno\n");
        }

        System.out.println(sb.toString());
    }

}
