package ru.gb.seminar05.group02.task02;

public class MyThreadA extends Thread {
    private MyProgramState state;

    public MyThreadA(MyProgramState state) {
        this.state = state;
    }

    @Override
    public void run() {
        while (!state.isFinish()) {
            // Changing the state to opposite condition
            state.setSwitcher(!state.isSwitcher());
            if (!state.isSwitcher()) {
                System.out.println("Pause");
            }
            try {
                // sleep() is called without any prefixes because current class is extending Thread. Hence,
                // this.sleep() is the same as sleep()
                sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}