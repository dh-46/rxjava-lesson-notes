package tw.dh46.rxjava.ch4_2;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.functions.Supplier;

public class MyClass {

    private String value;

    public void setValue(String value) {
        this.value = value;
    }

    /**
     * 建立Observable
     * @return
     */
    public Observable<String> valueObservable() {
        return Observable.just(MyClass.this.value);
    }

    public Observable<String> valueDeferObservable() {
        return Observable.defer(new Supplier<ObservableSource<? extends String>>() {
            @Override
            public ObservableSource<? extends String> get() throws Throwable {
                // 回傳的介面就是Observable有實作的介面
                return Observable.just(MyClass.this.value);
            }
        });
    }
}
