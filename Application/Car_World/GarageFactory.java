package Application.Car_World;

public class GarageFactory {
    public static Garage createGarage(int capacity) {
        return new Garage(capacity);
    }
}
