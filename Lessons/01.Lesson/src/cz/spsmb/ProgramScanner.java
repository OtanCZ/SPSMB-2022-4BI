package cz.spsmb;

import cz.spsmb.source.DeclaredMethodList;
import cz.spsmb.source.PrivateField;
import cz.spsmb.source.Singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Hashtable;

public class ProgramScanner {
       public void privateFieldScan() throws NoSuchFieldException, IllegalAccessException {
           PrivateField privateField = new PrivateField();
           Field jdbcConnection = privateField.getClass().getDeclaredField("jdbcConnection");
           Field databasePassword = privateField.getClass().getDeclaredField("databasePassword");

           jdbcConnection.setAccessible(true);
           databasePassword.setAccessible(true);

           System.out.println(jdbcConnection.get(privateField));
           System.out.println(databasePassword.get(privateField));
       }

       public void declaredMethodScan() {
           DeclaredMethodList declaredMethodList = new DeclaredMethodList();
           for(Method method : declaredMethodList.getClass().getDeclaredMethods()) {
               System.out.println(method);
           }
       }

       public void createSingletonInstances() throws NoSuchMethodException {
           Constructor constructor = Singleton.class.getDeclaredConstructor(null);
           constructor.setAccessible(true);
            /*
           for(int i = 0; i < 10; i++) {
               try {
                   Singleton singleton = (Singleton) constructor.newInstance();
               } catch (Exception e) {
                   e.printStackTrace();
               }
           }
           */

           Singleton singleton = Singleton.getSingleton();
           Singleton singleton2 = Singleton.getSingleton();

           System.out.println(singleton);
           System.out.println(singleton2);
       }
}
