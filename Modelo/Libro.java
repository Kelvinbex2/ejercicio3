package Modelo;

import java.sql.Date;

public class Libro implements MaterialBiblio{
    private String titulo;
    private String autor;
    private Date FechaPub;
    private String id;

    public Libro(String titulo, String autor, Date fechaPub, String id) {
        this.titulo = titulo;
        this.autor = autor;
        FechaPub = fechaPub;
        this.id = id;
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

    public Date getFechaPub() {
        return FechaPub;
    }

    public void setFechaPub(Date fechaPub) {
        FechaPub = fechaPub;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
