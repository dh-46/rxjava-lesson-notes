package tw.dh46.rxjava.ch2_3;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * Java 8 Stream練習
 */
public class Main {

    public static void main(String[] args) {
        List<Weather> dataList = new ArrayList<>();

        dataList.add(new Weather("Taipei",28,0.4));
        dataList.add(new Weather("New York",12,0.1));
        dataList.add(new Weather("Tokyo",20,0.1));

        /**
         * 傳統上去取所有陣列中的值
         * 有以下幾個方式
         * 1. for迴圈
         * 2. for each 迴圈
         * 3. 前一個段落提到的迭代器(iterator)
         */
        dataList.stream()
                .filter(new Predicate<Weather>() {
                    @Override
                    public boolean test(Weather weather) {
                        // 可自行設定條件回傳boolean
                        // 回true才會在forEach的accept中拿到
                        return weather.getLocation().equals("Taipei");
                    }
                })
                .forEach(new Consumer<Weather>() {
                    @Override
                    public void accept(Weather weather) {
                        System.out.println(weather.toString());
                    }
                });

        /**
         * Ch2_4: Java 8 Lambda
         */
        dataList.stream()
                .filter(weather -> {
                    // 可自行設定條件回傳boolean
                    // 回true才會在forEach的accept中拿到
                    return weather.getLocation().equals("Taipei");
                })
                .forEach(weather -> System.out.println(weather.toString()));

    }
}
