package uz.furor.domain;

import lombok.Data;
import lombok.ToString;
import uz.furor.enums.DirectionX;
import uz.furor.enums.DirectionY;
import uz.furor.enums.Gender;
import uz.furor.util.Constants;
import uz.furor.util.RandomGenerator;

@Data
@ToString
public class Fish{
    private int id;
    private Gender gender;
    private int lifeDuration; // in seconds
    private Location location;

    public Fish(Gender gender){
        this();
        this.gender = gender;
    }

    public Fish(){
        this.lifeDuration = RandomGenerator.getRandomNumber(Constants.MIN_LIFE_DURATION, Constants.MAX_LIFE_DURATION);
        this.location = new Location(); // random location
        this.gender = Gender.getRandomGender(); // random gender
    }

    // method moves fish randomly 1 unit left or right, 1 unit up or down
    public void changeLocation(){
        // random x axes direction, it may be left, right or none
        int x = this.location.getX() + DirectionX.getRandomXDirection(location.getX());

        // random y axes direction, it may be up, down or none
        int y = this.location.getY() + DirectionY.getRandomYDirection(location.getY());

        this.location = new Location(x, y);
    }

}
