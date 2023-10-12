package ru.jdk.lecture03.ex08_wildcardSymbols;

// Wildcard symbols
public class Main {
    public static void main(String[] args) {
        Tbox<Cat> catInBox = Tbox.emptyBox();
        catInBox.setValue(new Cat("Kusya"));
        printInfo(catInBox);

        Tbox<Dog> dogInBox = Tbox.emptyBox();
        dogInBox.setValue(new Dog("Vasya"));
        printInfo(dogInBox);

        Tbox<Integer> number = Tbox.emptyBox();
        number.setValue(10);
//        printInfo(number);                              // If method calls (Tbox box) then there are no bounds for the method
                                                        // It won't work if method will call (Tbox<? extends Animal>

        Cat cat = new Cat("Vasya");
        Animal animal = cat;

        Tbox<Cat> catTbox = new Tbox<>();
//        Tbox<Animal> animalTbox = catTbox;              // Incompatible types

        Tbox<? extends Cat> catTbox1 = new Tbox<>();
        Tbox<? extends Animal> animalTbox1 = catTbox1;  // Works OK

    }
    static void printInfo(Tbox<? extends Animal> animalBox) {
        System.out.println("Information about animal: " + animalBox);
    }
}
