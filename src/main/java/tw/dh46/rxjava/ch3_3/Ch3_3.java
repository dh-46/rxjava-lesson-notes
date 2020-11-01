package tw.dh46.rxjava.ch3_3;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Predicate;

/**
 * 在RxJava flow中加上資料操作
 */
public class Ch3_3 {

    public static void main(String[] args) {
        Observable.just(2,3,4,5,6,7,8,9)
                // 過濾資料: 大於5的資料才過
                .filter(new Predicate<Integer>() {
                    @Override
                    public boolean test(Integer integer) throws Throwable {
                        return integer > 5;
                    }
                })
                // 轉換資料: 將過濾過的資料乘與10
                // 操作子是可以一直串接下去的
                .map(new Function<Integer, Integer>() {

                    @Override
                    public Integer apply(Integer integer) throws Throwable {
                        return integer * 10;
                    }
                })
                .subscribe(new Observer<Integer>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull Integer integer) {
                        System.out.println("onNext = " + integer);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
