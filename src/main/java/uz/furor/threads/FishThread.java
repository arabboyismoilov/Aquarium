package uz.furor.threads;

import lombok.SneakyThrows;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import uz.furor.domain.Fish;
import uz.furor.domain.Location;
import uz.furor.service.FishService;
import uz.furor.util.Constants;

import java.util.concurrent.TimeUnit;

public class FishThread implements Runnable{
    private final Fish fish;
    private static final Logger logger = LogManager.getLogger(FishThread.class);

    public FishThread(Fish fish){
        this.fish = fish;
    }

    @SneakyThrows
    @Override
    public void run() {
        long stopTime = System.nanoTime() + TimeUnit.SECONDS.toNanos(fish.getLifeDuration());
        logger.info("Fish started to live: {}", fish);

        while (true){
            if (stopTime < System.nanoTime()){
                logger.info("Fish's lifeDuration finished, so it has died. ID: {}", fish.getId());
                break;
            }

            if (FishService.fishList.size() > Constants.MAX_FISH_AMOUNT){
                logger.info("Aquarium size is exceeded, aquarium size: {}, allowedMaxSize: {}, so all threads forced to die. Died fish's ID: {}", FishService.fishList.size(), Constants.MAX_FISH_AMOUNT, fish.getId());
                break;
            }

            Location previousLocation = fish.getLocation();
            fish.changeLocation();
            logger.info("ID: {} Fish moved to new location. Previous location: {}  Current location: {}", fish.getId(), previousLocation.toString(),fish.getLocation());

            // fish can move to new location ion every 1s
            Thread.sleep(1000);
        }
    }
}
