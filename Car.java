import java.awt.*;

/**
 * abstract super class which implements the Movable interface
 */
public abstract class Car implements IMovable {

    /**
     * Angle of the car, initially in +y-direction.
     */
    private int angle;

    /**
     * X-coordinate of the car.
     */
    private double x;

    /**
     * States if the car is loaded somewhere.
     */
    private boolean isLoaded;

    /**
     * Y-coordinate of the car.
     */
    private double y;

    /**
     * Number of doors on the car.
     */
    private final int nrDoors;

    /**
     * Engine power of car.
     */
    private final double enginePower;

    /**
     * Current speed of the car.
     */
    private double currentSpeed;

    /**
     * Color of the car.
     */
    private final Color color;

    /**
     * Name of the model.
     */
    private final String modelName;

    /**
     * Length of the car.
     */
    private final double length;

    /**
     * Name of the car.
     */
    private final String name;

    /**
     * Constructor of the abstract class Car, sets a framework for the subclasses of the class.
     */
    public Car(int nrDoors, double enginePower, Color color, String modelName, double x, double y, int angle, double length, String name, boolean isLoaded) {
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.color = color;
        this.modelName = modelName;
        this.x = x;
        this.y = y;
        this.angle = angle;
        this.length = length;
        this.name = name;
        this.isLoaded = isLoaded;
    }

    /**
     * Returns the number of doors of the car.
     */
    int getNrDoors() {
        return nrDoors;
    }

    /**
     * Returns if the car is loaded somewhere.
     */
    boolean getIsLoaded() {
        return isLoaded;
    }

    /**
     * Sets if the car is loaded.
     */
    void setIsLoaded(boolean load) {
        this.isLoaded = load;
    }

    /**
     * Returns the engine power of the car.
     */
    double getEnginePower() {
        return enginePower;
    }

    /**
     * Returns the current speed of the car.
     */
    double getCurrentSpeed() {
        return currentSpeed;
    }

    /**
     * Returns the color of the car.
     */
    Color getColor() {
        return color;
    }

    /**
     * Returns the current angle of the car.
     */
    public int getAngle() {
        return angle;
    }

    /**
     * Returns the current x-coordinate of the car.
     */
    public double getX() {
        return x;
    }

    /**
     * Returns the current y-coordinate of the car.
     */
    public double getY() {
        return y;
    }

    /**
     * Returns the length of the car.
     */
    public double getLength(){
        return length;
    }

    /**
     * Returns the model name of the car.
     */
    public String getModelName(){ return modelName; }

    /**
     * Abstract method for speed factor which gets overridden in each subclass.
     */
    abstract double speedFactor();

    /**
     * Returns the increment speed of the car.
     * @param amount The amount you want to increase.
     */
    protected void incrementSpeed(double amount) {
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount, enginePower);
    }

    /**
     * Returns the decrement speed of the car.
     *
     * @param amount The amount you want to decrease.
     */
    void decrementSpeed(double amount) {
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount, 0);
    }

    /**
     * Returns the cars given name
     */
    String getName(){
        return name ;
    }

    //Public methods below, visible to user.

    /**
     * Starts the engine of the car.
     */
    public void startEngine() {
        currentSpeed = 0.1;
    }

    /**
     * Kills the engine of the car.
     */
    public void stopEngine() {
        currentSpeed = 0;
    }

    /**
     * Checks if the car can move.
     */
    @Override
    public abstract boolean canMove();

    /**
     * Moves the car its current speed in its current direction.
     */
    @Override
    public void move() {
        if (canMove()) {
            if (angle % 4 == 0) y += getCurrentSpeed();
            else if (angle % 4 == -2 || angle % 4 == 2) y -= getCurrentSpeed();
            else if (angle % 4 == -1 || angle % 4 == 3) x -= getCurrentSpeed();
            else x += getCurrentSpeed();
        }
    }

    /**
     * Reverses the car slowly.
     */
    @Override
    public void reverse() {
        if (canMove()) {
            if (angle % 4 == 0) y -= 1;
            else if (angle % 4 == -2 || angle % 4 == 2) y += 1;
            else if (angle % 4 == -1 || angle % 4 == 3) x += 1;
            else x -= 1;
        }
    }

    /**
     * Makes the car turn 90 degrees to the left
     */
    @Override
    public void turnLeft() {
        angle -= 1;
    }

    /**
     * Makes the car turn 90 degrees to the right.
     */
    @Override
    public void turnRight() {
        angle += 1;
    }

    /**
     * Increases the speed of the car.
     * @param amount The amount you want to gas.
     */
    public void gas(double amount) {
        if (0 < amount && amount < 1) {
            incrementSpeed(amount);
        }
    }

    /**
     * Decreases the speed of the car.
     * @param amount The amount you want to brake.
     */
    public void brake(double amount) {
        if (0 < amount && amount < 1) {
            decrementSpeed(amount);
        }
    }

    /**
     * while in transport, set car's position to truck's position
     * @param carTransporter carTransporter to compare with
     */
    void setPosInTransport(CarTransporter<?> carTransporter) {
        if (carTransporter.getStorageUnit().getDeque().contains(this)) {
            x = carTransporter.getX();
            y = carTransporter.getY();
            angle = carTransporter.getAngle();
        }
    }
}