package ru.jdk.lecture03.task02;

// a. Есть классы Fruit -> Apple, Orange; (больше не надо)
// b. Класс Box в который можно складывать фрукты, коробки условно сортируются по типу фрукта, поэтому в одну
// коробку нельзя сложить и яблоки, и апельсины; Для хранения фруктов внутри коробки можете использовать ArrayList;
// c. Сделать метод getWeight() который высчитывает вес коробки, зная количество фруктов и вес одного фрукта
// (вес яблока — 1.0f, апельсина — 1.5f, не важно в каких единицах);
// d. Внутри класса коробки сделать метод compare, который позволяет сравнить текущую коробку с той, которую подадут
// в compare в качестве параметра, true — если их веса равны, false в противном случае(коробки с яблоками мы можем
// сравнивать с коробками с апельсинами);
// e. Написать метод, который позволяет пересыпать фрукты из текущей коробки в другую коробку(помним про сортировку
// фруктов, нельзя яблоки высыпать в коробку с апельсинами), соответственно в текущей коробке фруктов не остается,
// а в другую перекидываются объекты, которые были в этой коробке.
public class Main {
    public static void main(String[] args) {
        Box<Apple> appleBox = new Box<>();
        System.out.println(appleBox.getWeight());
        appleBox.add(new Apple());
        appleBox.add(new Apple());
        appleBox.add(new Apple());
        appleBox.add(new Apple());
        appleBox.add(new Apple());
        appleBox.add(new Apple());
        System.out.println(appleBox.getWeight());

        Box<Orange> orangeBox = new Box<>();
        System.out.println(orangeBox.getWeight());
        orangeBox.add(new Orange());
        orangeBox.add(new Orange());
        orangeBox.add(new Orange());
        orangeBox.add(new Orange());
//        orangeBox.add(new Orange());
        System.out.println(orangeBox.getWeight());

        System.out.println(appleBox.compare(orangeBox));

        Box<Apple> appleBox1 = new Box<>();
        appleBox.move(appleBox1);
        System.out.println(appleBox.getWeight());
        System.out.println(appleBox1.getWeight());
    }
}
