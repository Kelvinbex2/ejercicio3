package Modelo;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class Usuario extends Personal  {
    private String id;
    private ArrayList<MaterialBiblio> librosPrest;

    public Usuario() {
        super("","","");
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

    public ArrayList<MaterialBiblio> getLibrosPrest() {
        return librosPrest;
    }

    public void setLibrosPrest(ArrayList<MaterialBiblio> librosPrest) {
        this.librosPrest = librosPrest;
    }

   

    public String generarIdentificador() {
        String[] nombresGen = nombre.split(" ");
        String id = nombresGen[nombresGen.length - 1];
        String idNombre = id.substring(0, Math.min(id.length(), 4)).toUpperCase();

        SimpleDateFormat format = new SimpleDateFormat("yy-MM-dd");
        String fecString = format.format(fechNac);
        return idNombre + "-" + fecString;
    }

    public void devolverLibro() {
        System.out.println("Libros prestados: ");
        for (MaterialBiblio string : librosPrest) {

            System.out.println("-" + string);

        }

        for (MaterialBiblio libro : librosPrest) {
            if (librosPrest.isEmpty()) {
                System.out.println("no hay libro para devolver");
            }

            System.out.println("Escribe el libro a devolver ");
            String libroPrestadosAux = Entrada.leerString();
            if (libroPrestadosAux.equalsIgnoreCase(libroPrestadosAux)) {
                System.out.println("Se ha devuelto el libro: " + libro);
            } else {
                System.out.println("No hay libro ");
            }
        }

    }





    @Override
    public String toString() {
        return "Usuario [nombre=" + nombre + ", fechNac=" + fechNac + ", id=" + id + ", tipo=" + tipo + ", librosPrest="
                + librosPrest + "]";
    }

    

    


}
