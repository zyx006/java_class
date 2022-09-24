package lesson5.work;

/**
 * @author : 张宇轩
 * @createTime : 2022/9/21 - 9:14
 */
public class Student {
    private String name;
    private String phoneNumber;
    private String studentNumber;

    public Student(String name, String phoneNumber, String studentNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.studentNumber = studentNumber;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", studentNumber='" + studentNumber + '\'' +
                '}';
    }

    public void displayStudent(){
        System.out.println(this.toString());
    }
}
