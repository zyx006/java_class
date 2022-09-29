package bank;

/**
 * @author : 张宇轩
 * @createTime : 2022/9/28 - 9:44
 */
public class SavingAccount extends BankAccount{
    private Double interestRate;

    public SavingAccount(String accountNum, Double balance, Double interestRate) {
        super(accountNum, balance);
        this.interestRate = interestRate;
    }

    public Double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(Double interestRate) {
        this.interestRate = interestRate;
    }

    @Override
    public String toString() {
        return super.toString() + "，利率：" + this.interestRate;
    }
}
