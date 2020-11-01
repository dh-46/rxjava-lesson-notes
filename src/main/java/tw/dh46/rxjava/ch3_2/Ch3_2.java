package tw.dh46.rxjava.ch3_2;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Function;

public class Ch3_2 {
    public static void main(String[] args) {
        Observable.just("20", "RxJava", "Ch3_2")
                /**
                 * 利用map方法，試圖將原本的資料轉成Integer型態，製造Error以利觀察onError
                 * - 第一筆資料會跑成功
                 * - 但第二筆資料失敗後，整個flow就會被中斷
                 *
                 * 補充: 下方的map可以改寫成lambda格式
                 * - 格式一: .map(s -> Integer.parseInt(s))
                 * - 格式二: .map(Integer::parseInt)
                 */
                .map(new Function<String, Integer>() {
                    @Override
                    public Integer apply(String s) throws Throwable {
                        return Integer.parseInt(s);
                    }
                })
                .subscribe(new Observer<Integer>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        System.out.println("onSubscribe");
                    }

                    @Override
                    public void onNext(@NonNull Integer s) {
                        System.out.println("onNext: " + s);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        System.out.println("onError " + e);
                    }

                    @Override
                    public void onComplete() {
                        System.out.println("onComplete");
                    }
                });
    }
}
