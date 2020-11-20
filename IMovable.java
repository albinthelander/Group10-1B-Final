public interface IMovable {

    /**
     *x-coordinate of car, package protected instance variable
     */
    double x = 0;

    /**
     *y-coordinate of car, package protected instance variable
     */
    double y = 0;

    /**
     *moves the car its current speed in its current direction
     */
    void move();

    /**
     *moves the car slowly backwards
     */
    void reverse();

    /**
     *turns the car 90 degrees the the left
     */
    void turnLeft();

    /**
     *turns the car 90 degrees the the right
     */
    void turnRight();

    /**
     *checks if the vehicle can move
     */
    boolean canMove();

}
