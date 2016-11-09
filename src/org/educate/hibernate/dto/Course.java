/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.educate.hibernate.dto;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author MRuser
 */
public class Course {
    private int id;
    private String title;
    
    /* Set of students for the courses */
    private Set<Student> students = new HashSet<>(0);

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }
    /*-----------------------------------------*/

    public Course() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    
}
