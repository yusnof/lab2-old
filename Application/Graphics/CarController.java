package Application.Graphics;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Application.Application;
import Application.Car_World.*;



/*
 * This class represents the Controller part in the MVC pattern.
 * It's responsibilities is to listen to the View and responds in a appropriate manner by
 * modifying the model state and the updating the view.
 */

public class CarController {
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    // The timer is started with a listener (see below) that executes the statements
    // each step between delays.

    private final CarWorld model;

    public CarController(CarWorld model) {
        this.model = model;
    }


    /* Each step the TimerListener moves all the cars in the list and tells the
     * view to update its images. Change this method to your needs.
     * */
    //TODO Replace with other code
    /*int distanceToWorkshop(Car car){
        double x = frame.drawPanel.volvoWorkshopPoint.x - car.getX() ;
        double y = frame.drawPanel.volvoWorkshopPoint.x - car.getY();
        return (int) Math.sqrt(Math.pow(x,2) + Math.pow(y,2));
   }*/
  /* void removeCarAddToGarage(Car car, Garage garage) {
        cars.remove(car);
        garage.addCar(car);
   } */

    // Calls the gas method for each car once
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Car car: model.getCarsList()) {
            car.gas(gas);
        }
    }
    void brake(int amount){
        double brake = ((double) amount) / 100;
        for (Car car: model.getCarsList()) {
            car.brake(brake);
        }
    }
    void startAllCars(){
        for (Car car: model.getCarsList()) {
            car.startEngine();
        }
    }
    void stopAllCars(){
        for (Car car: model.getCarsList()) {
            car.stopEngine();
        }
    }
    void turboOn(){
        for (Car car: model.getCarsList()) {
            if(car.getClass() == Saab95.class){
                ((Saab95) car).setTurboOn();
            }
        }
    }
    void turboOff(){
        for (Car car: model.getCarsList()) {
            if(car.getClass() == Saab95.class){
                ((Saab95) car).setTurboOff();
            }
        }

    }
    void truckBedDown(){
        for (Car car: model.getCarsList()) {
            if(HasTruckBed.class.isAssignableFrom(car.getClass())){
                System.out.println(car.getClass());
                ((HasTruckBed) car).lowerTruckBed();
            }
        }
    }
    void truckBedUp(){
        for (Car car: model.getCarsList()) {
            if(HasTruckBed.class.isAssignableFrom(car.getClass())){
                ((HasTruckBed) car).raiseTruckBed();
            }
        }
    }
    void addCar() {
        if(model.getCarsList().size() <= 10) {
            model.getCarsList().add(CarFactory.createVolvo240());
        }
    }
    void removeCar() {
        if(!model.getCarsList().isEmpty()) {
            model.getCarsList().removeLast();
        }
    }
}