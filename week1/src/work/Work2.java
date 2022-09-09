package work;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class Work2 {
    public static void main(String[] args) {
        double price = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入图片长度（英寸）：");
        double length = scanner.nextDouble();
        System.out.println("输入图片宽度（英寸）：");
        double width = scanner.nextDouble();

        //纸板和玻璃的面积按与 照片 等大处理
        price += length * width * 0.09;//照片

        double framePerimeter = 2 * length + 2 * width + 4;//框架周长

        System.out.println("选择画框类型（0:普通 / 1:花式）：");
        int optFrame = -1;
        while (optFrame == -1){
            optFrame = checkInputNumber(scanner,0,1);
        }
        if (optFrame == 0){
            price += framePerimeter * 0.15;
        }else price += framePerimeter * 0.25;

        System.out.println("选择画框颜色（0:白色 / 1:其他）：");
        int optColor = -1;
        while (optColor == -1){
            optColor = checkInputNumber(scanner,0,1);
        }
        if (optColor == 1) {
            price += framePerimeter * 0.1;
        }

        System.out.println("是否需要放置皇冠（0:是 / 1:否）：");
        int optIfCrown = -1;
        while (optIfCrown == -1){
            optIfCrown = checkInputNumber(scanner,0,1);
        }
        if (optIfCrown == 0){
            System.out.println("输入要放置的皇冠数量：");
            int crownCnt = scanner.nextInt();
            price += crownCnt * 0.35;
        }
        System.out.println("总费用：" + new BigDecimal(price).setScale(2, RoundingMode.HALF_UP));
    }


    public static int checkInputNumber(Scanner scanner, int low, int high) {
        String input = scanner.next();
        try {
            int opt = Integer.parseInt(input);
            if (opt >= low && opt <= high)
                return opt;
            else {
                System.out.println("输入无效，只能输入" + low + "-" + high);
            }
        } catch (NumberFormatException e) {
            System.out.println("输入无效，只能输入" + low + "-" + high);
        }
        return -1;
    }
}
