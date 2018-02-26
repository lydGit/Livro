package lyd.github.livro.base.single;

import android.support.annotation.NonNull;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author shawn
 * @date 18/2/26
 * @desription 数据库线程池单例
 */

public class DaoThreadSingle {

    private static volatile DaoThreadSingle instance;

    private static final String THREAD_NAME = "DataDao_ThreadSingle";

    /**
     * 线程池
     * <p>
     * 该模式下线程池内部只有一个线程，所有的任务都在一个线程中执行
     * ，会创建一个单线程化的线程池，它只会用唯一的工作线程来执行任务
     * ，保证所有任务按照指定顺序(FIFO, LIFO, 优先级)执行
     */
    private final ExecutorService singleThreadExecutor;

    public static DaoThreadSingle getInstance() {
        if (instance == null) {
            synchronized (DaoThreadSingle.class) {
                if (instance == null) {
                    instance = new DaoThreadSingle();
                }
            }
        }
        return instance;
    }

    public DaoThreadSingle() {
        //使用线程安全的Integer来记录当前线池已使用的条数
        final AtomicInteger threadNumber = new AtomicInteger(1);
        //设置线程名称
        ThreadFactory factory = new ThreadFactory() {
            @Override
            public Thread newThread(@NonNull Runnable r) {
                //名称＝指定名称＋当前线池已使用的条数
                Thread t = new Thread(r, THREAD_NAME + threadNumber.getAndIncrement());
                if (t.isDaemon()) {
                    t.setDaemon(true);
                }
                if (t.getPriority() != Thread.NORM_PRIORITY) {
                    t.setPriority(Thread.NORM_PRIORITY);
                }
                return t;
            }
        };
        singleThreadExecutor = new ThreadPoolExecutor(1, 1,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(), factory);
    }

    public ExecutorService getSingleThreadExecutor() {
        return singleThreadExecutor;
    }
}
