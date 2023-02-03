package uz.furor.enums;

import uz.furor.util.RandomGenerator;

public enum Gender {
    MALE, FEMALE;

    public static Gender getRandomGender(){
        return values()[RandomGenerator.getRandomNumber(0, values().length - 1)];
    }
}
