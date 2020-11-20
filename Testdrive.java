public class Testdrive {

    public static void main(String[] args){

        //Creates some cars
        Volvo240 VolvoCar = new Volvo240("Albins Volvo");
        Saab95 SaabCar = new Saab95("Albins Saab");
        CarTransporter<Car> trans = new CarTransporter<>("Albins CarTransporter", 10);

        //Test drive CarTransporter

        trans.lowerBoard();

        trans.loadStorage(VolvoCar);
        trans.loadStorage(SaabCar);

        trans.raiseBoard();
        trans.startEngine();

        trans.move();
        trans.move();

        trans.stopEngine();
        trans.lowerBoard();
        trans.unloadStorage();

        trans.raiseBoard();
        trans.startEngine();
        trans.turnLeft();
        trans.move();
        trans.move();

        //Checks coordinates
        System.out.println(trans.getX());
        System.out.println(trans.getY());
        System.out.println(VolvoCar.getX());
        System.out.println(VolvoCar.getY());
        System.out.println(SaabCar.getX());
        System.out.println(SaabCar.getY());

        System.out.println(SaabCar.getX());
        System.out.println(SaabCar.getY());

    }
}
