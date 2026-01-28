package thread.sync;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public interface BankAccount {
    final Lock lock = new ReentrantLock();


}
