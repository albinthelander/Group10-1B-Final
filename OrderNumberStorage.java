import java.util.*;
import java.util.Map.Entry;

public class OrderNumberStorage<T extends Car> {

    private T t;
    private int order = 0 ;
    private int capacity;

    /**
     * Creates a new storage unit.
     */
    public OrderNumberStorage(int capacity){
        this.capacity = capacity;
    }

    //When order is not important

    /**
     * A CarMap which holds cars and give them unique order numbers.
     */
    private final HashMap<T, Integer> CarMap = new HashMap<>(capacity);

    /**
     * Loads a car into the map.
     * @param carToAdd Desired car.
     */
    int loadMap(T carToAdd){
        CarMap.put(carToAdd, order);
        order++ ;
        return order-1;
    }

    /**
     * Returns the ordernumber.
     */
    public int getOrder() {
        return order;
    }

    /**
     * Unloads a car from the map.
     */
    void unloadMap(int order){
        CarMap.values().remove(order);
    }

    /**
     * Returns a car, given its order number.
     * @param order Order number.
     */
    T getCar(Integer order){
        return getKeyByValue(CarMap, order);
    }

    /**
     * Searches for a mathcing value in Map, returns its key.
     * @param map Map to search through.
     */static <T, Integer> T getKeyByValue(HashMap<T, Integer> map, Integer value) {
        for (Entry<T, Integer> entry : map.entrySet()) {
            if (Objects.equals(value, entry.getValue())) {
                return entry.getKey();
            }
        }
        return null;
    }
}