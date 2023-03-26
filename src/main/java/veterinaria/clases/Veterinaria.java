package veterinaria.clases;

import java.util.ArrayList;

public class Veterinaria {
    private ArrayList<Cliente> clientes;

    public Veterinaria() {
        this.clientes = new ArrayList<>();
    }

    public void agregarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }



    public Cliente buscarCliente(String nombreCliente) {
        for (Cliente cliente : clientes) {
            if (cliente.getNombre().equalsIgnoreCase(nombreCliente)) {
                return cliente;
            }
        }
        return null;
    }

    public Mascota buscarMascota(String nombreMascota) {
        for (Cliente cliente : clientes) {
            for (Mascota mascota : cliente.getMascotas()) {
                if (mascota.getNombre().equalsIgnoreCase(nombreMascota)) {
                    return mascota;
                }
            }
        }
        return null;
    }

    public double calcularPrecioTotalMascota(Mascota mascota) {
        double precioTotal = 0;
        for (Servicio servicio : mascota.getServicios()) {
            precioTotal += servicio.getPrecio();
        }
        return precioTotal;
    }

    public double calcularPrecioTotalCliente(Cliente cliente) {
        double precioTotal = 0;
        for (Mascota mascota : cliente.getMascotas()) {
            precioTotal += calcularPrecioTotalMascota(mascota);
        }
        return precioTotal;
    }
}