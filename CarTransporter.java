import java.awt.*;

public class CarTransporter<T extends Car> extends Car {

    private int capacity;
    private boolean isBoardUp = true;
    private static final double trimFactor = 1.25;
    private static final double maxLength = 3.0;

    /**
     * The OrderNumberStorage of the CarTransporter.
     */
    InOutStorage<T> CarTransporterStorage = new InOutStorage<>(capacity);

    /**
     * Creates an object of CarTransporter with a certain loading capacity.
     */
    public CarTransporter(String name, int capacity) {
        super(2, 1000, Color.blue, "CarTransporter", 0, 0, 0, 15, name,false);
        this.capacity = capacity;
        stopEngine();
    }

    /**
     * Checks if it is possible to load carToLoad.
     * @param carToLoad the car you wish to load.
     */

    public void loadStorage(T carToLoad){
        if (canLoad(carToLoad)) {
            while (carToLoad.getAngle() != getAngle()){
                carToLoad.turnLeft();
            }
            carToLoad.setIsLoaded(true);
            CarTransporterStorage.loadStorage(carToLoad);
        }
        else{
            System.out.println("Already loaded.");
        }
    }

    /**
     * Unloads the last stored car from the CarTransport and reverses it 1 length unit.
     */
    public void unloadStorage () {
        if (!isBoardUp) {
            for (int i = 0; i < 10; i++) {
                CarTransporterStorage.getDeque().getFirst().reverse();
            }
            CarTransporterStorage.getDeque().getFirst().setIsLoaded(false);
            CarTransporterStorage.unloadLast();
        }
    }

    /**
     * Checks if it's possible to load a car due to several requirements.
     * @param carToLoad Car you wish to load.
     */
    private boolean canLoad(T carToLoad) {
        return !CarTransporterStorage.getDeque().contains(carToLoad) && !carToLoad.getIsLoaded() && !isBoardUp && carToLoad.getLength() < maxLength &&
                Math.sqrt(Math.pow(getX() - carToLoad.getX(), 2) + Math.pow(getY() - carToLoad.getY(), 2)) <= 5;
    }

    /**
     * Starts the engine of the CarTransporter, if the board is up.
     */
    @Override
    public void startEngine() {
        if(isBoardUp)
            super.startEngine();
    }

    /**
     * Moves the board to its upper state.
     */
    public void raiseBoard () {
        if (getCurrentSpeed() == 0)
            isBoardUp = true;
    }

    /**
     * Moves the board to its lower state.
     */
    public void lowerBoard () {
        if (getCurrentSpeed() == 0)
            isBoardUp = false;
    }

    /**
     * Returns the CarTransporterStorage.
     */
    public InOutStorage<T> getStorageUnit () {
        return CarTransporterStorage;
    }

    /**
     * Moves the CarTransporter and its loaded cars its current speed in its current direction
     */
    @Override
    public void move () {
        if(canMove()) {
            super.move();
            for (T car : CarTransporterStorage.getDeque())
                car.setPosInTransport(this);
        }
    }

    /**
     * Checks if the CarTransporter can move.
     */
    public boolean canMove () {
        return isBoardUp;
    }

    /**
     * Returns the speed factor of the CarTransporter.
     */
    double speedFactor () {
        return getEnginePower() * 0.01 * trimFactor;
    }
}