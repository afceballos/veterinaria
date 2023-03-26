package agregacion;

import java.util.ArrayList;
import java.util.List;

public class ApplicationAgregacion {

    public static void main(String[] args) {

        Estudiante estudiante = new Estudiante("Pepe", 23);
        List<Estudiante> estudiantes = new ArrayList<>();
        estudiantes.add(estudiante);

        Universidad universidad = new Universidad(estudiantes);
        universidad = null;

        for (Estudiante estudiante1: estudiantes) {
            System.out.println(estudiante1.getNombre());
        }

    }

}
