package oh29oh29.study06;

public class Bicycle implements Vehicle {
    private int speed;

    @Override
    public void speedUp(int increment) {
        this.speed += increment;
        System.out.println("Bicycle speed: " + speed);
    }
}
