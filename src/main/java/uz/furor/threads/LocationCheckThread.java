package uz.furor.threads;

import lombok.SneakyThrows;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import uz.furor.service.FishService;
import uz.furor.util.Constants;

/**
 * This class is thread that checks fishList in every 1s to find two fish which are in same location
 * */
public class LocationCheckThread implements Runnable{
    private static final Logger logger = LogManager.getLogger(LocationCheckThread.class);

    @SneakyThrows
    @Override
    public void run() {
        while (true){
            if (FishService.fishList.size() > Constants.MAX_FISH_AMOUNT){
                logger.info("Aquarium size is exceeded, aquarium size: {}, allowedMaxSize: {}, so all threads forced to die. LocationCheckThread has died", FishService.fishList.size(), Constants.MAX_FISH_AMOUNT);
                break;
            }

            logger.info("Checking locations...");
            FishService.checkLocations();

            // this thread checks fishList in every 1s
            Thread.sleep(1000);
        }
    }
}
