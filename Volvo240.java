import java.awt.*;

public class Volvo240 extends Car{

    /**
     * Trim factor of the Volvo
     */
    private static double trimFactor = 1.25;

    /**
     * Creates an object of type Volvo240
     */
    public Volvo240(String name){
        super(4, 100, Color.black, "Volvo240)",0,0,0,2.5, name, false);
        stopEngine();
    }

    /**
     * Checks if the car can move.
     */
    public boolean canMove(){
        return true;
    }

    /**
     * Determines the speed factor
     */
    double speedFactor(){
        return getEnginePower() * 0.01 * trimFactor;
    }
}