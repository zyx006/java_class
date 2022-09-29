package bank;

/**
 * @author : 张宇轩
 * @createTime : 2022/9/28 - 9:36
 */
public class Customer {
    private String SSN;//身份证号
    private String name;
    private CheckingAccount checkingAccount;
    private SavingAccount savingAccount;

    public Customer(String SSN, String name) {
        this.SSN = SSN;
        this.name = name;
    }

    public String getSSN() {
        return SSN;
    }

    public void setSSN(String SSN) {
        this.SSN = SSN;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CheckingAccount getCheckingAccount() {
        return checkingAccount;
    }

    public void setCheckingAccount(CheckingAccount checkingAccount) {
        this.checkingAccount = checkingAccount;
    }

    public SavingAccount getSavingAccount() {
        return savingAccount;
    }

    public void setSavingAccount(SavingAccount savingAccount) {
        this.savingAccount = savingAccount;
    }

    @Override
    public String toString() {
        String info = "身份证号：" + this.SSN + "，姓名：" + this.name + "\n";
        if (savingAccount != null) {
            info += "存储卡信息：\n" + savingAccount + "\n";
        }
        if (checkingAccount != null) {
            info += "信用卡信息：\n" + checkingAccount + "\n";
        }
        return info;
    }
}
