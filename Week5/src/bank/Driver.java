package bank;

import java.io.IOException;
import java.util.Scanner;

/**
 * @author : 张宇轩
 * @createTime : 2022/9/28 - 10:02
 */
public class Driver {
    private static Customer customer = null;

    public static void main(String[] args) throws IOException {
        while (true) {
            int opt = menu();
            switch (opt) {
                case 1:
                    create();
                    break;
                case 2:
                    save();
                    break;
                case 3:
                    withDraw();
                    break;
                case 4:
                    consume();
                    break;
                case 5:
                    repay();
                    break;
                case 6:
                    settle();
                    break;
                case 7:
                    balance();
                    break;
                case 8:
                    return;
            }
            System.out.println("按任意键继续...");
            System.in.read();
        }
    }

    /**
     * 检查菜单选项输入合法性
     * @param low 选项下界
     * @param high 选项上界
     * @return 合法选项值
     */
    public static int checkInput(int low, int high) {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) {
            int opt = scanner.nextInt();
            if (opt >= low && opt <= high) {
                return opt;
            }
            System.out.println("输入超限，请输入" + low + "-" + high + "的数字");
        } else {
            System.out.println("输入数据类型错误，请输入" + low + "-" + high + "的数字");
            scanner.next();
        }
        return -1;
    }

    public static int menu() {
        System.out.println("欢迎使用银行系统");
        System.out.println("1.开户");
        System.out.println("2.存款");
        System.out.println("3.取款");
        System.out.println("4.消费");
        System.out.println("5.还款");
        System.out.println("6.银行结算");
        System.out.println("7.查询余额");
        System.out.println("8.退出");
        System.out.print(">>>请选择(1-8)：");
        int opt = -1;
        while (opt == -1) {
            opt = checkInput(1,8);
        }
        return opt;
    }

    /**
     * 主菜单选项1 子菜单
     */
    public static void create() {
        if (customer != null && customer.getCheckingAccount() != null && customer.getSavingAccount() != null){
            System.out.println("用户 " + customer.getName() + "(" + customer.getSSN() + ")" + " 信用卡、存储卡已全部开户！无需再次开户");
            return;
        }
        System.out.println("请选择开卡类型");
        System.out.println("1.信用卡");
        System.out.println("2.存储卡");
        System.out.println("3.返回");
        System.out.print(">>>请选择(1-3)：");
        int opt = checkInput(1,3);
        switch (opt){
            case 1://信用卡开户
                createCheckingAccount();
                break;
            case 2://存储卡开户
                createSavingAccount();
                break;
            case 3://返回上一级
                return;
        }
    }

    /**
     * 主菜单选项1 子菜单1 信用卡开户
     */
    public static void createCheckingAccount() {
        Scanner scanner = new Scanner(System.in);
        if (customer == null){
            System.out.print("请输入SSN：");
            String SSN = scanner.nextLine();
            System.out.print("请输入姓名：");
            String name = scanner.nextLine();
            customer = new Customer(SSN, name);
        }
        if (customer.getCheckingAccount() == null){
            System.out.print("请输入卡号：");
            String accountNum = scanner.nextLine();
            System.out.print("请输入服务费：");
            double serviceCharge = scanner.nextDouble();
            customer.setCheckingAccount(new CheckingAccount(accountNum, 0.0, serviceCharge));
            System.out.println("成功创建信用卡账户！");
            System.out.println(customer.getCheckingAccount());
        } else {
            System.out.println("信用卡已开户！无需创建");
        }
    }

    /**
     * 主菜单选项1 子菜单2 存储卡开户
     */
    public static void createSavingAccount() {
        Scanner scanner = new Scanner(System.in);
        if (customer == null){
            System.out.print("请输入SSN：");
            String SSN = scanner.nextLine();
            System.out.print("请输入姓名：");
            String name = scanner.nextLine();
            customer = new Customer(SSN, name);
        }
        if (customer.getSavingAccount() == null) {
            System.out.print("请输入卡号：");
            String accountNum = scanner.nextLine();
            System.out.print("请输入利率：");
            double interestRate = scanner.nextDouble();
            customer.setSavingAccount(new SavingAccount(accountNum, 0.0, interestRate));
            System.out.println("成功创建存储卡账户！");
            System.out.println(customer.getSavingAccount());
        } else {
            System.out.println("存储卡已开户！无需创建");
        }
    }

    /**
     * 主菜单选项2 存款
     */
    public static void save(){
        if (customer != null) {
            SavingAccount savingAccount = customer.getSavingAccount();
            if (savingAccount != null) {
                Scanner scanner = new Scanner(System.in);
                System.out.print("请输入存款金额：");
                double balance = scanner.nextDouble();
                savingAccount.setBalance(savingAccount.getBalance()+balance);
                System.out.println("成功存款 " + balance + " 元");
            } else {
                System.out.println("存储卡未开户！");
            }
        } else {
            System.out.println("用户未开户！请先执行功能1");
        }
    }

    /**
     * 主菜单选项3 取款
     */
    public static void withDraw(){
        if (customer != null) {
            SavingAccount savingAccount = customer.getSavingAccount();
            if (savingAccount != null) {
                Scanner scanner = new Scanner(System.in);
                System.out.print("请输入取款金额：");
                double balance = scanner.nextDouble();
                Double accountBalance = savingAccount.getBalance();
                if (accountBalance > balance){
                    savingAccount.setBalance(accountBalance - balance);
                    System.out.println("成功取款 " + balance + " 元");
                } else System.out.println("取款失败，余额不足");
            } else {
                System.out.println("存储卡未开户！");
            }
        } else {
            System.out.println("用户未开户！请先执行功能1");
        }
    }

    /**
     * 主菜单选项4 消费
     */
    public static void consume(){
        if (customer != null) {
            CheckingAccount checkingAccount = customer.getCheckingAccount();
            if (checkingAccount != null) {
                Scanner scanner = new Scanner(System.in);
                System.out.print("请输入消费刷卡金额：");
                double consumeMoney = scanner.nextDouble();
                checkingAccount.setBalance(checkingAccount.getBalance() - consumeMoney);
                System.out.println("成功消费 " + consumeMoney + " 元");
            } else {
                System.out.println("信用卡未开户！");
            }
        } else {
            System.out.println("用户未开户！请先执行功能1");
        }
    }

    /**
     * 主菜单选项5 还款
     */
    public static void repay(){
        if (customer != null) {
            CheckingAccount checkingAccount = customer.getCheckingAccount();
            if (checkingAccount != null) {
                if (checkingAccount.getBalance() >= 0){
                    System.out.println("无需还款！");
                    return;
                }
                Scanner scanner = new Scanner(System.in);
                System.out.print("请输入还款金额：");
                double repayMoney = scanner.nextDouble();
                checkingAccount.setBalance(checkingAccount.getBalance() + repayMoney);
                System.out.println("成功还款 " + repayMoney + " 元");
            } else {
                System.out.println("信用卡未开户！");
            }
        } else {
            System.out.println("用户未开户！请先执行功能1");
        }
    }

    /**
     * 主菜单选项6 银行结算
     */
    public static void settle(){
        if (customer != null) {
            SavingAccount savingAccount = customer.getSavingAccount();
            if (savingAccount != null) {
                Double oldBalance = savingAccount.getBalance();
                double interestBalance = oldBalance * savingAccount.getInterestRate();
                savingAccount.setBalance(oldBalance + interestBalance);
                System.out.println("存储卡 " + savingAccount.getAccountNum() + " 结算已完成");
                System.out.println("根据利率 " + savingAccount.getInterestRate() + " 获得利息 " + interestBalance + " 元");
            }

            CheckingAccount checkingAccount = customer.getCheckingAccount();
            if (checkingAccount != null) {
                checkingAccount.setBalance(checkingAccount.getBalance() - checkingAccount.getServiceCharge());
                System.out.println("信用卡 " + checkingAccount.getAccountNum() + " 结算已完成");
                System.out.println("已扣除服务费 " + checkingAccount.getServiceCharge() + " 元");
            }
        } else {
            System.out.println("用户未开户！请先执行功能1");
        }
    }

    /**
     * 主菜单选项7 查询信用卡余额，存储卡余额
     */
    public static void balance(){
        if (customer != null) {
            CheckingAccount checkingAccount = customer.getCheckingAccount();
            if (checkingAccount != null) {
                System.out.println("信用卡 " + checkingAccount.getAccountNum() + " 余额：" + checkingAccount.getBalance() + " 元");
            } else {
                System.out.println("信用卡 未开户");
            }

            SavingAccount savingAccount = customer.getSavingAccount();
            if (savingAccount != null) {
                System.out.println("存储卡 " + savingAccount.getAccountNum() + " 余额：" + savingAccount.getBalance() + " 元");
            } else {
                System.out.println("存储卡 未开户");
            }
        } else {
            System.out.println("用户未开户！请先执行功能1");
        }
    }
}
