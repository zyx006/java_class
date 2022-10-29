package work2;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Student {
    private String id;
    private String name;
    private String gender;
    private String province;
    private Date birth;
    private Double score;

    public Student() {
    }

    public Student(String id, String name, String gender, String province, Date birth, Double score) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.province = province;
        this.birth = birth;
        this.score = score;
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

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return id + "\t" + name + "\t" + gender + "\t\t" + province + "\t" +
                new SimpleDateFormat("yyyy-MM-dd").format(birth) + "\t" + score;
    }
}
