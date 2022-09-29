/**
 * @author : 张宇轩
 * @createTime : 2022/9/28 - 9:08
 */
public class TestDriver {
    public static void main(String[] args) {
        Administrator administrator = new Administrator("001", "Tom", "董事会", 4000.0, 2000.0);
        SalesPerson salesPerson = new SalesPerson("002", "Lily", "销售", 5000.0, 20000.0);

        System.out.println(administrator);
        System.out.println(salesPerson);

        administrator.updateSalary();
        System.out.println(administrator.getBaseSalary());

        salesPerson.updateSalary();
        System.out.println(salesPerson.getBaseSalary());
    }
}
