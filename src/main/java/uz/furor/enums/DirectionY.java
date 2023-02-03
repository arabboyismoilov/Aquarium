package uz.furor.enums;

import uz.furor.util.Constants;
import uz.furor.util.RandomGenerator;

public enum DirectionY {
    DOWN(-1), NONE(0), UP(1);
    public int directionValue;

    DirectionY(int directionIndex){
        this.directionValue = directionIndex;
    }

    public static int getRandomYDirection(int previousY){
        // if fish near to max y axis value, it can't move up
        if (previousY == Constants.AQUARIUM_Y_AXIS_MAX_VALUE){
            return values()[RandomGenerator.getRandomNumber(0, 1)].directionValue;
        }
        // if fish near to min y axis value, it can't move down
        else if (previousY == 0){
            return values()[RandomGenerator.getRandomNumber(1, 2)].directionValue;
        }
        return values()[RandomGenerator.getRandomNumber(0,2)].directionValue;
    }
}
