package org.educate.hibernate.dto;

public class Lecturer {
    
    private int id;
    private String name;

    public Lecturer() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Lecturer{" + "id=" + id + ", name=" + name + '}';
    }
        
}
