package Application.Car_World;

import java.util.ArrayList;
import java.util.List;

public class CarWorld {
    List<Car> cars = new ArrayList<>();
    public Garage<Volvo240> garage; //hardcodat ;)  ¯\_(ツ)_/¯ (.)



    public CarWorld(){
        cars.add(CarFactory.createVolvo240());
        cars.add(CarFactory.createSaab95()) ;
        cars.add(CarFactory.createScania());

        garage = new Garage<>(10);
    }
    public void addCar() {
        if (cars.size() < 10) {
            cars.add(CarFactory.createVolvo240());
        }
    }
    public void removeCar(){
        if (!cars.isEmpty()){
            cars.removeLast();
        }
    }
}
