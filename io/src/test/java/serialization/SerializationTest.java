package serialization;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;

import static org.junit.Assert.assertTrue;

public class SerializationTest {

    @Test(expected = java.io.NotSerializableException.class)
    public void withoutSerializable() throws Exception {
        try (OutputStream outputStream = new ByteArrayOutputStream();
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream)) {
            objectOutputStream.writeObject(new NotSerializable());
        }
    }

    @Test
    public void withSerializable() throws Exception {
        try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream)) {
            objectOutputStream.writeObject(new Ser());
            assertTrue(outputStream.toByteArray().length > 0);
        }
    }
}
class NotSerializable{}
class Ser implements Serializable {}