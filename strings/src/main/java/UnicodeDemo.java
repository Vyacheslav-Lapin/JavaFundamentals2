public class UnicodeDemo {

    public static void main(String[] args) {
        oneChar();
        manyChars();
        intsAsString();
    }

    private static void oneChar() {
        char ch = '现';// Unicode code - 73b0; utf8 - E7 8E B0
        String str = "现";

        System.out.println("String size = " + str.getBytes().length); // 3
        System.out.println(ch); // 现
        System.out.println(str); // 现
    }

    private static void manyChars() {
        String str = "现已整合";
        System.out.println("Строка - " + str);
        System.out.println("Длина строки - " + str.length());
        System.out.println("Длина строки в байтах - " + str.getBytes().length);
        for (int i = 0; i < str.codePointCount(0, str.length()); i++) {
            int index = str.offsetByCodePoints(0, i);
            int code = str.codePointAt(index);
            int[] mas = {code};
            System.out.println(i + "-й символ: "
                    + Integer.toHexString(code)
                    + " " + new String(mas, 0, mas.length));
        }

    }

    private static void intsAsString() {
        int[] mas2 = { 0x3fdc, 0x4010 };
        String str2 = new String(mas2, 0, mas2.length);
        System.out.println("Строка - " + str2);
        System.out.println("Длина строки - " + str2.length());
        System.out.println("Длина строки в байтах - " + str2.getBytes().length);
    }
}