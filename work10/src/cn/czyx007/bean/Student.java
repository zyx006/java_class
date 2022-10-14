package cn.czyx007.bean;

import java.util.HashMap;
import java.util.Map;

public class Student {
    private String id;
    private String name;
    private String gender;
    private Map<String, Double> courseScore;

    public Student() {
    }

    public Student(String id, String name, String gender) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        courseScore = new HashMap<>();
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Map<String, Double> getCourseScoreMap() {
        return courseScore;
    }

    public Double getCourseScore(String course) {
        return courseScore.get(course);
    }

    public void setCourseScore(String course, Double score) {
        courseScore.put(course, score);
    }

    @Override
    public String toString() {
        return id + "\t\t" + name + "\t" + gender;
    }
}
