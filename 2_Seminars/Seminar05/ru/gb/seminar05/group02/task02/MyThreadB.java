package ru.gb.seminar05.group02.task02;

public class MyThreadB extends Thread{
    private MyProgramState state;

    public MyThreadB(MyProgramState state) {
        this.state = state;
    }

    @Override
    public void run() {
        int countDown = 100;
        while (!state.isFinish() && countDown > 0) {
            // Without volatile key word on switcher this thread will be using it cached value of switcher. Therefore,
            // the program won't work correctly
            if (state.isSwitcher()) {
                System.out.println(countDown--);
                try {
                    sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        state.setFinish(true);
        System.out.println("Work complete.");
    }
}
