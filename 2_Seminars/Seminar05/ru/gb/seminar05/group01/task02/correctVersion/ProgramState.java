package ru.gb.seminar05.group01.task02.correctVersion;

public class ProgramState {
    private volatile boolean switcher;
    private volatile int countDown;

    public ProgramState() {
        this.countDown = 100;
    }

    public boolean isSwitcher() {
        return switcher;
    }

    public void setSwitcher(boolean switcher) {
        this.switcher = switcher;
    }

    public int getCountDown() {
        return countDown;
    }

    public void setCountDown(int countDown) {
        this.countDown = countDown;
    }


    public boolean isSwitcherTrue() {
        return switcher;
    }
}
