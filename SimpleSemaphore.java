package Module_EE_03;

/**
 * Created by Andrey on 10.06.2016.
 */
public class SimpleSemaphore implements Semaphore{

    private int permits;
    private final Object lock = new Object();


    public SimpleSemaphore(int permits) {
        this.permits = permits;
    }

    @Override
    public void acquire() throws InterruptedException{
        synchronized (lock){
            while(this.permits == 0){
                lock.wait();
            }
            this.permits--;
        }
    }

    @Override
    public void acquire(int permits) throws InterruptedException{
        synchronized (lock){
            while(permits >= this.permits){
                lock.wait();
            }
            this.permits -= permits;
        }
    }

    @Override
    public void release() throws InterruptedException{
        synchronized (lock){
            this.permits++;
            lock.notifyAll();
        }
    }

    @Override
    public void release(int permits) throws InterruptedException{

        synchronized (lock) {
            this.permits += permits;
            lock.notifyAll();
        }
    }

    @Override
    public int getAvailablePermits() {
        return permits;
    }
}
