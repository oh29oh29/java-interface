package oh29oh29.study03;

public class Bicycle implements Vehicle {
    private int speed;

    @Override
    public void move() {
        System.out.println("Bicycle move");
    }

    @Override
    public void speedUp(int increment) {
        speed += increment;
        System.out.println("Bicycle speed: " + speed);
    }
}
