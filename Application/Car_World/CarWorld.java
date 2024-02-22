package Application.Car_World;

import Application.Car_World.Car;
import Application.Car_World.Volvo240;

import java.util.ArrayList;
import java.util.List;

import static java.awt.geom.Point2D.distance;

public class CarWorld {
    List<Car> cars = new ArrayList<>();
    public Garage<Volvo240> garage; //hardcodat ;)  ¯\_(ツ)_/¯ (.)
    public List<ModelUpdateListener> listeners = new ArrayList<>();
    private int XBound;
    private int YBound;

    public CarWorld(int XBound ,int YBound){
        this.XBound = XBound;
        this.YBound = YBound;

        garage = new Garage<>(10);
    }
   public void update() {
        while (true) {
            for (Car car : cars) {
                car.move();
                if (car.getClass() == Volvo240.class) {
                    if (distanceToWorkshop(car) <= 50) {
                        //removeCarAddToGarage(car); TODO FIX
                    }
                }
                if(carOutOfBounds(car)) {
                    reverseSpeed(car);
                }
            }
            notifyListeners();
        }
    }
    boolean carOutOfBounds(Car car) {
        int x= car.getPosition().x;
        int y= car.getPosition().y;
        if(x>=XBound || x<=0 || y>= YBound || y<=0) {
            return true;
        }
        else{
            return false;
        }
    }
    public int distanceToWorkshop(Car car){
        return (int) garage.getPoint().distance(car.getPosition());
    }
    public void removeCarAddToGarage(Car car){
        cars.remove(car);
        garage.addCar((Volvo240) car);
    }
    void notifyListeners() {
        for(ModelUpdateListener l: listeners) {
            l.actOnModelUpdate();
        }
    }
   public void addListener(ModelUpdateListener l) {
        listeners.add(l);
    }
    public void addCar(Car car) {
       cars.add(car);
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
