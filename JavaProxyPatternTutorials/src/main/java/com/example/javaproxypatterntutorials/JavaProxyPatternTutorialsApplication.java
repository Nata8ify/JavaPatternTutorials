package com.example.javaproxypatterntutorials;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.lang.reflect.Proxy;
import java.util.UUID;

@SpringBootApplication
public class JavaProxyPatternTutorialsApplication {

//    public static void main(String[] args) {
//        SpringApplication.run(JavaProxyPatternTutorialsApplication.class, args);
//    }

    public static void main(String[] args) {
//        IEmployee iEmployee = EmployeeServiceInvocationHandler.proxyInstance(UUID.randomUUID().toString(), "NP", 25000);

        IEmployee targetEmployee = new ITEmployee();
        targetEmployee.setId(UUID.randomUUID().toString());
        targetEmployee.setName("NP");
        targetEmployee.setSalary(25000);
        EmployeeServiceInvocationHandler handler = new EmployeeServiceInvocationHandler(targetEmployee);
        IEmployee iEmployee =  (IEmployee) Proxy.newProxyInstance(ITEmployee.class.getClassLoader(), new Class[]{IEmployee.class}, handler);

        iEmployee.addSalary(5000);
        System.out.println(iEmployee.getSalary());
    }

}
