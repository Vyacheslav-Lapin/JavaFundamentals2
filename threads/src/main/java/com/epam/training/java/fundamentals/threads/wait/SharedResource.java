package com.epam.training.java.fundamentals.threads.wait;

import java.util.ArrayList;
import java.util.List;

public class SharedResource {
    private List<Integer> list;

    public SharedResource() {
        list = new ArrayList<>();
    }

    public void setElement(Integer element) {
        list.add(element);
    }

    public Integer getELement() {
        return list.size() > 0 ? list.remove(0) : null;
    }

}
