public class TestWorkshop {

    public static void main(String[] args){

        //Creates some cars
        Volvo240 VolvoCar1 = new Volvo240("Albins Volvo");
        Volvo240 Ivar= new Volvo240("Ivars Volvo");
        Volvo240 VolvoCar3 = new Volvo240("Jens Volvo");
        Volvo240 VolvoCar4 = new Volvo240("Alex Volvo");
        Volvo240 VolvoCar5 = new Volvo240("Pelles Volvo");
        Saab95 SaabCar = new Saab95("Albins Saab");

        //Creates two workshops
        Workshop<Volvo240> volvoWorkshop = new Workshop<Volvo240>(10);
        Workshop<Car> allWorkshop = new Workshop<Car>(10);

        allWorkshop.loadStorage(SaabCar);
        volvoWorkshop.loadStorage(VolvoCar1);
        volvoWorkshop.loadStorage(VolvoCar3);
        volvoWorkshop.loadStorage(VolvoCar4);
        volvoWorkshop.loadStorage(VolvoCar5) ; //Returns order number 4.
        volvoWorkshop.loadStorage(Ivar);

        //Unloads cars based on their order number
        volvoWorkshop.unloadStorage(1) ;
        volvoWorkshop.unloadStorage(5) ;



    }
}
