public class ConcatDemo {
    public static void main(String[] args) {
//        simpleConcat();

        complexConcat();
    }

    private static void complexConcat() {
        String s1 = null;

        try {
            s1.concat("abc");
        } catch (NullPointerException e) {
            System.err.println(e.getClass().getName()); // java.lang.NullPointerException
        }

        System.out.println(s1); // "null"

        String s2 = null;

        // concat() returns new String object only when the length of argument
        System.out.println(s2 + "abc"); // "nullabc"

        // string is > 0.
        String s3 = "Blue";
        String s4 = "Sky!";
        String s5 = s3.concat(s4);
        System.out.println(s5 == s3); // "false"

        String s6 = "abc";
        String s7 = s6.concat("");
        System.out.println(s6 == s7); // "true"
    }

    private static void simpleConcat() {
        String attention = "Внимание: ";
        String s1 = attention.concat("!!!");
        String s2 = attention + "неизвестный символ";

        System.out.println("s1 = " + s1); // s1 = Внимание: !!!
        System.out.println("s2 = " + s2); // s2 = Внимание: неизвестный символ

        String str1 = "2" + 2 + 2;
        String str2 = 2 + 2 + "2";
        String str3 = "2" + (2 + 2);

        System.out.println("str1=" + str1 + "; str2=" + str2 + "; str3=" + str3); // str1=222; str2=42; str3=24
    }


}