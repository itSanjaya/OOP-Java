public class Circle extends Shape{
    private double radius;

    public Circle(String color, boolean isFilled, double radius){
        super(color, isFilled);
        this.radius = radius;
    }

    @Override
    public double calculateArea(){
        return Math.PI * this.radius * this.radius;
    }

    @Override
    public void printDetails(){
        System.out.println("This is a " + this.color + " Circle with radius: " + this.radius + ". Area: " + calculateArea());
    }

}