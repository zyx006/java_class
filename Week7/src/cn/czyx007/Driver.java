package cn.czyx007;

import cn.czyx007.VO.Result;
import cn.czyx007.bean.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author : 张宇轩
 * @createTime : 2022/10/12 - 10:14
 */
public class Driver {
    public static void main(String[] args) {
        List<Student> studentList = inputFromKeyBoard();
        List<Result> resultList = calculateProvince(studentList);
        display(studentList, resultList);
    }

    public static List<Student> inputFromKeyBoard(){
        List<Student> studentList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String data = "";
        while (!(data=scanner.nextLine()).equals("end")){
            String[] stuArray = data.split(",|，");
            studentList.add(new Student(stuArray[0], stuArray[1], stuArray[2], stuArray[3]));
        }
        return studentList;
    }

    public static int calculateByGender(List<Student> studentList, String gender){
        int count=0;
        for (Student student : studentList) {
            if(student.getGender().equals(gender)){
                count++;
            }
        }
        return count;
    }

    public static List<Result> calculateProvince(List<Student> studentList){
        List<Result> resultList = new ArrayList<>();
        for (Student stu : studentList) {
            String province = stu.getProvince();
            String name = stu.getName();
            int index = isProvinceExist(resultList, province);
            if (index != -1) {
                Result oldResult = resultList.get(index);
                oldResult.setCount(oldResult.getCount() + 1);
                oldResult.setNames(oldResult.getNames() + "," + name);
                resultList.set(index, oldResult);
            } else {
                resultList.add(new Result(province, 1, name));
            }
        }
        return resultList;
    }

    public static int isProvinceExist(List<Result> resultList, String province){
        int index=-1;
        for (int i = 0; i < resultList.size(); i++) {
            Result result = resultList.get(i);
            if (result.getProvince().equals(province)){
                return i;
            }
        }
        return index;
    }

    public static void display(List<Student> studentList, List<Result> resultList){
        int totalCount = studentList.size();
        int maleCount = calculateByGender(studentList, "男");
        int femaleCount = calculateByGender(studentList, "女");
        System.out.println("总人数："+totalCount);
        System.out.println("其中男："+maleCount+"人，" + maleCount*100.0f/totalCount + "%，女："+femaleCount+"人，"+femaleCount*100.0f/totalCount+"%");
        for (Result result : resultList) {
            System.out.println(result);
        }
    }
}

