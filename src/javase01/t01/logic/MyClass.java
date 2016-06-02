package javase01.t01.logic;

import java.util.Objects;

public class MyClass {

    private int anInt;

    public MyClass(int anInt) {
        this.anInt = anInt;
    }

    public int getAnInt() {
        return anInt;
    }

    public void setAnInt(int anInt) {
        this.anInt = anInt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyClass myClass = (MyClass) o;
        return anInt == myClass.anInt;
    }

    @Override
    public int hashCode() {
        return Objects.hash(anInt);
    }

    @Override
    public String toString() {
        return "MyClass{" + "anInt=" + anInt + '}';
    }
}
