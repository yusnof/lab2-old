package Application.Graphics;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import Application.Application;
import Application.Car_World.Garage;
import Application.Car_World.GarageFactory;
import Application.Car_World.CarFactory;
import Application.Graphics.CarView;



/*
 * This class represents the Controller part in the MVC pattern.
 * It's responsibilities is to listen to the View and responds in a appropriate manner by
 * modifying the model state and the updating the view.
 */

public class CarController {
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with a listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());



    // The frame that represents this instance View of the MVC pattern
    CarView frame;
    // A list of cars, modify if needed
     ArrayList<Application.Car_World.Car> cars = new ArrayList<>();
     Garage garage = GarageFactory.createGarage(100);
    //methods:




    /* Each step the TimerListener moves all the cars in the list and tells the
     * view to update its images. Change this method to your needs.
     * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            for (int i =0 ; i < cars.size(); i ++) {
                cars.get(i).move();
                int x = (int) Math.round(cars.get(i).getX());
                int y = (int) Math.round(cars.get(i).getY());
                frame.drawPanel.moveit(x, y, i);
                if(cars.get(i).getClass()== Application.Car_World.Volvo240.class){
                    if (distanceToWorkshop(cars.get(i)) <= 50) {
                        removeCarAddToGarage(cars.get(i), workShop);
                    }
                }
                // repaint() calls the paintComponent method of the panel
                frame.drawPanel.repaint();
                if (x  >= frame.getBounds().width - 100 || x <= -1){
                    cars.get(i).currentSpeed = -(cars.get(i).currentSpeed);
                }
            }
        }
    }

    public Timer getTimer (){
        return timer;
    }
    //TODO Replace with other code
    /*int distanceToWorkshop(Car car){
        double x = frame.drawPanel.volvoWorkshopPoint.x - car.getX() ;
        double y = frame.drawPanel.volvoWorkshopPoint.x - car.getY();
        return (int) Math.sqrt(Math.pow(x,2) + Math.pow(y,2));
   }*/
   void removeCarAddToGarage(Car car, Garage garage) {
        cars.remove(car);
        garage.addCar(car);
   }

    // Calls the gas method for each car once
    void gas(List<Application.GUIcomponent> cars , int amount) {
        double gas = ((double) amount) / 100;
        for (Application.GUIcomponent g : cars) {
            g.thing.gas(gas);
        }
    }
    void brake(int amount){
        double brake = ((double) amount) / 100;
        for (Car car : cars) {
            car.brake(brake);
        }
    }
    void startAllCars(){
        for (Car car : cars) {
            car.startEngine();
        }
    }
    void stopAllCars(){
        for (Car car : cars) {
            car.stopEngine();
        }
    }
    void turboOn(){
        for (Car car : cars) {
            if(car.getClass() == Saab95.class){
                ((Saab95) car).setTurboOn();
            }
        }

    }
    void turboOff(){
        for (Car car : cars) {
            if(car.getClass() == Saab95.class){
                ((Saab95) car).setTurboOff();
            }
        }

    }
    void truckBedDown(){
        for (Car car : cars) {
            if(HasTruckBed.class.isAssignableFrom(car.getClass())){
                System.out.println(car.getClass());
                ((HasTruckBed) car).lowerTruckBed();
            }
        }

    }
    void truckBedUp(){
        for (Car car : cars) {
            if(HasTruckBed.class.isAssignableFrom(car.getClass())){
                ((HasTruckBed) car).raiseTruckBed();
            }
        }
    }
}