/**
 * @author : 张宇轩
 * @createTime : 2022/9/28 - 8:51
 */
public class Employee {
    private String id;
    private String name;
    private String department;
    private Double baseSalary;

    public Employee() {
        id = "00000";
        name="未知";
        department="销售";
        baseSalary=1000.0;
    }

    public Employee(String id, String name, String department, Double baseSalary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.baseSalary = baseSalary;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(Double baseSalary) {
        this.baseSalary = baseSalary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", baseSalary=" + baseSalary +
                '}';
    }

    public void displayEmployee(){
        System.out.println(this);
    }

    public void updateSalary(){
        this.baseSalary = this.baseSalary*1.0725;
    }
}
