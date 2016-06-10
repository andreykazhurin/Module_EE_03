package Module_EE_03;

/**
 * Created by Andrey on 10.06.2016.
 */
public class TestSemaphore extends Thread {

    private static SimpleSemaphore semaphore;

    public TestSemaphore(String name, SimpleSemaphore simpleSemaphore) {
        super(name);
        this.semaphore = simpleSemaphore;

    }

    public static void main(String[] args) {

        SimpleSemaphore simpleSemaphore = new SimpleSemaphore(10);

        for (int i = 0; i < 10; i++) {
            Thread t = new TestSemaphore("Thread-" + i, simpleSemaphore);
            t.start();
        }

    }

    @Override
    public void run() {
        try {
            synchronized (this) {
                System.out.println(getName() + ": before acquired available permits: " + semaphore.getAvailablePermits());
                semaphore.acquire(2);
                System.out.println(getName() + ": monitor acquired available permits: " + semaphore.getAvailablePermits());
                sleep(1);
                System.out.println(getName() + ": before release available permits: " + semaphore.getAvailablePermits());
                semaphore.release(2);
                System.out.println(getName() + ": monitor release available permits: " + semaphore.getAvailablePermits());
            }
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
