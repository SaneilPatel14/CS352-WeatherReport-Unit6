public class WeatherDriver {

    public static void main(String[] args){

        WeatherReport w1 = new WeatherReport("weather.txt");
        WeatherReport w2 = new WeatherReport("weather.txt");

        long start,end;

        start = System.currentTimeMillis();
        System.out.println(w1.computeByList());
        end = System.currentTimeMillis();
        System.out.println("List Time: " + (end-start));

        start = System.currentTimeMillis();
        System.out.println(w2.computeByTree());
        end = System.currentTimeMillis();
        System.out.println("Tree Time: " + (end-start));
    }
}