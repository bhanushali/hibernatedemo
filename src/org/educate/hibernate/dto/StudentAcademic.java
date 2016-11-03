/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.educate.hibernate.dto;

import java.io.Serializable;

/**
 *
 * @author MRuser
 */
public class StudentAcademic implements Serializable {
    private int id;   
    private Student student;
    private String rollNo;
    private int alumni;

    public StudentAcademic() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String getRollNo() {
        return rollNo;
    }

    public void setRollNo(String rollNo) {
        this.rollNo = rollNo;
    }

    public int getAlumni() {
        return alumni;
    }

    public void setAlumni(int alumni) {
        this.alumni = alumni;
    }
    
    
}
