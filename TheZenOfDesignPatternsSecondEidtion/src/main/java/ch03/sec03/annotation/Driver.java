package ch03.sec03.annotation;

/**
 * <功能描述><br>
 *
 * @author Brilliant James Jamesmarva1993@gmail.com 2020-12-09 12:11
 **/
public class Driver implements IDriver {

    @Override
    public void drive(ICar car) {
        car.run();
    }
}
