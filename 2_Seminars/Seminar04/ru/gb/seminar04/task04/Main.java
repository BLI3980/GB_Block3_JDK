package ru.gb.seminar04.task04;

public class Main {
    public static void main(String[] args) {
        Personnel personnel = new Personnel();
        personnel.add(new Employee("Ivan", 111, 777, 2));
        personnel.add(new Employee("Ivan", 444, 13413, 2));
        personnel.add(new Employee("Petr", 222, 888, 10));
        personnel.add(new Employee("Michael", 666, 6746, 5));
        personnel.add(new Employee("Maria", 333, 999, 5));
        personnel.add(new Employee("Jessica", 555, 555, 5));


        System.out.println("\nSearch by name: ");
//        UI.printPersonnel(personnel.findByName("John"));
        UI.printPersonnel(personnel.findByName("Ivan"));

        System.out.println("\nSearch by seniority: ");
//        UI.printPersonnel(personnel.findBySeniority(3));
        UI.printPersonnel(personnel.findBySeniority(5));

        System.out.println("\nSearch by personnel number: ");
//        UI.printPersonnel(personnel.findByPersNumber(11));
        UI.printPersonnel(personnel.findByPersNumber(555));

        System.out.println("\nSearch phone number(s) by name: ");
        UI.printPersonnel(personnel.findPhoneByName("Ivan"));

        System.out.println("\nUniversal find:");
        String searchName = "ivan";
        var result = personnel.findSomething(
                p -> p.getName().equalsIgnoreCase(searchName),
                Employee::getPhone);
        System.out.println("Phone number(s) of " + searchName + ": " + result);

        int id = 333;
        var result1 = personnel.findSomething(
                p -> p.getPerNumber() == id,
                Employee::getName);
        System.out.println("Employee name of Personal ID " + id + ": " + result1);



    }
}
