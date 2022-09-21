package Class5.work;

/**
 * @author : 张宇轩
 * @createTime : 2022/9/21 - 9:20
 */
public class RectangleTest {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(3.0,4.0);
        System.out.println("矩形的面积：" + rectangle.calculateArea());
        System.out.println("矩形的周长：" + rectangle.calculatePerimeter());
    }
}
