package ru.gb.seminar04.task04;

public class Employee {
    private String name;
    private Integer perNumber;
    private Integer phone;
    private Integer seniority;

    public Employee(String name, Integer perNumber, Integer phone, Integer seniority) {
        this.name = name;
        this.perNumber = perNumber;
        this.phone = phone;
        this.seniority = seniority;
    }

    public Employee() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPerNumber() {
        return perNumber;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public int getSeniority() {
        return seniority;
    }

    public void setSeniority(Integer seniority) {
        this.seniority = seniority;
    }

    @Override
    public String toString() {
        return  String.format("Employee name: %s; " +
                "Personnel number: %d; " +
                "Phone number : %d; " +
                "Seniority: %d.", name, perNumber,phone, seniority);
    }

}
