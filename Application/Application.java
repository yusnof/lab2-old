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
    private final int delay = 50;
    private Timer timer = new Timer(delay, new Application.TimerListener());

    public Application() {
        int X=800;
        int Y=800;

        carWorld = Application.createModel(X,Y);
        carController = new CarController(carWorld);
        carView = new CarView("CarSim 1.0" , carController,X,Y);

        carWorld.addListener(carView);
    }

    public static CarWorld createModel(int x, int y) {
        CarWorld cars = new CarWorld(x, y);

        cars.addCar(CarFactory.createVolvo240());
        cars.addCar(CarFactory.createSaab95());
        cars.addCar(CarFactory.createVolvo240());

        return cars;
    }
    public static void main(String[] args) {

        Application application = new Application();


        // Start a new view and send a reference of self

        // Start the timer
        application.timer.start();
    }
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            carWorld.update();

        }
    }
}
