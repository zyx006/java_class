package cn.czyx007.DAO;

import cn.czyx007.bean.Student;

import java.util.List;

public interface StudentDAO {
    /**
     * 获取该学生的各科课程平均分
     * @param student 某个学生
     * @return 平均分
     */
    double getAverageScoreByStu(Student student);

    /**
     * 获取有该课程的所有学生的平均分
     * @param studentList 所有学生
     * @param course 特定课程
     * @return 平均分
     */
    double getAverageScoreByCourse(List<Student> studentList, String course);

    /**
     * 显示学生所有信息
     * @param studentList 所有学生
     */
    void displayByStu(List<Student> studentList);

    /**
     * 显示各课程所有信息
     * @param studentList 所有学生
     */
    void displayByCourse(List<Student> studentList);

}
