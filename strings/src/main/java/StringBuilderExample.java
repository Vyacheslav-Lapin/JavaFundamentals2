public class StringBuilderExample {
    public static void main(String[] args) {
        appendion();
        insertion();
        setCharAt();
    }

    private static void setCharAt() {
        StringBuilder sb = new StringBuilder();
        sb.append("Java tringBuilder");
        sb.setCharAt(5, 'S');
        System.out.println("StringBuilder : "+sb);
    }

    private static void insertion() {
        StringBuilder sb = new StringBuilder();
        sb.append("Java StringBuilder");
        sb.insert(5, "insert ");
        System.out.println("StringBuilder :" + sb);
    }

    private static void appendion() {
        StringBuilder sb = new StringBuilder();
        System.out.println("StringBuilder1 : " + sb.append("Java StringBuilder"));
        System.out.println("StringBuilder2 : " + sb.append(" Example"));
    }
}
