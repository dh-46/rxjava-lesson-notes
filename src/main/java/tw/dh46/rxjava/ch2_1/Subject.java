package tw.dh46.rxjava.ch2_1;

/**
 * 被訂閱的主題介面
 */
public interface Subject {

    /**
     * 讓觀察者註冊
     * @param observer
     */
    void registerObserver(Observer observer);

    /**
     * 讓觀察者取消註冊
     * @param observer
     */
    void removeObserver(Observer observer);

    /**
     * 當資料異動時會通知觀察者
     * @param data
     */
    void notifyObserver(String data);
}
