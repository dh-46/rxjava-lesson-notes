package tw.dh46.rxjava.ch4_2;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;

public class Ch4_2 {

    public static void main(String[] args) {
        /**
         * Defer- 延遲建立Observable的operator
         */

        MyClass myClass = new MyClass();
        // Observable<String> observable = myClass.valueObservable();
        Observable<String> observable1 = myClass.valueDeferObservable();

        /**
         * 這裡設定了字串，但是onNext印出的卻是null?
         * -> 在取得observable時，just()已取得當時的value，也就是Null，所以後續的給值不會影響到它
         * -> 所以這時候就需要使用defer()
         */
        myClass.setValue("RxJava");

//        observable.subscribe(new Observer<String>() {
//            @Override
//            public void onSubscribe(@NonNull Disposable d) {
//                System.out.println("onSubscribe");
//            }
//
//            @Override
//            public void onNext(@NonNull String s) {
//                System.out.println(s);
//            }
//
//            @Override
//            public void onError(@NonNull Throwable e) {
//                System.err.println("onError" + e);
//            }
//
//            @Override
//            public void onComplete() {
//                System.out.println("onComplete");
//            }
//        });

        observable1.subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                System.out.println("onSubscribe");
            }

            @Override
            public void onNext(@NonNull String s) {
                System.out.println(s);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                System.err.println("onError" + e);
            }

            @Override
            public void onComplete() {
                System.out.println("onComplete");
            }
        });
    }
}
