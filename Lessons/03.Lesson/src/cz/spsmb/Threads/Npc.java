package cz.spsmb.Threads;

public class Npc extends Thread {

    public static int COUNT = 0;

    @Override
    public void run() {
        for (int i = 0; i < 5000000; i++) {
            synchronized (Npc.class) {
                COUNT++;
            }
        }
    }
}
