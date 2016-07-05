package com.epam.courses.jf.common;

public interface ReflectUtils {

    static Class<?> loadClass(String classFullName) {
        return loadClass(classFullName, "Class " + classFullName + " wasn`t loaded!");
    }

    static Class<?> loadClass(String classFullName, String message) {
        try {
            return Class.forName(classFullName);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(message, e);
        }
    }


}
