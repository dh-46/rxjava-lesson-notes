package tw.dh46.rxjava.ch2_2;

/**
 * 設計模式--迭代器模式
 * 這裡的設計只是為了模擬設計模式的概念
 * 否則在實務上應該都是使用Java API中的iterator居多
 * 或是再行實作
 */
public interface Iterator {

    /**
     * 集合/陣列是否還有下一個
     * @return
     */
    boolean hasNext();

    /**
     * 取出
     * @return
     */
    Object next();
}
