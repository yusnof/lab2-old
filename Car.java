import java.awt.*;
import java.lang.Math;
  public abstract class Car implements Movable{



    protected int nrDoors,weight;
    protected Color color;
    protected double enginePower,currentSpeed,x,y,direction;
    protected String modelName;
    public int getNrDoors(){
        return nrDoors;
    }
    public double getEnginePower() { return enginePower; }

    public double getCurrentSpeed(){ return currentSpeed; }
    public Color getColor(){ return color; }

    public void setColor(Color color){
        this.color = color;
    }
    public void startEngine(){
        currentSpeed = 0.1;
    }
    public double speedFactor() {
        return enginePower * 0.01;
    }
    public void stopEngine(){
        currentSpeed = 0;
    }
    public int getWeight() {
        return weight;
    }
    public double getY() {
        return y;
    }
    public double getX() {
        return x;
     }
    public void setY(double y) {
          this.y = y;
      }
    public void setX(double x) {
          this.x = x;
      }
     public double measureDistance(Car a, Car b) {
        double xDiff=  a.getX() - b.getX();
        double yDiff=  a.getY() - b.getY();
        return Math.sqrt(Math.pow(xDiff,2)+Math.pow(yDiff,2));
      }

    public void incrementSpeed(double amount){
        double temp = Math.min(getCurrentSpeed() + speedFactor() * amount,enginePower);
        if (temp >=0 && temp <= this.enginePower ) {
            currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount, enginePower);
        }
    }
    public void decrementSpeed(double amount){
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount,0);
    }

    // findAngleA used in move() to find the angle of the right triangle in unit circle,
    // a should be the angle between the x-axle and the facing direction.
    // to ensure opposite leg of triangle is the y component, and adjacent is the x component.
    public double findAngleA (double a) {
        double t = a / 90;
        if (t < 1) {
            return a;
        } else if (t > 1 && t < 2) {
            return 180 - a;
        } else if (t >= 2 && t < 3) {
            return a - 180;
        } else {
            return 360 - a;
        }
    }
    @Override
    public void move() {
        double a = Math.toRadians(findAngleA(direction));
        double absCurrentSpeed = Math.abs(currentSpeed);
        double yComponent = absCurrentSpeed*Math.sin(a);
        double xComponent = absCurrentSpeed*Math.cos(a);
        // if facing direction is in the negative y direction, y cord should be reduced.
        if(Math.sin(Math.toRadians(direction))<0) {
           yComponent=yComponent/-1;
        }
        // if facing direction is in the negative x direction, x cord should be reduced.
        if(Math.cos(Math.toRadians(direction))<0) {
            xComponent=xComponent/-1;
        }
        // negate the components to move opposite to the facing direction if speed <0
        if(currentSpeed<0) {
            x=x+(xComponent/-1);
            y=y+(yComponent/-1);
         }
        // speed is >= 0 ,new x,y positions
        else {
            x=x+xComponent;
            y=y+yComponent;
        }
    }

    @Override
    public void turnLeft() {
        direction=(direction+15)%360;
    }

    @Override
    public void turnRight() {
        if(direction-15<0) {
            direction=360-(direction-15);
        }
        else {direction=direction-15;}
    }

    public void gas(double amount){
        if (amount >= 0 && amount <=1){
            incrementSpeed(amount);
        }
    }

    public void brake(double amount){
        if (amount >= 0 && amount <=1){
            decrementSpeed(amount);
        }
    }

}
