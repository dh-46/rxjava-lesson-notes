package tw.dh46.rxjava.ch2_2;

public class Main {

    public static void main(String[] args) {
        String[] data = new String[]{
                "A","B","C"
        };

        Iterator arrayIterator = new StringArrayIterator(data);

        while (arrayIterator.hasNext()) {
            System.out.println(arrayIterator.next());
        }
    }
}
