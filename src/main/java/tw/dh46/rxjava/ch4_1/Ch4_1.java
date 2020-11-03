package tw.dh46.rxjava.ch4_1;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;

import java.util.Calendar;

public class Ch4_1 {

    public static void main(String[] args) {
        fromCreate().subscribe(new Observer<Long>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                System.out.println("onSubscribe");
            }

            @Override
            public void onNext(@NonNull Long aLong) {
                System.out.println("onNext " + aLong);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                System.out.println("onError");
            }

            @Override
            public void onComplete() {
                System.out.println("onComlete");
            }
        });
    }

    /**
     * 建立一個Observable的方法
     * 這只是範例用的方法
     *
     * @return
     */
    public static Observable<Long> fromCreate() {
        // 使用create()操作子來建立
        /**
         * create的使用時機
         * - 清楚地知道訂閱時資料派發給訂閱者的流程
         */
        return Observable.create(new ObservableOnSubscribe<Long>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<Long> emitter) throws Throwable {
                /**
                 * emitter用來發射資料
                 *
                 * 範例: 送出三次目前的時間
                 */
                for (int i = 0; i < 3; i++) {
                    // 檢查是否有被訂閱
                    if (!emitter.isDisposed()) {
                        // 送出時間
                        emitter.onNext(Calendar.getInstance().getTimeInMillis());
                    }
                }
                // 迴圈跑完
                emitter.onComplete();
            }
        });
    }
}
