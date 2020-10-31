package tw.dh46.rxjava.ch2_1;

public class Main {

    public static void main(String[] args) {
        Subject weatherSubject = new WeatherSubject();

        Observer observer1 = new WeatherObserver("John");
        Observer observer2 = new WeatherObserver("Allen");
        Observer observer3 = new WeatherObserver("Trump");

        weatherSubject.registerObserver(observer1);
        weatherSubject.registerObserver(observer2);
        weatherSubject.registerObserver(observer3);

        weatherSubject.notifyObserver("Today is a sunny day in Taipei");
    }
}
