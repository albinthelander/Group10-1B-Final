import java.awt.*;

public class Scania extends Car {

    /**
     * Current angle of the board.
     */
    private double boardAngle;

    /**
     * Trim factor of the car.
     */
    private final static double trimFactor = 1.25;

    /**
     * Creates an object of Scania.
     */
    public Scania(String name){
        super(2, 700, Color.pink, "Scania",0,0,0,8.0, name, false);
        stopEngine();
    }

    /**
     * Speed factor of the Scania.
     */
    double speedFactor(){
        return getEnginePower() * 0.01 * trimFactor;
    }

    /**
     * Starts the engine of the CarTransporter, if the board angle is zero.
     */
    @Override
    public void startEngine() {
        if(boardAngle == 0)
            super.startEngine();
    }

    /**
     * increases the board angle, stops if angle reaches 70 degrees
     * @param angle the angle you want to increase the board with
     */
    public void raiseBoard(double angle){
        if(getCurrentSpeed() == 0)
            boardAngle= Math.min(boardAngle+=angle, 70);
    }

    /**
     * Returns the current board angle.
     */
    public double getBoardAngle(){
        return boardAngle;
    }

    /**
     * decreases the board angle, stops if angle reaches 0 degrees
     * @param angle the angle you want to decrease the board with
     */
    public void lowerBoard(double angle){
        boardAngle= Math.max(boardAngle-=angle, 0);
    }

    /**
     * Gases the truck if the board angle is 0 degrees
     */
    @Override
    public void move(){
        if(boardAngle == 0){
            super.move();
        }
    }

    /**
     * Checks if the car can move.
     */
    public boolean canMove(){
        return boardAngle == 0;
    }

}