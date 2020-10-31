package tw.dh46.rxjava.ch2_4;

public class Ch2_4 {

    public static void main(String[] args) {

        /**
         * 觀察Runnable的原始碼
         * 會發現上面會有FunctionalInterface
         * 且方法只有一個
         */
        Runnable runnable = new Runnable() {
            @Override
            public void run() {

            }
        };

        /**
         * Lambda只在乎input與body
         * () => 因為方法沒有Input所以為空
         * {} => body
         *
         * 如果方法有回傳且回傳只有一行
         * 可改寫成
         * (input) -> System.out.println("Lambda");
        */
        Runnable runnable1 = () -> {

        };
    }
}
