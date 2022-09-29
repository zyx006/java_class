/**
 * @author : 张宇轩
 * @createTime : 2022/9/28 - 8:54
 */
public class Administrator extends Employee{
    private Double bonus;

    public Administrator(String id, String name, String department, Double baseSalary, Double bonus) {
        super(id, name, department, baseSalary);
        this.bonus = bonus;
    }

    public Double getBonus() {
        return bonus;
    }

    public void setBonus(Double bonus) {
        this.bonus = bonus;
    }

    @Override
    public void updateSalary() {
        super.updateSalary();
        super.setBaseSalary(super.getBaseSalary()+this.bonus);
    }

    @Override
    public String toString() {
        return "Administrator{" +
                "bonus=" + bonus +
                "," + super.toString() +
                '}';
    }
}
