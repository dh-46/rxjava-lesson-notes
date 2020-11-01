package tw.dh46.rxjava.ch3_1;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;

public class Ch3_1 {

    public static void main(String[] args) {

        // just 建立Observable的其中一種Operator

        Observable.just("Hello", "RxJava")
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        // 註冊時呼叫
                        /**
                         * - 註冊時呼叫
                         * - Disposable 參數
                         *   - 用在Observer解除訂閱時用
                         *   - 解除訂閱: disposable.dispose();
                         */
                        System.out.println("onSubscribe");
                    }

                    @Override
                    public void onNext(@NonNull String s) {
                        /**
                         * - 與迭代器的onNext()類似
                         * - 印出每筆資料
                         */
                        System.out.println("onNext: " + s);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        /**
                         * - 元素中走訪/操作中出例外會呼叫
                         * - 當發生錯誤時就會停止整個flow
                         */
                        System.out.println("onError");
                    }

                    @Override
                    public void onComplete() {
                        /**
                         * 所有流程都完成後會執行這裡
                         *  - 元素都走訪完成也做完操作
                         *  - onComplete與onError只會擇一被執行
                         */
                        System.out.println("onComplete");
                    }
                });
    }
}
