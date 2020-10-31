package tw.dh46.rxjava.ch2_2;

public class StringArrayIterator implements Iterator{

    private String[] stringArray;

    private int index;

    public StringArrayIterator(String[] stringArray) {
        this.stringArray = stringArray;
    }

    @Override
    public boolean hasNext() {
        return index < stringArray.length && stringArray[index] != null;
    }

    @Override
    public Object next() {

        String string = stringArray[index];

        index++;

        return string;
    }
}
