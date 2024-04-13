package Modelo;

public class Revista implements MaterialBiblio {
    private String titulo;
    private String editor;
    private int numeroEdicion;

    public Revista(String titulo, String editor, int numeroEdicion) {
        this.titulo = titulo;
        this.editor = editor;
        this.numeroEdicion = numeroEdicion;
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



    @Override
    public void verSinopsis() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'verSinopsis'");
    }

    @Override
    public void prestar() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'prestar'");
    }


}
