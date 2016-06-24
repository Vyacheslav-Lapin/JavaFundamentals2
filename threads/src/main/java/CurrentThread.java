public class CurrentThread {
    public static void main(String[] args) {
        Thread t = Thread.currentThread();
        System.out.println("Текущий поток: " + t);
        t.setName("My Thread");
        System.out.println("После изменения имени: " + t);
        try {
            for (int n = 5; n > 0; n--) {
                System.out.println(n);
                Thread.sleep(1_000);
            }
        } catch (InterruptedException e) {
            System.err.println("Exception: " + e);
        }
    }
}
