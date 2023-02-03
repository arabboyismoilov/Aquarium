package uz.furor.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import uz.furor.domain.Fish;
import uz.furor.domain.Location;
import uz.furor.threads.FishThread;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class FishService {
    public static List<Fish> fishList;
    public static int lastId;
    private static final Logger logger = LogManager.getLogger(FishService.class);

    static {
        lastId = 1;
        fishList = Collections.synchronizedList(new ArrayList<>());
    }

    public static Fish addNewFish(Fish fish){
        fish.setId(lastId++);
        fishList.add(fish);
        return fish;
    }

    // method finds some fish which is in the same location,
    // and checks their gender to decide create new fish or not
    public static void checkLocations(){
        if (fishList == null){
            return;
        }
        // mapping fish according their location
        HashMap<Location, List<Fish>> locations = new HashMap<>();

        for (int i = 0; i < fishList.size(); i++) {
            Fish fish = fishList.get(i);

            List<Fish> fishItems = locations.getOrDefault(fish.getLocation(), new ArrayList<>());
            fishItems.add(fish);

            locations.put(fish.getLocation(), fishItems);
        }

        locations.forEach((key, value) -> {
            // two fish has the same location, so inside if we create new child fish with random gender
            if (value.size() > 1){
                if (value.get(0).getGender() != value.get(1).getGender()){
                    Fish childFish = addNewFish(new Fish());
                    logger.info("New fish was born: {} because: {} and {} are in same location!", childFish, value.get(0), value.get(1));
                    Thread thread = new Thread(new FishThread(childFish));
                    thread.start();
                }
            }
        });
    }
}
