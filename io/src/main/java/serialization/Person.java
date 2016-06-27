package serialization;

import lombok.Data;

@SuppressWarnings("WeakerAccess")
@Data
public class Person implements java.io.Serializable {
    private final String firstName;
    private final String lastName;
    private final int age;
    private Person spouse;
}