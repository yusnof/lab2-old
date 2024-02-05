import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Garage<T extends Car>{

    private final int capacity;
    private final String name;
    private final CarInventory<T> carInventory;

    public Garage(int capacity){
        this.capacity = capacity;
        name = "Pimp my ride";
        carInventory = new CarInventory<T>(capacity);
    }
    public List<T> getCarInventory(){
        return carInventory.getInventory();
    }

    public void addCar(T car){
        carInventory.add(car);
    }

    public void pimpAllCars (){
        for(T car: carInventory.getInventory()) {
            car.modelName += "BromBrom";
            car.setColor(Color.MAGENTA);
            car.enginePower += 1000;
        }
    }
    public void removeCar(T car){
        if (!carInventory.getInventory().isEmpty()) {
            this.carInventory.remove(car);
        }
    }
}
