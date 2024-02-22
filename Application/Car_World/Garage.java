package Application.Car_World;

import java.awt.*;
import java.util.List;

public class Garage<T extends Car>{

    private final int capacity;
    private final Point point;
    private final String name;
    String imageSource;
    private final CarInventory<T> carInventory;

    public Garage(int capacity){
        imageSource="pics/VolvoBrand.jpg";
        point = new Point(10,10);
        this.capacity = capacity;
        name = "Pimp my ride";
        carInventory = new CarInventory<T>(capacity);
    }
    public Point getPoint(){
        return point;
    }
    public List<T> getCarInventory(){
        return carInventory.getInventory();
    }

    public void addCar(T car){
        carInventory.add(car);
    }
    public String getImageSource(){return imageSource;}

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
