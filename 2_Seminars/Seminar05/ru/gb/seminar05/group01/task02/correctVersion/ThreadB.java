package ru.gb.seminar05.group01.task02.correctVersion;

public class ThreadB extends Thread{
    private ProgramState state;

    public ThreadB(ProgramState state) {
        this.state = state;
    }


    @Override
    public void run() {
        while (state.getCountDown() > 0) {
            if (state.isSwitcher()){
                System.out.println(state.getCountDown());
                state.setCountDown(state.getCountDown() - 1);
                try {
                    sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

}
