package lesson5.work;

public class Rectangle {
    private Double length;
    private Double width;

    public Rectangle() {
        this.length = 1.0;
        this.width = 1.0;
    }

    public Rectangle(Double length, Double width) {
        this.length = length;
        this.width = width;
    }

    public double calculateArea(){
        return length*width;
    }

    public double calculatePerimeter(){
        return (length+width)*2;
    }
}
