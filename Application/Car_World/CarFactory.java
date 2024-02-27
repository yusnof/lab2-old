package Application.Car_World;

public class CarFactory {
    public static Car createVolvo240() {
        return new Volvo240();
    }
    public static Car createSaab95(int x, int y) {
        return new Saab95(x, y);
    }
    public static Car createCarTransport() {
        return new CarTransport();
    }
    public static Car createScania(int x, int y) {
        return new Scania(x,y);
    }
}
