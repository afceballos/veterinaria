package veterinaria.clases;

import java.util.ArrayList;

public class Cliente {
    private String nombre;
    private String direccion;
    private String telefono;
    private ArrayList<Mascota> mascotas;

    public Cliente(String nombre, String direccion, String telefono) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.mascotas = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void agregarMascota(Mascota mascota) {
        mascotas.add(mascota);
    }

    public ArrayList<Mascota> getMascotas() {
        return mascotas;
    }
}