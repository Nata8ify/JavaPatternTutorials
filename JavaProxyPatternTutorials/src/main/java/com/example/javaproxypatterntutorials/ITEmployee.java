package com.example.javaproxypatterntutorials;

public class ITEmployee implements IEmployee {

    private String id;
    private String name;
    private double salary;

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

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public void addSalary(double amount) {
        this.salary += amount;
    }

    @Override
    public String toString() {
        return "IEmployee{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}
