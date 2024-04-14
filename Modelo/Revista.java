package Modelo;
import java.util.ArrayList;
import java.util.List;

import Entradas.Entrada;

public class Revista implements MaterialBiblio {
    private String titulo;
    private String editor;
    private int numeroEdicion;
    private int contardorRev;
    private List<String> revPrestados;

    


   


    public Revista(String titulo, String editor, int numeroEdicion) {
        this.titulo = titulo;
        this.editor = editor;
        this.numeroEdicion = numeroEdicion;
        contardorRev++;
        revPrestados=new ArrayList<>();
    }

   
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }

    public int getNumeroEdicion() {
        return numeroEdicion;
    }

    public void setNumeroEdicion(int numeroEdicion) {
        this.numeroEdicion = numeroEdicion;
    }

    public int getContardorRev() {
        return contardorRev;
    }


    public void setContardorRev(int contardorRev) {
        this.contardorRev = contardorRev;
    }
    public List<String> getRevPrestados() {
        return revPrestados;
    }


    public void setRevPrestados(List<String> revPrestados) {
        this.revPrestados = revPrestados;
    }



    @Override
    public void verSinopsis() {
        String msg = Entrada.leerString();
        if (msg.startsWith("Habla") && msg.length()==20) {
            StringBuilder sb = new StringBuilder();
            sb.append("El autor " + getEditor()).append(" " + msg);
            System.out.println(sb);
        }

    }

    @Override
    public void prestar() {
        if (contardorRev!=0) {
            System.out.println("Hay " + contardorRev +  "Revistas");

            System.out.println("El titulo de revista al prestar");
            String titulos = Entrada.leerString();
           

            if (titulo.equals(titulos)) {
                contardorRev--;
                revPrestados.add(titulos);
                System.out.println("Revista prestado");
            }else{
                System.out.println("El titulo no coincide");
            }

        }else{
            System.out.println("No hay Revista disponibles");
        }

        
        
    }


}
