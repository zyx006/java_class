package exercise5;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class MarketCashier {
    public static void cashier(){
        Date date = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
        String serialNumber = df.format(date);

        Scanner scanner = new Scanner(System.in);
        int cnt = 1, allSaleNum = 0;
        double allSaleMoney = 0;
        StringBuilder info = new StringBuilder();
        System.out.println("请依次输入销售记录(商品名称,销售数量,商品单价),输入'0000'时结束输入：");
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
            info.append(tmpSerialNumber).append("\t").append(detail[0]).append("\t").append(detail[1]).append("\t\t").append(detail[2]).append("\t\t").append(saleNum * saleMoney).append("\n");
        }
        System.out.println("流水号\t\t\t商品名称\t商品数量\t单价\t总价");
        System.out.println(info);
        System.out.println("总计：销售笔数 " + (cnt-1) + "，销售数量 " + allSaleNum + "，销售金额 " + allSaleMoney);
    }
}
