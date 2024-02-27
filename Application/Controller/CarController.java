package Application.Controller;

import Application.Car_World.*;



/*
 * This class represents the Controller part in the MVC pattern.
 * It's responsibilities is to listen to the View and responds in a appropriate manner by
 * modifying the model state and the updating the view.
 */

public class CarController {
    private final CarWorld model;

    public CarController(CarWorld model) {
        this.model = model;
    }
    public void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Car car: model.getCarsList()) {
            car.gas(gas);
        }
    }
    public void brake(int amount){
        double brake = ((double) amount) / 100;
        for (Car car: model.getCarsList()) {
            car.brake(brake);
        }
    }
    public void startAllCars(){
        for (Car car: model.getCarsList()) {
            car.startEngine();
        }
    }
    public void stopAllCars(){
        for (Car car: model.getCarsList()) {
            car.stopEngine();
        }
    }
    public void turboOn(){
        for (Car car: model.getCarsList()) {
            if(car instanceof HasTurbo){
                ((HasTurbo) car).setTurboOn();
            }
        }
    }
    public void turboOff(){
        for (Car car : model.getCarsList()) {
            if(car instanceof HasTurbo ){
                ((HasTurbo) car).setTurboOff();
            }
        }

    }
    public void truckBedDown(){
        for (Car car: model.getCarsList()) {
            if(car instanceof HasTruckBed){
                ((HasTruckBed) car).lowerTruckBed();
            }
        }
    }
    public void truckBedUp(){
        for (Car car: model.getCarsList()) {
            if(car instanceof HasTruckBed){
                ((HasTruckBed) car).raiseTruckBed();
            }
        }
    }
    public void addCar() {
        if(model.getCarsList().size() <= 10) {
            model.addCar(CarFactory.createVolvo240(0, 400));
            System.out.println(model.getCarsList().toString());
        }
    }
    public void removeCar() {
        if(!model.getCarsList().isEmpty()) {
            model.getCarsList().removeLast();
        }
    }
}