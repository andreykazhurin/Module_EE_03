package Module_EE_03;

/**
 * Created by Andrey on 10.06.2016.
 */
public interface Semaphore {

    // ����������� ����������. ���� ���� ��������� ����������� ���.
    // ���� ��� - ���������������� ����� �� ��� ��� ���� �� �������� ��������� ����������.

    public void acquire() throws InterruptedException;

    // ����������� ��������� ���������� ����������. ���� ���� ��������� ���������� ��������� ���������� ����������� ��.

    // ���� ��� - ���������������� ����� �� ��� ��� ���� �� �������� ��������� ���������� ��������� ����������.

    public void acquire(int permits) throws InterruptedException;

    // ��������� ���������� ��������� ��� ��������.

    public void release() throws InterruptedException;

    // ��������� ��������� ���������� ���������� ��������� �� ��������.

    public void release(int permits) throws InterruptedException;

    // ���������� ���������� ��������� ���������� �� ������ ������.

    public int getAvailablePermits();

}
