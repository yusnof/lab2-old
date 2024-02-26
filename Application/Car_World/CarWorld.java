package Application.Car_World;

import java.util.ArrayList;
import java.util.List;


public class CarWorld {
    List<Car> cars = new ArrayList<>();
    public Garage<Volvo240> garage; //hardcodat ;)  ¯\_(ツ)_/¯ (.)
    public List<ModelUpdateListener> listeners = new ArrayList<>();
    private int XBound;
    private int YBound;

    public CarWorld(int XBound ,int YBound){
        this.XBound = XBound;
        this.YBound = YBound;
    }
   public void update() {
       List<Car> foundCar = new ArrayList<>();
            for (Car car : cars) {
                car.move();
                if (car.getClass() == Volvo240.class) {
                    if (distanceToWorkshop(car) <= 50) {
                        foundCar.add(car);
                    }
                }
                if(carOutOfBounds(car)) {
                    reverseSpeed(car);
                }
            }
            cars.removeAll(foundCar);
            addCarsToGarage(foundCar);
            notifyListeners();
    }
    boolean carOutOfBounds(Car car) {
        int x = car.getPosition().x;
        int y = car.getPosition().y;
        if (x >=XBound || x <= -10 || y>= YBound || y<=-10) {
            return true;
        }
        else{
            return false;
        }
    }
    public int distanceToWorkshop(Car car){
        return (int) garage.getPoint().distance(car.getPosition());
    }
    public void addCarsToGarage(List<Car> foundCars){
        for(Car car: foundCars) {
            garage.addCar((Volvo240) car);
        }
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
