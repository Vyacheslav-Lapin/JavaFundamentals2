public class Replacement {
    public static void main(String[] args) {
        String str = "Her name is Tamara. Tamana is a good girl.";
        String strReplace = "Sonia";
        String result = str.replaceFirst("Tamana", strReplace);
        System.out.println(result); // "Her name is Tamara. Sonia is a good girl."
    }
}