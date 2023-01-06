package cz.spsmb.Semaphore;
import java.util.concurrent.Semaphore;

public class Person extends Thread {
    public static Semaphore SEMAPHORE = new Semaphore(3);
    public static Gender SEMAPHORE_GENDER;

    private Gender gender;
    public Person() {
        super();
        this.gender = Gender.values()[(int) (Math.random() * Gender.values().length)];
    }

    @Override
    public void run() {
            while(true){
                try{
                    if(gender == SEMAPHORE_GENDER || SEMAPHORE_GENDER == null || SEMAPHORE.availablePermits() == 3){
                        SEMAPHORE_GENDER = gender;
                        SEMAPHORE.acquire();
                        System.out.println("Person (" + gender.name() + ")" + this.getName() + " entered the room. There are " + SEMAPHORE.availablePermits() + " free places.");
                        Thread.sleep(3000);
                        SEMAPHORE.release();
                        System.out.println("Person (" + gender.name() + ")" + this.getName() + " left the room. There are " + SEMAPHORE.availablePermits() + " free places.");
                    } else {
                        System.out.println("Person (" + gender.name() + ")" + this.getName() + " is in playground.");
                        Thread.sleep(3000);
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
    }
}
