package com.nuthan.SpringSecurity.Model;

import jakarta.persistence.Entity;

@Entity
public class Student {
    private int std_id;
    private String std_name;
    private double std_marks;

    public int getStd_id() {
        return std_id;
    }

    public void setStd_id(int std_id) {
        this.std_id = std_id;
    }

    public String getStd_name() {
        return std_name;
    }

    public void setStd_name(String std_name) {
        this.std_name = std_name;
    }

    public double getStd_marks() {
        return std_marks;
    }

    public void setStd_marks(double std_marks) {
        this.std_marks = std_marks;
    }

    public Student() {
        super();
    }

    public Student(int std_id, String std_name, double std_marks) {
        this.std_id = std_id;
        this.std_name = std_name;
        this.std_marks = std_marks;
    }

    @Override
    public String toString() {
        return "Student{" +
                "std_id=" + std_id +
                ", std_name='" + std_name + '\'' +
                ", std_marks=" + std_marks +
                '}';
    }
}
