package org.o7planning.qlsv;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "user")
public class user {
    @PrimaryKey(autoGenerate = true)

    private int id;
    private String username;
    private String address;
    private String grade;
    private String sex;
    private String chemistry;
    private String math;
    private String physical;

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getChemistry() {
        return chemistry;
    }

    public void setChemistry(String chemistry) {
        this.chemistry = chemistry;
    }

    public String getMath() {
        return math;
    }

    public void setMath(String math) {
        this.math = math;
    }

    public String getPhysical() {
        return physical;
    }

    public void setPhysical(String physical) {
        this.physical = physical;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public user(String username, String address,String sex,String grade, String math, String physical, String chemistry) {
        this.username = username;
        this.address = address;
        this.grade = grade;
        this.sex = sex;
        this.math = math;
        this.physical = physical;
        this.chemistry = chemistry;


    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
