package cz.spsmb.Semaphore;

import java.util.concurrent.Semaphore;

public class Application {
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 25; i++) {
            Person person = new Person();
            person.start();
        }
    }
}