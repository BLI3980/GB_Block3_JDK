package ru.gb.seminar05.group01.task02.correctVersion;

public class ThreadA extends Thread{
    private ProgramState state;

    public ThreadA(ProgramState state) {
        this.state = state;
    }

    @Override
    public void run() {
        while (state.getCountDown() > 0) {
            try {
                state.setSwitcher(!state.isSwitcher());
                if (!state.isSwitcher()) System.out.println("Pause");
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
