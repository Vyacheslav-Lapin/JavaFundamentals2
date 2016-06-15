package serialization;

import org.junit.After;
import org.junit.Test;

import java.io.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class PersonSerializationTest {

    public static final String FILE_NAME = "tempdata.ser";

    @Test
    public void serializationToDisk() throws Exception {

        Person ted = new Person("Ted", "Neward", 39);
        Person charl = new Person("Charlotte", "Neward", 38);
        ted.setSpouse(charl);
        charl.setSpouse(ted);

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(ted);
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            ted = (Person) ois.readObject();
        }

        assertThat(ted.getFirstName(), is("Ted"));
        assertThat(ted.getSpouse().getFirstName(), is("Charlotte"));
    }

    @After
    public void cleanup() {
        // Clean up the file
        new File(FILE_NAME).delete();
    }
}