package Modelo;

public class Personal {
    private String nombre;
    private String fechNac;
    private String tipo;

   

    public Personal(String nombre, String fechNac, String tipo) {
        this.nombre = nombre;
        this.fechNac = fechNac;
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFechNac() {
        return fechNac;
    }

    public void setFechNac(String fechNac) {
        this.fechNac = fechNac;
    }

}
