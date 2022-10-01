import java.io.IOException;
import java.util.Scanner;

/**
 * @author : 张宇轩
 * @createTime : 2022/10/1 - 21:20
 */
public class SubjectEnrolmentDriver {
    private static SubjectEnrolment subjectEnrolment = null;

    public static void main(String[] args) throws IOException {
        while (true) {
            int opt = menu();
            switch (opt) {
                case 1:
                    createNewSubject();
                    break;
                case 2:
                    addStudent();
                    break;
                case 3:
                    printSubjectDetails();
                    break;
                case 4:
                    return;
            }
            System.out.println("按任意键继续...");
            System.in.read();
        }
    }

    /**
     * 检查菜单选项输入合法性
     * @param low 选项下界
     * @param high 选项上界
     * @return 合法选项值
     */
    public static int checkInput(int low, int high) {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) {
            int opt = scanner.nextInt();
            if (opt >= low && opt <= high) {
                return opt;
            }
            System.out.println("输入超限，请输入" + low + "-" + high + "的数字");
        } else {
            System.out.println("输入数据类型错误，请输入" + low + "-" + high + "的数字");
            scanner.next();
        }
        return -1;
    }

    public static int menu() {
        System.out.println("欢迎使用学科报名系统");
        System.out.println("1.创建新学科");
        System.out.println("2.添加学生");
        System.out.println("3.查看学科详情");
        System.out.println("4.退出");
        System.out.print(">>>请选择(1-4)：");
        int opt = -1;
        while (opt == -1) {
            opt = checkInput(1,4);
        }
        return opt;
    }

    public static void createNewSubject() {
        if (subjectEnrolment == null) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("请输入课程号：");
            String id = scanner.nextLine();
            System.out.println("请输入课程名：");
            String name = scanner.nextLine();
            System.out.println("请输入授课学期：");
            int semester = scanner.nextInt();
            System.out.println("请输入授课学年：");
            int year = scanner.nextInt();
            subjectEnrolment = new SubjectEnrolment(id, name, semester, year, 5);
        } else {
            System.out.println("课程已创建！无需重复创建");
        }
    }

    public static void addStudent() {
        if (subjectEnrolment == null){
            System.out.println("学科不存在！请先执行功能1");
            return;
        }
        if (!subjectEnrolment.isFull()) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("请输入学生学号：");
            String id = scanner.nextLine();
            System.out.println("请输入学生姓名：");
            String name = scanner.nextLine();
            subjectEnrolment.addStudent(new Student(id, name));
            System.out.println("学生添加成功！");
        } else {
            System.out.println("学生已满！无法添加更多学生");
        }
    }

    public static void printSubjectDetails() {
        if (subjectEnrolment != null) {
            System.out.println(subjectEnrolment);
        } else {
            System.out.println("学科不存在！请先执行功能1");
        }
    }


}
