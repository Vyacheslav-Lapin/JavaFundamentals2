package com.epam.training.java.fundamentals.threads.group;

public class GroupList {
    public static void main(String[] args) {

        ThreadGroup mainGroup = new ThreadGroup("mainGroup");

        ThreadGroup groupA = new ThreadGroup(mainGroup, "Group A");
        new Group("One", groupA);
        new Group("Two", groupA);

        ThreadGroup groupB = new ThreadGroup(mainGroup, "Group B");
        new Group("Three", groupB);
        new Group("Four", groupB);

        groupA.list();
        groupB.list();

        mainGroup.interrupt();
    }
}