package Application;

import Application.Car_World.CarFactory;

import Application.Graphics.CarController;
import Application.Graphics.CarView;
import Application.Graphics.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Application {
    public ArrayList<Application.Car_World.Car> cars;

    public Application() {
        carController = new CarController();
        carView = new CarView("CarSim 1.0" , carController);

        try {
            volvoImage = ImageIO.read(Application.class.getResourceAsStream("pics/Volvo240.jpg"));
            saabImage = ImageIO.read(Application.class.getResourceAsStream("pics/Saab95.jpg"));
            scaniaImage = ImageIO.read(Application.class.getResourceAsStream("pics/Scania.jpg"));

            volvoWorkshopImage = ImageIO.read(Application.class.getResourceAsStream("pics/VolvoBrand.jpg"));
        } catch (IOException ex)
        {
            ex.printStackTrace();
        }

        GUIcomponents.add(new GUIcomponent(CarFactory.createSaab95(),carView.saabImage,new Point(0,0)));
        GUIcomponents.add(new GUIcomponent(CarFactory.createScania(),scaniaImage,new Point(0,0)));
        GUIcomponents.add(new GUIcomponent(CarFactory.createVolvo240(),volvoImage,new Point(0,0)));
    }

    public static void main(String[] args) {

        Application application = new Application();
        application.GUIcomponents.get(1).setY(100);
        application.GUIcomponents.get(2).setY(250);

        // Start a new view and send a reference of self

        // Start the timer
        application.carController.getTimer().start();
    }

}
