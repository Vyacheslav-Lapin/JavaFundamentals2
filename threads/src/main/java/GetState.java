public class GetState implements Runnable {

    @Override
    public void run() {
        Thread.State state
                = Thread.currentThread().getState();
        System.out.println(Thread.currentThread().getName()
                + " " + state);
    }

    public static void main(String[] args) {
        Thread th1 = new Thread(new GetState());
        th1.start();
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            System.out.println(e);
        }
        Thread.State state = th1.getState();
        System.out.println(th1.getName() + " " + state);
    }
}