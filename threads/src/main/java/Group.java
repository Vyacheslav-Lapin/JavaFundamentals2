public class Group extends Thread {

    public Group(String threadname, ThreadGroup tgOb) {
        super(tgOb, threadname);
        System.out.println("New thread: " + this);
        start();
    }

    @Override
    public void run() {
        try {
            for (int i = 5; i > 0; i--) {
                System.out.println(getName() + ": " + i);
                Thread.sleep(1_000);
            }
        } catch (Exception e) {
            System.out.println("Exception in " + getName());
        }
        System.out.println(getName() + " exiting.");
    }

    public static void main(String[] args) {
        ThreadGroup groupA = new ThreadGroup("Group A");
        new Group("One", groupA);
        new Group("Two", groupA);

        ThreadGroup groupB = new ThreadGroup("Group B");
        new Group("Three", groupB);
        new Group("Four", groupB);

        try {
            Thread.sleep(2_500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        groupA.interrupt();
    }
}