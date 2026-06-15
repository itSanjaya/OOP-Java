public class Shape{
    protected String color;
    protected boolean isFilled;

    public Shape(String color, boolean isFilled){
        this.color = color;
        this.isFilled = isFilled;
    }

    public double calculateArea(){
        return 0.0;
    }

    void printDetails(){
        System.out.println("This is a " + this.color + " shape. Filled status: " + this.isFilled + ".");
    }
}