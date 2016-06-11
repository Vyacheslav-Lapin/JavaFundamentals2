package generics;

import lombok.*;
import lombok.extern.java.Log;

@AllArgsConstructor
@Data //@ToString @EqualsAndHashCode @Getter @Setter @RequiredArgsConstructor
@Log
public class MyClass {
    private int anInt;
    private double aDouble;
    private String string;

    public static void main(String[] args) {
        MyClass myClass = new MyClass(1, 5.5, "Мама мыла раму.");
        System.out.println(myClass); // "MyClass(anInt=1, aDouble=5.5, string=Мама мыла раму.)"
        System.out.println(myClass.equals(new MyClass(1, 5.5, "Мама мыла раму."))); // true
        System.out.println(myClass.getString()); // "Мама мыла раму."
        myClass.setString("The quick brown fox jumps over the lazy dog");
        System.out.println(myClass.getString()); // "The quick brown fox jumps over the lazy dog"
    }
}