package ru.gb.lecture05.lecturerCode;

public class TicTac1 implements Runnable{

    private final String bracket;

    public TicTac1(String bracket) {
        this.bracket = bracket;
    }

    @Override
    public void run() {
        while (true) {
            System.out.print(bracket);
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
