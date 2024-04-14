package Modelo;

import java.util.ArrayList;
import java.util.List;
import Entradas.Entrada;

public class Biblioteca {
    private String nombre;
    private String calle;

    private List<MaterialBiblio> listaMaterialBiblios;
    private List<Usuario> lUsuarios;
    private List<Personal> personals;

    public Biblioteca(String nombre, String calle) {
        this.listaMaterialBiblios = new ArrayList<>();
        this.lUsuarios = new ArrayList<>();
        this.personals = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
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

    public List<Personal> getPersonals() {
        return personals;
    }

    public void setPersonals(List<Personal> personals) {
        this.personals = personals;
    }

    public int elegir() {
        int num = 0;
        System.out.println("Que personal quieres aniadir");
        System.out.println("1. Usuario");
        System.out.println("2. Autor");
        System.out.print("Elege: ");
        num = Entrada.leerEntero();
        return num;
    }

    public void crearPersonal() {
        int num = elegir();
        System.out.print("Nombre: ");
        String nombre = Entrada.leerString();

        System.out.println("Fecha Nacimiento (formato: dd-MM-yyyy): ");
        String fechNac = Entrada.leerString();

        System.out.print("Tipo (Usuario/Autor): ");
        String tipo = Entrada.leerString();

        if (num == 1 && tipo.equalsIgnoreCase("Usuario")) {
            Personal usuPersonal = new Usuario(nombre, fechNac, tipo);
            personals.add(usuPersonal);
        } else if (num == 2 && tipo.equalsIgnoreCase("Autor")) {
            Personal auPersonal = new Autor(nombre, fechNac, tipo);
            personals.add(auPersonal);
        } else {
            System.out.println("Error");
        }

    }
}
