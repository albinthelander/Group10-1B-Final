public class Workshop<T extends Car> {

  /**
   * Capacity of the workshop.
   */
  private int capacity;

  /**
   * Creates a new Workshop.
   * @param capacity What the workshop size should be.
   */
  public Workshop(int capacity) {
    this.capacity = capacity;
  }

  /**
   * The unit which stores all objects.
   */
  OrderNumberStorage<T> WorkshopStorage = new OrderNumberStorage<T>(this.capacity);

  /**
   * Loads a car into the storage.
   * @param car The car we wish to load.
   */
  public int loadStorage(T car) {
    WorkshopStorage.loadMap(car);
    return WorkshopStorage.getOrder();
  }

  /**
   * Unloads a car from the storage.
   * @param carToRemove The car you wish to unload.
   */
  public void unloadStorage(int carToRemove) {
    System.out.println("Successfully unloaded " + WorkshopStorage.getCar(carToRemove-1).getName());
    WorkshopStorage.unloadMap(carToRemove-1);
  }
}