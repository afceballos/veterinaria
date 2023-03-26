package veterinaria.clases;

public class Servicio {
    private String tipo;
    private double precio;

    public Servicio(String tipo, double precio) {
        this.tipo = tipo;
        this.precio = precio;
    }

    public String getTipo() {
        return tipo;
    }

    public double getPrecio() {
        return precio;
    }
}