public class ThreadPriorityDemo extends Thread {
    int click = 0;
    private volatile boolean running = true;

    public void stopClick() {
        running = false;
    }

    @Override
    public void run() {
        while (running) {
            click++;
        }
    }

    public static void main(String[] args) {
        Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
        ThreadPriorityDemo hi = new ThreadPriorityDemo();
        ThreadPriorityDemo lo = new ThreadPriorityDemo();

        hi.setPriority(Thread.NORM_PRIORITY + 2);
        lo.setPriority(Thread.NORM_PRIORITY - 2);

        lo.start();
        hi.start();

        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted.");
        }

        lo.stopClick();
        hi.stopClick();

        try {
            hi.join();
            lo.join();
        } catch (InterruptedException e) {
            System.out.println("InterruptedException caught");
        }
        System.out.println("Low-priority thread: " + lo.click);
        System.out.println("High-priority thread: " + hi.click);
    }
}
