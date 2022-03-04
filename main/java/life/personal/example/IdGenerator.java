package life.personal.example;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;


/**
 * 1. 饿汉式：不支持延迟加载，支持高并发
 */
//public class IdGenerator {
//    private static final IdGenerator instance = new IdGenerator();
//    private AtomicLong id = new AtomicLong(0);
//
//    private IdGenerator() {
//    }
//
//    public static IdGenerator getInstance() {
//        return instance;
//    }
//
//    public long getId() {
//        return id.incrementAndGet();
////        return id.getAndAdd(1);
//    }
//}

/**
 * 2. 懒汉式，支持延迟加载，不支持高并发
 */
//public class IdGenerator {
//    private static IdGenerator instance;
//    private AtomicLong id = new AtomicLong(0);
//
//    private IdGenerator() {
//    }
//
//    public static synchronized IdGenerator getInstance() {
//        if (instance == null) {
//            instance = new IdGenerator();
//        }
//        return instance;
//    }
//
//    public long getId() {
//        return id.incrementAndGet();
//    }
//}

/**
 * 3. 双重检测：既支持延迟加载，又支持高并发，如果已存在对象，则不再重复加锁
 */
//public class IdGenerator {
//    private AtomicLong id = new AtomicLong(0);
//    private static IdGenerator instance;
//    private IdGenerator() {}
//    public static IdGenerator getInstance() {
//        if (instance == null) {
//            // 此处为类级别的锁
//            synchronized(IdGenerator.class) {
//                if (instance == null) {
//                    instance = new IdGenerator();
//                }
//            }
//        }
//        return instance;
//    }
//    public long getId() {
//        return id.incrementAndGet();
//    }
//}

/**
 * 4. 通过静态内部类实现
 */
//public class IdGenerator {
//    private AtomicLong id = new AtomicLong(0);
//    private IdGenerator(){}
//    private static class SingletonHolder{
//        private static final IdGenerator instance = new IdGenerator();
//    }
//    public static IdGenerator getInstance(){
//        return SingletonHolder.instance;
//    }
//    public long getId(){
//        return id.incrementAndGet();
//    }
//}


/**
 * 5. 利用枚举自身特性实现
 */
//public enum IdGenerator{
//    INSTANCE;
//    private AtomicLong id = new AtomicLong(0);
//    public long getId(){
//        return id.incrementAndGet();
//    }
//}

/**
 * 以上的单例都是进程唯一的单例，下面这个是线程唯一的单例
 * @author David
 */

public class IdGenerator {
    private static final ConcurrentHashMap<Long, IdGenerator> instances
            = new ConcurrentHashMap<>();
    private final AtomicLong id = new AtomicLong(0);

    private IdGenerator() {
    }

    public static IdGenerator getInstance() {
        Long currentThreadId = Thread.currentThread().getId();
        instances.putIfAbsent(currentThreadId, new IdGenerator());
        return instances.get(currentThreadId);
    }

    public long getId() {
        return id.incrementAndGet();
    }


}