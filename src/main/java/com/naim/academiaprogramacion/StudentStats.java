package com.naim.academiaprogramacion;

public class StudentStats {
    private int total;// total of students
    private double average;// average of the grades
    private int passing;//people who have pass the course

    public StudentStats(int total, double average, int passing){
        this.total=total;
        this.average=average;
        this.passing=passing;
    }

    public int getTotal() {
        return total;
    }

    public double getAverage() {
        return average;
    }

    public int getPassing() {
        return passing;
    }
}

