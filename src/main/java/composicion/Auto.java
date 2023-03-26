package composicion;

public class Auto {

    private Motor motor;
    private Transmision transmision;
    private Rueda[] ruedas;

    public Auto() {

        this.motor = new Motor();
        this.transmision = new Transmision();
        this.ruedas = new Rueda[4];
        for (int i = 0; i < ruedas.length; i++) {
            this.ruedas[i] = new Rueda();
        }

    }

    public Motor getMotor() {
        return motor;
    }

    public void setMotor(Motor motor) {
        this.motor = motor;
    }

    public Transmision getTransmision() {
        return transmision;
    }

    public void setTransmision(Transmision transmision) {
        this.transmision = transmision;
    }

    public Rueda[] getRuedas() {
        return ruedas;
    }

    public void setRuedas(Rueda[] ruedas) {
        this.ruedas = ruedas;
    }
}
