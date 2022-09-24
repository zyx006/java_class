package lesson6;

/**
 * @author : 张宇轩
 * @createTime : 2022/9/21 - 10:31
 */
public class Project {
    private String projectName;
    private Double budget;
    private Employee employee1;
    private Employee employee2;

    public Project() {
    }

    public Project(String projectName, Double budget, Employee employee1, Employee employee2) {
        this.projectName = projectName;
        this.budget = budget;
        this.employee1 = employee1;
        this.employee2 = employee2;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Double getBudget() {
        return budget;
    }

    public void setBudget(Double budget) {
        this.budget = budget;
    }

    public Employee getEmployee1() {
        return employee1;
    }

    public void setEmployee1(Employee employee1) {
        this.employee1 = employee1;
    }

    public Employee getEmployee2() {
        return employee2;
    }

    public void setEmployee2(Employee employee2) {
        this.employee2 = employee2;
    }

    public void updateBudget() {
        this.budget *= 1.2;
    }

    @Override
    public String toString() {
        return "Project{" +
                "projectName='" + projectName + '\'' +
                ", budget=" + budget +
                ", employee1=" + employee1 +
                ", employee2=" + employee2 +
                '}';
    }
}
