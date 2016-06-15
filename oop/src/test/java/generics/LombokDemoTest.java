package generics;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class LombokDemoTest {

    LombokDemo lombokDemo = new LombokDemo(1, 5.5, "Мама мыла раму."); // All args constructor present

    @Test
    public void gettersPresent() throws Exception {
        assertThat(lombokDemo.getAnInt(), is(1));
        assertThat(lombokDemo.getADouble(), is(5.5));
        assertThat(lombokDemo.getString(), is("Мама мыла раму."));
    }

    @Test
    public void settersPresent() throws Exception {
        lombokDemo.setAnInt(2);
        assertThat(lombokDemo.getAnInt(), is(2));

        lombokDemo.setADouble(10.9);
        assertThat(lombokDemo.getADouble(), is(10.9));

        lombokDemo.setString("The quick brown fox jumps over the lazy dog");
        assertThat(lombokDemo.getString(), is("The quick brown fox jumps over the lazy dog"));
    }

    @Test
    public void toStringPresent() throws Exception {
        assertThat(lombokDemo.toString(), is("LombokDemo(anInt=1, aDouble=5.5, string=Мама мыла раму.)"));
    }

    @Test
    public void equalsPresent() throws Exception {
        assertTrue(lombokDemo.equals(new LombokDemo(1, 5.5, "Мама мыла раму.")));
    }

    @Test
    public void logPresent() throws Exception {
        assertTrue(lombokDemo.isLogger());
    }
}