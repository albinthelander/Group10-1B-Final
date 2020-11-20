import java.awt.*;

public class Saab95 extends Car {

    /**
     * Shows if the turbo is on or off.
     */
    boolean turboOn;

    /**
     * Creates an object of type Saab95.
     */
    public Saab95(String name){
        super(2, 125, Color.red, "Saab95",0,0,0,2.5, name, false);
        turboOn = false;
        stopEngine();
    }

    /**
     * Determines the speed factor.
     */
    double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return getEnginePower() * 0.01 * turbo;
    }

    /**
     * Checks if the car can move.
     */
    public boolean canMove(){
        return true;
    }

    /**
     * Sets the turbo on.
     */
    public void setTurboOn(){
        turboOn = true;
    }

    /**
     * Sets the turbo off.
     */
    public void setTurboOff(){
        turboOn = false;
    }

}