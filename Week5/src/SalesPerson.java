/**
 * @author : 张宇轩
 * @createTime : 2022/9/28 - 9:05
 */
public class SalesPerson extends Employee{
    private Double yearlySales;

    public SalesPerson() {
    }

    public SalesPerson(String id, String name, String department, Double baseSalary, Double yearlySales) {
        super(id, name, department, baseSalary);
        this.yearlySales = yearlySales;
    }

    public Double getYearlySales() {
        return yearlySales;
    }

    public void setYearlySales(Double yearlySales) {
        this.yearlySales = yearlySales;
    }

    @Override
    public void updateSalary() {
        super.updateSalary();
        super.setBaseSalary(super.getBaseSalary()+this.yearlySales*0.1);
    }

    @Override
    public String toString() {
        return "SalesPerson{" +
                "yearlySales=" + yearlySales +
                "," + super.toString() +
                '}';
    }
}
