import java.awt.*;

public class Volvo240 extends Car{

    public final static double trimFactor = 1.25;

    public Volvo240(){
        weight=1000;
        nrDoors = 4;
        color = Color.black;
        enginePower = 120;
        modelName = "Volvo240";
        image = "pics/Volvo240.jpg";
        stopEngine();
    }
    @Override
    public double speedFactor(){
        return enginePower * 0.01 * trimFactor;
    }
}
