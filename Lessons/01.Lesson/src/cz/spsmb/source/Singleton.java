package cz.spsmb.source;

public class Singleton {
    private static int instanceCount;
    private static Singleton singleton;

    public static Singleton getSingleton() {
        if(singleton == null) {
            singleton = new Singleton();
        }
        return singleton;
    }

    public static int getInstanceCount() {
        return instanceCount;
    }

    private Singleton() {
        if(singleton != null) {
            throw new RuntimeException("Singleton already exists!");
        } else {
            instanceCount++;
            singleton = this;
            System.out.println("Singleton created!");
        }
    }

    public String getMessage() {
        return "Hello";
    }

}
