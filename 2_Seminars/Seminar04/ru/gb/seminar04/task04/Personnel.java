package ru.gb.seminar04.task04;

import java.util.*;
import java.util.stream.Collectors;

public class Personnel {
    private Employee employee;
    private List<Employee> employeeList;

    public Personnel() {
        employeeList = new ArrayList<>();
    }

    public Personnel(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    public void add(Employee employee) {
        employeeList.add(employee);
    }

    /**
     * Method for finding a list of people by seniority.
     * @param seniority
     * @return List of employees
     */
    public List<Employee> findBySeniority(int seniority) {
        List<Employee> result = new ArrayList<>();
        // Option 1:
//        for (Employee person : employeeList) {
//            if(person.getSeniority() == seniority) {
//                result.add(person);
//            }
//        }
        // Option 2:
        result = employeeList.stream().filter(e -> e.getSeniority() == seniority).
                toList();
        if (result.size() == 0) {
            throw new RuntimeException(
                    "No employee found with specified seniority.");
        }
        return result;
    }

    /**
     * Method for finding person full information by name
     * @param name
     * @return List of employees
     */
    public List<Employee> findByName(String name) {
        List<Employee> result = new ArrayList<>();
        // Option 1:
//        for (Employee person : employeeList) {
//            if(person.getName().equals(name)) {
//                result.add(person);
//            }
//        }
        // Option 2:
        result = employeeList.stream().filter(e -> e.getName().equalsIgnoreCase(name)).
                toList();
        if (result.size() == 0) {
            throw new RuntimeException(
                    "No employee found with specified name.");
        }
        return result;

    }

    /**
     * Method for finding a phone number(s) by person name
     * @param name
     * @return
     */
    public Map<Integer, String> findPhoneByName(String name) {
        Map<Integer, String> result = new HashMap<>();
        // Option 1:
//        for (Employee person : employeeList) {
//            if(person.getName().equals(name)) {
//                result.put(person.getPhone(), person.getName());
//            }
//        }
        // Option 2:
        result = employeeList.stream().filter(e -> e.getName().equalsIgnoreCase(name)).
                collect(Collectors.toMap(Employee::getPhone, Employee::getName));
        if (result.size() == 0) {
            throw new RuntimeException(
                    "No employee found with specified name.");
        }
        return result;

    }

    /**
     * Method for finding a person by his Personnel Number
     * @param number - Pesonnel Number
     * @return List of employees
     */
    public List<Employee> findByPersNumber(int number) {
        List<Employee> result = new ArrayList<>();
        // Option 1:
//        for (Employee person : employeeList) {
//            if(person.getPerNumber() == number) {
//                result.add(person);
//            }
//        }
//        if (result.size() == 0) {
//            throw new RuntimeException(
//                    "No employee found with such personnel number.");
//        }

        // Option 2:
        try{
            Employee employee1 =
                    employeeList.stream().filter(
                            e -> e.getPerNumber() == number).findAny().get();
            result.add(employee1);
        } catch (NoSuchElementException e) {
            throw new RuntimeException("No employee found with specified seniority.");
        }
        return result;
    }

//    public <R> List<? extends R> findSomething(
//            Predicate<? super Employee> filter,
//            Function<? super Employee, ? extends R> mapper) {
//        var result = employeeList.stream().filter(filter).map(mapper).toList();
//        var result1 = new ArrayList<>();
//        for (Object o : result) {
//            result1.add((R)o);
//        }
//        return result1;
//    }

}
