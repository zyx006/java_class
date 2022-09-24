package lesson5.work;

public class RectangleTest {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(3.0,4.0);
        System.out.println("矩形的面积：" + rectangle.calculateArea());
        System.out.println("矩形的周长：" + rectangle.calculatePerimeter());

        System.out.println();

        Rectangle rectangle1 = new Rectangle();
        System.out.println("矩形的面积：" + rectangle1.calculateArea());
        System.out.println("矩形的周长：" + rectangle1.calculatePerimeter());
    }
}
