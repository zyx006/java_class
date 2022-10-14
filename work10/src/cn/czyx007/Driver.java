package cn.czyx007;

import cn.czyx007.DAO.StudentDAO;
import cn.czyx007.DAO.impl.StudentDAOImpl;
import cn.czyx007.bean.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Driver {
    private static StudentDAO studentDAO = new StudentDAOImpl();

    public static void main(String[] args) {
        List<Student> studentList = inputFromKeyBoard();
        System.out.println("按学生统计：");
        studentDAO.displayByStu(studentList);
        System.out.println("按课程统计：");
        studentDAO.displayByCourse(studentList);
    }

    public static List<Student> inputFromKeyBoard(){
        List<Student> studentList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String data = "";
        System.out.println("请输入学生基本信息：");
        while (!(data=scanner.nextLine()).equals("end")){
            String[] stuArray = data.split(",|，");
            studentList.add(new Student(stuArray[0], stuArray[1], stuArray[2]));
        }

        data = "";
        System.out.println("请输入学生成绩：");
        while (!(data=scanner.nextLine()).equals("end")){
            String[] courseArray = data.split(",|，");
            for (Student student : studentList) {
                if (student.getId().equals(courseArray[0])) {
                    student.setCourseScore(courseArray[1], Double.valueOf(courseArray[2]));
                }
            }
        }
        return studentList;
    }
}
