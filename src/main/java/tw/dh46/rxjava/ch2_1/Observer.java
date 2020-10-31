package tw.dh46.rxjava.ch2_1;

public interface Observer {

    /**
     * 發生資料異動時可被通知
     * @param data
     */
    void update(String data);
}
