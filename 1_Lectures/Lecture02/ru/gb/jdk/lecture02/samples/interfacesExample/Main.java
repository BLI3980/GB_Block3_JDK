package ru.gb.jdk.lecture02.samples.interfacesExample;

public class Main {
    public static void main(String[] args) {
        Man man0 = new Man();
        Ox ox0 = new Ox();
        Human man1 = new Man();
        Bull ox1 = new Ox();

        Bull minos0 = new Minotaurus();
        Human minos1 = new Minotaurus();
        Minotaurus minos2 = new Minotaurus();

        Bull[] allBulls = {ox1, minos0, minos2};
        Human[] allHumans = {man1, minos2, minos1};
    }
}
