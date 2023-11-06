package ru.gb.seminar05.group01.task02.myVersion;

/**
 * Создайте два потока A и B.
 * Поток A меняет значение Boolean переменной switcher с задержкой 1000 миллисекунд (true в состояние false и наоборот).
 * Поток B ожидает состояния true переменной switcher и выводит на консоль обратный отсчет от 100 с задержкой 100 миллисекунд и приостанавливает свое действие, как только поток A переключит switcher в состояние false.
 * Условием завершения работы потоков является достижение отсчета нулевой отметки.
 */
public class Main {
    public static void main(String[] args) {
        ThreadA threadA = new ThreadA();
        ThreadB threadB = new ThreadB(threadA.getSwitcher());
        threadA.setCount(threadB.getCount());
        threadA.start();
        threadB.start();
    }
}
