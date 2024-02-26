package Application.Car_World;

import java.awt.*;

class Scania extends Car implements HasTruckBed {
    private int truckBedAngle;
    private TruckBed truckBed;
    public Scania(){
        position=new Point(0,0);
        weight=3000;
        imageSource = "pics/Scania.jpg";
        modelName = "Scania";
        nrDoors = 2;
        enginePower=750;
        color = Color.pink;
        truckBedAngle = 0;
        truckBed = new TruckBed(true,35000) ;
        stopEngine();
    }
    @Override
    public void raiseTruckBed(){
        if((truckBedAngle <= 60 && truckBedAngle >= 0) && currentSpeed == 0) {
            truckBedAngle += 10;
             truckBed.setTruckBed(false);

        }
    }
    @Override
    public void lowerTruckBed() {

        if ((truckBedAngle <= 70 && truckBedAngle >= 10) && currentSpeed == 0) {
            truckBedAngle -= 10;
        }
        if (truckBedAngle == 0) {
            truckBed.setTruckBed(true);
        }

    }
    public int getTruckBedAngle(){
        return this.truckBedAngle;
    }
    @Override
    public void move(){

        if(truckBed.isTruckBedDown()) {
            super.move();
        }
    }
}
