package Application.Car_World;

import java.awt.*;
import java.util.List;

class CarTransport extends Car implements HasTruckBed {

    private final CarInventory<Car> carInventory;
    private final TruckBed truckBed;

    public CarTransport() {
        weight = 10000;
        modelName = "Lorry";
        nrDoors = 2;
        enginePower = 1000;
        color = Color.YELLOW;
        carInventory = new CarInventory(10);
        truckBed = new TruckBed(true, 35000);
        stopEngine();
    }

    public List<Car> getCarInventory () {
        return carInventory.getInventory();
    }

    public TruckBed getTruckBed() {
        return truckBed;
    }

    public void addCar(Car car){
        if (currentSpeed == 0 && truckBed.isTruckBedDown() && car.getClass() != this.getClass() ){//&&  measureDistance(car,this)<=3 && isCapacityNotFull(car)) {
            carInventory.add(car);
            car.getPosition().x = this.getPosition().x;
            car.getPosition().y = this.getPosition().y;
        }
    }
    public void removeCar() {
        if(truckBed.isTruckBedDown()) {
            carInventory.getInventory().remove(0);
        }
    }

    public boolean isCapacityNotFull(Car car) {
        if (calculateLoad() + car.getWeight() <= truckBed.getmaxWeight() && carInventory.getInventory().size() < carInventory.getCapacity()) {
            return true;
        }
        else { return false; }
    }

    public int calculateLoad() {
        int load = 0;
        for (Car car : carInventory.getInventory()) {
            load += car.getWeight();
        }
        return load;
    }
    @Override
    public void move() {
        if(truckBed.isTruckBedDown()) {
            super.move();
            for (Car car : carInventory.getInventory()) {
                car.getPosition().x = this.getPosition().x;
                car.getPosition().y = this.getPosition().y;
            }
        }
    }

    @Override
    public void raiseTruckBed() {
        truckBed.setTruckBed(false);
    }

    @Override
    public void lowerTruckBed() {
        truckBed.setTruckBed(true);
    }
}
