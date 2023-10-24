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

//        UI.printPersonnel(personnel.findSomething(
//                p -> p.getName().equals("Ivan"),
//                p -> p.getPhone()));

    }
}
