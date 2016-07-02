package com.epam.trainings.java.fundamentals.jdbc.cp;

@FunctionalInterface
public interface Wrapper<T> {
    T toSrc();
}