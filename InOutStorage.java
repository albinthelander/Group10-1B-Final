import java.util.ArrayDeque;

public class InOutStorage<T extends Car> {

    private T t;
    private int order = 0 ;
    private int capacity;

    /**
     * Creates a new storage unit.
     */
    public InOutStorage(int capacity){
        this.capacity = capacity;
    }

    /**
     * Arraydeque to store cars.
     */
    private final ArrayDeque<T> Storage = new ArrayDeque<>(capacity);

    /**
     * Loads a car.
     * @param carToAdd Desired car.
     */
    void loadStorage(T carToAdd){
        Storage.push(carToAdd);
    }

    /**
     * Unloads the last stored car.
     */
    void unloadLast(){
        Storage.pop();
    }

    /**
     * Returns the deque.
     */
    ArrayDeque<T> getDeque(){
        return Storage;
    }
}
