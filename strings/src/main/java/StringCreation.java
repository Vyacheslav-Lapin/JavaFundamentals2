import java.io.UnsupportedEncodingException;

public class StringCreation {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String str1 = new String();

        char[] data1 = { 'a', 'b', 'c', 'd', 'e', 'f' };
        System.out.println(new String(data1, 2, 3)); // "cde"

        char[] data2 = { '\u004A', '\u0061', 'V', 'A' };
        System.out.println(new String(data2)); // "JaVA"

        byte ascii[] = { 65, 66, 67, 68, 69, 70 };
        System.out.println(new String(ascii)); // ”ABCDEF”

        byte[] data3 = { (byte) 0xE3, (byte) 0xEE };
        System.out.println(new String(data3, "CP1251"));// ”го”
        System.out.println(new String(data3, "CP866"));// ”ую”

    }
}