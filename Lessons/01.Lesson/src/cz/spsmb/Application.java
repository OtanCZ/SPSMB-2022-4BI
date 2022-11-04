package cz.spsmb;

import cz.spsmb.source.LicenceServer;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Application {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        int a = 3, b = 9, c = 21;
        /*
        if(a > b) {
            if(a > c) {
                if(b > c) {
                    System.out.println(a + ", " + b + ", " + c);
                } else {
                    System.out.println(a + ", " + c + ", " + b);
                }
            } else {
                System.out.println(c + ", " + a + ", " + b);
            }
        } else {
            if(b > c) {
                if(a > c) {
                    System.out.println(b + ", " + a + ", " + c);
                } else {
                    System.out.println(b + ", " + c + ", " + a);
                }
            } else {
                System.out.println(c + ", " + b + ", " + a);
            }
        }
        */

        ProgramScanner programScanner = new ProgramScanner();
        programScanner.privateFieldScan();
        programScanner.declaredMethodScan();
        programScanner.createSingletonInstances();

        LicenceServer licenceServer = new LicenceServer();
        Method method = licenceServer.getClass().getDeclaredMethod("checkValidLicense", String.class);
        method.setAccessible(true);
        method.invoke(licenceServer, "https://google.com");
        licenceServer.startGame();
    }
}
