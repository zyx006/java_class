import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Exercise2 {
    public static void main(String[] args) {
        Date date = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
        String serialNumber = df.format(date);

        int cnt = 1, allSaleNum = 0;
        double allSaleMoney = 0;
        Scanner scanner = new Scanner(System.in);
        String info = "";
        while (true){
            String input = scanner.nextLine();
            if ("0000".equals(input)){
                break;
            }
            String tmpSerialNumber = serialNumber + String.format("%04d",cnt++);

            String[] detail = input.split(",");

            int saleNum = Integer.parseInt(detail[1]);
            double saleMoney = Double.parseDouble(detail[2]);
            allSaleNum += saleNum;
            allSaleMoney += saleNum*saleMoney;
            info += tmpSerialNumber + "\t" + detail[0] + "\t" + detail[1] + "\t\t" + detail[2] + "\t\t" + saleNum*saleMoney + "\n";
        }
        System.out.println("流水号\t\t\t商品名称\t商品数量\t单价\t总价");
        System.out.println(info);
        System.out.println("总计：销售笔数 " + (cnt-1) + "，销售数量 " + allSaleNum + "，销售金额 " + allSaleMoney);
    }
}
