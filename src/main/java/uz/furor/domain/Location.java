package uz.furor.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import uz.furor.util.Constants;
import uz.furor.util.RandomGenerator;

import java.util.Objects;

@Data
@AllArgsConstructor
@ToString
public class Location {
    private int x; //x axes in coordinate system
    private int y; //y axes in coordinate system

    public Location(){
        this.x = RandomGenerator.getRandomNumber(0, Constants.AQUARIUM_X_AXIS_MAX_VALUE); // random point
        this.y = RandomGenerator.getRandomNumber(0, Constants.AQUARIUM_Y_AXIS_MAX_VALUE);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return x == location.x && y == location.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
