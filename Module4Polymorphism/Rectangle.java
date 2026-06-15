public class Rectangle extends Shape{
    private double width;
    private double height;

    public Rectangle(String color, boolean isFilled, double width, double height){
        super(color, isFilled);
        this.width = width;
        this.height = height;
    }

    @Override
    public double calculateArea(){
        return this.width * this.height;
    }

    @Override
    public void printDetails(){
        System.out.println("This is a " + this.color + " Rectangle with dimensions: " + this.width + "x" + this.height + ". Area: " + calculateArea());
    }

}