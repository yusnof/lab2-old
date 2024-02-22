package Application;

import Application.Car_World.*;
import Application.Graphics.CarController;
import Application.Graphics.CarView;


import java.util.ArrayList;


public class Application {
    public CarController carController;
    public CarView carView;
    public CarWorld carWorld;

    public Application() {
        carWorld = new CarWorld();
        carController = new CarController(carWorld);
        carView = new CarView("CarSim 1.0" , carController);

    }

    public static void main(String[] args) {

        Application application = new Application();

        // Start a new view and send a reference of self

        // Start the timer
        application.carController.getTimer().start();
    }

}
