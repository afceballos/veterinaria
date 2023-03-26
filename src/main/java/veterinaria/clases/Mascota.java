package veterinaria.clases;

import java.util.ArrayList;

public class Mascota {
    private String nombre;
    private int edad;
    private String tipo;
    private ArrayList<Servicio> servicios;

    public Mascota(String nombre, int edad, String tipo) {
        this.nombre = nombre;
        this.edad = edad;
        this.tipo = tipo;
        this.servicios = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public String getTipo() {
        return tipo;
    }

    public void agregarServicio(Servicio servicio) {
        servicios.add(servicio);
    }

    public ArrayList<Servicio> getServicios() {
        return servicios;
    }
}