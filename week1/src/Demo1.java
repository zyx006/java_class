import java.util.Scanner;

public class Demo1 {
    public static void main(String[] args) {
        final double managerCommission = 0.12;
        final double siteCommission = 0.03;

        String songTitle;
        double songPrice;
        int copies;
        double totalRevenue;
        double mamagerRevenue;
        double siteRevenue;

        Scanner scanner = new Scanner(System.in);
        System.out.println();
        songTitle = scanner.nextLine();
        songPrice = scanner.nextDouble();
        copies = scanner.nextInt();

        totalRevenue = songPrice * copies;
        mamagerRevenue = totalRevenue * managerCommission;
        siteRevenue = totalRevenue * siteCommission;

        System.out.println(totalRevenue);
        System.out.println(mamagerRevenue);
        System.out.println(siteRevenue);
    }
}
