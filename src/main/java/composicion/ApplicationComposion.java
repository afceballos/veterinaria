package composicion;

public class ApplicationComposion {

    public static void main(String[] args) {
        Auto auto = new Auto();

        auto = null;

        System.out.println(auto.getMotor());
    }

}
