public class Truck extends Vehicle {
    private double payloadCapacity;

    public Truck(String manufacturedBy, String modelname, int manufacturedYear, double loadCapacity){
        super(manufacturedBy, modelname, manufacturedYear);
        this.payloadCapacity = loadCapacity;
    }

    public void startEngine(){
        System.out.println("The heavy-duty" + this.getManufacturer() + " " + this.getModel() + "is rumbling. Payload capacity: " + this.payloadCapacity + " tons.");
    }
}
