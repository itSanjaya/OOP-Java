public class Car extends Vehicle{
    private int numDoors;

    public Car(String manufacturedBy, String modelname, int manufacturedYear, int doorNumbers){
        super(manufacturedBy, modelname, manufacturedYear);
        this.numDoors = doorNumbers;
    }

    public void startEngine(){
        System.out.println("This " + this.getManufacturer() + " " + this.getModel() + " roars to life in " + this.getManufacturedYear() + ". It has " + this.numDoors + " doors.");
    }
}
