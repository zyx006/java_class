package bank;

/**
 * @author : 张宇轩
 * @createTime : 2022/9/28 - 9:37
 */
public class BankAccount {
    private String accountNum;
    private Double balance;

    public BankAccount(String accountNum, Double balance) {
        this.accountNum = accountNum;
        this.balance = balance;
    }

    public String getAccountNum() {
        return accountNum;
    }

    public void setAccountNum(String accountNum) {
        this.accountNum = accountNum;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "卡号：" + accountNum + "，余额：" + balance;
    }
}
