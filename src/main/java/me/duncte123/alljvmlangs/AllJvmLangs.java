package me.duncte123.alljvmlangs;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Method;
import java.util.List;

public class AllJvmLangs {


    private static final List<String> classNames = List.of(
            "JavaClass",
            "GroovyClass",
            "KotlinClass",
            "ScalaClass",
            "RunRhino",
            "RunGolo",
            "clojure_namespace"
        );

    public static void main(String[] args) throws Exception {
        File file = new File("output.txt");
        FileOutputStream fis = new FileOutputStream(file);
        PrintStream out = new PrintStream(fis);

        System.setOut(out);

        System.out.println("Welcome to AllJVMLangs");
        System.out.println("Don't ask me why I made this");
        System.out.println("This file contains the output generated from all the messages in the classes");
        System.out.println();
        System.out.println();

        for (String clsn : classNames) {
            String className = "me.duncte123.alljvmlangs." + clsn;
            Class<?> cls = Class.forName(className);
            Method m = cls.getDeclaredMethod("greet");
            System.out.printf("Class: %s > ", cls.getName());
            m.invoke(null);
        }
    }

}
