package Application.Car_World;

import java.awt.*;

public class Volvo240 extends Car{

    public final static double trimFactor = 1.25;

    public Volvo240(){
        weight=1000;
        nrDoors = 4;
        color = Color.black;
        enginePower = 120;
        modelName = "Application.Application.Application.Graphics.Graphics.Application.Graphics.Car_World.Application.Graphics.Graphics.Application.Graphics.Car_World.Volvo240";
        stopEngine();
    }
    @Override
    public double speedFactor(){
        return enginePower * 0.01 * trimFactor;
    }
}
