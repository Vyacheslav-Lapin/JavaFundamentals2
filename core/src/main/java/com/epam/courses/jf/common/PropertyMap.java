package com.epam.courses.jf.common;

import java.util.Properties;

public interface PropertyMap {
    static String getAndRemove(Properties properties, String key) {
        String property = properties.getProperty(key);
        properties.remove(key);
        return property;
    }
}