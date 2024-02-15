package Application;

import Application.Car_World.CarFactory;

import java.util.ArrayList;

public class Application {
    public ArrayList<Application.Car_World.Car> cars;

    public Application() {
        cars.add(CarFactory.createVolvo240());
    }

}
