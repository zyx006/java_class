package cn.czyx007.DAO.impl;

import cn.czyx007.DAO.StudentDAO;
import cn.czyx007.bean.Student;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class StudentDAOImpl implements StudentDAO {
    @Override
    public double getAverageScoreByStu(Student student) {
        double sum=0;
        Map<String, Double> courseScore = student.getCourseScoreMap();
        Set<String> courses = courseScore.keySet();
        for (String cours : courses) {
            sum+=courseScore.get(cours);
        }
        return sum/courses.size();
    }

    @Override
    public double getAverageScoreByCourse(List<Student> studentList, String course) {
        double sum=0;
        int cnt=0;
        for (Student student : studentList) {
            if (student.getCourseScoreMap().containsKey(course)) {
                sum += student.getCourseScore(course);
                cnt++;
            }
        }
        return sum/cnt;
    }

    @Override
    public void displayByStu(List<Student> studentList) {
        System.out.println("学号\t姓名\t性别\t平均分");
        for (Student student : studentList) {
            System.out.print(student);
            System.out.printf("\t\t%.2f\n", getAverageScoreByStu(student));
        }
    }

    @Override
    public void displayByCourse(List<Student> studentList) {
        Set<String> courses = new HashSet<>();
        for (Student student : studentList) {
            Map<String, Double> courseScoreMap = student.getCourseScoreMap();
            Set<String> keys = courseScoreMap.keySet();
            courses.addAll(keys);
        }
        System.out.println("课程\t平均分");
        for (String cour : courses) {
            System.out.println(cour + "\t" + getAverageScoreByCourse(studentList, cour));
        }
    }
}
