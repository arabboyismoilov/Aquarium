package uz.furor.enums;

import uz.furor.util.Constants;
import uz.furor.util.RandomGenerator;

public enum DirectionX {
    LEFT(-1), NONE(0), RIGHT(1);
    public int directionValue;

    DirectionX(int directionIndex){
        this.directionValue = directionIndex;
    }

    public static int getRandomXDirection(int previousX){
        // if fish near to max x axis value, it can't move right
        if (previousX == Constants.AQUARIUM_X_AXIS_MAX_VALUE){
            return values()[RandomGenerator.getRandomNumber(0, 1)].directionValue;
        }
        else if (previousX == 0){
            // if fish near to min x axis value, it can't move left
            return values()[RandomGenerator.getRandomNumber(1, 2)].directionValue;
        }
        return values()[RandomGenerator.getRandomNumber(0,2)].directionValue;
    }
}
