package bank;

/**
 * @author : 张宇轩
 * @createTime : 2022/9/28 - 9:39
 */
public class CheckingAccount extends BankAccount{
    private Double serviceCharge;

    public CheckingAccount(String accountNum, Double balance, Double serviceCharge) {
        super(accountNum, balance);
        this.serviceCharge = serviceCharge;
    }

    public Double getServiceCharge() {
        return serviceCharge;
    }

    public void setServiceCharge(Double serviceCharge) {
        this.serviceCharge = serviceCharge;
    }

    @Override
    public String toString() {
        return super.toString() + "，服务费：" + this.serviceCharge;
    }
}
