package Class5.work;

/**
 * @author : 张宇轩
 * @createTime : 2022/9/21 - 9:17
 */
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
