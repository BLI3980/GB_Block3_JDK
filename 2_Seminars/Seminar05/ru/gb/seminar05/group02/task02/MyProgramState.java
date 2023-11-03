package ru.gb.seminar05.group02.task02;

/**
 * Creating a class which contains switcher and completeness indicator variables. Which will then be shared between two
 * threads.
 * Otherwise, if we create these two variables in Main and then share them between two threads via constructors, we
 * won't be using the same variables but rather use their copies.
 */
public class MyProgramState {
    // Both variables have "false" value by default as all primitive boolean variables.
    // With volatile key word these variables won't be cached by any threads.
    private volatile boolean switcher;
    private volatile boolean finish;

    public boolean isSwitcher() {
        return switcher;
    }

    public void setSwitcher(boolean switcher) {
        this.switcher = switcher;
    }

    public boolean isFinish() {
        return finish;
    }

    public void setFinish(boolean finish) {
        this.finish = finish;
    }
}
