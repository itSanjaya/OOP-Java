public class Vehicle {
    private String manufacturer;
    private String model;
    private int year;

    public Vehicle(String manufacturedBy, String modelname, int manufacturedYear){
        if (manufacturedBy == null || manufacturedBy.trim().isEmpty()){
            throw new IllegalArgumentException("Brandname can't be empty.");
        }
        this.manufacturer = manufacturedBy;

        if (modelname == null || modelname.trim().isEmpty()){
            throw new IllegalArgumentException("Model can't be empty");
        }

        this.model = modelname;
        this.year = manufacturedYear;
    }

    public String getManufacturer() { return this.manufacturer; }
    public String getModel() { return this.model; }
    public int getManufacturedYear() { return this.year; }

    public void startEngine(){
        System.out.println("The" + this.manufacturer + this.model + "'s engine is now running.");
    }
}
