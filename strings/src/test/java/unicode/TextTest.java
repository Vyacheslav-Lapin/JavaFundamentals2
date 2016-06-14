package unicode;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TextTest {

    @Test
    public void oneCharTest() throws Exception {
        Text text = new Text('现');

        assertThat(text.toString(), is("现"));
        assertThat(text.length(), is(1));
        assertThat(text.bytesLength(), is(3));

        assertThat(text.codePointString(0), is("现"));
        assertThat(text.codePointCode(0), is(0x73b0));
        assertThat(text.codePointHexCode(0), is("73b0"));

        byte[] bytes = text.toString().getBytes();
        assertThat(bytes.length, is(3));
        assertThat(bytes[0], is((byte) 0xe7));
        assertThat(bytes[1], is((byte) 0x8e));
        assertThat(bytes[2], is((byte) 0xb0));
    }

    @Test
    public void stringTest() throws Exception {
        Text text = new Text("现已整合");
        assertThat(text.toSrc(), is("现已整合"));
        assertThat(text.length(), is(4));
        assertThat(text.bytesLength(), is(12));

        assertThat(text.codePointString(0), is("现"));
        assertThat(text.codePointCode(0), is(0x73b0));
        assertThat(text.codePointHexCode(0), is("73b0"));

        assertThat(text.codePointString(1), is("已"));
        assertThat(text.codePointCode(1), is(0x5df2));
        assertThat(text.codePointHexCode(1), is("5df2"));

        assertThat(text.codePointString(2), is("整"));
        assertThat(text.codePointCode(2), is(0x6574));
        assertThat(text.codePointHexCode(2), is("6574"));

        assertThat(text.codePointString(3), is("合"));
        assertThat(text.codePointCode(3), is(0x5408));
        assertThat(text.codePointHexCode(3), is("5408"));
    }

    @Test
    public void intsArrayTest() throws Exception {
        Text text = new Text(0x3fdc, 0x4010);
        assertThat(text.toSrc(), is("㿜䀐"));
        assertThat(text.length(), is(2));
        assertThat(text.bytesLength(), is(6));

        assertThat(text.codePointString(0), is("㿜"));
        assertThat(text.codePointCode(0), is(0x3fdc));
        assertThat(text.codePointHexCode(0), is("3fdc"));

        assertThat(text.codePointString(1), is("䀐"));
        assertThat(text.codePointCode(1), is(0x4010));
        assertThat(text.codePointHexCode(1), is("4010"));
    }
}