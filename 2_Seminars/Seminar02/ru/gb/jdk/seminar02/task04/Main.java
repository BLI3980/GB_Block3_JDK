package ru.gb.jdk.seminar02.task04;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Developer dev1 = new FrontendDev();
        Developer dev2 = new BackendDev();
        FullstackDev dev3 = new FullstackDev();

        List<Developer> developers = new ArrayList<>();
        developers.add(dev1);
        developers.add(dev2);
        developers.add(dev3);


        for (Developer dev : developers) {
            if (dev instanceof FrontendDev) {
                System.out.println(dev.getClass().getSimpleName() + ": ");
                ((FrontendDev) dev).doesFront();
            } if (dev instanceof BackendDev) {
                System.out.println(dev.getClass().getSimpleName() + ": ");
                ((BackendDev) dev).doesBack();
            } else if (dev instanceof FullstackDev) {
                System.out.println(dev.getClass().getSimpleName() + ": ");
                ((FullstackDev) dev).doesBoth();
            }
        }

    }
}
