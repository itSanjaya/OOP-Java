public class Main{
    public static void main(String[] args){

        Shape newShape = new Shape("black", true );

        // newShape.calculateArea();
        newShape.printDetails();


        Circle newCircle = new Circle("blue", true, 46.3 );

        // newCircle.calculateArea();
        newCircle.printDetails();


        Rectangle newRectangle = new Rectangle("Red", false, 10.6, 15.2);

        // newRectangle.calculateArea();
        newRectangle.printDetails();
    }
}