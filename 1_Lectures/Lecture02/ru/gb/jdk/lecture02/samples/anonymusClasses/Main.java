package ru.gb.jdk.lecture02.samples.anonymusClasses;

public class Main {
    public static void main(String[] args) {
        // Ways to create instances of event handlers
        // 1
        MouseAdapter m = new MouseAdapter();
        addMouseListener(m);
        // 2
        addMouseListener(new MouseAdapter());
        // 3
        MouseListener l = new MouseListener() {
            @Override
            public void mouseUp() {

            }
            @Override
            public void mouseDown() {

            }
        };
        addMouseListener(l);
        // 4
        addMouseListener(new MouseListener() {
            @Override
            public void mouseUp() {

            }
            @Override
            public void mouseDown() {

            }
        });
    }

    public interface MouseListener{
        void mouseUp();
        void mouseDown();
    }
    private static class MouseAdapter implements MouseListener {
        @Override
        public void mouseUp() {

        }
        @Override
        public void mouseDown() {

        }
    }
    private static void addMouseListener(MouseListener l) {
        l.mouseUp();
        l.mouseDown();
    }
}
