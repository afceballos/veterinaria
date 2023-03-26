package veterinaria;

import veterinaria.clases.Cliente;
import veterinaria.clases.Mascota;
import veterinaria.clases.Servicio;
import veterinaria.clases.Veterinaria;

import javax.swing.*;

public class ApplicationVeterinaria {
    public static void main(String[] args) {

        // Creamos un objeto de la clase Veterinaria
        Veterinaria veterinaria = new Veterinaria();
        int select = -1;
        while (select != 0) {
            try {
                // Menu principal
                String opcion;

                opcion = JOptionPane.showInputDialog("Bienvenido a la Veterinaria. ¿Qué desea hacer?\n\n"
                        + "1. Registrar clientes\n"
                        + "2. Registrar mascota\n"
                        + "3. Agregar servicio a una mascota\n"
                        + "4. Mostrar información de un cliente\n"
                        + "5. Mostrar información de una mascota\n"
                        + "6. Calcular precio total de los servicios de una mascota\n"
                        + "7. Calcular precio total de los servicios de un cliente\n"
                        + "0. Salir");

                select = Integer.parseInt(opcion);

                switch (opcion) {
                    case "1":// Registro de nuevo cliente

                        String nombreCliente = JOptionPane.showInputDialog("Ingrese el nombre del cliente:");
                        String direccionCliente = JOptionPane.showInputDialog("Ingrese la dirección del cliente:");
                        String telefonoCliente = JOptionPane.showInputDialog("Ingrese el teléfono del cliente:");

                        // Creamos un objeto Cliente y lo agregamos a la lista de clientes de la veterinaria
                        Cliente cliente = new Cliente(nombreCliente, direccionCliente, telefonoCliente);
                        veterinaria.agregarCliente(cliente);

                        JOptionPane.showMessageDialog(null, "Cliente registrado correctamente.");
                        break;

                    case "2":// Agregar una mascota

                        String clienteName = JOptionPane.showInputDialog("Ingrese el nombre del cliente para agregar su mascota:");

                        Cliente clienteaddMascota = veterinaria.buscarCliente(clienteName);

                        if (clienteaddMascota == null) {
                            JOptionPane.showMessageDialog(null, "Cliente no encontrado");
                        } else {

                            // Registro de nueva mascota
                            String nombreMascota = JOptionPane.showInputDialog("Ingrese el nombre de la mascota:");
                            String tipoMascota = JOptionPane.showInputDialog("Ingrese el tipo de mascota (por ejemplo, perro, gato, ave, etc.):");
                            String edadMascotaString = JOptionPane.showInputDialog("Ingrese la edad de la mascota:");
                            int edadMascota = Integer.parseInt(edadMascotaString);

                            // Creamos un objeto Mascota y lo agregamos a la lista de mascotas del cliente de la veterinaria
                            Mascota mascota = new Mascota(nombreMascota, edadMascota, tipoMascota);
                            clienteaddMascota.agregarMascota(mascota);

                            JOptionPane.showMessageDialog(null, "Mascota registrada correctamente.");
                        }
                        break;


                    case "3":// Agregar servicio a una mascota

                        String nombreMascotaServicio = JOptionPane.showInputDialog("Ingrese el nombre de la mascota a la que desea agregar el servicio:");

                        // Buscamos que exista el nombre de la mascota
                        Mascota mascotaAddServicio = veterinaria.buscarMascota(nombreMascotaServicio);

                        if (mascotaAddServicio == null) {
                            JOptionPane.showMessageDialog(null, "Mascota no encontrada");
                        } else {
                            String tipoServicio = JOptionPane.showInputDialog("Ingrese el tipo de servicio que desea agregar (por ejemplo, consulta, vacunación, peluquería, etc.):");
                            String precioServicioString = JOptionPane.showInputDialog("Ingrese el precio del servicio:");
                            double precioServicio = Double.parseDouble(precioServicioString);

                            // Buscamos la mascota a la que se le va a agregar el servicio
                            Mascota mascotaServicio = veterinaria.buscarMascota(nombreMascotaServicio);
                            // Creamos un objeto Servicio y lo agregamos a la lista de servicios de la mascota correspond
                            Servicio servicio = new Servicio(tipoServicio, precioServicio);
                            mascotaServicio.agregarServicio(servicio);
                            JOptionPane.showMessageDialog(null, "Servicio registrada correctamente.");
                        }
                        break;

                    case "4":// Mostrar información de un cliente

                        String nombreClienteInfo = JOptionPane.showInputDialog("Ingrese el nombre del cliente:");

                        //Buscamos que exista informacion del cliente
                        Cliente clienteInfo = veterinaria.buscarCliente(nombreClienteInfo);

                        if (clienteInfo == null) {
                            JOptionPane.showMessageDialog(null, "Cliente no encontrado");
                        } else {
                            String mensaje = "Información del cliente:\n";
                            mensaje += "Nombre: " + clienteInfo.getNombre() + "\n";
                            mensaje += "Dirección: " + clienteInfo.getDireccion() + "\n";
                            mensaje += "Teléfono: " + clienteInfo.getTelefono() + "\n";
                            for (Mascota mascotacliente : clienteInfo.getMascotas()) {
                                mensaje += "Mascota:\n";
                                mensaje += "- Nombre: " + mascotacliente.getNombre() + "\n";
                                mensaje += "- Edad: " + mascotacliente.getEdad() + "\n";
                                mensaje += "- Tipo: " + mascotacliente.getTipo() + "\n";
                                for (Servicio servicioMascota : mascotacliente.getServicios()) {
                                    mensaje += "  Servicio:\n";
                                    mensaje += "  - Tipo: " + servicioMascota.getTipo() + "\n";
                                    mensaje += "  - Precio: " + servicioMascota.getPrecio() + "\n";
                                }
                            }
                            JOptionPane.showMessageDialog(null, mensaje);
                        }
                        break;
                    case "5":// Mostrar mascotas de un cliente

                        String nombreClienteMascota = JOptionPane.showInputDialog("Ingrese el nombre del cliente:");

                        //Buscamos que exista informacion del cliente
                        Cliente MascotaCliente = veterinaria.buscarCliente(nombreClienteMascota);

                        if (MascotaCliente == null) {
                            JOptionPane.showMessageDialog(null, "Cliente no encontrado");
                        } else {
                            //Mostrar nombre de las mascotas del cliente
                            String mensaje = "Mascotas del cliente " + MascotaCliente.getNombre() + ":\n";
                            for (Mascota mascotaCliente : MascotaCliente.getMascotas()) {
                                mensaje += " - Nombre: " + mascotaCliente.getNombre() + "\n";
                            }
                            mensaje += "Ingrese el nombre de la mascota::\n";

                            String mascotaNombre = JOptionPane.showInputDialog(mensaje);

                            // Buscamos que exista el nombre de la mascota
                            Mascota mascotaExist = veterinaria.buscarMascota(mascotaNombre);

                            if (mascotaExist == null) {
                                JOptionPane.showMessageDialog(null, "Mascota no encontrada");
                            } else {

                                String mensajeFinal = "Mascota del cliente " + MascotaCliente.getNombre() + ":\n";
                                mensajeFinal += "- Nombre: " + mascotaExist.getNombre() + "\n";
                                mensajeFinal += "  Edad: " + mascotaExist.getEdad() + "\n";
                                mensajeFinal += "  Tipo: " + mascotaExist.getTipo() + "\n";
                                mensajeFinal += "  Servicios:\n";
                                for (Servicio serviciocliente : mascotaExist.getServicios()) {
                                    mensajeFinal += "  - Tipo: " + serviciocliente.getTipo() + "\n";
                                    mensajeFinal += "    Precio: " + serviciocliente.getPrecio() + "\n";
                                }

                                JOptionPane.showMessageDialog(null, mensajeFinal);
                            }
                        }
                        break;
                    case "6":// Calcular precio total de los servicios de una mascota

                        String mascotaNombre = JOptionPane.showInputDialog("Ingrese el nombre de la mascota:");

                        // Buscamos que exista el nombre de la mascota
                        Mascota mascotaExist = veterinaria.buscarMascota(mascotaNombre);

                        if (mascotaExist == null) {
                            JOptionPane.showMessageDialog(null, "Mascota no encontrada");
                        } else {
                            //Calculamos el precio de una mascota
                            double precioTotal = veterinaria.calcularPrecioTotalMascota(mascotaExist);

                            String mensaje = "El precio total de los servicios de la mascota " + mascotaExist.getNombre() + " es $" + precioTotal;
                            JOptionPane.showMessageDialog(null, mensaje);
                        }
                        break;
                    case "7":// Calcular precio total de los servicios de una mascota

                        String clienteNombre = JOptionPane.showInputDialog("Ingrese el nombre del cliente:");

                        // Buscamos que exista el nombre de la mascota
                        Cliente clienteExist = veterinaria.buscarCliente(clienteNombre);

                        if (clienteExist == null) {
                            JOptionPane.showMessageDialog(null, "Mascota no encontrada");
                        } else {
                            // calculamos el precio total del cliente
                            double precioTotalCliente = veterinaria.calcularPrecioTotalCliente(clienteExist);

                            String mensaje = "El precio total de los servicios del cliente " + clienteExist.getNombre() + " es $" + precioTotalCliente;
                            JOptionPane.showMessageDialog(null, mensaje);
                        }
                        break;
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Upps! Error!");
            }
        }
    }
}