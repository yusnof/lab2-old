package Application.Car_World;

public class CarFactory {
    public static Car createVolvo240() {
        return new Volvo240();
    }
    public static Car createSaab95() {
        return new Saab95();
    }
    public static Car createCarTransport() {
        return new CarTransport();
    }
    public static Car createScania() {
        return new Scania();
    }
}
