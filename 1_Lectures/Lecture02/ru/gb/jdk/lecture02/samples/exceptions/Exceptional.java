package ru.gb.jdk.lecture02.samples.exceptions;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Exceptional extends JFrame implements ActionListener, Thread.UncaughtExceptionHandler {
    public Exceptional() {
        Thread.setDefaultUncaughtExceptionHandler(this);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(1100, 200, 500, 300);
        JButton btn = new JButton("Push me!");
        btn.addActionListener(this);
        add(btn);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new ArrayIndexOutOfBoundsException("Bad thins happened!");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Exceptional();
            }
        });
    }

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        JOptionPane.showMessageDialog(
                null, e.getMessage(),
                "Exception!", JOptionPane.ERROR_MESSAGE
        );
    }
}
