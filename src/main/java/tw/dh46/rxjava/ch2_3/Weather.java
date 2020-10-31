package tw.dh46.rxjava.ch2_3;

public class Weather {

    private String location;
    private int temperature;
    private double humidity;

    public Weather(String location, int temperature, double humidity) {
        this.location = location;
        this.temperature = temperature;
        this.humidity = humidity;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    @Override
    public String toString() {
        return "location='" + location + '\'' +
                        ", temperature=" + temperature +
                        ", humidity=" + humidity +
                        '}';
    }
}
