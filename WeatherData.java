public class WeatherData {

    public String state;
    public int low;
    public int high;

    public WeatherData(String state, int low, int high) {
        this.state = state;
        this.low = low;
        this.high = high;
    }

    public int differential() {
        return Math.abs(high - low);
    }
}