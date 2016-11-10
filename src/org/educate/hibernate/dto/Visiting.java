package org.educate.hibernate.dto;

public class Visiting extends Lecturer{

    private double hourlyCharges;

    public Visiting() {
    }

    public double getHourlyCharges() {
        return hourlyCharges;
    }

    public void setHourlyCharges(double hourlyCharges) {
        this.hourlyCharges = hourlyCharges;
    }    
    
}
