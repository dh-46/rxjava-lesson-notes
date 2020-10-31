package tw.dh46.rxjava.ch2_1;

public class WeatherObserver implements Observer {

    private String name;

    public WeatherObserver(String name) {
        this.name = name;
    }

    @Override
    public void update(String data) {
        System.out.println(name + "接收到 " + data);
    }
}
