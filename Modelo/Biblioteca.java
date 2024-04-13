package Modelo;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private List<MaterialBiblio> listaMaterialBiblios;
    private List<Usuario> lUsuarios;

    public Biblioteca(List<MaterialBiblio> listaMaterialBiblios, List<Usuario> lUsuarios) {
        this.listaMaterialBiblios = new ArrayList<>();
        this.lUsuarios = new ArrayList<>();
    }

    public List<MaterialBiblio> getListaMaterialBiblios() {
        return listaMaterialBiblios;
    }

    public void setListaMaterialBiblios(List<MaterialBiblio> listaMaterialBiblios) {
        this.listaMaterialBiblios = listaMaterialBiblios;
    }

    public List<Usuario> getlUsuarios() {
        return lUsuarios;
    }

    public void setlUsuarios(List<Usuario> lUsuarios) {
        this.lUsuarios = lUsuarios;
    }
}
