package uz.furor;

import uz.furor.domain.Fish;
import uz.furor.enums.Gender;
import uz.furor.service.FishService;
import uz.furor.threads.FishThread;
import uz.furor.threads.LocationCheckThread;
import uz.furor.util.Constants;

public class Main {

    public static void main(String[] args) {
        // adding initial male fish to aquarium
        for (int i = 0; i < Constants.INITIAL_MALE_FISH_AMOUNT; i++) {
            Fish fish = FishService.addNewFish(new Fish(Gender.MALE));
            Thread thread = new Thread(new FishThread(fish));
            thread.start();
        }

        // adding initial female fish to aquarium
        for (int i = 0; i < Constants.INITIAL_FEMALE_FISH_AMOUNT; i++) {
            Fish fish = FishService.addNewFish(new Fish(Gender.FEMALE));
            Thread thread = new Thread(new FishThread(fish));
            thread.start();
        }

        // this thread checks fish's location in every 0.5s and creates new fish if some conditions match
        Thread locationCheckThread = new Thread(new LocationCheckThread());
        locationCheckThread.start();
    }
}
