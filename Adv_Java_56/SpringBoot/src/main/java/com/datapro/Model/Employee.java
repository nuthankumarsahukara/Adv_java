package com.datapro.Model;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Arrays;

@Entity
@Table(name = "java56sbe")
public class Employee {
    @Id
    @GeneratedValue
    private long emp_id;

    @Column(length = 20)
    private String emp_name;

    private Date emp_dob;

    @Column(length = 20)
    private String emp_dept;

    @Column(length = 20)
    private String emp_gender;

    private double emp_sal;

    @Column(length = 20)
    private String emp_email;

    private long emp_phone;

    @Lob
    private byte[] emp_photo;

    public Employee() {
        super();
    }

    public Employee(long emp_id, String emp_name, Date emp_dob, String emp_dept, String emp_gender, double emp_sal, String emp_email, long emp_phone, byte[] emp_photo) {
        this.emp_id = emp_id;
        this.emp_name = emp_name;
        this.emp_dob = emp_dob;
        this.emp_dept = emp_dept;
        this.emp_gender = emp_gender;
        this.emp_sal = emp_sal;
        this.emp_email = emp_email;
        this.emp_phone = emp_phone;
        this.emp_photo = emp_photo;
    }

    public long getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(long emp_id) {
        this.emp_id = emp_id;
    }

    public String getEmp_name() {
        return emp_name;
    }

    public void setEmp_name(String emp_name) {
        this.emp_name = emp_name;
    }

    public Date getEmp_dob() {
        return emp_dob;
    }

    public void setEmp_dob(Date emp_dob) {
        this.emp_dob = emp_dob;
    }

    public String getEmp_dept() {
        return emp_dept;
    }

    public void setEmp_dept(String emp_dept) {
        this.emp_dept = emp_dept;
    }

    public String getEmp_gender() {
        return emp_gender;
    }

    public void setEmp_gender(String emp_gender) {
        this.emp_gender = emp_gender;
    }

    public double getEmp_sal() {
        return emp_sal;
    }

    public void setEmp_sal(double emp_sal) {
        this.emp_sal = emp_sal;
    }

    public String getEmp_email() {
        return emp_email;
    }

    public void setEmp_email(String emp_email) {
        this.emp_email = emp_email;
    }

    public long getEmp_phone() {
        return emp_phone;
    }

    public void setEmp_phone(long emp_phone) {
        this.emp_phone = emp_phone;
    }

    public byte[] getEmp_photo() {
        return emp_photo;
    }

    public void setEmp_photo(byte[] emp_photo) {
        this.emp_photo = emp_photo;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "emp_id=" + emp_id +
                ", emp_name='" + emp_name + '\'' +
                ", emp_dob=" + emp_dob +
                ", emp_dept='" + emp_dept + '\'' +
                ", emp_gender='" + emp_gender + '\'' +
                ", emp_sal=" + emp_sal +
                ", emp_email='" + emp_email + '\'' +
                ", emp_phone=" + emp_phone +
                ", emp_photo=" + Arrays.toString(emp_photo) +
                '}';
    }
}
