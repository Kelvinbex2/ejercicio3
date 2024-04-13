package Modelo;

import java.util.ArrayList;

public class Usuario extends Personal {
    private String id;
    private ArrayList<MaterialBiblio>librosPrest;

    public Usuario(String nombre, String fechNac, String tipo,String id, ArrayList<MaterialBiblio> librosPrest) {
        super(nombre, fechNac, tipo);
       this.id= id;
       this.librosPrest= new ArrayList<>();
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


    public void devolverLibro(Libro libro){

       

        
        
    }
   
    
}
