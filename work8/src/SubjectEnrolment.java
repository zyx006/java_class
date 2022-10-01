import java.util.Arrays;

/**
 * @author : 张宇轩
 * @createTime : 2022/10/1 - 21:21
 */
public class SubjectEnrolment {
    private String id;
    private String name;
    private Integer semester;
    private Integer year;

    private Student[] students;
    private Integer count;

    public SubjectEnrolment() {
    }

    public SubjectEnrolment(String id, String name, Integer semester, Integer year, Integer max) {
        this.id = id;
        this.name = name;
        this.semester = semester;
        this.year = year;
        this.students = new Student[max];
        this.count = 0;
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

    public Integer getSemester() {
        return semester;
    }

    public void setSemester(Integer semester) {
        this.semester = semester;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public boolean addStudent(Student student) {
        if (students == null || isFull()) {
            return false;
        }
        students[this.count++] = student;
        return true;
    }

    public boolean isFull() {
        return students.length <= this.count;
    }

    @Override
    public String toString() {
        String info = "学科报名详情：" + "\n----------------\n" +
                      "课程号：" + id + "\n" +
                      "课程名：" + name + "\n" +
                      "授课学期：" + semester + "\n" +
                      "授课学年：" + year + "\n";
        if (count != 0) {
            info += "================\n学生详情：\n----------------\n学号：\t姓名：\n";
            for (int i = 0; i < count; i++) {
                info += students[i];
            }
        }
        return info;
    }
}
