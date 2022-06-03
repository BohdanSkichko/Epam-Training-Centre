package chapter5.task16park;

import javax.sound.sampled.AudioFileFormat;
import java.util.stream.Collectors;

public class Runner {
    public static void main(String[] args) {
        Park park = new Park("Hueta");
//non static Park.Attraction  attraction = park.new Attraction(130.00,"10.00 - 20.00", Park.Attraction.Type.HYDRODROME);

        Park.Attraction attraction = new Park.Attraction(150.00, "14.00 - 23.00",
                Park.Attraction.Type.GAME_MAZES);
        Park.Attraction attraction1 = new Park.Attraction(100.00, "16.00 - 24.00",
                Park.Attraction.Type.HYDRODROME);
        Park.Attraction attraction2 = new Park.Attraction(250.00, "14.00 - 23.00",
                Park.Attraction.Type.INFLATUBLE_SLIDES);
        Park.Attraction attraction3 = new Park.Attraction(250.00, "14.00 - 23.00",
                Park.Attraction.Type.PNEUMATIC_TRAMPLINE);

        park.addAttraction(attraction);
        park.addAttraction(attraction1);
        park.addAttraction(attraction2);
        park.addAttraction(attraction3);

        System.out.println(park);




    }

}
