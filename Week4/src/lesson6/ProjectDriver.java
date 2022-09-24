package lesson6;

/**
 * @author : 张宇轩
 * @createTime : 2022/9/21 - 10:35
 */
public class ProjectDriver {
    public static void main(String[] args) {
        Employee employee1 = new Employee("123", "admin", "销售", 9500F);
        Employee employee2 = new Employee("456", "zhangsan", "销售", 9500F);

        Project project = new Project("project", 165000.0, employee1, employee2);
        System.out.println(project);
        project.updateBudget();
        System.out.println(project);

        System.out.println(project.getEmployee1().getBaseSalary());
    }
}
