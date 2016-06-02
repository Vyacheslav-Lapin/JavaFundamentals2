package javase01.t01.logic;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<MyClass> myClasses = new ArrayList<>();

        myClasses.add(new MyClass(1));
        myClasses.add(new MyClass(2));
        myClasses.add(new MyClass(5));

        myClasses.add(new Logic(1));

        List<Logic> logics = new ArrayList<>();

        myClasses.addAll(logics);
    }
}
