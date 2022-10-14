import java.util.Scanner;

public class Validate {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //学号，姓名，性别，手机，邮箱，固定电话
        inputStudentID();
        inputName();
        inputGender();
        inputPhoneNumber();
        inputEmail();
        inputLinePhoneNumber();
    }

    public static void inputStudentID() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("请输入学号：");
            String studentID = scanner.nextLine();
            if (isStudentID(studentID)) {
                System.out.println("格式正确！学号输入完毕");
                return;
            } else {
                System.out.println("格式错误！请重新输入");
            }
        }
    }

    public static void inputName() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("请输入姓名：");
            String name = scanner.nextLine();
            if (isName(name)) {
                System.out.println("格式正确！姓名输入完毕");
                return;
            } else {
                System.out.println("格式错误！请重新输入");
            }
        }
    }

    public static void inputGender() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("请输入性别：");
            String gender = scanner.nextLine();
            if (isGender(gender)) {
                System.out.println("格式正确！性别输入完毕");
                return;
            } else {
                System.out.println("格式错误！请重新输入");
            }
        }
    }

    public static void inputPhoneNumber() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("请输入手机号码：");
            String phoneNumber = scanner.nextLine();
            if (isPhoneNumber(phoneNumber)) {
                System.out.println("格式正确！手机号码输入完毕");
                return;
            } else {
                System.out.println("格式错误！请重新输入");
            }
        }
    }

    public static void inputEmail() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("请输入邮箱：");
            String email = scanner.nextLine();
            if (isEmail(email)) {
                System.out.println("格式正确！邮箱输入完毕");
                return;
            } else {
                System.out.println("格式错误！请重新输入");
            }
        }
    }

    public static void inputLinePhoneNumber() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("请输入固定电话：");
            String linePhoneNumber = scanner.nextLine();
            if (isLinePhoneNumber(linePhoneNumber)) {
                System.out.println("格式正确！固定电话输入完毕");
                return;
            } else {
                System.out.println("格式错误！请重新输入");
            }
        }
    }

    public static boolean isStudentID(String id) {
        return id.matches("[0-9]*");
    }

    public static boolean isName(String name) {
        return name.matches("[a-zA-Z]\\w{4,15}");
    }

    public static boolean isGender(String gender) {
        return gender.matches("[\\u7537\\u5973]");
    }

    public static boolean isPhoneNumber(String phoneNumber) {
        return phoneNumber.matches("1[358]\\d{9}");
    }

    public static boolean isEmail(String email) {
        return email.matches("\\w[-\\w.+]*@([A-Za-z\\d][-A-Za-z\\d]+\\.)+[A-Za-z]{2,14}");
    }

    public static boolean isLinePhoneNumber(String linePhoneNumber) {
        return linePhoneNumber.matches("(0\\d{2,3}\\-{0,1}){0,1}[1-9]\\d{6,7}");
    }
}
