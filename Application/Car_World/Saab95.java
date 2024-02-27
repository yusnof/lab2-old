package Application.Car_World;

import java.awt.*;

class Saab95 extends Car implements HasTurbo {

    public boolean turboOn;

    public Saab95(int x, int y){
        position=new Point(x,y);
        weight=1000;
        nrDoors = 2;
        imageSource = "pics/Saab95.jpg";
        modelName = "Saab95";
        color = Color.red;
        turboOn=false;
        enginePower = 100;
        stopEngine();
    }
    public void setTurboOn(){
        turboOn = true;
    }

    public void setTurboOff(){
        turboOn = false;
    }
    @Override
    public double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return enginePower * 0.01 * turbo;
    }
}
