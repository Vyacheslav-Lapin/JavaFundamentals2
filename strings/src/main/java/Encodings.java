import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

public class Encodings {
    public static void main(String[] args) throws UnsupportedEncodingException {
        byte[] data3 = { (byte) 0xE3, (byte) 0xEE };
        String str = "Мама мыла раму1!";
        byte[] strCP866 = str.getBytes(Charset.forName("cp866"));
        byte[] strCP1251 = str.getBytes("cp1251");

        for (byte b : strCP866)
            System.out.print(b + " ");

        System.out.println();

        for (byte b : strCP1251)
            System.out.print(b + " ");

        System.out.println();

        System.out.println(new String(strCP866));
        System.out.println(new String(strCP866, "cp866"));
        System.out.println(new String(strCP1251));
    }
}