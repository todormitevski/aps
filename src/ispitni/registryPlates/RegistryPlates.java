package ispitni.registryPlates;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

class Speeder implements Comparable<Speeder>{
    String plate;
    int speed;
    String time;
    long parsedTime;

    public Speeder(String plate, int speed, String time) throws ParseException {
        this.plate = plate;
        this.speed = speed;
        this.time = time;
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        this.parsedTime = sdf.parse(time).getTime();
    }


    @Override
    public int compareTo(Speeder o) {
        return (int) (this.parsedTime - o.parsedTime);
    }
}

public class RegistryPlates {
    public static void main(String[] args) throws IOException, ParseException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Map<String,String> drivers = new HashMap<String,String>();
        br.lines()
                .limit(n)
                .forEach(line ->{
                    String[] parts = line.split("\\s+");
                    String plate = parts[0];
                    String fullName = parts[1] + " " + parts[2];
                    drivers.put(plate,fullName);
                });
        int speedLimit = Integer.parseInt(br.readLine());
        String radarInfo = br.readLine();
        String[] radarParts = radarInfo.split("\\s+");
        List<Speeder> speederList = new ArrayList<Speeder>();
        for(int i=0;i< radarParts.length;i+=3){
            String plate = radarParts[i];
            int speed = Integer.parseInt(radarParts[i+1]);
            String time = radarParts[i+2];
            if(speed > speedLimit) {
                Speeder speeder = new Speeder(plate,speed,time);
                speederList.add(speeder);
            }
        }
        speederList.stream()
                .sorted(Speeder::compareTo)
                .forEach(speeder ->
                        System.out.println(drivers.get(speeder.plate))
                );
    }
}
