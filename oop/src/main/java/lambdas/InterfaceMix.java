package lambdas;

import java.util.Optional;

public class InterfaceMix {
    public static void main(String[] args) {
        class Котопёс implements Кот, Пёс {}
        test(new Котопёс());
    }
    static void test(Object o) {
        Optional.of((Кот & Пёс) o).ifPresent(котопёс -> {
            котопёс.мяукать();
            котопёс.лаять();
        });
    }
}

interface Кот { default void мяукать() { System.out.println("мяу!"); } }
interface Пёс { default void лаять() { System.out.println("гав!"); } }