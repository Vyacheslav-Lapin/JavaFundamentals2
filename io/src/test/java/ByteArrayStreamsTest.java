import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ByteArrayStreamsTest {

    @Test
    public void test() {
        byte[] bytes = {1, -1, 0};
        ByteArrayInputStream in = new ByteArrayInputStream(bytes);

        assertThat(in.read(), is(1));

        int read = in.read();
        assertThat(read, is(255));
        assertThat((byte) read, is((byte) -1));

        assertThat(in.read(), is(0));
    }

    @Test
    public void test2() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        out.write(10);
        out.write(11);

        byte[] bytes = out.toByteArray();
        assertThat(bytes[0], is((byte) 10));
        assertThat(bytes[1], is((byte) 11));

    }
}