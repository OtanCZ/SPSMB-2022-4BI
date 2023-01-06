package cz.spsmb.Threads;

public class Application {
    public static void main(String[] args) throws InterruptedException {
        /*
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.format("%s %d \n", "thread1", i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.format("%s %d \n", "thread2", i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        thread2.start();
        thread.start();
        */

        Npc npc1 = new Npc();
        Npc npc2 = new Npc();
        Npc npc3 = new Npc();

        npc1.start();
        npc2.start();
        npc3.start();

        npc1.join();
        npc2.join();
        npc3.join();

        System.out.println(Npc.COUNT);
    }
}
