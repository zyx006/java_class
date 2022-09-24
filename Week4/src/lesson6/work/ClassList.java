package lesson6.work;

public class ClassList {
    private Integer semester;
    private Integer year;
    private Subject subj;
    private Student s1;
    private Student s2;

    public ClassList() {
    }

    public ClassList(Integer semester, Integer year, Subject subj, Student s1, Student s2) {
        this.semester = semester;
        this.year = year;
        this.subj = subj;
        this.s1 = s1;
        this.s2 = s2;
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

    public Subject getSubj() {
        return subj;
    }

    public void setSubj(Subject subj) {
        this.subj = subj;
    }

    public Student getS1() {
        return s1;
    }

    public void setS1(Student s1) {
        this.s1 = s1;
    }

    public Student getS2() {
        return s2;
    }

    public void setS2(Student s2) {
        this.s2 = s2;
    }

    @Override
    public String toString() {
        return year + "年第" + semester + "学期\n" +
                "================\n" +
                subj +
                "================\n" +
                "学号\t姓名\n" + s1 + "\n" + s2;
    }
}
