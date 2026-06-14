public class Main {
    public static void main(String[] args){
        Car newCar = new Car("Toyota", "Camry", 2021, 4);

        newCar.startEngine();

        Truck newTruck = new Truck("Volvo", "FH16 Aero", 2018, 100.0);

        newTruck.startEngine();
    }
    
}
