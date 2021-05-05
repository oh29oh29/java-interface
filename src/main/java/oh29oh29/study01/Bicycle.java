package oh29oh29.study01;

public class Bicycle implements Vehicle {
    int speed;

    @Override
    public void speedUp(int increment) {
        speed += increment;
        System.out.println("Bicycle speed up: " + increment);
    }
}
