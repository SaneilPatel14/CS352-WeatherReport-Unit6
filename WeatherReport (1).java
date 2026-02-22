import java.util.*;
import java.io.*;

public class WeatherReport {

    private List<WeatherData> data;

    public WeatherReport() {
        data = new ArrayList<>();

        data.add(new WeatherData("Texas",50,70));
        data.add(new WeatherData("Texas",40,60));
        data.add(new WeatherData("Florida",70,85));
        data.add(new WeatherData("Florida",65,75));
        data.add(new WeatherData("Arizona",60,90));
        data.add(new WeatherData("Arizona",50,80));
        data.add(new WeatherData("Texas",30,55));
        data.add(new WeatherData("Florida",55,72));
    }

    public WeatherReport(String fileName) {
        data = new ArrayList<>();
        try {
            Scanner input = new Scanner(new File(fileName));
            input.nextLine(); 

            while(input.hasNextLine()){
                String line = input.nextLine();
                String[] parts = line.split(",");

                String state = parts[10];
                int high = Integer.parseInt(parts[5]);
                int low = Integer.parseInt(parts[6]);

                data.add(new WeatherData(state,low,high));
            }
        } catch(Exception e){
            System.out.println("File error");
        }
    }

    public List<String> computeByList() {

        List<String> result = new LinkedList<>();

        Map<String,Integer> counts = new HashMap<>();

        for(WeatherData w : data){
            if(w.differential() > 15){
                counts.put(w.state, counts.getOrDefault(w.state,0)+1);
            }
        }

        for(String key : counts.keySet()){
            result.add(key + " " + counts.get(key));
        }

        return result;
    }

    public TreeMap<String,Integer> computeByTree() {

        TreeMap<String,Integer> map = new TreeMap<>();

        for(WeatherData w : data){
            if(w.differential() > 15){
                map.put(w.state, map.getOrDefault(w.state,0)+1);
            }
        }

        return map;
    }
}