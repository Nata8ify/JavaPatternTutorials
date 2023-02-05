package com.example.javaproxypatterntutorials;

public interface IEmployee {
    String getId();

    void setId(String id);

    String getName();

    void setName(String name);

    double getSalary();

    void setSalary(double salary);

    void addSalary(double amount);

}
