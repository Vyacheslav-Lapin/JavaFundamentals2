public class InternTester {

    static String hello = "Hello";

    public static void main(String[] args) {
        String s1 = "Hello";
        String s2 = new StringBuffer("He").append("llo").toString();
        String s3 = s2.intern();

        System.out.println("s1 == s2? " + (s1 == s2)); // false
        System.out.println("s1 == s3? " + (s1 == s3)); // true

        String hello = "Hello";
        String lo = "lo";

        System.out.print((hello == "Hello") + " "); // true
        System.out.print((InternTester.hello == hello) + " "); // true
        System.out.print((otherpack.Other.hello == hello) + " "); // true
        System.out.print((hello == ("Hel" + "lo")) + " "); // true
        System.out.print((hello == ("Hel" + lo)) + " "); // false
        System.out.println(hello == ("Hel" + lo).intern()); // true
    }
}