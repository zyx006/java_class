import java.util.Scanner;

public class Demo2 {
    public static void main(String[] args) {
        final int BOX_CNT = 24;
        final int CONTAINER_CNT = 75;

        System.out.println("请输入饼干总数：");
        Scanner scanner = new Scanner(System.in);
        int totalBiscuit = scanner.nextInt();

        int remainBiscuit = totalBiscuit % BOX_CNT;
        int boxNumber = totalBiscuit / BOX_CNT;
        int remainBox = boxNumber % CONTAINER_CNT;
        int containerNumber = boxNumber / CONTAINER_CNT;

        System.out.println(totalBiscuit + "个饼干装了" + boxNumber + "个盒子，" + boxNumber + "个盒子装了" + containerNumber + "个容器");
        System.out.println("剩余" + remainBiscuit + "个饼干，" + remainBox + "个盒子");
    }
}
