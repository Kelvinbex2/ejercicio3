package Modelo;


import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Usuario extends Personal {
    private String id;
    private ArrayList<Libro> librosPrest;
    
public Usuario(){
    super("", "", "");
    librosPrest = new ArrayList<>();
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

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String fechaFormateada = fechNac.formatted(formatter);

        return idNombre + "-" + fechaFormateada;
    }

    

  

    @Override
    public void detalle(){
        System.out.println("\tUsuario: ");
        System.out.println("Nombre: " + getNombre());
        System.out.println("FechaNac: " + getFechNac());
        System.out.println("Tipo: " + getTipo());
        System.out.println("Id : " + id);
        
        
    }
}
