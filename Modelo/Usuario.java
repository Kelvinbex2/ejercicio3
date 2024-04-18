package Modelo;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Usuario extends Personal {
    private String id;
    private ArrayList<Libro> librosPrest;
    

    public Usuario() {
        super("", "", "");
        this.librosPrest = new ArrayList<>();
    
    }

    public Usuario(String nombre, String fechNac, String tipo) {
        super(nombre, fechNac, tipo);
        this.id = generarIdentificador();
        this.librosPrest = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ArrayList<Libro> getLibrosPrest() {
        return librosPrest;
    }

    public void setLibrosPrest(ArrayList<Libro> librosPrest) {
        this.librosPrest = librosPrest;
    }

    public String generarIdentificador() {
        String[] nombresGen = nombre.split(" ");
        String id = nombresGen[nombresGen.length - 1];
        String idNombre = id.substring(0, Math.min(id.length(), 4)).toUpperCase();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyMMdd");
        String fechaFormateada = fechNac.formatted(formatter);

        return idNombre + "-" + fechaFormateada;
    }

    

  

    @Override
    public String toString() {
        return "Usuario [nombre=" + nombre + ", fechNac=" + fechNac + ", id=" + id + ", tipo=" + tipo + ", librosPrest="
                + librosPrest + "]";
    }

}
