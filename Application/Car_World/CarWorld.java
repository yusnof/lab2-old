package Application.Car_World;

import Application.Car_World.Car;
import Application.Car_World.Volvo240;

import java.util.ArrayList;
import java.util.List;

import static java.awt.geom.Point2D.distance;

public class CarWorld {
    List<Car> cars = new ArrayList<>();
    public Garage<Volvo240> garage; //hardcodat ;)  ¯\_(ツ)_/¯ (.)
    public List<ModelUpdateListener> listeners;

    public CarWorld(){
        cars.add(CarFactory.createVolvo240());
        cars.add(CarFactory.createSaab95()) ;
        cars.add(CarFactory.createScania());

        garage = new Garage<>(10);
    }

    void gameLoop() {
        for (Car car: cars) {
            car.move();
            int x = (int) Math.round(car.getPosition().x);
            int y = (int) Math.round(car.getPosition().y);
            // frame.drawPanel.moveit(x, y, i);
            if (cars.getClass() == Application.Car_World.Volvo240.class) {
                if (distance(garage.getPoint().x,car.position.x,garage.getPoint().y,car.position.y) <= 50) {
                    removeCarAddToGarage(car);
                }
            }
        }
    }
    public int distanceToWorkshop(Car car){
        return (int) garage.getPoint().distance(car.getPosition());
    }
    public void removeCarAddToGarage(Car car){
        cars.remove(car);
        garage.addCar((Volvo240) car);
    }


    void notifyListener() {
        for(ModelUpdateListener l: listeners) {
            l.actOnModelUpdate();
        }
    }
   public void addListener(ModelUpdateListener l) {
        listeners.add(l);
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
    public List<Car> getCarsList() {
        return cars;
    }
    public void reverseSpeed(Car car){
        car.setCurrentSpeed((int)-car.getCurrentSpeed());
    }
}
