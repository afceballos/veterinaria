package veterinaria.emuns;

public enum TipoLibro {

    FANTASIA(1, "Fantasía"),
    POLITICA(2, "Politica"),
    CIENCIA(3, "Ciencia"),
    TERROR(4, "Terror"),
    COMEDIA(5, "Comedia");

    private int id;
    private String nombre;

    TipoLibro(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }
}
