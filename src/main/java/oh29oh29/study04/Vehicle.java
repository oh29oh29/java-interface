package oh29oh29.study04;

public interface Vehicle {
    default void display() {
        System.out.println("Hello Vehicle");
    }

    void speedUp(int increment);
}
