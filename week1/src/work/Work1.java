package work;

import java.util.Scanner;

public class Work1 {
    public static void main(String[] args) {
        System.out.println("请输入价格：");
        double price = new Scanner(System.in).nextDouble();
        int twoDollarCnt = (int) price / 2;
        int oneDollarCnt = (int) price % 2;

        double decimal = (price*100) - twoDollarCnt*200 - oneDollarCnt*100;
        int fiftyCentCnt = (int) (decimal / 50);
        int twentyCentCnt = (int) ((decimal - 50*fiftyCentCnt) / 20);
        int tenCentCnt = (int) ((decimal - 50*fiftyCentCnt - 20*twentyCentCnt) / 10);
        int fiveCentCnt = (int) ((decimal - 50*fiftyCentCnt - 20*twentyCentCnt - 10*tenCentCnt) / 5);

        System.out.println("$2数量：" + twoDollarCnt);
        System.out.println("$1数量：" + oneDollarCnt);
        System.out.println("￠50数量：" + fiftyCentCnt);
        System.out.println("￠20数量：" + twentyCentCnt);
        System.out.println("￠10数量：" + tenCentCnt);
        System.out.println("￠5数量：" + fiveCentCnt);
    }
}
