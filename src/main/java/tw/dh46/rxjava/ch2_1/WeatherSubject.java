package tw.dh46.rxjava.ch2_1;

import java.util.ArrayList;
import java.util.List;

public class WeatherSubject implements Subject {

    /**
     * 儲存目前訂閱的觀察者
     */
    private List<Observer> observerList;

    public WeatherSubject() {
        this.observerList = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer observer) {
        // 加入到目前訂閱的名單
        observerList.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {

        // 解除已訂閱的觀察者
        int index = observerList.indexOf(observer);

        if (index >= 0) {
            observerList.remove(index);
        }
    }

    @Override
    public void notifyObserver(String data) {
        // 資料異動時通知
        for (Observer observer : observerList) {
            observer.update(data);
        }
    }
}
