package Application.Car_World;

import java.awt.*;

 class Volvo240 extends Car{

    public final static double trimFactor = 1.25;

    public Volvo240(int x, int y){
        position=new Point(x,y);
        imageSource= "pics/Volvo240.jpg";
        weight=1000;
        nrDoors = 4;
        color = Color.black;
        enginePower = 120;
        modelName = "Volvo240";
        stopEngine();
    }
    @Override
    public double speedFactor(){
        return enginePower * 0.01 * trimFactor;
    }
}
