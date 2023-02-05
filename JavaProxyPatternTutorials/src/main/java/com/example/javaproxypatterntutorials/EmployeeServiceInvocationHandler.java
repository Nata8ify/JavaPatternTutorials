package com.example.javaproxypatterntutorials;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class EmployeeServiceInvocationHandler implements InvocationHandler {

    private IEmployee targetEmployee;

    public EmployeeServiceInvocationHandler(IEmployee targetEmployee) {
        this.targetEmployee = targetEmployee;
    }

    public static IEmployee proxyInstance(
            String id,
            String name,
            double salary
    ) {
        IEmployee targetEmployee = new ITEmployee();
        targetEmployee.setId(id);
        targetEmployee.setName(name);
        targetEmployee.setSalary(salary);
        EmployeeServiceInvocationHandler handler = new EmployeeServiceInvocationHandler(targetEmployee);
        return (IEmployee) Proxy.newProxyInstance(ITEmployee.class.getClassLoader(), new Class[]{IEmployee.class}, handler);
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object returnValue = null;

        switch (method.getName()) {
            case "addSalary":
                handlerAddSalary(method, args);
                break;
            default: returnValue = method.invoke(targetEmployee, args);
        }

        return returnValue;
    }

    private Object handlerAddSalary(Method method, Object[] args) throws InvocationTargetException, IllegalAccessException {
        double amount = (double) args[0];
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must greater than zero");
        }
        Object returnValue = method.invoke(targetEmployee, args);
        System.out.println(String.format("New salary of [%s : %s] is [%f]", targetEmployee.getId(), targetEmployee.getName(), targetEmployee.getSalary()));
        return returnValue;
    }

}
