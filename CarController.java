import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;import java.awt.*;


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
    ArrayList<GUIComponents> cars;
    //methods:
    public CarController(){
        cars=new ArrayList<>(3);
        cars.add(new GUIComponents(new Volvo240(),"pics/Volvo240.jpg",new Point(0,0)));
        cars.add(new GUIComponents(new Saab95(),"pics/Saab95.jpg",new Point(0,100)));
        cars.add(new GUIComponents(new Scania(),"pics/Scania.jpg",new Point(0,200)));
    }
    public ArrayList<GUIComponents> getCars() {
        return cars;
    }

    public static void main(String[] args) {
        // Instance of this class
         CarController cc = new CarController();

        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", cc);
        // Start the timer
        cc.timer.start();
    }
    /* Each step the TimerListener moves all the cars in the list and tells the
    * view to update its images. Change this method to your needs.
    * */

    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            for (GUIComponents car : cars) {
                car.getComponent().move();
                int x = (int) Math.round(car.getComponent().getX());
                int y = (int) Math.round(car.getComponent().getY());
                frame.drawPanel.moveit(x, y, car);
                // repaint() calls the paintComponent method of the panel
                frame.drawPanel.repaint();
            }
        }
    }

    // Calls the gas method for each car once
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (GUIComponents car : cars
                ) {
            car.getComponent().gas(gas);
        }
    }
    void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (GUIComponents car : cars
        ) {
            car.getComponent().brake(brake);
        }
    }
    void startAllCars() {
        for(GUIComponents car: cars) {
            car.getComponent().startEngine();
        }
    }

    void stopAllCars(){
        for (GUIComponents car : cars){
            car.getComponent().stopEngine();
        }
    }
    void turboOn(){
        for(GUIComponents car : cars){
            if (car.getComponent().getClass() == Saab95.class){
                ((Saab95) car.getComponent()).setTurboOn();
            }
        }
    }
    void turboOff() {
        for(GUIComponents car: cars) {
            if (car.getComponent().getClass() == Saab95.class){
                ((Saab95) car.getComponent()).setTurboOff();
            }
        }
    }
    void truckBedDown(){
        for(GUIComponents car: cars){
            if (HasTruckBed.class.isAssignableFrom(car.getClass())){
                ((HasTruckBed) car.getComponent()).lowerTruckBed();
            }
        }
    }
    void truckBedUp() {
        for(GUIComponents car: cars) {
            if (HasTruckBed.class.isAssignableFrom(car.getClass())){
                ((HasTruckBed) car.getComponent()).lowerTruckBed();
            }
        }
    }

}
