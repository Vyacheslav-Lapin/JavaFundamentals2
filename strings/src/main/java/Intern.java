public class Intern {
    public static void main(String[] args) {
        String str1 = "Hello";
        String str2 = new String("Hello");

        System.out.println(str1 == str2 ? "Equal" : "Not Equal"); // "Not Equal"
        System.out.println(str1 == (str2 = str2.intern()) ? "Equal": "Not Equal"); // "Equal"
        System.out.println(str1.equals(str2) ? "Equal": "Not Equal"); // "Equal"
    }
}