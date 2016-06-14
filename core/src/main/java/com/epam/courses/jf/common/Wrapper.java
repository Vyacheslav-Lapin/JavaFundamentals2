package com.epam.courses.jf.common;

@FunctionalInterface
public interface Wrapper<T> {
    T toSrc();
}
