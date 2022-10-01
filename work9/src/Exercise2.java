import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 * @author : 张宇轩
 * @createTime : 2022/10/1 - 23:00
 */
public class Exercise2 {
    public static void main(String[] args) {
        Date date = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
        String serialNumber = df.format(date);

        int cnt = 0;
        Scanner scanner = new Scanner(System.in);
        List<String> details = new ArrayList<>();
        while (true){
            String input = scanner.nextLine();
            if ("0000".equals(input)){
                break;
            }
            String tmpSerialNumber = serialNumber + String.format("%04d",cnt++);
            String detail = tmpSerialNumber + "," +input;
            details.add(detail);
        }
        System.out.println("流水号\t\t\t商品名称\t商品数量\t单价\t总价");
        int allSaleNum = 0;
        double allSaleMoney = 0;
        for (String each : details) {
            String[] detail = each.split(",");
            System.out.print(detail[0] + "\t" + detail[1] + "\t" + detail[2] + "\t\t" + detail[3] + "\t\t" );
            int saleNum = Integer.parseInt(detail[2]);
            double saleMoney = Double.parseDouble(detail[3]);
            System.out.println(saleNum*saleMoney);

            allSaleNum += saleNum;
            allSaleMoney += saleNum*saleMoney;
        }
        System.out.println("总计：销售笔数 " + details.size() + "，销售数量 " + allSaleNum + "，销售金额 " + allSaleMoney);
    }
}
