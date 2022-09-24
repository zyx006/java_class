package lesson6.work;

import java.util.Scanner;

public class Driver {
    static ClassList classList1 = null;
    static ClassList classList2 = null;
    static int classListCount = 0;

    public static void main(String[] args) {
        while (true) {
            int opt = menu();
            switch (opt) {
                case 1:
                    if (classListCount == 0) {
                        System.out.println("创建第一张班级出勤表：");
                        classList1 = inputClassList();
                        classListCount++;
                    } else if (classListCount == 1) {
                        System.out.println("创建第二张班级出勤表：");
                        classList2 = inputClassList();
                        classListCount++;
                    } else {
                        System.out.println("已经创建了两张班级出勤表，无法创建更多");
                    }
                    break;
                case 2:
                    if (classListCount == 0) {
                        System.out.println("不存在任何班级出勤表！请先使用功能1");
                    } else {
                        System.out.println("班级出勤表1：");
                        System.out.println(classList1 + "\n");
                        if (classList2 != null) {
                            System.out.println("班级出勤表2：");
                            System.out.println(classList2);
                        }
                    }
                    break;
                default:
                    return;
            }
            System.out.println();
        }
    }

    public static int menu(){
        System.out.println("1.创建班级出勤名单");
        System.out.println("2.输出班级出勤名单");
        System.out.println("3.退出系统");
        int opt = -1;
        Scanner scanner = new Scanner(System.in);
        while (opt == -1) {
            opt = checkInput(scanner, 1, 3);
        }
        return opt;
    }

    public static Subject inputSubject() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入课程号：");
        String subjectID = scanner.nextLine();
        System.out.print("请输入课程名：");
        String subjectName = scanner.nextLine();
        return new Subject(subjectID, subjectName);
    }

    public static Student inputStudent() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入学生学号：");
        String studentID = scanner.nextLine();
        System.out.print("请输入学生的名：");
        String firstName = scanner.nextLine();
        System.out.print("请输入学生的姓：");
        String lastName = scanner.nextLine();
        return new Student(studentID, firstName, lastName);
    }

    public static ClassList inputClassList() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入学期数：");
        int semester = scanner.nextInt();
        System.out.print("请输入学年数：");
        int year = scanner.nextInt();
        System.out.println("===========\n请输入课程：");
        Subject subject = inputSubject();
        System.out.println("===========\n请输入第一个学生：");
        Student student1 = inputStudent();
        System.out.println("===========\n请输入第二个学生：");
        Student student2 = inputStudent();
        return new ClassList(semester, year, subject, student1, student2);
    }

    public static int checkInput(Scanner scanner, int low, int high) {
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
}
