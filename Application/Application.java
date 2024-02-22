package Application;

import Application.Car_World.*;
import Application.Graphics.CarController;
import Application.Graphics.CarView;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Application {
    public CarController carController;
    public CarView carView;
    public CarWorld carWorld;


    public Application() {
        int X=800;
        int Y=800;

        carWorld = Application.createModel(X,Y);
        carController = new CarController(carWorld);
        carView = new CarView("CarSim 1.0" , carController,X,Y, carWorld);

        carWorld.addListener(carView);
    }

    public static CarWorld createModel(int x, int y) {
        CarWorld cars = new CarWorld(x, y);

        cars.addCar(CarFactory.createVolvo240());
        cars.addCar(CarFactory.createSaab95());
        cars.addCar(CarFactory.createScania());

        return cars;
    }
    public static void main(String[] args) {

        Application application = new Application();

        while(true) {
            try {
                Thread.sleep(50);
                application.carWorld.update();
                System.out.println(application.carWorld.getCarsList().getFirst().getPosition().x + " " + application.carWorld.getCarsList().getFirst().getPosition().y);
            }
            catch (Exception e) {
                System.out.println(e);
            }
        }

    }

}
